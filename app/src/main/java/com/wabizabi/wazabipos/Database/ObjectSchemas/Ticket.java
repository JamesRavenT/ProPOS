package com.wabizabi.wazabipos.Database.ObjectSchemas;

import com.wabizabi.wazabipos.Utilities.Objects.CartObject;

import org.bson.types.ObjectId;

import java.util.LinkedHashMap;
import java.util.Map;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Ticket {
    String ticketID;
    String dateAndTime;
    String orderType;
    String tableName;
    int tableNumber;
    String customerName;
    String cashierName;
    String additionalDetails;
    Map<CartObject, Integer> items = new LinkedHashMap<>();

    public Ticket(){}
    public Ticket(String ticketID, String dateAndTime, String orderType, String tableName, int tableNumber, String customerName, String cashierName, String additionalDetails) {
        this.ticketID = ticketID;
        this.dateAndTime = dateAndTime;
        this.orderType = orderType;
        this.tableName = tableName;
        this.tableNumber = tableNumber;
        this.customerName = customerName;
        this.cashierName = cashierName;
        this.additionalDetails = additionalDetails;
    }

    public String getTicketID() { return ticketID; }
    public String getDateAndTime() { return dateAndTime; }
    public String getOrderType() { return orderType; }
    public String getTableName() { return tableName; }
    public int getTableNumber() { return tableNumber; }
    public String getCustomerName() { return customerName; }
    public String getCashierName() { return cashierName; }
    public String getAdditionalDetails() { return additionalDetails; }
    public Map<CartObject, Integer> getItems() { return items; }

    public void setTicketID(String ticketID) { this.ticketID = ticketID; }
    public void setDateAndTime(String dateAndTime) { this.dateAndTime = dateAndTime; }
    public void setOrderType(String orderType) { this.orderType = orderType; }
    public void setTableName(String tableName) { this.tableName = tableName; }
    public void setTableNumber(int tableNumber) { this.tableNumber = tableNumber; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public void setAdditionalDetails(String additionalDetails) { this.additionalDetails = additionalDetails; }
    public void setCashierName(String cashierName) { this.cashierName = cashierName; }
    public void setItems(Map<CartObject, Integer> items) { this.items = items; }
}
