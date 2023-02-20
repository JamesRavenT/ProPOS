package com.wabizabi.wazabipos.Database.Instances;


import com.wabizabi.wazabipos.Database.DB;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuCategory;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuItem;

import org.bson.types.ObjectId;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.realm.Realm;
import io.realm.RealmResults;

public class OpenMenuInstance {

    public static void toCreateCategory(int icon, String name){
        ObjectId id = new ObjectId();
        String logID = new SimpleDateFormat("yyMMddHH-mmss").format(new Date());
        String logTxt = new SimpleDateFormat("MMMM dd, yyyy | HH:mm a").format(new Date());
        try(Realm realm = io.realm.Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmMenuCategory category = db.createObject(RealmMenuCategory.class, id);
                category.setCategoryIcon(icon);
                category.setCategoryName(name);
                category.setLastUpdatedID(logID);
                category.setLastUpdatedText(logTxt);
                DB.uploadNewMenuCategoryToCloud(id, icon, name);
            });
        }
    }

    public static void toUpdateCategory(String oldCategoryName, int icon, String name){
        String logID = new SimpleDateFormat("yyMMddHH-mmss").format(new Date());
        String logTxt = new SimpleDateFormat("MMMM dd, yyyy | HH:mm a").format(new Date());
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmMenuCategory category = db.where(RealmMenuCategory.class).equalTo("categoryName", oldCategoryName).findFirst();
                RealmResults<RealmMenuItem> listOfItems = db.where(RealmMenuItem.class).equalTo("itemCategory", oldCategoryName).findAll();
                category.setCategoryIcon(icon);
                category.setCategoryName(name);
                for(RealmMenuItem item : listOfItems){
                    DB.updateMenuItemFromCloud(item.get_id(), icon, name, item.getItemWebName(), item.getItemPOSName(), item.getItemPrice());
                    item.setItemCategory(name);
                    item.setItemIcon(icon);
                }
                category.setLastUpdatedID(logID);
                category.setLastUpdatedText(logTxt);
                DB.updateMenuCategoryFromCloud(category.get_id(), icon, name);
            });
        }
    }

    public static void toDeleteCategory(String name){
        try(Realm realm = Realm.getDefaultInstance()){
            RealmResults<RealmMenuItem> listOfItems = realm.where(RealmMenuItem.class).equalTo("itemCategory", name).findAll();
            realm.executeTransaction(db -> {
                RealmMenuCategory category = db.where(RealmMenuCategory.class).equalTo("categoryName", name).findFirst();
                DB.deleteMenuCategoryFromCloud(category);
                category.deleteFromRealm();
                for(RealmMenuItem item : listOfItems){
                    DB.deleteMenuItemFromCloud(item);
                    item.deleteFromRealm();
                }
            });
        }
    }

    public static void toCreateItem(int icon, String categoryName, String webName, String posName, double price){
        ObjectId id = new ObjectId();
        String logID = new SimpleDateFormat("yyMMddHH-mmss").format(new Date());
        String logTxt = new SimpleDateFormat("MMMM dd, yyyy | HH:mm a").format(new Date());
        //SAVE TO LOCAL DB//
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmMenuItem item = db.createObject(RealmMenuItem.class, id);
                RealmMenuCategory category = db.where(RealmMenuCategory.class).equalTo("categoryName", categoryName).findFirst();
                item.setItemIcon(icon);
                item.setItemCategory(categoryName);
                item.setItemWebName(webName);
                item.setItemPOSName(posName);
                item.setItemPrice(price);
                category.setLastUpdatedID(logID);
                category.setLastUpdatedText(logTxt);
                DB.uploadNewMenuItemToCloud(id, icon, categoryName, webName, posName, price);
            });
        }
    }

    public static void toUpdateItem(String oldName, int icon,  String categoryName, String webName, String posName, double price){
        String logID = new SimpleDateFormat("yyMMddHH-mmss").format(new Date());
        String logTxt = new SimpleDateFormat("MMMM dd, yyyy | HH:mm a").format(new Date());
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmMenuItem item = db.where(RealmMenuItem.class).equalTo("itemPOSName", oldName).findFirst();
                RealmMenuCategory category = db.where(RealmMenuCategory.class).equalTo("categoryName", categoryName).findFirst();
                item.setItemIcon(icon);
                item.setItemWebName(webName);
                item.setItemPOSName(posName);
                item.setItemPrice(price);
                category.setLastUpdatedID(logID);
                category.setLastUpdatedText(logTxt);
                DB.updateMenuItemFromCloud(item.get_id(), icon, categoryName, webName, posName, price);
            });
        }
    }

    public static void toDeleteItem(String categoryName, String name){
        String logID = new SimpleDateFormat("yyMMddHH-mmss").format(new Date());
        String logTxt = new SimpleDateFormat("MMMM dd, yyyy | HH:mm a").format(new Date());
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmMenuItem item = db.where(RealmMenuItem.class).equalTo("itemPOSName", name).findFirst();
                RealmMenuCategory category = db.where(RealmMenuCategory.class).equalTo("categoryName", categoryName).findFirst();
                DB.deleteMenuItemFromCloud(item);
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
                RealmMenuCategory category = db.createObject(RealmMenuCategory.class, id);
                category.setCategoryIcon(icon);
                category.setCategoryName(name);
                category.setLastUpdatedID(logID);
                category.setLastUpdatedText(logTxt);
            });
        }
    }

    public static void toUpdateCategoryFromCloud(ObjectId id, int icon, String name){
        String logID = new SimpleDateFormat("yyMMddHH-mmss").format(new Date());
        String logTxt = new SimpleDateFormat("MMMM dd, yyyy | HH:mm a").format(new Date());
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmMenuCategory category = db.where(RealmMenuCategory.class).equalTo("_id", id).findFirst();
                RealmResults<RealmMenuItem> listOfItems = db.where(RealmMenuItem.class).equalTo("itemCategory", category.getCategoryName()).findAll();
                category.setCategoryIcon(icon);
                category.setCategoryName(name);
                for(RealmMenuItem item : listOfItems){
                    DB.updateMenuItemFromCloud(item.get_id(), icon, name, item.getItemWebName(), item.getItemPOSName(), item.getItemPrice());
                    item.setItemCategory(name);
                    item.setItemIcon(icon);
                }
                category.setLastUpdatedID(logID);
                category.setLastUpdatedText(logTxt);
                DB.updateMenuCategoryFromCloud(category.get_id(), icon, name);
            });
        }
    }

    public static void toLoadItemFromCloud(ObjectId id, int icon, String categoryName, String webName, String posName, double price){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmMenuItem item = db.createObject(RealmMenuItem.class, id);
                item.setItemIcon(icon);
                item.setItemCategory(categoryName);
                item.setItemWebName(webName);
                item.setItemPOSName(posName);
                item.setItemPrice(price);
            });
        }
    }

    public static void toUpdateItemFromCloud(ObjectId id, int icon,  String categoryName, String webName, String posName, double price){
        String logID = new SimpleDateFormat("yyMMddHH-mmss").format(new Date());
        String logTxt = new SimpleDateFormat("MMMM dd, yyyy | HH:mm a").format(new Date());
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmMenuItem item = db.where(RealmMenuItem.class).equalTo("_id", id).findFirst();
                RealmMenuCategory category = db.where(RealmMenuCategory.class).equalTo("categoryName", categoryName).findFirst();
                item.setItemIcon(icon);
                item.setItemWebName(webName);
                item.setItemPOSName(posName);
                item.setItemPrice(price);
                category.setLastUpdatedID(logID);
                category.setLastUpdatedText(logTxt);
                DB.updateMenuItemFromCloud(item.get_id(), icon, categoryName, webName, posName, price);
            });
        }
    }


}
