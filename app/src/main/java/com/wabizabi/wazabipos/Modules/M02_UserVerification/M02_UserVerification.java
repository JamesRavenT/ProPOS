package com.wabizabi.wazabipos.Modules.M02_UserVerification;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.M04_Main.currentFragment;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;

import androidx.appcompat.app.AppCompatActivity;

import com.wabizabi.wazabipos.Database.RealmSchemas.RealmUser;
import com.wabizabi.wazabipos.Modules.M02_UserVerification.Fragments.M02F01_UserSignIn;
import com.wabizabi.wazabipos.Modules.M02_UserVerification.Fragments.M02F02_UserLogIn;
import com.wabizabi.wazabipos.R;

import io.realm.Realm;
import io.realm.RealmResults;

public class M02_UserVerification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act02_userverification);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
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
            finish();
        }
    }

    @Override
    protected void attachBaseContext(final Context baseContext) {

        Context newContext;

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

            DisplayMetrics displayMetrics = baseContext.getResources().getDisplayMetrics();
            Configuration configuration = baseContext.getResources().getConfiguration();

            if (displayMetrics.densityDpi != DisplayMetrics.DENSITY_DEVICE_STABLE) {
                // Current density is different from Default Density. Override it
                configuration.densityDpi = DisplayMetrics.DENSITY_DEVICE_STABLE;
                newContext = baseContext.createConfigurationContext(configuration);
            } else {
                // Same density. Just use same context
                newContext = baseContext;
            }
        } else {
            // Old API. Screen zoom not supported
            newContext = baseContext;
        }
        super.attachBaseContext(newContext);
    }
}