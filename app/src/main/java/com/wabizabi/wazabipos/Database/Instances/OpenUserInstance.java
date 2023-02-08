package com.wabizabi.wazabipos.Database.Instances;

import com.wabizabi.wazabipos.Database.DB;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmUser;

import org.bson.types.ObjectId;

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
                DB.uploadUserToCloud(id, email, username, Integer.parseInt(password));
            });
        }
    }

    public static void toLoadUserFromDB(ObjectId id, String email, String username, int password){
        try (Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction((user) -> {
                RealmUser account = user.createObject(RealmUser.class, id);
                account.setEmail(email);
                account.setUserName(username);
                account.setPassword(password);
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
}
