package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment06_IngredientStock.Helpers;

import com.wabizabi.wazabipos.Database.ObjectSchemas.StockItem;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmStockItem;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class SIHelper {

    //STOCK ITEM | RV
    public static List<StockItem> getStockItems(Realm realm, String category){
        List<StockItem> listOfStockItems = new ArrayList<>();
        RealmResults<RealmStockItem> queriedItems = realm.where(RealmStockItem.class).equalTo("itemCategory", category).sort("itemName").findAll();
        for(RealmStockItem query : queriedItems){
            listOfStockItems.add(new StockItem(query.getItemIcon(), query.getItemCategory(), query.getItemName(), query.getItemAmount(), query.getUnitOfMeasurement()));
        }
        return listOfStockItems;
    }

    //STOCK ITEM | RV FILTERED
    public static List<StockItem> getFilteredStockItems(List<StockItem> listOfStockItems, String input){
        List<StockItem> filteredItem = new ArrayList<>();
        for(StockItem item : listOfStockItems){
            if(item.getItemName().toLowerCase().contains(input.toLowerCase())){
                filteredItem.add(item);
            }
        }
        return filteredItem;
    }

    //STOCK ITEMS | EDITTEXT
    public static List<String> getStockItemNames(Realm realm){
        List<String> listOfItems = new ArrayList<>();
        RealmResults<RealmStockItem> queriedMethods = realm.where(RealmStockItem.class).findAll();
        for(RealmStockItem query : queriedMethods){
            listOfItems.add(query.getItemName());
        }
        return listOfItems;
    }
}
