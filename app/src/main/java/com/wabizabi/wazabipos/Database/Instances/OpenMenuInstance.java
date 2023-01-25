package com.wabizabi.wazabipos.Database.Instances;


import android.content.Context;

import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuCategory;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuItem;
import com.wabizabi.wazabipos.Utilities.Libraries.ToastMessage;

import org.bson.types.ObjectId;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.realm.Realm;
import io.realm.RealmResults;

public class OpenMenuInstance {

    public static void toCreateCategory(int image, String name){
        String logID = new SimpleDateFormat("yyMMddHH-mmss").format(new Date());
        String logTxt = new SimpleDateFormat("MMMM dd, yyyy | HH:mm a").format(new Date());
        try(Realm realm = io.realm.Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmMenuCategory category = db.createObject(RealmMenuCategory.class, new ObjectId());
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
                RealmMenuCategory category = db.where(RealmMenuCategory.class).equalTo("categoryName", oldCategoryName).findFirst();
                RealmResults<RealmMenuItem> listOfItems = db.where(RealmMenuItem.class).equalTo("itemCategory", oldCategoryName).findAll();
                category.setCategoryImage(image);
                category.setCategoryName(name);
                for(RealmMenuItem item : listOfItems){
                    item.setItemCategory(name);
                    item.setItemImage(image);
                }
                category.setLastUpdatedID(logID);
                category.setLastUpdatedText(logTxt);
            });
        }
    }

    public static void toDeleteCategory(String name){
        try(Realm realm = Realm.getDefaultInstance()){
            RealmResults<RealmMenuItem> listOfItems = realm.where(RealmMenuItem.class).equalTo("itemCategory", name).findAll();
            realm.executeTransaction(db -> {
                RealmMenuCategory category = db.where(RealmMenuCategory.class).equalTo("categoryName", name).findFirst();
                category.deleteFromRealm();
                listOfItems.deleteAllFromRealm();
            });
        }
    }

    public static void toCreateItem(int image, String categoryName, String name, double price){
        String logID = new SimpleDateFormat("yyMMddHH-mmss").format(new Date());
        String logTxt = new SimpleDateFormat("MMMM dd, yyyy | HH:mm a").format(new Date());
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmMenuItem item = db.createObject(RealmMenuItem.class, new ObjectId());
                RealmMenuCategory category = db.where(RealmMenuCategory.class).equalTo("categoryName", categoryName).findFirst();
                item.setItemImage(image);
                item.setItemCategory(categoryName);
                item.setItemName(name);
                item.setItemPrice(price);
                category.setLastUpdatedID(logID);
                category.setLastUpdatedText(logTxt);
            });
        }
    }

    public static void toUpdateItem(String oldName, int image,  String categoryName, String name, double price){
        String logID = new SimpleDateFormat("yyMMddHH-mmss").format(new Date());
        String logTxt = new SimpleDateFormat("MMMM dd, yyyy | HH:mm a").format(new Date());
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmMenuItem item = db.where(RealmMenuItem.class).equalTo("itemName", oldName).findFirst();
                RealmMenuCategory category = db.where(RealmMenuCategory.class).equalTo("categoryName", categoryName).findFirst();
                item.setItemImage(image);
                item.setItemName(name);
                item.setItemPrice(price);
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
                RealmMenuItem item = db.where(RealmMenuItem.class).equalTo("itemName", name).findFirst();
                RealmMenuCategory category = db.where(RealmMenuCategory.class).equalTo("categoryName", categoryName).findFirst();
                item.deleteFromRealm();
                category.setLastUpdatedID(logID);
                category.setLastUpdatedText(logTxt);
            });
        }
    }

}
