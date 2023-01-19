package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.Items.CategoryItemSelector;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.RealmSchemas.StockList;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.Items.CategoryItemSelector.Adapter.M04F02OPICS_ItemCategoriesRVA;
import com.wabizabi.wazabipos.R;

import io.realm.Realm;
import io.realm.RealmResults;

public class M04F02OPICS_SelectItemCategory extends Fragment {
    RealmResults<StockList> listOfStockCategories;
    RecyclerView selectItemCategoryRV;
    Realm realm;
    RecyclerView.Adapter selectItemCategoryRVA;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag02_stocks_operation_crud_itemcategoryselector, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    public void init_FragmentFunctionalities(View v){
        init_Views(v);
        init_Database();
        init_RecylerViews();
    }

    public void init_Views(View v){
        selectItemCategoryRV = v.findViewById(R.id.M04F02OPICS_RecyclerView);
    }

    public void init_Database(){
        realm = Realm.getDefaultInstance();
    }

    public void init_RecylerViews(){
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        listOfStockCategories = realm.where(StockList.class).findAll();
        selectItemCategoryRVA = new M04F02OPICS_ItemCategoriesRVA(listOfStockCategories, getActivity());
        selectItemCategoryRV.setAdapter(selectItemCategoryRVA);
        selectItemCategoryRV.setLayoutManager(layout);
    }
}
