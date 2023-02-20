package com.wabizabi.wazabipos.Utilities.BackgroundThreads;

import static com.wabizabi.wazabipos.Utilities.BackgroundThreads.W01_Algorithm.fpList;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.wabizabi.wazabipos.Database.DB;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuItem;

import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmResults;

public class W02_UploadResultsToCloud extends Worker {
    public W02_UploadResultsToCloud(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }
    @NonNull
    @Override
    public Result doWork() {
        if(!fpList.isEmpty()){
            Realm realm = Realm.getDefaultInstance();
            RealmResults<RealmMenuItem> listOfItems = realm.where(RealmMenuItem.class).findAll();
            for(Map.Entry<String, Map<List<String>, Integer>> itemSet : fpList.entrySet()){
                for(RealmMenuItem item : listOfItems){
                    if(itemSet.getKey().equals(item.getItemWebName())){
                        ObjectId id = item.get_id();
                        Map<List<String>, Integer> itemSets = itemSet.getValue();
                        List<List<String>> combinations = new ArrayList<>(itemSets.keySet());
                        DB.uploadFPGDaily(id, combinations);
                    }
                }

            }
        }
        return Result.success();
    }
}





//    public void createNotification(){
//        NotificationChannel testChannel = new NotificationChannel("CH1", "Channel 1", NotificationManager.IMPORTANCE_DEFAULT);
//        testChannel.setDescription("testing 01");
//
//        NotificationManager manager = getApplicationContext().getSystemService(NotificationManager.class);
//        manager.createNotificationChannel(testChannel);
//
//        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplicationContext());
//
//        Notification notification = new NotificationCompat.Builder(getApplicationContext(), "CH1")
//                .setSmallIcon(R.drawable.icon_profile_createuser)
//                .setContentTitle("Title")
//                .setContentText("FPData Syncing complete")
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//                .setCategory(NotificationCompat.CATEGORY_REMINDER)
//                .build();
//        notificationManager.notify(1,notification);
//    }