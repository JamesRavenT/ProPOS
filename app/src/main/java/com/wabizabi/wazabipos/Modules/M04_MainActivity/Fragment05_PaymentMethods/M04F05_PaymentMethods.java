package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment05_PaymentMethods;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.wabizabi.wazabipos.Database.Instances.OpenPaymentMethodInstance;
import com.wabizabi.wazabipos.Database.ObjectSchemas.PaymentMethod;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment05_PaymentMethods.Adapters.M04F05_PaymentMethodsRVA;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Interfaces.DialogLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.Bundles.DialogBundle;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.DialogHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.ListHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.RVHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.ToastHelper;

import java.util.List;

import io.realm.Realm;

public class M04F05_PaymentMethods extends Fragment implements DialogLoader {
    //--DATABASE--//
    Realm realm = Realm.getDefaultInstance();

    //--CREATE BUTTON--//
    ImageView createBtn;

    //--SEARCH BAR--//
    EditText searchbar;

    //--RECYCLERVIEW--//
    List<PaymentMethod> listOfMethods;
    RecyclerView methodsRV;
    RecyclerView.Adapter methodsRVA;

    //--Dialogs--//
    //--DG01 CREATE method--//
    Dialog methodDG01;
    EditText methodDG01_NameInput;
    CardView methodDG01_ConfirmBtn;
    ImageView closeDG01Btn;

    //--DG02 EDIT method--//
    Dialog methodDG02;
    EditText methodDG02_NameInput;
    CardView methodDG02_ApplyBtn, methodDG02_DeleteBtn;
    ImageView closeDG02Btn;

    //--DG03 DELETE method--//
    Dialog methodDG03;
    TextView methodDG03_methodName;
    CardView methodDG03_YesBtn, methodDG03_NoBtn;
    ImageView closeDG03Btn;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag05_paymentmethods, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        createBtn = v.findViewById(R.id.M04F05_CreateBtn);
        searchbar = v.findViewById(R.id.M04F05_SearchBarInput);
        methodsRV = v.findViewById(R.id.M04F05_RecyclerView);

