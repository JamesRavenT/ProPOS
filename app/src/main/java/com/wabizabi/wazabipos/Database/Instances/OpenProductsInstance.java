package com.wabizabi.wazabipos.Database.Instances;

import com.wabizabi.wazabipos.Database.Schemas.ProductsList;
import com.wabizabi.wazabipos.Database.Schemas.ProductItem;

import org.bson.types.ObjectId;

import io.realm.Realm;

public class OpenProductsInstance {

    public static void toCreateCategory(String category){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction((db) -> {
                ProductsList product = db.createObject(ProductsList.class, new ObjectId());
                product.setCategoryName(category);
            });
        }
    }

    public static void toCreateItem(String category, String name, double price){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction((db) -> {
                ProductItem product = db.createObject(ProductItem.class, new ObjectId());
                product.setItemCategory(category);
                product.setItemName(name);
                product.setItemPrice(price);
            });
        }
    }
}
