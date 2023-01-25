package com.wabizabi.wazabipos.Database.RealmSchemas;

import org.bson.types.ObjectId;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RealmPaymentMethod extends RealmObject {
    @PrimaryKey
    ObjectId _id;
    String methodName;
    String lastUpdatedID;
    String lastUpdatedText;

    public RealmPaymentMethod(){}

    public String getMethodName() { return methodName; }
    public String getLastUpdatedID() { return lastUpdatedID; }
    public String getLastUpdatedText() { return lastUpdatedText; }

    public void setMethodName(String methodName) { this.methodName = methodName; }
    public void setLastUpdatedID(String lastUpdatedID) { this.lastUpdatedID = lastUpdatedID; }
    public void setLastUpdatedText(String lastUpdatedText) { this.lastUpdatedText = lastUpdatedText; }
}
