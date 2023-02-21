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
            listOfStockItems.add(new StockItem(query.getItemIcon(), query.getItemCategory(), query.getItemName(), query.getItemAmount(), query.getUnitOfMeasurement()));
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

    //INVENTORY TRANSACTION | OBJECT DESCENDING
    public static List<InventoryTransaction> getInventoryTransactionDescending(Realm realm, String transactionType, String year, String month, String day){
        List<InventoryTransaction> listOfInventoryTransactions = new ArrayList<>();
        int filter = (!transactionType.equals("Any") &&
                !year.equals("Any") &&
                !month.equals("Any") &&
                !day.equals("Any"))
                ? 5
                : (!transactionType.equals("Any") &&
                !year.equals("Any") &&
                !month.equals("Any") &&
                day.equals("Any"))
                ? 4
                : (!transactionType.equals("Any") &&
                !year.equals("Any") &&
                month.equals("Any") &&
                day.equals("Any"))
                ? 3
                : (!transactionType.equals("Any") &&
                year.equals("Any") &&
                month.equals("Any") &&
                day.equals("Any"))
                ? 2
                : 1;
        switch(filter){
            case 5:
                RealmResults<RealmInventoryTransaction> queriedInventoryC5 =
                        realm.where(RealmInventoryTransaction.class)
                                .equalTo("transactionType", transactionType)
                                .equalTo("year", year)
                                .equalTo("month", month)
                                .equalTo("day", day)
                                .sort("_id", Sort.DESCENDING)
                                .findAll();
                for(RealmInventoryTransaction query : queriedInventoryC5){
                    listOfInventoryTransactions.add(new InventoryTransaction(
                            query.get_id(),
                            query.getTransactionDT(),
                            query.getTransactionType(),
                            query.getItemName(),
                            query.getAmount(),
                            query.getItemUnit(),
                            query.getYear(),
                            query.getMonth(),
                            query.getDay()
                    ));
                }
                break;
            case 4:
                RealmResults<RealmInventoryTransaction> queriedInventoryC4 =
                        realm.where(RealmInventoryTransaction.class)
                                .equalTo("transactionType", transactionType)
                                .equalTo("year", year)
                                .equalTo("month", month)
                                .sort("_id", Sort.DESCENDING)
                                .findAll();
                for(RealmInventoryTransaction query : queriedInventoryC4){
                    listOfInventoryTransactions.add(new InventoryTransaction(
                            query.get_id(),
                            query.getTransactionDT(),
                            query.getTransactionType(),
                            query.getItemName(),
                            query.getAmount(),
                            query.getItemUnit(),
                            query.getYear(),
                            query.getMonth(),
                            query.getDay()
                    ));
                }
                break;
            case 3:
                RealmResults<RealmInventoryTransaction> queriedInventoryC3 =
                        realm.where(RealmInventoryTransaction.class)
                                .equalTo("transactionType", transactionType)
                                .equalTo("year", year)
                                .sort("_id", Sort.DESCENDING)
                                .findAll();
                for(RealmInventoryTransaction query : queriedInventoryC3){
                    listOfInventoryTransactions.add(new InventoryTransaction(
                            query.get_id(),
                            query.getTransactionDT(),
                            query.getTransactionType(),
                            query.getItemName(),
                            query.getAmount(),
                            query.getItemUnit(),
                            query.getYear(),
                            query.getMonth(),
                            query.getDay()
                    ));
                }
                break;
            case 2:
                RealmResults<RealmInventoryTransaction> queriedInventoryC2 =
                        realm.where(RealmInventoryTransaction.class)
                                .equalTo("transactionType", transactionType)
                                .sort("_id", Sort.DESCENDING)
                                .findAll();
                for(RealmInventoryTransaction query : queriedInventoryC2){
                    listOfInventoryTransactions.add(new InventoryTransaction(
                            query.get_id(),
                            query.getTransactionDT(),
                            query.getTransactionType(),
                            query.getItemName(),
                            query.getAmount(),
                            query.getItemUnit(),
                            query.getYear(),
                            query.getMonth(),
                            query.getDay()
                    ));
                }
                break;
            case 1:
                RealmResults<RealmInventoryTransaction> queriedInventoryC1 =
                        realm.where(RealmInventoryTransaction.class)
                                .sort("_id", Sort.DESCENDING)
                                .findAll();
                for(RealmInventoryTransaction query : queriedInventoryC1){
                    listOfInventoryTransactions.add(new InventoryTransaction(
                            query.get_id(),
                            query.getTransactionDT(),
                            query.getTransactionType(),
                            query.getItemName(),
                            query.getAmount(),
                            query.getItemUnit(),
                            query.getYear(),
                            query.getMonth(),
                            query.getDay()
                    ));
                }
                break;
        }
        return listOfInventoryTransactions;
    }

    //INVENTORY TRANSACTION | OBJECT ASCENDING
    public static List<InventoryTransaction> getInventoryTransactionAscending(Realm realm, String transactionType, String year, String month, String day){
        List<InventoryTransaction> listOfInventoryTransactions = new ArrayList<>();
        int filter = (!transactionType.equals("Any") &&
                !year.equals("Any") &&
                !month.equals("Any") &&
                !day.equals("Any"))
                ? 5
                : (!transactionType.equals("Any") &&
                !year.equals("Any") &&
                !month.equals("Any") &&
                day.equals("Any"))
                ? 4
                : (!transactionType.equals("Any") &&
                !year.equals("Any") &&
                month.equals("Any") &&
                day.equals("Any"))
                ? 3
                : (!transactionType.equals("Any") &&
                year.equals("Any") &&
                month.equals("Any") &&
                day.equals("Any"))
                ? 2
                : 1;
        switch(filter){
            case 5:
                RealmResults<RealmInventoryTransaction> queriedInventoryC5 =
                        realm.where(RealmInventoryTransaction.class)
                                .equalTo("transactionType", transactionType)
                                .equalTo("year", year)
                                .equalTo("month", month)
                                .equalTo("day", day)
                                .sort("_id", Sort.ASCENDING)
                                .findAll();
                for(RealmInventoryTransaction query : queriedInventoryC5){
                    listOfInventoryTransactions.add(new InventoryTransaction(
                            query.get_id(),
                            query.getTransactionDT(),
                            query.getTransactionType(),
                            query.getItemName(),
                            query.getAmount(),
                            query.getItemUnit(),
                            query.getYear(),
                            query.getMonth(),
                            query.getDay()
                    ));
                }
                break;
            case 4:
                RealmResults<RealmInventoryTransaction> queriedInventoryC4 =
                        realm.where(RealmInventoryTransaction.class)
                                .equalTo("transactionType", transactionType)
                                .equalTo("year", year)
                                .equalTo("month", month)
                                .sort("_id", Sort.ASCENDING)
                                .findAll();
                for(RealmInventoryTransaction query : queriedInventoryC4){
                    listOfInventoryTransactions.add(new InventoryTransaction(
                            query.get_id(),
                            query.getTransactionDT(),
                            query.getTransactionType(),
                            query.getItemName(),
                            query.getAmount(),
                            query.getItemUnit(),
                            query.getYear(),
                            query.getMonth(),
                            query.getDay()
                    ));
                }
                break;
            case 3:
                RealmResults<RealmInventoryTransaction> queriedInventoryC3 =
                        realm.where(RealmInventoryTransaction.class)
                                .equalTo("transactionType", transactionType)
                                .equalTo("year", year)
                                .sort("_id", Sort.ASCENDING)
                                .findAll();
                for(RealmInventoryTransaction query : queriedInventoryC3){
                    listOfInventoryTransactions.add(new InventoryTransaction(
                            query.get_id(),
                            query.getTransactionDT(),
                            query.getTransactionType(),
                            query.getItemName(),
                            query.getAmount(),
                            query.getItemUnit(),
                            query.getYear(),
                            query.getMonth(),
                            query.getDay()
                    ));
                }
                break;
            case 2:
                RealmResults<RealmInventoryTransaction> queriedInventoryC2 =
                        realm.where(RealmInventoryTransaction.class)
                                .equalTo("transactionType", transactionType)
                                .sort("_id", Sort.ASCENDING)
                                .findAll();
                for(RealmInventoryTransaction query : queriedInventoryC2){
                    listOfInventoryTransactions.add(new InventoryTransaction(
                            query.get_id(),
                            query.getTransactionDT(),
                            query.getTransactionType(),
                            query.getItemName(),
                            query.getAmount(),
                            query.getItemUnit(),
                            query.getYear(),
                            query.getMonth(),
                            query.getDay()
                    ));
                }
                break;
            case 1:
                RealmResults<RealmInventoryTransaction> queriedInventoryC1 =
                        realm.where(RealmInventoryTransaction.class)
                                .sort("_id", Sort.ASCENDING)
                                .findAll();
                for(RealmInventoryTransaction query : queriedInventoryC1){
                    listOfInventoryTransactions.add(new InventoryTransaction(
                            query.get_id(),
                            query.getTransactionDT(),
                            query.getTransactionType(),
                            query.getItemName(),
                            query.getAmount(),
                            query.getItemUnit(),
                            query.getYear(),
                            query.getMonth(),
                            query.getDay()
                    ));
                }
                break;
        }
        return listOfInventoryTransactions;
    }

    // INVENTORY TRANSACTION | OBJECT FILTERED
    public static List<InventoryTransaction> getFilteredInventoryTransaction(List<InventoryTransaction> listOfInventory, String input){
        List<InventoryTransaction> filteredTransaction = new ArrayList<>();
        for(InventoryTransaction transaction : listOfInventory){
            if(transaction.getItemName().toLowerCase().contains(input.toLowerCase())){
                filteredTransaction.add(transaction);
            }
        }
        return filteredTransaction;
    }


    // SALES TRANSACTION | OBJECT DESCENDING
    public static List<SalesTransaction> getSalesTransactionDescending(Realm realm, String transactionType, String orderType, String year, String month, String day){
        List<SalesTransaction> listOfSalesTransactions = new ArrayList<>();
        int filter = (!transactionType.equals("Any") &&
                      !orderType.equals("Any") &&
                      !year.equals("Any") &&
                      !month.equals("Any") &&
                      !day.equals("Any"))
                   ? 6
                   : (!transactionType.equals("Any") &&
                      !orderType.equals("Any") &&
                      !year.equals("Any") &&
                      !month.equals("Any") &&
                      day.equals("Any"))
                   ? 5
                   : (!transactionType.equals("Any") &&
                      !orderType.equals("Any") &&
                      !year.equals("Any") &&
                      month.equals("Any") &&
                      day.equals("Any"))
                   ? 4
                   : (!transactionType.equals("Any") &&
                      !orderType.equals("Any") &&
                      year.equals("Any") &&
                      month.equals("Any") &&
                      day.equals("Any"))
                   ? 3
                   : (!transactionType.equals("Any") &&
                      orderType.equals("Any") &&
                      year.equals("Any") &&
                      month.equals("Any") &&
                      day.equals("Any"))
                   ? 2
                   : 1;

        switch(filter){
            case 6:
                RealmResults<RealmSalesTransaction> queriedSalesC6 =
                        realm.where(RealmSalesTransaction.class)
                                .equalTo("transactionType", transactionType)
                                .and().equalTo("orderType", orderType)
                                .and().equalTo("year", year)
                                .and().equalTo("month", month)
                                .and().equalTo("day", day)
                                .sort("_id", Sort.DESCENDING)
                                .findAll();
                for(RealmSalesTransaction query : queriedSalesC6){
                    listOfSalesTransactions.add(new SalesTransaction(
                            query.getDateAndTime(),
                            query.get_id(),
                            query.getTransactionNo(),
                            query.getTransactionType(),
                            query.getOrder(),
                            query.getOrderType(),
                            query.getTotalItems(),
                            query.getTotalAmountDue(),
                            query.getTotalPayment(),
                            query.getPaymentMethod()
                    ));
                }
                break;
            case 5:
                RealmResults<RealmSalesTransaction> queriedSalesC5 =
                        realm.where(RealmSalesTransaction.class)
                                .equalTo("transactionType", transactionType)
                                .and().equalTo("orderType", orderType)
                                .and().equalTo("year", year)
                                .and().equalTo("month", month)
                                .sort("_id", Sort.DESCENDING)
                                .findAll();
                for(RealmSalesTransaction query : queriedSalesC5){
                    listOfSalesTransactions.add(new SalesTransaction(
                            query.getDateAndTime(),
                            query.get_id(),
                            query.getTransactionNo(),
                            query.getTransactionType(),
                            query.getOrder(),
                            query.getOrderType(),
                            query.getTotalItems(),
                            query.getTotalAmountDue(),
                            query.getTotalPayment(),
                            query.getPaymentMethod()
                    ));
                }
                break;
            case 4:
                RealmResults<RealmSalesTransaction> queriedSalesC4 =
                        realm.where(RealmSalesTransaction.class)
                                .equalTo("transactionType", transactionType)
                                .and().equalTo("orderType", orderType)
                                .and().equalTo("year", year)
                                .sort("_id", Sort.DESCENDING)
                                .findAll();
                for(RealmSalesTransaction query : queriedSalesC4){
                    listOfSalesTransactions.add(new SalesTransaction(
                            query.getDateAndTime(),
                            query.get_id(),
                            query.getTransactionNo(),
                            query.getTransactionType(),
                            query.getOrder(),
                            query.getOrderType(),
                            query.getTotalItems(),
                            query.getTotalAmountDue(),
                            query.getTotalPayment(),
                            query.getPaymentMethod()
                    ));
                }
                break;
            case 3:
                RealmResults<RealmSalesTransaction> queriedSalesC3 =
                        realm.where(RealmSalesTransaction.class)
                                .equalTo("transactionType", transactionType)
                                .and().equalTo("orderType", orderType)
                                .sort("_id", Sort.DESCENDING)
                                .findAll();
                for(RealmSalesTransaction query : queriedSalesC3){
                    listOfSalesTransactions.add(new SalesTransaction(
                            query.getDateAndTime(),
                            query.get_id(),
                            query.getTransactionNo(),
                            query.getTransactionType(),
                            query.getOrder(),
                            query.getOrderType(),
                            query.getTotalItems(),
                            query.getTotalAmountDue(),
                            query.getTotalPayment(),
                            query.getPaymentMethod()
                    ));
                }
                break;
            case 2:
                RealmResults<RealmSalesTransaction> queriedSalesC2 =
                        realm.where(RealmSalesTransaction.class)
                                .equalTo("transactionType", transactionType)
                                .sort("_id", Sort.DESCENDING)
                                .findAll();
                for(RealmSalesTransaction query : queriedSalesC2){
                    listOfSalesTransactions.add(new SalesTransaction(
                            query.getDateAndTime(),
                            query.get_id(),
                            query.getTransactionNo(),
                            query.getTransactionType(),
                            query.getOrder(),
                            query.getOrderType(),
                            query.getTotalItems(),
                            query.getTotalAmountDue(),
                            query.getTotalPayment(),
                            query.getPaymentMethod()
                    ));
                }
                break;
            case 1:
                RealmResults<RealmSalesTransaction> queriedSalesC1 =
                        realm.where(RealmSalesTransaction.class)
                                .sort("_id", Sort.DESCENDING)
                                .findAll();
                for(RealmSalesTransaction query : queriedSalesC1){
                    listOfSalesTransactions.add(new SalesTransaction(
                            query.getDateAndTime(),
                            query.get_id(),
                            query.getTransactionNo(),
                            query.getTransactionType(),
                            query.getOrder(),
                            query.getOrderType(),
                            query.getTotalItems(),
                            query.getTotalAmountDue(),
                            query.getTotalPayment(),
                            query.getPaymentMethod()
                    ));
                }
                break;
        }
        return listOfSalesTransactions;
    }

    // SALES TRANSACTION | OBJECT ASCENDING
    public static List<SalesTransaction> getSalesTransactionAscending(Realm realm, String transactionType, String orderType, String year, String month, String day){
        List<SalesTransaction> listOfSalesTransactions = new ArrayList<>();
        int filter = (!transactionType.equals("Any") &&
                !orderType.equals("Any") &&
                !year.equals("Any") &&
                !month.equals("Any") &&
                !day.equals("Any"))
                ? 6
                : (!transactionType.equals("Any") &&
                !orderType.equals("Any") &&
                !year.equals("Any") &&
                !month.equals("Any") &&
                day.equals("Any"))
                ? 5
                : (!transactionType.equals("Any") &&
                !orderType.equals("Any") &&
                !year.equals("Any") &&
                month.equals("Any") &&
                day.equals("Any"))
                ? 4
                : (!transactionType.equals("Any") &&
                !orderType.equals("Any") &&
                year.equals("Any") &&
                month.equals("Any") &&
                day.equals("Any"))
                ? 3
                : (!transactionType.equals("Any") &&
                orderType.equals("Any") &&
                year.equals("Any") &&
                month.equals("Any") &&
                day.equals("Any"))
                ? 2
                : 1;

        switch(filter){
            case 6:
                RealmResults<RealmSalesTransaction> queriedSalesC6 =
                        realm.where(RealmSalesTransaction.class)
                                .equalTo("transactionType", transactionType)
                                .and().equalTo("orderType", orderType)
                                .and().equalTo("year", year)
                                .and().equalTo("month", month)
                                .and().equalTo("day", day)
                                .sort("_id", Sort.ASCENDING)
                                .findAll();
                for(RealmSalesTransaction query : queriedSalesC6){
                    listOfSalesTransactions.add(new SalesTransaction(
                            query.getDateAndTime(),
                            query.get_id(),
                            query.getTransactionNo(),
                            query.getTransactionType(),
                            query.getOrder(),
                            query.getOrderType(),
                            query.getTotalItems(),
                            query.getTotalAmountDue(),
                            query.getTotalPayment(),
                            query.getPaymentMethod()
                    ));
                }
                break;
            case 5:
                RealmResults<RealmSalesTransaction> queriedSalesC5 =
                        realm.where(RealmSalesTransaction.class)
                                .equalTo("transactionType", transactionType)
                                .and().equalTo("orderType", orderType)
                                .and().equalTo("year", year)
                                .and().equalTo("month", month)
                                .sort("_id", Sort.ASCENDING)
                                .findAll();
                for(RealmSalesTransaction query : queriedSalesC5){
                    listOfSalesTransactions.add(new SalesTransaction(
                            query.getDateAndTime(),
                            query.get_id(),
                            query.getTransactionNo(),
                            query.getTransactionType(),
                            query.getOrder(),
                            query.getOrderType(),
                            query.getTotalItems(),
                            query.getTotalAmountDue(),
                            query.getTotalPayment(),
                            query.getPaymentMethod()
                    ));
                }
                break;
            case 4:
                RealmResults<RealmSalesTransaction> queriedSalesC4 =
                        realm.where(RealmSalesTransaction.class)
                                .equalTo("transactionType", transactionType)
                                .and().equalTo("orderType", orderType)
                                .and().equalTo("year", year)
                                .sort("_id", Sort.ASCENDING)
                                .findAll();
                for(RealmSalesTransaction query : queriedSalesC4){
                    listOfSalesTransactions.add(new SalesTransaction(
                            query.getDateAndTime(),
                            query.get_id(),
                            query.getTransactionNo(),
                            query.getTransactionType(),
                            query.getOrder(),
                            query.getOrderType(),
                            query.getTotalItems(),
                            query.getTotalAmountDue(),
                            query.getTotalPayment(),
                            query.getPaymentMethod()
                    ));
                }
                break;
            case 3:
                RealmResults<RealmSalesTransaction> queriedSalesC3 =
                        realm.where(RealmSalesTransaction.class)
                                .equalTo("transactionType", transactionType)
                                .and().equalTo("orderType", orderType)
                                .sort("_id", Sort.ASCENDING)
                                .findAll();
                for(RealmSalesTransaction query : queriedSalesC3){
                    listOfSalesTransactions.add(new SalesTransaction(
                            query.getDateAndTime(),
                            query.get_id(),
                            query.getTransactionNo(),
                            query.getTransactionType(),
                            query.getOrder(),
                            query.getOrderType(),
                            query.getTotalItems(),
                            query.getTotalAmountDue(),
                            query.getTotalPayment(),
                            query.getPaymentMethod()
                    ));
                }
                break;
            case 2:
                RealmResults<RealmSalesTransaction> queriedSalesC2 =
                        realm.where(RealmSalesTransaction.class)
                                .equalTo("transactionType", transactionType)
                                .sort("_id", Sort.ASCENDING)
                                .findAll();
                for(RealmSalesTransaction query : queriedSalesC2){
                    listOfSalesTransactions.add(new SalesTransaction(
                            query.getDateAndTime(),
                            query.get_id(),
                            query.getTransactionNo(),
                            query.getTransactionType(),
                            query.getOrder(),
                            query.getOrderType(),
                            query.getTotalItems(),
                            query.getTotalAmountDue(),
                            query.getTotalPayment(),
                            query.getPaymentMethod()
                    ));
                }
                break;
            case 1:
                RealmResults<RealmSalesTransaction> queriedSalesC1 =
                        realm.where(RealmSalesTransaction.class)
                                .sort("_id", Sort.ASCENDING)
                                .findAll();
                for(RealmSalesTransaction query : queriedSalesC1){
                    listOfSalesTransactions.add(new SalesTransaction(
                            query.getDateAndTime(),
                            query.get_id(),
                            query.getTransactionNo(),
                            query.getTransactionType(),
                            query.getOrder(),
                            query.getOrderType(),
                            query.getTotalItems(),
                            query.getTotalAmountDue(),
                            query.getTotalPayment(),
                            query.getPaymentMethod()
                    ));
                }
                break;
        }
        return listOfSalesTransactions;
    }

    // SALES TRANSACTION | OBJECT FILTERED
    public static List<SalesTransaction> getFilteredSalesTransaction(List<SalesTransaction> listOfSales, String input){
        List<SalesTransaction> filteredTransaction = new ArrayList<>();
        for(SalesTransaction transaction : listOfSales){
            if(transaction.getOrder().toLowerCase().contains(input.toLowerCase())){
                filteredTransaction.add(transaction);
            }
        }
        return filteredTransaction;
    }

}
