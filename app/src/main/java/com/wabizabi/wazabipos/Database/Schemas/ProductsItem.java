package com.wabizabi.wazabipos.Database.Schemas;

import org.bson.types.ObjectId;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ProductsItem extends RealmObject {
    @PrimaryKey
    ObjectId _id;
    String itemCategory;
    String itemName;
    double itemPrice;

    public ProductsItem(){}
    public ProductsItem(ObjectId _id, String belongsToCategory, String itemName, int itemPrice) {
        this._id = _id;
        this.itemCategory = belongsToCategory;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public String getItemCategory() { return itemCategory; }
    public String getItemName() { return itemName; }
    public double getItemPrice() { return itemPrice; }

    public void setItemCategory(String itemCategory) { this.itemCategory = itemCategory; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public void setItemPrice(double itemPrice) { this.itemPrice = itemPrice;}
}
