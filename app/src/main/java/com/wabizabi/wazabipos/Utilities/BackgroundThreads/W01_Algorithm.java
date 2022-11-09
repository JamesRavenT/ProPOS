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
            for (SalesTransaction sales : queriedTransactions) {
                List<String> transaction = new ArrayList<>(sales.getNameOfEachItem());
                listOfTransactions.add(transaction);
            }

        /** STEP 1.2 : CREATE THE F-LIST **/
            FQList.create(listOfTransactions, fqItems);
        /** STEP 1.3 : CALCULATE THE MINIMUM SUPPORT THRESHOLD **/
            minSuppThreshold = FQList.calculateMinSupp(listOfTransactions, fqItems);
        /** STEP 1.4 : SORT AND FILTER THE F-LIST **/
            FQList.filter(minSuppThreshold, fqItems, fqList);

        //--
        // STEP 2 : BUILDING THE FP TREE
        //--

        /** STEP 2.1 TO 2.2 : PREPARE THE DATASET AND CREATE THE FP TREE **/
            Tree fpTree = Tree.create(listOfTransactions, fqList);

        //--
        // STEP 3 : GENERATION OF FREQUENT PATTERNS
        //--

        /** STEP 3.1 TO 3.2 : MINING THE TREE AND EXTRACTING THE PATHS **/
            Map<List<String>, Integer> paths = Tree.mine(fpTree, minSuppThreshold);
        /** STEP 3.3 : CREATE THE LIST OF FREQUENT PATTERNS **/
            findFrequentPatterns(paths, fqList, fpList);
        }
        realm.commitTransaction();
        return Result.success();
    }

    /** STEP 3.3 : CREATE THE LIST OF FREQUENT PATTERNS
     * Initialize a Concurrent HashMap as the List of Frequent Patterns
     * Clear the entries of the FP-List
     * Copy the entries from F-List to the FP-List
     * Create another map to calculate the frequency of each path
     * Remove the entry in the second map if the frequency doesnt match the MST
     * If a key in the FP-list exists as an item inside a path, add that path to the said key
     * Remove the keysets in the FP-list who'se value = 0
     * **/
    static void findFrequentPatterns(
            Map<List<String>, Integer> paths,
            Map<String, Integer> fqList,
            Map<String, Map<List<String>, Integer>> fpList
    ) {
        fpList.clear();
        //--Create a map base on the F-List--//
        for (Map.Entry<String, Integer> items : fqList.entrySet()) {
            String item = items.getKey();
            fpList.put(item, new ConcurrentHashMap<>());
        }

        //-- F-LIST SAMPLE --//
        // Item     |   Frequency
        // Item B           5
        // Item A           4
        // Item D           4

        //-- FP-LIST SAMPLE --//
        // Item     |         Patterns
        // Item B     <List<Items> , Support>
        // Item A     <List<Items> , Support>
        // Item D     <List<Items> , Support>


        //--Add the paths to their corresponding keysets--//
        for (Map.Entry<List<String>, Integer> path : paths.entrySet()) {
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

        //-- FP-LIST SAMPLE --//
        // Item     |         Patterns
        // Item B     [ [Item B, Item A, Item D] : 5]
        // Item A     [ [Item B, Item A, Item D] : 5 , [Item A, Item D] : 3 ]
        // Item D     [ [Item B, Item A, Item D] : 5 , [Item A, Item D] : 3 ]
    }
}




