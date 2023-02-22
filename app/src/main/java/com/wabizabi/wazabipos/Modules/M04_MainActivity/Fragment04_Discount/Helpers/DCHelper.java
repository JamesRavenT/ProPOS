package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_Discount.Helpers;

import com.wabizabi.wazabipos.Database.ObjectSchemas.Discount;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmDiscount;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class DCHelper {

    //DISCOUNTS | RV
    public static List<Discount> getDiscounts(Realm realm){
        List<Discount> listOfDiscounts = new ArrayList<>();
        RealmResults<RealmDiscount> queriedDiscounts = realm.where(RealmDiscount.class).sort("discountName").findAll();
        for(RealmDiscount query : queriedDiscounts){
            listOfDiscounts.add(new Discount(query.getDiscountName(), query.getDiscountPercentage(), query.getLastUpdatedID(), query.getLastUpdatedText()));
        }
        return listOfDiscounts;
    }

    //DISCOUNTS | RV FILTERED
    public static List<Discount> getFilteredDiscounts(List<Discount> listOfDiscounts, String input){
        List<Discount> filteredDiscounts = new ArrayList<>();
        for(Discount discount : listOfDiscounts){
            if(discount.getDiscountName().toLowerCase().contains(input.toLowerCase())){
                filteredDiscounts.add(discount);
            }
        }
        return filteredDiscounts;
    }

    //DISCOUNTS | EDITTEXT
    public static List<String> getDiscountNames(Realm realm){
        List<String> listOfDiscounts = new ArrayList<>();
        RealmResults<RealmDiscount> queriedDiscounts = realm.where(RealmDiscount.class).findAll();
        for(RealmDiscount query : queriedDiscounts){
            listOfDiscounts.add(query.getDiscountName());
        }
        return listOfDiscounts;
    }
}
