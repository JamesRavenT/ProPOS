package com.wabizabi.wazabipos.Database.Schemas;

import org.bson.types.ObjectId;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class SalesTransaction extends RealmObject {
    @PrimaryKey
    ObjectId _id;
    RealmList<String> nameOfEachItem;
    RealmList<Double> priceOfEachItem;
    RealmList<Integer> amountOfEachItem;
    double priceOfAllItems;
    String timestamp;
    String month;
    String week;
    String dayNumber;
    String dayText;
    String year;
    String time;
    String hour;

    public SalesTransaction(){}


    public String getTimestamp() { return timestamp; }
    public RealmList<String> getNameOfEachItem() { return nameOfEachItem; }
    public RealmList<Double> getPriceOfEachItem() { return priceOfEachItem; }
    public RealmList<Integer> getAmountOfEachItem() { return amountOfEachItem; }
    public double getPriceOfAllItems() { return priceOfAllItems; }
    public String getMonth() { return month; }
    public String getWeek() { return week; }
    public String getDayNumber() { return dayNumber; }
    public String getDayText() { return dayText; }
    public String getYear() { return year; }
    public String getTime() { return time; }
    public String getHour() { return hour; }

    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
    public void setNameOfEachItem(RealmList<String> nameOfEachItem) { this.nameOfEachItem = nameOfEachItem; }
    public void setPriceOfEachItem(RealmList<Double> priceOfEachItem) { this.priceOfEachItem = priceOfEachItem; }
    public void setAmountOfEachItem(RealmList<Integer> amountOfEachItem) { this.amountOfEachItem = amountOfEachItem; }
    public void setPriceOfAllItems(double priceOfAllItems) { this.priceOfAllItems = priceOfAllItems; }
    public void setMonth(String month) { this.month = month; }
    public void setWeek(String week) { this.week = week; }
    public void setDayNumber(String dayNumber) { this.dayNumber = dayNumber; }
    public void setDayText(String dayText) { this.dayText = dayText; }
    public void setYear(String year) { this.year = year; }
    public void setTime(String time) { this.time = time; }
    public void setHour(String hour) { this.hour = hour; }
}
