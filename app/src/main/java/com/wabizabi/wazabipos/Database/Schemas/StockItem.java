package com.wabizabi.wazabipos.Database.Schemas;

import org.bson.types.ObjectId;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class StockItem extends RealmObject {
    @PrimaryKey
    ObjectId _id;
    String itemName;
    int itemAmount;

    public StockItem(){}

    public StockItem(ObjectId _id, String itemName, int itemAmount) {
        this._id = _id;
        this.itemName = itemName;
        this.itemAmount = itemAmount;
    }

    public String getItemName() { return itemName; }
    public int getItemAmount() { return itemAmount; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public void setItemAmount(int itemAmount) { this.itemAmount = itemAmount;}
}
