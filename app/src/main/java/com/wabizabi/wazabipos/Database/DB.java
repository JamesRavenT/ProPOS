package com.wabizabi.wazabipos.Database;

import android.util.Log;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.SetOptions;
import com.wabizabi.wazabipos.Database.Instances.OpenFPGInstance;
import com.wabizabi.wazabipos.Database.Instances.OpenMenuInstance;
import com.wabizabi.wazabipos.Database.Instances.OpenStocksInstance;
import com.wabizabi.wazabipos.Database.Instances.OpenTransactionsInstance;
import com.wabizabi.wazabipos.Database.Instances.OpenUserInstance;
import com.wabizabi.wazabipos.Database.ObjectSchemas.InventoryTransaction;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmInventoryTransaction;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuCategory;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuItem;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmPopCombination;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmPopItem;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmSalesTransaction;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmStockCategory;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmStockItem;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmUser;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.LogHelper;

import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import io.realm.Sort;


public class DB {
    private static final String TAG = "Database";
    static Realm realm;
    static RealmConfiguration wazabi;
    static FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    static CollectionReference userProfile = firestore.collection("Debug_UserProfile");
    static CollectionReference menuCategory = firestore.collection("Debug_MenuCategory");
    static CollectionReference menuItem = firestore.collection("Debug_MenuItem");
    static CollectionReference stockCategory = firestore.collection("Debug_StockCategory");
    static CollectionReference stockItem = firestore.collection("Debug_StockItem");
    static CollectionReference salesTransaction = firestore.collection("Debug_TransactionSales");
    static CollectionReference inventoryTransaction = firestore.collection("Debug_TransactionInv");
    static CollectionReference algorithmFP = firestore.collection("Debug_AlgorithmFP");
    static CollectionReference algorithmFQ = firestore.collection("Debug_AlgorithmFQ");

    //Realm
    public static void init(){
        wazabi = new RealmConfiguration.Builder().name("wazabi.realm")
                .allowQueriesOnUiThread(true)
                .allowWritesOnUiThread(true)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(wazabi);
        realm = Realm.getDefaultInstance();
        Log.d(TAG, "RealmDatabase | Initialized");
    }

    //--CLOUD INSTANCE--//

