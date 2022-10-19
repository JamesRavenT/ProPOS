package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.Items.CategoryItemSelector;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.Schemas.ProductsList;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.Items.CategoryItemSelector.Adapter.M0F03OPICS_SelectItemCategoryRVA;
import com.wabizabi.wazabipos.R;

import io.realm.Realm;
import io.realm.RealmResults;

public class M04F03OPICS_SelectItemCategory extends Fragment {
    RealmResults<ProductsList> listOfProductsCategories;
    RecyclerView selectItemCategoryRV;
    Realm realm;
    RecyclerView.Adapter selectItemCategoryRVA;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag03_products_operation_crud_itemcategoryselector, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        init_Views(v);
        init_DB();
        init_RecyclerView();
    }
    private void init_Views(View v){
        selectItemCategoryRV = v.findViewById(R.id.M04F03OPICS_RecyclerView);
    }
    private void init_DB(){
        realm = Realm.getDefaultInstance();
    }
    private void init_RecyclerView(){
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        listOfProductsCategories = realm.where(ProductsList.class).findAll();
        selectItemCategoryRVA = new M0F03OPICS_SelectItemCategoryRVA(listOfProductsCategories, getActivity());
        selectItemCategoryRV.setLayoutManager(layout);
        selectItemCategoryRV.setAdapter(selectItemCategoryRVA);

    }}
