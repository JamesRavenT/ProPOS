package com.wabizabi.wazabipos.Database.Instances;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.M04F03_Products.M04F03_CurrentCategory;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.M04F03_Products.M04F03_CurrentItem;

import com.wabizabi.wazabipos.Database.Schemas.ProductsList;
import com.wabizabi.wazabipos.Database.Schemas.ProductsItem;

import org.bson.types.ObjectId;

import io.realm.Realm;
import io.realm.RealmResults;

public class OpenProductsInstance {

    public static void toCreateCategory(int image, String categoryName){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                ProductsList category = db.createObject(ProductsList.class, new ObjectId());
                category.setCategoryImage(image);
                category.setCategoryName(categoryName);
            });
        }
    }

    public static void toEditCategory(int image, String categoryName){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                ProductsList category = db.where(ProductsList.class).equalTo("categoryName", M04F03_CurrentCategory).findFirst();
                RealmResults<ProductsItem> items = db.where(ProductsItem.class).equalTo("itemCategory", M04F03_CurrentCategory).findAll();
                if(!items.isEmpty()){
                    for(ProductsItem item : items){
                        item.setItemImage(image);
                        item.setItemCategory(categoryName);
                    }
                }
                category.setCategoryImage(image);
                category.setCategoryName(categoryName);
            });
        }
    }

    public static void toDeleteCategory(){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                ProductsList category = db.where(ProductsList.class).equalTo("categoryName", M04F03_CurrentCategory).findFirst();
                RealmResults<ProductsItem> items = db.where(ProductsItem.class).equalTo("itemCategory", M04F03_CurrentCategory).findAll();
                items.deleteAllFromRealm();
                category.deleteFromRealm();
            });
        }
    }

    public static void toCreateItem(int image, String category, String name, double price){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                ProductsItem product = db.createObject(ProductsItem.class, new ObjectId());
                product.setItemImage(image);
                product.setItemCategory(category);
                product.setItemName(name);
                product.setItemPrice(price);
            });
        }
    }

    public static void toEditItem(String name, double price){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                ProductsItem item = db.where(ProductsItem.class).equalTo("itemName", M04F03_CurrentItem).findFirst();
                item.setItemName(name);
                item.setItemPrice(price);
            });
        }
    }

    public static void toDeleteItem(){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                ProductsItem item = db.where(ProductsItem.class).equalTo("itemName", M04F03_CurrentItem).findFirst();
                item.deleteFromRealm();
            });
        }
    }
}
