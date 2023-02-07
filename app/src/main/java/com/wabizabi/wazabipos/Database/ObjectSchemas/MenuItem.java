package com.wabizabi.wazabipos.Database.ObjectSchemas;

import org.bson.types.ObjectId;

public class MenuItem {
    ObjectId id;
    int itemIcon;
    String itemImage;
    String itemCategory;
    String itemWebName;
    String itemPOSName;
    double itemPrice;

    public MenuItem(){}

    public MenuItem(ObjectId id, int itemIcon, String itemCategory, String itemWebName, String itemPOSName, double itemPrice) {
        this.id = id;
        this.itemIcon = itemIcon;
        this.itemCategory = itemCategory;
        this.itemWebName = itemWebName;
        this.itemPOSName = itemPOSName;
        this.itemPrice = itemPrice;
    }

    public MenuItem(int itemIcon, String itemCategory, String itemWebName, String itemPOSName, double itemPrice) {
        this.itemIcon = itemIcon;
        this.itemCategory = itemCategory;
        this.itemWebName = itemWebName;
        this.itemPOSName = itemPOSName;
        this.itemPrice = itemPrice;
    }

    public ObjectId getId() { return id; }
    public int getItemIcon() { return itemIcon; }
    public String getItemImage() { return itemImage; }
    public String getItemCategory() { return itemCategory; }
    public String getItemWebName() { return itemWebName; }
    public String getItemPOSName() { return itemPOSName; }
    public double getItemPrice() { return itemPrice; }

    public void setId(ObjectId id) { this.id = id; }
    public void setItemIcon(int itemIcon) { this.itemIcon = itemIcon; }
    public void setItemImage(String itemImage) { this.itemImage = itemImage; }
    public void setItemCategory(String itemCategory) { this.itemCategory = itemCategory; }
    public void setItemWebName(String itemWebName) { this.itemWebName = itemWebName; }
    public void setItemPOSName(String itemPOSName) { this.itemPOSName = itemPOSName; }
    public void setItemPrice(double itemPrice) { this.itemPrice = itemPrice;}
}
