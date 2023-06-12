package com.wabizabi.wazabipos.Utilities.Libraries.Bundles;


import android.view.Menu;

import com.wabizabi.wazabipos.Database.ObjectSchemas.MenuItem;
import com.wabizabi.wazabipos.Database.ObjectSchemas.StockItem;

import java.util.List;

public class RVBundle {
    int menuIcon;
    String menuCategory;
    String stockCategory;
    List<MenuItem> listOfMenuItems;
    List<StockItem> listOfStockItems;

    public RVBundle(int menuIcon, String menuCategory, List<MenuItem> listOfMenuItems){
        this.menuIcon = menuIcon;
        this.menuCategory = menuCategory;
        this.listOfMenuItems = listOfMenuItems;
    }
    public RVBundle(String menuCategory, List<MenuItem> listOfMenuItems) {
        this.menuCategory = menuCategory;
        this.listOfMenuItems = listOfMenuItems;
    }

    public RVBundle(List<StockItem> listOfStockItems, String stockCategory) {
        this.stockCategory = stockCategory;
        this.listOfStockItems = listOfStockItems;
    }

    public int getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(int menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuCategory() { return menuCategory; }
    public String getStockCategory() { return stockCategory; }

    public List<MenuItem> getListOfMenuItems() { return listOfMenuItems; }
    public List<StockItem> getListOfStockItems() { return listOfStockItems; }
}
