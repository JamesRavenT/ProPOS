package com.wabizabi.wazabipos.Database.Instances;

import com.wabizabi.wazabipos.Database.RealmSchemas.RealmTable;

import org.bson.types.ObjectId;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.realm.Realm;
import io.realm.RealmResults;

public class OpenTableInstance {

    public static void toCreateTable(String name){
        String logID = new SimpleDateFormat("yyMMddHH-mmss").format(new Date());
        String logTxt = new SimpleDateFormat("MMMM dd, yyyy | HH:mm a").format(new Date());
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmTable table = db.createObject(RealmTable.class, new ObjectId());
                table.setTableName(name);
                table.setTableNo(1);
                table.setTableStatus("Free");
                table.setLastUpdatedID(logID);
                table.setLastUpdatedText(logTxt);
            });
        }
    }

    public static void toAddTableCount(String name){
        String logID = new SimpleDateFormat("yyMMddHH-mmss").format(new Date());
        String logTxt = new SimpleDateFormat("MMMM dd, yyyy | HH:mm a").format(new Date());
        try(Realm realm = Realm.getDefaultInstance()){
            RealmResults<RealmTable> listOfTables = realm.where(RealmTable.class).equalTo("tableName", name).sort("tableNo").findAll();
            int number = listOfTables.size() + 1;
            realm.executeTransaction(db -> {
                RealmTable table = db.createObject(RealmTable.class, new ObjectId());
                table.setTableName(name);
                table.setTableNo(number);
                table.setTableStatus("Free");
                table.setLastUpdatedID(logID);
                table.setLastUpdatedText(logTxt);
            });
        }
    }

    public static void toSubTableCount(String name){
        try(Realm realm = Realm.getDefaultInstance()){
            String logID = new SimpleDateFormat("yyMMddHH-mmss").format(new Date());
            String logTxt = new SimpleDateFormat("MMMM dd, yyyy | HH:mm a").format(new Date());
            RealmResults<RealmTable> listOfTables = realm.where(RealmTable.class).equalTo("tableName", name).sort("tableNo").findAll();
            int number = listOfTables.size();
            realm.executeTransaction(db -> {
                RealmTable table = db.where(RealmTable.class).equalTo("tableName", name).and().equalTo("tableNo", number).findFirst();
                table.deleteFromRealm();
                RealmResults<RealmTable> updatedListOfTables = realm.where(RealmTable.class).equalTo("tableName", name).sort("tableNo").findAll();
                for(RealmTable updatedTable : updatedListOfTables){
                    updatedTable.setLastUpdatedID(logID);
                    updatedTable.setLastUpdatedText(logTxt);
                }
            });
        }
    }

    public static void toSetTableStatusToOccupied(String name, int number){
        String logID = new SimpleDateFormat("yyMMddHH-mmss").format(new Date());
        String logTxt = new SimpleDateFormat("MMMM dd, yyyy | HH:mm a").format(new Date());
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmTable table = db.where(RealmTable.class).equalTo("tableName", name).and().equalTo("tableNo", number).findFirst();
                table.setTableStatus("Occupied");
                table.setLastUpdatedID(logID);
                table.setLastUpdatedText(logTxt);
            });
        }
    }

    public static void toSetTableStatusToFree(String name, int number){
        String logID = new SimpleDateFormat("yyMMddHH-mmss").format(new Date());
        String logTxt = new SimpleDateFormat("MMMM dd, yyyy | HH:mm a").format(new Date());
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmTable table = db.where(RealmTable.class).equalTo("tableName", name).and().equalTo("tableNo", number).findFirst();
                table.setTableStatus("Free");
                table.setLastUpdatedID(logID);
                table.setLastUpdatedText(logTxt);
            });
        }
    }

    public static void toEditTable(String oldName, String name){
        String logID = new SimpleDateFormat("yyMMddHH-mmss").format(new Date());
        String logTxt = new SimpleDateFormat("MMMM dd, yyyy | HH:mm a").format(new Date());
        try(Realm realm = Realm.getDefaultInstance()) {
            RealmResults<RealmTable> listOfTables = realm.where(RealmTable.class).equalTo("tableName", oldName).findAll();
            realm.executeTransaction(db -> {
                for (RealmTable table : listOfTables) {
                    table.setTableName(name);
                    table.setLastUpdatedID(logID);
                    table.setLastUpdatedText(logTxt);
                }
            });
        }
    }

    public static void toDeleteTable(String name){
        try(Realm realm = Realm.getDefaultInstance()){
            RealmResults<RealmTable> listOfTables = realm.where(RealmTable.class).equalTo("tableName", name).findAll();
            realm.executeTransaction(db -> {
                for(RealmTable table : listOfTables){
                    table.deleteFromRealm();
                }
            });
        }
    }

}
