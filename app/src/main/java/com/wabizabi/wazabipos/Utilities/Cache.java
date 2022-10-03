package com.wabizabi.wazabipos.Utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {

    //ALGORITHM
    public static final List<List<String>> cachedTransactions = new Vector<>();
    public static final List<List<String>> filteredTransactions = new ArrayList<>();
    public static final Map<String, Integer> fqItems = new TreeMap<>();
    public static final Map<String, Integer> fqList = new LinkedHashMap<>();
    public static final Map<String, Map<List<String>, Integer>> fpList = new ConcurrentHashMap<>();

}
