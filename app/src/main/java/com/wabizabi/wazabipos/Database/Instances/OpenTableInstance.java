package com.wabizabi.wazabipos.Database.Instances;

import com.wabizabi.wazabipos.Database.RealmSchemas.RealmTable;

import org.bson.types.ObjectId;

import io.realm.Realm;

public class OpenTableInstance {

    public static void toCreateTable(String name, int number){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmTable table = db.createObject(RealmTable.class, new ObjectId());
                table.setTableName(name);
                table.setTableNo(number);
                table.setTableStatus("Free");
            });
        }
    }

    public static void toSetTableStatusToOccupied(String name, int number){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmTable table = realm.where(RealmTable.class).equalTo("tableName", name).and().equalTo("tableNo", number).findFirst();
                table.setTableStatus("Occupied");
            });
        }
    }

    public static void toSetTableStatusToFree(String name, int number){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmTable table = realm.where(RealmTable.class).equalTo("tableName", name).and().equalTo("tableNo", number).findFirst();
                table.setTableStatus("Free");
            });
        }
    }

//    public static void toEditTable(String number, String name){
//        try(Realm realm = Realm.getDefaultInstance()){
//            realm.executeTransaction(db -> {
//                RealmTable table = db.where(RealmTable.class).equalTo("tableName", currentTable).findFirst();
//                if(number.length() == 1){
//                    table.setTableNo("0" + number);
//                } else {
//                    table.setTableNo(number);
//                }
//                table.setTableName(name);
//
//            });
//        }
//    }

//    public static void toDeleteDiscount(String name){
//        try(Realm realm = Realm.getDefaultInstance()){
//            realm.executeTransaction(db -> {
//                RealmTable table = db.where(RealmTable.class).equalTo("tableName", currentTable).findFirst();
//                table.deleteFromRealm();
//            });
//        }
//    }
}