    //Fire Store
    public static void fetchDataFromTheCloud(){
        RealmUser user = realm.where(RealmUser.class).findFirst();
        RealmResults<RealmMenuCategory> queryListMenuCategory = realm.where(RealmMenuCategory.class).findAll();
        RealmResults<RealmMenuItem> queryListMenuItems = realm.where(RealmMenuItem.class).findAll();
        RealmResults<RealmStockCategory> queryListStockCategory = realm.where(RealmStockCategory.class).findAll();
        RealmResults<RealmStockItem> queryListStockItems = realm.where(RealmStockItem.class).findAll();
        RealmResults<RealmInventoryTransaction> queryListInventoryTransaction = realm.where(RealmInventoryTransaction.class).findAll();
        RealmResults<RealmSalesTransaction> queryListSalesTransaction = realm.where(RealmSalesTransaction.class).findAll();
        RealmResults<RealmPopItem> queryListPopItems = realm.where(RealmPopItem.class).findAll();
        RealmResults<RealmPopCombination> queryListPopCombos = realm.where(RealmPopCombination.class).findAll();

        //Counts
        userProfile.get().addOnSuccessListener(snapshots -> {
            if(snapshots.getDocuments().size() > 0){
                List<DocumentSnapshot> listOfDocuments = snapshots.getDocuments();
                for(int i = 0 ; i < listOfDocuments.size() ; i++){
                    DocumentSnapshot snapShot = listOfDocuments.get(i);
                    DocumentReference docRef = snapShot.getReference();
                    docRef.get().addOnSuccessListener(document -> {
                        if(document.exists()){
                            int inv = document.getLong("transaction_InvCounter").intValue();
                            int sales = document.getLong("transaction_SalesCounter").intValue();
                            OpenUserInstance.toFetchCloudInventoryTransactionCount(inv);
                            OpenUserInstance.toFetchCloudSalesTransactionCount(sales);

                        }
                    });
                }
            }
        });

        //Menu Category
        if(queryListMenuCategory.isEmpty()){
            menuCategory.get().addOnSuccessListener(query -> {
                if(query.getDocuments().size() > 0){
                    List<DocumentSnapshot> listOfDocuments = query.getDocuments();
                    for(int i = 0 ; i < listOfDocuments.size() ; i++){
                        DocumentSnapshot snapShot = listOfDocuments.get(i);
                        DocumentReference docRef = snapShot.getReference();
                        docRef.get().addOnSuccessListener(document -> {
                            if(document.exists()){
                                ObjectId id = new ObjectId(document.getString("id"));
                                int icon = document.getLong("icon").intValue();
                                String name = document.getString("name");
                                OpenMenuInstance.toLoadCategoryFromCloud(id, icon, name);
                            }
                        });
                    }
                }
            });
        }

        //Menu Item
        if(queryListMenuItems.isEmpty()){
            menuItem.get().addOnSuccessListener(query -> {
                if(query.getDocuments().size() > 0){
                    List<DocumentSnapshot> listOfDocuments = query.getDocuments();
                    for(int i = 0 ; i < listOfDocuments.size() ; i++){
                        DocumentSnapshot snapShot = listOfDocuments.get(i);
                        DocumentReference docRef = snapShot.getReference();
                        docRef.get().addOnSuccessListener(document -> {
                            if(document.exists()){
                                ObjectId id = new ObjectId(document.getString("id"));
                                String category = document.getString("category");
                                String webName = document.getString("name");
                                double price = document.getLong("price").doubleValue();
                                int icon = document.getLong("z_POSIcon").intValue();
                                String posName = document.getString("z_POSName");
                                OpenMenuInstance.toLoadItemFromCloud(id, icon, category, webName, posName, price);
                            }
                        });
                    }
                }
            });
        }

        //Stock Category
        if(queryListStockCategory.isEmpty()){
            stockCategory.get().addOnSuccessListener(query -> {
                if(query.getDocuments().size() > 0){
                    List<DocumentSnapshot> listOfDocuments = query.getDocuments();
                    for(int i = 0 ; i < listOfDocuments.size() ; i++){
                        DocumentSnapshot snapShot = listOfDocuments.get(i);
                        DocumentReference docRef = snapShot.getReference();
                        docRef.get().addOnSuccessListener(document -> {
                            if(document.exists()){
                                ObjectId id = new ObjectId(document.getString("id"));
                                int icon = document.getLong("icon").intValue();
                                String name = document.getString("name");
                                OpenStocksInstance.toLoadCategoryFromCloud(id, icon, name);
                            }
                        });
                    }
                }
            });
        }

        //Stock Item
        if(queryListStockItems.isEmpty()){
            stockItem.get().addOnSuccessListener(query -> {
                if(query.getDocuments().size() > 0){
                    List<DocumentSnapshot> listOfDocuments = query.getDocuments();
                    for(int i = 0 ; i < listOfDocuments.size() ; i++){
                        DocumentSnapshot snapShot = listOfDocuments.get(i);
                        DocumentReference docRef = snapShot.getReference();
                        docRef.get().addOnSuccessListener(document -> {
                            if(document.exists()){
                                ObjectId id = new ObjectId(document.getString("id"));
                                String category = document.getString("category");
                                int icon = document.getLong("itemIcon").intValue();
                                String name = document.getString("itemName");
                                int value = document.getLong("value").intValue();
                                String unit = document.getString("unit");
                                OpenStocksInstance.toLoadItemFromCloud(id, icon,category, name, value, unit);
                            }
                        });
                    }
                }
            });
        }

        //Inventory Transaction
        if(queryListInventoryTransaction.isEmpty() || queryListInventoryTransaction.size() < user.getInvTransactionCloud()){
            Query query;
            if(queryListInventoryTransaction.isEmpty()){
                query = inventoryTransaction
                        .orderBy("_id", Query.Direction.ASCENDING)
                        .limit(5000);
            } else {
                RealmResults<RealmInventoryTransaction> transactionList = realm.where(RealmInventoryTransaction.class).sort("_id", Sort.ASCENDING).findAll();
                RealmInventoryTransaction transaction = transactionList.get(user.getInvTransactionLocal() - 1);
                query = inventoryTransaction
                        .orderBy("_id", Query.Direction.ASCENDING)
                        .startAfter(transaction.get_id())
                        .limit(5000);
            }

            query.get().addOnSuccessListener(snapshots -> {
                if(snapshots.getDocuments().size() > 0){
                    List<DocumentSnapshot> listOfDocuments = snapshots.getDocuments();
                    for(int i = 0 ; i < listOfDocuments.size() ; i++){
                        DocumentSnapshot snapShot = listOfDocuments.get(i);
                        DocumentReference docRef = snapShot.getReference();
                        docRef.get().addOnSuccessListener(document -> {
                            if(document.exists()){
                                String id = document.getString("id");
                                String transactionDT = document.getString("_transDT");
                                String transactionType = document.getString("_transType");
                                String itemName = document.getString("dt_ItemName");
                                String itemUnit = document.getString("dt_ItemUnit");
                                int amount = document.getLong("dt_ItemValue").intValue();
                                List<String> date = (List<String>) document.get("dt_variables");
                                OpenTransactionsInstance.toLoadInventoryTransactionFromCloud(id, transactionDT, transactionType, itemName, amount, itemUnit, date);
                                OpenUserInstance.toUpdateLocalInventoryTransactionCount();
                            }
                        });
                    }
                }
            });
        }

        //Sales Transaction
        if(queryListSalesTransaction.isEmpty() || queryListSalesTransaction.size() < user.getSalesTransactionsCloud()){
            Query query;
            if(queryListSalesTransaction.isEmpty()){
                query = salesTransaction
                        .orderBy("_id", Query.Direction.ASCENDING)
                        .limit(5000);
            } else {
                RealmResults<RealmSalesTransaction> transactionList = realm.where(RealmSalesTransaction.class).sort("_id", Sort.ASCENDING).findAll();
                RealmSalesTransaction transaction = transactionList.get(user.getSalesTransactionLocal()-1);
                query = salesTransaction
                        .orderBy("_id", Query.Direction.ASCENDING)
                        .startAfter(transaction.get_id())
                        .limit(5000);
            }
            query.get().addOnSuccessListener(snapshots -> {
                if(snapshots.getDocuments().size() > 0){
                    LogHelper.debug("SIZE" + snapshots.getDocuments().size());
                    List<DocumentSnapshot> listOfDocuments = snapshots.getDocuments();
                    for(int i = 0 ; i < listOfDocuments.size() ; i++){
                        DocumentSnapshot snapShot = listOfDocuments.get(i);
                        DocumentReference docRef = snapShot.getReference();
                        docRef.get().addOnSuccessListener(document -> {
                            if(document.exists()){
                                String id = document.getString("_id");
                                String transNo = document.getString("_transNo");
                                String transType = document.getString("_transType");
                                String transDT = document.getString("_transDT");
                                String cashier = document.getString("dt_cashier");
                                String order = document.getString("dt_order");
                                String orderType = document.getString("dt_orderType");
                                List<String> dtVar = (List<String>) document.get("dt_Variables");
                                List<String> itemWebName = (List<String>) document.get("listA_ItemWebName");
                                List<String> itemPOSName = (List<String>) document.get("listB_ItemPOSName");
                                List<Double> itemPrice = (List<Double>) document.get("listC_ItemPrice");
                                List<Long> itemAmount = (List<Long>) document.get("listD_ItemAmount");
                                List<String> discountItem = (List<String>) document.get("listE_DiscountItem");
                                List<String> discountName = (List<String>) document.get("listF_DiscountName");
                                List<Long> discountPercentage = (List<Long>) document.get("listG_DiscountPercent");
                                int totalItems = document.getLong("sectA_TotalItems").intValue();
                                double subTotal = document.getLong("sectB_SubTotal").doubleValue();
                                double tax = document.getLong("sectC_Tax").doubleValue();
                                double serviceFee = document.getLong("sectD_ServiceFee").doubleValue();
                                double discount = document.getLong("sectE_Discount").doubleValue();
                                double amountDue = document.getLong("sectF_AmountDue").doubleValue();
                                String paymentMethod = document.getString("sectG_PaymentMethod");
                                double amountRecieved = document.getLong("sectH_AmountRecieved").doubleValue();
                                double change = document.getLong("sectI_Change").doubleValue();
                                OpenTransactionsInstance.toLoadSalesFromCloud(
                                        id, transNo, transType, transDT, order, cashier, orderType,
                                        itemWebName, itemPOSName, itemPrice, itemAmount, discountItem, discountName, discountPercentage,
                                        totalItems, subTotal, tax, serviceFee, discount, amountDue, paymentMethod, amountRecieved, change, dtVar);
                                OpenUserInstance.toUpdateLocalSalesTransactionCount();
                            }
                        });
                    }
                }
            });
        }

        //Algorithm
        if(queryListPopItems.isEmpty()){
            algorithmFQ.get().addOnSuccessListener(query -> {
                if(query.getDocuments().size() > 0){
                    List<DocumentSnapshot> listOfDocuments = query.getDocuments();
                    for(int i = 0 ; i < listOfDocuments.size() ; i++){
                        DocumentSnapshot snapShot = listOfDocuments.get(i);
                        DocumentReference docRef = snapShot.getReference();
                        docRef.get().addOnSuccessListener(document -> {
                            if(document.exists()){
                                ObjectId id = new ObjectId(document.getString("_id"));
                                String name = document.getString("itemName");
                                int frequency = document.getLong("itemFrequency").intValue();
                                String year = document.getString("time_Year");
                                String month = document.getString("time_Month");
                                OpenFPGInstance.toLoadFQLResults(id, name, frequency, year, month);
                            }
                        });
                    }
                }
            });
        }

        if(queryListPopCombos.isEmpty()){
            algorithmFP.get().addOnSuccessListener(query -> {
                if(query.getDocuments().size() > 0){
                    List<DocumentSnapshot> listOfDocuments = query.getDocuments();
                    for(int i = 0 ; i < listOfDocuments.size() ; i++){
                        DocumentSnapshot snapShot = listOfDocuments.get(i);
                        DocumentReference docRef = snapShot.getReference();
                        docRef.get().addOnSuccessListener(document -> {
                            if(document.exists()){
                                ObjectId id = new ObjectId(document.getString("_id"));
                                String name = document.getString("itemName");
                                List<String> itemSet = (List<String>) document.get("itemSet");
                                int frequency = document.getLong("itemFrequency").intValue();
                                String year = document.getString("time_Year");
                                String month = document.getString("time_Month");
                                OpenFPGInstance.toLoadFPGResults(id, name, itemSet, frequency, year, month);
                            }
                        });
                    }
                }
            });
        }

    }

