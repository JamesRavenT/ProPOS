package com.wabizabi.wazabipos.Utilities.Libraries.Helper;

import static com.wabizabi.wazabipos.Utilities.BackgroundThreads.W01_Algorithm.fpList;

import com.wabizabi.wazabipos.Database.ObjectSchemas.Discount;
import com.wabizabi.wazabipos.Database.ObjectSchemas.InventoryTransaction;
import com.wabizabi.wazabipos.Database.ObjectSchemas.MenuCategory;
import com.wabizabi.wazabipos.Database.ObjectSchemas.MenuItem;
import com.wabizabi.wazabipos.Database.ObjectSchemas.PaymentMethod;
import com.wabizabi.wazabipos.Database.ObjectSchemas.SalesTransaction;
import com.wabizabi.wazabipos.Database.ObjectSchemas.StockCategory;
import com.wabizabi.wazabipos.Database.ObjectSchemas.StockItem;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmDiscount;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmInventoryTransaction;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuCategory;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuItem;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmPaymentMethod;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmSalesTransaction;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmStockCategory;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmStockItem;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmTable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

public class RVHelper {
    //MENU CATEGORY | SIZE
    public static String getMenuCategorySize(Realm realm, String categoryName){
        RealmResults<RealmMenuItem> queriedItems = realm.where(RealmMenuItem.class).equalTo("itemCategory", categoryName).findAll();
        String categorySize = "(" + queriedItems.size() + ") items";
        return categorySize;
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