        init_Dialogs();
        load_Creation();
        load_SearchBar();
        load_RecyclerView();
    }

    private void load_Creation(){
        //On Create Button
        createBtn.setOnClickListener(create -> {
            load_DG01Functionalities();
            methodDG01.show();
        });
    }

    private void load_SearchBar(){
        searchbar.setText("");
        searchbar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable input) {
                load_FilteredRecyclerView(input.toString());
            }
        });

    }
    private void load_RecyclerView(){
        //Initialize RecyclerView
        listOfMethods = RVHelper.getPaymentMethods(realm);
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        methodsRVA = new M04F05_PaymentMethodsRVA(getActivity(), realm, listOfMethods, this);
        methodsRV.setAdapter(methodsRVA);
        methodsRV.setLayoutManager(layout);
    }

    private void load_FilteredRecyclerView(String input){
        //Initialize RecyclerView
        List<PaymentMethod> filteredMethods = RVHelper.getFilteredPaymentMethods(listOfMethods, input);
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        methodsRVA = new M04F05_PaymentMethodsRVA(getActivity(), realm, filteredMethods, this);
        methodsRV.setAdapter(methodsRVA);
        methodsRV.setLayoutManager(layout);
    }

    private void init_Dialogs(){

        //--DG01--//
        methodDG01 = DialogHelper.create(getActivity(), R.layout.act04_main_frag05_paymentmethods_dg01_createpaymentmethod);
        methodDG01_NameInput = methodDG01.findViewById(R.id.M04F05D01_PaymentMethodNameInput);
        methodDG01_ConfirmBtn = methodDG01.findViewById(R.id.M04F05D01_ConfirmBtn);
        closeDG01Btn = methodDG01.findViewById(R.id.M04F05D01_CloseDGBtn);

        //--DG02--//
        methodDG02 = DialogHelper.create(getActivity(), R.layout.act04_main_frag05_paymentmethods_dg02_editpaymentmethod);
        methodDG02_NameInput = methodDG02.findViewById(R.id.M04F05D02_PaymentMethodNameInput);
        methodDG02_ApplyBtn = methodDG02.findViewById(R.id.M04F05D02_ApplyChangesBtn);
        methodDG02_DeleteBtn = methodDG02.findViewById(R.id.M04F05D02_DeleteBtn);
        closeDG02Btn = methodDG02.findViewById(R.id.M04F05D02_CloseDGBtn);

        //--DG03--//
        methodDG03 = DialogHelper.create(getActivity(), R.layout.act04_main_frag05_paymentmethods_dg03_deletepaymentmethod);
        methodDG03_methodName = methodDG03.findViewById(R.id.M04F05D03_PaymentMethodNameText);
        methodDG03_YesBtn = methodDG03.findViewById(R.id.M04F05D03_YesBtn);
        methodDG03_NoBtn = methodDG03.findViewById(R.id.M04F05D03_NoBtn);
        closeDG03Btn = methodDG03.findViewById(R.id.M04F05D03_CloseDGBtn);
    }

    private void load_DG01Functionalities(){
        //Set Text
        methodDG01_NameInput.setText("");

        //On Confirm Button
        methodDG01_ConfirmBtn.setOnClickListener(confirm -> {
            String input = methodDG01_NameInput.getText().toString();

            List<String> listOfMethodNames = ListHelper.getMethodNames(realm);
            if(listOfMethodNames.contains(input)){
                methodDG01_NameInput.setError("Name already exists");
            } else {
                OpenPaymentMethodInstance.toCreateMethod(input);
                load_RecyclerView();
                methodDG01_NameInput.setText("");
                methodDG01_NameInput.setError(null);
                methodDG01.dismiss();
            }
        });

        //On Close
        closeDG01Btn.setOnClickListener(close -> {
            methodDG01.dismiss();
        });

    }

    private void load_DG02Functionalities(DialogBundle bundle){
        //Unpack Bundle
        String method = bundle.getMethod().getMethodName();

        //Set Text
        methodDG02_NameInput.setText(method);
        int focus = methodDG02_NameInput.getText().toString().length();
        methodDG02_NameInput.requestFocus();
        methodDG02_NameInput.setSelection(focus);

        //On Apply Btn
        methodDG02_ApplyBtn.setOnClickListener(apply -> {
            String input = methodDG02_NameInput.getText().toString();

            List<String> listOfMethodNames = ListHelper.getMethodNames(realm);
            if(method.equals(input)){
                ToastHelper.show(getActivity(), "No changes were made");
                methodDG02_NameInput.setText("");
                methodDG02_NameInput.setError(null);
                methodDG02.dismiss();
            } else if(listOfMethodNames.contains(input)){
                methodDG02_NameInput.setError("Name already exists");
            } else {
                OpenPaymentMethodInstance.toUpdateMethod(method, input);
                load_RecyclerView();
                methodDG02_NameInput.setText("");
                methodDG02_NameInput.setError(null);
                methodDG02.dismiss();
            }
        });

        //On Delete Btn
        methodDG02_DeleteBtn.setOnClickListener(delete -> {
            bundle.setDialogDestinationNo(3);
            load_DG03Functionalities(bundle);
            methodDG02.dismiss();
            methodDG03.show();
        });

        //On Close Btn
        closeDG02Btn.setOnClickListener(close -> {
            methodDG02.dismiss();
        });
    }

    private void load_DG03Functionalities(DialogBundle bundle){
        //Unpack Bundle
        String method = bundle.getMethod().getMethodName();

        //Set Names
        methodDG03_methodName.setText(method + "?");

        //On Yes Btn
        methodDG03_YesBtn.setOnClickListener(yes -> {
            OpenPaymentMethodInstance.toDeleteMethod(method);
            load_RecyclerView();
            methodDG03.dismiss();
        });

        //On No Btn
        methodDG03_NoBtn.setOnClickListener(no -> {
            bundle.setDialogDestinationNo(2);
            load_DG02Functionalities(bundle);
            methodDG03.dismiss();
            methodDG02.show();
        });

        //On Close Button

        closeDG03Btn.setOnClickListener(close -> {
            bundle.setDialogDestinationNo(2);
            load_DG02Functionalities(bundle);
            methodDG03.dismiss();
            methodDG02.show();
        });
    }

    @Override
    public void load_DGContents(DialogBundle bundle) {
        load_DG02Functionalities(bundle);
        methodDG02.show();
    }
}
