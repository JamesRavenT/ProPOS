package com.wabizabi.wazabipos.Database.RealmSchemas;

import org.bson.types.ObjectId;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RealmStockItem extends RealmObject {
    @PrimaryKey
    ObjectId _id;
    int itemIcon;
    String itemCategory;
    String itemName;
    int itemAmount;
    String unitOfMeasurement;

    public RealmStockItem(){}

    public RealmStockItem(int itemImage, String itemCategory, String itemName, int itemAmount, String itemUnit) {
        this.itemIcon = itemImage;
        this.itemCategory = itemCategory;
        this.itemName = itemName;
        this.itemAmount = itemAmount;
        this.unitOfMeasurement = itemUnit;
    }

    public int getItemIcon() { return itemIcon; }
    public String getItemCategory() { return itemCategory; }
    public String getItemName() { return itemName; }
    public int getItemAmount() { return itemAmount; }
    public String getUnitOfMeasurement() { return unitOfMeasurement; }

    public void setItemIcon(int itemIcon) { this.itemIcon = itemIcon; }
    public void setItemCategory(String itemCategory) { this.itemCategory = itemCategory; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public void setItemAmount(int itemAmount) { this.itemAmount = itemAmount; }
    public void setUnitOfMeasurement(String unitOfMeasurement) { this.unitOfMeasurement = unitOfMeasurement; }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }
}
