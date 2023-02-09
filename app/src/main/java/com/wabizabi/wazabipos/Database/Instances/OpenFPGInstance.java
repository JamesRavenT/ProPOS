package com.wabizabi.wazabipos.Database.Instances;

import com.wabizabi.wazabipos.Database.RealmSchemas.RealmPopCombination;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmPopItem;

import org.bson.types.ObjectId;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class OpenFPGInstance {

    public static void toSaveResult(Map<String, Integer> fqList, Map<String, Map<List<String>, Integer>> fpItemSets){
        int currentWeek = Integer.parseInt(new SimpleDateFormat("W").format(new Date()));
        String currentYear = new SimpleDateFormat("YYYY").format(new Date());
        String currentMonth = new SimpleDateFormat("MM").format(new Date());
        if(currentWeek == 1) {
            try(Realm realm = Realm.getDefaultInstance()){
                //DATE
                int prevMonth = (Integer.parseInt(currentMonth) == 1)
                        ? 12
                        : Integer.parseInt(currentMonth) - 1;
                String month = (String.valueOf(prevMonth).length() == 1)
                        ? "0" + prevMonth
                        : String.valueOf(prevMonth);

                //FQLIST
                RealmResults<RealmPopItem> queriedFQList = realm.where(RealmPopItem.class)
                        .equalTo("year", currentYear)
                        .and()
                        .equalTo("month", month)
                        .findAll();
                if(queriedFQList.isEmpty()){
                    for(Map.Entry<String, Integer> fqItem : fqList.entrySet()){
                        realm.executeTransaction(db -> {
                            RealmPopItem item = db.createObject(RealmPopItem.class, new ObjectId());
                            item.setName(fqItem.getKey());
                            item.setFrequency(fqItem.getValue());
                            item.setYear(currentYear);
                            item.setMonth(month);
                        });
                    }
                }

                //FPLIST
                RealmResults<RealmPopCombination> queriedFPList = realm.where(RealmPopCombination.class)
                        .equalTo("year", currentYear)
                        .and()
                        .equalTo("month", month)
                        .findAll();
                if(queriedFPList.isEmpty()){
                    for(Map.Entry<String, Map<List<String>, Integer>> fpItemSet : fpItemSets.entrySet()){
                        for(Map.Entry<List<String>, Integer> itemSet : fpItemSet.getValue().entrySet()){
                            String name = fpItemSet.getKey();
                            List<String> items = itemSet.getKey();
                            int frequency = itemSet.getValue();
                            realm.executeTransaction(db -> {
                                RealmPopCombination fpList = db.createObject(RealmPopCombination.class, new ObjectId());
                                RealmList<String> combinations = new RealmList<>(); combinations.addAll(items);
                                fpList.setItemName(name);
                                fpList.setItemSet(combinations);
                                fpList.setFrequency(frequency);
                                fpList.setYear(currentYear);
                                fpList.setMonth(month);
                            });
                        }
                    }
                }
            }
        }
    }
}
