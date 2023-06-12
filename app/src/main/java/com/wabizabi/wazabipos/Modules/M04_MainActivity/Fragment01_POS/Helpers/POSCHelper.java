package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Helpers;

import com.wabizabi.wazabipos.Database.ObjectSchemas.MenuCategory;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuCategory;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuItem;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class POSCHelper {

    //MENU CATEGORY | SIZE
    public static String getMenuCategorySize(Realm realm, String categoryName){
        RealmResults<RealmMenuItem> queriedItems = realm.where(RealmMenuItem.class).equalTo("itemCategory", categoryName).findAll();
        String categorySize = "(" + queriedItems.size() + ") items";
        return categorySize;
    }
//
//    //MENU CATEGORY | RV
//    public static List<MenuCategory> getMenuCategories(Realm realm){
//        List<MenuCategory> listOfCategories = new ArrayList<>();
//        RealmResults<RealmMenuCategory> queriedCategories = realm.where(RealmMenuCategory.class).sort("categoryName").findAll();
//        for(RealmMenuCategory query : queriedCategories){
//            listOfCategories.add(new MenuCategory(query.getCategoryIcon(), query.getCategoryName(), query.getLastUpdatedID(), query.getLastUpdatedText()));
//        }
//        return listOfCategories;
//    }
//
    //MENU CATEGORY | RV FILTERED
    public static List<MenuCategory> getFilteredMenuCategories(List<MenuCategory> listOfCategories, String input){
        List<MenuCategory> listOfFilteredCategories = new ArrayList<>();
        for(MenuCategory category : listOfCategories){
            if(category.getCategoryName().toLowerCase().contains(input.toLowerCase())){
                listOfFilteredCategories.add(category);
            }
        }
        return listOfFilteredCategories;
    }
}
