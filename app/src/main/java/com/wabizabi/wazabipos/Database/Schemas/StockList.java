package com.wabizabi.wazabipos.Database.Schemas;

import org.bson.types.ObjectId;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class StockList extends RealmObject {
    @PrimaryKey
    ObjectId _id;
    String categoryName;

    public StockList(){}

    public StockList(ObjectId _id, String categoryName) {
        this._id = _id;
        this.categoryName = categoryName;
    }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
}
