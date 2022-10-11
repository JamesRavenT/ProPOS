package com.wabizabi.wazabipos.Modules.M01_SplashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.wabizabi.wazabipos.Database.DB;

import com.wabizabi.wazabipos.Modules.M02_UserVerification.M02A01_UserVerification;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Testing.TestData;

import io.realm.Realm;

public class M01A01_SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act01_splashscreen);
        setContentOrientation();
    }
    private void setContentOrientation(){
        int screenLayoutSize = getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
        if (screenLayoutSize == Configuration.SCREENLAYOUT_SIZE_SMALL || screenLayoutSize == Configuration.SCREENLAYOUT_SIZE_NORMAL) {
            setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            setPortraitFunctionalities();
        } else {
            setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            setLandscapeFunctionalites();
        }
    }
    private void setPortraitFunctionalities(){
        initDB();
        loadTestData();
        loadNextModule();
    }
    private void setLandscapeFunctionalites(){
        initDB();
        loadTestData();
        loadNextModule();
    }
    private void initDB(){
        Realm.init(this);
        DB.init();
    }
    private void loadTestData(){
        TestData.preloadProducts();
        TestData.preloadTransactions();
    }
    private void loadNextModule(){
        Handler splashScreen = new Handler();
        splashScreen.postDelayed(()->{
            startActivity(new Intent(this, M02A01_UserVerification.class));
        }, 3000);
    }
}