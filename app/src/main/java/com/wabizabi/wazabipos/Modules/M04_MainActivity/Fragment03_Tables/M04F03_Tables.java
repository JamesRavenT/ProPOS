package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Tables;

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

import com.wabizabi.wazabipos.Database.Instances.OpenTableInstance;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmTable;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Tables.Adapters.M04F03_TablesRVA;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Interfaces.DialogLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.DialogBuilder;
import com.wabizabi.wazabipos.Utilities.Libraries.ListBuilder;
import com.wabizabi.wazabipos.Utilities.Libraries.ToastMessage;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmResults;

public class M04F03_Tables extends Fragment implements DialogLoader {
    //--DATABASE--//
    Realm realm = Realm.getDefaultInstance();

    //--CREATE BUTTON--//
    ImageView createBtn;

    //--SEARCH BAR--//
    EditText searchbar;

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
        searchbar = v.findViewById(R.id.M04F03_SearchBarInput);
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
        Map<String, Integer> listOfAllTables = new LinkedHashMap<>();
        RealmResults<RealmTable> queriedTables = realm.where(RealmTable.class).sort("tableName").findAll();
        for(RealmTable query : queriedTables){
            if(listOfAllTables.containsKey(query.getTableName())){
                listOfAllTables.put(query.getTableName(), listOfAllTables.get(query.getTableName()) + 1);
            } else {
                listOfAllTables.put(query.getTableName(), 1);
            }
        }
        listOfTables = new ArrayList<>(listOfAllTables.keySet());

        //Initialize RecyclerView
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        tablesRVA = new M04F03_TablesRVA(getActivity(), realm, listOfTables, this);
        tablesRV.setAdapter(tablesRVA);
        tablesRV.setLayoutManager(layout);
    }

    private void load_FilteredRecyclerView(String input){
        //Initialize RecyclerView Items
        List<String> filteredTables = new ArrayList<>();
        for(String table : listOfTables){
            if(table.toLowerCase().contains(input.toLowerCase())){
                filteredTables.add(table);
            }
        }

        //Initialize RecyclerView
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
            List<String> listOfTables = ListBuilder.getTableNames(realm);
            if(listOfTables.contains(input)){
                tableDG01_NameInput.setError("Name already Exists");
            } else {
                OpenTableInstance.toCreateTable(input);
                tableDG01_NameInput.setText("");
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
    private void load_DG02Functionalities(String name){
        //Set Edit Text
        tableDG02_NameInput.setText(name);

        //On Apply Btn
        tableDG02_ApplyBtn.setOnClickListener(apply -> {
            //Extract String
            String input = tableDG02_NameInput.getText().toString();
            List<String> listOfTables = ListBuilder.getTableNames(realm);
            if(name.equals(input)){
                ToastMessage.show(getActivity(), "No Changes were made");
                tableDG02.dismiss();
            } else if(listOfTables.contains(input)){
                tableDG02_NameInput.setError("Name Already Exists");
            } else {
                OpenTableInstance.toEditTable(name, input);
                load_RecyclerView();
                tableDG02_NameInput.setText("");
                tableDG02.dismiss();
            }
        });

        //On Delete Btn
        tableDG02_DeleteBtn.setOnClickListener(delete -> {
            load_DG03Functionalitites(name);
            tableDG02.dismiss();
            tableDG03.show();
        });

        //On Close Btn
        closeDG02Btn.setOnClickListener(close -> {
            tableDG02.dismiss();
        });
    }

    //Delete Table
    private void load_DG03Functionalitites(String name){
        //Set Table Name
        tableDG03_TableName.setText(name);

        //On Yes Btn
        tableDG03_YesBtn.setOnClickListener(yes -> {
            OpenTableInstance.toDeleteTable(name);
            load_RecyclerView();
            tableDG03.dismiss();
        });

        //On No Btn
        tableDG03_NoBtn.setOnClickListener(no -> {
            load_DG02Functionalities(name);
            tableDG03.dismiss();
            tableDG02.show();
        });

        //On Close Btn
        closeDG03Btn.setOnClickListener(close -> {
            load_DG02Functionalities(name);
            tableDG03.dismiss();
            tableDG02.show();
        });
    }

    @Override
    public void load_DGContents(int dialogNo, int image, String name) {
        load_DG02Functionalities(name);
        tableDG02.show();
    }

}
