package com.wabizabi.wazabipos.Database.RealmSchemas;

import org.bson.types.ObjectId;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RealmMenuItem extends RealmObject {
    @PrimaryKey
    ObjectId _id;
    int itemIcon;
    String itemImage;
    String itemCategory;
    String itemWebName; // Web
    String itemPOSName;
    double itemPrice;

    public RealmMenuItem(){}

    public ObjectId get_id() { return _id; }
    public int getItemIcon() { return itemIcon; }
    public String getItemImage() { return itemImage; }
    public String getItemCategory() { return itemCategory; }
    public String getItemWebName() { return itemWebName; }
    public String getItemPOSName() { return itemPOSName; }
    public double getItemPrice() { return itemPrice; }

    public void setItemIcon(int itemIcon) { this.itemIcon = itemIcon; }
    public void setItemImage(String itemImage) { this.itemImage = itemImage; }
    public void setItemCategory(String itemCategory) { this.itemCategory = itemCategory; }
    public void setItemWebName(String itemWebName) { this.itemWebName = itemWebName; }
    public void setItemPOSName(String itemPOSName) { this.itemPOSName = itemPOSName; }
    public void setItemPrice(double itemPrice) { this.itemPrice = itemPrice; }
}
