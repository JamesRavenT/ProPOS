package com.wabizabi.wazabipos.Database.Instances;


import com.wabizabi.wazabipos.Database.Schemas.InventoryTransaction;
import com.wabizabi.wazabipos.Database.Schemas.SalesTransaction;

import org.bson.types.ObjectId;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;

public class OpenTransactionsInstance {

    public static void toCreateSales(List<String> itemsetName,
                                     List<Double> itemsetPrice,
                                     List<Integer> itemsetQty,
                                     double totalPrice){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                //DATE AND TIME
                DateFormat currentTimeStamp = new SimpleDateFormat("yyyyMMdhmmsS");
                DateFormat currentYear = new SimpleDateFormat("yyyy");
                DateFormat currentMonth = new SimpleDateFormat("MMMM");
                DateFormat currentWeek = new SimpleDateFormat("W");
                DateFormat currentDay = new SimpleDateFormat("d");
                DateFormat currentDoW = new SimpleDateFormat("EEEE");
                DateFormat currentTime = new SimpleDateFormat("h:mm a");
                DateFormat currentHour = new SimpleDateFormat("k");
                String timestamp = currentTimeStamp.format(new Date());
                String year = currentYear.format(new Date());
                String month = currentMonth.format(new Date());
                String week = currentWeek.format(new Date());
                String day = currentDay.format(new Date());
                String dow = currentDoW.format(new Date());
                String time = currentTime.format(new Date());
                String hour = currentHour.format(new Date());

                //TRANSACTION
                SalesTransaction transaction = db.createObject(SalesTransaction.class, new ObjectId());
                RealmList<String> itemsIDName = new RealmList<>(); itemsIDName.addAll(itemsetName);
                RealmList<Double> itemsIDPrice = new RealmList<>(); itemsIDPrice.addAll(itemsetPrice);
                RealmList<Integer> itemsIDAmount = new RealmList<>(); itemsIDAmount.addAll(itemsetQty);
                transaction.setNameOfEachItem(itemsIDName);
                transaction.setPriceOfEachItem(itemsIDPrice);
                transaction.setAmountOfEachItem(itemsIDAmount);
                transaction.setPriceOfAllItems(totalPrice);
                transaction.setTimestamp(timestamp);
                transaction.setYear(year);
                transaction.setMonth(month);
                transaction.setWeek(week);
                transaction.setDayNumber(day);
                transaction.setDayText(dow);
                transaction.setTime(time);
                transaction.setHour(hour);
            });
        }
    }

    public static void toUpdateInventory(String operation,
                                         String itemName,
                                         int amountAdded,
                                         int amountSubtracted,
                                         String itemUnit){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                //DATE AND TIME
                DateFormat currentDT = new SimpleDateFormat("yyyyMMdhmmsS");
                DateFormat currentTime = new SimpleDateFormat("h:mm a");
                DateFormat currentMonth = new SimpleDateFormat("MMMM");
                DateFormat currentDay = new SimpleDateFormat("d");
                DateFormat currentYear = new SimpleDateFormat("yyyy");
                String dt = currentDT.format(new Date());
                String time = currentTime.format(new Date());
                String month = currentMonth.format(new Date());
                String day = currentDay.format(new Date());
                String year = currentYear.format(new Date());

                //TRANSACTION
                InventoryTransaction transaction = db.createObject(InventoryTransaction.class, dt);
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
