package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment07_Admin;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.wabizabi.wazabipos.Database.Instances.OpenUserInstance;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmUser;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment07_Admin.SubFragments.SubFragment01_SalesReport.M04F07SF01_SalesReport;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment07_Admin.SubFragments.SubFragment02_InventoryTransaction.M04F07SF02_InventoryTransaction;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment07_Admin.SubFragments.SubFragment03_SalesTransaction.M04F07SF03_SalesTransaction;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.DialogHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.LayoutHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.ToastHelper;

import io.realm.Realm;

public class M04F07_Admin extends Fragment {

    //--DATABASE--//
    Realm realm = Realm.getDefaultInstance();

    //--User Details--//

    //--View Buttons--//
    CardView viewProfileManagerBtn,
             viewSalesReportBtn,
             viewTransactionsBtn;
    //--DG01 OPERATION--//
    Dialog adminDG01;
    CardView adminDG01_changeEmailBtn,
             adminDG01_changeNameBtn,
             adminDG01_changePasswordBtn;
    ImageView closeDG01Btn;

    //--DG02 CHANGE EMAIL--//
    Dialog adminDG02;
    EditText adminDG02_OldEmailInput,
             adminDG02_NewEmailInput;
    CardView adminDG02_ConfirmBtn;
    ImageView closeDG02Btn;

    //--DG03 CHANGE NAME--//
    Dialog adminDG03;
    EditText adminDG03_UserNameInput;
    CardView adminDG03_ConfirmBtn;
    ImageView closeDG03Btn;

    //--DG04 CHANGE PASSWORD--//
    Dialog adminDG04;
    EditText adminDG04_OldPasswordInput,
             adminDG04_NewPasswordInput;
    CardView adminDG04_ConfirmBtn;
    ImageView closeDG04Btn;

    //--DG05 TRANSACTION--//
    Dialog adminDG05;
    CardView adminDG05_InventoryBtn,
             adminDG05_SalesBtn;
    ImageView closeDG05Btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutHelper.inflateFragment(inflater, container, R.layout.act04_main_frag07_admin);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        viewProfileManagerBtn = v.findViewById(R.id.M04F07_ProfileContainer);
        viewSalesReportBtn = v.findViewById(R.id.M04F07_SalesReportViewBtn);
        viewTransactionsBtn = v.findViewById(R.id.M04F07_TransactionsViewBtn);

