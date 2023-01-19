package com.wabizabi.wazabipos.Database.Instances;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.M04F02_Stocks.M04F02_CurrentCategory;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.M04F02_Stocks.M04F02_CurrentItem;

import com.wabizabi.wazabipos.Database.RealmSchemas.StockItem;
import com.wabizabi.wazabipos.Database.RealmSchemas.StockList;

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
    public static void toEditCategory(int image, String name){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                StockList category = db.where(StockList.class).equalTo("categoryName", M04F02_CurrentCategory).findFirst();
                RealmResults<StockItem> items = db.where(StockItem.class).equalTo("itemCategory", category.getCategoryName()).findAll();
                if(!items.isEmpty()){
                    for(StockItem item : items){
                        item.setItemImage(image);
                        item.setItemCategory(name);
                    }
                }
                category.setCategoryImage(image);
                category.setCategoryName(name);
            });
        }
    }
    public static void toDeleteCategory(){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                StockList category = db.where(StockList.class).equalTo("categoryName", M04F02_CurrentCategory).findFirst();
                RealmResults<StockItem> items = db.where(StockItem.class).equalTo("itemCategory", M04F02_CurrentCategory).findAll();
                items.deleteAllFromRealm();
                category.deleteFromRealm();
            });
        }
    }

    public static void toCreateItem(int image, String category, String name, int amount, String unit){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                StockItem item = db.createObject(StockItem.class, new ObjectId());
                item.setItemImage(image);
                item.setItemCategory(category);
                item.setItemName(name);
                item.setItemAmount(amount);
                item.setItemUnit(unit);
            });
        }
    }
    public static void toEditItem(String name){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                StockItem item = db.where(StockItem.class).equalTo("itemName", M04F02_CurrentItem).findFirst();
                item.setItemName(name);

            });
        }
    }
    public static void toStockIn(int amount){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                StockItem item = db.where(StockItem.class).equalTo("itemName", M04F02_CurrentItem).findFirst();
                int oldAmount = item.getItemAmount();
                int newAmount = oldAmount + amount;
                item.setItemAmount(newAmount);
            });
        }
    }
    public static void toStockOut(int amount){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                StockItem item = db.where(StockItem.class).equalTo("itemName", M04F02_CurrentItem).findFirst();
                int oldAmount = item.getItemAmount();
                int newAmount = oldAmount - amount;
                item.setItemAmount(newAmount);
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
