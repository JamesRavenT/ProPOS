package com.wabizabi.wazabipos.Database.Schemas;

import org.bson.types.ObjectId;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class TransactionsOfInventory extends RealmObject {
    @PrimaryKey
    String _id;
    String operation;
    String itemName;
    int stockIn, stockOut;
    String itemUnit;
    String time, day, month, year;

    public TransactionsOfInventory(){}

    public TransactionsOfInventory(String _id, String operation, String itemName, int stockIn, int stockOut, String itemUnit, String time, String day, String month, String year) {
        this._id = _id;
        this.operation = operation;
        this.itemName = itemName;
        this.stockIn = stockIn;
        this.stockOut = stockOut;
        this.itemUnit = itemUnit;
        this.time = time;
        this.day = day;
        this.month = month;
        this.year = year;
    }


    public String get_id() { return _id; }
    public String getOperation() { return operation; }
    public String getItemName() { return itemName; }
    public int getStockIn() { return stockIn; }
    public int getStockOut() { return stockOut; }
    public String getItemUnit() { return itemUnit; }
    public String getTime() { return time; }
    public String getDay() { return day; }
    public String getMonth() { return month; }
    public String getYear() { return year; }

    public void set_id(String _id) { this._id = _id; }
    public void setOperation(String operation) { this.operation = operation; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public void setStockIn(int stockIn) { this.stockIn = stockIn; }
    public void setStockOut(int stockOut) { this.stockOut = stockOut; }
    public void setItemUnit(String itemUnit) { this.itemUnit = itemUnit; }
    public void setTime(String time) { this.time = time; }
    public void setDay(String day) { this.day = day; }
    public void setMonth(String month) { this.month = month; }
    public void setYear(String year) { this.year = year; }
}
