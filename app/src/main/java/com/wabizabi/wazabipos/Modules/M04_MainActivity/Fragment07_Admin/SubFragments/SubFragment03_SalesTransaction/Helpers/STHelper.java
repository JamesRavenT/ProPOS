package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment07_Admin.SubFragments.SubFragment03_SalesTransaction.Helpers;

import com.wabizabi.wazabipos.Database.ObjectSchemas.SalesTransaction;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmSalesTransaction;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

public class STHelper {

    // SALES TRANSACTION | RV DESCENDING
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

    // SALES TRANSACTION | RV ASCENDING
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

    // SALES TRANSACTION | RV FILTERED
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
