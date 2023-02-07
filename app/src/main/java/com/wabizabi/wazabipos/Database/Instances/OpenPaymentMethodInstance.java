package com.wabizabi.wazabipos.Database.Instances;

import com.wabizabi.wazabipos.Database.RealmSchemas.RealmPaymentMethod;

import org.bson.types.ObjectId;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.realm.Realm;

public class OpenPaymentMethodInstance {

    public static void toCreateMethod(String name){
        String logID = new SimpleDateFormat("yyMMddHH-mmss").format(new Date());
        String logTxt = new SimpleDateFormat("MMMM dd, yyyy | hh:mm a").format(new Date());
        DateFormat currentDateAndTime = new SimpleDateFormat("MMMM dd, yyyy | hh:mm a");
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmPaymentMethod payment = db.createObject(RealmPaymentMethod.class, new ObjectId());
                payment.setMethodName(name);
                payment.setLastUpdatedID(logID);
                payment.setLastUpdatedText(logTxt);
            });
        }
    }

    public static void toUpdateMethod(String oldName, String name){
        String logID = new SimpleDateFormat("yyMMddHH-mmss").format(new Date());
        String logTxt = new SimpleDateFormat("MMMM dd, yyyy | hh:mm a").format(new Date());
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmPaymentMethod payment = db.where(RealmPaymentMethod.class).equalTo("methodName", oldName).findFirst();
                payment.setMethodName(name);
                payment.setLastUpdatedID(logID);
                payment.setLastUpdatedText(logTxt);
            });
        }
    }

    public static void toDeleteMethod(String name){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmPaymentMethod payment = db.where(RealmPaymentMethod.class).equalTo("methodName", name).findFirst();
                payment.deleteFromRealm();
            });
        }
    }
}
