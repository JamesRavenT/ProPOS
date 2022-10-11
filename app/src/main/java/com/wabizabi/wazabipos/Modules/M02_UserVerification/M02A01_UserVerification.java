package com.wabizabi.wazabipos.Modules.M02_UserVerification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

import com.wabizabi.wazabipos.Database.Schemas.UserProfile;
import com.wabizabi.wazabipos.Modules.M02_UserVerification.Fragments.M02F01_UserSignIn;
import com.wabizabi.wazabipos.Modules.M02_UserVerification.Fragments.M02F02_UserLogIn;
import com.wabizabi.wazabipos.R;

import io.realm.Realm;
import io.realm.RealmResults;

public class M02A01_UserVerification extends AppCompatActivity {

    M02F01_UserSignIn signIn = new M02F01_UserSignIn();
    M02F02_UserLogIn logIn = new M02F02_UserLogIn();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act02_userverification);
        setContentOrientation();
    }

    private void setContentOrientation(){
        int screenLayoutSize = getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
        if (screenLayoutSize == Configuration.SCREENLAYOUT_SIZE_SMALL || screenLayoutSize == Configuration.SCREENLAYOUT_SIZE_NORMAL) {
            setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            setPortraitFunctionalities();
        } else {
            setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            setLandsacpeFunctionalities();
        }
    }
    private void setPortraitFunctionalities(){
        checkForUsers();
    }
    private void setLandsacpeFunctionalities(){
        checkForUsers();
    }
    private void checkForUsers(){
        try(Realm realm = Realm.getDefaultInstance()){
            RealmResults<UserProfile> userlist = realm.where(UserProfile.class).findAll();
            if(userlist.isEmpty()){
                initFragment01();
            } else {
                initFragment02();
            }
        }
    }
    private void initFragment01(){
        getSupportFragmentManager().beginTransaction().replace(R.id.PM02A01_FragContainer, signIn).commit();
    }
    private void initFragment02(){
        getSupportFragmentManager().beginTransaction().replace(R.id.PM02A01_FragContainer, logIn).commit();
    }

}