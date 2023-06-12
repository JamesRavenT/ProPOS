package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Menu.Helpers;

import static com.wabizabi.wazabipos.Utilities.BackgroundThreads.W01_Algorithm.fpList;

import com.wabizabi.wazabipos.Database.ObjectSchemas.MenuItem;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmResults;

public class MIHelper {


    //MENU ITEMS | RV
    public static List<MenuItem> getMenuItems(Realm realm, String categoryName){
        List<MenuItem> listOfItems = new ArrayList<>();
        RealmResults<RealmMenuItem> queriedItems = realm.where(RealmMenuItem.class).equalTo("itemCategory", categoryName).sort("itemWebName").findAll();
        for(RealmMenuItem query : queriedItems){
            listOfItems.add(
                    new MenuItem(query.get_id(),
                            query.getItemIcon(),
                            query.getItemCategory(),
                            query.getItemWebName(),
                            query.getItemPOSName(),
                            query.getItemPrice()));
        }
        return listOfItems;
    }
    //MENU ITEMS | RV FILTERED
    public static List<MenuItem> getFilteredMenuItems(List<MenuItem> listOfItems, String input) {
        List<MenuItem> listOfFilteredItems = new ArrayList<>();
        for(MenuItem item : listOfItems){
            if(item.getItemPOSName().toLowerCase().contains(input.toLowerCase())){
                listOfFilteredItems.add(item);
            }
        }
        return listOfFilteredItems;
    }

    //MENU ITEMS | RV POPULAR COMBINATIONS
    public static List<List<String>> getPopularCombinations(String name){
        List<List<String>> listOfCombinations = new ArrayList<>();
        for(Map.Entry<String, Map<List<String>, Integer>> list : fpList.entrySet()){
            if(name.equals(list.getKey())){
                for(List<String> itemsets : list.getValue().keySet()){
                    listOfCombinations.add(itemsets);
                }
            }
        }
        return listOfCombinations;
    }

    //MENU ITEMS | EDITTEXT
    public static List<String> getMenuWebItemNames(Realm realm) {
        List<String> listOfItems = new ArrayList<>();
        RealmResults<RealmMenuItem> queriedItems = realm
                .where(RealmMenuItem.class)
                .findAll();
        for(RealmMenuItem query : queriedItems){
            listOfItems.add(query.getItemWebName());
        }
        return listOfItems;
    }

    //MENU ITEMS | EDITTEXT POS
    public static List<String> getMenuPOSItemNames(Realm realm) {
        List<String> listOfItems = new ArrayList<>();
        RealmResults<RealmMenuItem> queriedItems = realm
                .where(RealmMenuItem.class)
                .findAll();
        for(RealmMenuItem query : queriedItems){
            listOfItems.add(query.getItemPOSName());
        }
        return listOfItems;
    }

}
