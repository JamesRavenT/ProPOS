package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.SubModule.Categories.Create.SubActivity.Model;

public class StockImg_CategoryModel {

    int iconNo;
    String iconName;

    public StockImg_CategoryModel(){}

    public StockImg_CategoryModel(int iconNo, String iconName) {
        this.iconNo = iconNo;
        this.iconName = iconName;
    }

    public int getIconNo() { return iconNo; }
    public String getIconName() { return iconName; }

    public void setIconNo(int iconNo) { this.iconNo = iconNo; }
    public void setIconName(String iconName) { this.iconName = iconName; }
}
