package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment07_Admin.SubFragments.SubFragment02_InventoryTransaction.Helpers;

import com.wabizabi.wazabipos.Database.ObjectSchemas.InventoryTransaction;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmInventoryTransaction;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

public class ITHelper {

    //INVENTORY TRANSACTION | RV DESCENDING
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
                            query.getNewAmount(),
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
                            query.getNewAmount(),
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
                            query.getNewAmount(),
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
                            query.getNewAmount(),
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
                            query.getNewAmount(),
                            query.getYear(),
                            query.getMonth(),
                            query.getDay()
                    ));
                }
                break;
        }
        return listOfInventoryTransactions;
    }

    //INVENTORY TRANSACTION | RV DESCENDING
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
                            query.getNewAmount(),
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
                            query.getNewAmount(),
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
                            query.getNewAmount(),
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
                            query.getNewAmount(),
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
                            query.getNewAmount(),
                            query.getYear(),
                            query.getMonth(),
                            query.getDay()
                    ));
                }
                break;
        }
        return listOfInventoryTransactions;
    }

    // INVENTORY TRANSACTION | RV FILTERED
    public static List<InventoryTransaction> getFilteredInventoryTransaction(List<InventoryTransaction> listOfInventory, String input){
        List<InventoryTransaction> filteredTransaction = new ArrayList<>();
        for(InventoryTransaction transaction : listOfInventory){
            if(transaction.getItemName().toLowerCase().contains(input.toLowerCase())){
                filteredTransaction.add(transaction);
            }
        }
        return filteredTransaction;
    }
}
