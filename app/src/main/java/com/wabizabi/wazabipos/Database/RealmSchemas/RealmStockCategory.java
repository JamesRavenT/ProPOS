package com.wabizabi.wazabipos.Database.RealmSchemas;

import org.bson.types.ObjectId;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RealmStockCategory extends RealmObject {
    @PrimaryKey
    ObjectId _id;
    int categoryImage;
    String categoryName;
    String lastUpdatedID;
    String lastUpdatedText;

    public RealmStockCategory(){}

    public int getCategoryImage() { return categoryImage; }
    public String getCategoryName() { return categoryName; }
    public String getLastUpdatedID() { return lastUpdatedID; }
    public String getLastUpdatedText() { return lastUpdatedText; }

    public void setCategoryImage(int categoryImage) { this.categoryImage = categoryImage; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    public void setLastUpdatedID(String lastUpdatedID) { this.lastUpdatedID = lastUpdatedID; }
    public void setLastUpdatedText(String lastUpdatedText) { this.lastUpdatedText = lastUpdatedText; }
}
