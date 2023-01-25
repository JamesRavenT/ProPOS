package com.wabizabi.wazabipos.Database.ObjectSchemas;

import org.bson.types.ObjectId;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class MenuItem {
    int itemImage;
    String itemCategory;
    String itemName;
    double itemPrice;

    public MenuItem(){}

    public MenuItem(int itemImage, String itemName, double itemPrice) {
        this.itemImage = itemImage;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public MenuItem(int itemImage, String itemCategory, String itemName, double itemPrice) {
        this.itemImage = itemImage;
        this.itemCategory = itemCategory;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public int getItemImage() { return itemImage; }
    public String getItemCategory() { return itemCategory; }
    public String getItemName() { return itemName; }
    public double getItemPrice() { return itemPrice; }


    public void setItemImage(int itemImage) { this.itemImage = itemImage; }
    public void setItemCategory(String itemCategory) { this.itemCategory = itemCategory; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public void setItemPrice(double itemPrice) { this.itemPrice = itemPrice;}
}
