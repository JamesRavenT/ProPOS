package com.wabizabi.wazabipos.Modules.M02_UserVerification;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.M04_Main.currentFragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.wabizabi.wazabipos.Database.RealmSchemas.RealmUser;
import com.wabizabi.wazabipos.Modules.M02_UserVerification.Fragments.M02F01_UserSignIn;
import com.wabizabi.wazabipos.Modules.M02_UserVerification.Fragments.M02F02_UserLogIn;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.M04_Main;
import com.wabizabi.wazabipos.R;

import io.realm.Realm;
import io.realm.RealmResults;

public class M02_UserVerification extends AppCompatActivity {

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
        if(currentFragment != null){
            init_LogInFragment();
        } else {
            try(Realm realm = Realm.getDefaultInstance()){
                RealmResults<RealmUser> userlist = realm.where(RealmUser.class).findAll();
                if(userlist.isEmpty()){
                    init_SignInFragment();
                } else {
                    init_LogInFragment();
                }
            }
        }
    }
    private void init_SignInFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.M02A01_FragContainer, new M02F01_UserSignIn()).commit();
    }
    private void init_LogInFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.M02A01_FragContainer, new M02F02_UserLogIn()).commit();
    }

    @Override
    public void onBackPressed() {
        if(currentFragment != null){
            startActivity(new Intent(this, M04_Main.class));
            finish();
        }
    }
}