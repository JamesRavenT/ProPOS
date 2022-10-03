package com.wabizabi.wazabipos.Database.Schemas;

import org.bson.types.ObjectId;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ProductsList extends RealmObject {
    @PrimaryKey
    ObjectId _id;
    String CategoryName;

    public ProductsList(){}
    public ProductsList(ObjectId _id, String categoryName) {
        this._id = _id;
        CategoryName = categoryName;
    }

    public String getCategoryName() { return CategoryName; }
    public void setCategoryName(String categoryName) { CategoryName = categoryName; }
}
