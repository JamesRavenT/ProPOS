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
import com.wabizabi.wazabipos.Modules.M04_MainActivity.M04_Main;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.BackgroundThreads.WorkOrders;
import com.wabizabi.wazabipos.Utilities.Testing.TestData;

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
        boolean checkComplete = checkForData();
        if(checkComplete){
//            TestData.preloadProducts();
//            TestData.preloadTransactions();
            zero.postDelayed(()->{ loading.setText("L O A D I N G .");
                one.postDelayed(()->{ loading.setText("L O A D I N G . .");
                    two.postDelayed(()->{ loading.setText("L O A D I N G . . ."); WorkOrders.startAlgorithm(this);
                        three.postDelayed(()->{ WorkOrders.storeFPData(this); startActivity(new Intent(this, M04_Main.class)); finish();
                        },1000);
                    },1000);
                },1000);
            }, 1000);
        }
    }

    private boolean checkForData(){
        boolean isFinished = false;
        boolean connectionExists = checkIfNetworkIsAvailable();
        if(connectionExists){
            DB.fetchDataFromTheCloud();
            isFinished = true;
        }
        return isFinished;
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