package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment05_PaymentMethods.Helpers;

import com.wabizabi.wazabipos.Database.ObjectSchemas.PaymentMethod;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmPaymentMethod;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class PMHelper {

    //PAYMENT METHODS | RV
    public static List<PaymentMethod> getPaymentMethods(Realm realm){
        List<PaymentMethod>listOfMethods = new ArrayList<>();
        RealmResults<RealmPaymentMethod> queriedMethods = realm.where(RealmPaymentMethod.class).sort("methodName").findAll();
        for(RealmPaymentMethod query : queriedMethods){
            listOfMethods.add(new PaymentMethod(query.getMethodName(), query.getLastUpdatedID(), query.getLastUpdatedText()));
        }
        return listOfMethods;
    }

    //PAYMENT METHODS | RV FILTERED
    public static List<PaymentMethod> getFilteredPaymentMethods(List<PaymentMethod> listOfMethods, String input){
        List<PaymentMethod> filteredMethods = new ArrayList<>();
        for(PaymentMethod method : listOfMethods){
            if(method.getMethodName().toLowerCase().contains(input.toLowerCase())){
                filteredMethods.add(new PaymentMethod(method.getMethodName(), method.getLastUpdatedID(), method.getLastUpdatedText()));
            }
        }
        return filteredMethods;
    }


    //PAYMENT METHODS | EDITTEXT
    public static List<String> getMethodNames(Realm realm){
        List<String> listOfMethods = new ArrayList<>();
        RealmResults<RealmPaymentMethod> queriedMethods = realm.where(RealmPaymentMethod.class).findAll();
        for(RealmPaymentMethod query : queriedMethods){
            listOfMethods.add(query.getMethodName());
        }
        return listOfMethods;
    }
}
