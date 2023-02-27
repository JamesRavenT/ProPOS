package com.wabizabi.wazabipos.Database.RealmSchemas;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RealmSalesTransaction extends RealmObject {
    @PrimaryKey
    String _id; //230126110400 || yyMMddHHmmsSSS
    String transactionNo; //00000-000 || yyDDD-000
    String transactionType;
    String dateAndTime; //00|00|00 || yy|MM|dd
    String cashier; //Username
    String order; //Table No || Customer Name
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
    int totalItems;
    double totalSubTotal;
    double totalTax;
    double totalServiceFee;
    double totalDiscount;
    double totalAmountDue;
    String paymentMethod;
    double totalPayment;
    double totalChange;
    //TIME STAMPS
    String year; //2023 || yyyy
    String month; // 12 || MM
    String week; // 4 || W
    String dayTxt; // Monday ||  E
    String dayNo; // 01 || dd
    String hour; // 01 || hh

    public RealmSalesTransaction(){

    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
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

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public double getTotalSubTotal() {
        return totalSubTotal;
    }

    public void setTotalSubTotal(double totalSubTotal) {
        this.totalSubTotal = totalSubTotal;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }

    public double getTotalServiceFee() {
        return totalServiceFee;
    }

    public void setTotalServiceFee(double totalServiceFee) {
        this.totalServiceFee = totalServiceFee;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public double getTotalAmountDue() {
        return totalAmountDue;
    }

    public void setTotalAmountDue(double totalAmountDue) {
        this.totalAmountDue = totalAmountDue;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public double getTotalChange() {
        return totalChange;
    }

    public void setTotalChange(double totalChange) {
        this.totalChange = totalChange;
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

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getDayTxt() {
        return dayTxt;
    }

    public void setDayTxt(String dayTxt) {
        this.dayTxt = dayTxt;
    }

    public String getDayNo() {
        return dayNo;
    }

    public void setDayNo(String dayNo) {
        this.dayNo = dayNo;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}
