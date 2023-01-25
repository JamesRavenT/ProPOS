package com.wabizabi.wazabipos.Database.RealmSchemas;

import org.bson.types.ObjectId;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RealmStockItem extends RealmObject {
    @PrimaryKey
    ObjectId _id;
    int itemImage;
    String itemCategory;
    String itemName;
    int itemAmount;
    String unitOfMeasurement;

    public RealmStockItem(){}

    public RealmStockItem(int itemImage, String itemCategory, String itemName, int itemAmount, String itemUnit) {
        this.itemImage = itemImage;
        this.itemCategory = itemCategory;
        this.itemName = itemName;
        this.itemAmount = itemAmount;
        this.unitOfMeasurement = itemUnit;
    }

    public int getItemImage() { return itemImage; }
    public String getItemCategory() { return itemCategory; }
    public String getItemName() { return itemName; }
    public int getItemAmount() { return itemAmount; }
    public String getUnitOfMeasurement() { return unitOfMeasurement; }

    public void setItemImage(int itemImage) { this.itemImage = itemImage; }
    public void setItemCategory(String itemCategory) { this.itemCategory = itemCategory; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public void setItemAmount(int itemAmount) { this.itemAmount = itemAmount; }
    public void setUnitOfMeasurement(String unitOfMeasurement) { this.unitOfMeasurement = unitOfMeasurement; }
}
