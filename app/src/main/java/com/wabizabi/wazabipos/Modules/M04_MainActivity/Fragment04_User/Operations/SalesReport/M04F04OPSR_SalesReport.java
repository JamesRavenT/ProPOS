package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_User.Operations.SalesReport;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.wabizabi.wazabipos.Database.Schemas.SalesTransaction;
import com.wabizabi.wazabipos.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class M04F04OPSR_SalesReport extends Fragment {
    Realm realm;
    ImageButton settingsBtn, prevBtn, nextBtn;
    TextView displayText, currentText;
    BarChart chart;
    String year, month, week, day;
    String dataToDisplay = "Daily";
    Dialog changeDisplayDialog;
    TextView daily, weekly, monthly, yearly;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag04_admin_operation_management_salesreport, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        init_Views(v);
        init_DBInstance();
        init_Dialog();
        init_CurrentDate();
        init_Chart();
        init_Buttons();
    }

    private void init_Views(View v){
        displayText = v.findViewById(R.id.M04F04OPSR_CurrentDisplayText);
        settingsBtn = v.findViewById(R.id.M04F04OPSR_SettingsButton);
        prevBtn = v.findViewById(R.id.M04F04OPSR_PrevChartButton);
        currentText = v.findViewById(R.id.M04F04OPSR_CurrentChartText);
        nextBtn = v.findViewById(R.id.M04F04OPSR_NextChartButton);
        chart = v.findViewById(R.id.M04F04OPSR_Chart);
    }

    private void init_DBInstance(){
        realm = Realm.getDefaultInstance();
    }

    private void init_Dialog(){
        changeDisplayDialog = new Dialog(getActivity());
        changeDisplayDialog.setContentView(R.layout.act04_main_frag04_admin_operation_management_salesreport_window_changedialog);
        changeDisplayDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        daily = changeDisplayDialog.findViewById(R.id.M04F04OPSRDC_DailyText);
        weekly = changeDisplayDialog.findViewById(R.id.M04F04OPSRDC_DailyText);
        monthly = changeDisplayDialog.findViewById(R.id.M04F04OPSRDC_MonthlyText);
        yearly = changeDisplayDialog.findViewById(R.id.M04F04OPSRDC_YearlyText);
        daily.setOnClickListener(v -> {
            dataToDisplay = "Daily";
            init_Chart();
            changeDisplayDialog.dismiss();
        });
        weekly.setOnClickListener(v -> {
            dataToDisplay = "Weekly";
            init_Chart();
            changeDisplayDialog.dismiss();
        });
        monthly.setOnClickListener(v -> {
            dataToDisplay = "Monthly";
            init_Chart();
            changeDisplayDialog.dismiss();
        });
        yearly.setOnClickListener(v -> {
            dataToDisplay = "Yearly";
            init_Chart();
            changeDisplayDialog.dismiss();
        });
    }

    private void init_CurrentDate(){
        DateFormat currentYear = new SimpleDateFormat("yyyy");
        DateFormat currentMonth = new SimpleDateFormat("MMM");
        DateFormat currentWeek = new SimpleDateFormat("W");
        DateFormat currentDay = new SimpleDateFormat("d");
        year = currentYear.format(new Date());
        month = currentMonth.format(new Date());
        week = currentWeek.format(new Date());
        day = currentDay.format(new Date());

    }

    private void init_Chart(){
        switch(dataToDisplay){
            case "Daily":
                init_CurrentDate();
                displayText.setText("Daily");
                currentText.setText(month + " " + day + ", " + year);
                set_DailyChart();
                break;
            case "Weekly":
                init_CurrentDate();
                displayText.setText("Weekly");
                currentText.setText("Week " + week + ", " + month + " " +  year);
                set_WeeklyChart();
                break;
            case "Monthly":
                init_CurrentDate();
                displayText.setText("Monthly");
                currentText.setText(month + " " + year);
                set_MonthlyChart();
                break;
            case "Yearly":
                init_CurrentDate();
                displayText.setText("Yearly");
                currentText.setText("Year " + year);
                set_YearlyChart();
                break;
        }
    }

    private void init_Buttons(){
        prevBtn.setOnClickListener(v -> {
            int yearNo = Integer.parseInt(year);
            int weekNo = Integer.parseInt(week);
            int dayNo = Integer.parseInt(day);
            switch(dataToDisplay){
                case "Daily":
                    if(dayNo != 1){
                        day = String.valueOf(dayNo - 1);
                    } else {
                        switch(month){
                            case "January":
                                year = String.valueOf(yearNo - 1);
                                month = "December";
                                day = String.valueOf(31);
                                break;
                            case "February":
                                month = "January";
                                day = String.valueOf(31);
                                break;
                            case "March":
                                month = "February";
                                day = String.valueOf(28);
                                break;
                            case "April":
                                month = "March";
                                day = String.valueOf(31);
                                break;
                            case "May":
                                month = "April";
                                day = String.valueOf(30);
                                break;
                            case "June":
                                month = "May";
                                day = String.valueOf(31);
                                break;
                            case "July":
                                month = "June";
                                day = String.valueOf(30);
                                break;
                            case "August":
                                month = "July";
                                day = String.valueOf(31);
                                break;
                            case "September":
                                month = "August";
                                day = String.valueOf(31);
                                break;
                            case "October":
                                month = "September";
                                day = String.valueOf(30);
                                break;
                            case "November":
                                month = "October";
                                day = String.valueOf(31);
                                break;
                            case "December":
                                month = "November";
                                day = String.valueOf(30);
                                break;
                        }
                    }
                    set_DailyChart();
                    currentText.setText(month + " " + day + ", " + year);

                    break;
                case "Weekly":
                    set_WeeklyChart();
                    if(weekNo != 1){
                        week = String.valueOf(weekNo - 1);
                    } else {
                        switch(month){
                            case "January":
                                year = String.valueOf(yearNo - 1);
                                month = "December";
                                week = String.valueOf(1);
                                break;
                            case "February":
                                month = "January";
                                day = String.valueOf(6);
                                break;
                            case "March":
                                month = "February";
                                week = String.valueOf(6);
                                break;
                            case "April":
                                month = "March";
                                week = String.valueOf(6);;
                                break;
                            case "May":
                                month = "April";
                                week = String.valueOf(6);
                                break;
                            case "June":
                                month = "May";
                                week = String.valueOf(6);
                                break;
                            case "July":
                                month = "June";
                                week = String.valueOf(6);
                                break;
                            case "August":
                                month = "July";
                                week = String.valueOf(6);
                                break;
                            case "September":
                                month = "August";
                                week = String.valueOf(6);
                                break;
                            case "October":
                                month = "September";
                                week = String.valueOf(6);
                                break;
                            case "November":
                                month = "October";
                                week = String.valueOf(6);
                                break;
                            case "December":
                                month = "November";
                                week = String.valueOf(6);
                                break;
                        }
                    }
                    set_WeeklyChart();
                    currentText.setText("Week " + week + ", " + month + " " +  year);
                    break;
                case "Monthly":
                    switch(month){
                        case "January":
                            year = String.valueOf(yearNo - 1);
                            month = "December";
                            break;
                        case "February":
                            month = "January";
                            break;
                        case "March":
                            month = "February";
                            break;
                        case "April":
                            month = "March";
                            break;
                        case "May":
                            month = "April";
                            break;
                        case "June":
                            month = "May";
                            break;
                        case "July":
                            month = "June";
                            break;
                        case "August":
                            month = "July";
                            break;
                        case "September":
                            month = "August";
                            break;
                        case "October":
                            month = "September";
                            break;
                        case "November":
                            month = "October";
                            break;
                        case "December":
                            month = "November";
                            break;
                    }
                    set_MonthlyChart();
                    currentText.setText(month + " " + year);
                    break;
                case "Yearly":
                    year = String.valueOf(yearNo - 1);
                    set_YearlyChart();
                    currentText.setText("Year " + year);
                    break;
            }
        });

        nextBtn.setOnClickListener(v -> {
            int yearNo = Integer.parseInt(year);
            int weekNo = Integer.parseInt(week);
            int dayNo = Integer.parseInt(day);
            switch(dataToDisplay){
                case "Daily":
                    switch(month){
                        case "January":
                            if(dayNo != 31) {
                                day = String.valueOf(dayNo + 1);
                            } else {
                                day = String.valueOf(1);
                                month = "February";
                            }
                            break;
                        case "February":
                            if(dayNo != 28) {
                                day = String.valueOf(dayNo + 1);
                            } else {
                                day = String.valueOf(1);
                                month = "March";
                            }
                            break;
                        case "March":
                            if(dayNo != 31) {
                                day = String.valueOf(dayNo + 1);
                            } else {
                                day = String.valueOf(1);
                                month = "April";
                            }
                            break;
                        case "April":
                            if(dayNo != 30) {
                                day = String.valueOf(dayNo + 1);
                            } else {
                                day = String.valueOf(1);
                                month = "May";
                            }
                            break;
                        case "May":
                            if(dayNo != 31) {
                                day = String.valueOf(dayNo + 1);
                            } else {
                                day = String.valueOf(1);
                                month = "June";
                            }
                            break;
                        case "June":
                            if(dayNo != 30) {
                                day = String.valueOf(dayNo + 1);
                            } else {
                                day = String.valueOf(1);
                                month = "July";
                            }
                            break;
                        case "July":
                            if(dayNo != 31) {
                                day = String.valueOf(dayNo + 1);
                            } else {
                                day = String.valueOf(1);
                                month = "August";
                            }
                            break;
                        case "August":
                            if(dayNo != 31) {
                                day = String.valueOf(dayNo + 1);
                            } else {
                                day = String.valueOf(1);
                                month = "September";
                            }
                            break;
                        case "September":
                            if(dayNo != 30) {
                                day = String.valueOf(dayNo + 1);
                            } else {
                                day = String.valueOf(1);
                                month = "October";
                            }
                            break;
                        case "October":
                            if(dayNo != 31) {
                                day = String.valueOf(dayNo + 1);
                            } else {
                                day = String.valueOf(1);
                                month = "November";
                            }
                            break;
                        case "November":
                            if(dayNo != 30) {
                                day = String.valueOf(dayNo + 1);
                            } else {
                                day = String.valueOf(1);
                                month = "December";
                            }
                            break;
                        case "December":
                            if(dayNo != 31) {
                                day = String.valueOf(dayNo + 1);
                            } else {
                                day = String.valueOf(1);
                                year = String.valueOf(yearNo + 1);
                                month = "January";
                            }
                            break;
                    }
                    set_DailyChart();
                    currentText.setText(month + " " + day + ", " + year);
                    break;
                case "Weekly":
                    if(weekNo != 6){
                        week = String.valueOf(weekNo + 1);
                    } else {
                        switch(month){
                            case "January":
                                month = "February";
                                week = String.valueOf(1);
                                break;
                            case "February":
                                month = "March";
                                week = String.valueOf(1);
                                break;
                            case "March":
                                month = "April";
                                week = String.valueOf(1);
                                break;
                            case "April":
                                month = "May";
                                week = String.valueOf(1);
                                break;
                            case "May":
                                month = "June";
                                week = String.valueOf(1);
                                break;
                            case "June":
                                month = "July";
                                week = String.valueOf(1);
                                break;
                            case "July":
                                month = "August";
                                week = String.valueOf(1);
                                break;
                            case "August":
                                month = "September";
                                week = String.valueOf(1);
                                break;
                            case "September":
                                month = "October";
                                week = String.valueOf(1);
                                break;
                            case "October":
                                month = "November";
                                week = String.valueOf(1);
                                break;
                            case "November":
                                month = "December";
                                week = String.valueOf(1);
                                break;
                            case "December":
                                year = String.valueOf(yearNo + 1);
                                month = "January";
                                week = String.valueOf(1);
                                break;
                        }
                    }
                    set_WeeklyChart();
                    currentText.setText("Week " + week + ", " + month + " " +  year);
                    break;
                case "Monthly":
                    switch(month){
                        case "January":
                            month = "February";
                            break;
                        case "February":
                            month = "March";
                            break;
                        case "March":
                            month = "April";
                            break;
                        case "April":
                            month = "May";
                            break;
                        case "May":
                            month = "June";
                            break;
                        case "June":
                            month = "July";
                            break;
                        case "July":
                            month = "August";
                            break;
                        case "August":
                            month = "September";
                            break;
                        case "September":
                            month = "October";
                            break;
                        case "October":
                            month = "November";
                            break;
                        case "November":
                            month = "December";
                            break;
                        case "December":
                            year = String.valueOf(yearNo + 1);
                            month = "January";
                            break;
                    }
                    set_MonthlyChart();
                    currentText.setText(month + " " + year);
                    break;
                case "Yearly":
                    year = String.valueOf(yearNo + 1);
                    set_YearlyChart();
                    currentText.setText("Year " + year);
                    break;
            }
        });
    }

    private void set_DailyChart(){

        String[] hours = new String[] {
                "11AM",
                "1PM",
                "3PM",
                "5PM",
                "7PM",
        };

        RealmResults<SalesTransaction> dailyDataSet01 = realm.where(SalesTransaction.class)
                .equalTo("year", year)
                .and()
                .equalTo("month", month)
                .and()
                .equalTo("dayNumber", day)
                .and()
                .equalTo("hour", "11")
                .or()
                .equalTo("hour", "12")
                .findAll();
        RealmResults<SalesTransaction> dailyDataSet02 = realm.where(SalesTransaction.class)
                .equalTo("year", year)
                .and()
                .equalTo("month", month)
                .and()
                .equalTo("dayNumber", day)
                .and()
                .equalTo("hour", "13")
                .or()
                .equalTo("hour", "14")
                .findAll();
        RealmResults<SalesTransaction> dailyDataSet03 = realm.where(SalesTransaction.class)
                .equalTo("year", year)
                .and()
                .equalTo("month", month)
                .and()
                .equalTo("dayNumber", day)
                .and()
                .equalTo("hour", "15")
                .or()
                .equalTo("hour", "16")
                .findAll();
        RealmResults<SalesTransaction> dailyDataSet04 = realm.where(SalesTransaction.class)
                .equalTo("year", year)
                .and()
                .equalTo("month", month)
                .and()
                .equalTo("dayNumber", day)
                .and()
                .equalTo("hour", "17")
                .or()
                .equalTo("hour", "18")
                .findAll();
        RealmResults<SalesTransaction> dailyDataSet05 = realm.where(SalesTransaction.class)
                .equalTo("year", year)
                .and()
                .equalTo("month", month)
                .and()
                .equalTo("dayNumber", day)
                .and()
                .equalTo("hour", "19")
                .or()
                .equalTo("hour", "20")
                .findAll();

        List<BarEntry> dataEntries = new ArrayList<>();
        dataEntries.add(new BarEntry(0, dailyDataSet01.size()));
        dataEntries.add(new BarEntry(1, dailyDataSet02.size()));
        dataEntries.add(new BarEntry(2, dailyDataSet03.size()));
        dataEntries.add(new BarEntry(3, dailyDataSet04.size()));
        dataEntries.add(new BarEntry(4, dailyDataSet05.size()));

        BarDataSet dataSet = new BarDataSet(dataEntries, "DailyData");
        dataSet.setColor(Color.rgb(38, 38, 43));
        BarData data = new BarData();
        data.addDataSet(dataSet);
        chart.setData(data);

        XAxis axis = chart.getXAxis();
        axis.setValueFormatter(new IndexAxisValueFormatter(hours));
        axis.setPosition(XAxis.XAxisPosition.BOTTOM);
        axis.setGranularity(1);
        axis.setGranularityEnabled(true);

        chart.setDragEnabled(true);
        chart.setVisibleXRangeMaximum(3);

        chart.getDescription().setEnabled(false);
        chart.getLegend().setEnabled(false);
        chart.getXAxis().setDrawGridLines(false);
        chart.getAxisLeft().setDrawGridLines(false);

        chart.invalidate();

    }

    private void set_WeeklyChart(){
        String[] days = new String[] {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        };

        RealmResults<SalesTransaction> weeklyDataSet01 = realm.where(SalesTransaction.class)
                .equalTo("year", year)
                .and()
                .equalTo("month", month)
                .and()
                .equalTo("week", week)
                .and()
                .equalTo("dayText", "Monday")
                .findAll();
        RealmResults<SalesTransaction> weeklyDataSet02 = realm.where(SalesTransaction.class)
                .equalTo("year", year)
                .and()
                .equalTo("month", month)
                .and()
                .equalTo("week", week)
                .and()
                .equalTo("dayText", "Tuesday")
                .findAll();
        RealmResults<SalesTransaction> weeklyDataSet03 = realm.where(SalesTransaction.class)
                .equalTo("year", year)
                .and()
                .equalTo("month", month)
                .and()
                .equalTo("week", week)
                .and()
                .equalTo("dayText", "Wednesday")
                .findAll();
        RealmResults<SalesTransaction> weeklyDataSet04 = realm.where(SalesTransaction.class)
                .equalTo("year", year)
                .and()
                .equalTo("month", month)
                .and()
                .equalTo("week", week)
                .and()
                .equalTo("dayText", "Thursday")
                .findAll();
        RealmResults<SalesTransaction> weeklyDataSet05 = realm.where(SalesTransaction.class)
                .equalTo("year", year)
                .and()
                .equalTo("month", month)
                .and()
                .equalTo("week", week)
                .and()
                .equalTo("dayText", "Friday")
                .findAll();
        RealmResults<SalesTransaction> weeklyDataSet06 = realm.where(SalesTransaction.class)
                .equalTo("year", year)
                .and()
                .equalTo("month", month)
                .and()
                .equalTo("week", week)
                .and()
                .equalTo("dayText", "Saturday")
                .findAll();
        RealmResults<SalesTransaction> weeklyDataSet07 = realm.where(SalesTransaction.class)
                .equalTo("year", year)
                .and()
                .equalTo("month", month)
                .and()
                .equalTo("week", week)
                .and()
                .equalTo("dayText", "Sunday")
                .findAll();
        List<BarEntry> dataEntries = new ArrayList<>();
        dataEntries.add(new BarEntry(0, weeklyDataSet01.size()));
        dataEntries.add(new BarEntry(1, weeklyDataSet02.size()));
        dataEntries.add(new BarEntry(2, weeklyDataSet03.size()));
        dataEntries.add(new BarEntry(3, weeklyDataSet04.size()));
        dataEntries.add(new BarEntry(4, weeklyDataSet05.size()));
        dataEntries.add(new BarEntry(5, weeklyDataSet06.size()));
        dataEntries.add(new BarEntry(6, weeklyDataSet07.size()));

        BarDataSet dataSet = new BarDataSet(dataEntries, "DailyData");
        dataSet.setColor(Color.rgb(38, 38, 43));
        BarData data = new BarData();
        data.addDataSet(dataSet);
        chart.setData(data);

        XAxis axis = chart.getXAxis();
        axis.setValueFormatter(new IndexAxisValueFormatter(days));
        axis.setPosition(XAxis.XAxisPosition.BOTTOM);
        axis.setGranularity(1);
        axis.setGranularityEnabled(true);

        chart.setDragEnabled(true);
        chart.setVisibleXRangeMaximum(3);

        chart.getDescription().setEnabled(false);
        chart.getLegend().setEnabled(false);
        chart.getXAxis().setDrawGridLines(false);
        chart.getAxisLeft().setDrawGridLines(false);

        chart.invalidate();
    }

    private void set_MonthlyChart(){
        String[] weeks = new String[] {
                "Week 1",
                "Week 2",
                "Week 3",
                "Week 4",
                "Week 5",
                "Week 6"
        };
        RealmResults<SalesTransaction> monthlyDataSet01 = realm.where(SalesTransaction.class)
                .equalTo("year", year)
                .and()
                .equalTo("month", month)
                .and()
                .equalTo("week", "1")
                .findAll();
        RealmResults<SalesTransaction> monthlyDataSet02 = realm.where(SalesTransaction.class)
                .equalTo("year", year)
                .and()
                .equalTo("month", month)
                .and()
                .equalTo("week", "2")
                .findAll();
        RealmResults<SalesTransaction> monthlyDataSet03 = realm.where(SalesTransaction.class)
                .equalTo("year", year)
                .and()
                .equalTo("month", month)
                .and()
                .equalTo("week", "3")
                .findAll();
        RealmResults<SalesTransaction> monthlyDataSet04 = realm.where(SalesTransaction.class)
                .equalTo("year", year)
                .and()
                .equalTo("month", month)
                .and()
                .equalTo("week", "4")
                .findAll();
        RealmResults<SalesTransaction> monthlyDataSet05 = realm.where(SalesTransaction.class)
                .equalTo("year", year)
                .and()
                .equalTo("month", month)
                .and()
                .equalTo("week", "5")
                .findAll();
        RealmResults<SalesTransaction> monthlyDataSet06 = realm.where(SalesTransaction.class)
                .equalTo("year", year)
                .and()
                .equalTo("month", month)
                .and()
                .equalTo("week", "6")
                .findAll();

        List<BarEntry> dataEntries = new ArrayList<>();
        dataEntries.add(new BarEntry(0, monthlyDataSet01.size()));
        dataEntries.add(new BarEntry(1, monthlyDataSet02.size()));
        dataEntries.add(new BarEntry(2, monthlyDataSet03.size()));
        dataEntries.add(new BarEntry(3, monthlyDataSet04.size()));
        dataEntries.add(new BarEntry(4, monthlyDataSet05.size()));
        dataEntries.add(new BarEntry(5, monthlyDataSet06.size()));

        BarDataSet dataSet = new BarDataSet(dataEntries, "MonthlyData");
        dataSet.setColor(Color.rgb(38, 38, 43));
        BarData data = new BarData();
        data.addDataSet(dataSet);
        chart.setData(data);

        XAxis axis = chart.getXAxis();
        axis.setValueFormatter(new IndexAxisValueFormatter(weeks));
        axis.setPosition(XAxis.XAxisPosition.BOTTOM);
        axis.setGranularity(1);
        axis.setGranularityEnabled(true);

        chart.setDragEnabled(true);
        chart.setVisibleXRangeMaximum(3);

        chart.getDescription().setEnabled(false);
        chart.getLegend().setEnabled(false);
        chart.getXAxis().setDrawGridLines(false);
        chart.getAxisLeft().setDrawGridLines(false);

        chart.invalidate();
    }

    private void set_YearlyChart(){
        String[] months = new String[] {
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"
        };
        RealmResults<SalesTransaction> yearlyDataSet01 = realm.where(SalesTransaction.class)
                .equalTo("year", "January")
                .findAll();
        RealmResults<SalesTransaction> yearlyDataSet02 = realm.where(SalesTransaction.class)
                .equalTo("year", "February")
                .findAll();
        RealmResults<SalesTransaction> yearlyDataSet03 = realm.where(SalesTransaction.class)
                .equalTo("year", "March")
                .findAll();
        RealmResults<SalesTransaction> yearlyDataSet04 = realm.where(SalesTransaction.class)
                .equalTo("year", "April")
                .findAll();
        RealmResults<SalesTransaction> yearlyDataSet05 = realm.where(SalesTransaction.class)
                .equalTo("year", "May")
                .findAll();
        RealmResults<SalesTransaction> yearlyDataSet06 = realm.where(SalesTransaction.class)
                .equalTo("year", "June")
                .findAll();
        RealmResults<SalesTransaction> yearlyDataSet07 = realm.where(SalesTransaction.class)
                .equalTo("year", "July")
                .findAll();
        RealmResults<SalesTransaction> yearlyDataSet08 = realm.where(SalesTransaction.class)
                .equalTo("year", "August")
                .findAll();
        RealmResults<SalesTransaction> yearlyDataSet09 = realm.where(SalesTransaction.class)
                .equalTo("year", "September")
                .findAll();
        RealmResults<SalesTransaction> yearlyDataSet10 = realm.where(SalesTransaction.class)
                .equalTo("year", "October")
                .findAll();
        RealmResults<SalesTransaction> yearlyDataSet11 = realm.where(SalesTransaction.class)
                .equalTo("year", "November")
                .findAll();
        RealmResults<SalesTransaction> yearlyDataSet12 = realm.where(SalesTransaction.class)
                .equalTo("year", "December")
                .findAll();


        List<BarEntry> dataEntries = new ArrayList<>();
        dataEntries.add(new BarEntry(0, yearlyDataSet01.size()));
        dataEntries.add(new BarEntry(1, yearlyDataSet02.size()));
        dataEntries.add(new BarEntry(2, yearlyDataSet03.size()));
        dataEntries.add(new BarEntry(3, yearlyDataSet04.size()));
        dataEntries.add(new BarEntry(4, yearlyDataSet05.size()));
        dataEntries.add(new BarEntry(5, yearlyDataSet06.size()));
        dataEntries.add(new BarEntry(6, yearlyDataSet07.size()));
        dataEntries.add(new BarEntry(7, yearlyDataSet08.size()));
        dataEntries.add(new BarEntry(8, yearlyDataSet09.size()));
        dataEntries.add(new BarEntry(9, yearlyDataSet10.size()));
        dataEntries.add(new BarEntry(10, yearlyDataSet11.size()));
        dataEntries.add(new BarEntry(11, yearlyDataSet12.size()));

        BarDataSet dataSet = new BarDataSet(dataEntries, "YearlyData");
        dataSet.setColor(Color.rgb(38, 38, 43));
        BarData data = new BarData();
        data.addDataSet(dataSet);
        chart.setData(data);

        XAxis axis = chart.getXAxis();
        axis.setValueFormatter(new IndexAxisValueFormatter(months));
        axis.setPosition(XAxis.XAxisPosition.BOTTOM);
        axis.setGranularity(1);
        axis.setGranularityEnabled(true);

        chart.setDragEnabled(true);
        chart.setVisibleXRangeMaximum(3);

        chart.getDescription().setEnabled(false);
        chart.getLegend().setEnabled(false);
        chart.getXAxis().setDrawGridLines(false);
        chart.getAxisLeft().setDrawGridLines(false);

        chart.invalidate();

    }

}
