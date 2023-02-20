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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.wabizabi.wazabipos.Database.DB;

import com.wabizabi.wazabipos.Database.Instances.OpenUserInstance;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmUser;
import com.wabizabi.wazabipos.Modules.M02_UserVerification.M02_UserVerification;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.BackgroundThreads.WorkOrders;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.DialogHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.LogHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.ToastHelper;
import com.wabizabi.wazabipos.Utilities.Testing.TestData;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.realm.Realm;

public class M01_SplashScreen extends AppCompatActivity {
    //--DG01--//
    Dialog scDG01;
    CardView scDG01_retryBtn;
    ImageView closeDG01Btn;

    //--DG02--//
    Dialog scDG02;
    TextView scDG02_userName;
    EditText scDG02_codeInput;
    String previousSendingTime = null;
    TextView scDG02_resendVerificationCode;
    CardView scDG02_verifyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act01_splashscreen);
        init_Functionalities();
    }

    private void init_Functionalities(){
        init_DB();
        init_Dialog();
        verify_User();
    }

    private void init_DB(){
        LogHelper.debug("ONE");
        Realm.init(this);
        DB.init();
    }

    private void verify_User(){
        Handler timer = new Handler();
        try(Realm realm = Realm.getDefaultInstance()){
            RealmUser user = realm.where(RealmUser.class).findFirst();
            if(user == null){
                boolean connectionExists = checkIfNetworkIsAvailable();
                if(connectionExists){
                    DB.checkForUser();
                    timer.postDelayed(() -> {
                        RealmUser userVerification = realm.where(RealmUser.class).findFirst();
                        if(userVerification != null && !userVerification.isVerifiedUser()) {
                            load_DG02Functionalities();
                            scDG02.show();
                        } else {
                            load_NextModule();
                        }
                    }, 5000);
                } else {
                    load_DG01Functionalities();
                    scDG01.show();
                }
            } else if(!user.isVerifiedUser()){
                load_DG02Functionalities();
                scDG02.show();
            } else {
                load_NextModule();
            }
        }
    }

    private void init_Dialog(){
        //--DG01--//
        scDG01 = DialogHelper.create(this, R.layout.act01_splashscreen_dg01_internet);
        scDG01_retryBtn = scDG01.findViewById(R.id.M01D01_RetryBtn);
        closeDG01Btn = scDG01.findViewById(R.id.M01D01_CloseDGBtn);

        //--DG02--//
        scDG02 = DialogHelper.create(this, R.layout.act01_splashscreen_dg02_verificationcode);
        scDG02.setCancelable(false);
        scDG02_userName = scDG02.findViewById(R.id.M01D02_WelcomeBack);
        scDG02_codeInput = scDG02.findViewById(R.id.M01D02_CodeInput);
        scDG02_resendVerificationCode = scDG02.findViewById(R.id.M01D02_ResendBtn);
        scDG02_verifyBtn = scDG02.findViewById(R.id.M01D02_VerifyBtn);
    }

    private void load_DG01Functionalities(){
        scDG01_retryBtn.setOnClickListener(retry -> {
            scDG01.dismiss();
            verify_User();
        });
        closeDG01Btn.setOnClickListener(close -> {
            scDG01.dismiss();
            verify_User();
        });
    }

    private void load_DG02Functionalities(){
        Realm realm = Realm.getDefaultInstance();
        OpenUserInstance.toCreateVerificationCode();
        WorkOrders.sendVerificationCode(this);
        RealmUser user = realm.where(RealmUser.class).findFirst();
        String name = user.getUserName();

        //Set Views
        scDG02_userName.setText("Welcome Back,\n" + name + "!");
        scDG02_codeInput.setText("");

        //On Resend
        scDG02_resendVerificationCode.setOnClickListener(resend -> {
            boolean connectionExists = checkIfNetworkIsAvailable();
            if(connectionExists){
                if(previousSendingTime == null){
                    LogHelper.debug("case1");
                    OpenUserInstance.toCreateVerificationCode();
                    previousSendingTime = new SimpleDateFormat("mm").format(new Date());
                    WorkOrders.sendVerificationCode(this);
                } else {
                    int previousTime = Integer.parseInt(previousSendingTime);
                    int currentTime = Integer.parseInt(new SimpleDateFormat("mm").format(new Date()));
                    if(previousTime != currentTime){
                        LogHelper.debug("case2");
                        OpenUserInstance.toCreateVerificationCode();
                        WorkOrders.sendVerificationCode(this);
                        ToastHelper.show(this, "A mail has been sent to your registered E-mail");
                        previousSendingTime = String.valueOf(currentTime);
                    } else {
                        LogHelper.debug("case3");
                        ToastHelper.show(this, "Please wait for a minute before sending a mail again");
                    }
                }
            } else {
                ToastHelper.show(this, "Please check your internet connection and try again");
            }
        });

        //On Confirm
        scDG02_verifyBtn.setOnClickListener(verify -> {
            String input = scDG02_codeInput.getText().toString();
            if(input.equals("") || !input.equals(user.getVerficationCode())){
                scDG02_codeInput.setError("Code Invalid");
            } else {
                OpenUserInstance.toDeleteVerificationCode();
                scDG02.dismiss();
                load_NextModule();
            }
        });
    }

    private void load_NextModule(){
        Handler splashScreen = new Handler();
        splashScreen.postDelayed(()->{
            startActivity(new Intent(this, M02_UserVerification.class));
            finish();
        }, 1000);
    }

    private boolean checkIfNetworkIsAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}