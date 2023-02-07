package com.wabizabi.wazabipos.Utilities.Libraries.Helper;

import com.wabizabi.wazabipos.Database.RealmSchemas.RealmDiscount;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuCategory;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuItem;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmPaymentMethod;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmStockCategory;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmStockItem;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmTable;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class ListHelper {

    //MENU CATEGORY | STRING
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

    //MENU ITEMS | STRING
    public static List<String> getMenuItemNames(Realm realm) {
        List<String> listOfItems = new ArrayList<>();
        RealmResults<RealmMenuItem> queriedItems = realm
                .where(RealmMenuItem.class)
                .findAll();
        for(RealmMenuItem query : queriedItems){
            listOfItems.add(query.getItemPOSName());
        }
        return listOfItems;
    }

    //TABLE | STRING
    public static List<String> getTableNames(Realm realm) {
        List<String> listOfTables = new ArrayList<>();
        RealmResults<RealmTable> queriedTables = realm.where(RealmTable.class).findAll();
        for(RealmTable query : queriedTables){
            listOfTables.add(query.getTableName());
        }
        return listOfTables;
    }

    //DISCOUNT  STRING
    public static List<String> getDiscountNames(Realm realm){
        List<String> listOfDiscounts = new ArrayList<>();
        RealmResults<RealmDiscount> queriedDiscounts = realm.where(RealmDiscount.class).findAll();
        for(RealmDiscount query : queriedDiscounts){
            listOfDiscounts.add(query.getDiscountName());
        }
        return listOfDiscounts;
    }

    //METHOD | STRING
    public static List<String> getMethodNames(Realm realm){
        List<String> listOfMethods = new ArrayList<>();
        RealmResults<RealmPaymentMethod> queriedMethods = realm.where(RealmPaymentMethod.class).findAll();
        for(RealmPaymentMethod query : queriedMethods){
            listOfMethods.add(query.getMethodName());
        }
        return listOfMethods;
    }

    //STOCK CATEGORY | STRING
    public static List<String> getStockCategoryNames(Realm realm){
        List<String> listOfCategories = new ArrayList<>();
        RealmResults<RealmStockCategory> queriedMethods = realm.where(RealmStockCategory.class).findAll();
        for(RealmStockCategory query : queriedMethods){
            listOfCategories.add(query.getCategoryName());
        }
        return listOfCategories;
    }

    //STOCK ITEMS | STRING
    public static List<String> getStockItemNames(Realm realm){
        List<String> listOfItems = new ArrayList<>();
        RealmResults<RealmStockItem> queriedMethods = realm.where(RealmStockItem.class).findAll();
        for(RealmStockItem query : queriedMethods){
            listOfItems.add(query.getItemName());
        }
        return listOfItems;
    }
}
