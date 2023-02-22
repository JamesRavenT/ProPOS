package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Tables.Helpers;

import com.wabizabi.wazabipos.Database.RealmSchemas.RealmTable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmResults;

public class TBHelper {

    //TABLE ITEMS | RV
    public static List<String> getTables(Realm realm){
        Map<String, Integer> listOfAllTables = new LinkedHashMap<>();
        RealmResults<RealmTable> queriedTables = realm.where(RealmTable.class).sort("tableName").findAll();
        for(RealmTable query : queriedTables){
            if(listOfAllTables.containsKey(query.getTableName())){
                listOfAllTables.put(query.getTableName(), listOfAllTables.get(query.getTableName()) + 1);
            } else {
                listOfAllTables.put(query.getTableName(), 1);
            }
        }
        List<String> listOfTables = new ArrayList<>(listOfAllTables.keySet());
        return listOfTables;
    }

    //TABLE ITEMS | RV FILTERED
    public static List<String> getFilteredTables(List<String> listOfTables, String input){
        List<String> filteredTables = new ArrayList<>();
        for(String table : listOfTables){
            if(table.toLowerCase().contains(input.toLowerCase())){
                filteredTables.add(table);
            }
        }
        return filteredTables;
    }

    //TABLE | EDITTEXT
    public static List<String> getTableNames(Realm realm) {
        List<String> listOfTables = new ArrayList<>();
        RealmResults<RealmTable> queriedTables = realm.where(RealmTable.class).findAll();
        for(RealmTable query : queriedTables){
            listOfTables.add(query.getTableName());
        }
        return listOfTables;
    }
}
