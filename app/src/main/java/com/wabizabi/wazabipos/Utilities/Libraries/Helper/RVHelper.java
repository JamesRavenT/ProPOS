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