    //CHECK IF USER EXISTS
    public static void checkForUser(){
        userProfile.get().addOnSuccessListener(query -> {
            if(query.getDocuments().size() > 0) {
                List<DocumentSnapshot> listOfDocuments = query.getDocuments();
                for(int i = 0 ; i < listOfDocuments.size() ; i++) {
                    DocumentSnapshot snapShot = listOfDocuments.get(i);
                    DocumentReference docRef = snapShot.getReference();
                    docRef.get().addOnSuccessListener(document -> {
                        if (document.exists()) {
                            ObjectId id = new ObjectId(document.getString("id"));
                            String email = document.getString("email");
                            String name = document.getString("name");
                            int password = document.getLong("password").intValue();
                            int transaction_InvCounter = document.getLong("transaction_InvCounter").intValue();
                            int transaction_SalesCounter = document.getLong("transaction_SalesCounter").intValue();
                            OpenUserInstance.toLoadUserFromDB(id, email, name, password, transaction_InvCounter, transaction_SalesCounter);
                        }
                    });
                }
                LogHelper.debug("TRUE!");
            }
            else {
                LogHelper.debug("FALSE!");
            }
        });
    }

    //USER | UPLOAD
    public static void uploadUserToCloud(ObjectId id, String email, String name, int password){
        String docID = id.toString();
        Map<String, Object> document = new HashMap<>();
        document.put("_createdAt", new Date());
        document.put("id", docID);
        document.put("email", email);
        document.put("name", name);
        document.put("password", password);
        document.put("transaction_SalesCounter", 0);
        document.put("transaction_InvCounter", 0);
        userProfile.document(docID).set(document);
    }

