package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Interfaces;

import com.wabizabi.wazabipos.Database.Schemas.ProductsItem;
import com.wabizabi.wazabipos.Database.Schemas.StockItem;

import io.realm.RealmResults;

public interface Update_ProductsItemList {

    public void refreshItemList(int position, RealmResults<ProductsItem> products);
}
