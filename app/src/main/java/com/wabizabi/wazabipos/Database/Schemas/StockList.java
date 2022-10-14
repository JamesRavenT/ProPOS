package com.wabizabi.wazabipos.Database.Schemas;

import org.bson.types.ObjectId;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class StockList extends RealmObject {
    @PrimaryKey
    ObjectId _id;
    int categoryImage;
    String categoryName;

    public StockList(){}

    public StockList(int categoryImage, String categoryName) {
        this.categoryImage = categoryImage;
        this.categoryName = categoryName;
    }

    public ObjectId get_id() { return _id; }
    public int getCategoryImage() { return categoryImage; }
    public String getCategoryName() { return categoryName; }

    public void setCategoryImage(int categoryImage) { this.categoryImage = categoryImage; }

    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
}
