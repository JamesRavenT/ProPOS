package com.wabizabi.wazabipos.Utilities.BackgroundThreads;

import static com.wabizabi.wazabipos.Utilities.Cache.cachedTransactions;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.wabizabi.wazabipos.Database.Schemas.Transactions;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class W01_QueryTransactions extends Worker {

    public W01_QueryTransactions(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        try(Realm realm = Realm.getDefaultInstance()){
            RealmResults<Transactions> listOfTransactions = realm.where(Transactions.class).findAll();
            for(Transactions transactionsz : listOfTransactions){
                List<String> transactions = new ArrayList<>(transactionsz.getNameOfEachItem());
                cachedTransactions.add(transactions);
            }
        }

        return Result.success();
    }



}
