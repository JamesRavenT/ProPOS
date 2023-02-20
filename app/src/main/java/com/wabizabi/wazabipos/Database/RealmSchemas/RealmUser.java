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
    //VERIFICATION
    boolean isVerifiedUser;
    String verficationCode;
    //COUNTER
    int invTransactionLocal;
    int invTransactionCloud;
    int salesTransactionLocal;
    int salesTransactionsCloud;


    public RealmUser(){}

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public boolean isVerifiedUser() {
        return isVerifiedUser;
    }

    public void setVerifiedUser(boolean verifiedUser) {
        isVerifiedUser = verifiedUser;
    }

    public String getVerficationCode() {
        return verficationCode;
    }

    public void setVerficationCode(String verficationCode) {
        this.verficationCode = verficationCode;
    }

    public int getInvTransactionLocal() {
        return invTransactionLocal;
    }

    public void setInvTransactionLocal(int invTransactionLocal) {
        this.invTransactionLocal = invTransactionLocal;
    }

    public int getInvTransactionCloud() {
        return invTransactionCloud;
    }

    public void setInvTransactionCloud(int invTransactionCloud) {
        this.invTransactionCloud = invTransactionCloud;
    }

    public int getSalesTransactionLocal() {
        return salesTransactionLocal;
    }

    public void setSalesTransactionLocal(int salesTransactionLocal) {
        this.salesTransactionLocal = salesTransactionLocal;
    }

    public int getSalesTransactionsCloud() {
        return salesTransactionsCloud;
    }

    public void setSalesTransactionsCloud(int salesTransactionsCloud) {
        this.salesTransactionsCloud = salesTransactionsCloud;
    }
}
