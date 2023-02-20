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
                    .Builder(W02_UploadResultsToCloud.class, 20, TimeUnit.MINUTES)
                    .setConstraints(network)
                    .build();

    static OneTimeWorkRequest verificationCode =
            new OneTimeWorkRequest
                    .Builder(W03_VerificationCode.class)
                    .setConstraints(network)
                    .build();

    static OneTimeWorkRequest passwordRecovery =
            new OneTimeWorkRequest
                    .Builder(W04_ForgottenPassword.class)
                    .setConstraints(network)
                    .build();

    public static void startAlgorithm(Context context){
        WorkManager
                .getInstance(context)
                .enqueueUniquePeriodicWork("Algorithm", ExistingPeriodicWorkPolicy.REPLACE, algorithm);
    }

    public static void storeFPData(Context context){
        WorkManager
                .getInstance(context)
                .enqueueUniquePeriodicWork("FPData", ExistingPeriodicWorkPolicy.REPLACE, uploadToCloudDatabase);
    }

    public static void sendEmail(Context context){
        WorkManager
                .getInstance(context)
                .enqueue(passwordRecovery);
    }

    public static void sendVerificationCode(Context context){
        WorkManager
                .getInstance(context)
                .enqueue(verificationCode);
    }

}
