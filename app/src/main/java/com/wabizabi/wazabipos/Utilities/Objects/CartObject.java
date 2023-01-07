package com.wabizabi.wazabipos.Utilities.Objects;

public class CartObject {
    int itemImage;
    String itemName;
    double itemPrice;


    public CartObject(){}
    public CartObject(int itemImage, String itemName, double itemPrice) {
        this.itemImage = itemImage;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public String getItemName() { return itemName; }
    public double getItemPrice() { return itemPrice; }
    public int getItemImage() { return itemImage; }

    public void setItemName(String itemName) { this.itemName = itemName; }
    public void setItemPrice(double itemPrice) { this.itemPrice = itemPrice; }
}
