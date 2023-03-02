package com.wabizabi.wazabipos.Modules.M03_LoadResources;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.wabizabi.wazabipos.Database.DB;
import com.wabizabi.wazabipos.Database.Instances.OpenUserInstance;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmUser;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.M04_Main;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.BackgroundThreads.WorkOrders;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.LogHelper;
import com.wabizabi.wazabipos.Utilities.Testing.TestData;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.realm.Realm;

public class M03_LoadResources extends AppCompatActivity {
    TextView loading;
    Handler zero, one, two, three;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act03_loadresources);
        init_Functionalities();
    }
    private void init_Functionalities() {
        loading = findViewById(R.id.M03A01_LoadingText);
        initBackgroundResources();
    }
    private void initBackgroundResources(){
        zero = new Handler();
        one = new Handler();
        two = new Handler();
        three = new Handler();
        boolean networkIsAvailable = checkIfNetworkIsAvailable();
        if(networkIsAvailable){
            checkLastDataSync();
            boolean dailySyncLimitIsReached = checkIfDailySyncLimitIsReached();
            if(!dailySyncLimitIsReached){
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
        } else {
            zero.postDelayed(()->{ loading.setText("L O A D I N G ."); WorkOrders.startAlgorithm(this);
                one.postDelayed(()->{ loading.setText("L O A D I N G . .");
                    two.postDelayed(()->{ loading.setText("C O M P L E T E!");
                        three.postDelayed(()->{ WorkOrders.storeFPData(this); startActivity(new Intent(this, M04_Main.class)); finish();
                        },1000);
                    },500);
                },500);
            }, 500);
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
                    zero.postDelayed(()->{ loading.setText("L O A D I N G ."); WorkOrders.startAlgorithm(this);
                        one.postDelayed(()->{ loading.setText("L O A D I N G . .");
                            two.postDelayed(()->{ loading.setText("C O M P L E T E!");
                                three.postDelayed(()->{ WorkOrders.storeFPData(this); startActivity(new Intent(this, M04_Main.class)); finish();
                                },1000);
                            },1000);
                        },1000);
                    }, 1000);
                    return;
                }
        }, 1000);
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
}