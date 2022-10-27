package com.wabizabi.wazabipos.Utilities.Testing;


import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public abstract class Template implements DataSet {
    public static void insertInto(List<List<String>> transactionsTB){

        for (List<String> transaction : transactionsTB) {
            Set<String> filteredTransactions = new LinkedHashSet<>(transaction);
            transaction.clear();
            transaction.addAll(filteredTransactions);
        }

    }
}
