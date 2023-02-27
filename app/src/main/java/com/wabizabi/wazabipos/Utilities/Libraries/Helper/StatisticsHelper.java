package com.wabizabi.wazabipos.Utilities.Libraries.Helper;

import static com.wabizabi.wazabipos.Utilities.BackgroundThreads.W01_Algorithm.fpList;
import static com.wabizabi.wazabipos.Utilities.BackgroundThreads.W01_Algorithm.fqList;

import com.wabizabi.wazabipos.Database.ObjectSchemas.PopCombination;
import com.wabizabi.wazabipos.Database.ObjectSchemas.PopItem;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmPopCombination;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmPopItem;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

public class StatisticsHelper {

    public static List<PopItem> getCurrentMonthPopItems(){
        List<PopItem> listOfPopItems = new ArrayList<>();
        List<Map.Entry<String, Integer>> item = new ArrayList<>(fqList.entrySet());
        int counter = (item.size() < 5)
                ? item.size() - 1
                : 4;
        for(int i = 0 ; i < counter ; i++){
            Map.Entry<String, Integer> a = item.get(i);
            String b = a.getKey();
            int c = a.getValue();
            if(b != null){
                listOfPopItems.add(new PopItem(b, c));
            }
        }
        return listOfPopItems;
    }

    public static List<PopItem> getMonthlyPopItems(Realm realm, String year, String month){
        List<PopItem> listOfPopItems = new ArrayList<>();
        RealmResults<RealmPopItem> queriedPopItems = realm.where(RealmPopItem.class)
                .equalTo("year", year)
                .and()
                .equalTo("month", month)
                .sort("frequency", Sort.DESCENDING)
                .findAll();
        int counter = (queriedPopItems.size() < 5)
                ? queriedPopItems.size() - 1
                : 4;
        for(int i = 0 ; i < counter ; i++){
            RealmPopItem query = queriedPopItems.get(i);
            if(query != null) {
                listOfPopItems.add(new PopItem(query.getName(), query.getFrequency()));
            }
        }
        return listOfPopItems;
    }

    public static List<PopItem> getYearlyPopItems(Realm realm, String year){
        List<PopItem> listOfPopItems = new ArrayList<>();
        RealmResults<RealmPopItem> queriedPopItems = realm.where(RealmPopItem.class)
                .equalTo("year", year)
                .sort("frequency", Sort.DESCENDING)
                .findAll();
        int counter = (queriedPopItems.size() < 5)
                ? queriedPopItems.size() - 1
                : 5;
        for(int i = 0 ; i < counter ; i++){
            RealmPopItem query = queriedPopItems.get(i);
            if(query != null) {
                listOfPopItems.add(new PopItem(query.getName(), query.getFrequency()));
            }
        }
        return listOfPopItems;
    }

    //POP COMBOS
    public static List<PopCombination> getCurrentMonthPopCombos(){
        List<PopCombination> listOfPopCombos = new ArrayList<>();
        Map<List<String>, Integer> fpItemSet = new LinkedHashMap<>();
        for(Map.Entry<String, Map<List<String>, Integer>> itemSets : fpList.entrySet()){
            for(Map.Entry<List<String>, Integer> itemSet : itemSets.getValue().entrySet()){
                fpItemSet.put(itemSet.getKey(), itemSet.getValue());
            }
        }
        List<Map.Entry<List<String>, Integer>> setSorter = new ArrayList<>(fpItemSet.entrySet());
        setSorter.sort((highestVal, lowestVal) -> lowestVal.getValue().compareTo(highestVal.getValue()));
        int counter = (setSorter.size() < 5)
                    ? setSorter.size() - 1
                    : 5;
        for(int i = 0 ; i < counter ; i++){
            Map.Entry<List<String>, Integer> a = setSorter.get(i);
            List<String> b = a.getKey();
            int c = a.getValue();
            LogHelper.debug(a.getValue().toString());
            listOfPopCombos.add(new PopCombination(b, c));
        }
        return listOfPopCombos;
    }

    public static List<PopCombination> getMonthlyPopCombos(Realm realm, String year, String month){
        List<PopCombination> listOfPopCombos = new ArrayList<>();
        RealmResults<RealmPopCombination> queriedPopCombos = realm.where(RealmPopCombination.class)
                .equalTo("year", year)
                .and()
                .equalTo("month", month)
                .sort("frequency", Sort.DESCENDING)
                .findAll();
        int counter = (queriedPopCombos.size() < 5)
                ? queriedPopCombos.size() - 1
                : 5;
        for(int i = 0 ; i < counter ; i++){
            RealmPopCombination query = queriedPopCombos.get(i);
            List<String> itemSet = new ArrayList<>();
            for(String item : query.getItemSet()){
                itemSet.add(item);
            }
            listOfPopCombos.add(new PopCombination(itemSet, query.getFrequency()));
        }
        return listOfPopCombos;
    }

    public static List<PopCombination> getYearlyPopCombos(Realm realm, String year){
        List<PopCombination> listOfPopCombos = new ArrayList<>();
        RealmResults<RealmPopCombination> queriedPopCombos = realm.where(RealmPopCombination.class)
                .equalTo("year", year)
                .sort("frequency", Sort.DESCENDING)
                .findAll();
        int counter = (queriedPopCombos.size() < 5)
                ? queriedPopCombos.size() - 1
                : 4;
        for(int i = 0 ; i < counter ; i++){
            RealmPopCombination query = queriedPopCombos.get(i);
            List<String> itemSet = new ArrayList<>();
            for(String item : query.getItemSet()){
                itemSet.add(item);
            }
            listOfPopCombos.add(new PopCombination(itemSet, query.getFrequency()));
        }
        return listOfPopCombos;
    }
}
