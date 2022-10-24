package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_User.Operations.Profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.wabizabi.wazabipos.Database.Instances.OpenUserInstance;
import com.wabizabi.wazabipos.Database.Schemas.UserProfile;
import com.wabizabi.wazabipos.R;

import io.realm.Realm;

public class M04F04OPUU_ChangeUsername extends Fragment {
    Realm realm;
    EditText newUsernameInput;
    CardView confirmChangesButton;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag04_admin_operation_management_changeusername, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        init_Views(v);
        init_DB();
        init_UserName();
        init_Buttons();
    }
    private void init_Views(View v){
        newUsernameInput = v.findViewById(R.id.M04F04OPUU_NewUserNameInput);
        confirmChangesButton = v.findViewById(R.id.M04F04OPUU_ConfirmChangesButton);
    }
    private void init_DB(){
        realm = Realm.getDefaultInstance();
    }
    private void init_UserName(){
        UserProfile user = realm.where(UserProfile.class).findFirst();
        newUsernameInput.setHint(user.getUserName());
    }
    private void init_Buttons(){
        confirmChangesButton.setOnClickListener(v -> {
            String newUsername = newUsernameInput.getText().toString();

            if(newUsername.equals("")){
                Toast.makeText(getActivity(), "No changes has been made", Toast.LENGTH_SHORT).show();
                getActivity().finish();
            } else {
                OpenUserInstance.toUpdateUsername(newUsername);
                Toast.makeText(getActivity(), "Changes saved", Toast.LENGTH_SHORT).show();
                getActivity().finish();
            }
        });
    }
}
