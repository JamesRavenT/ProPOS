package com.wabizabi.wazabipos.Database;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
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
            String documentID = (counter < 9) ? "Item No.0" + counter : "Item No." + counter;
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
            items.put("id", String.valueOf(new ObjectId()));
            items.put("itemName", entry.getKey());
            items.put("itemSets", frequentItemSets);
            DocumentReference docu = firestore.collection("WazabiPOSTEST2").document(documentID);
            docu.get().addOnCompleteListener(task -> {
                if(task.isSuccessful()){
                    DocumentSnapshot document = task.getResult();
                    if(document.exists()){
                        firestore.collection("WazabiPOSTEST2").document(documentID).update(items);
                    } else {
                        firestore.collection("WazabiPOSTEST2").document(documentID).set(items);
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
        firestore.collection("WazabiPOSTEST").document("FrequentList").set(items);
    }

}
