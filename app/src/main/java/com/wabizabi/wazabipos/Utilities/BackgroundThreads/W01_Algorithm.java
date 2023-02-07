package com.wabizabi.wazabipos.Utilities.BackgroundThreads;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.wabizabi.wazabipos.Database.RealmSchemas.RealmSalesTransaction;
import com.wabizabi.wazabipos.Utilities.Libraries.Algorithm.FQList;
import com.wabizabi.wazabipos.Utilities.Libraries.Algorithm.Tree;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import io.realm.Realm;
import io.realm.RealmResults;

public class W01_Algorithm extends Worker {
    public static Map<String, Integer> unfilteredfqList = new TreeMap<>();
    public static Map<String, Integer> fqList = new LinkedHashMap<>();
    public static Map<String, Map<List<String>, Integer>> fpList = new ConcurrentHashMap<>();
    static int minSuppThreshold;
    public W01_Algorithm(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmResults<RealmSalesTransaction> queriedTransactions = realm.where(RealmSalesTransaction.class).findAll();
        if (!queriedTransactions.isEmpty()) {
            List<List<String>> listOfTransactions = new ArrayList<>();
            for(RealmSalesTransaction sales : queriedTransactions) {
                List<String> transaction = new ArrayList<>(sales.getItemWebName());
                listOfTransactions.add(transaction);
            }
            FQList.create(listOfTransactions, unfilteredfqList);
            minSuppThreshold = FQList.calculateMinSupp(listOfTransactions, unfilteredfqList);
            FQList.filterandsort(minSuppThreshold, unfilteredfqList, fqList);
            Tree fpTree = Tree.create(listOfTransactions, fqList);
            Tree.mineToFindFrequentPatterns(fpTree, minSuppThreshold, fqList, fpList);
        }
        realm.commitTransaction();
        return Result.success();
    }
}

