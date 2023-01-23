package com.wabizabi.wazabipos.Database.Instances;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.M04F01SF03_Cart.currentCartDiscount;

import com.wabizabi.wazabipos.Database.RealmSchemas.RealmDiscount;

import org.bson.types.ObjectId;
import io.realm.Realm;

public class OpenDiscountInstance {

    public static void toCreateDiscount(String name, int amount){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmDiscount discount = db.createObject(RealmDiscount.class, new ObjectId());
                discount.setDiscountName(name);
                discount.setDiscountPercentage(amount);
            });
        }
    }

    public static void toEditDiscount(String name, int percent){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmDiscount discount = db.where(RealmDiscount.class).equalTo("discountName", currentCartDiscount).findFirst();
                discount.setDiscountName(name);
                discount.setDiscountPercentage(percent);
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
