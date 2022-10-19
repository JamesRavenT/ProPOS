package com.wabizabi.wazabipos.Database.Schemas;

import org.bson.types.ObjectId;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ProductsList extends RealmObject {
    @PrimaryKey
    ObjectId _id;
    int categoryImage;
    String categoryName;

    public ProductsList(){}

    public ProductsList(int categoryImage, String categoryName) {
        this.categoryImage = categoryImage;
        this.categoryName = categoryName;
    }

    public int getCategoryImage() { return categoryImage; }
    public String getCategoryName() { return categoryName; }

    public void setCategoryImage(int categoryImage) { this.categoryImage = categoryImage; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
}
