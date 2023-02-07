package com.wabizabi.wazabipos.Database.Instances;

import com.wabizabi.wazabipos.Database.RealmSchemas.RealmTicket;

import org.bson.types.ObjectId;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;

public class OpenTicketInstance {

    public static void toCreateTicket(
                                     String order,
                                     String cashier,
                                     String details,
                                     String ordertype,
                                     List<String> itemWebName,
                                     List<String> itemPOSName,
                                     List<Double> itemPrice,
                                     List<Integer> itemQty,
                                     List<String> discountItem,
                                     List<String> discountName,
                                     List<Integer> discountPercentage){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                //Date And Time
                String ticketID = new SimpleDateFormat("yyDDDHHssS").format(new Date());
                String dateAndTime = new SimpleDateFormat("MMMM dd , yyyy | hh:mm a").format(new Date());
                String year = new SimpleDateFormat("yyyy").format(new Date());
                String month = new SimpleDateFormat("M").format(new Date());
                String day = new SimpleDateFormat("d").format(new Date());
                String hour = new SimpleDateFormat("HH").format(new Date());
                String minute = new SimpleDateFormat("mm").format(new Date());


                //Initiate Lists
                RealmList<String> listOfItemWebName = new RealmList<>(); listOfItemWebName.addAll(itemWebName);
                RealmList<String> listOfItemPOSName = new RealmList<>(); listOfItemPOSName.addAll(itemPOSName);
                RealmList<Double> listOfItemPrice = new RealmList<>(); listOfItemPrice.addAll(itemPrice);
                RealmList<Integer> listOfItemQty = new RealmList<>(); listOfItemQty.addAll(itemQty);
                RealmList<String> listOfDiscountItem = new RealmList<>(); listOfDiscountItem.addAll(discountItem);
                RealmList<String> listOfDiscountName = new RealmList<>(); listOfDiscountName.addAll(discountName);
                RealmList<Integer> listOfDiscountPercentage = new RealmList<>(); listOfDiscountPercentage.addAll(discountPercentage);

                //Create Object
                RealmTicket ticket = db.createObject(RealmTicket.class, new ObjectId());
                ticket.setTicketID(ticketID);
                ticket.setOrder(order);
                ticket.setCashier(cashier);
                ticket.setDetails(details);
                ticket.setOrderType(ordertype);
                //CARTOBJECT
                ticket.setItemWebName(listOfItemWebName);
                ticket.setItemPOSName(listOfItemPOSName);
                ticket.setItemPrice(listOfItemPrice);
                ticket.setItemQty(listOfItemQty);
                //DISCOUNT
                ticket.setDiscountItem(listOfDiscountItem);
                ticket.setDiscountName(listOfDiscountName);
                ticket.setDiscountPercent(listOfDiscountPercentage);
                //DATE AND TIME
                ticket.setDateAndTime(dateAndTime);
                ticket.setYear(year);
                ticket.setMonth(month);
                ticket.setDay(day);
                ticket.setHour(hour);
                ticket.setMinute(minute);
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
