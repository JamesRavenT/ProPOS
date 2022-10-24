package com.wabizabi.wazabipos.Utilities.BackgroundThreads;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.wabizabi.wazabipos.Utilities.Algorithm.FQList;
import com.wabizabi.wazabipos.Utilities.Algorithm.Tree;
import com.wabizabi.wazabipos.Database.Schemas.SalesTransaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import io.realm.Realm;
import io.realm.RealmResults;

public class W01_Algorithm extends Worker {
    public static Map<String, Integer> fqItems = new TreeMap<>();
    public static Map<String, Integer> fqList = new LinkedHashMap<>();
    public static Map<String, Map<List<String>, Integer>> fpList = new ConcurrentHashMap<>();

    static int minSuppThreshold;
    static RealmResults<SalesTransaction> transactionsAll;

    public W01_Algorithm(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        transactionsAll = realm.where(SalesTransaction.class).findAll();
        if (!transactionsAll.isEmpty()) {
            List<List<String>> transactions = new ArrayList<>();
            for (SalesTransaction sales : transactionsAll) {
                List<String> listOfItemsinTheTransaction = sales.getNameOfEachItem();
                List<String> transaction = new ArrayList<>(listOfItemsinTheTransaction);
                transactions.add(transaction);
            }
            minSuppThreshold = FQList.calculateMinSupp(transactions, fqItems);
            FQList.create(minSuppThreshold, fqItems, fqList);
            Tree fpTree = Tree.create(transactions, fqList);
            List<List<String>> paths = Tree.mine(fpTree);
            findFrequentPatterns(paths, fqList, fpList, minSuppThreshold);
        }
        realm.commitTransaction();
        return Result.success();
    }
    static void findFrequentPatterns(
            List<List<String>> stringPaths,
            Map<String, Integer> fqList,
            Map<String, Map<List<String>, Integer>> fpList,
            int minSuppThreshold
    ) {
        fpList.clear();
        for (Map.Entry<String, Integer> items : fqList.entrySet()) {
            String item = items.getKey();
            fpList.put(item, new ConcurrentHashMap<>());
        }

        Map<List<String>, Integer> frequentPaths = new HashMap<>();
        for (List<String> item : stringPaths) {
            if (frequentPaths.containsKey(item)) {
                frequentPaths.put(item, frequentPaths.get(item) + 1);
            } else {
                frequentPaths.put(item, 1);
            }
        }
        frequentPaths.values().removeIf(value -> value < minSuppThreshold);

        for (Map.Entry<List<String>, Integer> path : frequentPaths.entrySet()) {
            List<String> itemset = path.getKey();
            for(String item : itemset){
                if(fpList.containsKey(item)){
                    if(fpList.get(item).containsKey(itemset)){
                        fpList.get(item).put(itemset, path.getValue() + 1);
                    } else {
                        fpList.get(item).put(itemset, path.getValue());
                    }

                }
            }
        }
        fpList.entrySet().removeIf(entry -> entry.getValue().size() == 0);
    }
}




