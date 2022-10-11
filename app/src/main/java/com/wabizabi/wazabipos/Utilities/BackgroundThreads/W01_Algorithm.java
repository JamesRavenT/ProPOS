package com.wabizabi.wazabipos.Utilities.BackgroundThreads;

import static com.wabizabi.wazabipos.Utilities.GlobalVariables.fpList;
import static com.wabizabi.wazabipos.Utilities.GlobalVariables.fqItems;
import static com.wabizabi.wazabipos.Utilities.GlobalVariables.fqList;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.wabizabi.wazabipos.Utilities.Algorithm.FQList;
import com.wabizabi.wazabipos.Utilities.Algorithm.Tree;
import com.wabizabi.wazabipos.Database.Schemas.TransactionsOfSales;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import io.realm.Realm;
import io.realm.RealmResults;

public class W01_Algorithm extends Worker {

    static RealmResults<TransactionsOfSales> transactionsAll;

    static int totalTranscations;
    static int minSuppThreshold;
    static int minFreqThreshold;
    static int counter;

    public W01_Algorithm(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        transactionsAll = realm.where(TransactionsOfSales.class).findAll();
        totalTranscations = transactionsAll.size();
        minSuppThreshold = calculateMinSupThreshold(totalTranscations);
        minFreqThreshold = calculateMinFreqThreshold(minSuppThreshold);
        if (!transactionsAll.isEmpty()) {
            List<List<String>> transactions = new ArrayList<>();
            for (int i = counter; i < transactionsAll.size(); i++) {
                TransactionsOfSales transact = transactionsAll.get(i);
                List<String> aaa = transact.getNameOfEachItem();
                List<String> transaction = new ArrayList<>(aaa);
                transactions.add(transaction);
                counter++;
            }
            FQList.create(transactions, minSuppThreshold, fqItems, fqList);
            Tree fpTree = Tree.create(transactions, fqList);
            List<List<String>> paths = Tree.mine(fpTree);
            findFrequentPatterns(paths, fqList, fpList, minFreqThreshold);
        }
        realm.commitTransaction();
        return Result.success();
    }
    static void findFrequentPatterns(
            List<List<String>> stringPaths,
            Map<String, Integer> fqList,
            Map<String, Map<List<String>, Integer>> fpList,
            int minFreqThreshold
    ) {
        fpList.clear();
        //Create Frequent Pattern Base
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
        frequentPaths.values().removeIf(value -> value < minFreqThreshold);
        stringPaths.clear();
        stringPaths.addAll(frequentPaths.keySet());

        for (Map.Entry<List<String>, Integer> path : frequentPaths.entrySet()) {
            int index = path.getKey().size() - 1;
            String lastItem = path.getKey().get(index);
            if (fpList.containsKey(lastItem)) {
                fpList.get(lastItem).put(path.getKey(), path.getValue());
            }
        }
        fpList.entrySet().removeIf(entry -> entry.getValue().size() == 0 );
    }

    static Integer calculateMinSupThreshold(int confidence){
        double minimumSupport = 0.5;
        double result = minimumSupport * confidence / 10;
        return (int) result;
    }
    static Integer calculateMinFreqThreshold(int minSuppThreshold){
        double minimumFrequency = minSuppThreshold * 0.50 / 10;
        return (int) minimumFrequency;
    }


}




