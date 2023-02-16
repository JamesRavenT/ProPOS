package com.wabizabi.wazabipos.Modules.M01_SplashScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.wabizabi.wazabipos.Database.DB;

import com.wabizabi.wazabipos.Database.RealmSchemas.RealmUser;
import com.wabizabi.wazabipos.Modules.M02_UserVerification.M02_UserVerification;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.DialogHelper;
import com.wabizabi.wazabipos.Utilities.Testing.TestData;

import io.realm.DynamicRealm;
import io.realm.Realm;

public class M01_SplashScreen extends AppCompatActivity {
    //--DG01--//
    Dialog scDG01;
    CardView scDG01_retryBtn;
    ImageView scDG01_closeDGBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act01_splashscreen);
        init_Functionalities();
    }

    private void init_Functionalities(){
        init_DB();
        init_Dialog();
        load_TestData();
        verify_User();
//        load_NextModule();
    }
    private void init_DB(){
        Realm.init(this);
        DB.init();
    }

    private void init_Dialog(){
        scDG01 = DialogHelper.create(this, R.layout.act01_splashscreen_dg01_internet);
        scDG01_retryBtn = scDG01.findViewById(R.id.M01D01_RetryBtn);
        scDG01_closeDGBtn = scDG01.findViewById(R.id.M01D01_CloseDGBtn);
    }

    private void load_DialogFunctionalities(){
        scDG01_retryBtn.setOnClickListener(retry -> {
            scDG01.dismiss();
            verify_User();
        });
        scDG01_closeDGBtn.setOnClickListener(close -> {
            scDG01.dismiss();
            verify_User();
        });
    }

    private void verify_User(){
        Realm realm = Realm.getDefaultInstance();
        RealmUser user = realm.where(RealmUser.class).findFirst();
        if(user == null){
            boolean connectionExists = checkIfNetworkIsAvailable();
            if(connectionExists){
                DB.checkForUser();
                load_NextModule();
            } else {
                load_DialogFunctionalities();
                scDG01.show();
            }
        } else {
            load_NextModule();
        }
    }
    private void load_TestData(){
        TestData.preloadTransactions();
//        TestData.preloadProducts();
    }
    private void load_NextModule(){
        Handler splashScreen = new Handler();
        splashScreen.postDelayed(()->{
            startActivity(new Intent(this, M02_UserVerification.class));
            finish();
        }, 3000);
    }

    private boolean checkIfNetworkIsAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}