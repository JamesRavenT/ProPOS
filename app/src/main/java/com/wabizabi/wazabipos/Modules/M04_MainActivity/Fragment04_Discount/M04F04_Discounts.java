package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_Discount;

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

import com.wabizabi.wazabipos.Database.Instances.OpenDiscountInstance;
import com.wabizabi.wazabipos.Database.ObjectSchemas.Discount;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_Discount.Adapters.M04F04_DiscountsRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_Discount.Helpers.DCHelper;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Interfaces.DialogLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.Bundles.DialogBundle;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.DialogHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.ToastHelper;

import java.util.List;

import io.realm.Realm;

public class M04F04_Discounts extends Fragment implements DialogLoader {

    //--DATABASE--//
    Realm realm = Realm.getDefaultInstance();

    //--CREATE BUTTON--//
    ImageView createBtn;

    //--SEARCH BAR--//
    EditText searchbar;

    //--RECYCLERVIEW--//
    List<Discount> listOfDiscounts;
    RecyclerView discountsRV;
    RecyclerView.Adapter discountsRVA;

    //--Dialogs--//
    //--DG01 CREATE DISCOUNT--//
    Dialog discountDG01;
    EditText discountDG01_NameInput,
             discountDG01_percentInput;
    CardView discountDG01_ConfirmBtn;
    ImageView closeDG01Btn;

    //--DG02 EDIT DISCOUNT--//
    Dialog discountDG02;
    EditText discountDG02_NameInput,
             discountDG02_PercentInput;
    CardView discountDG02_ApplyBtn, discountDG02_DeleteBtn;
    ImageView closeDG02Btn;

    //--DG03 DELETE DISCOUNT--//
    Dialog discountDG03;
    TextView discountDG03_discountName;
    CardView discountDG03_YesBtn, discountDG03_NoBtn;
    ImageView closeDG03Btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag04_discounts, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        createBtn = v.findViewById(R.id.M04F04_CreateBtn);
        searchbar = v.findViewById(R.id.M04F04_SearchBarInput);
        discountsRV = v.findViewById(R.id.M04F04_RecyclerView);

