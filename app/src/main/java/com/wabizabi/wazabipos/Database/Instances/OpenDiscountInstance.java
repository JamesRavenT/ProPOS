package com.wabizabi.wazabipos.Database.Instances;

import com.wabizabi.wazabipos.Database.RealmSchemas.RealmDiscount;

import org.bson.types.ObjectId;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.realm.Realm;

public class OpenDiscountInstance {

    public static void toCreateDiscount(String name, int amount){
        String logID = new SimpleDateFormat("yyMMddHH-mmss").format(new Date());
        String logTxt = new SimpleDateFormat("MMMM dd, yyyy | HH:mm a").format(new Date());
        DateFormat currentDateAndTime = new SimpleDateFormat("MMMM dd, yyyy | HH:mm a");
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmDiscount discount = db.createObject(RealmDiscount.class, new ObjectId());
                discount.setDiscountName(name);
                discount.setDiscountPercentage(amount);
                discount.setLastUpdatedID(logID);
                discount.setLastUpdatedText(logTxt);
            });
        }
    }

    public static void toEditDiscount(String oldName, String name, int percent){
        String logID = new SimpleDateFormat("yyMMddHH-mmss").format(new Date());
        String logTxt = new SimpleDateFormat("MMMM dd, yyyy | HH:mm a").format(new Date());
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmDiscount discount = db.where(RealmDiscount.class).equalTo("discountName", oldName).findFirst();
                discount.setDiscountName(name);
                discount.setDiscountPercentage(percent);
                discount.setLastUpdatedID(logID);
                discount.setLastUpdatedText(logTxt);
            });
        }
    }

    public static void toDeleteDiscount(String name){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmDiscount discount = db.where(RealmDiscount.class).equalTo("discountName", name).findFirst();
                discount.deleteFromRealm();
            });
        }
    }
}
