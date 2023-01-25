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
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmDiscount;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_Discount.Adapters.M04F04_DiscountsRVA;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Interfaces.DialogLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.DialogBuilder;
import com.wabizabi.wazabipos.Utilities.Libraries.ListBuilder;
import com.wabizabi.wazabipos.Utilities.Libraries.ToastMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import io.realm.Realm;
import io.realm.RealmResults;

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
        //Initialize RecyclerView Items
        listOfDiscounts = new ArrayList<>();
        RealmResults<RealmDiscount> queriedDiscounts = realm.where(RealmDiscount.class).sort("discountName").findAll();
        for(RealmDiscount query : queriedDiscounts){
            listOfDiscounts.add(new Discount(query.getDiscountName(), query.getDiscountPercentage(), query.getLastUpdatedID(), query.getLastUpdatedText()));
        }

        //Initialize RecyclerView
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        discountsRVA = new M04F04_DiscountsRVA(getActivity(), realm, listOfDiscounts, this);
        discountsRV.setAdapter(discountsRVA);
        discountsRV.setLayoutManager(layout);
    }

    private void load_FilteredRecyclerView(String input){
        //Initialize Filtered RecyclerView Items
        List<Discount> filteredDiscounts = new ArrayList<>();
        for(Discount discount : listOfDiscounts){
            if(discount.getDiscountName().toLowerCase().contains(input.toLowerCase())){
                filteredDiscounts.add(discount);
            }
        }

        //Initialize RecyclerView
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        discountsRVA = new M04F04_DiscountsRVA(getActivity(), realm, filteredDiscounts, this);
        discountsRV.setAdapter(discountsRVA);
        discountsRV.setLayoutManager(layout);
    }

    private void init_Dialogs(){
        //--DG01--//
        discountDG01 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag04_discounts_dg01_creatediscount);
        discountDG01_NameInput = discountDG01.findViewById(R.id.M04F04D01_DiscountNameInput);
        discountDG01_percentInput = discountDG01.findViewById(R.id.M04F04D01_DiscountPercentageInput);
        discountDG01_ConfirmBtn = discountDG01.findViewById(R.id.M04F04D01_ConfirmBtn);
        closeDG01Btn = discountDG01.findViewById(R.id.M04F04D01_CloseDGBtn);

        //--DG02--//
        discountDG02 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag04_discounts_dg02_editdiscount);
        discountDG02_NameInput = discountDG02.findViewById(R.id.M04F04D02_DiscountNameInput);
        discountDG02_PercentInput = discountDG02.findViewById(R.id.M04F04D02_DiscountPercentageInput);
        discountDG02_ApplyBtn = discountDG02.findViewById(R.id.M04F04D02_ApplyChangesBtn);
        discountDG02_DeleteBtn = discountDG02.findViewById(R.id.M04F04D02_DeleteBtn);
        closeDG02Btn = discountDG02.findViewById(R.id.M04F04D02_CloseDGBtn);

        //--DG03--//
        discountDG03 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag04_discounts_dg03_deletediscount);
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
            String input01 = discountDG01_NameInput.getText().toString();
            String input02 = discountDG01_percentInput.getText().toString();
            List<String> listOfAllDiscounts = ListBuilder.getDiscountNames(realm);
            if(listOfAllDiscounts.contains(input01)){
                discountDG01_NameInput.setError("Name already exists");
            } else {
                OpenDiscountInstance.toCreateDiscount(input01, Integer.parseInt(input02));
                load_RecyclerView();
                discountDG01_NameInput.setText("");
                discountDG01_percentInput.setText("");
                discountDG01.dismiss();
            }
        });

        //On Close Btn
        closeDG01Btn.setOnClickListener(close -> {
            discountDG01.dismiss();
        });
    }

    //Edit Discount
    private void load_DG02Functionalities(String name){
        //Set Text
        RealmDiscount discount = realm.where(RealmDiscount.class).equalTo("discountName", name).findFirst();
        discountDG02_NameInput.setText(discount.getDiscountName());
        discountDG02_PercentInput.setText(String.valueOf(discount.getDiscountPercentage()));

        //On Apply Button
        discountDG02_ApplyBtn.setOnClickListener(apply -> {
            String input01 = discountDG02_NameInput.getText().toString();
            String input02 = discountDG02_PercentInput.getText().toString();
            List<String> listOfAllDiscounts = ListBuilder.getDiscountNames(realm);
            if(name.equals(input01) && discount.getDiscountPercentage() == Integer.parseInt(input02)){
                ToastMessage.show(getActivity(), "No changes were made");
                discountDG02_NameInput.setText("");
                discountDG02_PercentInput.setText("");
                discountDG02.dismiss();
            } else if (name.equals(input01) && discount.getDiscountPercentage() == Integer.parseInt(input02)){
                OpenDiscountInstance.toEditDiscount(name, input01, Integer.parseInt(input02));
                load_RecyclerView();
                discountDG02_NameInput.setText("");
                discountDG02_PercentInput.setText("");
                discountDG02.dismiss();
            } else if (listOfAllDiscounts.contains(input01)){
                discountDG02_NameInput.setError("Name already exists");
            } else {
                OpenDiscountInstance.toEditDiscount(name, input01, Integer.parseInt(input02));
                load_RecyclerView();
                discountDG02_NameInput.setText("");
                discountDG02_PercentInput.setText("");
                discountDG02.dismiss();
            }
        });

        //On Delete Button
        discountDG02_DeleteBtn.setOnClickListener(delete -> {
            load_DG03Functionalities(name);
            discountDG02.dismiss();
            discountDG03.show();
        });

        //On Close Button
        closeDG02Btn.setOnClickListener(close -> {
            discountDG02.dismiss();
        });

    }

    //Delete Discount
    private void load_DG03Functionalities(String name){
        //Set Discount Name
        discountDG03_discountName.setText(name);

        //On Yes Btn
        discountDG03_YesBtn.setOnClickListener(yes -> {
            OpenDiscountInstance.toDeleteDiscount(name);
            load_RecyclerView();
            discountDG03.dismiss();
        });

        //On No Btn
        discountDG03_NoBtn.setOnClickListener(no -> {
            load_DG02Functionalities(name);
            discountDG03.dismiss();
            discountDG02.show();
        });

        //On Close Btn
        closeDG03Btn.setOnClickListener(close -> {
            load_DG02Functionalities(name);
            discountDG03.dismiss();
            discountDG02.show();
        });
    }

    @Override
    public void load_DGContents(int dialogNo, int image, String name) {
        load_DG02Functionalities(name);
        discountDG02.show();
    }
}
