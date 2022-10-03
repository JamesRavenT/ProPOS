package com.wabizabi.wazabipos.Modules.M02_UserVerification;

import static com.wabizabi.wazabipos.Database.DB.realm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;

import com.wabizabi.wazabipos.Database.DB;
import com.wabizabi.wazabipos.Database.Schemas.UserProfile;
import com.wabizabi.wazabipos.R;

import io.realm.Realm;
import io.realm.RealmResults;

public class Activity_UserVerification extends AppCompatActivity {

    Fragment01_UserSignIn signIn = new Fragment01_UserSignIn();
    Fragment02_UserLogIn logIn = new Fragment02_UserLogIn();

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
            setContentView(R.layout.act02_userverification);
        } else {
            setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            setContentView(R.layout.act02_userverification);
        }
    }
    private void setActivityContents(){
        initCheckForUsers();
    }
    private void initCheckForUsers(){
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
        getSupportFragmentManager().beginTransaction().replace(R.id.UserVerification_FragmentLayout, signIn).commit();
    }
    private void initFragment02(){
        getSupportFragmentManager().beginTransaction().replace(R.id.UserVerification_FragmentLayout, logIn).commit();
    }

}