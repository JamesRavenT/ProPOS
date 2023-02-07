package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Tables;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.Instances.OpenTableInstance;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmTicket;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Tables.Adapters.M04F03_TablesRVA;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Interfaces.DialogLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.Bundles.DialogBundle;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.DialogBuilder;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.ListHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.RVHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.ToastMessage;

import java.util.List;

import io.realm.Realm;

public class M04F03_Tables extends Fragment implements DialogLoader {
    //--DATABASE--//
    Realm realm = Realm.getDefaultInstance();

    //--CREATE BUTTON--//
    ImageView createBtn;

    //--SEARCH BAR--//
    EditText searchBar;
    InputMethodManager keyBoard;

    //--RECYCLERVIEW--//
    List<String> listOfTables;
    RecyclerView tablesRV;
    RecyclerView.Adapter tablesRVA;

    //--Dialogs--//
    //--DG01 CREATE TABLE--//
    Dialog tableDG01;
    EditText tableDG01_NameInput;
    CardView tableDG01_ConfirmBtn;
    ImageView closeDG01Btn;

    //--DG02 EDIT TABLE--//
    Dialog tableDG02;
    EditText tableDG02_NameInput;
    CardView tableDG02_ApplyBtn, tableDG02_DeleteBtn;
    ImageView closeDG02Btn;

