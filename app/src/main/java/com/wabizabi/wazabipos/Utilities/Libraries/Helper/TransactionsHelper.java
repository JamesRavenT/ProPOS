package com.wabizabi.wazabipos.Utilities.Libraries.Helper;

import com.wabizabi.wazabipos.Database.ObjectSchemas.SalesTransaction;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmSalesTransaction;
import com.wabizabi.wazabipos.Utilities.Libraries.Objects.CartItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import io.realm.Realm;
import io.realm.Sort;

public class TransactionsHelper {

    public static SalesTransaction getSelectedTransaction(Realm realm, SalesTransaction sale){
        RealmSalesTransaction query
                = realm.where(RealmSalesTransaction.class)
                .equalTo("_id", sale.getTransactionID())
                .sort("_id", Sort.DESCENDING)
                .findFirst();
        SalesTransaction sales = new SalesTransaction(
                query.get_id(),
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
