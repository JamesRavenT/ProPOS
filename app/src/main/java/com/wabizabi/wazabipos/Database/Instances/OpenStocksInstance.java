package com.wabizabi.wazabipos.Database.Instances;

import com.wabizabi.wazabipos.Database.Schemas.ProductsList;
import com.wabizabi.wazabipos.Database.Schemas.StockList;

import org.bson.types.ObjectId;

import io.realm.Realm;
import io.realm.RealmResults;

public class OpenStocksInstance {

    public static void toCreateCategory(int image, String name){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                StockList category = db.createObject(StockList.class, new ObjectId());
                category.setCategoryImage(image);
                category.setCategoryName(name);
            });
        }
    }

    public static void toEditCategory(int image, String name, int position){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmResults<StockList> categories = db.where(StockList.class).sort("categoryName").findAll();
                StockList category = categories.get(position);
                category.setCategoryImage(image);
                category.setCategoryName(name);
            });
        }
    }
}
