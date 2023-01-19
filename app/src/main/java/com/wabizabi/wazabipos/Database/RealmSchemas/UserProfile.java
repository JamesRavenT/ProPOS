package com.wabizabi.wazabipos.Database.RealmSchemas;

import org.bson.types.ObjectId;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class UserProfile extends RealmObject {
    @PrimaryKey
    ObjectId _id;
    String key;
    String userName;
    int password;


    public UserProfile(){}

    public UserProfile(ObjectId _id, String userName, int password, String key) {
        this._id = _id;
        this.key = key;
        this.userName = userName;
        this.password = password;

    }
    public String getKey() { return key; }
    public String getUserName() { return userName; }
    public int getPassword() { return password; }

    public void setKey(String key) { this.key = key; }
    public void setUserName(String userName) { this.userName = userName; }
    public void setPassword(int password) { this.password = password; }

}
