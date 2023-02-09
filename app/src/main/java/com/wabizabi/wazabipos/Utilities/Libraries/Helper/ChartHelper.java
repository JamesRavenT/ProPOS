package com.wabizabi.wazabipos.Utilities.Libraries.Helper;

import com.wabizabi.wazabipos.Database.ObjectSchemas.SalesTransaction;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmSalesTransaction;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class ChartHelper {

    public static List<SalesTransaction> getNormalView(Realm realm){
        List<SalesTransaction> listOfSales = new ArrayList<>();
        String year = new SimpleDateFormat("yyyy").format(new Date());
        String month = new SimpleDateFormat("MM").format(new Date());
        String week = new SimpleDateFormat("W").format(new Date());
        String day = new SimpleDateFormat("dd").format(new Date());
        RealmResults<RealmSalesTransaction> queriedSales = realm.where(RealmSalesTransaction.class)
                .equalTo("year", year)
                .and()
                .equalTo("month", month)
                .and()
                .equalTo("week", week)
                .and()
                .equalTo("day", day)
                .findAll();
        for(RealmSalesTransaction query : queriedSales){
            listOfSales.add(new SalesTransaction(query.getTransactionType(), query.getTotalSubTotal(), query.getTotalAmountDue()));
        }
        return listOfSales;
    }

    public static List<SalesTransaction> getYearlyView(Realm realm, String year){
        List<SalesTransaction> listOfSales = new ArrayList<>();
        RealmResults<RealmSalesTransaction> queriedSales = realm.where(RealmSalesTransaction.class)
                .equalTo("year", year)
                .findAll();
        for(RealmSalesTransaction query : queriedSales){
            listOfSales.add(new SalesTransaction(query.getTransactionType(), query.getTotalSubTotal(), query.getTotalAmountDue()));
        }
        return listOfSales;
    }

    public static List<SalesTransaction> getMonthlyView(Realm realm, String year, String month){
        List<SalesTransaction> listOfSales = new ArrayList<>();
        RealmResults<RealmSalesTransaction> queriedSales = realm.where(RealmSalesTransaction.class)
                .equalTo("year", year)
                .and()
                .equalTo("month", month)
                .findAll();
        for(RealmSalesTransaction query : queriedSales){
            listOfSales.add(new SalesTransaction(query.getTransactionType(), query.getTotalSubTotal(), query.getTotalAmountDue()));
        }
        return listOfSales;
    }

    public static List<SalesTransaction> getWeeklyView(Realm realm, String year, String month, String week){
        List<SalesTransaction> listOfSales = new ArrayList<>();
        RealmResults<RealmSalesTransaction> queriedSales = realm.where(RealmSalesTransaction.class)
                .equalTo("year", year)
                .and()
                .equalTo("month", month)
                .and()
                .equalTo("week", week)
                .findAll();
        for(RealmSalesTransaction query : queriedSales){
            listOfSales.add(new SalesTransaction(query.getTransactionType(), query.getTotalSubTotal(), query.getTotalAmountDue()));
        }
        return listOfSales;
    }

    public static List<SalesTransaction> getDailyView(Realm realm, String year, String month, String week, String day){
        List<SalesTransaction> listOfSales = new ArrayList<>();
        RealmResults<RealmSalesTransaction> queriedSales = realm.where(RealmSalesTransaction.class)
                .equalTo("year", year)
                .and()
                .equalTo("month", month)
                .and()
                .equalTo("week", week)
                .and()
                .equalTo("day", day)
                .findAll();
        for(RealmSalesTransaction query : queriedSales){
            listOfSales.add(new SalesTransaction(query.getTransactionType(), query.getTotalSubTotal(), query.getTotalAmountDue()));
        }
        return listOfSales;
    }
}
