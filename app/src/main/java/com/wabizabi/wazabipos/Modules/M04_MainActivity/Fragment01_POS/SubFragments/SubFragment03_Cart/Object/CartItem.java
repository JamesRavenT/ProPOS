package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Object;

import java.util.Map;
import java.util.TreeMap;

public class CartItem {
    int itemImage;
    String itemWebName;
    String itemPOSName;
    double itemPrice;
    Map<String, Integer> itemDiscounts = new TreeMap<>();

    public CartItem(){}
    public CartItem(String itemWebName, String itemName, double itemPrice) {
        this.itemWebName = itemWebName;
        this.itemPOSName = itemName;
        this.itemPrice = itemPrice;
    }

    public CartItem(String itemWebName, String itemName, double itemPrice, Map<String, Integer> itemDiscounts) {
        this.itemWebName = itemWebName;
        this.itemPOSName = itemName;
        this.itemPrice = itemPrice;
        this.itemDiscounts = itemDiscounts;
    }

    public CartItem(int itemImage, String itemWebName, String itemName, double itemPrice) {
        this.itemImage = itemImage;
        this.itemWebName = itemWebName;
        this.itemPOSName = itemName;
        this.itemPrice = itemPrice;
    }

    public String getItemWebName() { return itemWebName; }
    public int getItemImage() { return itemImage; }
    public String getItemPOSName() { return itemPOSName; }
    public double getItemPrice() { return itemPrice; }
    public Map<String, Integer> getItemDiscounts() { return itemDiscounts; }

    public void setItemWebName(String itemWebName) { this.itemWebName = itemWebName; }
    public void setItemImage(int itemImage) { this.itemImage = itemImage; }
    public void setItemPOSName(String itemPOSName) { this.itemPOSName = itemPOSName; }
    public void setItemPrice(double itemPrice) { this.itemPrice = itemPrice; }
    public void setItemDiscounts(Map<String, Integer> itemDiscountName) { this.itemDiscounts = itemDiscounts; }
}
