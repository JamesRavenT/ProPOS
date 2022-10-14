package com.wabizabi.wazabipos.Database.Schemas;

import org.bson.types.ObjectId;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class TransactionsOfInventory extends RealmObject {
    @PrimaryKey
    ObjectId _id;
    String operation;
    String itemName;
    int amountAdded, amountSubtracted;
    String time, day, month, year;

    public TransactionsOfInventory(){}

    public TransactionsOfInventory(String operation, String itemName, int amountAdded, int amountSubtracted, String time, String day, String month, String year) {
        this.operation = operation;
        this.itemName = itemName;
        this.amountAdded = amountAdded;
        this.amountSubtracted = amountSubtracted;
        this.time = time;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getOperation() { return operation; }
    public String getItemName() { return itemName; }
    public int getAmountAdded() { return amountAdded; }
    public int getAmountSubtracted() { return amountSubtracted; }
    public String getTime() { return time; }
    public String getDay() { return day; }
    public String getMonth() { return month; }
    public String getYear() { return year; }

    public void setOperation(String operation) { this.operation = operation; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public void setAmountAdded(int amountAdded) { this.amountAdded = amountAdded; }
    public void setAmountSubtracted(int amountSubtracted) { this.amountSubtracted = amountSubtracted; }
    public void setTime(String time) { this.time = time; }
    public void setDay(String day) { this.day = day; }
    public void setMonth(String month) { this.month = month; }
    public void setYear(String year) { this.year = year; }
}
