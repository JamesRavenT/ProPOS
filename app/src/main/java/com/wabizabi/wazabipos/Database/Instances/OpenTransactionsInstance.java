package com.wabizabi.wazabipos.Database.Instances;


import android.util.Log;

import com.wabizabi.wazabipos.Database.Schemas.Transactions;

import org.bson.types.ObjectId;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;

public class OpenTransactionsInstance {

    public static void toCreateTransaction(List<String> itemset,
                                           double totalPrice,
                                           String time,
                                           String month,
                                           String day,
                                           String year){
        try(Realm realm = Realm.getDefaultInstance()){

            realm.executeTransaction(db -> {
                Transactions transaction = db.createObject(Transactions.class, new ObjectId());
                RealmList<String> items = new RealmList<>();
                items.addAll(itemset);
                Log.v("AAAAAA", "Item" + items.size());
                transaction.setNameOfEachItem(items);
                transaction.setPriceOfAllItems(totalPrice);
                transaction.setTime(time);
                transaction.setMonth(month);
                transaction.setDay(day);
                transaction.setYear(year);
            });

        }
    }
}
