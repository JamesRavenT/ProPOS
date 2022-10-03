package com.wabizabi.wazabipos.Modules.M01_SplashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;

import com.wabizabi.wazabipos.Database.DB;

import com.wabizabi.wazabipos.Modules.M02_UserVerification.Activity_UserVerification;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Testing.TestData;

import io.realm.Realm;

public class Activity_SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setScreenOrientation();
        setActivityContents();
    }
    private void setScreenOrientation(){
        int screenLayoutSize = getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
        if (screenLayoutSize == Configuration.SCREENLAYOUT_SIZE_SMALL || screenLayoutSize == Configuration.SCREENLAYOUT_SIZE_NORMAL) {
            setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            setContentView(R.layout.act01_splashscreen);
        } else {
            setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            setContentView(R.layout.act01_splashscreen);
        }
    }
    private void setActivityContents(){
        initDB();
        initTestData();
        initSplashScreen();
    }
    private void initDB(){
        Realm.init(this);
        DB.init();
    }
    private void initTestData(){
        TestData.preloadProducts();
        TestData.preloadTransactions();
    }
    private void initSplashScreen(){
        Handler splashScreen = new Handler();
        splashScreen.postDelayed(()->{
            startActivity(new Intent(this, Activity_UserVerification.class));
        }, 5000);
    }

}