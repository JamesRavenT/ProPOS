package com.wabizabi.wazabipos.Utilities.Libraries.Helper;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.M04F01SF03_CartRVA.cart;

import com.wabizabi.wazabipos.Database.ObjectSchemas.PaymentMethod;
import com.wabizabi.wazabipos.Database.ObjectSchemas.SalesTransaction;
import com.wabizabi.wazabipos.Database.ObjectSchemas.Table;
import com.wabizabi.wazabipos.Database.ObjectSchemas.Ticket;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmDiscount;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmPaymentMethod;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmSalesTransaction;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmTable;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmTicket;
import com.wabizabi.wazabipos.Utilities.Libraries.Objects.CartItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

public class CartHelper {

    //--DG04--//
    public static Map<String, Integer> getAppliedDiscounts(){
        Map<String, Integer> listOfDiscountsApplied = new TreeMap<>();
        for(CartItem cartItem : cart.keySet()){
            Map<String, Integer> discountsWithinTheItem = cartItem.getItemDiscounts();
            if(!discountsWithinTheItem.isEmpty()){
                for(Map.Entry<String, Integer> discount : discountsWithinTheItem.entrySet()){
                    if(listOfDiscountsApplied.containsKey(discount.getKey())){
                        listOfDiscountsApplied.put(discount.getKey(),  listOfDiscountsApplied.get(discount.getKey())+ 1);
                    } else {
                        listOfDiscountsApplied.put(discount.getKey(), 1);
                    }
                }
            }
        }
        return listOfDiscountsApplied;
    }

    //--DG05--//
    public static List<CartItem> getItemsAppliedWith(String discount){
        List<CartItem> itemsAppliedWithCurrentDiscount = new ArrayList<>();
        for(CartItem cartItem : cart.keySet()){
            if(cartItem.getItemDiscounts().containsKey(discount)){
                itemsAppliedWithCurrentDiscount.add(cartItem);
            }
        }
        return itemsAppliedWithCurrentDiscount;
    }

    //--DG06--//
    public static Map<String, Integer> getListOfDiscounts(Realm realm){
        Map<String, Integer> listOfDiscounts = new TreeMap<>();
        RealmResults<RealmDiscount> queriedDiscounts = realm.where(RealmDiscount.class).sort("discountName").findAll();
        for(RealmDiscount query : queriedDiscounts){
            listOfDiscounts.put(query.getDiscountName(), query.getDiscountPercentage());
        }

        return listOfDiscounts;
    }

    //--DG07--//
    public static List<Table> getListOfFreeTable(Realm realm){
        List<Table> listOfTables = new ArrayList<>();
        RealmResults<RealmTable> queriedTables = realm.where(RealmTable.class).equalTo("tableStatus", "Free").sort("tableName").sort("tableNo").findAll();
        for(RealmTable query : queriedTables){
            listOfTables.add(new Table(query.getTableName(), query.getTableNo()));
        }
        return listOfTables;
    }

    //--DG10--//
    public static List<Ticket> getListOfTickets(Realm realm){
        List<Ticket> listOfTickets = new ArrayList<>();
        RealmResults<RealmTicket> queriedTickets = realm.where(RealmTicket.class).findAll();
        for(RealmTicket query : queriedTickets){
            Ticket ticket = new Ticket(
                    query.getTicketID(),
                    "Original",
                    query.getOrder(),
                    query.getCashier(),
                    query.getDetails(),
                    query.getOrderType(),
                    query.getDateAndTime(),
                    query.getYear(),
                    query.getMonth(),
                    query.getDay(),
                    query.getHour(),
                    query.getMinute());
            //CARTOBJECT
            List<String> itemWebName = new ArrayList<>(query.getItemWebName());
            List<String> itemPOSName = new ArrayList<>(query.getItemPOSName());
            List<Double> itemPrice = new ArrayList<>(query.getItemPrice());
            List<Integer> itemQty = new ArrayList<>(query.getItemQty());
            //DISCOUNT
            List<String> discountItem = new ArrayList<>(query.getDiscountItem());
            List<String> discountName = new ArrayList<>(query.getDiscountName());
            List<Integer> discountPercentage = new ArrayList<>(query.getDiscountPercent());
            for(int i = 0 ; i < itemPOSName.size() ; i++){
                String webName = itemWebName.get(i);
                String posName = itemPOSName.get(i);
                double price = itemPrice.get(i);
                int quantity = itemQty.get(i);
                Map<String, Integer> discounts = new TreeMap<>();
                for(int j = 0 ; j < discountItem.size() ; j++){
                    String dItem = discountItem.get(j);
                    String dName = discountName.get(j);
                    int dPercentage = discountPercentage.get(j);
                    if(dItem.equals(posName)){
                        discounts.put(dName, dPercentage);
                    }
                }
                ticket.getItems().put(new CartItem(webName, posName, price, discounts), quantity);
            }
            listOfTickets.add(ticket);
        }
        return listOfTickets;
    }

    //--DG13--//
    public static List<PaymentMethod> getPaymentMethods(Realm realm){
        List<PaymentMethod> listOfMethods = new ArrayList<>();
        RealmResults<RealmPaymentMethod> queriedMethods = realm.where(RealmPaymentMethod.class).sort("methodName").findAll();
        for(RealmPaymentMethod query : queriedMethods){
            listOfMethods.add(new PaymentMethod(query.getMethodName()));
        }
        return listOfMethods;
    }

    //--DG15--//
    public static SalesTransaction getLatestTranscation(Realm realm){
        RealmSalesTransaction query = realm.where(RealmSalesTransaction.class).sort("transactionID", Sort.DESCENDING).findFirst();
        SalesTransaction sales = new SalesTransaction(
                query.getTransactionID(),
                query.getTransactionNo(),
                query.getDateAndTime(),
                query.getCashier(),
                query.getOrder(),
                query.getOrderType(),
                query.getTotalItems(),
                query.getTotalSubTotal(),
                query.getTotalTax(),
                query.getTotalServiceFee(),
                query.getTotalDiscount(),
                query.getTotalAmountDue(),
                query.getPaymentMethod(),
                query.getTotalPayment(),
                query.getTotalChange()
        );

        //CARTOBJECT
        List<String> itemWebName = new ArrayList<>(query.getItemWebName());
        List<String> itemPOSName = new ArrayList<>(query.getItemPOSName());
        List<Double> itemPrice = new ArrayList<>(query.getItemPrice());
        List<Integer> itemQty = new ArrayList<>(query.getItemQty());
        //DISCOUNT
        List<String> discountItem = new ArrayList<>(query.getDiscountItem());
        List<String> discountName = new ArrayList<>(query.getDiscountName());
        List<Integer> discountPercentage = new ArrayList<>(query.getDiscountPercent());
        for(int i = 0 ; i < itemPOSName.size() ; i++){
            String webName = itemWebName.get(i);
            String posName = itemPOSName.get(i);
            double price = itemPrice.get(i);
            int quantity = itemQty.get(i);
            Map<String, Integer> discounts = new TreeMap<>();
            for(int j = 0 ; j < discountItem.size() ; j++){
                String dItem = discountItem.get(j);
                String dName = discountName.get(j);
                int dPercentage = discountPercentage.get(j);
                if(dItem.equals(posName)){
                    discounts.put(dName, dPercentage);
                }
            }
            sales.getItems().put(new CartItem(webName, posName, price, discounts), quantity);
        }
        return sales;
    }
}
