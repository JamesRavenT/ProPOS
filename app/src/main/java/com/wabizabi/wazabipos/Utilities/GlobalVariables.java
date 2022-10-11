package com.wabizabi.wazabipos.Utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class GlobalVariables {

    //ALGORITHM
    public static List<List<String>> filteredTransactions = new ArrayList<>();
    public static Map<String, Integer> fqItems = new TreeMap<>();
    public static Map<String, Integer> fqList = new LinkedHashMap<>();
    public static Map<String, Map<List<String>, Integer>> fpList = new ConcurrentHashMap<>();

    //PRODUCTS
    public static int currentIndex;

}
