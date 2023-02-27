package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Helpers;

import com.wabizabi.wazabipos.Database.ObjectSchemas.MenuItem;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuItem;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class POSIHelper {

    //MENU ITEMS | OBJECT
    public static List<MenuItem> getMenuItems(Realm realm, String categoryName){
        List<MenuItem> listOfItems = new ArrayList<>();
        RealmResults<RealmMenuItem> queriedItems = realm.where(RealmMenuItem.class).equalTo("itemCategory", categoryName).sort("itemCategory").findAll();
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

    //MENU ITEMS | OBJECT FILTERED
    public static List<MenuItem> getFilteredMenuItems(List<MenuItem> listOfItems, String input) {
        List<MenuItem> listOfFilteredItems = new ArrayList<>();
        for(MenuItem item : listOfItems){
            if(item.getItemPOSName().toLowerCase().contains(input.toLowerCase())){
                listOfFilteredItems.add(item);
            }
        }
        return listOfFilteredItems;
    }
}
