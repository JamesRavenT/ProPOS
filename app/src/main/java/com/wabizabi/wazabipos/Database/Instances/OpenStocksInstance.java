package com.wabizabi.wazabipos.Database.Instances;

import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuCategory;
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
                category.setCategoryIcon(image);
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
                category.setCategoryIcon(image);
                category.setCategoryName(name);
                for(RealmStockItem item : listOfItems){
                    item.setItemIcon(image);
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
                item.setItemIcon(image);
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
                item.setItemIcon(image);
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

    //CLOUD
    public static void toLoadCategoryFromCloud(ObjectId id, int icon, String name){
        String logID = new SimpleDateFormat("yyMMddHH-mmss").format(new Date());
        String logTxt = new SimpleDateFormat("MMMM dd, yyyy | HH:mm a").format(new Date());
        try(Realm realm = io.realm.Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmStockCategory category = db.createObject(RealmStockCategory.class, id);
                category.setCategoryIcon(icon);
                category.setCategoryName(name);
                category.setLastUpdatedID(logID);
                category.setLastUpdatedText(logTxt);
            });
        }
    }

    public static void toUpdateCategoryFromCloud(ObjectId id, int image, String name){
        String logID = new SimpleDateFormat("yyMMddHH-mmss").format(new Date());
        String logTxt = new SimpleDateFormat("MMMM dd, yyyy | HH:mm a").format(new Date());
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmStockCategory category = db.where(RealmStockCategory.class).equalTo("_id", id).findFirst();
                RealmResults<RealmStockItem> listOfItems = db.where(RealmStockItem.class).equalTo("itemCategory", category.getCategoryName()).findAll();
                category.setCategoryIcon(image);
                category.setCategoryName(name);
                for(RealmStockItem item : listOfItems){
                    item.setItemIcon(image);
                    item.setItemCategory(name);
                }
                category.setLastUpdatedID(logID);
                category.setLastUpdatedText(logTxt);
            });
        }
    }

    public static void toLoadItemFromCloud(ObjectId id, int icon, String categoryName, String name, int amount, String measurement){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmStockItem item = db.createObject(RealmStockItem.class, id);
                item.setItemIcon(icon);
                item.setItemCategory(categoryName);
                item.setItemName(name);
                item.setItemAmount(amount);
                item.setUnitOfMeasurement(measurement);
            });
        }
    }

    public static void toUpdateItemFromCloud(ObjectId id, int image,  String categoryName, String name, String measurement){
        String logID = new SimpleDateFormat("yyMMddHH-mmss").format(new Date());
        String logTxt = new SimpleDateFormat("MMMM dd, yyyy | HH:mm a").format(new Date());
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmStockItem item = db.where(RealmStockItem.class).equalTo("_id", id).findFirst();
                RealmStockCategory category = db.where(RealmStockCategory.class).equalTo("categoryName", categoryName).findFirst();
                item.setItemIcon(image);
                item.setItemName(name);
                item.setUnitOfMeasurement(measurement);
                category.setLastUpdatedID(logID);
                category.setLastUpdatedText(logTxt);
            });
        }
    }
}
