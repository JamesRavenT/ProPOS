package com.wabizabi.wazabipos.Database.ObjectSchemas;

import com.wabizabi.wazabipos.Utilities.Libraries.Objects.CartItem;

import java.util.LinkedHashMap;
import java.util.Map;

public class Ticket {
    String ticketID; //00000-000 || yyDDDHHssS
    String ticketStatus;
    String order;
    String cashier; //Username
    String details;
    String orderType; //Dine In, Take Out etc.
    Map<CartItem, Integer> items = new LinkedHashMap<>();
    //TIME STAMPS
    String dateAndTime; //January 02, 2023 | 12:30 pm  || MMMM dd , yyyy | hh:mm a
    String year; //2023 || yyyy
    String month; // 12 || MM
    String day;
    String hour; // 24 || HH
    String minute; // 00 || mm

    public Ticket(){}

    //Normal Ticket
    public Ticket(String ticketID, String ticketStatus, String order, String cashier, String details, String orderType, String dateAndTime, String year, String month, String day, String hour, String minute) {
        this.ticketID = ticketID;
        this.ticketStatus = ticketStatus;
        this.order = order;
        this.cashier = cashier;
        this.details = details;
        this.orderType = orderType;
        this.dateAndTime = dateAndTime;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    //Printable Ticket
    public Ticket(String order, String cashier, String orderType, Map<CartItem, Integer> items, String dateAndTime) {
        this.order = order;
        this.cashier = cashier;
        this.orderType = orderType;
        this.items = items;
        this.dateAndTime = dateAndTime;
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

    public Map<CartItem, Integer> getItems() {
        return items;
    }

    public void setItems(Map<CartItem, Integer> items) {
        this.items = items;
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

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
