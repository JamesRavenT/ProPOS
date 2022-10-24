package com.wabizabi.wazabipos.Database.Instances;

import com.google.firebase.firestore.auth.User;
import com.wabizabi.wazabipos.Database.DB;
import com.wabizabi.wazabipos.Database.Schemas.UserProfile;

import org.bson.types.ObjectId;

import io.realm.Realm;

public class OpenUserInstance {

    public static void toCreateUser(String username, String password){
        try (Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction((user) -> {
                UserProfile account = user.createObject(UserProfile.class, new ObjectId());
                account.setKey("Registered");
                account.setUserName(username);
                account.setPassword(Integer.parseInt(password));
            });
        }
    }

    public static void toUpdateUsername(String username){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                UserProfile user = db.where(UserProfile.class).findFirst();
                user.setUserName(username);
            });
        }
    }

    public static void toUpdatePassword(String password){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(db -> {
                UserProfile user = db.where(UserProfile.class).findFirst();
                user.setPassword(Integer.parseInt(password));
            });
        }
    }
}
