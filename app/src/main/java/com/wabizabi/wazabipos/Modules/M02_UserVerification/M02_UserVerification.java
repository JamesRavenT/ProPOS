package com.wabizabi.wazabipos.Modules.M02_UserVerification;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.wabizabi.wazabipos.Database.RealmSchemas.RealmUser;
import com.wabizabi.wazabipos.Modules.M02_UserVerification.Fragments.M02F01_UserSignIn;
import com.wabizabi.wazabipos.Modules.M02_UserVerification.Fragments.M02F02_UserLogIn;
import com.wabizabi.wazabipos.R;

import io.realm.Realm;
import io.realm.RealmResults;

public class M02_UserVerification extends AppCompatActivity {

    M02F01_UserSignIn signIn = new M02F01_UserSignIn();
    M02F02_UserLogIn logIn = new M02F02_UserLogIn();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act02_userverification);
        init_Functionalities();
    }
    private void init_Functionalities(){
        checkForUsers();
    }
    private void checkForUsers(){
        try(Realm realm = Realm.getDefaultInstance()){
            RealmResults<RealmUser> userlist = realm.where(RealmUser.class).findAll();
            if(userlist.isEmpty()){
                init_SignInFragment();
            } else {
                init_LogInFragment();
            }
        }
    }
    private void init_SignInFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.M02A01_FragContainer, signIn).commit();
    }
    private void init_LogInFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.M02A01_FragContainer, logIn).commit();
    }

}