package com.wabizabi.wazabipos.Database.Instances;

import com.wabizabi.wazabipos.Database.RealmSchemas.RealmUser;

import org.bson.types.ObjectId;

import io.realm.Realm;

public class OpenUserInstance {

    public static void toCreateUser(String username, String password){
        try (Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction((user) -> {
                RealmUser account = user.createObject(RealmUser.class, new ObjectId());
                account.setKey("Registered");
                account.setUserName(username);
                account.setPassword(Integer.parseInt(password));
            });
        }
    }

    public static void toUpdateUsername(String username){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmUser user = db.where(RealmUser.class).findFirst();
                user.setUserName(username);
            });
        }
    }

    public static void toUpdatePassword(String password){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                RealmUser user = db.where(RealmUser.class).findFirst();
                user.setPassword(Integer.parseInt(password));
            });
        }
    }
}
