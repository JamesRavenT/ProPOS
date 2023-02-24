package com.wabizabi.wazabipos.Database.Instances;


import com.wabizabi.wazabipos.Database.DB;
import com.wabizabi.wazabipos.Database.ObjectSchemas.InventoryTransaction;
import com.wabizabi.wazabipos.Database.ObjectSchemas.SalesTransaction;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmInventoryTransaction;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmSalesTransaction;
import com.wabizabi.wazabipos.Utilities.Libraries.Objects.CartItem;

import org.bson.types.ObjectId;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class OpenTransactionsInstance {

    public static void toCreateInventoryTransaction(String itemName,
                                                    int originalAmount,
                                                    int amountToBeAdded,
                                                    String itemUnit){
        try(Realm realm = Realm.getDefaultInstance()){
            String id = new SimpleDateFormat("yyMMddHHmmsSSS").format(new Date());
            String transactionDT = new SimpleDateFormat("MMMM dd , yyyy | hh:mm a").format(new Date());
            String year = new SimpleDateFormat("yyyy").format(new Date());
            String month = new SimpleDateFormat("MM").format(new Date());
            String day = new SimpleDateFormat("dd").format(new Date());
            String operation = (originalAmount > amountToBeAdded)
                             ? "Stock Out"
                             : "Stock In";
            int amount = (originalAmount > amountToBeAdded)
                       ? originalAmount - amountToBeAdded //Stocked Out
                       : amountToBeAdded - originalAmount; //Stocked In
            int newAmount = (originalAmount > amountToBeAdded)
                          ? originalAmount - amount //Stocked Out
                          : originalAmount + amount; //Stocked In
            realm.executeTransaction(db -> {
                RealmInventoryTransaction transaction = db.createObject(RealmInventoryTransaction.class, id);
                transaction.setTransactionDT(transactionDT);
                transaction.setItemName(itemName);
                transaction.setTransactionType(operation);
                transaction.setAmount(amount);
                transaction.setItemUnit(itemUnit);
                transaction.setNewAmount(newAmount);
                transaction.setYear(year);
                transaction.setMonth(month);
                transaction.setDay(day);
            });
            DB.uploadNewInventoryTransactionToCloud(id, transactionDT, operation, itemName, amount, itemUnit, newAmount, day, month, year);
            OpenUserInstance.toUpdateLocalInventoryTransactionCountAdd();
        }
    }

    public static void toVoidInventoryTransaction(InventoryTransaction inventory){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmInventoryTransaction transaction = db.where(RealmInventoryTransaction.class).equalTo("_id", inventory.getTransactionID()).findFirst();

                DB.voidInventoryTransactionFromCloud(inventory);
                transaction.deleteFromRealm();
            });
            OpenUserInstance.toUpdateLocalInventoryTransactionCountSub();
        }
    }

    public static void toCreateSales(String order,
                                     String cashier,
                                     String orderType,
                                     List<String> itemsetWebName,
                                     List<String> itemsetPOSName,
                                     List<Double> itemsetPrice,
                                     List<Integer> itemsetQty,
                                     List<String> discountsItem,
                                     List<String> discountsName,
                                     List<Integer> discountsPercent,
                                     int totalItems,
                                     double totalSubTotal,
                                     double totalTax,
                                     double totalServiceFee,
                                     double totalDiscount,
                                     double totalAmountDue,
                                     String paymentMethod,
                                     double totalAmountReceived,
                                     double change
                                     ){
        try(Realm realm = Realm.getDefaultInstance()){
            String transNo = new SimpleDateFormat("yyDDD").format(new Date());
            String year = new SimpleDateFormat("yyyy").format(new Date());
            String month = new SimpleDateFormat("MM").format(new Date());
            String week = new SimpleDateFormat("W").format(new Date());
            String dayTxt = new SimpleDateFormat("EEEE").format(new Date());
            String dayNo = new SimpleDateFormat("dd").format(new Date());
            String hour = new SimpleDateFormat("kk").format(new Date());
            RealmResults<RealmSalesTransaction> query = realm.where(RealmSalesTransaction.class)
                    .equalTo("year", year)
                    .and()
                    .equalTo("month", month)
                    .and()
                    .equalTo("dayNo", dayNo)
                    .findAll();
            String id = new SimpleDateFormat("yyMMddHHmmsSSS").format(new Date());
            String dateAndTime = new SimpleDateFormat("MMMM dd , yyyy | hh:mm a").format(new Date());
            String transactionNo = (String.valueOf(query.size()).length() == 3)
                                 ? transNo + "-" + query.size()
                                 : (String.valueOf(query.size()).length() == 2)
                                 ? transNo + "-0" + query.size()
                                 : (String.valueOf(query.size()).length() == 1 && query.size() != 1)
                                 ? transNo + "-00" + query.size()
                                 : transNo + "-001";
            realm.executeTransaction(db -> {
                RealmSalesTransaction transaction = db.createObject(RealmSalesTransaction.class, id);
                //CART ITEMS
                RealmList<String> itemsWebName = new RealmList<>(); itemsWebName.addAll(itemsetWebName);
                RealmList<String> itemsIDName = new RealmList<>(); itemsIDName.addAll(itemsetPOSName);
                RealmList<Double> itemsIDPrice = new RealmList<>(); itemsIDPrice.addAll(itemsetPrice);
                RealmList<Integer> itemsIDAmount = new RealmList<>(); itemsIDAmount.addAll(itemsetQty);
                //DISCOUNTS
                RealmList<String> discountsIDItem = new RealmList<>(); discountsIDItem.addAll(discountsItem);
                RealmList<String> discountsIDName = new RealmList<>(); discountsIDName.addAll(discountsName);
                RealmList<Integer> discountsIDPercent = new RealmList<>(); discountsIDPercent.addAll(discountsPercent);
                transaction.setTransactionNo(transactionNo);
                transaction.setTransactionType("Sales");
                transaction.setDateAndTime(dateAndTime);
                transaction.setCashier(cashier);
                transaction.setOrder(order);
                transaction.setOrderType(orderType);
                transaction.setItemWebName(itemsWebName);
                transaction.setItemPOSName(itemsIDName);
                transaction.setItemPrice(itemsIDPrice);
                transaction.setItemQty(itemsIDAmount);
                transaction.setDiscountItem(discountsIDItem);
                transaction.setDiscountName(discountsIDName);
                transaction.setDiscountPercent(discountsIDPercent);
                transaction.setTotalItems(totalItems);
                transaction.setTotalSubTotal(totalSubTotal);
                transaction.setTotalTax(totalTax);
                transaction.setTotalServiceFee(totalServiceFee);
                transaction.setTotalDiscount(totalDiscount);
                transaction.setTotalAmountDue(totalAmountDue);
                transaction.setPaymentMethod(paymentMethod);
                transaction.setTotalPayment(totalAmountReceived);
                transaction.setTotalChange(change);

                transaction.setYear(year);
                transaction.setMonth(month);
                transaction.setWeek(week);
                transaction.setDayTxt(dayTxt);
                transaction.setDayNo(dayNo);
                transaction.setHour(hour);
            });
            OpenUserInstance.toUpdateLocalSalesTransactionCount();
        }
    }

    public static void toCreateRefund(SalesTransaction sales){
        try(Realm realm = Realm.getDefaultInstance()){
            String id = new SimpleDateFormat("yyMMddHHmmsSSS").format(new Date());
            String year = new SimpleDateFormat("yyyy").format(new Date());
            String month = new SimpleDateFormat("MM").format(new Date());
            String week = new SimpleDateFormat("W").format(new Date());
            String dayTxt = new SimpleDateFormat("E").format(new Date());
            String dayNo = new SimpleDateFormat("dd").format(new Date());
            String hour = new SimpleDateFormat("HH").format(new Date());
            String dateAndTime = new SimpleDateFormat("MMMM dd , yyyy | hh:mm a").format(new Date());
            //ITEMS
            List<String> itemWebName = new ArrayList<>();
            List<String> itemPOSName = new ArrayList<>();
            List<Double> itemPrice = new ArrayList<>();
            List<Integer> itemQty = new ArrayList<>();
            List<String> discountItem = new ArrayList<>();
            List<String> discountName = new ArrayList<>();
            List<Integer> discountPercentage = new ArrayList<>();
            for(Map.Entry<CartItem, Integer> cartItem : sales.getItems().entrySet()){
                String webName = cartItem.getKey().getItemWebName();
                String name = cartItem.getKey().getItemPOSName();
                double price = cartItem.getKey().getItemPrice();
                int frequency = cartItem.getValue();
                Map<String, Integer> discounts = cartItem.getKey().getItemDiscounts();
                itemWebName.add(webName);
                itemPOSName.add(name);
                itemPrice.add(price);
                itemQty.add(frequency);
                for(Map.Entry<String, Integer> discount : discounts.entrySet()){
                    discountItem.add(name);
                    discountName.add(discount.getKey());
                    discountPercentage.add(discount.getValue());
                }
            }
            //CREATE
            realm.executeTransaction(db -> {
                RealmSalesTransaction transaction = db.createObject(RealmSalesTransaction.class, id);
                //CART ITEMS
                RealmList<String> itemsWebName = new RealmList<>(); itemsWebName.addAll(itemWebName);
                RealmList<String> itemsIDName = new RealmList<>(); itemsIDName.addAll(itemPOSName);
                RealmList<Double> itemsIDPrice = new RealmList<>(); itemsIDPrice.addAll(itemPrice);
                RealmList<Integer> itemsIDAmount = new RealmList<>(); itemsIDAmount.addAll(itemQty);
                //DISCOUNTS
                RealmList<String> discountsIDItem = new RealmList<>(); discountsIDItem.addAll(discountItem);
                RealmList<String> discountsIDName = new RealmList<>(); discountsIDName.addAll(discountName);
                RealmList<Integer> discountsIDPercent = new RealmList<>(); discountsIDPercent.addAll(discountPercentage);
                transaction.setTransactionNo(sales.getTransactionNo());
                transaction.setTransactionType("Refund");
                transaction.setDateAndTime(dateAndTime);
                transaction.setCashier(sales.getCashier());
                transaction.setOrder(sales.getOrder());
                transaction.setOrderType(sales.getOrderType());
                transaction.setItemWebName(itemsWebName);
                transaction.setItemPOSName(itemsIDName);
                transaction.setItemPrice(itemsIDPrice);
                transaction.setItemQty(itemsIDAmount);
                transaction.setDiscountItem(discountsIDItem);
                transaction.setDiscountName(discountsIDName);
                transaction.setDiscountPercent(discountsIDPercent);
                transaction.setTotalItems(sales.getTotalItems());
                transaction.setTotalSubTotal(sales.getTotalSubTotal());
                transaction.setTotalTax(sales.getTotalTax());
                transaction.setTotalServiceFee(sales.getTotalServiceFee());
                transaction.setTotalDiscount(sales.getTotalDiscount());
                transaction.setTotalAmountDue(sales.getTotalAmountDue());
                transaction.setPaymentMethod(sales.getPaymentMethod());
                transaction.setTotalPayment(sales.getTotalPayment());
                transaction.setTotalChange(sales.getChange());

                transaction.setYear(year);
                transaction.setMonth(month);
                transaction.setWeek(week);
                transaction.setDayTxt(dayTxt);
                transaction.setDayNo(dayNo);
                transaction.setHour(hour);
                DB.uploadNewSalesToCloud(
                        id,sales.getTransactionNo(), "Refund", dateAndTime, sales.getCashier(), sales.getOrder(), sales.getOrderType(),
                        itemWebName, itemPOSName, itemPrice, itemQty, discountItem, discountName, discountPercentage, sales.getTotalItems(),
                        sales.getTotalSubTotal(), sales.getTotalTax(), sales.getTotalServiceFee(), sales.getTotalDiscount(), sales.getTotalAmountDue(),
                        sales.getTotalPayment(), sales.getChange(), sales.getPaymentMethod(),year, month, week, dayTxt, dayNo, hour
                );
            });
            OpenUserInstance.toUpdateLocalSalesTransactionCount();

        }
    }

    public static void toCreateTestSales(List<String> itemsetWebName,
                                         List<String> itemsetPOSName,
                                         List<Double> itemsetPrice,
                                         List<Integer> itemsetQty,
                                         double totalPrice){
        try(Realm realm = Realm.getDefaultInstance()){
            String id = new SimpleDateFormat("yyMMddHHmmsSSS").format(new Date());
            String dateAndTime = new SimpleDateFormat("MMMM dd , yyyy | hh:mm a").format(new Date());
            String year = new SimpleDateFormat("yyyy").format(new Date());
            String month = new SimpleDateFormat("MM").format(new Date());
            String week = new SimpleDateFormat("W").format(new Date());
            String dayTxt = new SimpleDateFormat("EEEE").format(new Date());
            String dayNo = new SimpleDateFormat("dd").format(new Date());
            String hour = new SimpleDateFormat("kk").format(new Date());
            realm.executeTransaction(db -> {
                //TRANSACTION
                RealmSalesTransaction transaction = db.createObject(RealmSalesTransaction.class, id);
                //CART ITEMS
                RealmList<String> itemsWebName = new RealmList<>(); itemsWebName.addAll(itemsetWebName);
                RealmList<String> itemsIDName = new RealmList<>(); itemsIDName.addAll(itemsetPOSName);
                RealmList<Double> itemsIDPrice = new RealmList<>(); itemsIDPrice.addAll(itemsetPrice);
                RealmList<Integer> itemsIDAmount = new RealmList<>(); itemsIDAmount.addAll(itemsetQty);
                //DISCOUNTS
                RealmList<String> discountsIDItem = new RealmList<>();
                RealmList<String> discountsIDName = new RealmList<>();
                RealmList<Integer> discountsIDPercent = new RealmList<>();

                transaction.setTransactionNo("00000-000");
                transaction.setTransactionType("Sales");
                transaction.setDateAndTime(dateAndTime);
                transaction.setCashier("Test Cashier");
                transaction.setOrder("Table 00 [Default]");
                transaction.setOrderType("Take Out");
                transaction.setItemWebName(itemsWebName);
                transaction.setItemPOSName(itemsIDName);
                transaction.setItemPrice(itemsIDPrice);
                transaction.setItemQty(itemsIDAmount);
                transaction.setDiscountItem(discountsIDItem);
                transaction.setDiscountName(discountsIDName);
                transaction.setDiscountPercent(discountsIDPercent);
                transaction.setTotalItems(itemsetQty.stream().mapToInt(i->i).sum());
                transaction.setTotalSubTotal(totalPrice);
                transaction.setTotalTax(totalPrice * 0.03);
                transaction.setTotalServiceFee(0.00);
                transaction.setTotalDiscount(0.00);
                transaction.setTotalAmountDue(totalPrice + (totalPrice * 0.03));
                transaction.setPaymentMethod("Cash");
                transaction.setTotalPayment(totalPrice + (totalPrice * 0.03));
                transaction.setTotalChange(0.00);

                transaction.setYear(year);
                transaction.setMonth(month);
                transaction.setWeek(week);
                transaction.setDayTxt(dayTxt);
                transaction.setDayNo(dayNo);
                transaction.setHour(hour);

                List<String> discountsItem = new ArrayList<>();
                List<String> discountsName = new ArrayList<>();
                List<Integer> discountsPercent = new ArrayList<>();
                DB.uploadNewSalesToCloud(
                        id,"00000-000", "Sales", dateAndTime, "Test Cashier", "Table 00 [Default]", "Take Out",
                        itemsetWebName, itemsetPOSName, itemsetPrice, itemsetQty, discountsItem, discountsName, discountsPercent, itemsetQty.stream().mapToInt(i->i).sum(),
                        totalPrice, totalPrice*0.03, 0.00, 0.00, totalPrice + (totalPrice * 0.03), totalPrice + (totalPrice * 0.03),
                        0.00, "Cash", year, month, week, dayTxt, dayNo, hour
                        );
                OpenUserInstance.toUpdateLocalSalesTransactionCount();
            });
        }
    }

    public static void toLoadInventoryTransactionFromCloud(String id,
                                                           String transactionDT,
                                                           String transactionType,
                                                           String itemName,
                                                           int amount,
                                                           String itemUnit,
                                                           int newAmount,
                                                           List<String> dtVar){
        try(Realm realm = Realm.getDefaultInstance()){
            String year = dtVar.get(0);
            String month = dtVar.get(1);
            String day = dtVar.get(2);
            realm.executeTransaction(db -> {
                RealmInventoryTransaction transaction = db.createObject(RealmInventoryTransaction.class, id);
                transaction.setTransactionDT(transactionDT);
                transaction.setItemName(itemName);
                transaction.setTransactionType(transactionType);
                transaction.setAmount(amount);
                transaction.setItemUnit(itemUnit);
                transaction.setNewAmount(newAmount);
                transaction.setYear(year);
                transaction.setMonth(month);
                transaction.setDay(day);
            });
        }
    }

    public static void toLoadSalesFromCloud(
                                     String id,
                                     String transNo,
                                     String transType,
                                     String transDT,
                                     String order,
                                     String cashier,
                                     String orderType,
                                     List<String> itemsetWebName,
                                     List<String> itemsetPOSName,
                                     List<Double> itemsetPrice,
                                     List<Long> itemsetQtyLong,
                                     List<String> discountsItem,
                                     List<String> discountsName,
                                     List<Long> discountsPercentLong,
                                     int totalItems,
                                     double totalSubTotal,
                                     double totalTax,
                                     double totalServiceFee,
                                     double totalDiscount,
                                     double totalAmountDue,
                                     String paymentMethod,
                                     double totalAmountReceived,
                                     double change,
                                     List<String> dtVar
    ){
        try(Realm realm = Realm.getDefaultInstance()){
            List<Integer> itemsetQty = itemsetQtyLong.stream()
                    .map(Long::intValue)
                    .collect(Collectors.toList());
            List<Integer> discountsPercent = discountsPercentLong.stream()
                    .map(Long::intValue)
                    .collect(Collectors.toList());
            String year = dtVar.get(0);
            String month = dtVar.get(1);
            String week = dtVar.get(2);
            String dayTxt = dtVar.get(3);
            String dayNo = dtVar.get(4);
            String hour = dtVar.get(5);
            realm.executeTransaction(db -> {
                RealmSalesTransaction transaction = db.createObject(RealmSalesTransaction.class, id);
                //CART ITEMS
                RealmList<String> itemsWebName = new RealmList<>(); itemsWebName.addAll(itemsetWebName);
                RealmList<String> itemsIDName = new RealmList<>(); itemsIDName.addAll(itemsetPOSName);
                RealmList<Double> itemsIDPrice = new RealmList<>(); itemsIDPrice.addAll(itemsetPrice);
                RealmList<Integer> itemsIDAmount = new RealmList<>(); itemsIDAmount.addAll(itemsetQty);
                //DISCOUNTS
                RealmList<String> discountsIDItem = new RealmList<>(); discountsIDItem.addAll(discountsItem);
                RealmList<String> discountsIDName = new RealmList<>(); discountsIDName.addAll(discountsName);
                RealmList<Integer> discountsIDPercent = new RealmList<>(); discountsIDPercent.addAll(discountsPercent);
                transaction.setTransactionNo(transNo);
                transaction.setTransactionType(transType);
                transaction.setDateAndTime(transDT);
                transaction.setCashier(cashier);
                transaction.setOrder(order);
                transaction.setOrderType(orderType);
                transaction.setItemWebName(itemsWebName);
                transaction.setItemPOSName(itemsIDName);
                transaction.setItemPrice(itemsIDPrice);
                transaction.setItemQty(itemsIDAmount);
                transaction.setDiscountItem(discountsIDItem);
                transaction.setDiscountName(discountsIDName);
                transaction.setDiscountPercent(discountsIDPercent);
                transaction.setTotalItems(totalItems);
                transaction.setTotalSubTotal(totalSubTotal);
                transaction.setTotalTax(totalTax);
                transaction.setTotalServiceFee(totalServiceFee);
                transaction.setTotalDiscount(totalDiscount);
                transaction.setTotalAmountDue(totalAmountDue);
                transaction.setPaymentMethod(paymentMethod);
                transaction.setTotalPayment(totalAmountReceived);
                transaction.setTotalChange(change);
                transaction.setYear(year);
                transaction.setMonth(month);
                transaction.setWeek(week);
                transaction.setDayTxt(dayTxt);
                transaction.setDayNo(dayNo);
                transaction.setHour(hour);
            });

        }
    }


