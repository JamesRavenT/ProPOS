package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_User;

import static com.wabizabi.wazabipos.Modules.M02_UserVerification.Fragments.M02F02_UserLogIn.operationForM02F02;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.wabizabi.wazabipos.Modules.M02_UserVerification.M02_UserVerification;
import com.wabizabi.wazabipos.R;

public class M04F04_Admin extends Fragment {
    Dialog settingsDialog;
    ImageButton settingsBtn;
    TextView changeUsername, changePassword;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag04_admin, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        init_Views(v);
        init_Dialogs();
        init_Buttons();
    }

    private void init_Views(View v){
        settingsBtn = v.findViewById(R.id.M04F04_SettingsButton);

    }

    private void init_Dialogs(){
        settingsDialog = new Dialog(getActivity());
        settingsDialog.setContentView(R.layout.act04_main_frag04_admin_window_settingsdialog);
        settingsDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        changeUsername = settingsDialog.findViewById(R.id.M04F04WDS_ChangeUsernameText);
        changePassword = settingsDialog.findViewById(R.id.M04F04WDS_ChangePasswordText);
        changeUsername.setOnClickListener(v -> {
            operationForM02F02 = "Change Username";
            settingsDialog.dismiss();
            startActivity(new Intent(getActivity(), M02_UserVerification.class));
        });
        changePassword.setOnClickListener(v -> {
            operationForM02F02 = "Change Password";
            settingsDialog.dismiss();
            startActivity(new Intent(getActivity(), M02_UserVerification.class));
        });
    }

    private void init_Buttons(){
        settingsBtn.setOnClickListener(v -> {
            settingsDialog.show();
        });
    }
}
