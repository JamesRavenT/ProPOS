package com.wabizabi.wazabipos.Utilities.BackgroundThreads;

import static com.wabizabi.wazabipos.Utilities.Global.Variables.fpList;
import static com.wabizabi.wazabipos.Utilities.Global.Variables.fqList;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.wabizabi.wazabipos.Database.DB;
import com.wabizabi.wazabipos.R;

public class W02_UploadData extends Worker {
    public W02_UploadData(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        if(!fqList.isEmpty() && !fpList.isEmpty()){
            DB.uploadFQListData(fqList);
            DB.uploadFPListData(fpList);
            createNotification();
        }
        return Result.success();
    }
    public void createNotification(){
        NotificationChannel testChannel = new NotificationChannel("CH1", "Channel 1", NotificationManager.IMPORTANCE_DEFAULT);
        testChannel.setDescription("testing 01");

        NotificationManager manager = getApplicationContext().getSystemService(NotificationManager.class);
        manager.createNotificationChannel(testChannel);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplicationContext());

        Notification notification = new NotificationCompat.Builder(getApplicationContext(), "CH1")
                .setSmallIcon(R.drawable.icon_user)
                .setContentTitle("Title")
                .setContentText("FPData Syncing complete")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_REMINDER)
                .build();
        notificationManager.notify(1,notification);
    }
}
