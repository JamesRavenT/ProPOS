package com.wabizabi.wazabipos.Database.RealmSchemas;

import org.bson.types.ObjectId;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RealmOrderTable extends RealmObject {
    @PrimaryKey
    ObjectId _id;
    String tableName;

    public RealmOrderTable(){}
    public RealmOrderTable(String tableName, int discountAmount){
        this.tableName = tableName;
    }

    public String getTableName() { return tableName; }

    public void seTableName(String tableName) { this.tableName = tableName; }
}
