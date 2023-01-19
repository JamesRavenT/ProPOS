package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Adapters.M04F02_CategoryRVA.listOfStockCategories;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Adapters.M04F02_ItemRVA.listOfStockItems;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.M04F02OP_CRUD.operationForM04F02;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.Instances.OpenStocksInstance;
import com.wabizabi.wazabipos.Database.RealmSchemas.StockItem;
import com.wabizabi.wazabipos.Database.RealmSchemas.StockList;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Adapters.M04F02_CategoryRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Adapters.M04F02_ItemRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Interfaces.Update_StocksCurrentCategory;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Interfaces.Update_StocksItemList;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.M04F02OP_CRUD;
import com.wabizabi.wazabipos.R;

import io.realm.Realm;
import io.realm.RealmResults;

public class M04F02_Stocks extends Fragment implements Update_StocksItemList, Update_StocksCurrentCategory {
    public static int M04F02_CurrentCategoryIndex = -1;
    public static int M04F02_CurrentItemIndex = -1;
    public static String M04F02_CurrentCategory;
    public static String M04F02_CurrentItem;

    Realm realm;
    Dialog dialogCreateCRUD, dialogCategoryCRUD, dialogItemCRUD;
    ImageButton createButton;
    RecyclerView stockCategoryRV, stockItemRV;
    RecyclerView.Adapter stockCategoryRVA, stockItemRVA;
    //--DIALOG--//
    TextView createCategoryText, createItemText;
    TextView categoryNameText, categoryViewText, categoryEditText, categoryDeleteText;
    TextView itemNameText, itemViewText, itemEditText, itemDeleteText;

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
        init_Dialogs();
        init_RecyclerViews();
    }

    private void init_DBInstance(){
        realm = Realm.getDefaultInstance();
    }

    private void init_Views(View v){
        createButton = v.findViewById(R.id.M04F02_CreateButton);
        stockCategoryRV = v.findViewById(R.id.M04F02_CategoryRV);
        stockItemRV = v.findViewById(R.id.M04F02_ItemRV);
    }

    private void init_Dialogs(){
        //--ADD--//
        dialogCreateCRUD = new Dialog(getActivity());
        dialogCreateCRUD.setContentView(R.layout.act04_main_frag02_stocks_window_adddialog);
        dialogCreateCRUD.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        createCategoryText = dialogCreateCRUD.findViewById(R.id.M04F02OPDA_CategoryText);
        createItemText = dialogCreateCRUD.findViewById(R.id.M04F02OPDA_ItemText);
        createCategoryText.setOnClickListener(v -> {
            operationForM04F02 = "Create Category";
            dialogCreateCRUD.dismiss();
            startActivity(new Intent(getActivity(), M04F02OP_CRUD.class));
        });
        createItemText.setOnClickListener(v -> {
            operationForM04F02 = "Create Item";
            dialogCreateCRUD.dismiss();
            startActivity(new Intent(getActivity(), M04F02OP_CRUD.class));
        });

        //--CATEGORY--//
        dialogCategoryCRUD = new Dialog(getActivity());
        dialogCategoryCRUD.setContentView(R.layout.act04_main_frag02_stocks_window_categorydialog);
        dialogCategoryCRUD.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        categoryNameText = dialogCategoryCRUD.findViewById(R.id.M04F02OPCD_CategoryName);
        categoryViewText = dialogCategoryCRUD.findViewById(R.id.M04F02OPCD_ViewText);
        categoryEditText = dialogCategoryCRUD.findViewById(R.id.M04F02OPCD_EditText);
        categoryDeleteText = dialogCategoryCRUD.findViewById(R.id.M04F02OPCD_DeleteText);
        categoryViewText.setOnClickListener(v -> {
            operationForM04F02 = "Read Category";
            dialogCategoryCRUD.dismiss();
            startActivity(new Intent(getActivity(), M04F02OP_CRUD.class));
        });
        categoryEditText.setOnClickListener(v -> {
            operationForM04F02 = "Edit Category";
            dialogCategoryCRUD.dismiss();
            startActivity(new Intent(getActivity(), M04F02OP_CRUD.class));
        });
        categoryDeleteText.setOnClickListener(v -> {
            OpenStocksInstance.toDeleteCategory();
            M04F02_CurrentCategoryIndex = -1;
            stockCategoryRVA.notifyDataSetChanged();
            stockItemRVA.notifyDataSetChanged();
            dialogCategoryCRUD.dismiss();
            Toast.makeText(getActivity(), "Deleted", Toast.LENGTH_SHORT).show();
        });

        //--ITEM--//
        dialogItemCRUD = new Dialog(getActivity());
        dialogItemCRUD.setContentView(R.layout.act04_main_frag02_stocks_window_itemdialog);
        dialogItemCRUD.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        itemNameText = dialogItemCRUD.findViewById(R.id.M04F02OPDI_ItemName);
        itemViewText = dialogItemCRUD.findViewById(R.id.M04F02OPDI_ViewText);
        itemEditText = dialogItemCRUD.findViewById(R.id.M04F02OPDI_EditText);
        itemDeleteText = dialogItemCRUD.findViewById(R.id.M04F02OPDI_DeleteText);
        itemViewText.setOnClickListener(v -> {
            operationForM04F02 = "Read Item";
            dialogItemCRUD.dismiss();
            startActivity(new Intent(getActivity(), M04F02OP_CRUD.class));
        });
        itemEditText.setOnClickListener(v -> {
            operationForM04F02 = "Edit Item";
            dialogItemCRUD.dismiss();
            startActivity(new Intent(getActivity(), M04F02OP_CRUD.class));
        });
        itemDeleteText.setOnClickListener(v -> {
            OpenStocksInstance.toDeleteItem(M04F02_CurrentCategory, M04F02_CurrentItemIndex);
            stockItemRVA.notifyDataSetChanged();
            dialogItemCRUD.dismiss();
            Toast.makeText(getActivity(), "Deleted", Toast.LENGTH_SHORT).show();
        });

    }

    private void init_Buttons(){
        createButton.setOnClickListener(v -> {
            dialogCreateCRUD.show();
        });
    }

    private void init_RecyclerViews(){
        //--CATEGORY--//
        LinearLayoutManager categoryLayout = new LinearLayoutManager(getActivity());
        categoryLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        listOfStockCategories = realm.where(StockList.class).sort("categoryName").findAll();
        stockCategoryRVA = new M04F02_CategoryRVA(this,this, dialogCategoryCRUD, getActivity(), realm);
        stockCategoryRV.setLayoutManager(categoryLayout);
        stockCategoryRV.setAdapter(stockCategoryRVA);

        //--ITEM--//
        LinearLayoutManager itemLayout = new LinearLayoutManager(getActivity());
        itemLayout.setOrientation(LinearLayoutManager.VERTICAL);
        listOfStockItems = realm.where(StockItem.class).equalTo("itemCategory", M04F02_CurrentCategory).sort("itemName").findAll();
        stockItemRVA = new M04F02_ItemRVA(dialogItemCRUD, getActivity(), realm);
        stockItemRV.setLayoutManager(itemLayout);
        stockItemRV.setAdapter(stockItemRVA);
    }

    @Override
    public void refreshItemList(int position, RealmResults<StockItem> products) {
        try(Realm realm = Realm.getDefaultInstance()){
            stockItemRVA = new M04F02_ItemRVA(dialogItemCRUD, getActivity(), realm);
            stockItemRVA.notifyDataSetChanged();
            stockItemRV.setAdapter(stockItemRVA);
        }
    }

    @Override
    public void updateCurrentStock() {
        categoryNameText.setText(M04F02_CurrentCategory);
    }

    @Override
    public void onResume() {
        stockCategoryRVA.notifyDataSetChanged();
        stockItemRVA.notifyDataSetChanged();
        super.onResume();
    }


}
