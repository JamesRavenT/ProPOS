package com.wabizabi.wazabipos.Database.Instances;

import com.wabizabi.wazabipos.Database.Schemas.ProductsList;
import com.wabizabi.wazabipos.Database.Schemas.StockItem;
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
                RealmResults<StockItem> items = db.where(StockItem.class).equalTo("itemCategory", category.getCategoryName()).findAll();
                if(!items.isEmpty()){
                    for(StockItem item : items){
                        item.setItemCategory(name);
                    }
                }
                category.setCategoryImage(image);
                category.setCategoryName(name);
            });
        }
    }

    public static void toDeleteCategory(int position){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmResults<StockList> categories = db.where(StockList.class).sort("categoryName").findAll();
                StockList category = categories.get(position);
                RealmResults<StockItem> items = db.where(StockItem.class).equalTo("itemCategory", category.getCategoryName()).findAll();
                if(!items.isEmpty()){
                    for(int i = 0 ; i < items.size() ; i++){
                        items.deleteFromRealm(i);
                    }
                }
                categories.deleteFromRealm(position);
            });
        }
    }

    public static void toCreateItem(int image, String category, String name, int amount){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                StockItem item = db.createObject(StockItem.class, new ObjectId());
                item.setItemImage(image);
                item.setItemCategory(category);
                item.setItemName(name);
                item.setItemAmount(amount);
            });
        }
    }

    public static void toEditItem(int image, String category, String name, int amount, int position){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmResults<StockItem> items = db.where(StockItem.class).equalTo("itemCategory", category).sort("itemName").findAll();
                StockItem item = items.get(position);
                item.setItemImage(image);
                item.setItemCategory(category);
                item.setItemName(name);
                item.setItemAmount(amount);
            });
        }
    }
    public static void toDeleteItem(String category, int position){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmResults<StockItem> items = db.where(StockItem.class).equalTo("itemCategory", category).sort("itemCategory").findAll();
                items.deleteFromRealm(position);
            });
        }
    }
}
