package com.wabizabi.wazabipos.Database.ObjectSchemas;

public class Table {

    String tableName;
    int tableNo;

    public Table(){}

    public Table(String tableName, int tableNo) {
        this.tableName = tableName;
        this.tableNo = tableNo;
    }

    public String getTableName() { return tableName; }
    public int getTableNo() { return tableNo; }

    public void setTableName(String tableName) { this.tableName = tableName; }
    public void setTableNo(int tableNo) { this.tableNo = tableNo; }


}