        init_Dialogs();
        load_ProfileManager();
        load_ViewSalesReport();
        load_ViewTransaction();
    }

    private void load_ProfileManager(){
        viewProfileManagerBtn.setOnClickListener(view -> {
            load_DG01Functionalities();
            adminDG01.show();
        });
    }

    private void load_ViewSalesReport(){
        viewSalesReportBtn.setOnClickListener(view -> {
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.MainActivityContainer, new M04F07SF01_SalesReport())
                    .commit();
        });
    }

    private void load_ViewTransaction(){
        viewTransactionsBtn.setOnClickListener(transcation -> {
            load_DG05Functionalities();
            adminDG05.show();
        });
    }

    private void init_Dialogs(){
        //--DG01--//
        adminDG01 = DialogHelper.create(getActivity(), R.layout.act04_main_frag07_admin_dg01_selectprofileoperation);
        adminDG01_changeEmailBtn = adminDG01.findViewById(R.id.M04F07D01_ChangeEmailBtn);
        adminDG01_changeNameBtn = adminDG01.findViewById(R.id.M04F07D01_ChangeUserNameBtn);
        adminDG01_changePasswordBtn = adminDG01.findViewById(R.id.M04F07D01_ChangePasswordBtn);
        closeDG01Btn = adminDG01.findViewById(R.id.M04F07D01_CloseDGBtn);

        //--DG02--//
        adminDG02 = DialogHelper.create(getActivity(), R.layout.act04_main_frag07_admin_dg02_changeemail);
        adminDG02_OldEmailInput = adminDG02.findViewById(R.id.M04F07D02_OldEmailInput);
        adminDG02_NewEmailInput = adminDG02.findViewById(R.id.M04F07D02_NewEmailInput);
        adminDG02_ConfirmBtn = adminDG02.findViewById(R.id.M04F07D02_ConfirmBtn);
        closeDG02Btn = adminDG02.findViewById(R.id.M04F07D02_CloseDGBtn);

        //--DG03--//
        adminDG03 = DialogHelper.create(getActivity(), R.layout.act04_main_frag07_admin_dg03_changeusername);
        adminDG03_UserNameInput = adminDG03.findViewById(R.id.M04F07D03_UsernameInput);
        adminDG03_ConfirmBtn = adminDG03.findViewById(R.id.M04F07D03_ConfirmBtn);
        closeDG03Btn = adminDG03.findViewById(R.id.M04F07D03_CloseDGBtn);

        //--DG04--//
        adminDG04 = DialogHelper.create(getActivity(), R.layout.act04_main_frag07_admin_dg04_changepassword);
        adminDG04_OldPasswordInput = adminDG04.findViewById(R.id.M04F07D04_OldPasswordInput);
        adminDG04_NewPasswordInput = adminDG04.findViewById(R.id.M04F07D04_NewPasswordInput);
        adminDG04_ConfirmBtn = adminDG04.findViewById(R.id.M04F07D04_ConfirmBtn);
        closeDG04Btn = adminDG04.findViewById(R.id.M04F07D04_CloseDGBtn);

        //--DG05--//
        adminDG05 = DialogHelper.create(getActivity(), R.layout.act04_main_frag07_admin_dg05_selecttransaction);
        adminDG05_InventoryBtn = adminDG05.findViewById(R.id.M04F07D05_InventoryBtn);
        adminDG05_SalesBtn = adminDG05.findViewById(R.id.M04F07D05_SalesBtn);
        closeDG05Btn = adminDG05.findViewById(R.id.M04F07D04_CloseDGBtn);
    }

    private void load_DG01Functionalities(){
        adminDG01_changeEmailBtn.setOnClickListener(email -> {
            load_DG02Functionalities();
            adminDG01.dismiss();
            adminDG02.show();

        });

        adminDG01_changeNameBtn.setOnClickListener(name -> {
            load_DG03Functionalities();
            adminDG01.dismiss();
            adminDG03.show();
        });

        adminDG01_changePasswordBtn.setOnClickListener(password -> {
            load_DG04Functionalities();
            adminDG01.dismiss();
            adminDG04.show();
        });

        closeDG01Btn.setOnClickListener(close -> {
            adminDG01.dismiss();
        });
    }

    private void load_DG02Functionalities(){
        //Load Details
        RealmUser user = realm.where(RealmUser.class).findFirst();
        String oldEmail = user.getEmail();

        //Set Views
        adminDG02_OldEmailInput.setText("");
        adminDG02_NewEmailInput.setText("");

        //On Confirm
        adminDG02_ConfirmBtn.setOnClickListener(confirm -> {
            String oldEmailInput = adminDG02_OldEmailInput.getText().toString();
            String newEmailInput = adminDG02_NewEmailInput.getText().toString();

            if(oldEmailInput.equals("")){
                adminDG02_OldEmailInput.setError("This field cannot be empty!");
            } else if(!oldEmailInput.equals(oldEmail)){
                adminDG02_OldEmailInput.setError("Input does not match previous E-mail");
            } else if(newEmailInput.equals("")) {
                adminDG02_NewEmailInput.setError("This field cannot be empty!");
            } else if(!newEmailInput.contains("@") && !newEmailInput.contains(".")){
                adminDG02_NewEmailInput.setError("Input is not a valid email");
            } else {
                OpenUserInstance.toUpdateEmail(newEmailInput);
                adminDG02.dismiss();
            }
        });

        //On Close
        closeDG02Btn.setOnClickListener(close -> {
            adminDG02.dismiss();
        });

    }

    private void load_DG03Functionalities(){
        //Load Details
        RealmUser user = realm.where(RealmUser.class).findFirst();
        String username = user.getUserName();

        //Set Views
        adminDG03_UserNameInput.setText("");

        //On Confirm
        adminDG03_ConfirmBtn.setOnClickListener(confirm -> {
            String userInput = adminDG03_UserNameInput.getText().toString();

            if(userInput.equals("")){
                adminDG03_UserNameInput.setError("This field cannot be empty!");
            } else if(userInput.equals(username)){
                ToastHelper.show(getActivity(), "No Changes were made");
                adminDG03.dismiss();
            } else {
                OpenUserInstance.toUpdateUsername(userInput);
                ToastHelper.show(getActivity(), "Username Updated!");
                adminDG03.dismiss();
            }
        });
    }

    private void load_DG04Functionalities(){
        //Load Details
        RealmUser user = realm.where(RealmUser.class).findFirst();
        String oldPIN = String.valueOf(user.getPassword());

        //Set Views
        adminDG04_OldPasswordInput.setText("");
        adminDG04_NewPasswordInput.setText("");

        //On Confirm
        adminDG04_ConfirmBtn.setOnClickListener(confirm -> {
            String oldPINInput = adminDG04_OldPasswordInput.getText().toString();
            String newPINInput = adminDG04_NewPasswordInput.getText().toString();
            if(oldPINInput.equals("")){
                adminDG04_OldPasswordInput.setError("This field cannot be empty!");
            } else if(newPINInput.equals("")){
                adminDG04_NewPasswordInput.setError("This field cannot be empty!");
            } else if(!oldPINInput.equals(oldPIN)){
                adminDG04_OldPasswordInput.setError("Input does not match previous PIN");
            } else {
                OpenUserInstance.toUpdatePassword(newPINInput);
                ToastHelper.show(getActivity(), "PIN Updated!");
                adminDG04.dismiss();
            }
        });

        //On Close
        closeDG04Btn.setOnClickListener(close -> {
            adminDG04.dismiss();
        });
    }

    private void load_DG05Functionalities(){
        //On Inventory Btn
        adminDG05_InventoryBtn.setOnClickListener(inventory -> {
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.MainActivityContainer, new M04F07SF02_InventoryTransaction())
                    .commit();
        });

        //On Sales Btn
        adminDG05_SalesBtn.setOnClickListener(sales -> {
            getActivity().getSupportFragmentManager()
                         .beginTransaction()
                         .replace(R.id.MainActivityContainer, new M04F07SF03_SalesTransaction())
                         .commit();
        });

        //On Close Btn
        closeDG05Btn.setOnClickListener(close -> {
            adminDG05.dismiss();
        });
    }

}
