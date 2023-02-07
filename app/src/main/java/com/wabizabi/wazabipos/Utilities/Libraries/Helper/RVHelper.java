package com.wabizabi.wazabipos.Utilities.Libraries.Helper;

import static com.wabizabi.wazabipos.Utilities.BackgroundThreads.W01_Algorithm.fpList;

import com.wabizabi.wazabipos.Database.ObjectSchemas.Discount;
import com.wabizabi.wazabipos.Database.ObjectSchemas.MenuCategory;
import com.wabizabi.wazabipos.Database.ObjectSchemas.MenuItem;
import com.wabizabi.wazabipos.Database.ObjectSchemas.PaymentMethod;
import com.wabizabi.wazabipos.Database.ObjectSchemas.StockCategory;
import com.wabizabi.wazabipos.Database.ObjectSchemas.StockItem;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmDiscount;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuCategory;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuItem;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmPaymentMethod;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmStockCategory;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmStockItem;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmTable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmResults;

public class RVHelper {

    //MENU ICONS
    public static List<Integer> getMenuIcons(){
        List<Integer> icons = new ArrayList<>();
        int counter = 0;
        while (counter != 9){
            icons.add(counter);
            counter++;
        }
        return icons;
    }
    //MENU CATEGORY | OBJECT
    public static List<MenuCategory> getMenuCategories(Realm realm){
        List<MenuCategory> listOfCategories = new ArrayList<>();
        RealmResults<RealmMenuCategory> queriedCategories = realm.where(RealmMenuCategory.class).sort("categoryName").findAll();
        for(RealmMenuCategory query : queriedCategories){
            listOfCategories.add(new MenuCategory(query.getCategoryIcon(), query.getCategoryName()));
        }
        return listOfCategories;
    }

    //MENU CATEGORY | OBJECT FILTERED
    public static List<MenuCategory> getFilteredMenuCategories(List<MenuCategory> listOfCategories, String input){
        List<MenuCategory> listOfFilteredCategories = new ArrayList<>();
        for(MenuCategory category : listOfCategories){
            if(category.getCategoryName().toLowerCase().contains(input.toLowerCase())){
                listOfFilteredCategories.add(category);
            }
        }
        return listOfFilteredCategories;
    }

    //MENU CATEGORY | SIZE
    public static String getMenuCategorySize(Realm realm, String categoryName){
        RealmResults<RealmMenuItem> queriedItems = realm.where(RealmMenuItem.class).equalTo("itemCategory", categoryName).findAll();
        String categorySize = "(" + queriedItems.size() + ") items";
        return categorySize;
    }

