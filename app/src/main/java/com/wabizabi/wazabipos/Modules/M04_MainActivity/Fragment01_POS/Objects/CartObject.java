package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Objects;

public class CartObject {
    String itemName;
    double itemPrice;

    public CartObject(){}
    public CartObject(String itemName, double itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public String getItemName() { return itemName; }
    public double getItemPrice() { return itemPrice; }

    public void setItemName(String itemName) { this.itemName = itemName; }
    public void setItemPrice(double itemPrice) { this.itemPrice = itemPrice; }
}