    //USER | UPDATE EMAIL
    public static void updateUserEmailFromCloud(ObjectId id, String email){
        String docID = id.toString();
        Map<String, Object> document = new HashMap<>();
        document.put("_updatedAt", new Date());
        document.put("email", email);
        userProfile.document(docID).set(document, SetOptions.merge());
    }

    //USER | UPDATE NAME
    public static void updateUserNameFromCloud(ObjectId id, String name){
        String docID = id.toString();
        Map<String, Object> document = new HashMap<>();
        document.put("_updatedAt", new Date());
        document.put("name", name);
        userProfile.document(docID).set(document, SetOptions.merge());
    }

    //USER | UPDATE PASSWORD
    public static void updateUserPasswordFromCloud(ObjectId id, int password){
        String docID = id.toString();
        Map<String, Object> document = new HashMap<>();
        document.put("_updatedAt", new Date());
        document.put("password", password);
        userProfile.document(docID).set(document, SetOptions.merge());
    }

    //MENU CATEGORY | UPLOAD
    public static void uploadNewMenuCategoryToCloud(ObjectId id, int categoryIcon, String categoryName){
        String docID = id.toString();
        Map<String, Object> document = new HashMap<>();
        document.put("_createdAt", new Date());
        document.put("id", docID);
        document.put("icon", categoryIcon);
        document.put("name", categoryName);
        menuCategory.document(docID).set(document);
    }

    //MENU CATEGORY | UPDATE
    public static void updateMenuCategoryFromCloud(ObjectId id, int categoryIcon, String categoryName){
        String docID = id.toString();
        Map<String, Object> document = new HashMap<>();
        document.put("_updatedAt", new Date());
        document.put("icon", categoryIcon);
        document.put("name", categoryName);
        menuCategory.document(docID).set(document, SetOptions.merge());
    }

    //MENU CATEGORY | DELETE
    public static void deleteMenuCategoryFromCloud(RealmMenuCategory category){
        String docID = category.get_id().toString();
        menuCategory.document(docID).delete();
    }

    //MENU ITEM | UPLOAD
    public static void uploadNewMenuItemToCloud(ObjectId id, int itemIcon, String itemCategory, String itemWebName, String itemPOSName, double price) {
        String docID = id.toString();
        Map<String, Object> document = new HashMap<>();
        document.put("_createdAt", new Date());
        document.put("id", docID);
        document.put("category", itemCategory);
        document.put("name", itemWebName);
        document.put("price", price);
        document.put("z_POSIcon", itemIcon);
        document.put("z_POSName", itemPOSName);
        menuItem.document(docID).set(document);
    }

