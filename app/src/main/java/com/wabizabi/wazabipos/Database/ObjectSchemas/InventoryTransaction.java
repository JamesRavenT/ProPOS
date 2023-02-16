package com.wabizabi.wazabipos.Database.ObjectSchemas;

public class InventoryTransaction {
    String transactionID;
    String transactionDT;
    String itemName;
    String transactionType;
    int amount;
    String itemUnit;
    String day, month, year;

    public InventoryTransaction(){}

    public InventoryTransaction(String transactionID, String transactionDT, String transactionType, String itemName,  int amount, String itemUnit, String day, String month, String year) {
        this.transactionID = transactionID;
        this.transactionDT = transactionDT;
        this.transactionType = transactionType;
        this.itemName = itemName;
        this.amount = amount;
        this.itemUnit = itemUnit;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getTransactionDT() {
        return transactionDT;
    }

    public void setTransactionDT(String transactionDT) {
        this.transactionDT = transactionDT;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getItemUnit() {
        return itemUnit;
    }

    public void setItemUnit(String itemUnit) {
        this.itemUnit = itemUnit;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
