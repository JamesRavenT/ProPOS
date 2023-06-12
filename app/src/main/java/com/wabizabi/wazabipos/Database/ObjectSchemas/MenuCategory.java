package com.wabizabi.wazabipos.Database.ObjectSchemas;

public class MenuCategory {
    int categoryImage;
    String categoryName;

    public MenuCategory(){}

    public MenuCategory(int categoryImage, String categoryName) {
        this.categoryImage = categoryImage;
        this.categoryName = categoryName;
    }

    public int getCategoryImage() { return categoryImage; }
    public String getCategoryName() { return categoryName; }

    public void setCategoryImage(int categoryImage) { this.categoryImage = categoryImage; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
}
