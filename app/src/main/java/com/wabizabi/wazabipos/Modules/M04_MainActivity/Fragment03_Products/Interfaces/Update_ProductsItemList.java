package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Interfaces;

import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuItem;

import io.realm.RealmResults;

public interface Update_ProductsItemList {

    public void refreshItemList(int position, RealmResults<RealmMenuItem> products);
}
