package com.wabizabi.wazabipos.Database.Instances;

import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuCategory;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuItem;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmStockCategory;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmStockItem;

import org.bson.types.ObjectId;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.realm.Realm;
import io.realm.RealmResults;

public class OpenStocksInstance {

    public static void toCreateCategory(int image, String name){
        String logID = new SimpleDateFormat("yyMMddHH-mmss").format(new Date());
        String logTxt = new SimpleDateFormat("MMMM dd, yyyy | HH:mm a").format(new Date());
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmStockCategory category = db.createObject(RealmStockCategory.class, new ObjectId());
                category.setCategoryImage(image);
                category.setCategoryName(name);
                category.setLastUpdatedID(logID);
                category.setLastUpdatedText(logTxt);
            });
        }
    }

    public static void toUpdateCategory(String oldCategoryName, int image, String name){
        String logID = new SimpleDateFormat("yyMMddHH-mmss").format(new Date());
        String logTxt = new SimpleDateFormat("MMMM dd, yyyy | HH:mm a").format(new Date());
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmStockCategory category = db.where(RealmStockCategory.class).equalTo("categoryName", oldCategoryName).findFirst();
                RealmResults<RealmStockItem> listOfItems = db.where(RealmStockItem.class).equalTo("itemCategory", oldCategoryName).findAll();
                category.setCategoryImage(image);
                category.setCategoryName(name);
                for(RealmStockItem item : listOfItems){
                    item.setItemCategory(name);
                }
                category.setLastUpdatedID(logID);
                category.setLastUpdatedText(logTxt);
            });
        }
    }

    public static void toDeleteCategory(String name){
        try(Realm realm = Realm.getDefaultInstance()){
            RealmResults<RealmStockItem> listOfItems = realm.where(RealmStockItem.class).equalTo("itemCategory", name).findAll();
            realm.executeTransaction(db -> {
                RealmStockCategory category = db.where(RealmStockCategory.class).equalTo("categoryName", name).findFirst();
                category.deleteFromRealm();
                listOfItems.deleteAllFromRealm();
            });
        }
    }

    public static void toCreateItem(int image, String categoryName, String name, int amount, String measurement){
        String logID = new SimpleDateFormat("yyMMddHH-mmss").format(new Date());
        String logTxt = new SimpleDateFormat("MMMM dd, yyyy | HH:mm a").format(new Date());
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmStockItem item = db.createObject(RealmStockItem.class, new ObjectId());
                RealmStockCategory category = db.where(RealmStockCategory.class).equalTo("categoryName", categoryName).findFirst();
                item.setItemImage(image);
                item.setItemCategory(categoryName);
                item.setItemName(name);
                item.setItemAmount(amount);
                item.setUnitOfMeasurement(measurement);
                category.setLastUpdatedID(logID);
                category.setLastUpdatedText(logTxt);
            });
        }
    }

    public static void toUpdateItem(String oldName, int image,  String categoryName, String name, String measurement){
        String logID = new SimpleDateFormat("yyMMddHH-mmss").format(new Date());
        String logTxt = new SimpleDateFormat("MMMM dd, yyyy | HH:mm a").format(new Date());
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmStockItem item = db.where(RealmStockItem.class).equalTo("itemName", oldName).findFirst();
                RealmStockCategory category = db.where(RealmStockCategory.class).equalTo("categoryName", categoryName).findFirst();
                item.setItemImage(image);
                item.setItemName(name);
                item.setUnitOfMeasurement(measurement);
                category.setLastUpdatedID(logID);
                category.setLastUpdatedText(logTxt);
            });
        }
    }

    public static void toUpdateAmount(String categoryName, String name, int quantity){
        String logID = new SimpleDateFormat("yyMMddHH-mmss").format(new Date());
        String logTxt = new SimpleDateFormat("MMMM dd, yyyy | HH:mm a").format(new Date());
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmStockItem item = db.where(RealmStockItem.class).equalTo("itemName", name).findFirst();
                RealmStockCategory category = db.where(RealmStockCategory.class).equalTo("categoryName", categoryName).findFirst();
                item.setItemAmount(quantity);
                category.setLastUpdatedID(logID);
                category.setLastUpdatedText(logTxt);
            });
        }
    }

    public static void toDeleteItem(String categoryName, String name){
        String logID = new SimpleDateFormat("yyMMddHH-mmss").format(new Date());
        String logTxt = new SimpleDateFormat("MMMM dd, yyyy | HH:mm a").format(new Date());
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmStockItem item = db.where(RealmStockItem.class).equalTo("itemName", name).findFirst();
                RealmStockCategory category = db.where(RealmStockCategory.class).equalTo("categoryName", categoryName).findFirst();
                item.deleteFromRealm();
                category.setLastUpdatedID(logID);
                category.setLastUpdatedText(logTxt);
            });
        }
    }
}
