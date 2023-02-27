package com.wabizabi.wazabipos.Utilities.Libraries.Helper;

import com.github.mikephil.charting.data.BarEntry;
import com.wabizabi.wazabipos.Database.ObjectSchemas.SalesTransaction;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmSalesTransaction;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class ChartHelper {
    //DATA
    public static List<SalesTransaction> getYearlyView(Realm realm, String year){
        List<SalesTransaction> listOfSales = new ArrayList<>();
        RealmResults<RealmSalesTransaction> queriedSales = realm.where(RealmSalesTransaction.class)
                .equalTo("year", year)
                .findAll();
        for(RealmSalesTransaction query : queriedSales){
            listOfSales.add(
                    new SalesTransaction(
                            query.getTransactionType(),
                            query.getTotalSubTotal(),
                            query.getTotalAmountDue(),
                            query.getYear(),
                            query.getMonth(),
                            query.getWeek(),
                            query.getDayTxt(),
                            query.getDayNo(),
                            query.getHour()
                    ));
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
            listOfSales.add(
                    new SalesTransaction(
                            query.getTransactionType(),
                            query.getTotalSubTotal(),
                            query.getTotalAmountDue(),
                            query.getYear(),
                            query.getMonth(),
                            query.getWeek(),
                            query.getDayTxt(),
                            query.getDayNo(),
                            query.getHour()
                    ));
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
            listOfSales.add(
                    new SalesTransaction(
                            query.getTransactionType(),
                            query.getTotalSubTotal(),
                            query.getTotalAmountDue(),
                            query.getYear(),
                            query.getMonth(),
                            query.getWeek(),
                            query.getDayTxt(),
                            query.getDayNo(),
                            query.getHour()
                    ));
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
                .equalTo("dayNo", day)
                .findAll();
        for(RealmSalesTransaction query : queriedSales){
            listOfSales.add(
                    new SalesTransaction(
                            query.getTransactionType(),
                            query.getTotalSubTotal(),
                            query.getTotalAmountDue(),
                            query.getYear(),
                            query.getMonth(),
                            query.getWeek(),
                            query.getDayTxt(),
                            query.getDayNo(),
                            query.getHour()
                    ));
        }
        return listOfSales;
    }

    //BAR
    public static String[] getXVariables(String viewType){
        String[] xVariables = new String[0];
        switch(viewType){
            case "Yearly":
                xVariables = new String[]{
                        "Jan",
                        "Feb",
                        "Mar",
                        "Apr",
                        "May",
                        "Jun",
                        "Jul",
                        "Aug",
                        "Sep",
                        "Oct",
                        "Nov",
                        "December"
                };
                break;
            case "Monthly":
                xVariables = new String[]{
                        "Week 1",
                        "Week 2",
                        "Week 3",
                        "Week 4",
                        "Week 5"
                };
                break;
            case "Weekly":
                xVariables = new String[]{
                        "Mon",
                        "Tue",
                        "Wed",
                        "Thu",
                        "Fri",
                        "Sat",
                        "Sun"
                };
                break;
            case "Daily" :
                xVariables = new String[]{
                        "6AM",
                        "9AM",
                        "12PM",
                        "3PM",
                        "6PM",
                        "8PM"
                };
                break;
        }
        return  xVariables;
    }

    public static List<BarEntry> getYearlySales(Realm realm, String year){
        List<BarEntry> listOfYearlySales = new ArrayList<>();
        //JANUARY
        RealmResults<RealmSalesTransaction> janQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Sales")
                        .and().equalTo("year", year)
                        .and().equalTo("month", "01")
                        .findAll();
        //FEBRUARY
        RealmResults<RealmSalesTransaction> febQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Sales")
                        .and().equalTo("year", year)
                        .and().equalTo("month", "02")
                        .findAll();
        //MARCH
        RealmResults<RealmSalesTransaction> marQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Sales")
                        .and().equalTo("year", year)
                        .and().equalTo("month", "03")
                        .findAll();
        //APRIL
        RealmResults<RealmSalesTransaction> aprQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Sales")
                        .and().equalTo("year", year)
                        .and().equalTo("month", "04")
                        .findAll();
        //MAY
        RealmResults<RealmSalesTransaction> mayQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Sales")
                        .and().equalTo("year", year)
                        .and().equalTo("month", "05")
                        .findAll();
        //JUNE
        RealmResults<RealmSalesTransaction> junQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Sales")
                        .and().equalTo("year", year)
                        .and().equalTo("month", "06")
                        .findAll();
        //JULY
        RealmResults<RealmSalesTransaction> julQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Sales")
                        .and().equalTo("year", year)
                        .and().equalTo("month", "07")
                        .findAll();
        //AUGUST
        RealmResults<RealmSalesTransaction> augQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Sales")
                        .and().equalTo("year", year)
                        .and().equalTo("month", "08")
                        .findAll();
        //SEPTEMBER
        RealmResults<RealmSalesTransaction> sepQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Sales")
                        .and().equalTo("year", year)
                        .and().equalTo("month", "09")
                        .findAll();
        //OCTOBER
        RealmResults<RealmSalesTransaction> octQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Sales")
                        .and().equalTo("year", year)
                        .and().equalTo("month", "10")
                        .findAll();
        //NOVEMBER
        RealmResults<RealmSalesTransaction> novQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Sales")
                        .and().equalTo("year", year)
                        .and().equalTo("month", "11")
                        .findAll();
        //DECEMBER
        RealmResults<RealmSalesTransaction> decQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Sales")
                        .and().equalTo("year", year)
                        .and().equalTo("month", "12")
                        .findAll();

        listOfYearlySales.add(new BarEntry(1, janQuery.size()));
        listOfYearlySales.add(new BarEntry(2, febQuery.size()));
        listOfYearlySales.add(new BarEntry(3, marQuery.size()));
        listOfYearlySales.add(new BarEntry(4, aprQuery.size()));
        listOfYearlySales.add(new BarEntry(5, mayQuery.size()));
        listOfYearlySales.add(new BarEntry(6, junQuery.size()));
        listOfYearlySales.add(new BarEntry(7, julQuery.size()));
        listOfYearlySales.add(new BarEntry(8, augQuery.size()));
        listOfYearlySales.add(new BarEntry(9, sepQuery.size()));
        listOfYearlySales.add(new BarEntry(10, octQuery.size()));
        listOfYearlySales.add(new BarEntry(11, novQuery.size()));
        listOfYearlySales.add(new BarEntry(12, decQuery.size()));

        return listOfYearlySales;
    }
    public static List<BarEntry> getYearlyRefund(Realm realm, String year){
        List<BarEntry> listOfYearlyRefunds = new ArrayList<>();
        RealmResults<RealmSalesTransaction> janQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Refund")
                        .and()
                        .equalTo("year", year)
                        .and()
                        .equalTo("month", "01")
                        .findAll();
        RealmResults<RealmSalesTransaction> febQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Refund")
                        .and()
                        .equalTo("year", year)
                        .and()
                        .equalTo("month", "02")
                        .findAll();
        RealmResults<RealmSalesTransaction> marQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Refund")
                        .and()
                        .equalTo("year", year)
                        .and()
                        .equalTo("month", "03")
                        .findAll();
        RealmResults<RealmSalesTransaction> aprQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Refund")
                        .and()
                        .equalTo("year", year)
                        .and()
                        .equalTo("month", "04")
                        .findAll();
        RealmResults<RealmSalesTransaction> mayQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Refund")
                        .and()
                        .equalTo("year", year)
                        .and()
                        .equalTo("month", "05")
                        .findAll();
        RealmResults<RealmSalesTransaction> junQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Refund")
                        .and()
                        .equalTo("year", year)
                        .and()
                        .equalTo("month", "06")
                        .findAll();
        RealmResults<RealmSalesTransaction> julQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Refund")
                        .and()
                        .equalTo("year", year)
                        .and()
                        .equalTo("month", "07")
                        .findAll();
        RealmResults<RealmSalesTransaction> augQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Refund")
                        .and()
                        .equalTo("year", year)
                        .and()
                        .equalTo("month", "08")
                        .findAll();
        RealmResults<RealmSalesTransaction> sepQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Refund")
                        .and()
                        .equalTo("year", year)
                        .and()
                        .equalTo("month", "09")
                        .findAll();
        RealmResults<RealmSalesTransaction> octQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Refund")
                        .and()
                        .equalTo("year", year)
                        .and()
                        .equalTo("month", "10")
                        .findAll();
        RealmResults<RealmSalesTransaction> novQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Refund")
                        .and()
                        .equalTo("year", year)
                        .and()
                        .equalTo("month", "11")
                        .findAll();
        RealmResults<RealmSalesTransaction> decQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Refund")
                        .and()
                        .equalTo("year", year)
                        .and()
                        .equalTo("month", "12")
                        .findAll();

        listOfYearlyRefunds.add(new BarEntry(1, janQuery.size()));
        listOfYearlyRefunds.add(new BarEntry(2, febQuery.size()));
        listOfYearlyRefunds.add(new BarEntry(3, marQuery.size()));
        listOfYearlyRefunds.add(new BarEntry(4, aprQuery.size()));
        listOfYearlyRefunds.add(new BarEntry(5, mayQuery.size()));
        listOfYearlyRefunds.add(new BarEntry(6, junQuery.size()));
        listOfYearlyRefunds.add(new BarEntry(7, julQuery.size()));
        listOfYearlyRefunds.add(new BarEntry(8, augQuery.size()));
        listOfYearlyRefunds.add(new BarEntry(9, sepQuery.size()));
        listOfYearlyRefunds.add(new BarEntry(10, octQuery.size()));
        listOfYearlyRefunds.add(new BarEntry(11, novQuery.size()));
        listOfYearlyRefunds.add(new BarEntry(12, decQuery.size()));

        return listOfYearlyRefunds;
    }

    public static List<BarEntry> getMonthlySales(Realm realm, String year, String month){
        List<BarEntry> listOfMonthlySales = new ArrayList<>();
        //WEEK 1
        RealmResults<RealmSalesTransaction> w1Query =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Sales")
                        .and()
                        .equalTo("year", year)
                        .and()
                        .equalTo("month", month)
                        .and()
                        .equalTo("week", "1")
                        .findAll();
        //WEEK 2
        RealmResults<RealmSalesTransaction> w2Query =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Sales")
                        .and()
                        .equalTo("year", year)
                        .and()
                        .equalTo("month", month)
                        .and()
                        .equalTo("week", "2")
                        .findAll();
        //WEEK 3
        RealmResults<RealmSalesTransaction> w3Query =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Sales")
                        .and()
                        .equalTo("year", year)
                        .and()
                        .equalTo("month", month)
                        .and()
                        .equalTo("week", "3")
                        .findAll();
        //WEEK 4
        RealmResults<RealmSalesTransaction> w4Query =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Sales")
                        .and()
                        .equalTo("year", year)
                        .and()
                        .equalTo("month", month)
                        .and()
                        .equalTo("week", "4")
                        .findAll();
        //WEEK 5
        RealmResults<RealmSalesTransaction> w5Query =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Sales")
                        .and()
                        .equalTo("year", year)
                        .and()
                        .equalTo("month", month)
                        .and()
                        .equalTo("week", "5")
                        .findAll();
        listOfMonthlySales.add(new BarEntry(1, w1Query.size()));
        listOfMonthlySales.add(new BarEntry(2, w2Query.size()));
        listOfMonthlySales.add(new BarEntry(3, w3Query.size()));
        listOfMonthlySales.add(new BarEntry(4, w4Query.size()));
        listOfMonthlySales.add(new BarEntry(5, w5Query.size()));
        return listOfMonthlySales;
    }
    public static List<BarEntry> getMonthlyRefund(Realm realm, String year, String month){
        List<BarEntry> listOfMonthlyRefunds = new ArrayList<>();
        //WEEK 1
        RealmResults<RealmSalesTransaction> w1Query =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Refund")
                        .and()
                        .equalTo("year", year)
                        .and()
                        .equalTo("month", month)
                        .and()
                        .equalTo("week", "1")
                        .findAll();
        //WEEK 2
        RealmResults<RealmSalesTransaction> w2Query =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Refund")
                        .and()
                        .equalTo("year", year)
                        .and()
                        .equalTo("month", month)
                        .and()
                        .equalTo("week", "2")
                        .findAll();
        //WEEK 3
        RealmResults<RealmSalesTransaction> w3Query =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Refund")
                        .and()
                        .equalTo("year", year)
                        .and()
                        .equalTo("month", month)
                        .and()
                        .equalTo("week", "3")
                        .findAll();
        //WEEK 4
        RealmResults<RealmSalesTransaction> w4Query =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Refund")
                        .and()
                        .equalTo("year", year)
                        .and()
                        .equalTo("month", month)
                        .and()
                        .equalTo("week", "4")
                        .findAll();
        //WEEK 5
        RealmResults<RealmSalesTransaction> w5Query =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Refund")
                        .and()
                        .equalTo("year", year)
                        .and()
                        .equalTo("month", month)
                        .and()
                        .equalTo("week", "5")
                        .findAll();
        listOfMonthlyRefunds.add(new BarEntry(1, w1Query.size()));
        listOfMonthlyRefunds.add(new BarEntry(2, w2Query.size()));
        listOfMonthlyRefunds.add(new BarEntry(3, w3Query.size()));
        listOfMonthlyRefunds.add(new BarEntry(4, w4Query.size()));
        listOfMonthlyRefunds.add(new BarEntry(5, w5Query.size()));
        return listOfMonthlyRefunds;
    }

    public static List<BarEntry> getWeeklySales(Realm realm, String year, String month, String week){
        List<BarEntry> listOfWeeklySales = new ArrayList<>();
        //MONDAY
        RealmResults<RealmSalesTransaction> monQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Sales")
                        .and()
                        .equalTo("year", year)
                        .and()
                        .equalTo("month", month)
                        .and()
                        .equalTo("week", week)
                        .and()
                        .equalTo("dayTxt", "Monday")
                        .findAll();
        //TUESDAY
        RealmResults<RealmSalesTransaction> tueQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Sales")
                        .and()
                        .equalTo("year", year)
                        .and()
                        .equalTo("month", month)
                        .and()
                        .equalTo("week", week)
                        .and()
                        .equalTo("dayTxt", "Tuesday")
                        .findAll();
        //WEDNESDAY
        RealmResults<RealmSalesTransaction> wedQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Sales")
                        .and()
                        .equalTo("year", year)
                        .and()
                        .equalTo("month", month)
                        .and()
                        .equalTo("week", week)
                        .and()
                        .equalTo("dayTxt", "Wednesday")
                        .findAll();
        //THURSDAY
        RealmResults<RealmSalesTransaction> thuQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Sales")
                        .and()
                        .equalTo("year", year)
                        .and()
                        .equalTo("month", month)
                        .and()
                        .equalTo("week", week)
                        .and()
                        .equalTo("dayTxt", "Thursday")
                        .findAll();
        //FRIDAY
        RealmResults<RealmSalesTransaction> friQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Sales")
                        .and()
                        .equalTo("year", year)
                        .and()
                        .equalTo("month", month)
                        .and()
                        .equalTo("week", week)
                        .and()
                        .equalTo("dayTxt", "Friday")
                        .findAll();
        //SATURDAY
        RealmResults<RealmSalesTransaction> satQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Sales")
                        .and()
                        .equalTo("year", year)
                        .and()
                        .equalTo("month", month)
                        .and()
                        .equalTo("week", week)
                        .and()
                        .equalTo("dayTxt", "Saturday")
                        .findAll();
        //SUNDAY
        RealmResults<RealmSalesTransaction> sunQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Sales")
                        .and()
                        .equalTo("year", year)
                        .and()
                        .equalTo("month", month)
                        .and()
                        .equalTo("week", week)
                        .and()
                        .equalTo("dayTxt", "Sunday")
                        .findAll();
        listOfWeeklySales.add(new BarEntry(1, monQuery.size()));
        listOfWeeklySales.add(new BarEntry(2, tueQuery.size()));
        listOfWeeklySales.add(new BarEntry(3, wedQuery.size()));
        listOfWeeklySales.add(new BarEntry(4, thuQuery.size()));
        listOfWeeklySales.add(new BarEntry(5, friQuery.size()));
        listOfWeeklySales.add(new BarEntry(6, satQuery.size()));
        listOfWeeklySales.add(new BarEntry(7, sunQuery.size()));
        return listOfWeeklySales;
    }
    public static List<BarEntry> getWeeklyRefund(Realm realm, String year, String month, String week){
        List<BarEntry> listOfWeeklyRefund = new ArrayList<>();
        //MONDAY
        RealmResults<RealmSalesTransaction> monQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Refund")
                        .and()
                        .equalTo("year", year)
                        .and()
                        .equalTo("month", month)
                        .and()
                        .equalTo("week", week)
                        .and()
                        .equalTo("dayTxt", "Monday")
                        .findAll();
        //TUESDAY
        RealmResults<RealmSalesTransaction> tueQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Refund")
                        .and()
                        .equalTo("year", year)
                        .and()
                        .equalTo("month", month)
                        .and()
                        .equalTo("week", week)
                        .and()
                        .equalTo("dayTxt", "Tuesday")
                        .findAll();
        //WEDNESDAY
        RealmResults<RealmSalesTransaction> wedQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Refund")
                        .and()
                        .equalTo("year", year)
                        .and()
                        .equalTo("month", month)
                        .and()
                        .equalTo("week", week)
                        .and()
                        .equalTo("dayTxt", "Wednesday")
                        .findAll();
        //THURSDAY
        RealmResults<RealmSalesTransaction> thuQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Refund")
                        .and()
                        .equalTo("year", year)
                        .and()
                        .equalTo("month", month)
                        .and()
                        .equalTo("week", week)
                        .and()
                        .equalTo("dayTxt", "Thursday")
                        .findAll();
        //FRIDAY
        RealmResults<RealmSalesTransaction> friQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Refund")
                        .and()
                        .equalTo("year", year)
                        .and()
                        .equalTo("month", month)
                        .and()
                        .equalTo("week", week)
                        .and()
                        .equalTo("dayTxt", "Friday")
                        .findAll();
        //SATURDAY
        RealmResults<RealmSalesTransaction> satQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Refund")
                        .and()
                        .equalTo("year", year)
                        .and()
                        .equalTo("month", month)
                        .and()
                        .equalTo("week", week)
                        .and()
                        .equalTo("dayTxt", "Saturday")
                        .findAll();
        //SUNDAY
        RealmResults<RealmSalesTransaction> sunQuery =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Refund")
                        .and()
                        .equalTo("year", year)
                        .and()
                        .equalTo("month", month)
                        .and()
                        .equalTo("week", week)
                        .and()
                        .equalTo("dayTxt", "Sunday")
                        .findAll();
        listOfWeeklyRefund.add(new BarEntry(1, monQuery.size()));
        listOfWeeklyRefund.add(new BarEntry(2, tueQuery.size()));
        listOfWeeklyRefund.add(new BarEntry(3, wedQuery.size()));
        listOfWeeklyRefund.add(new BarEntry(4, thuQuery.size()));
        listOfWeeklyRefund.add(new BarEntry(5, friQuery.size()));
        listOfWeeklyRefund.add(new BarEntry(6, satQuery.size()));
        listOfWeeklyRefund.add(new BarEntry(7, sunQuery.size()));
        return listOfWeeklyRefund;
    }

    public static List<BarEntry> getDailySales(Realm realm, String year, String month, String week, String day){
        List<BarEntry> listOfDailySales = new ArrayList<>();
        //6AM - 8AM
        RealmResults<RealmSalesTransaction> gozenRokuJi =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Sales")
                        .and().equalTo("year", year)
                        .and().equalTo("month", month)
                        .and().equalTo("week", week)
                        .and().equalTo("dayNo", day)
                        .and().equalTo("hour", "06")
                        .or()
                        .equalTo("transactionType", "Sales")
                        .and().equalTo("year", year)
                        .and().equalTo("month", month)
                        .and().equalTo("week", week)
                        .and().equalTo("dayNo", day)
                        .and().equalTo("hour", "07")
                        .or()
                        .equalTo("transactionType", "Sales")
                        .and().equalTo("year", year)
                        .and().equalTo("month", month)
                        .and().equalTo("week", week)
                        .and().equalTo("dayNo", day)
                        .and().equalTo("hour", "08")
                        .findAll();
        //9AM - 11AM
        RealmResults<RealmSalesTransaction> gozenKuJi =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Sales")
                        .and().equalTo("year", year)
                        .and().equalTo("month", month)
                        .and().equalTo("week", week)
                        .and().equalTo("dayNo", day)
                        .and().equalTo("hour", "09")
                        .or()
                        .equalTo("transactionType", "Sales")
                        .and().equalTo("year", year)
                        .and().equalTo("month", month)
                        .and().equalTo("week", week)
                        .and().equalTo("dayNo", day)
                        .and().equalTo("hour", "10")
                        .or()
                        .equalTo("transactionType", "Sales")
                        .and().equalTo("year", year)
                        .and().equalTo("month", month)
                        .and().equalTo("week", week)
                        .and().equalTo("dayNo", day)
                        .and().equalTo("hour", "11")
                        .findAll();
        //12PM - 2PM
        RealmResults<RealmSalesTransaction> gogoNiJuuJi =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Sales")
                        .and().equalTo("year", year)
                        .and().equalTo("month", month)
                        .and().equalTo("week", week)
                        .and().equalTo("dayNo", day)
                        .and().equalTo("hour", "12")
                        .or()
                        .equalTo("transactionType", "Sales")
                        .and().equalTo("year", year)
                        .and().equalTo("month", month)
                        .and().equalTo("week", week)
                        .and().equalTo("dayNo", day)
                        .and().equalTo("hour", "13")
                        .or()
                        .equalTo("transactionType", "Sales")
                        .and().equalTo("year", year)
                        .and().equalTo("month", month)
                        .and().equalTo("week", week)
                        .and().equalTo("dayNo", day)
                        .and().equalTo("hour", "14")
                        .findAll();
        //3PM - 5PM
        RealmResults<RealmSalesTransaction> gogoSanJi =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Sales")
                        .and().equalTo("year", year)
                        .and().equalTo("month", month)
                        .and().equalTo("week", week)
                        .and().equalTo("dayNo", day)
                        .and().equalTo("hour", "15")
                        .or()
                        .equalTo("transactionType", "Sales")
                        .and().equalTo("year", year)
                        .and().equalTo("month", month)
                        .and().equalTo("week", week)
                        .and().equalTo("dayNo", day)
                        .and().equalTo("hour", "16")
                        .or()
                        .equalTo("transactionType", "Sales")
                        .and().equalTo("year", year)
                        .and().equalTo("month", month)
                        .and().equalTo("week", week)
                        .and().equalTo("dayNo", day)
                        .and().equalTo("hour", "17")
                        .findAll();
        //6PM - 8PM
        RealmResults<RealmSalesTransaction> gogoRokuJi =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Sales")
                        .and().equalTo("year", year)
                        .and().equalTo("month", month)
                        .and().equalTo("week", week)
                        .and().equalTo("dayNo", day)
                        .and().equalTo("hour", "18")
                        .or()
                        .equalTo("transactionType", "Sales")
                        .and().equalTo("year", year)
                        .and().equalTo("month", month)
                        .and().equalTo("week", week)
                        .and().equalTo("dayNo", day)
                        .and().equalTo("hour", "19")
                        .or()
                        .equalTo("transactionType", "Sales")
                        .and().equalTo("year", year)
                        .and().equalTo("month", month)
                        .and().equalTo("week", week)
                        .and().equalTo("dayNo", day)
                        .and().equalTo("hour", "20")
                        .findAll();
        //9PM - 11PM
        RealmResults<RealmSalesTransaction> gogoKuJi =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Sales")
                        .and().equalTo("year", year)
                        .and().equalTo("month", month)
                        .and().equalTo("week", week)
                        .and().equalTo("dayNo", day)
                        .and().equalTo("hour", "21")
                        .or()
                        .equalTo("transactionType", "Sales")
                        .and().equalTo("year", year)
                        .and().equalTo("month", month)
                        .and().equalTo("week", week)
                        .and().equalTo("dayNo", day)
                        .and().equalTo("hour", "22")
                        .or()
                        .equalTo("transactionType", "Sales")
                        .and().equalTo("year", year)
                        .and().equalTo("month", month)
                        .and().equalTo("week", week)
                        .and().equalTo("dayNo", day)
                        .and().equalTo("hour", "23")
                        .findAll();
        listOfDailySales.add(new BarEntry(1, gozenRokuJi.size()));
        listOfDailySales.add(new BarEntry(2, gozenKuJi.size()));
        listOfDailySales.add(new BarEntry(3, gogoNiJuuJi.size()));
        listOfDailySales.add(new BarEntry(4, gogoSanJi.size()));
        listOfDailySales.add(new BarEntry(5, gogoRokuJi.size()));
        listOfDailySales.add(new BarEntry(6, gogoKuJi.size()));
        return listOfDailySales;
    }
    public static List<BarEntry> getDailyRefund(Realm realm, String year, String month, String week, String day){
        List<BarEntry> listOfDailyRefund = new ArrayList<>();
        //6AM - 8AM
        RealmResults<RealmSalesTransaction> gozenRokuJi =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Refund")
                        .and().equalTo("year", year)
                        .and().equalTo("month", month)
                        .and().equalTo("week", week)
                        .and().equalTo("dayNo", day)
                        .and().equalTo("hour", "06")
                        .or()
                        .equalTo("transactionType", "Refund")
                        .and().equalTo("year", year)
                        .and().equalTo("month", month)
                        .and().equalTo("week", week)
                        .and().equalTo("dayNo", day)
                        .and().equalTo("hour", "07")
                        .or()
                        .equalTo("transactionType", "Refund")
                        .and().equalTo("year", year)
                        .and().equalTo("month", month)
                        .and().equalTo("week", week)
                        .and().equalTo("dayNo", day)
                        .and().equalTo("hour", "08")
                        .findAll();
        //9AM - 11AM
        RealmResults<RealmSalesTransaction> gozenKuJi =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Refund")
                        .and().equalTo("year", year)
                        .and().equalTo("month", month)
                        .and().equalTo("week", week)
                        .and().equalTo("dayNo", day)
                        .and().equalTo("hour", "09")
                        .or()
                        .equalTo("transactionType", "Refund")
                        .and().equalTo("year", year)
                        .and().equalTo("month", month)
                        .and().equalTo("week", week)
                        .and().equalTo("dayNo", day)
                        .and().equalTo("hour", "10")
                        .or()
                        .equalTo("transactionType", "Refund")
                        .and().equalTo("year", year)
                        .and().equalTo("month", month)
                        .and().equalTo("week", week)
                        .and().equalTo("dayNo", day)
                        .and().equalTo("hour", "11")
                        .findAll();
        //12PM - 2PM
        RealmResults<RealmSalesTransaction> gogoNiJuuJi =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Refund")
                        .and().equalTo("year", year)
                        .and().equalTo("month", month)
                        .and().equalTo("week", week)
                        .and().equalTo("dayNo", day)
                        .and().equalTo("hour", "12")
                        .or()
                        .equalTo("transactionType", "Refund")
                        .and().equalTo("year", year)
                        .and().equalTo("month", month)
                        .and().equalTo("week", week)
                        .and().equalTo("dayNo", day)
                        .and().equalTo("hour", "13")
                        .or()
                        .equalTo("transactionType", "Refund")
                        .and().equalTo("year", year)
                        .and().equalTo("month", month)
                        .and().equalTo("week", week)
                        .and().equalTo("dayNo", day)
                        .and().equalTo("hour", "14")
                        .findAll();
        //3PM - 5PM
        RealmResults<RealmSalesTransaction> gogoSanJi =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Refund")
                        .and().equalTo("year", year)
                        .and().equalTo("month", month)
                        .and().equalTo("week", week)
                        .and().equalTo("dayNo", day)
                        .and().equalTo("hour", "15")
                        .or()
                        .equalTo("transactionType", "Refund")
                        .and().equalTo("year", year)
                        .and().equalTo("month", month)
                        .and().equalTo("week", week)
                        .and().equalTo("dayNo", day)
                        .and().equalTo("hour", "16")
                        .or()
                        .equalTo("transactionType", "Refund")
                        .and().equalTo("year", year)
                        .and().equalTo("month", month)
                        .and().equalTo("week", week)
                        .and().equalTo("dayNo", day)
                        .and().equalTo("hour", "17")
                        .findAll();
        //6PM - 8PM
        RealmResults<RealmSalesTransaction> gogoRokuJi =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Refund")
                        .and().equalTo("year", year)
                        .and().equalTo("month", month)
                        .and().equalTo("week", week)
                        .and().equalTo("dayNo", day)
                        .and().equalTo("hour", "18")
                        .or()
                        .equalTo("transactionType", "Refund")
                        .and().equalTo("year", year)
                        .and().equalTo("month", month)
                        .and().equalTo("week", week)
                        .and().equalTo("dayNo", day)
                        .and().equalTo("hour", "19")
                        .or()
                        .equalTo("transactionType", "Refund")
                        .and().equalTo("year", year)
                        .and().equalTo("month", month)
                        .and().equalTo("week", week)
                        .and().equalTo("dayNo", day)
                        .and().equalTo("hour", "20")
                        .findAll();
        //9PM - 11PM
        RealmResults<RealmSalesTransaction> gogoKuJi =
                realm.where(RealmSalesTransaction.class)
                        .equalTo("transactionType", "Refund")
                        .and().equalTo("year", year)
                        .and().equalTo("month", month)
                        .and().equalTo("week", week)
                        .and().equalTo("dayNo", day)
                        .and().equalTo("hour", "21")
                        .or()
                        .equalTo("transactionType", "Refund")
                        .and().equalTo("year", year)
                        .and().equalTo("month", month)
                        .and().equalTo("week", week)
                        .and().equalTo("dayNo", day)
                        .and().equalTo("hour", "22")
                        .or()
                        .equalTo("transactionType", "Refund")
                        .and().equalTo("year", year)
                        .and().equalTo("month", month)
                        .and().equalTo("week", week)
                        .and().equalTo("dayNo", day)
                        .and().equalTo("hour", "23")
                        .findAll();
        listOfDailyRefund.add(new BarEntry(1, gozenRokuJi.size()));
        listOfDailyRefund.add(new BarEntry(2, gozenKuJi.size()));
        listOfDailyRefund.add(new BarEntry(3, gogoNiJuuJi.size()));
        listOfDailyRefund.add(new BarEntry(4, gogoSanJi.size()));
        listOfDailyRefund.add(new BarEntry(5, gogoRokuJi.size()));
        listOfDailyRefund.add(new BarEntry(6, gogoKuJi.size()));
        return listOfDailyRefund;
    }
}
