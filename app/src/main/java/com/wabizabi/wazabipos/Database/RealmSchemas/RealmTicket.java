package com.wabizabi.wazabipos.Database.RealmSchemas;

import org.bson.types.ObjectId;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RealmTicket extends RealmObject {
    @PrimaryKey
    ObjectId _id;
    String ticketID; //0000000000 || yyDDDHHssS
    String order;
    String cashier; //Username
    String details;
    String orderType; //Dine In, Take Out etc.
    //CART OBJECT
    RealmList<String> itemWebName;
    RealmList<String> itemPOSName;
    RealmList<Double> itemPrice;
    RealmList<Integer> itemQty;
    //CART OBJECT DISCOUNTS
    RealmList<String> discountItem;
    RealmList<String> discountName;
    RealmList<Integer> discountPercent;
    //TIME STAMPS
    String dateAndTime; //January 02, 2023 | 12:30 pm  || MMMM dd , yyyy | hh:mm a
    String year; //2023 || yyyy
    String month; // 12 || MM
    String day; // 01 || dd
    String hour; // 24 || HH
    String minute; // 00 || mm


    public RealmTicket(){}

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public RealmList<String> getItemWebName() {
        return itemWebName;
    }

    public void setItemWebName(RealmList<String> itemWebName) {
        this.itemWebName = itemWebName;
    }

    public RealmList<String> getItemPOSName() {
        return itemPOSName;
    }

    public void setItemPOSName(RealmList<String> itemPOSName) {
        this.itemPOSName = itemPOSName;
    }

    public RealmList<Double> getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(RealmList<Double> itemPrice) {
        this.itemPrice = itemPrice;
    }

    public RealmList<Integer> getItemQty() {
        return itemQty;
    }

    public void setItemQty(RealmList<Integer> itemQty) {
        this.itemQty = itemQty;
    }

    public RealmList<String> getDiscountItem() {
        return discountItem;
    }

    public void setDiscountItem(RealmList<String> discountItem) {
        this.discountItem = discountItem;
    }

    public RealmList<String> getDiscountName() {
        return discountName;
    }

    public void setDiscountName(RealmList<String> discountName) {
        this.discountName = discountName;
    }

    public RealmList<Integer> getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(RealmList<Integer> discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }
}
