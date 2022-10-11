package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.SubModule.Categories.Create.SubActivity.Model;

public class M04F02SM01CF01SA01_RVModel {

    int iconNo;
    String iconName;

    public M04F02SM01CF01SA01_RVModel(){}

    public M04F02SM01CF01SA01_RVModel(int iconNo, String iconName) {
        this.iconNo = iconNo;
        this.iconName = iconName;
    }

    public int getIconNo() { return iconNo; }
    public String getIconName() { return iconName; }

    public void setIconNo(int iconNo) { this.iconNo = iconNo; }
    public void setIconName(String iconName) { this.iconName = iconName; }
}
