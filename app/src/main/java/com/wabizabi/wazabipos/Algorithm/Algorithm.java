package com.wabizabi.wazabipos.Algorithm;

import static com.wabizabi.wazabipos.Utilities.Cache.cachedTransactions;
import static com.wabizabi.wazabipos.Utilities.Cache.filteredTransactions;
import static com.wabizabi.wazabipos.Utilities.Cache.fpList;

import static com.wabizabi.wazabipos.Utilities.Cache.fqItems;
import static com.wabizabi.wazabipos.Utilities.Cache.fqList;

import android.util.Log;

import com.wabizabi.wazabipos.Algorithm.Libraries.FQList;
import com.wabizabi.wazabipos.Algorithm.Libraries.Tree;
import com.wabizabi.wazabipos.Database.DB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Algorithm {
    static int totalTranscations;
    static int minSuppThreshold;
    static int minFreqThreshold;
    static int counter;

    public static void init() {
        totalTranscations = cachedTransactions.size();
        minSuppThreshold = calculateMinSupThreshold(totalTranscations);
        minFreqThreshold = calculateMinFreqThreshold(minSuppThreshold);

        if (!cachedTransactions.isEmpty()) {
            List<List<String>> transactions = new ArrayList<>();
            for (int i = counter; i < cachedTransactions.size(); i++) {
                Set<String> filter = new LinkedHashSet<>(cachedTransactions.get(i));
                List<String> transaction = new ArrayList<>(filter);
                transactions.add(transaction);
                counter++;
            }
            FQList.create(transactions, minSuppThreshold, fqItems, fqList);
            Tree fpTree = Tree.create(transactions, filteredTransactions, fqList);
            List<List<String>> paths = Tree.mine(fpTree);
            findFrequentPatterns(paths, fqList, fpList, minFreqThreshold);

            DB.uploadFQListData(fqList);
            DB.uploadFPListData(fpList);
        }
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
