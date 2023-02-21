package com.wabizabi.wazabipos.Database.Instances;

import com.wabizabi.wazabipos.Database.DB;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmUser;

import org.bson.types.ObjectId;

import java.util.Random;

import io.realm.Realm;

public class OpenUserInstance {

    public static void toCreateUser(String email, String username, String password){
        try (Realm realm = Realm.getDefaultInstance()){
            ObjectId id = new ObjectId();
            realm.executeTransaction((user) -> {
                RealmUser account = user.createObject(RealmUser.class, id);
                account.setEmail(email);
                account.setUserName(username);
                account.setPassword(Integer.parseInt(password));
                account.setVerifiedUser(true);
                account.setInvTransactionLocal(0);
                account.setSalesTransactionLocal(0);
                account.setInvTransactionCloud(0);
                account.setSalesTransactionsCloud(0);
                DB.uploadUserToCloud(id, email, username, Integer.parseInt(password));
            });
        }
    }

    public static void toLoadUserFromDB(ObjectId id, String email, String username, int password, int invTransaction, int salesTransaction){
        try (Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction((user) -> {
                RealmUser account = user.createObject(RealmUser.class, id);
                account.setEmail(email);
                account.setUserName(username);
                account.setPassword(password);
                account.setVerifiedUser(false);
                account.setVerficationCode(null);
                account.setInvTransactionLocal(0);
                account.setSalesTransactionLocal(0);
                account.setInvTransactionCloud(invTransaction);
                account.setSalesTransactionsCloud(salesTransaction);
            });
        }
    }

    public static void toCreateVerificationCode(){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmUser user = db.where(RealmUser.class).findFirst();
                Random rnd = new Random();
                int number = rnd.nextInt(999999);
                String verificationCode = String.format("%06d", number);
                user.setVerficationCode(verificationCode);
            });
        }
    }

    public static void toDeleteVerificationCode(){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmUser user = db.where(RealmUser.class).findFirst();
                user.setVerifiedUser(true);
                user.setVerficationCode(null);
            });
        }
    }

    public static void toSetVerifiedUserToTrue(){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmUser user = db.where(RealmUser.class).findFirst();
                if(!user.isVerifiedUser()){
                    user.setVerifiedUser(true);
                }
            });
        }

    }
    public static void toUpdateEmail(String email){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmUser user = db.where(RealmUser.class).findFirst();
                user.setEmail(email);
                DB.updateUserEmailFromCloud(user.get_id(), email);
            });
        }
    }

    public static void toUpdateUsername(String username){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmUser user = db.where(RealmUser.class).findFirst();
                user.setUserName(username);
                DB.updateUserNameFromCloud(user.get_id(), username);
            });
        }
    }

    public static void toUpdatePassword(String password){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmUser user = db.where(RealmUser.class).findFirst();
                user.setPassword(Integer.parseInt(password));
                DB.updateUserPasswordFromCloud(user.get_id(), Integer.parseInt(password));
            });
        }
    }

    public static void toUpdateLocalInventoryTransactionCount(){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmUser user = db.where(RealmUser.class).findFirst();
                int count = user.getInvTransactionLocal();
                user.setInvTransactionLocal(count + 1);
            });
        }
    }

    public static void toFetchCloudInventoryTransactionCount(int count){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmUser user = db.where(RealmUser.class).findFirst();
                user.setInvTransactionCloud(count);
            });
        }
    }

    public static void toUpdateLocalSalesTransactionCount(){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmUser user = db.where(RealmUser.class).findFirst();
                int count = user.getSalesTransactionLocal();
                user.setSalesTransactionLocal(count + 1);
            });
        }
    }

    public static void toFetchCloudSalesTransactionCount(int count){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmUser user = db.where(RealmUser.class).findFirst();
                user.setSalesTransactionsCloud(count);
            });
        }
    }
}
