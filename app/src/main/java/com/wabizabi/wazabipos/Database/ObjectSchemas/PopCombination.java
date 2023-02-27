package com.wabizabi.wazabipos.Database.ObjectSchemas;

import java.util.ArrayList;
import java.util.List;

public class PopCombination {

    String itemName;
    List<String> itemSet = new ArrayList<>();
    int frequency;
    String year;
    String month;

    public PopCombination(){}

    public PopCombination(List<String> itemSet, int frequency) {
        this.itemSet = itemSet;
        this.frequency = frequency;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public List<String> getItemSet() {
        return itemSet;
    }

    public void setItemSet(List<String> itemSet) {
        this.itemSet = itemSet;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
