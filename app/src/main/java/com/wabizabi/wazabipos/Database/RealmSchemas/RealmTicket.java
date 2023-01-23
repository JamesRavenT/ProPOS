package com.wabizabi.wazabipos.Database.RealmSchemas;

import org.bson.types.ObjectId;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RealmTicket extends RealmObject {
    @PrimaryKey
    ObjectId _id;
    String ticketID;
    String dateAndTime;
    String orderType;
    String tableName;
    int tableNumber;
    String customerName;
    String cashierName;
    String additionalDetails;
    //CARTOBJECT <name, price, frequency>
    RealmList<String> itemName;
    RealmList<Double> itemPrice;
    RealmList<Integer> itemQty;
    //DISCOUNT
    RealmList<String> discountItem;
    RealmList<String> discountName;
    RealmList<Integer> discountPercentage;

    public RealmTicket(){}



    public String getTicketID() { return ticketID; }
    public String getDateAndTime() { return dateAndTime; }
    public String getCashierName() { return cashierName; }
    public String getOrderType() { return orderType; }
    public String getTableName() { return tableName; }
    public int getTableNumber() { return tableNumber; }
    public String getCustomerName() { return customerName; }
    public String getAdditionalDetails() { return additionalDetails; }
    public RealmList<String> getItemName() { return itemName; }
    public RealmList<Double> getItemPrice() { return itemPrice; }
    public RealmList<Integer> getItemQty() { return itemQty; }
    public RealmList<String> getDiscountItem() { return discountItem; }
    public RealmList<String> getDiscountName() { return discountName; }
    public RealmList<Integer> getDiscountPercentage() { return discountPercentage; }

    public void setTicketID(String ticketID) { this.ticketID = ticketID; }
    public void setDateAndTime(String dateAndTime) { this.dateAndTime = dateAndTime; }
    public void setCashierName(String cashierName) { this.cashierName = cashierName; }
    public void setOrderType(String orderType) { this.orderType = orderType; }
    public void setTableName(String tableName) { this.tableName = tableName; }
    public void setTableNumber(int tableNumber) { this.tableNumber = tableNumber; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public void setAdditionalDetails(String additionalDetails) { this.additionalDetails = additionalDetails; }
    public void setItemName(RealmList<String> itemName) { this.itemName = itemName; }
    public void setItemPrice(RealmList<Double> itemPrice) { this.itemPrice = itemPrice; }
    public void setItemQty(RealmList<Integer> itemQty) { this.itemQty = itemQty; }
    public void setDiscountItem(RealmList<String> discountItem) { this.discountItem = discountItem; }
    public void setDiscountName(RealmList<String> discountName) { this.discountName = discountName;}
    public void setDiscountPercentage(RealmList<Integer> discountPercentage) { this.discountPercentage = discountPercentage; }

}
