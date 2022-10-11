package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Activity_Main.currentPOSCategory;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Activity_Main.currentPOSCategoryIndex;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Activity_Main.currentProductCategory;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Activity_Main.currentProductCategoryIndex;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Adapters.RVA_POSItem.listOfPOSItems;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Adapters.RVA_ProductCategory.listOfProductCategories;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Adapters.RVA_ProductItem.listOfProductItems;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.Schemas.ProductsItem;
import com.wabizabi.wazabipos.Database.Schemas.ProductsList;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Adapters.RVA_POSItem;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Adapters.RVA_ProductCategory;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Adapters.RVA_ProductItem;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Interfaces.Update_ProductsItemList;
import com.wabizabi.wazabipos.R;

import io.realm.Realm;
import io.realm.RealmResults;

public class Fragment03_Products extends Fragment implements Update_ProductsItemList{

    Realm realm;
    RecyclerView productCategoryRV, productItemRV;
    RecyclerView.Adapter productCategoryRVA, productItemRVA;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag03_products, container, false);
        setDBInstance();
        setViews(v);
        setRecyclerView();
        return v;
    }


    private void setDBInstance(){
        realm = Realm.getDefaultInstance();
    }

    private void setViews(View v){
        productCategoryRV = v.findViewById(R.id.Products_CategoryRV);
        productItemRV = v.findViewById(R.id.Products_ItemRV);

    }

    private void setRecyclerView(){
        //--CATEGORY--//
        LinearLayoutManager categoryLayout = new LinearLayoutManager(getActivity());
        categoryLayout.setOrientation(LinearLayoutManager.HORIZONTAL);

        listOfProductCategories = realm.where(ProductsList.class).sort("categoryName").findAll();
        productCategoryRVA = new RVA_ProductCategory(this, getActivity(), realm);
        productCategoryRV.setLayoutManager(categoryLayout);
        productCategoryRV.setAdapter(productCategoryRVA);

        //--ITEM--//
        LinearLayoutManager itemLayout = new LinearLayoutManager(getActivity());
        itemLayout.setOrientation(LinearLayoutManager.VERTICAL);
        if(currentProductCategoryIndex == -1){
            listOfProductItems = realm.where(ProductsItem.class).sort("itemName").findAll();
            productItemRVA = new RVA_ProductItem(getActivity(), realm);
            productItemRV.setLayoutManager(itemLayout);
            productItemRV.setAdapter(productItemRVA);
        } else {
            listOfProductItems = realm.where(ProductsItem.class).equalTo("itemCategory", currentProductCategory).sort("itemName").findAll();
            productItemRVA = new RVA_ProductItem(getActivity(), realm);
            productItemRV.setLayoutManager(itemLayout);
            productItemRV.setAdapter(productItemRVA);

        }
    }

    @Override
    public void refreshItemList(int position, RealmResults<ProductsItem> products) {
        productItemRVA = new RVA_ProductItem(getActivity(), realm);
        productItemRVA.notifyDataSetChanged();
        productItemRV.setAdapter(productItemRVA);
    }
}
