package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment06_IngredientStock.Helpers;

import com.wabizabi.wazabipos.Database.ObjectSchemas.StockCategory;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmStockCategory;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class SCHelper {

    //STOCK ICONS | RV
    public static List<Integer> getStockIcons(){
        List<Integer> icons = new ArrayList<>();
        int counter = 0;
        while (counter != 34){
            icons.add(counter);
            counter++;
        }
        return icons;
    }

    //STOCK CATEGORY | RV
    public static List<StockCategory> getStockCategories(Realm realm){
        List<StockCategory> listOfStockCategories = new ArrayList<>();
        RealmResults<RealmStockCategory> queriedCategories = realm.where(RealmStockCategory.class).sort("categoryName").findAll();
        for(RealmStockCategory query : queriedCategories){
            listOfStockCategories.add(new StockCategory(query.getCategoryIcon(), query.getCategoryName(), query.getLastUpdatedID(), query.getLastUpdatedText()));
        }
        return listOfStockCategories;
    }

    //STOCK CATEGORY | RV FILTERED
    public static List<StockCategory> getFilteredStockCategories(List<StockCategory> listOfStockCategories, String input){
        List<StockCategory> filteredCategory = new ArrayList<>();
        for(StockCategory category : listOfStockCategories){
            if(category.getCategoryName().toLowerCase().contains(input.toLowerCase())){
                filteredCategory.add(category);
            }
        }
        return filteredCategory;
    }

    //STOCK CATEGORY | EDITTEXT
    public static List<String> getStockCategoryNames(Realm realm){
        List<String> listOfCategories = new ArrayList<>();
        RealmResults<RealmStockCategory> queriedMethods = realm.where(RealmStockCategory.class).findAll();
        for(RealmStockCategory query : queriedMethods){
            listOfCategories.add(query.getCategoryName());
        }
        return listOfCategories;
    }
}
