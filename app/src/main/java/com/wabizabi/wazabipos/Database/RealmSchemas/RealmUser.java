package com.wabizabi.wazabipos.Database.RealmSchemas;

import org.bson.types.ObjectId;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RealmUser extends RealmObject {
    @PrimaryKey
    ObjectId _id;
    String email;
    String userName;
    int password;


    public RealmUser(){}

    public ObjectId get_id() {
        return _id;
    }

    public String getEmail() { return email; }
    public String getUserName() { return userName; }
    public int getPassword() { return password; }

    public void setEmail(String email) { this.email = email; }
    public void setUserName(String userName) { this.userName = userName; }
    public void setPassword(int password) { this.password = password; }

}
