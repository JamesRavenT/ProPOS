package com.wabizabi.wazabipos.Utilities.Objects;

import java.util.Map;
import java.util.TreeMap;

public class CartObject {
    int itemImage;
    String itemName;
    double itemPrice;
    Map<String, Integer> itemDiscounts = new TreeMap<>();


    public CartObject(){}
    public CartObject(int itemImage, String itemName, double itemPrice) {
        this.itemImage = itemImage;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public String getItemName() { return itemName; }
    public double getItemPrice() { return itemPrice; }
    public int getItemImage() { return itemImage; }
    public Map<String, Integer> getItemDiscounts() { return itemDiscounts; }

    public void setItemImage(int itemImage) { this.itemImage = itemImage; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public void setItemPrice(double itemPrice) { this.itemPrice = itemPrice; }
    public void setItemDiscounts(Map<String, Integer> itemDiscountName) { this.itemDiscounts = itemDiscounts; }
}