    //MENU ITEMS | ALL
    public static List<MenuItem> getAllMenuItems(Realm realm){
        List<MenuItem> listOfItems = new ArrayList<>();
        RealmResults<RealmMenuItem> queriedItems = realm.where(RealmMenuItem.class).findAll();
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

    //MENU ITEMS | POPULAR COMBINATIONS
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

    //TABLE ITEMS | OBJECT
    public static List<String> getTables(Realm realm){
        Map<String, Integer> listOfAllTables = new LinkedHashMap<>();
        RealmResults<RealmTable> queriedTables = realm.where(RealmTable.class).sort("tableName").findAll();
        for(RealmTable query : queriedTables){
            if(listOfAllTables.containsKey(query.getTableName())){
                listOfAllTables.put(query.getTableName(), listOfAllTables.get(query.getTableName()) + 1);
            } else {
                listOfAllTables.put(query.getTableName(), 1);
            }
        }
        List<String> listOfTables = new ArrayList<>(listOfAllTables.keySet());
        return listOfTables;
    }

    //TABLE ITEMS | OBJECT FILTERED
    public static List<String> getFilteredTables(List<String> listOfTables, String input){
        List<String> filteredTables = new ArrayList<>();
        for(String table : listOfTables){
            if(table.toLowerCase().contains(input.toLowerCase())){
                filteredTables.add(table);
            }
        }
        return filteredTables;
    }

    //DISCOUNT ITEMS | OBJECT
    public static List<Discount> getDiscounts(Realm realm){
        List<Discount> listOfDiscounts = new ArrayList<>();
        RealmResults<RealmDiscount> queriedDiscounts = realm.where(RealmDiscount.class).sort("discountName").findAll();
        for(RealmDiscount query : queriedDiscounts){
            listOfDiscounts.add(new Discount(query.getDiscountName(), query.getDiscountPercentage(), query.getLastUpdatedID(), query.getLastUpdatedText()));
        }
        return listOfDiscounts;
    }

    //DISCOUNT ITEMS | OBJECT FILTERED
    public static List<Discount> getFilteredDiscounts(List<Discount> listOfDiscounts, String input){
        List<Discount> filteredDiscounts = new ArrayList<>();
        for(Discount discount : listOfDiscounts){
            if(discount.getDiscountName().toLowerCase().contains(input.toLowerCase())){
                filteredDiscounts.add(discount);
            }
        }
        return filteredDiscounts;
    }

    //PAYMENT METHOD | OBJECT
    public static List<PaymentMethod> getPaymentMethods(Realm realm){
        List<PaymentMethod>listOfMethods = new ArrayList<>();
        RealmResults<RealmPaymentMethod> queriedMethods = realm.where(RealmPaymentMethod.class).sort("methodName").findAll();
        for(RealmPaymentMethod query : queriedMethods){
            listOfMethods.add(new PaymentMethod(query.getMethodName(), query.getLastUpdatedID(), query.getLastUpdatedText()));
        }
        return listOfMethods;
    }

    //PAYMENT METHOD | OBJECT FILTERED
    public static List<PaymentMethod> getFilteredPaymentMethods(List<PaymentMethod> listOfMethods, String input){
        List<PaymentMethod> filteredMethods = new ArrayList<>();
        for(PaymentMethod method : listOfMethods){
            if(method.getMethodName().toLowerCase().contains(input.toLowerCase())){
                filteredMethods.add(new PaymentMethod(method.getMethodName(), method.getLastUpdatedID(), method.getLastUpdatedText()));
            }
        }
        return filteredMethods;
    }

    //STOCK ICONS
    public static List<Integer> getStockIcons(){
        List<Integer> icons = new ArrayList<>();
        int counter = 0;
        while (counter != 9){
            icons.add(counter);
            counter++;
        }
        return icons;
    }

    //STOCK CATEGORY | OBJECT
    public static List<StockCategory> getStockCategories(Realm realm){
        List<StockCategory> listOfStockCategories = new ArrayList<>();
        RealmResults<RealmStockCategory> queriedCategories = realm.where(RealmStockCategory.class).sort("categoryName").findAll();
        for(RealmStockCategory query : queriedCategories){
            listOfStockCategories.add(new StockCategory(query.getCategoryIcon(), query.getCategoryName(), query.getLastUpdatedID(), query.getLastUpdatedText()));
        }
        return listOfStockCategories;
    }

    //STOCK CATEGORY | OBJECT FILTERED
    public static List<StockCategory> getFilteredStockCategories(List<StockCategory> listOfStockCategories, String input){
        List<StockCategory> filteredCategory = new ArrayList<>();
        for(StockCategory category : listOfStockCategories){
            if(category.getCategoryName().toLowerCase().contains(input.toLowerCase())){
                filteredCategory.add(category);
            }
        }
        return filteredCategory;
    }

    //STOCK ITEM | OBJECT
    public static List<StockItem> getStockItems(Realm realm, String category){
        List<StockItem> listOfStockItems = new ArrayList<>();
        RealmResults<RealmStockItem> queriedItems = realm.where(RealmStockItem.class).equalTo("itemCategory", category).sort("itemName").findAll();
        for(RealmStockItem query : queriedItems){
            listOfStockItems.add(new StockItem(query.getItemImage(), query.getItemCategory(), query.getItemName(), query.getItemAmount(), query.getUnitOfMeasurement()));
        }
        return listOfStockItems;
    }

    //STOCK ITEM | OBJECT FILTERED

    public static List<StockItem> getFilteredStockItems(List<StockItem> listOfStockItems, String input){
        List<StockItem> filteredItem = new ArrayList<>();
        for(StockItem item : listOfStockItems){
            if(item.getItemName().toLowerCase().contains(input.toLowerCase())){
                filteredItem.add(item);
            }
        }
        return filteredItem;
    }

}