    //MENU ITEM | UPDATE
    public static void updateMenuItemFromCloud(ObjectId id, int itemIcon, String itemCategory, String itemWebName, String itemPOSName, double price){
        String docID = id.toString();
        Map<String, Object> document = new HashMap<>();
        document.put("_updatedAt", new Date());
        document.put("category", itemCategory);
        document.put("name", itemWebName);
        document.put("price", price);
        document.put("z_PosIcon", itemIcon);
        document.put("z_PosName", itemPOSName);
        menuItem.document(docID).set(document, SetOptions.merge());
    }

    //MENU ITEM | DELETE
    public static void deleteMenuItemFromCloud(RealmMenuItem item){
        String docID = item.get_id().toString();
        menuItem.document(docID).delete();
    }

    //FPG | UPLOAD DAILY
    public static void uploadFPGDaily(ObjectId id, List<List<String>> itemSets) {
        String docID = id.toString();
        Map<String, Object> document = new HashMap<>();
        Map<String, Object> fqItems = new HashMap<>();
        for(int i = 0 ; i < itemSets.size() ; i++){
            List<String> itemSet = itemSets.get(i);
            String position = (i < 9)
                    ? "itemSet0" + (i + 1)
                    : "itemSet" + (i + 1);
            fqItems.put(position, itemSet);
        }
        document.put("freqBw", fqItems);
        menuItem.document(docID).set(document, SetOptions.merge());
    }

    //FQL MONTHLY | UPLOAD
    public static void uploadPopItem(ObjectId id, String name, int itemFrequency, String year, String month){
        String docID = id.toString();
        Map<String, Object> document = new HashMap<>();
        document.put("_createdAt", new Date());
        document.put("_id", docID);
        document.put("itemName", name);
        document.put("itemFrequency", itemFrequency);
        document.put("time_Year", year);
        document.put("time_Month", month);
        algorithmFQ.document("FQ" + year + month).set(document, SetOptions.merge());
    }

    //FPG MONTHLY | UPLOAD
    public static void uploadPopCombo(ObjectId id, String name, List<String> combinations, int frequency, String year, String month) {
        String docID = id.toString();
        Map<String, Object> document = new HashMap<>();
        document.put("_createdAt", new Date());
        document.put("_id", docID);
        document.put("itemName", name);
        document.put("itemSet", combinations);
        document.put("itemFrequency", frequency);
        document.put("time_Year", year);
        document.put("time_Month", month);
        algorithmFP.document("FP" + year + month).set(document, SetOptions.merge());
    }

    //STOCK CATEGORY | UPLOAD
    public static void uploadNewStockCategoryToCloud(ObjectId id, int categoryIcon, String categoryName){
        String docID = id.toString();
        Map<String, Object> document = new HashMap<>();
        document.put("_createdAt", new Date());
        document.put("id", docID);
        document.put("icon", categoryIcon);
        document.put("name", categoryName);
        stockCategory.document(docID).set(document);
    }

    //STOCK CATEGORY | UPDATE
    public static void updateStockCategoryFromCloud(ObjectId id, int categoryIcon, String categoryName){
        String docID = id.toString();
        Map<String, Object> document = new HashMap<>();
        document.put("_updatedAt", new Date());
        document.put("icon", categoryIcon);
        document.put("name", categoryName);
        stockCategory.document(docID).set(document, SetOptions.merge());
    }

    //STOCK CATEGORY | DELETE
    public static void deleteStockCategoryFromCloud(RealmMenuCategory category){
        String docID = category.get_id().toString();
        stockCategory.document(docID).delete();
    }

    //STOCK ITEM | UPLOAD
    public static void uploadNewStockItemToCloud(ObjectId id, int itemIcon, String itemCategory, String itemName, String unitOfMeasurement, int value) {
        String docID = id.toString();
        Map<String, Object> document = new HashMap<>();
        document.put("_createdAt", new Date());
        document.put("id", docID);
        document.put("category", itemCategory);
        document.put("icon", itemIcon);
        document.put("name", itemName);
        document.put("unit", unitOfMeasurement);
        document.put("value", value);
        stockItem.document(docID).set(document);
    }

    //STOCK ITEM | UPDATE
    public static void updateStockItemFromCloud(ObjectId id, int itemIcon, String itemCategory, String itemName, String unitOfMeasurement, int value){
        String docID = id.toString();
        Map<String, Object> document = new HashMap<>();
        document.put("_updatedAt", new Date());
        document.put("category", itemCategory);
        document.put("icon", itemIcon);
        document.put("name", itemName);
        document.put("unit", unitOfMeasurement);
        document.put("value", value);
        stockItem.document(docID).set(document, SetOptions.merge());
    }

    //STOCK ITEM | DELETE
    public static void deleteStockItemFromCloud(RealmStockItem item){
        String docID = item.get_id().toString();
        stockItem.document(docID).delete();
    }

