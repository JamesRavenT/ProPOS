package com.wabizabi.wazabipos.Utilities.BackgroundThreads;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.wabizabi.wazabipos.Utilities.Algorithm.FQList;
import com.wabizabi.wazabipos.Utilities.Algorithm.Tree;
import com.wabizabi.wazabipos.Database.Schemas.SalesTransaction;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import io.realm.Realm;
import io.realm.RealmResults;

public class W01_Algorithm extends Worker {
    public static Map<String, Integer> fqListItemsets = new TreeMap<>();
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

        //--
        // STEP 1 : CREATION OF THE F-LIST
        //--

        /** STEP 1.1 : SCAN THE DATABASE
         * Query the transactions from the database using the code below.
         * If the result is not empty, proceed with the algorithm.
         * Create a 2D list to store the datasets.
         * For each transaction in the query, extract the list of items as a new list and add them to the 2D list
         * **/
        RealmResults<SalesTransaction> queriedTransactions = realm.where(SalesTransaction.class).findAll();
        if (!queriedTransactions.isEmpty()) {
            List<List<String>> listOfTransactions = new ArrayList<>();
            for(SalesTransaction sales : queriedTransactions) {
                List<String> transaction = new ArrayList<>(sales.getName());
                listOfTransactions.add(transaction);
            }

        /** STEP 1.2 : CREATE THE F-LIST **/
            FQList.create(listOfTransactions, fqListItemsets);
        /** STEP 1.3 : CALCULATE THE MINIMUM SUPPORT THRESHOLD **/
            minSuppThreshold = FQList.calculateMinSupp(listOfTransactions, fqListItemsets);
        /** STEP 1.4 : SORT AND FILTER THE F-LIST **/
            FQList.filterandsort(minSuppThreshold, fqListItemsets, fqList);

        //--
        // STEP 2 : BUILDING THE FP TREE
        //--

        /** STEP 2.1 TO 2.2 : PREPARE THE DATASET AND CREATE THE FP TREE **/
            Tree fpTree = Tree.create(listOfTransactions, fqList);


        /** STEP 3.1 TO 3.3 : MINING THE TREE AND EXTRACTING THE PATHS TO FIND FREQUENT PATTERNS**/
           Tree.mineToFindFrequentPatterns(fpTree, minSuppThreshold, fqList, fpList);
        }
        realm.commitTransaction();
        return Result.success();
    }
}

