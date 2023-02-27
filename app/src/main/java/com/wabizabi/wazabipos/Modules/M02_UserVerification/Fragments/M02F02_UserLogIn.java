package com.wabizabi.wazabipos.Modules.M02_UserVerification.Fragments;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.M04_Main.currentFragment;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.wabizabi.wazabipos.Database.Instances.OpenUserInstance;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmUser;
import com.wabizabi.wazabipos.Modules.M03_LoadResources.M03_LoadResources;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.M04_Main;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.BackgroundThreads.WorkOrders;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.ToastHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import io.realm.Realm;

public class M02F02_UserLogIn extends Fragment {
    List<Integer> pin = new ArrayList<>();
    CardView pin1, pin2, pin3, pin4;
    CardView btn01, btn02, btn03, btn04, btn05, btn06, btn07, btn08, btn09, btn00;
    ImageButton btnBackspace;
    TextView forgotPwBtn;
    String previousSendingTime = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act02_userverification_frag02_login, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        pin1 = v.findViewById(R.id.M02F02_PIN1);
        pin2 = v.findViewById(R.id.M02F02_PIN2);
        pin3 = v.findViewById(R.id.M02F02_PIN3);
        pin4 = v.findViewById(R.id.M02F02_PIN4);
        btn00 = v.findViewById(R.id.M02F02_Button00);
        btn01 = v.findViewById(R.id.M02F02_Button01);
        btn02 = v.findViewById(R.id.M02F02_Button02);
        btn03 = v.findViewById(R.id.M02F02_Button03);
        btn04 = v.findViewById(R.id.M02F02_Button04);
        btn05 = v.findViewById(R.id.M02F02_Button05);
        btn06 = v.findViewById(R.id.M02F02_Button06);
        btn07 = v.findViewById(R.id.M02F02_Button07);
        btn08 = v.findViewById(R.id.M02F02_Button08);
        btn09 = v.findViewById(R.id.M02F02_Button09);
        btnBackspace = v.findViewById(R.id.M02F02_ButtonBackspace);
        forgotPwBtn = v.findViewById(R.id.M04F02_ForgotPasswordBtn);

        updatePIN();

        btn00.setOnClickListener(btn -> insertEntry(0));
        btn01.setOnClickListener(btn -> insertEntry(1));
        btn02.setOnClickListener(btn -> insertEntry(2));
        btn03.setOnClickListener(btn -> insertEntry(3));
        btn04.setOnClickListener(btn -> insertEntry(4));
        btn05.setOnClickListener(btn -> insertEntry(5));
        btn06.setOnClickListener(btn -> insertEntry(6));
        btn07.setOnClickListener(btn -> insertEntry(7));
        btn08.setOnClickListener(btn -> insertEntry(8));
        btn09.setOnClickListener(btn -> insertEntry(9));
        btnBackspace.setOnClickListener(btn -> deleteEntry());

        passwordRecovery();
    }

    private void insertEntry(int number){
        if(pin.size() == 3){
            pin.add(number);
            updatePIN();
            verify();
        } else {
            pin.add(number);
            updatePIN();
        }
    }
    private void deleteEntry(){
        if(!pin.isEmpty()){
            pin.remove(pin.size()-1);
            updatePIN();
        }
    }
    private void updatePIN(){
        switch(pin.size()){
            case 0:
                pin1.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.gray));
                pin2.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.gray));
                pin3.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.gray));
                pin4.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.gray));
                break;
            case 1:
                pin1.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
                pin2.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.gray));
                pin3.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.gray));
                pin4.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.gray));
                break;
            case 2:
                pin1.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
                pin2.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
                pin3.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.gray));
                pin4.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.gray));
                break;
            case 3:
                pin1.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
                pin2.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
                pin3.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
                pin4.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.gray));
                break;
            case 4:
                pin1.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
                pin2.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
                pin3.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
                pin4.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
                break;
        }
    }
    private void verify(){
        try(Realm realm = Realm.getDefaultInstance()){
            RealmUser user = realm.where(RealmUser.class).findFirst();
            int pass = Integer.parseInt(pin.stream().map(String::valueOf).collect(Collectors.joining("")));
            if(pass == user.getPassword()){
                pin.clear();
                updatePIN();
                if(currentFragment != null){
                    currentFragment = "Admin";
                    startActivity(new Intent(getActivity(), M04_Main.class));
                    getActivity().finish();
                } else {
                    OpenUserInstance.toSetVerifiedUserToTrue();
                    startActivity(new Intent(getActivity(), M03_LoadResources.class));
                    getActivity().finish();
                }
            } else {
                pin.clear();
                updatePIN();
                Toast.makeText(getActivity(), "Invalid PIN", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void passwordRecovery(){
        forgotPwBtn.setOnClickListener(send -> {
            boolean connectionExists = checkIfNetworkIsAvailable();
            if(connectionExists){
                if(previousSendingTime == null){
                    previousSendingTime = new SimpleDateFormat("mm").format(new Date());
                    WorkOrders.sendEmail(getActivity());
                    ToastHelper.show(getActivity(), "A mail has been sent to your registered E-mail");
                } else {
                    int previousTime = Integer.parseInt(previousSendingTime);
                    int currentTime = Integer.parseInt(new SimpleDateFormat("mm").format(new Date()));
                    if(previousTime != currentTime){
                        WorkOrders.sendEmail(getActivity());
                        ToastHelper.show(getActivity(), "A mail has been sent to your registered E-mail");
                        previousSendingTime = String.valueOf(currentTime);
                    } else {
                        ToastHelper.show(getActivity(), "Please wait for a minute before sending a mail again");
                        previousSendingTime = String.valueOf(currentTime);
                    }
                }
            } else {
                ToastHelper.show(getActivity(), "Please enable your internet connection");

            }
        });
    }

    private boolean checkIfNetworkIsAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
