package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Interfaces;

import com.wabizabi.wazabipos.Database.Schemas.ProductsItem;

import io.realm.RealmResults;

public interface Update_POSItemList {
    public void refreshItemList(int position, RealmResults<ProductsItem> products);
}
