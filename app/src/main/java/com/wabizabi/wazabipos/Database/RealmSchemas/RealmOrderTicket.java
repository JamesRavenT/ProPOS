package com.wabizabi.wazabipos.Database.RealmSchemas;

import com.wabizabi.wazabipos.Utilities.Objects.CartObject;

import org.bson.types.ObjectId;

import java.util.List;
import java.util.Map;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RealmOrderTicket extends RealmObject {
    @PrimaryKey
    ObjectId _id;
    String cashierName;
    String orderType;
    String tableNo;
    String additionalDetails;
    double tax;
    String date;
    String time;

    public RealmOrderTicket(){}

}
