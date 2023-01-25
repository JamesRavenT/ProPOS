package com.wabizabi.wazabipos.Database.Instances;

import com.wabizabi.wazabipos.Database.RealmSchemas.RealmTicket;

import org.bson.types.ObjectId;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;

public class OpenTicketInstance {

    public static void toCreateTicket(String cashier,
                                     String ordertype,
                                     String tableName,
                                     int tableNumber,
                                     String customerName,
                                     String details,
                                     List<String> itemName,
                                     List<Double> itemPrice,
                                     List<Integer> itemQty,
                                     List<String> discountItem,
                                     List<String> discountName,
                                     List<Integer> discountPercentage){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                //Date And Time
                DateFormat currentTimeStamp = new SimpleDateFormat("yyMMddHH-mmss");
                DateFormat currentDateAndTime = new SimpleDateFormat("MMMM dd, yyyy | HH:mm a");
                String ticketID = currentTimeStamp.format(new Date());
                String dateAndTime = currentDateAndTime.format(new Date());

                //Initiate Lists
                RealmList<String> listOfItemName = new RealmList<>(); listOfItemName.addAll(itemName);
                RealmList<Double> listOfItemPrice = new RealmList<>(); listOfItemPrice.addAll(itemPrice);
                RealmList<Integer> listOfItemQty = new RealmList<>(); listOfItemQty.addAll(itemQty);
                RealmList<String> listOfDiscountItem = new RealmList<>(); listOfDiscountItem.addAll(discountItem);
                RealmList<String> listOfDiscountName = new RealmList<>(); listOfDiscountName.addAll(discountName);
                RealmList<Integer> listOfDiscountPercentage = new RealmList<>(); listOfDiscountPercentage.addAll(discountPercentage);

                //Create Object
                RealmTicket ticket = db.createObject(RealmTicket.class, new ObjectId());
                ticket.setTicketID(ticketID);
                ticket.setDateAndTime(dateAndTime);
                ticket.setOrderType(ordertype);
                ticket.setTableName(tableName);
                ticket.setTableNumber(tableNumber);
                ticket.setCustomerName(customerName);
                ticket.setCashierName(cashier);
                ticket.setAdditionalDetails(details);
                ticket.setItemName(listOfItemName);
                ticket.setItemPrice(listOfItemPrice);
                ticket.setItemQty(listOfItemQty);
                ticket.setDiscountItem(listOfDiscountItem);
                ticket.setDiscountName(listOfDiscountName);
                ticket.setDiscountPercentage(listOfDiscountPercentage);
            });
        }
    }

    public static void toDeleteTicket(String ticketID){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmTicket ticket = db.where(RealmTicket.class).equalTo("ticketID", ticketID).findFirst();
                ticket.deleteFromRealm();
            });
        }
    }
}
