package com.wabizabi.wazabipos.Utilities.Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FQList {
    /** STEP 1.2 : CREATE THE F-LIST
     * F-List will be created using the 2D list and a Map<String, Integer>.
     * Initialize the map as a TreeMap.
     * For each item in each List of String inside the 2D list, check if the item is in the map.
     * If item is already an entry in the map, +1 for the support of the item.
     * Else, create new entry.
     * **/
    public static void create(List<List<String>> transactionsTB,
                              Map<String, Integer> fqItems){
        for (List<String> transaction : transactionsTB) {
            for (String item : transaction) {
                if (fqItems.containsKey(item)) {
                    fqItems.put(String.valueOf(item), fqItems.get(item) + 1);
                } else {
                    fqItems.put(String.valueOf(item), 1);
                }
            }
        }
    }

    //-- F-LIST SAMPLE --//
    // Item     |   Frequency
    // Item A           4
    // Item B           5
    // Item C           2
    // Item D           4
    // Item E           1

    /** STEP 1.3 : CALCULATE THE MINIMUM SUPPORT THRESHOLD
     * Get the MST with formula of.. 0.25 * listOfTransactions.size() / f-list.size()
     * **/
    public static Integer calculateMinSupp(List<List<String>> transactionsTB,
                                           Map<String, Integer> fqItems){
        //-- GET THE MINIMUM SUPPORT THRESHOLD --//
        int confidence = transactionsTB.size();
        double minimumSupport = 0.25;
        double minimumSupportThreshold = minimumSupport * confidence / fqItems.size();
        return (int) minimumSupportThreshold;
    }
    /** STEP 1.4 : SORT AND FILTER THE F-LIST
     * Remove the entries in the TreeMap who'se values is below the MST
     * Copy the contents of the TreeMap to a LinkedHashMap to sort the list
     * Sort the entries in the LinkedHashMap from the Highest to Lowest Value in descending order
     * **/
    public static void filter(int minSuppThreshold,
                              Map<String, Integer> fqItems,
                              Map<String, Integer> fqList) {
        //-- FILTER THE F-LIST --//
        fqItems.values().removeIf(value -> value < minSuppThreshold);
        //-- SORT THE F-LIST --//
        fqList.putAll(fqItems);
        List<Map.Entry<String, Integer>> fqListEntry = new ArrayList<>(fqList.entrySet());
        fqListEntry.sort((highestVal, lowestVal) -> lowestVal.getValue().compareTo(highestVal.getValue()));
        fqList.clear();
        for (Map.Entry<String, Integer> map : fqListEntry) {
            fqList.put(map.getKey(), map.getValue());
        }
    }

    //-- F-LIST SAMPLE --//
    // Let MST = 3
    // Item     |   Frequency
    // Item B           5
    // Item A           4
    // Item D           4

}
