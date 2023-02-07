package com.wabizabi.wazabipos.Database.ObjectSchemas;

import org.bson.types.ObjectId;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class StockCategory {

    int categoryImage;
    String categoryName;
    String lastUpdatedID;
    String lastUpdatedText;

    public StockCategory(){}

    public StockCategory(int categoryImage, String categoryName) {
        this.categoryImage = categoryImage;
        this.categoryName = categoryName;
    }

    public StockCategory(int categoryImage, String categoryName, String lastUpdatedID, String lastUpdatedText) {
        this.categoryImage = categoryImage;
        this.categoryName = categoryName;
        this.lastUpdatedID = lastUpdatedID;
        this.lastUpdatedText = lastUpdatedText;
    }

    public int getCategoryImage() { return categoryImage; }
    public String getCategoryName() { return categoryName; }
    public String getLastUpdatedID() { return lastUpdatedID; }
    public String getLastUpdatedText() { return lastUpdatedText; }

    public void setCategoryImage(int categoryImage) { this.categoryImage = categoryImage; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    public void setLastUpdatedID(String lastUpdatedID) { this.lastUpdatedID = lastUpdatedID; }
    public void setLastUpdatedText(String lastUpdatedText) { this.lastUpdatedText = lastUpdatedText; }
}