//    public static void toUpdateInventory(String operation,
//                                         String itemName,
//                                         int amount,
//                                         String itemUnit){
//        try(Realm realm = Realm.getDefaultInstance()){
//            realm.executeTransaction(db -> {
//                //DATE AND TIME
//                DateFormat currentDT = new SimpleDateFormat("yyyyMMdhmmsS");
//                DateFormat currentTime = new SimpleDateFormat("h:mm a");
//                DateFormat currentMonth = new SimpleDateFormat("MMMM");
//                DateFormat currentDay = new SimpleDateFormat("d");
//                DateFormat currentYear = new SimpleDateFormat("yyyy");
//                String dt = currentDT.format(new Date());
//                String time = currentTime.format(new Date());
//                String month = currentMonth.format(new Date());
//                String day = currentDay.format(new Date());
//                String year = currentYear.format(new Date());
//
//                //TRANSACTION
//                RealmInventoryTransaction transaction = db.createObject(RealmInventoryTransaction.class, new ObjectId());
//                transaction.setItemName(itemName);
//                transaction.setOperation(operation);
//                transaction.setAmount(amount);
//                transaction.setItemUnit(itemUnit);
//                transaction.setTimestamp(dt);
//                transaction.setTime(time);
//                transaction.setDay(day);
//                transaction.setMonth(month);
//                transaction.setYear(year);
//            });
//        }
//    }
}
