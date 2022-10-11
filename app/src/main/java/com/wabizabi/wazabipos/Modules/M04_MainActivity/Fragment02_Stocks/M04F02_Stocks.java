package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Activity_Main.currentStockCategory;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Activity_Main.currentStockCategoryIndex;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Adapters.RVA_StockCategory.listOfStockCategories;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Adapters.RVA_StockItem.listOfStockItems;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.SubModule.M04F02SM01_CRUD.setOperationForM04F02;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.Schemas.StockItem;
import com.wabizabi.wazabipos.Database.Schemas.StockList;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Adapters.RVA_StockCategory;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Adapters.RVA_StockItem;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Interfaces.Update_StocksItemList;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.SubModule.M04F02SM01_CRUD;
import com.wabizabi.wazabipos.R;

import io.realm.Realm;
import io.realm.RealmResults;

public class M04F02_Stocks extends Fragment implements Update_StocksItemList {

    Realm realm;
    ImageButton newCategoryBtn, newItemBtn;
    RecyclerView stockCategoryRV, stockItemRV;
    RecyclerView.Adapter stockCategoryRVA, stockItemRVA;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag02_stocks, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        init_Views(v);
        init_DBInstance();
        init_Buttons();
        init_RecyclerViews();
    }

    private void init_DBInstance(){
        realm = Realm.getDefaultInstance();
    }

    private void init_Views(View v){
        //--BUTTONS--//
        newCategoryBtn = v.findViewById(R.id.M04F02_NewCategoryButton);
        newItemBtn = v.findViewById(R.id.M04F02_NewItemButton);
        //--RECYLERVIEWS--//
        stockCategoryRV = v.findViewById(R.id.M04F02_CategoryRV);
        stockItemRV = v.findViewById(R.id.M04F02_ItemRV);
    }

    private void init_Buttons(){
        newCategoryBtn.setOnClickListener(v -> {
            setOperationForM04F02 = "Create Category";
            startActivity(new Intent(getActivity(), M04F02SM01_CRUD.class));
        });

        newItemBtn.setOnClickListener(v -> {
            setOperationForM04F02 = "Create Item";
            startActivity(new Intent(getActivity(), M04F02SM01_CRUD.class));
        });
    }

    private void init_RecyclerViews(){
        //--CATEGORY--//
        LinearLayoutManager categoryLayout = new LinearLayoutManager(getActivity());
        categoryLayout.setOrientation(LinearLayoutManager.HORIZONTAL);

        listOfStockCategories = realm.where(StockList.class).sort("categoryName").findAll();
        stockCategoryRVA = new RVA_StockCategory(this, getActivity(), realm);
        stockCategoryRV.setLayoutManager(categoryLayout);
        stockCategoryRV.setAdapter(stockCategoryRVA);

        //--ITEM--//
        LinearLayoutManager itemLayout = new LinearLayoutManager(getActivity());
        itemLayout.setOrientation(LinearLayoutManager.VERTICAL);
        if(currentStockCategoryIndex == -1){
            listOfStockItems = realm.where(StockItem.class).sort("itemName").findAll();
            stockItemRVA = new RVA_StockItem(getActivity(), realm);
            stockItemRV.setLayoutManager(itemLayout);
            stockItemRV.setAdapter(stockItemRVA);
        } else {
            listOfStockItems = realm.where(StockItem.class).equalTo("itemCategory", currentStockCategory).sort("itemName").findAll();
            stockItemRVA = new RVA_StockItem(getActivity(), realm);
            stockItemRV.setLayoutManager(itemLayout);
            stockItemRV.setAdapter(stockItemRVA);
        }
    }

    @Override
    public void refreshItemList(int position, RealmResults<StockItem> products) {
        try(Realm realm = Realm.getDefaultInstance()){
            stockItemRVA = new RVA_StockItem(getActivity(), realm);
            stockItemRVA.notifyDataSetChanged();
            stockItemRV.setAdapter(stockItemRVA);
        }


    }
}
