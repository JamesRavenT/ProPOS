package com.wabizabi.wazabipos.Database.RealmSchemas;

import org.bson.types.ObjectId;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RealmOrderDiscount extends RealmObject {
    @PrimaryKey
    ObjectId _id;
    String discountName;
    int discountPercentage;

    public RealmOrderDiscount(){}
    public RealmOrderDiscount(String discountName, int discountAmount){
        this.discountName = discountName;
        this.discountPercentage = discountAmount;
    }

    public String getDiscountName() { return discountName; }
    public int getDiscountPercentage() { return discountPercentage; }

    public void setDiscountName(String discountName) { this.discountName = discountName; }
    public void setDiscountPercentage(int discountPercentage) { this.discountPercentage = discountPercentage; }
}
