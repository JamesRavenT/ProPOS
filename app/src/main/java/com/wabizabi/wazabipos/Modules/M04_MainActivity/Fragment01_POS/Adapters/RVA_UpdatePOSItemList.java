package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Adapters;

import com.wabizabi.wazabipos.Database.Schemas.ProductItem;

import io.realm.RealmResults;

public interface RVA_UpdatePOSItemList {
    public void callback(int position,  RealmResults<ProductItem> products);
}
