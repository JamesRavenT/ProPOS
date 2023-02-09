package com.wabizabi.wazabipos.Database;

import android.app.Activity;
import android.util.Log;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;
import com.wabizabi.wazabipos.Database.Instances.OpenMenuInstance;
import com.wabizabi.wazabipos.Database.Instances.OpenUserInstance;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuCategory;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuItem;

import org.bson.types.ObjectId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;


public class DB {
    private static final String TAG = "Database";
    static Realm realm = Realm.getDefaultInstance();
    static RealmConfiguration wazabi;
    static FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    static CollectionReference userProfile = firestore.collection("WazabiUSERSYNCTEST");
    static CollectionReference menuCategory = firestore.collection("WazabiCATEGORYSYNCTEST");
    static CollectionReference menuItem = firestore.collection("WazabiITEMSYNCTEST");
    static CollectionReference salesTransaction = firestore.collection("WazabiSALESSYNCTEST");

    //Realm
    public static void init(){
        wazabi = new RealmConfiguration.Builder().name("wazabi.realm")
                .allowQueriesOnUiThread(true)
                .allowWritesOnUiThread(true)
                .deleteRealmIfMigrationNeeded()
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

    public static void checkForUser(){
        userProfile.get().addOnSuccessListener(query -> {
            if(query.getDocuments().size() > 0) {
                List<DocumentSnapshot> listOfDocuments = query.getDocuments();
                for(int i = 0 ; i < listOfDocuments.size() ; i++) {
                    DocumentSnapshot snapShot = listOfDocuments.get(i);
                    DocumentReference docRef = snapShot.getReference();
                    docRef.get().addOnSuccessListener(document -> {
                        if (document.exists()) {
                            ObjectId id = new ObjectId(document.getString("User ID"));
                            String email = document.getString("User Mail");
                            String name = document.getString("User Name");
                            int password = document.getLong("User Password").intValue();
                            OpenUserInstance.toLoadUserFromDB(id, email, name, password);
                        }
                    });
                }
            }
        });
    }

    public static void uploadUserToCloud(ObjectId id, String email, String name, int password){
        String docID = id.toString();
        Map<String, Object> document = new HashMap<>();
        document.put("User ID", docID);
        document.put("User Mail", email);
        document.put("User Name", name);
        document.put("User Password", password);
        userProfile.document(docID).set(document);
    }

    public static void updateUserEmailFromCloud(ObjectId id, String email){
        String docID = id.toString();
        Map<String, Object> document = new HashMap<>();
        document.put("User Mail", email);
        userProfile.document(docID).set(document, SetOptions.merge());
    }

    public static void updateUserNameFromCloud(ObjectId id, String name){
        String docID = id.toString();
        Map<String, Object> document = new HashMap<>();
        document.put("User Name", name);
        userProfile.document(docID).set(document, SetOptions.merge());
    }

    public static void updateUserPasswordFromCloud(ObjectId id, int password){
        String docID = id.toString();
        Map<String, Object> document = new HashMap<>();
        document.put("User Password", password);
        userProfile.document(docID).set(document, SetOptions.merge());
    }


    public static void syncRealmAndFirestore(Activity activity){
        RealmResults<RealmMenuCategory> listOfCategories = realm.where(RealmMenuCategory.class).findAll();
        menuCategory.addSnapshotListener(activity, (query, collectionError) -> {
            if(collectionError != null){ return; }
            List<DocumentSnapshot> listOfDocuments = query.getDocuments();
            for(int i = 0 ; i < listOfCategories.size() ; i++) {
                String documentKey = listOfCategories.get(i).get_id().toString();
                DocumentSnapshot snapshot = listOfDocuments.get(i);
                DocumentReference docRef = snapshot.getDocumentReference(documentKey);
                docRef.addSnapshotListener((document, docuError) -> {
                    if(docuError != null){ return; }
                    if(document.exists()){
                        String image = document.getString("Image");
                        String category = document.getString("Name");
                        OpenMenuInstance.toUpdateCategoryImage(image, category);
                    }
                });
            }
        });

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
                        String category = document.getString("Item Category");
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

    public static void uploadNewSalesToCloud(ObjectId id,
                                             String dataVer,
                                             String transID,
                                             String transNo,
                                             String transType,
                                             String dateAndTime,
                                             String cashier,
                                             String order,
                                             String orderType,
                                             List<String> itemsetWebName,
                                             List<String> itemsetPOSName,
                                             List<Double> itemsetPrice,
                                             List<Integer> itemsetQty,
                                             List<String> discountsItem,
                                             List<String> discountsName,
                                             List<Integer> discountsPercent,
                                             int totalItems,
                                             double totalAmountDue,
                                             double totalDiscount,
                                             double totalTax,
                                             double totalAmountReceived,
                                             double change,
                                             String paymentMethod,
                                             String year,
                                             String month,
                                             String week,
                                             String daytxt,
                                             String dayno,
                                             String hr){
        String docID = id.toString();
        Map<String, Object> document = new HashMap<>();
        document.put("00_Object ID", docID);
        document.put("01_Data Ver", dataVer);
        document.put("02_TransID", transID);
        document.put("03_TransNo", transNo);
        document.put("04_TransType", transType);
        document.put("05_DateTime", dateAndTime);
        document.put("06_Cashier", cashier);
        document.put("07_Order", order);
        document.put("08_OrderType", orderType);
        document.put("09_ItemWebName", itemsetWebName);
        document.put("10_ItemPOSName", itemsetPOSName);
        document.put("11_ItemPrice", itemsetPrice);
        document.put("12_ItemAmount", itemsetQty);
        document.put("13_DiscountItem", discountsItem);
        document.put("14_DiscountName", discountsName);
        document.put("15_DiscountPercent", discountsPercent);
        document.put("16_TotalItems", totalItems);
        document.put("17_TotalAmountDue", totalAmountDue);
        document.put("18_TotalDiscount", totalDiscount);
        document.put("19_TotalTax", totalTax);
        document.put("20_TotalAmountRecieved", totalAmountReceived);
        document.put("21_Change", change);
        document.put("22_PaymentMethod", paymentMethod);
        document.put("23_Year", year);
        document.put("24_Month", month);
        document.put("25_Week", week);
        document.put("26_DayTxt", daytxt);
        document.put("27_DayNo", dayno);
        document.put("28_Hour", hr);
        salesTransaction.document(docID).set(document);
    }
}


//db.collection("users")
//        .whereEqualTo(FieldPath.documentId(), "idOfDocumentToListenTo")
//        .addSnapshotListener(new EventListener<QuerySnapshot>() {
//@Override
//public void onEvent(@Nullable QuerySnapshot snapshots,
//@Nullable FirebaseFirestoreException e) {
//        if (e != null) {
//        Log.w(TAG, "listen:error", e);
//        return;
//        }
//
//        for (DocumentChange dc : snapshots.getDocumentChanges()) {
//        switch (dc.getType()) {
//        case ADDED:
//        Log.d(TAG, "New user: " + dc.getDocument().getData());
//        break;
//        case MODIFIED:
//        Log.d(TAG, "Modified user: " + dc.getDocument().getData());
//        break;
//        case REMOVED:
//        Log.d(TAG, "Removed user: " + dc.getDocument().getData());
//        // 👆 this is what you're looking for
//        break;
//        }
//        }
//
//        }
//        });


//VATABLE SALES = 1004.46428571
//VAT =