package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_User.Operations.Profile;

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
import com.wabizabi.wazabipos.R;

public class M04F04OPUP_ChangePassword extends Fragment {
    EditText newPassword, newPasswordConfirm;
    CardView confirmChangesButton;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag04_admin_operation_management_changepassword, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        init_Views(v);
        init_Buttons();
    }

    private void init_Views(View v){
        newPassword = v.findViewById(R.id.M04F04OPUP_NewPasswordInput);
        newPasswordConfirm = v.findViewById(R.id.M04F04OPUP_ConfirmNewPasswordInput);
        confirmChangesButton= v.findViewById(R.id.M04F04OPUP_ConfirmChangesButton);
    }
    private void init_Buttons(){
        confirmChangesButton.setOnClickListener(v -> {
            String password = newPassword.getText().toString();
            String confirmpassword = newPasswordConfirm.getText().toString();

            if(!password.equals(confirmpassword)) {
               newPassword.setError("Passwords do not match");
               newPasswordConfirm.setError("Passwords do not match");
            }
            else if(password.equals("")){
                newPassword.setError("This field can't be empty");
            }
            else if(confirmpassword.equals("")){
                newPasswordConfirm.setError("This field can't be empty");
            }
            else {
                OpenUserInstance.toUpdatePassword(password);
                newPassword.setText("");
                newPasswordConfirm.setText("");
                getActivity().finish();
            }
        });

    }
}
