package com.wabizabi.wazabipos.Modules.M02_UserVerification.Fragments;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_User.Operations.M04F04OP_Management.operationForM04F04;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.wabizabi.wazabipos.Database.Schemas.UserProfile;
import com.wabizabi.wazabipos.Modules.M03_LoadResources.M03_LoadResources;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_User.Operations.M04F04OP_Management;
import com.wabizabi.wazabipos.R;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import io.realm.Realm;

public class M02F02_UserLogIn extends Fragment {
    public static String operationForM02F02 = "Log In";
    List<Integer> pin = new ArrayList<>();
    CardView pin1, pin2, pin3, pin4;
    CardView btn01, btn02, btn03, btn04, btn05, btn06, btn07, btn08, btn09, btn00;
    ImageButton btnBackspace;

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
                pin1.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.WazabiTheme));
                pin2.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.gray));
                pin3.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.gray));
                pin4.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.gray));
                break;
            case 2:
                pin1.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.WazabiTheme));
                pin2.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.WazabiTheme));
                pin3.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.gray));
                pin4.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.gray));
                break;
            case 3:
                pin1.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.WazabiTheme));
                pin2.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.WazabiTheme));
                pin3.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.WazabiTheme));
                pin4.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.gray));
                break;
            case 4:
                pin1.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.WazabiTheme));
                pin2.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.WazabiTheme));
                pin3.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.WazabiTheme));
                pin4.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.WazabiTheme));
                break;
        }
    }
    private void verify(){
        try(Realm realm = Realm.getDefaultInstance()){
            UserProfile user = realm.where(UserProfile.class).findFirst();
            int pass = Integer.parseInt(pin.stream().map(String::valueOf).collect(Collectors.joining("")));
            if(pass == user.getPassword()){
                pin.clear();
                updatePIN();
                if(operationForM02F02.equals("Change Username")){
                    operationForM04F04 = "Change Username";
                    startActivity(new Intent(getActivity(), M04F04OP_Management.class));
                    getActivity().finish();
                }
                else if(operationForM02F02.equals("Change Password")){
                    operationForM04F04 = "Change Password";
                    startActivity(new Intent(getActivity(), M04F04OP_Management.class));
                    getActivity().finish();
                } else {
                    startActivity(new Intent(getActivity(), M03_LoadResources.class));
                }
            } else {
                pin.clear();
                updatePIN();
                Toast.makeText(getActivity(), "Invalid PIN", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