        init_Dialogs();
        load_Creation();
        load_SearchBar();
        load_RecyclerView();
    }

    private void load_Creation(){
        //On Click Add Button
        createBtn.setOnClickListener(create -> {
            load_DG01Functionalities();
            discountDG01.show();
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
        listOfDiscounts = DCHelper.getDiscounts(realm);
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        discountsRVA = new M04F04_DiscountsRVA(getActivity(), realm, listOfDiscounts, this);
        discountsRV.setAdapter(discountsRVA);
        discountsRV.setLayoutManager(layout);
    }

    private void load_FilteredRecyclerView(String input){
        //Initialize RecyclerView
        List<Discount> filteredDiscounts = DCHelper.getFilteredDiscounts(listOfDiscounts, input);
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        discountsRVA = new M04F04_DiscountsRVA(getActivity(), realm, filteredDiscounts, this);
        discountsRV.setAdapter(discountsRVA);
        discountsRV.setLayoutManager(layout);
    }

    private void init_Dialogs(){
        //--DG01--//
        discountDG01 = DialogHelper.create(getActivity(), R.layout.act04_main_frag04_discounts_dg01_creatediscount);
        discountDG01_NameInput = discountDG01.findViewById(R.id.M04F04D01_DiscountNameInput);
        discountDG01_percentInput = discountDG01.findViewById(R.id.M04F04D01_DiscountPercentageInput);
        discountDG01_ConfirmBtn = discountDG01.findViewById(R.id.M04F04D01_ConfirmBtn);
        closeDG01Btn = discountDG01.findViewById(R.id.M04F04D01_CloseDGBtn);

        //--DG02--//
        discountDG02 = DialogHelper.create(getActivity(), R.layout.act04_main_frag04_discounts_dg02_editdiscount);
        discountDG02_NameInput = discountDG02.findViewById(R.id.M04F04D02_DiscountNameInput);
        discountDG02_PercentInput = discountDG02.findViewById(R.id.M04F04D02_DiscountPercentageInput);
        discountDG02_ApplyBtn = discountDG02.findViewById(R.id.M04F04D02_ApplyChangesBtn);
        discountDG02_DeleteBtn = discountDG02.findViewById(R.id.M04F04D02_DeleteBtn);
        closeDG02Btn = discountDG02.findViewById(R.id.M04F04D02_CloseDGBtn);

        //--DG03--//
        discountDG03 = DialogHelper.create(getActivity(), R.layout.act04_main_frag04_discounts_dg03_deletediscount);
        discountDG03_discountName = discountDG03.findViewById(R.id.M04F04D03_DiscountNameText);
        discountDG03_YesBtn = discountDG03.findViewById(R.id.M04F04D03_YesBtn);
        discountDG03_NoBtn = discountDG03.findViewById(R.id.M04F04D03_NoBtn);
        closeDG03Btn = discountDG03.findViewById(R.id.M04F04D03_CloseDGBtn);
    }

    //Create Table
    private void load_DG01Functionalities(){
        //Set Edit Text
        discountDG01_NameInput.setText("");
        discountDG01_percentInput.setText("");

        //On Confirm Button
        discountDG01_ConfirmBtn.setOnClickListener(confirm -> {
            String nameInput = discountDG01_NameInput.getText().toString();
            String percentInput = discountDG01_percentInput.getText().toString();
            List<String> listOfAllDiscounts = DCHelper.getDiscountNames(realm);
            if(listOfAllDiscounts.contains(nameInput)) {
                discountDG01_NameInput.setError("Name already exists");
            } else if(percentInput.equals("")){
                discountDG01_percentInput.setError("Please input a value");
            } else if(Integer.parseInt(percentInput) > 100) {
                discountDG01_percentInput.setError("Value cannot be greater than 100%");
            } else {
                OpenDiscountInstance.toCreateDiscount(nameInput, Integer.parseInt(percentInput));
                load_RecyclerView();
                discountDG01_NameInput.setText("");
                discountDG01_percentInput.setText("");
                discountDG01_NameInput.setError(null);
                discountDG01_percentInput.setError(null);
                discountDG01.dismiss();
            }
        });

        //On Close Btn
        closeDG01Btn.setOnClickListener(close -> {
            discountDG01.dismiss();
        });
    }

    //Edit Discount
    private void load_DG02Functionalities(DialogBundle bundle){
        //Unpack Bundle
        Discount discount = bundle.getDiscount();

        //Set Text
        discountDG02_NameInput.setText(discount.getDiscountName());
        discountDG02_PercentInput.setText(String.valueOf(discount.getDiscountInPercentage()));
        int focus = discountDG02_NameInput.getText().toString().length();
        discountDG02_NameInput.requestFocus();
        discountDG02_NameInput.setSelection(focus);

        //On Apply Button
        discountDG02_ApplyBtn.setOnClickListener(apply -> {
            String nameInput = discountDG02_NameInput.getText().toString();
            String percentInput = discountDG02_PercentInput.getText().toString();
            String dcName = discount.getDiscountName();
            int dcPercent = discount.getDiscountInPercentage();
            List<String> listOfAllDiscounts = DCHelper.getDiscountNames(realm);
            if(listOfAllDiscounts.contains(dcName)){
                listOfAllDiscounts.remove(dcName);
            }
            if(dcName.equals(nameInput) && dcPercent == Integer.parseInt(percentInput)){
                ToastHelper.show(getActivity(), "No changes were made");
                discountDG02_NameInput.setText("");
                discountDG02_PercentInput.setText("");
                discountDG02.dismiss();
            } else if (dcName.equals(nameInput) && dcPercent != Integer.parseInt(percentInput)){
                OpenDiscountInstance.toEditDiscount(discount.getDiscountName(), nameInput, Integer.parseInt(percentInput));
                load_RecyclerView();
                discountDG02_NameInput.setText("");
                discountDG02_PercentInput.setText("");
                discountDG02.dismiss();
            } else if (listOfAllDiscounts.contains(nameInput)){
                discountDG02_NameInput.setError("Name already exists");
            } else if(Integer.parseInt(percentInput) > 100) {
                discountDG02_PercentInput.setError("Value cannot be greater than 100%");
            } else {
                OpenDiscountInstance.toEditDiscount(discount.getDiscountName(), nameInput, Integer.parseInt(percentInput));
                load_RecyclerView();
                discountDG02_NameInput.setText("");
                discountDG02_PercentInput.setText("");
                discountDG02_NameInput.setError(null);
                discountDG02_PercentInput.setError(null);
                discountDG02.dismiss();
            }
        });

        //On Delete Button
        discountDG02_DeleteBtn.setOnClickListener(delete -> {
            bundle.setDialogDestinationNo(3);
            load_DG03Functionalities(bundle);
            discountDG02.dismiss();
            discountDG03.show();
        });

        //On Close Button
        closeDG02Btn.setOnClickListener(close -> {
            discountDG02.dismiss();
        });

    }

    //Delete Discount
    private void load_DG03Functionalities(DialogBundle bundle){
        //Unpack Bundle
        String discount = bundle.getDiscount().getDiscountName();
        //Set Discount Name
        discountDG03_discountName.setText(discount + "?");

        //On Yes Btn
        discountDG03_YesBtn.setOnClickListener(yes -> {
            OpenDiscountInstance.toDeleteDiscount(discount);
            load_RecyclerView();
            discountDG03.dismiss();
        });

        //On No Btn
        discountDG03_NoBtn.setOnClickListener(no -> {
            bundle.setDialogDestinationNo(2);
            load_DG02Functionalities(bundle);
            discountDG03.dismiss();
            discountDG02.show();
        });

        //On Close Btn
        closeDG03Btn.setOnClickListener(close -> {
            load_DG02Functionalities(bundle);
            discountDG03.dismiss();
            discountDG02.show();
        });
    }

    @Override
    public void load_DGContents(DialogBundle bundle) {
        load_DG02Functionalities(bundle);
        discountDG02.show();
    }
}
