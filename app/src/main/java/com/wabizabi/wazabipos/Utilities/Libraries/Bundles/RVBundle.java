package com.wabizabi.wazabipos.Utilities.Libraries.Bundles;



import com.wabizabi.wazabipos.Database.ObjectSchemas.MenuCategory;
import com.wabizabi.wazabipos.Database.ObjectSchemas.MenuItem;
import com.wabizabi.wazabipos.Database.ObjectSchemas.StockItem;

import java.util.List;

public class RVBundle {
    String menuCategory;
    String stockCategory;
    List<MenuItem> listOfMenuItems;
    List<StockItem> listOfStockItems;

    public RVBundle(String menuCategory, List<MenuItem> listOfMenuItems) {
        this.menuCategory = menuCategory;
        this.listOfMenuItems = listOfMenuItems;
    }

    public RVBundle(List<StockItem> listOfStockItems, String stockCategory) {
        this.stockCategory = stockCategory;
        this.listOfStockItems = listOfStockItems;
    }

    public String getMenuCategory() { return menuCategory; }
    public String getStockCategory() { return stockCategory; }

    public List<MenuItem> getListOfMenuItems() { return listOfMenuItems; }
    public List<StockItem> getListOfStockItems() { return listOfStockItems; }
}
