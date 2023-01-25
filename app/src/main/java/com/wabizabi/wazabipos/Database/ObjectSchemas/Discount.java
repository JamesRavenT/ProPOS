package com.wabizabi.wazabipos.Database.ObjectSchemas;

public class Discount {
    String discountName;
    int discountInPercentage;
    String lastUpdatedID;
    String lastUpdatedText;

    public Discount(){}
    public Discount(String discountName, int discountInPercentage){
        this.discountName = discountName;
        this.discountInPercentage = discountInPercentage;
    }

    public Discount(String discountName, int discountInPercentage, String lastUpdatedID, String lastUpdatedText) {
        this.discountName = discountName;
        this.discountInPercentage = discountInPercentage;
        this.lastUpdatedID = lastUpdatedID;
        this.lastUpdatedText = lastUpdatedText;
    }

    public String getDiscountName() { return discountName; }
    public int getDiscountInPercentage() { return discountInPercentage; }
    public String getLastUpdatedID() { return lastUpdatedID; }
    public String getLastUpdatedText() { return lastUpdatedText; }

    public void setDiscountName(String discountName) { this.discountName = discountName; }
    public void setDiscountInPercentage(int discountInPercentage) { this.discountInPercentage = discountInPercentage; }
    public void setLastUpdatedID(String lastUpdatedID) { this.lastUpdatedID = lastUpdatedID; }
    public void setLastUpdatedText(String lastUpdatedText) { this.lastUpdatedText = lastUpdatedText; }
}
