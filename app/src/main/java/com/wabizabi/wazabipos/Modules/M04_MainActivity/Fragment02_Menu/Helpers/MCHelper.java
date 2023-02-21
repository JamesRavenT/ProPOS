package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Menu.Helpers;

import com.wabizabi.wazabipos.Database.ObjectSchemas.MenuCategory;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuCategory;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuItem;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class MCHelper {

    //MENU ICONS | RV
    public static List<Integer> getMenuIcons(){
        List<Integer> icons = new ArrayList<>();
        int counter = 0;
        while (counter != 9){
            icons.add(counter);
            counter++;
        }
        return icons;
    }

    //MENU CATEGORY | RV
    public static List<MenuCategory> getMenuCategories(Realm realm){
        List<MenuCategory> listOfCategories = new ArrayList<>();
        RealmResults<RealmMenuCategory> queriedCategories = realm.where(RealmMenuCategory.class).sort("categoryName").findAll();
        for(RealmMenuCategory query : queriedCategories){
            listOfCategories.add(new MenuCategory(query.getCategoryIcon(), query.getCategoryName(), query.getLastUpdatedID(), query.getLastUpdatedText()));
        }
        return listOfCategories;
    }

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

    //MENU CATEGORY | EDITTEXT
    public static List<String> getMenuCategoryNames(Realm realm){
        List<String> listOfCategories = new ArrayList<>();
        RealmResults<RealmMenuCategory> queriedCategories = realm
                .where(RealmMenuCategory.class)
                .findAll();
        for(RealmMenuCategory query : queriedCategories){
            listOfCategories.add(query.getCategoryName());
        }
        return listOfCategories;
    }


}
