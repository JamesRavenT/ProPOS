package com.wabizabi.wazabipos.Utilities.Libraries.Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FQList {

    public static void create(List<List<String>> listOfTransactions,
                              Map<String, Integer> fqItemsets){
        fqItemsets.clear();
        for (List<String> transaction : listOfTransactions) {
            for (String item : transaction) {
                if (fqItemsets.containsKey(item)) {
                    fqItemsets.put(String.valueOf(item), fqItemsets.get(item) + 1);
                } else {
                    fqItemsets.put(String.valueOf(item), 1);
                }
            }
        }
    }

    //TRANSATION 1 : [ITEM D, ITEM C]
    //TRANSACTION 2 : [ITEM D, ITEM A]

    // FQ LIST | VALUE
    // ITEM A      2
    // ITEM B      4
    // ITEM C      3
    // ITEM D      5


    public static Integer calculateMinSupp(List<List<String>> listOfTransactions,
                                           Map<String, Integer> fqItemsets){
        int confidence = listOfTransactions.size();
        double minimumSupport = 0.25;
        double minimumSupportThreshold = minimumSupport * confidence / fqItemsets.size();
        return (int) minimumSupportThreshold;
    }

    public static void filterandsort(int minSuppThreshold,
                                     Map<String, Integer> fqItemsets,
                                     Map<String, Integer> fqList) {
        fqItemsets.values().removeIf(value -> value < minSuppThreshold);
        List<Map.Entry<String, Integer>> fqListEntry = new ArrayList<>(fqItemsets.entrySet());
        fqListEntry.sort((highestVal, lowestVal) -> lowestVal.getValue().compareTo(highestVal.getValue()));
        fqList.clear();
        for (Map.Entry<String, Integer> map : fqListEntry) {
            fqList.put(map.getKey(), map.getValue());
        }
    }

    //Minimum Support Threshold is : 3

    // FQ LIST | VALUE
    // ITEM B      4
    // ITEM C      3
    // ITEM D      5

    // FQ LIST | VALUE
    // ITEM D  :   5
    // ITEM B  :   4
    // ITEM C  :   3

}
