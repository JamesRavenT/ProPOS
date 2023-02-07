package com.wabizabi.wazabipos.Utilities.Libraries.Bundles;

import com.wabizabi.wazabipos.Database.ObjectSchemas.Discount;
import com.wabizabi.wazabipos.Database.ObjectSchemas.MenuCategory;
import com.wabizabi.wazabipos.Database.ObjectSchemas.MenuItem;
import com.wabizabi.wazabipos.Database.ObjectSchemas.PaymentMethod;
import com.wabizabi.wazabipos.Database.ObjectSchemas.StockCategory;
import com.wabizabi.wazabipos.Database.ObjectSchemas.StockItem;
import com.wabizabi.wazabipos.Database.ObjectSchemas.Table;
import com.wabizabi.wazabipos.Database.ObjectSchemas.Ticket;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.CartHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Objects.CartItem;

public class DialogBundle {
    int dialogDestinationNo;
    MenuCategory menuCategory;
    MenuItem menuItem;
    CartItem cartItem;
    Ticket ticket;

    String orderName;
    String orderType;
    String paymentMethod;
    double amountDue;
    double amountRecieved;

    Table table;
    String customerName;
    String additionalDetails;
    String tableName;
    Discount discount;
    PaymentMethod method;
    StockCategory stockCategory;
    StockItem stockItem;
    RVBundle rvBundle;

    //MenuCategory Bundle
    public DialogBundle(int dialogDestinationNo, MenuCategory menuCategory) {
        this.dialogDestinationNo = dialogDestinationNo;
        this.menuCategory = menuCategory;
    }

    //MenuItem Bundle
    public DialogBundle(int dialogDestinationNo, MenuItem menuItem, RVBundle rvBundle) {
        this.dialogDestinationNo = dialogDestinationNo;
        this.menuItem = menuItem;
        this.rvBundle = rvBundle;
    }

    //MenuItem Bundle
    public DialogBundle(int dialogDestinationNo, MenuItem menuItem) {
        this.dialogDestinationNo = dialogDestinationNo;
        this.menuItem = menuItem;
    }

    //CartItem Bundle
    public DialogBundle(int dialogDestinationNo, CartItem cartItem){
        this.dialogDestinationNo = dialogDestinationNo;
        this.cartItem = cartItem;
    }

    //Ticket Bundle
    public DialogBundle(int dialogDestinationNo, Ticket ticket){
        this.dialogDestinationNo = dialogDestinationNo;
        this.ticket = ticket;
    }

    //Payment Bundle
    public DialogBundle(int dialogDestinationNo, String orderName, String orderType, double amountDue){
        this.dialogDestinationNo = dialogDestinationNo;
        this.orderName = orderName;
        this.orderType = orderType;
        this.amountDue = amountDue;
    }

    //Table Bundle
    public DialogBundle(int dialogDestinationNo, Table tableObj) {
        this.dialogDestinationNo = dialogDestinationNo;
        this.table = tableObj;
    }

    //Table With Details Bundle
    public DialogBundle(int dialogNo, Table table, String details){
        this.dialogDestinationNo = dialogNo;
        this.table = table;
        this.additionalDetails = details;
    }

    //Customer Name With Details Bundle
    public DialogBundle(int dialogNo, String customerName, String details){
        this.dialogDestinationNo = dialogNo;
        this.customerName = customerName;
        this.additionalDetails = details;
    }

    //Table Name Bundle
    public DialogBundle(int dialogNo, String tableName){
        this.dialogDestinationNo = dialogNo;
        this.tableName = tableName;
    }



    //Discount Bundle
    public DialogBundle(int dialogDestinationNo, Discount discount) {
        this.dialogDestinationNo = dialogDestinationNo;
        this.discount = discount;
    }

    //PaymentMethod Bundle
    public DialogBundle(int dialogDestinationNo, PaymentMethod method) {
        this.dialogDestinationNo = dialogDestinationNo;
        this.method = method;
    }

    //Stock Category Bundle
    public DialogBundle(int dialogDestinationNo, StockCategory stockCategory) {
        this.dialogDestinationNo = dialogDestinationNo;
        this.stockCategory = stockCategory;
    }

    //StockItem bundle
    public DialogBundle(int dialogDestinationNo, StockItem stockItem, RVBundle rvBundle) {
        this.dialogDestinationNo = dialogDestinationNo;
        this.stockItem = stockItem;
        this.rvBundle = rvBundle;
    }

    //StockItem bundle
    public DialogBundle(int dialogDestinationNo, StockItem stockItem) {
        this.dialogDestinationNo = dialogDestinationNo;
        this.stockItem = stockItem;
    }

    public int getDialogDestinationNo() { return dialogDestinationNo; }
    public RVBundle getRvBundle() { return rvBundle; }
    public MenuCategory getMenuCategory() { return menuCategory; }
    public MenuItem getMenuItem() { return menuItem; }
    public CartItem getCartItem() { return cartItem; }
    public Table getTable() { return table; }
    public Ticket getTicket() { return ticket; }
    public String getOrderName() { return orderName; }
    public String getOrderType() { return orderType; }
    public double getAmountDue() { return amountDue; }
    public double getAmountRecieved() { return amountRecieved; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getCustomerName() { return customerName; }
    public String getAdditionalDetails() { return additionalDetails; }
    public String getTableName() { return tableName; }
    public Discount getDiscount() { return discount; }
    public PaymentMethod getMethod() { return method; }
    public StockCategory getStockCategory() { return stockCategory; }
    public StockItem getStockItem() { return stockItem; }



    public void setDialogDestinationNo(int dialogDestinationNo) { this.dialogDestinationNo = dialogDestinationNo; }
    public void setRvBundle(RVBundle rvBundle) { this.rvBundle = rvBundle; }
    public void setMenuCategory(MenuCategory menuCategory) { this.menuCategory = menuCategory; }
    public void setCartItem(CartItem cartItem) { this.cartItem = cartItem; }
    public void setAmountRecieved(double amountRecieved) { this.amountRecieved = amountRecieved; }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
