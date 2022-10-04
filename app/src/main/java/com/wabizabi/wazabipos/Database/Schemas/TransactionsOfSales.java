package com.wabizabi.wazabipos.Database.Schemas;

import org.bson.types.ObjectId;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class TransactionsOfSales extends RealmObject {
    @PrimaryKey
    ObjectId _id;
    RealmList<String> nameOfEachItem;
    RealmList<Double> priceOfEachItem;
    RealmList<Integer> amountOfEachItem;
    double priceOfAllItems;
    String time;
    String month;
    String day;
    String year;

    public TransactionsOfSales(){}

    public TransactionsOfSales(RealmList<String> nameOfEachItem, RealmList<Double> priceOfEachItem, RealmList<Integer> amountOfEachItem, double priceOfAllItems, String time, String month, String day, String year) {
        this.nameOfEachItem = nameOfEachItem;
        this.priceOfAllItems = priceOfAllItems;
        this.time = time;
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public RealmList<String> getNameOfEachItem() {
        return nameOfEachItem;
    }
    public RealmList<Double> getPriceOfEachItem() { return priceOfEachItem; }
    public RealmList<Integer> getAmountOfEachItem() { return amountOfEachItem; }
    public double getPriceOfAllItems() {
        return priceOfAllItems;
    }
    public String getTime() {
        return time;
    }
    public String getMonth() {
        return month;
    }
    public String getDay() {
        return day;
    }
    public String getYear() {
        return year;
    }

    public void setNameOfEachItem(RealmList<String> nameOfEachItem) { this.nameOfEachItem = nameOfEachItem; }
    public void setPriceOfEachItem(RealmList<Double> priceOfEachItem) { this.priceOfEachItem = priceOfEachItem; }
    public void setAmountOfEachItem(RealmList<Integer> amountOfEachItem) { this.amountOfEachItem = amountOfEachItem; }
    public void setPriceOfAllItems(double priceOfAllItems) { this.priceOfAllItems = priceOfAllItems; }
    public void setTime(String time) {
        this.time = time;
    }
    public void setMonth(String month) {
        this.month = month;
    }
    public void setDay(String day) {
        this.day = day;
    }
    public void setYear(String year) {
        this.year = year;
    }
}
