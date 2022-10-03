package com.wabizabi.wazabipos.Database.Schemas;

import org.bson.types.ObjectId;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ProductItem extends RealmObject {
    @PrimaryKey
    ObjectId _id;
    String ItemCategory;
    String ItemName;
    double ItemPrice;

    public ProductItem(){}
    public ProductItem(ObjectId _id, String belongsToCategory, String itemName, int itemPrice) {
        this._id = _id;
        this.ItemCategory = belongsToCategory;
        this.ItemName = itemName;
        this.ItemPrice = itemPrice;
    }

    public String getItemCategory() { return ItemCategory; }
    public String getItemName() { return ItemName; }
    public double getItemPrice() { return ItemPrice; }

    public void setItemCategory(String itemCategory) { this.ItemCategory = itemCategory; }
    public void setItemName(String itemName) { this.ItemName = itemName; }

    public void setItemPrice(double itemPrice) { this.ItemPrice = itemPrice;}
}
