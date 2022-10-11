package com.wabizabi.wazabipos.Database;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

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
    public static FirebaseFirestore firestore;

    public static void init(){
        wazabi = new RealmConfiguration.Builder().name("wazabi.realm")
                .deleteRealmIfMigrationNeeded()
                .allowQueriesOnUiThread(true)
                .allowWritesOnUiThread(true)
                .build();
        Realm.setDefaultConfiguration(wazabi);
        Log.d(TAG, "RealmDatabase | Initialized");
    }
    public static void uploadFPListData(Map<String, Map<List<String>, Integer>> fpList){
        Map<String, Object> items = new HashMap<>();
        for(Map.Entry<String, Map<List<String>, Integer>> entry : fpList.entrySet()){
            Map<String, Object> frequentItemSets = new HashMap<>();
            Set<List<String>> keyItemSets = entry.getValue().keySet();
            List<List<String>> listItemSets = new ArrayList<>(keyItemSets);
            for(int i = 0 ; i < listItemSets.size() ; i ++){
                List<String> itemset = listItemSets.get(i);
                if (i < 9){
                    String itemsetPosition = "FQItemSet No.0"+ String.valueOf(i+1);
                    frequentItemSets.put(itemsetPosition, itemset);
                } else {
                    String itemsetPosition = "FQItemSet No."+ String.valueOf(i+1);
                    frequentItemSets.put(itemsetPosition, itemset);
                }
            }
            items.put(entry.getKey(), frequentItemSets);

        }
        firestore = FirebaseFirestore.getInstance();
        firestore.collection("WazabiPOS").document("FrequentPatterns").set(items);

    }
    public static void uploadFQListData(Map<String, Integer> fqList) {
        Map<String,Object> items = new HashMap<>();
        for(Map.Entry<String, Integer> entry : fqList.entrySet()){
            String itemName = entry.getKey();
            Integer itemFrequency = entry.getValue();
            items.put(itemName, itemFrequency);
        }
        firestore = FirebaseFirestore.getInstance();
        firestore.collection("WazabiPOSTEST").document("FrequentList").set(items);
    }

}
