package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Activity_Main.currentStockCategory;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Activity_Main.currentStockCategoryIndex;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Adapters.RVA_StockCategory.listOfStockCategories;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Adapters.RVA_StockItem.listOfStockItems;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.Schemas.StockItem;
import com.wabizabi.wazabipos.Database.Schemas.StockList;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Adapters.RVA_POSItem;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Adapters.RVA_StockCategory;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Adapters.RVA_StockItem;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Interfaces.Update_StocksItemList;
import com.wabizabi.wazabipos.R;

import io.realm.Realm;
import io.realm.RealmResults;

public class Fragment02_Stocks extends Fragment implements Update_StocksItemList {

    Realm realm;
    RecyclerView stockCategoryRV, stockItemRV;
    RecyclerView.Adapter stockCategoryRVA, stockItemRVA;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag02_stocks, container, false);
        setDBInstance();
        setViews(v);
        setRecyclerView();
        return v;
    }

    private void setDBInstance(){
        realm = Realm.getDefaultInstance();
    }

    private void setViews(View v){
        stockCategoryRV = v.findViewById(R.id.Stocks_CategoryRV);
        stockItemRV = v.findViewById(R.id.Stocks_ItemRV);
    }

    private void setRecyclerView(){
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