    //INVENTORY TRANSACTION | UPLOAD
    public static void uploadNewInventoryTransactionToCloud(String id,
                                                 String transactionDT,
                                                 String transactionType,
                                                 String itemName,
                                                 int amount,
                                                 String itemUnit,
                                                 String day,
                                                 String month,
                                                 String year){
        List<String> dateVariables = new ArrayList<>();
        dateVariables.add(year);
        dateVariables.add(month);
        dateVariables.add(day);

        String docID = id;
        Map<String, Object> document = new HashMap<>();
        document.put("_createdAt", new Date());
        document.put("_id", docID);
        document.put("_transType", transactionType);
        document.put("_transDT", transactionDT);
        document.put("dt_ItemName", itemName);
        document.put("dt_ItemUnit", itemUnit);
        document.put("dt_ItemValue", amount);
        document.put("dt_Variables", dateVariables);
        inventoryTransaction.document(docID).set(document);
    }

    //INVENTORY TRANSACTION | DELETE
    public static void voidInventoryTransactionFromCloud(InventoryTransaction transaction){
        String docID = transaction.getTransactionID();
        inventoryTransaction.document(docID).delete();
    }

    //SALES TRANSACTION | UPLOAD
    public static void uploadNewSalesToCloud(String id,
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
                                             double totalSubTotal,
                                             double totalTax,
                                             double totalServiceFee,
                                             double totalDiscount,
                                             double totalAmountDue,
                                             double totalAmountReceived,
                                             double change,
                                             String paymentMethod,
                                             String year,
                                             String month,
                                             String week,
                                             String daytxt,
                                             String dayno,
                                             String hr){
        List<String> dateVariables = new ArrayList<>();
        dateVariables.add(year);
        dateVariables.add(month);
        dateVariables.add(week);
        dateVariables.add(daytxt);
        dateVariables.add(dayno);
        dateVariables.add(hr);

        String docID = id;
        Map<String, Object> document = new HashMap<>();
        document.put("_createdAt", new Date());
        document.put("_id", docID);
        document.put("_transNo", transNo);
        document.put("_transType", transType);
        document.put("_transDT", dateAndTime);
        document.put("dt_cashier", cashier);
        document.put("dt_order", order);
        document.put("dt_orderType", orderType);
        document.put("dt_Variables", dateVariables);
        document.put("listA_ItemWebName", itemsetWebName);
        document.put("listB_ItemPOSName", itemsetPOSName);
        document.put("listC_ItemPrice", itemsetPrice);
        document.put("listD_ItemAmount", itemsetQty);
        document.put("listE_DiscountItem", discountsItem);
        document.put("listF_DiscountName", discountsName);
        document.put("listG_DiscountPercent", discountsPercent);
        document.put("sectA_TotalItems", totalItems);
        document.put("sectB_SubTotal", totalSubTotal);
        document.put("sectC_Tax", totalTax);
        document.put("sectD_ServiceFee", totalServiceFee);
        document.put("sectE_Discount", totalDiscount);
        document.put("sectF_AmountDue", totalAmountDue);
        document.put("sectG_PaymentMethod", paymentMethod);
        document.put("sectH_AmountRecieved", totalAmountReceived);
        document.put("sectI_Change", change);
        salesTransaction.document(docID).set(document);

        RealmUser user = realm.where(RealmUser.class).findFirst();
        userProfile.document(user.get_id().toString()).update("transaction_SalesCounter", FieldValue.increment(1));
    }


}

