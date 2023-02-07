package com.wabizabi.wazabipos.Database;

import android.app.Activity;
import android.util.Log;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;
import com.wabizabi.wazabipos.Database.Instances.OpenMenuInstance;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuCategory;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuItem;

import org.bson.types.ObjectId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;


public class DB {
    private static final String TAG = "Database";
    static Realm realm = Realm.getDefaultInstance();
    static RealmConfiguration wazabi;
    static FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    static CollectionReference menuCategory = firestore.collection("WazabiCATEGORYSYNCTEST");
    static CollectionReference menuItem = firestore.collection("WazabiITEMSYNCTEST");

    //Realm
    public static void init(){
        wazabi = new RealmConfiguration.Builder().name("wazabi.realm")
                .deleteRealmIfMigrationNeeded()
                .allowQueriesOnUiThread(true)
                .allowWritesOnUiThread(true)
                .build();
        Realm.setDefaultConfiguration(wazabi);
        Log.d(TAG, "RealmDatabase | Initialized");
    }

    //Fire Store
    public static void fetchDataFromTheCloud(){
        menuCategory.get().addOnSuccessListener(query -> {
            if(query.getDocuments().size() > 0){
                List<DocumentSnapshot> listOfDocuments = query.getDocuments();
                for(int i = 0 ; i < listOfDocuments.size() ; i++){
                    DocumentSnapshot snapShot = listOfDocuments.get(i);
                    DocumentReference docRef = snapShot.getReference();
                    docRef.get().addOnSuccessListener(document -> {
                        if(document.exists()){
                            ObjectId id = new ObjectId(document.getString("Category ID"));
                            int icon = document.getLong("Icon").intValue();
                            String image = document.getString("Image");
                            String name = document.getString("Name");
                            OpenMenuInstance.toLoadCategoryFromCloud(id, icon, image, name);
                        }
                    });
                }
            }
        });

        menuItem.get().addOnSuccessListener(query -> {
           if(query.getDocuments().size() > 0){
               List<DocumentSnapshot> listOfDocuments = query.getDocuments();
               for(int i = 0 ; i < listOfDocuments.size() ; i++){
                   DocumentSnapshot snapShot = listOfDocuments.get(i);
                   DocumentReference docRef = snapShot.getReference();
                   docRef.get().addOnSuccessListener(document -> {
                       if(document.exists()){
                           ObjectId id = new ObjectId(document.getString("Item ID"));
                           int icon = document.getLong("Icon").intValue();
                           String image = document.getString("Image");
                           String category = document.getString("Item Category");
                           String webName = document.getString("Item Name");
                           String posName = document.getString("Item POS Name");
                           double price = document.getLong("Item Price").doubleValue();
                           OpenMenuInstance.toLoadItemFromCloud(id, icon, image, category, webName, posName, price);
                       }
                   });
               }
           }
        });
    }

    public static void syncRealmAndFirestore(Activity activity){
        RealmResults<RealmMenuItem> listOfItems = realm.where(RealmMenuItem.class).findAll();
        menuItem.addSnapshotListener(activity, (query, collectionError) -> {
            if(collectionError != null){ return; }
            List<DocumentSnapshot> listOfDocuments = query.getDocuments();
            for(int i = 0 ; i < listOfItems.size() ; i++) {
                String documentKey = listOfItems.get(i).get_id().toString();
                DocumentSnapshot snapshot = listOfDocuments.get(i);
                DocumentReference docRef = snapshot.getDocumentReference(documentKey);
                docRef.addSnapshotListener((document, docuError) -> {
                    if(docuError != null){ return; }
                    if(document.exists()){
                        String name = document.getString("Item Name");
                        String image = document.getString("Item Image");
                        String category = document.getString("Menu Name");
                        OpenMenuInstance.toUpdateItemImage(name, image, category);
                    }
                });
            }
        });
    }

    public static void uploadNewCategoryToCloud(ObjectId id, int categoryIcon, String categoryName){
        String docID = id.toString();
        Map<String, Object> document = new HashMap<>();
        document.put("Category ID", docID);
        document.put("Icon", categoryIcon);
        document.put("Image", "");
        document.put("Name", categoryName);
        menuCategory.document(docID).set(document);
    }

    public static void updateCategoryFromCloud(ObjectId id, int categoryIcon, String categoryName){
        String docID = id.toString();
        Map<String, Object> document = new HashMap<>();
        document.put("Icon", categoryIcon);
        document.put("Name", categoryName);
        menuCategory.document(docID).set(document, SetOptions.merge());
    }

    public static void deleteCategoryFromCloud(RealmMenuCategory category){
        String docID = category.get_id().toString();
        menuCategory.document(docID).delete();

    }

    public static void uploadNewItemToCloud(ObjectId id, int itemIcon, String itemImage, String itemCategory, String itemWebName, String itemPOSName, double price) {
        String docID = id.toString();
        Map<String, Object> document = new HashMap<>();
        document.put("Item ID", docID);
        document.put("Icon", itemIcon);
        document.put("Image", itemImage);
        document.put("Item Category", itemCategory);
        document.put("Item Name", itemWebName);
        document.put("Item POS Name", itemPOSName);
        document.put("Item Price", price);
        menuItem.document(docID).set(document);
    }

    public static void updateItemFromCloud(ObjectId id, int itemIcon, String itemCategory, String itemWebName, String itemPOSName, double price){
        String docID = id.toString();
        Map<String, Object> document = new HashMap<>();
        document.put("Item ID", docID);
        document.put("Icon", itemIcon);
        document.put("Item Category", itemCategory);
        document.put("Item Name", itemWebName);
        document.put("Item POS Name", itemPOSName);
        document.put("Item Price", price);
        menuItem.document(docID).set(document, SetOptions.merge());
    }

    public static void deleteItemFromCloud(RealmMenuItem item){
        String docID = item.get_id().toString();
        menuItem.document(docID).delete();
    }

    public static void uploadPopularCombinations(ObjectId id, List<List<String>> itemSets) {
        String docID = id.toString();
        Map<String, Object> document = new HashMap<>();
        for(int i = 0 ; i < itemSets.size() ; i++){
            List<String> itemSet = itemSets.get(i);
            String position = (i < 9)
                    ? "Popular Combination No.0" + (i + 1)
                    : "Popular Combination No." + (i + 1);
            document.put(position, itemSet);
        }
        menuItem.document(docID).set(document, SetOptions.merge());
    }
}
