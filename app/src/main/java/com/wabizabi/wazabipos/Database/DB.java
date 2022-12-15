package com.wabizabi.wazabipos.Database;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.realm.Realm;
import io.realm.RealmConfiguration;


public class DB {
    private static final String TAG = "Database";
    public static Realm realm;
    public static RealmConfiguration wazabi;
    public static FirebaseFirestore firestore = FirebaseFirestore.getInstance();;



    public static void init(){
        wazabi = new RealmConfiguration.Builder().name("wazabi.realm")
                .deleteRealmIfMigrationNeeded()
                .allowQueriesOnUiThread(true)
                .allowWritesOnUiThread(true)
                .build();
        Realm.setDefaultConfiguration(wazabi);
        Log.d(TAG, "RealmDatabase | Initialized");
    }

    public static void uploadFPListData(Map<String, Map<List<String>, Integer>> fpList) {
        int counter = 0;
        for (Map.Entry<String, Map<List<String>, Integer>> entry : fpList.entrySet()) {
            counter++;
            String documentID = (counter < 10) ? "Item No.0" + counter : "Item No." + counter;
            Map<String, Object> items = new HashMap<>();
            Map<String, Object> frequentItemSets = new HashMap<>();
            Set<List<String>> keyItemSets = entry.getValue().keySet();
            List<List<String>> listItemSets = new ArrayList<>(keyItemSets);
            for (int i = 0; i < listItemSets.size(); i++) {
                List<String> itemset = listItemSets.get(i);
                if (i < 9) {
                    String itemsetPosition = "FQItemSet No.0" + String.valueOf(i + 1);
                    frequentItemSets.put(itemsetPosition, itemset);
                } else {
                    String itemsetPosition = "FQItemSet No." + String.valueOf(i + 1);
                    frequentItemSets.put(itemsetPosition, itemset);
                }
            }
            switch(entry.getKey()){
                case "3 Cheese Crispy Kani Roll":
                    items.put("id", "0kng9kE1uBAmqYRyIngs");
                    break;
                case "All Fried Sushi Platter":
                    items.put("id",  "7L50djQmJFHtJg4vJYQV");
                    break;
                case "Salmon & Shrimp Tempura Roll":
                    items.put("id", "7zXORUbGKKNmHmykYowT");
                    break;
                case "Aburi Salmon Roll":
                    items.put("id", "BWv5lQS0f3XCJq1vvElY");
                    break;
                case "All California Sushi Platter":
                    items.put("id", "DfX7psgV2tBNBE2jwD3R");
                    break;
                case "Yuzu Creamy Salmon Roll":
                    items.put("id", "E9MK5mrfyjgnLWCzUDtc");
                    break;
                case "Chef's Special Sushi Platter":
                    items.put("id", "FKxS1zC9iPI0ZgbwWy8c");
                    break;
                case "Salad Wrap":
                    items.put("id", "KCCjnrIcHLKrvjxpubzF");
                    break;
                case "Shrimp & Vegetable Tempura":
                    items.put("id", "KU1qtVtRMKD5fAYU3ngK");
                    break;
                case "Shrimp Tempura":
                    items.put("id", "Shrimp Tempura");
                    break;
                case "Salmon Lovers Roll":
                    items.put("id", "Rvn8NT0ralv5vQBAbQct");
                    break;
                case "Beef Yaki Udon":
                    items.put("id", "SE6PKDkjULesexAzBHm0");
                    break;
                case "Premium Sushi Set":
                    items.put("id", "UspEShIxLliA7iht5Qtb");
                    break;
                case "Gyudon":
                    items.put("id", "VPIwOHxedfalbsP1gtRO");
                    break;
                case "Deluxe Sushi Platter":
                    items.put("id", "W8RX4MtSO4WiKwlQhfcR");
                    break;
                case "Kani Salad":
                    items.put("id", "X8WUbmIsQF0rKUTv6EU6");
                    break;
                case "Katsudon":
                    items.put("id", "XCWxjBKiXtO6oL9wptRG");
                    break;
                case "Tuna Sashimi":
                    items.put("id", "cJDTInjSHpCdqqDqsScQ");
                    break;
                case "Fried Futomaki Roll":
                    items.put("id", "erHlQwlgcx7TPgWBDfSN");
                    break;
                case "Crispy Spicy Tuna":
                    items.put("id", "exzOCdymq6yrAYvhhnEW");
                    break;
                case "Tuna Tataki Roll":
                    items.put("id", "jMkwgZuxeU76WbF8u6tN");
                    break;
                case "Crispy Philly Roll":
                    items.put("id", "t7ELrhdh2SXmQohOZomR");
                    break;
                case "Tuna Salmon Dynamite Roll":
                    items.put("id", "xYLyR2JQzneEbMYfmlag");
                    break;
                case "Miso Ramen":
                    items.put("id", "y0Z58xY17yB9iZm6bvGf");
                    break;
                case "California Deluxe":
                    items.put("id", "xQ7hWuxMyLSTmCJaUX4b");
                    break;
                case "California Maki":
                    items.put("id", "V9ZuWIrxpljeWQ2CKhsp");
                    break;
                case "Krazy Volcano":
                    items.put("id", "ATRn8sV9DE8aMvvU82m0");
                    break;
                case "nigiri salmon":
                    items.put("id","H6DhREj1NoeKqqVeLEcm");
                    break;
                case "Salmon sashimi":
                    items.put("id", "TqRu62Bl1d1PJfyiPmDG");
                    break;
                case "Tantan Ramen":
                    items.put("id", "ndBtCNgV2CTAvoloIh8N");
                    break;
                case "Teriyakidon":
                    items.put("id", "zwVakQO8ZFRmqnpDs955");
                    break;
                case "Tonkotsu Ramen":
                    items.put("id","YXOQwJ9oUyQfks6SQrVg");
                    break;
                case "rainbow chirashi":
                    items.put("id", "hfLpIoMW7modn0jP0WU1");
                    break;
                case "test" :
                    items.put("id", "GPi5D1UxEMc7lm83aoOc");
                    break;
                case "Sea weeds Salad":
                    items.put("id", "dYxTqLbDJszaatYwlTWG");
                    break;
                default:
                    items.put("id", String.valueOf(new ObjectId()));
                    break;
            }
            items.put("itemName", entry.getKey());
            items.put("itemSets", frequentItemSets);
            DocumentReference docu = firestore.collection("WazabiPOSTEST3").document(entry.getKey());
            docu.get().addOnCompleteListener(task -> {
                if(task.isSuccessful()){
                    DocumentSnapshot document = task.getResult();
                    if(document.exists()){
                        firestore.collection("WazabiPOSTEST3").document(documentID).update(items);
                    } else {
                        firestore.collection("WazabiPOSTEST3").document(documentID).set(items);
                    }
                }
            });
        }
    }
    public static void uploadFQListData(Map<String, Integer> fqList) {
        Map<String,Object> items = new HashMap<>();
        for(Map.Entry<String, Integer> entry : fqList.entrySet()){
            String itemName = entry.getKey();
            Integer itemFrequency = entry.getValue();
            items.put(itemName, itemFrequency);

        }
        firestore = FirebaseFirestore.getInstance();
        firestore.collection("WazabiPOSTEST4").document("Item Frequency").set(items);
    }

}