//    public static void syncRealmAndFirestore(Activity activity){
//        //User Profile
//        userProfile.addSnapshotListener(activity, new EventListener<QuerySnapshot>() {
//            @Override
//            public void onEvent(@Nullable QuerySnapshot query, @Nullable FirebaseFirestoreException error) {
//                if(error != null){ return; }
//                for (DocumentChange changes : query.getDocumentChanges()) {
//                    String email = changes.getDocument().getString("email");
//                    String name = changes.getDocument().getString("name");
//                    int password = changes.getDocument().getLong("password").intValue();
//                    RealmUser user = realm.where(RealmUser.class).findFirst();
//                    switch (changes.getType()) {
//                        case MODIFIED:
//                            if(!user.getEmail().equals(email))
//                                OpenUserInstance.toUpdateEmail(email);
//                            if(!user.getUserName().equals(name))
//                                OpenUserInstance.toUpdateUsername(name);
//                            if(user.getPassword() != password)
//                                OpenUserInstance.toUpdatePassword(String.valueOf(password));
//                            break;
//                    }
//                }
//            }
//        });
//
//        //Menu Category
//        menuCategory.addSnapshotListener(activity, new EventListener<QuerySnapshot>() {
//            @Override
//            public void onEvent(@Nullable QuerySnapshot query, @Nullable FirebaseFirestoreException error) {
//                if(error != null){ return; }
//                for (DocumentChange changes : query.getDocumentChanges()) {
//                    ObjectId id = new ObjectId(changes.getDocument().getString("id"));
//                    int icon = changes.getDocument().getLong("icon").intValue();
//                    String name = changes.getDocument().getString("name");
//                    RealmMenuCategory category = realm.where(RealmMenuCategory.class).equalTo("_id", id).findFirst();
//                    switch (changes.getType()) {
//                        case ADDED:
//                            if(category == null)
//                                OpenMenuInstance.toLoadCategoryFromCloud(id, icon, name);
//                            break;
//                        case MODIFIED:
//                            if(!category.getCategoryName().equals(name))
//                                OpenMenuInstance.toUpdateCategoryFromCloud(id, icon, name);
//                            break;
//                        case REMOVED:
//                            if(category != null)
//                                OpenMenuInstance.toDeleteCategory(name);
//                            break;
//                    }
//                }
//            }
//        });
//
//        //Menu Item
//        menuItem.addSnapshotListener(activity, new EventListener<QuerySnapshot>() {
//            @Override
//            public void onEvent(@Nullable QuerySnapshot query, @Nullable FirebaseFirestoreException error) {
//                if(error != null){ return; }
//                for (DocumentChange changes : query.getDocumentChanges()) {
//                    ObjectId id = new ObjectId(changes.getDocument().getString("id"));
//                    String category = changes.getDocument().getString("category");
//                    String webName = changes.getDocument().getString("name");
//                    double price = changes.getDocument().getLong("price").doubleValue();
//                    int icon = changes.getDocument().getLong("z_POSIcon").intValue();
//                    String posName = changes.getDocument().getString("z_POSName");
//                    RealmMenuItem item = realm.where(RealmMenuItem.class).equalTo("_id", id).findFirst();
//                    switch (changes.getType()) {
//                        case ADDED:
//                            if(item == null)
//                                OpenMenuInstance.toCreateItem(icon, category, webName, posName, price);
//                            break;
//                        case MODIFIED:
//                            if(item.getItemIcon() != icon || !item.getItemCategory().equals(category) || !item.getItemWebName().equals(webName) || !item.getItemPOSName().equals(posName) || item.getItemPrice() != price)
//                                OpenMenuInstance.toUpdateItemFromCloud(id, icon, category, webName, posName, price);
//                            break;
//                        case REMOVED:
//                            if(item != null)
//                                OpenMenuInstance.toDeleteItem(category, posName);
//                            break;
//                    }
//                }
//            }
//        });
//
//        //Stock Category
//        stockCategory.addSnapshotListener(activity, new EventListener<QuerySnapshot>() {
//            @Override
//            public void onEvent(@Nullable QuerySnapshot query, @Nullable FirebaseFirestoreException error) {
//                if(error != null){ return; }
//                for (DocumentChange changes : query.getDocumentChanges()) {
//                    ObjectId id = new ObjectId(changes.getDocument().getString("id"));
//                    int icon = changes.getDocument().getLong("icon").intValue();
//                    String name = changes.getDocument().getString("name");
//                    RealmStockCategory category = realm.where(RealmStockCategory.class).equalTo("_id", id).findFirst();
//                    switch (changes.getType()) {
//                        case ADDED:
//                            if(category == null)
//                                OpenStocksInstance.toLoadCategoryFromCloud(id, icon, name);
//                            break;
//                        case MODIFIED:
//                            if(!category.getCategoryName().equals(name))
//                                OpenStocksInstance.toUpdateCategoryFromCloud(id, icon, name);
//                            break;
//                        case REMOVED:
//                            if(category != null)
//                                OpenStocksInstance.toDeleteCategory(name);
//                            break;
//                    }
//                }
//            }
//        });
//
//        //Stock Item
//        stockItem.addSnapshotListener(activity, new EventListener<QuerySnapshot>() {
//            @Override
//            public void onEvent(@Nullable QuerySnapshot query, @Nullable FirebaseFirestoreException error) {
//                if(error != null){ return; }
//                for (DocumentChange changes : query.getDocumentChanges()) {
//                    ObjectId id = new ObjectId(changes.getDocument().getString("id"));
//                    int icon = changes.getDocument().getLong("icon").intValue();
//                    String category = changes.getDocument().getString("category");
//                    String name = changes.getDocument().getString("name");
//                    int value = changes.getDocument().getLong("value").intValue();
//                    String unit = changes.getDocument().getString("unit");
//                    RealmStockItem item = realm.where(RealmStockItem.class).equalTo("_id", id).findFirst();
//                    switch (changes.getType()) {
//                        case ADDED:
//                            if(item == null)
//                                OpenStocksInstance.toCreateItem(icon, category, name, value, unit);
//                            break;
//                        case MODIFIED:
//                            if(item.getItemIcon() != icon || !item.getItemCategory().equals(category) || !item.getItemName().equals(name) || item.getItemAmount() != value || !item.getUnitOfMeasurement().equals(unit))
//                                OpenStocksInstance.toUpdateItemFromCloud(id, icon, category, name, unit);
//                            break;
//                        case REMOVED:
//                            if(item != null)
//                                OpenStocksInstance.toDeleteItem(category, name);
//                            break;
//                    }
//                }
//            }
//        });
//
//        //Inventory Transaction
//        inventoryTransaction.addSnapshotListener(activity, new EventListener<QuerySnapshot>() {
//            @Override
//            public void onEvent(@Nullable QuerySnapshot query, @Nullable FirebaseFirestoreException error) {
//                if(error != null){ return; }
//                for (DocumentChange changes : query.getDocumentChanges()) {
//                    String id = changes.getDocument().getString("id");
//                    String transactionDT = changes.getDocument().getString("_transDT");
//                    String transactionType = changes.getDocument().getString("_transType");
//                    String itemName = changes.getDocument().getString("dt_ItemName");
//                    String itemUnit = changes.getDocument().getString("dt_ItemUnit");
//                    int amount = changes.getDocument().getLong("dt_ItemValue").intValue();
//                    List<String> date = (List<String>) changes.getDocument().get("dt_variables");
//                    RealmInventoryTransaction transaction = realm.where(RealmInventoryTransaction.class).equalTo("_id", id).findFirst();
//                    switch (changes.getType()) {
//                        case ADDED:
//                            if(transaction == null)
//                                OpenTransactionsInstance.toLoadInventoryTransactionFromCloud(id, transactionDT, transactionType, itemName, amount, itemUnit, date);
//                            break;
//                        case REMOVED:
//                            if(transaction != null)
//                                OpenTransactionsInstance.toVoidInventoryTransactionFromCloud(id);
//                            break;
//                    }
//                }
//            }
//        });
//
//        //Sales Transaction
//        salesTransaction.addSnapshotListener(activity, new EventListener<QuerySnapshot>() {
//            @Override
//            public void onEvent(@Nullable QuerySnapshot query, @Nullable FirebaseFirestoreException error) {
//                if(error != null){ return; }
//                for (DocumentChange changes : query.getDocumentChanges()) {
//                    String id = changes.getDocument().getString("_id");
//                    String transNo = changes.getDocument().getString("_transNo");
//                    String transType = changes.getDocument().getString("_transType");
//                    String transDT = changes.getDocument().getString("_transDT");
//                    String cashier = changes.getDocument().getString("dt_cashier");
//                    String order = changes.getDocument().getString("dt_order");
//                    String orderType = changes.getDocument().getString("dt_orderType");
//                    List<String> dtVar = (List<String>) changes.getDocument().get("dt_Variables");
//                    List<String> itemWebName = (List<String>) changes.getDocument().get("listA_ItemWebName");
//                    List<String> itemPOSName = (List<String>) changes.getDocument().get("listB_ItemPOSName");
//                    List<Double> itemPrice = (List<Double>) changes.getDocument().get("listC_ItemPrice");
//                    List<Long> itemAmount = (List<Long>) changes.getDocument().get("listD_ItemAmount");
//                    List<String> discountItem = (List<String>) changes.getDocument().get("listE_DiscountItem");
//                    List<String> discountName = (List<String>) changes.getDocument().get("listF_DiscountName");
//                    List<Long> discountPercentage = (List<Long>) changes.getDocument().get("listG_DiscountPercent");
//                    int totalItems = changes.getDocument().getLong("sectA_TotalItems").intValue();
//                    double subTotal = changes.getDocument().getLong("sectB_SubTotal").doubleValue();
//                    double tax = changes.getDocument().getLong("sectC_Tax").doubleValue();
//                    double serviceFee = changes.getDocument().getLong("sectD_ServiceFee").doubleValue();
//                    double discount = changes.getDocument().getLong("sectE_Discount").doubleValue();
//                    double amountDue = changes.getDocument().getLong("sectF_AmountDue").doubleValue();
//                    String paymentMethod = changes.getDocument().getString("sectG_PaymentMethod");
//                    double amountRecieved = changes.getDocument().getLong("sectH_AmountRecieved").doubleValue();
//                    double change = changes.getDocument().getLong("sectI_Change").doubleValue();
//                    switch (changes.getType()) {
//                        case ADDED:
//                            RealmSalesTransaction transaction = realm.where(RealmSalesTransaction.class).equalTo("_id", id).findFirst();
//                            if(transaction == null) {
////                                LogHelper.debug(transaction.get_id());
//                                LogHelper.debug("Transaction Is Null!");
//                                OpenTransactionsInstance.toLoadSalesFromCloud(
//                                        id, transNo, transType, transDT, order, cashier, orderType,
//                                        itemWebName, itemPOSName, itemPrice, itemAmount, discountItem, discountName, discountPercentage,
//                                        totalItems, subTotal, tax, serviceFee, discount, amountDue, paymentMethod, amountRecieved, change, dtVar);
//                            }
//                            break;
//                    }
//                }
//            }
//        });
//    }