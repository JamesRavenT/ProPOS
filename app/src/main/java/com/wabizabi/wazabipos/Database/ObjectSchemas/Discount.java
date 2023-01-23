package com.wabizabi.wazabipos.Database.ObjectSchemas;

public class Discount {
    String discountName;
    int discountInPercentage;
    int discountApplication;

    public Discount(){}
    public Discount(String discountName, int discountInPercentage){
        this.discountName = discountName;
        this.discountInPercentage = discountInPercentage;
    }

    public String getDiscountName() { return discountName; }
    public int getDiscountInPercentage() { return discountInPercentage; }
    public int getDiscountApplication() { return discountApplication; }

    public void setDiscountName(String discountName) { this.discountName = discountName; }
    public void setDiscountInPercentage(int discountInPercentage) { this.discountInPercentage = discountInPercentage; }

    public void setDiscountApplication(int discountApplication) { this.discountApplication = discountApplication; }
}
