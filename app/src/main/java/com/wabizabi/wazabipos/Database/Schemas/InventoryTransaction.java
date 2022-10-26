package com.wabizabi.wazabipos.Database.Schemas;

import org.bson.types.ObjectId;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class InventoryTransaction extends RealmObject {
    @PrimaryKey
    ObjectId _id;
    String itemName;
    String operation;
    int amount;
    String itemUnit;
    String timestamp;
    String time, day, month, year;

    public InventoryTransaction(){}

    public InventoryTransaction(String itemName, String operation, int amount, String itemUnit, String time, String day, String month, String year) {
        this.itemName = itemName;
        this.operation = operation;
        this.amount = amount;
        this.itemUnit = itemUnit;
        this.time = time;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getItemName() { return itemName; }
    public String getOperation() { return operation; }
    public int getAmount() { return amount; }
    public String getItemUnit() { return itemUnit; }
    public String getTimestamp() { return timestamp; }
    public String getTime() { return time; }
    public String getDay() { return day; }
    public String getMonth() { return month; }
    public String getYear() { return year; }

    public void setItemName(String itemName) { this.itemName = itemName; }
    public void setOperation(String operation) { this.operation = operation; }
    public void setAmount(int amount) { this.amount = amount; }
    public void setItemUnit(String itemUnit) { this.itemUnit = itemUnit; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
    public void setTime(String time) { this.time = time; }
    public void setDay(String day) { this.day = day; }
    public void setMonth(String month) { this.month = month;}
    public void setYear(String year) { this.year = year; }
}
