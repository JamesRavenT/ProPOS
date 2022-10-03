package com.wabizabi.wazabipos.Utilities.BackgroundThreads;

import android.content.Context;

import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import java.util.concurrent.TimeUnit;

public class WorkOrders {
    static OneTimeWorkRequest query = new OneTimeWorkRequest.Builder(W01_QueryTransactions.class).build();
    static PeriodicWorkRequest algorithm = new PeriodicWorkRequest.Builder(W02_Algorithm.class, 16, TimeUnit.MINUTES).build();


    public static void getTransactions(Context context) {
        WorkManager.getInstance(context).enqueue(query);
    }

    public static void startAlgorithm(Context context) {
        WorkManager.getInstance(context).enqueue(algorithm);
    }
}
