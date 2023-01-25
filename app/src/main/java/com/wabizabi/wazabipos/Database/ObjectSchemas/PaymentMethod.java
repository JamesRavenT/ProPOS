package com.wabizabi.wazabipos.Database.ObjectSchemas;

public class PaymentMethod {

    String methodName;
    String lastUpdatedID;
    String lastUpdatedText;

    public PaymentMethod(String methodName, String lastUpdatedID, String lastUpdatedText) {
        this.methodName = methodName;
        this.lastUpdatedID = lastUpdatedID;
        this.lastUpdatedText = lastUpdatedText;
    }

    public String getMethodName() { return methodName; }
    public String getLastUpdatedID() { return lastUpdatedID; }
    public String getLastUpdatedText() { return lastUpdatedText; }

    public void setMethodName(String methodName) { this.methodName = methodName; }
    public void setLastUpdatedID(String lastUpdatedID) { this.lastUpdatedID = lastUpdatedID; }
    public void setLastUpdatedText(String lastUpdatedText) { this.lastUpdatedText = lastUpdatedText; }
}
