package com.wabizabi.wazabipos.Database.Instances;


import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuCategory;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuItem;

import org.bson.types.ObjectId;

import io.realm.RealmResults;

public class OpenMenuInstance {

    public static void toCreateCategory(int image, String categoryName){
        try(io.realm.Realm realm = io.realm.Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmMenuCategory category = db.createObject(RealmMenuCategory.class, new ObjectId());
                category.setCategoryImage(image);
                category.setCategoryName(categoryName);
            });
        }
    }

//    public static void toEditCategory(int image, String categoryName){
//        try(io.realm.Realm realm = io.realm.Realm.getDefaultInstance()){
//            realm.executeTransaction(db -> {
//                RealmMenuCategory category = db.where(RealmMenuCategory.class).equalTo("categoryName", M04F03_CurrentCategory).findFirst();
//                RealmResults<RealmMenuItem> items = db.where(RealmMenuItem.class).equalTo("itemCategory", M04F03_CurrentCategory).findAll();
//                if(!items.isEmpty()){
//                    for(RealmMenuItem item : items){
//                        item.setItemImage(image);
//                        item.setItemCategory(categoryName);
//                    }
//                }
//                category.setCategoryImage(image);
//                category.setCategoryName(categoryName);
//            });
//        }
//    }
//
//    public static void toDeleteCategory(){
//        try(io.realm.Realm realm = io.realm.Realm.getDefaultInstance()){
//            realm.executeTransaction(db -> {
//                RealmMenuCategory category = db.where(RealmMenuCategory.class).equalTo("categoryName", M04F03_CurrentCategory).findFirst();
//                RealmResults<RealmMenuItem> items = db.where(RealmMenuItem.class).equalTo("itemCategory", M04F03_CurrentCategory).findAll();
//                items.deleteAllFromRealm();
//                category.deleteFromRealm();
//            });
//        }
//    }

    public static void toCreateItem(int image, String category, String name, double price){
        try(io.realm.Realm realm = io.realm.Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmMenuItem product = db.createObject(RealmMenuItem.class, new ObjectId());
                product.setItemImage(image);
                product.setItemCategory(category);
                product.setItemName(name);
                product.setItemPrice(price);
            });
        }
    }

//    public static void toEditItem(String name, double price){
//        try(io.realm.Realm realm = io.realm.Realm.getDefaultInstance()){
//            realm.executeTransaction(db -> {
//                RealmMenuItem item = db.where(RealmMenuItem.class).equalTo("itemName", M04F03_CurrentItem).findFirst();
//                item.setItemName(name);
//                item.setItemPrice(price);
//            });
//        }
//    }
//
//    public static void toDeleteItem(){
//        try(io.realm.Realm realm = io.realm.Realm.getDefaultInstance()){
//            realm.executeTransaction(db -> {
//                RealmMenuItem item = db.where(RealmMenuItem.class).equalTo("itemName", M04F03_CurrentItem).findFirst();
//                item.deleteFromRealm();
//            });
//        }
//    }
}
