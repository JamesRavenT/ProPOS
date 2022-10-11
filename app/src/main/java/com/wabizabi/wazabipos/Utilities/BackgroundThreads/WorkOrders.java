package com.wabizabi.wazabipos.Utilities.BackgroundThreads;

import android.content.Context;

import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import java.util.concurrent.TimeUnit;

public class WorkOrders {

    static Constraints network =
            new Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .build();

    static PeriodicWorkRequest algorithm =
            new PeriodicWorkRequest
                    .Builder(W01_Algorithm.class, 15, TimeUnit.MINUTES)
                    .build();
    static PeriodicWorkRequest uploadToCloudDatabase =
            new PeriodicWorkRequest
                    .Builder(W02_UploadData.class, 20, TimeUnit.MINUTES)
                    .setConstraints(network)
                    .build();

    public static void startAlgorithm(Context context){
        WorkManager.getInstance(context).enqueueUniquePeriodicWork("Algorithm", ExistingPeriodicWorkPolicy.REPLACE, algorithm);
    }

    public static void storeFPData(Context context){
        WorkManager.getInstance(context).enqueueUniquePeriodicWork("FPData", ExistingPeriodicWorkPolicy.REPLACE, uploadToCloudDatabase);
    }
}
