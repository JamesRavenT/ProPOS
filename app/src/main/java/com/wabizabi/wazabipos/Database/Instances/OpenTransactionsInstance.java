package com.wabizabi.wazabipos.Database.Instances;


import com.wabizabi.wazabipos.Database.Schemas.TransactionsOfInventory;
import com.wabizabi.wazabipos.Database.Schemas.TransactionsOfSales;

import org.bson.types.ObjectId;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;

public class OpenTransactionsInstance {

    public static void toCreateSalesTransaction(List<String> itemsetName,
                                                List<Double> itemsetPrice,
                                                List<Integer> itemsetQty,
                                                double totalPrice,
                                                String time,
                                                String month,
                                                String day,
                                                String year){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                TransactionsOfSales transaction = db.createObject(TransactionsOfSales.class, new ObjectId());
                RealmList<String> itemsIDName = new RealmList<>(); itemsIDName.addAll(itemsetName);
                RealmList<Double> itemsIDPrice = new RealmList<>(); itemsIDPrice.addAll(itemsetPrice);
                RealmList<Integer> itemsIDAmount = new RealmList<>(); itemsIDAmount.addAll(itemsetQty);
                transaction.setNameOfEachItem(itemsIDName);
                transaction.setPriceOfEachItem(itemsIDPrice);
                transaction.setAmountOfEachItem(itemsIDAmount);
                transaction.setPriceOfAllItems(totalPrice);
                transaction.setTime(time);
                transaction.setMonth(month);
                transaction.setDay(day);
                transaction.setYear(year);
            });
        }
    }

    public static void toCreateInventoryTransaction(String operation,
                                                    String itemName,
                                                    int amountAdded,
                                                    int amountSubtracted,
                                                    String itemUnit){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                DateFormat currentDT = new SimpleDateFormat("yyyyMMMdhmmsS");
                DateFormat currentTime = new SimpleDateFormat("h:mm a");
                DateFormat currentMonth = new SimpleDateFormat("MMM");
                DateFormat currentDay = new SimpleDateFormat("d");
                DateFormat currentYear = new SimpleDateFormat("yyyy");
                String dt = currentDT.format(new Date());
                String time = currentTime.format(new Date());
                String month = currentMonth.format(new Date());
                String day = currentDay.format(new Date());
                String year = currentYear.format(new Date());

                TransactionsOfInventory transaction = db.createObject(TransactionsOfInventory.class, dt);
                transaction.setOperation(operation);
                transaction.setItemName(itemName);
                transaction.setStockIn(amountAdded);
                transaction.setStockOut(amountSubtracted);
                transaction.setItemUnit(itemUnit);
                transaction.setTime(time);
                transaction.setDay(day);
                transaction.setMonth(month);
                transaction.setYear(year);
            });
        }
    }
}
