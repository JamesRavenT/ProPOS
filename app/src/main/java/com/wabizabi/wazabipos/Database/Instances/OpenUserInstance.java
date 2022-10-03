package com.wabizabi.wazabipos.Database.Instances;

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
}
