package com.wabizabi.wazabipos.Modules.M02_UserVerification;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.wabizabi.wazabipos.Database.Instances.OpenUserInstance;
import com.wabizabi.wazabipos.Modules.M03_LoadResources.Activity_LoadResources;
import com.wabizabi.wazabipos.R;

public class Fragment01_UserSignIn extends Fragment {
    EditText userInput, pinInput, pinConfirmInput;
    CardView confirmCreationBtn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act02_userverification_frag01_signin, container, false);

        //--FRAGMENT CONTENT--//
        userInput = v.findViewById(R.id.UserSignIn_UserNameInput);
        pinInput = v.findViewById(R.id.UserSignIn_4PINInput);
        pinConfirmInput = v.findViewById(R.id.UserSignIn_4PINConfirmInput);
        confirmCreationBtn = v.findViewById(R.id.UserSignIn_ConfirmButton);

        confirmCreationBtn.setOnClickListener((button)-> confirmAccountCreation());


        return v;
    }

    private void confirmAccountCreation(){
        String username = userInput.getText().toString();
        String password = pinInput.getText().toString();
        String passwordconfirm = pinConfirmInput.getText().toString();

        if(username.equals("")) {
            userInput.setError("Please input a username.");
        }
        else if(password.equals("") || password.length() < 4) {
            pinInput.setError("Please input a 4 PIN password.");
        }
        else if(!password.equals(passwordconfirm)) {
            pinInput.setError("Passwords do not match.");
            pinConfirmInput.setError("Passwords do not match.");
        } else {
            OpenUserInstance.toCreateUser(username, password);
            startActivity(new Intent(getActivity(), Activity_LoadResources.class));
        }


    }
}
