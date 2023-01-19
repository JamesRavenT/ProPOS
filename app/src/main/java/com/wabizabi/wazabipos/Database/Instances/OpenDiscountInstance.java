package com.wabizabi.wazabipos.Database.Instances;

import com.wabizabi.wazabipos.Database.RealmSchemas.RealmOrderDiscount;

import org.bson.types.ObjectId;
import io.realm.Realm;

public class OpenDiscountInstance {

    public static void toCreateDiscount(String name, int amount){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmOrderDiscount discount = db.createObject(RealmOrderDiscount.class, new ObjectId());
                discount.setDiscountName(name);
                discount.setDiscountPercentage(amount);
            });
        }
    }

//    public static void toEditDiscount(String name, int amount){
//        try(Realm realm = Realm.getDefaultInstance()){
//            realm.executeTransaction(db -> {
//                RealmDiscountItem discount = db.where(RealmDiscountItem.class).equalTo("discountName", currentDiscount).findFirst();
//                discount.setDiscountName(name);
//                discount.setDiscountAmount(amount);
//            });
//        }
//    }

    public static void toDeleteDiscount(String name){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmOrderDiscount discount = db.where(RealmOrderDiscount.class).equalTo("discountName", name).findFirst();
                discount.deleteFromRealm();
            });
        }
    }
}
