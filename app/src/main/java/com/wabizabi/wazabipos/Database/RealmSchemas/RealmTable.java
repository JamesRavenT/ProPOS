package com.wabizabi.wazabipos.Database.RealmSchemas;

import org.bson.types.ObjectId;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RealmTable extends RealmObject {
    @PrimaryKey
    ObjectId _id;
    int tableNo;
    String tableName;
    String tableStatus;

    public RealmTable(){}
    public RealmTable(String tableName, int tableNo){
        this.tableName = tableName;
    }

    public int getTableNo() { return tableNo; }
    public String getTableName() { return tableName; }
    public String getTableStatus() { return tableStatus; }
    public void setTableNo(int tableNo) { this.tableNo = tableNo; }
    public void setTableName(String tableName) { this.tableName = tableName; }
    public void setTableStatus(String tableStatus) { this.tableStatus = tableStatus; }

}
