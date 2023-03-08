package com.wabizabi.wazabipos.Modules.M03_LoadResources;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.wabizabi.wazabipos.Database.DB;
import com.wabizabi.wazabipos.Database.Instances.OpenPaymentMethodInstance;
import com.wabizabi.wazabipos.Database.Instances.OpenTableInstance;
import com.wabizabi.wazabipos.Database.Instances.OpenUserInstance;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmPaymentMethod;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmTable;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmUser;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.M04_Main;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.BackgroundThreads.WorkOrders;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.LogHelper;
import com.wabizabi.wazabipos.Utilities.Testing.TestData;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.realm.Realm;
import io.realm.RealmResults;

public class M03_LoadResources extends AppCompatActivity {
    Realm realm = Realm.getDefaultInstance();
    TextView loading, state;
    Handler zero, one, two, three, intervalOne, intervalTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act03_loadresources);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init_Functionalities();
    }
    private void init_Functionalities() {
        loading = findViewById(R.id.M03A01_LoadingText);
        state = findViewById(R.id.M03A01_StateText);
        initBackgroundResources();
    }
    private void initBackgroundResources(){
        zero = new Handler();
        one = new Handler();
        two = new Handler();
        three = new Handler();
        intervalOne = new Handler();
        intervalTwo = new Handler();
        loading.setText("L O A D I N G");
        state.setText("Establishing Connection To Cloud [1/5]");
        boolean networkIsAvailable = checkIfNetworkIsAvailable();
        if(networkIsAvailable){
            checkLastDataSync();
            boolean dailySyncLimitIsReached = checkIfDailySyncLimitIsReached();
            intervalOne.postDelayed(() -> { state.setText("Connection Established, Checking User Data [2/5]");
                intervalTwo.postDelayed(() -> {
                    if(!dailySyncLimitIsReached){
                        state.setText("Syncing User Data [3/5]");
                        int amountOfLocalTransactions = OpenUserInstance.fetchLocalSalesCount();
                        int amountOfTotalTransactions = OpenUserInstance.fetchCloudSalesCount();
                        int amountOfSyncedTransactions = OpenUserInstance.fetchSalesLimit();
                        int remainingSyncableDocuments = 5000 - amountOfSyncedTransactions;
                        int sumOfSyncedDocuments  = amountOfLocalTransactions + remainingSyncableDocuments;
                        int limit = (sumOfSyncedDocuments > amountOfTotalTransactions)
                                ? amountOfTotalTransactions - amountOfLocalTransactions
                                : 5000;
                        DB.fetchDataFromTheCloud();
                        checkIfTransmissionIsComplete(limit);
                    }
                }, 500);
            }, 500);
        } else {
            state.setText("Failure to Connect, Device is Offline [3/5]");
            zero.postDelayed(()->{ loading.setText("L O A D I N G ."); state.setText("Initializing System [4/5]");
                one.postDelayed(()->{ loading.setText("L O A D I N G . ."); WorkOrders.startAlgorithm(this);
                    two.postDelayed(()->{ loading.setText("W E L C O M E !"); loadDefaultVariables(); state.setText("Complete [5/5]");
                        three.postDelayed(()->{ WorkOrders.storeFPData(this); startActivity(new Intent(this, M04_Main.class)); finish();
                        },500);
                    },1000);
                },1000);
            }, 1000);
        }
    }

    private void checkIfTransmissionIsComplete(int limit){
        zero = new Handler();
        one = new Handler();
        two = new Handler();
        three = new Handler();
        int a = OpenUserInstance.fetchLocalSalesCount();
        int b = OpenUserInstance.fetchCloudSalesCount();
        int c = OpenUserInstance.fetchSalesLimit();
        LogHelper.debug(String.valueOf(limit));
        LogHelper.debug(a + " " + b + " " + c);
        zero.postDelayed(() -> { loading.setText("L O A D I N G .");
        one.postDelayed(() -> { loading.setText("L O A D I N G . .");
        two.postDelayed(() -> { loading.setText("L O A D I N G . . .");
        three.postDelayed(() -> {
                if (a < limit) {
                    (new Handler()).postDelayed(() -> checkIfTransmissionIsComplete(limit),500);
                } else {
                    zero.postDelayed(()->{ loading.setText("L O A D I N G ."); state.setText("Initializing System");
                        one.postDelayed(()->{ loading.setText("L O A D I N G . ."); WorkOrders.startAlgorithm(this);
                            two.postDelayed(()->{ loading.setText("W E L C O M E !"); loadDefaultVariables(); state.setText("Complete [5/5]");
                                three.postDelayed(()->{ WorkOrders.storeFPData(this); startActivity(new Intent(this, M04_Main.class)); finish();
                                },500);
                            },1000);
                        },1000);
                    }, 1000);
                    return;
                }
        }, 500);
        }, 1000);
        }, 1000);
        }, 1000);
        return;
    }

    private void checkLastDataSync(){
        String currentDate = new SimpleDateFormat("DDD").format(new Date());
        try(Realm realm = Realm.getDefaultInstance()){
            RealmUser user = realm.where(RealmUser.class).findFirst();
            String date = user.getDateOfLastSync();
            if(!date.equals(currentDate)){
                OpenUserInstance.toUpdateSyncDate();
            }
        }
        DB.fetchTransactionCountFromCloud();
    }

    private void loadDefaultVariables(){
        RealmResults<RealmPaymentMethod> pmQuery = realm.where(RealmPaymentMethod.class).findAll();
        RealmResults<RealmTable> tbQuery = realm.where(RealmTable.class).findAll();
        if(tbQuery.isEmpty()){
            OpenTableInstance.toCreateTable("Table");
        }

        if(pmQuery.isEmpty()){
            OpenPaymentMethodInstance.toCreateMethod("Cash");
        }
    }
    private boolean checkIfDailySyncLimitIsReached(){
        boolean limitReached = false;
        try(Realm realm = Realm.getDefaultInstance()) {
            RealmUser user = realm.where(RealmUser.class).findFirst();
            user.getDailySalesSyncCounter();
            user.getDailyInvSyncCounter();
            if(user.getDailyInvSyncCounter() == 5000 && user.getDailySalesSyncCounter() == 5000){
                limitReached = true;
            }
        }
        return limitReached;
    }

    private boolean checkIfNetworkIsAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    protected void attachBaseContext(final Context baseContext) {

        Context newContext;

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

            DisplayMetrics displayMetrics = baseContext.getResources().getDisplayMetrics();
            Configuration configuration = baseContext.getResources().getConfiguration();

            if (displayMetrics.densityDpi != DisplayMetrics.DENSITY_DEVICE_STABLE) {
                // Current density is different from Default Density. Override it
                configuration.densityDpi = DisplayMetrics.DENSITY_DEVICE_STABLE;
                newContext = baseContext.createConfigurationContext(configuration);
            } else {
                // Same density. Just use same context
                newContext = baseContext;
            }
        } else {
            // Old API. Screen zoom not supported
            newContext = baseContext;
        }
        super.attachBaseContext(newContext);
    }
}