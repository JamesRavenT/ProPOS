package com.wabizabi.wazabipos.Database.ObjectSchemas;

import com.wabizabi.wazabipos.Utilities.Libraries.Objects.CartItem;

import java.util.LinkedHashMap;
import java.util.Map;

public class SalesTransaction {
    String dataVer; //v1.0
    String transactionID; //230126110400 || yyMMddHHmmsS
    String transactionNo; //00000-000 || yyDDD-000
    String dateAndTime; //00|00|00 || yy|MM|dd
    String cashier; //Username
    String order; //Table No || Customer Name
    String orderType; //Dine In, Take Out etc.
    Map<CartItem, Integer> items = new LinkedHashMap<>();
    int totalItems;
    double totalSubTotal;
    double totalTax;
    double totalServiceFee;
    double totalDiscount;
    double totalAmountDue;
    double totalPayment;
    double change;
    String paymentMethod;
    //TIME STAMPS
    String year; //2023 || yyyy
    String month; // 12 || MM
    String week; // 4 || W
    String dayTxt; // Monday ||  E
    String dayNo; // 01 || dd
    String hour;

    public SalesTransaction(){
    }

    public SalesTransaction(String transactionID, String transactionNo, String dateAndTime, String cashier, String order, String orderType, int totalItems, double totalSubTotal, double totalTax, double totalServiceFee, double totalDiscount, double totalAmountDue, String paymentMethod, double totalPayment, double change) {
        this.transactionID = transactionID;
        this.transactionNo = transactionNo;
        this.dateAndTime = dateAndTime;
        this.cashier = cashier;
        this.order = order;
        this.orderType = orderType;
        this.totalItems = totalItems;
        this.totalSubTotal = totalSubTotal;
        this.totalTax = totalTax;
        this.totalServiceFee = totalServiceFee;
        this.totalDiscount = totalDiscount;
        this.totalAmountDue = totalAmountDue;
        this.totalPayment = totalPayment;
        this.change = change;
        this.paymentMethod = paymentMethod;
    }

    public String getDataVer() {
        return dataVer;
    }

    public void setDataVer(String dataVer) {
        this.dataVer = dataVer;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
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

    public Map<CartItem, Integer> getItems() {
        return items;
    }

    public void setItems(Map<CartItem, Integer> items) {
        this.items = items;
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

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
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
}
