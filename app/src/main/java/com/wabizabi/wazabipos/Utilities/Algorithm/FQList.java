package com.wabizabi.wazabipos.Utilities.Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FQList {

    public static void create(List<List<String>> transactionsTB, int minSuppThreshold, Map<String, Integer> fqItems, Map<String, Integer> fqList) {
        for (List<String> transaction : transactionsTB) {
            for (String item : transaction) {
                if (fqItems.containsKey(item)) {
                    fqItems.put(String.valueOf(item), fqItems.get(item) + 1);
                } else {
                    fqItems.put(String.valueOf(item), 1);
                }
            }
        }
        fqItems.values().removeIf(value -> value < minSuppThreshold);
//        fqItems.entrySet().removeIf(entry -> entry.getValue() == 0);
        fqList.putAll(fqItems);
        List<Map.Entry<String, Integer>> fqListEntry = new ArrayList<>(fqList.entrySet());
        fqListEntry.sort((highestVal, lowestVal) -> lowestVal.getValue().compareTo(highestVal.getValue()));
        fqList.clear();
        for (Map.Entry<String, Integer> map : fqListEntry) {
            fqList.put(map.getKey(), map.getValue());
        }

    }
}
