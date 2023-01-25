package com.wabizabi.wazabipos.Database.RealmSchemas;

import org.bson.types.ObjectId;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RealmDiscount extends RealmObject {
    @PrimaryKey
    ObjectId _id;
    String discountName;
    int discountPercentage;
    String lastUpdatedID;
    String lastUpdatedText;

    public RealmDiscount(){}

    public String getDiscountName() { return discountName; }
    public int getDiscountPercentage() { return discountPercentage; }
    public String getLastUpdatedID() { return lastUpdatedID; }
    public String getLastUpdatedText() { return lastUpdatedText; }

    public void setDiscountName(String discountName) { this.discountName = discountName; }
    public void setDiscountPercentage(int discountPercentage) { this.discountPercentage = discountPercentage; }
    public void setLastUpdatedID(String lastUpdatedID) { this.lastUpdatedID = lastUpdatedID; }
    public void setLastUpdatedText(String lastUpdatedText) { this.lastUpdatedText = lastUpdatedText; }
}
