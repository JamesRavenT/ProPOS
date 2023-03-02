package com.wabizabi.wazabipos.Database.Instances;

import com.wabizabi.wazabipos.Database.DB;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmUser;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.LogHelper;

import org.bson.types.ObjectId;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import io.realm.Realm;

public class OpenUserInstance {

    public static void toCreateUser(String email, String username, String password){
        try (Realm realm = Realm.getDefaultInstance()){
            ObjectId id = new ObjectId();
            String lastSynced = new SimpleDateFormat("DDD").format(new Date());
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
                account.setDateOfLastSync(lastSynced);
                account.setDailySalesSyncCounter(0);
                account.setDailyInvSyncCounter(0);
                DB.uploadUserToCloud(id, email, username, Integer.parseInt(password));
            });
        }
    }

    public static void toLoadUserFromDB(ObjectId id, String email, String username, int password, int invTransaction, int salesTransaction){
        try (Realm realm = Realm.getDefaultInstance()){
            String lastSynced = new SimpleDateFormat("DDD").format(new Date());
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
                account.setDateOfLastSync(lastSynced);
                account.setDailySalesSyncCounter(0);
                account.setDailyInvSyncCounter(0);
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

    public static void toUpdateLocalInventoryTransactionCountAdd(){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmUser user = db.where(RealmUser.class).findFirst();
                int count = user.getInvTransactionLocal();
                user.setInvTransactionLocal(count + 1);
            });
        }
    }

    public static void toUpdateLocalInventoryTransactionCountSub(){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmUser user = db.where(RealmUser.class).findFirst();
                int count = user.getInvTransactionLocal();
                int limit = user.getDailySalesSyncCounter();
                user.setInvTransactionLocal(count - 1);
                user.setDailyInvSyncCounter(limit + 1);
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
                int limit = user.getDailySalesSyncCounter();
                user.setSalesTransactionLocal(count + 1);
                user.setDailySalesSyncCounter(limit + 1);
            });
        }
    }

    public static void toFetchCloudSalesTransactionCount(int count){
        try(Realm realm = Realm.getDefaultInstance()){
            RealmUser user = realm.where(RealmUser.class).findFirst();
            realm.executeTransaction(db -> {
                user.setSalesTransactionsCloud(count);
            });
        }
    }

    public static void toUpdateSyncDate(){
        try(Realm realm = Realm.getDefaultInstance()){
            String lastSynced = new SimpleDateFormat("DDD").format(new Date());
            RealmUser user = realm.where(RealmUser.class).findFirst();
            realm.executeTransaction(db -> {
                user.setDateOfLastSync(lastSynced);
                user.setDailySalesSyncCounter(0);
                user.setDailyInvSyncCounter(0);
            });
        }
    }

    public static Integer fetchLocalSalesCount(){
        try(Realm realm = Realm.getDefaultInstance()){
            RealmUser user = realm.where(RealmUser.class).findFirst();
            return user.getSalesTransactionLocal();
        }
    }

    public static Integer fetchCloudSalesCount(){
        try(Realm realm = Realm.getDefaultInstance()){
            RealmUser user = realm.where(RealmUser.class).findFirst();
            return user.getSalesTransactionsCloud();
        }
    }

    public static Integer fetchSalesLimit(){
        try(Realm realm = Realm.getDefaultInstance()){
            RealmUser user = realm.where(RealmUser.class).findFirst();
            return user.getDailySalesSyncCounter();
        }
    }
}
