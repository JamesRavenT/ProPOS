package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Interfaces;

import com.wabizabi.wazabipos.Database.Schemas.ProductsItem;
import com.wabizabi.wazabipos.Database.Schemas.StockItem;

import io.realm.RealmResults;

public interface Update_StocksItemList {
    public void refreshItemList(int position, RealmResults<StockItem> products);
}
