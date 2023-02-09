package com.wabizabi.wazabipos.Utilities.Libraries.Helper;

import com.wabizabi.wazabipos.Database.ObjectSchemas.PopCombination;
import com.wabizabi.wazabipos.Database.ObjectSchemas.PopItem;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmPopCombination;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmPopItem;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

public class StatisticsHelper {

    public static List<PopItem> getMonthlyPopItems(Realm realm, String year, String month){
        List<PopItem> listOfPopItems = new ArrayList<>();
        RealmResults<RealmPopItem> queriedPopItems = realm.where(RealmPopItem.class)
                .equalTo("year", year)
                .and()
                .equalTo("month", month)
                .sort("frequency", Sort.DESCENDING)
                .findAll();
        for(int i = 0 ; i < 4 ; i++){
            RealmPopItem query = queriedPopItems.get(i);
            listOfPopItems.add(new PopItem(query.getName(), query.getFrequency()));
        }
        return listOfPopItems;
    }

    public static List<PopItem> getYearlyPopItems(Realm realm, String year){
        List<PopItem> listOfPopItems = new ArrayList<>();
        RealmResults<RealmPopItem> queriedPopItems = realm.where(RealmPopItem.class)
                .equalTo("year", year)
                .sort("frequency", Sort.DESCENDING)
                .findAll();
        for(int i = 0 ; i < 4 ; i++){
            RealmPopItem query = queriedPopItems.get(i);
            listOfPopItems.add(new PopItem(query.getName(), query.getFrequency()));
        }
        return listOfPopItems;
    }

    public static List<PopCombination> getMonthlyPopCombos(Realm realm, String year, String month){
        List<PopCombination> listOfPopCombos = new ArrayList<>();
        RealmResults<RealmPopCombination> queriedPopCombos = realm.where(RealmPopCombination.class)
                .equalTo("year", year)
                .and()
                .equalTo("month", month)
                .sort("frequency", Sort.DESCENDING)
                .findAll();
        for(int i = 0 ; i < 4 ; i++){
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
        for(int i = 0 ; i < 4 ; i++){
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
