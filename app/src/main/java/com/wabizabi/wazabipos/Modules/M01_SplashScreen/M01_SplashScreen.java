package com.wabizabi.wazabipos.Modules.M01_SplashScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import com.wabizabi.wazabipos.Database.DB;

import com.wabizabi.wazabipos.Modules.M02_UserVerification.M02_UserVerification;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.LogCat;
import com.wabizabi.wazabipos.Utilities.Testing.TestData;

import io.realm.Realm;

public class M01_SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act01_splashscreen);
        init_Functionalities();
    }

    private void init_Functionalities(){
        init_DB();
        load_TestData();
        load_NextModule();
    }
    private void init_DB(){
        Realm.init(this);
        DB.init();
    }
    private void load_TestData(){
//        TestData.preloadProducts();
        TestData.preloadTransactions();
//        TestData.preloadDiscounts();
//        TestData.preloadTables();
    }
    private void load_NextModule(){
        Handler splashScreen = new Handler();
        splashScreen.postDelayed(()->{
            startActivity(new Intent(this, M02_UserVerification.class));
            finish();
        }, 3000);
    }
}