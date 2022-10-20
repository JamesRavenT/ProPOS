package com.wabizabi.wazabipos.Utilities.Algorithm;

import static com.wabizabi.wazabipos.Utilities.Global.Variables.fqItems;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FQList {

    public static Integer calculateMinSupp(List<List<String>> transactionsTB, Map<String, Integer> fqItems){
        for (List<String> transaction : transactionsTB) {
            for (String item : transaction) {
                if (fqItems.containsKey(item)) {
                    fqItems.put(String.valueOf(item), fqItems.get(item) + 1);
                } else {
                    fqItems.put(String.valueOf(item), 1);
                }
            }
        }
        int confidence = transactionsTB.size();
        double minimumSupport = 0.5;
        double minimumSupportThreshold = minimumSupport * confidence / fqItems.size();
        return (int) minimumSupportThreshold;
    }

    public static void create( int minSuppThreshold, Map<String, Integer> fqItems, Map<String, Integer> fqList) {
        fqItems.values().removeIf(value -> value < minSuppThreshold);
        fqList.putAll(fqItems);
        List<Map.Entry<String, Integer>> fqListEntry = new ArrayList<>(fqList.entrySet());
        fqListEntry.sort((highestVal, lowestVal) -> lowestVal.getValue().compareTo(highestVal.getValue()));
        fqList.clear();
        for (Map.Entry<String, Integer> map : fqListEntry) {
            fqList.put(map.getKey(), map.getValue());
        }
    }
}