    //--DG03 DELETE TABLE--//
    Dialog tableDG03;
    TextView tableDG03_TableName;
    CardView tableDG03_YesBtn, tableDG03_NoBtn;
    ImageView closeDG03Btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag03_tables, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }


    private void init_FragmentFunctionalities(View v){
        createBtn = v.findViewById(R.id.M04F03_CreateBtn);
        searchBar = v.findViewById(R.id.M04F03_SearchBarInput);
        tablesRV = v.findViewById(R.id.M04F03_RecyclerView);

        init_Dialogs();
        load_Creation();
        load_Searchbar();
        load_RecyclerView();
    }

    private void load_Creation(){
        //On Click Add Button
        createBtn.setOnClickListener(create -> {
            load_DG01Functionalities();
            tableDG01.show();
        });

    }
    private void load_Searchbar(){
        searchBar.setText("");
        searchBar.setOnKeyListener((search, key, keyEvent) -> {
            if(key == KeyEvent.KEYCODE_ENTER){
                keyBoard = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                keyBoard.hideSoftInputFromWindow(getActivity().getWindow().getDecorView().getRootView().getWindowToken() , 0);
                return true;
            } else {
                return false;
            }
        });
        searchBar.addTextChangedListener(new TextWatcher() {
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
        listOfTables = RVHelper.getTables(realm);
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        tablesRVA = new M04F03_TablesRVA(getActivity(), realm, listOfTables, this);
        tablesRV.setAdapter(tablesRVA);
        tablesRV.setLayoutManager(layout);
    }

    private void load_FilteredRecyclerView(String input){
        //Initialize RecyclerView
        List<String> filteredTables = RVHelper.getFilteredTables(listOfTables, input);
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        tablesRVA = new M04F03_TablesRVA(getActivity(), realm, filteredTables, this);
        tablesRV.setAdapter(tablesRVA);
        tablesRV.setLayoutManager(layout);
    }

    private void init_Dialogs(){
        //--DG01--//
        tableDG01 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag03_tables_dg01_createtable);
        tableDG01_NameInput = tableDG01.findViewById(R.id.M04F03D01_TableNameInput);
        tableDG01_ConfirmBtn = tableDG01.findViewById(R.id.M04F03D01_ConfirmBtn);
        closeDG01Btn = tableDG01.findViewById(R.id.M04F03D01_CloseDGBtn);

        //--DG02--//
        tableDG02 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag03_tables_dg02_edittable);
        tableDG02_NameInput = tableDG02.findViewById(R.id.M04F03D02_TableNameInput);
        tableDG02_ApplyBtn = tableDG02.findViewById(R.id.M04F03D02_ApplyChangesBtn);
        tableDG02_DeleteBtn = tableDG02.findViewById(R.id.M04F03D02_DeleteBtn);
        closeDG02Btn = tableDG02.findViewById(R.id.M04F03D02_CloseDGBtn);

        //--DG03--//
        tableDG03 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag03_tables_dg03_deletetable);
        tableDG03_TableName = tableDG03.findViewById(R.id.M04F03D03_TableNameText);
        tableDG03_YesBtn = tableDG03.findViewById(R.id.M04F03D03_YesBtn);
        tableDG03_NoBtn = tableDG03.findViewById(R.id.M04F03D03_NoBtn);
        closeDG03Btn = tableDG03.findViewById(R.id.M04F03D03_CloseDGBtn);
    }

    //Create Table
    private void load_DG01Functionalities(){
        //Clear Edit Text
        tableDG01_NameInput.setText("");
        //On Confirm Btn
        tableDG01_ConfirmBtn.setOnClickListener(confirm -> {
            //Extract String from Edit Text
            String input = tableDG01_NameInput.getText().toString();
            List<String> listOfTables = ListHelper.getTableNames(realm);
            if(listOfTables.contains(input)){
                tableDG01_NameInput.setError("Name already Exists");
            } else {
                OpenTableInstance.toCreateTable(input);
                tableDG01_NameInput.setText("");
                tableDG01_NameInput.setError(null);
                load_RecyclerView();
                tableDG01.dismiss();
            }
        });

        //On Close Btn
        closeDG01Btn.setOnClickListener(close -> {
            tableDG01.dismiss();
        });
    }

    //Edit Table
    private void load_DG02Functionalities(DialogBundle bundle){
        //Unpack Bundle
        String table = bundle.getTableName();

        //Set Edit Text
        tableDG02_NameInput.setText(table);
        int focus = tableDG02_NameInput.getText().toString().length();
        tableDG02_NameInput.requestFocus();
        tableDG02_NameInput.setSelection(focus);

        //On Apply Btn
        tableDG02_ApplyBtn.setOnClickListener(apply -> {
            //Extract String
            String input = tableDG02_NameInput.getText().toString();
            List<String> listOfTables = ListHelper.getTableNames(realm);
            if(table.equals(input)){
                ToastMessage.show(getActivity(), "No Changes were made");
                tableDG02.dismiss();
            } else if(listOfTables.contains(input)){
                tableDG02_NameInput.setError("Name Already Exists");
            } else {
                OpenTableInstance.toEditTable(table, input);
                load_RecyclerView();
                tableDG02_NameInput.setText("");
                tableDG02_NameInput.setError(null);
                tableDG02.dismiss();
            }
        });

        //On Delete Btn
        RealmTicket ticket = realm.where(RealmTicket.class).findFirst();
        tableDG02_DeleteBtn.setOnClickListener(delete -> {
            if(ticket == null) {
                bundle.setDialogDestinationNo(3);
                load_DG03Functionalities(bundle);
                tableDG02.dismiss();
                tableDG03.show();
            } else {
                ToastMessage.show(getActivity(), "Cannot delete Tables if ticket is not empty");
            }
        });

        //On Close Btn
        closeDG02Btn.setOnClickListener(close -> {
            tableDG02.dismiss();
        });
    }

    //Delete Table
    private void load_DG03Functionalities(DialogBundle bundle){
        //Unpack Bundle
        String table = bundle.getTableName();

        //Set Table Name
        tableDG03_TableName.setText(table + "?");

        //On Yes Btn
        tableDG03_YesBtn.setOnClickListener(yes -> {
            OpenTableInstance.toDeleteTable(table);
            load_RecyclerView();
            tableDG03.dismiss();
        });

        //On No Btn
        tableDG03_NoBtn.setOnClickListener(no -> {
            bundle.setDialogDestinationNo(2);
            load_DG02Functionalities(bundle);
            tableDG03.dismiss();
            tableDG02.show();
        });

        //On Close Btn
        closeDG03Btn.setOnClickListener(close -> {
            bundle.setDialogDestinationNo(2);
            load_DG02Functionalities(bundle);
            tableDG03.dismiss();
            tableDG02.show();
        });
    }

    @Override
    public void load_DGContents(DialogBundle bundle) {
        //Unpack Bundle
        load_DG02Functionalities(bundle);
        tableDG02.show();
    }

}
