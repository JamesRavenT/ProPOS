package com.wabizabi.wazabipos.Database.RealmSchemas;

import org.bson.types.ObjectId;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RealmStockCategory extends RealmObject {
    @PrimaryKey
    ObjectId _id;
    int categoryIcon;
    String categoryName;
    String lastUpdatedID;
    String lastUpdatedText;

    public RealmStockCategory(){}

    public ObjectId get_id() { return _id; }
    public int getCategoryIcon() { return categoryIcon; }
    public String getCategoryName() { return categoryName; }
    public String getLastUpdatedID() { return lastUpdatedID; }
    public String getLastUpdatedText() { return lastUpdatedText; }

    public void set_id(ObjectId _id) { this._id = _id; }
    public void setCategoryIcon(int categoryIcon) { this.categoryIcon = categoryIcon; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    public void setLastUpdatedID(String lastUpdatedID) { this.lastUpdatedID = lastUpdatedID; }
    public void setLastUpdatedText(String lastUpdatedText) { this.lastUpdatedText = lastUpdatedText; }
}
