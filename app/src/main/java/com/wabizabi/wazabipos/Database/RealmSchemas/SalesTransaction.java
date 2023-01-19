package com.wabizabi.wazabipos.Database.RealmSchemas;

import org.bson.types.ObjectId;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class SalesTransaction extends RealmObject {
    @PrimaryKey
    ObjectId _id;
    String operation;
    String orderType;
    int tableNumber;
    int discountapplied;
    RealmList<String> name; //[item A, item B, item C]
    RealmList<Double> price; //[P100, P200, P300]
    RealmList<Integer> quantity; //[1, 2, 3]
    double priceOfAllItems;
    //TIME
    String timestamp;
    String month;
    String week;
    String dayNumber;
    String dayText;
    String year;
    String time;
    String hour;

    public SalesTransaction(){}

    public SalesTransaction(String operation,
                            String orderType,
                            int tableNumber,
                            int discountapplied,
                            RealmList<String> nameOfEachItem,
                            RealmList<Double> priceOfEachItem,
                            RealmList<Integer> amountOfEachItem,
                            double priceOfAllItems,
                            String timestamp,
                            String month,
                            String week,
                            String dayNumber,
                            String dayText,
                            String year,
                            String time,
                            String hour) {
        this.operation = operation;
        this.orderType = orderType;
        this.tableNumber = tableNumber;
        this.discountapplied = discountapplied;
        this.name = nameOfEachItem;
        this.price = priceOfEachItem;
        this.quantity = amountOfEachItem;
        this.priceOfAllItems = priceOfAllItems;
        this.timestamp = timestamp;
        this.month = month;
        this.week = week;
        this.dayNumber = dayNumber;
        this.dayText = dayText;
        this.year = year;
        this.time = time;
        this.hour = hour;
    }

    public String getOperation() { return operation; }
    public String getOrderType() { return orderType; }
    public int getTableNumber() { return tableNumber; }
    public int getDiscountapplied() { return discountapplied; }
    public RealmList<String> getName() { return name; }
    public RealmList<Double> getPrice() { return price; }
    public RealmList<Integer> getQuantity() { return quantity; }
    public double getPriceOfAllItems() { return priceOfAllItems; }
    public String getTimestamp() { return timestamp; }
    public String getMonth() { return month; }
    public String getWeek() { return week; }
    public String getDayNumber() { return dayNumber; }
    public String getDayText() { return dayText; }
    public String getYear() { return year; }
    public String getTime() { return time; }
    public String getHour() { return hour; }

    public void setOperation(String operation) { this.operation = operation; }
    public void setOrderType(String orderType) { this.orderType = orderType; }
    public void setTableNumber(int tableNumber) { this.tableNumber = tableNumber; }
    public void setDiscountapplied(int discountapplied) { this.discountapplied = discountapplied; }
    public void setName(RealmList<String> name) { this.name = name; }
    public void setPrice(RealmList<Double> price) { this.price = price; }
    public void setQuantity(RealmList<Integer> quantity) { this.quantity = quantity; }
    public void setPriceOfAllItems(double priceOfAllItems) { this.priceOfAllItems = priceOfAllItems; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp;}
    public void setMonth(String month) { this.month = month; }
    public void setWeek(String week) { this.week = week; }
    public void setDayNumber(String dayNumber) { this.dayNumber = dayNumber; }
    public void setDayText(String dayText) { this.dayText = dayText; }
    public void setYear(String year) { this.year = year; }
    public void setTime(String time) { this.time = time; }
    public void setHour(String hour) { this.hour = hour; }




}
