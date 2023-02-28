package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment07_Admin.SubFragments.SubFragment01_SalesReport;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.wabizabi.wazabipos.Database.ObjectSchemas.PopCombination;
import com.wabizabi.wazabipos.Database.ObjectSchemas.PopItem;
import com.wabizabi.wazabipos.Database.ObjectSchemas.SalesTransaction;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment07_Admin.SubFragments.SubFragment01_SalesReport.Adapters.M04F07SF01_PopCombosRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment07_Admin.SubFragments.SubFragment01_SalesReport.Adapters.M04F07SF01_PopItemRVA;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Libraries.Bundles.DialogBundle;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment07_Admin.SubFragments.SubFragment01_SalesReport.SRHelper.ChartHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.DateHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.DialogHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.LayoutHelper;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment07_Admin.SubFragments.SubFragment01_SalesReport.SRHelper.StatisticsHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.StringHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import io.realm.Realm;

public class M04F07SF01_SalesReport extends Fragment {
    //--DATABASE--//
    Realm realm = Realm.getDefaultInstance();

    //--HEADER--//
    ImageView settingsBtn;

    //--CHART--//
    TextView salesDate;
    BarChart chart;
    List<SalesTransaction> listOfSales;
    TextView salesGross, salesNet, salesQty;
    List<BarEntry> salesEntries;
    List<BarEntry> refundEntries;
    String currentYear = new SimpleDateFormat("yyyy").format(new Date());
    String currentMonth = new SimpleDateFormat("MM").format(new Date());
    String currentWeek = new SimpleDateFormat("W").format(new Date());
    String currentDay = new SimpleDateFormat("dd").format(new Date());

    //--STATISTICS--//
    TextView statisticText;
    RecyclerView popItemsRV;
    RecyclerView.Adapter popItemsRVA;
    List<PopItem> listOfPopItems;
    RecyclerView popCombosRV;
    RecyclerView.Adapter popCombosRVA;
    List<PopCombination> listOfPopCombos;

    //--DG01--//
    Dialog srDG01;
    TextView srDG01_YearTxt,
            srDG01_MonthTxt,
            srDG01_WeekTxt;
    ImageView srDG01_SubDisplayBtn,
              srDG01_SubYearBtn,
              srDG01_SubMonthBtn,
              srDG01_SubWeekBtn;
    TextView srDG01_Display,
             srDG01_Year,
             srDG01_Month,
             srDG01_Week;
    ImageView srDG01_AddDisplayBtn,
              srDG01_AddYearBtn,
              srDG01_AddMonthBtn,
              srDG01_AddWeekBtn;
    CardView srDG01_ConfirmBtn;
    ImageView closeDG01Btn;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutHelper.inflateFragment(inflater, container, R.layout.act04_main_frag07_admin_subfrag01_salesreport);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        settingsBtn = v.findViewById(R.id.M04F07SF01_SettingsBtn);
        salesDate = v.findViewById(R.id.M04F07SF01_ChartDate);
        chart = v.findViewById(R.id.M04F07SF01_Chart);
        salesGross = v.findViewById(R.id.M04F07SF01_GrossSalesNo);
        salesNet = v.findViewById(R.id.M04F07SF01_NetSalesNo);
        salesQty = v.findViewById(R.id.M04F07SF01_TranscationsCountNo);
        statisticText = v.findViewById(R.id.M04F07SF01_StatisticsText);
        popItemsRV = v.findViewById(R.id.M04F07SF01_PopularItemRV);
        popCombosRV = v.findViewById(R.id.M04F07SF01_PopularCombinationRV);

        init_Dialogs();
        load_Header(currentYear, currentMonth, currentWeek, currentDay);
        load_Chart(currentYear, currentMonth, currentWeek, currentDay);
        load_Statistics(currentYear, currentMonth);
    }

    private void load_Header(String year, String month, String week, String day){
        String text
                = (!year.equals("N/A") && !month.equals("N/A") && week.equals("N/A") && day.equals("N/A"))
                ? "「 " + DateHelper.getMonthName(month) + " " + year + " 」"
                : (!year.equals("N/A") && !month.equals("N/A") && !week.equals("N/A") && day.equals("N/A"))
                ?  "「 " + "Week " + week + ", " + DateHelper.getMonthName(month) + " " + year + " 」"
                : (!year.equals("N/A") && !month.equals("N/A") && !week.equals("N/A") && !day.equals(currentDay))
                ? "「 " + "Week " + week + ", " + DateHelper.getMonthName(month) + " " + day + " " + year + " 」"
                : "「 Today 」";
        salesDate.setText(text);
        settingsBtn.setOnClickListener(settings -> {
            load_DG01Functionalities(new DialogBundle(year, month, week, day));
            srDG01.show();
        });
    }

    private void load_Chart(String year, String month, String week, String day){
        //Load Sales Transactions
        String viewType
                 = (month.equals("N/A") && week.equals("N/A") && day.equals("N/A"))
                 ? "Yearly"
                 : (!month.equals("N/A") && week.equals("N/A") && day.equals("N/A"))
                 ? "Monthly"
                 : (!month.equals("N/A") && !week.equals("N/A") && day.equals("N/A"))
                 ? "Weekly"
                 : "Daily";

        //Load Chart
        switch(viewType){
            case "Yearly":
                load_YearlyReport(realm, viewType, year);
                break;
            case "Monthly":
                load_MonthlyReport(realm, viewType, year, month);
                break;
            case "Weekly":
                load_WeeklyReport(realm, viewType, year, month, week);
                break;
            case "Daily":
                load_DailyReport(realm, viewType, year, month, day);
                break;
        }
        //Prepare Variables
        double gross = 0.00;
        double net = 0.00;
        if(!listOfSales.isEmpty()){
            for(SalesTransaction sale : listOfSales){
                if(sale.getTransactionType().equals("Sales")) {
                    gross += sale.getTotalSubTotal();
                    net += sale.getTotalAmountDue();
                } else {
                    gross -= sale.getTotalSubTotal();
                    net -= sale.getTotalAmountDue();
                }
            }
        }
        String transactionsGross = StringHelper.shortenCurrency(gross);
        String transactionsNet = StringHelper.shortenCurrency(net);
        String transactionsQty = String.valueOf(listOfSales.size());

        //Set Views
        salesGross.setText(transactionsGross);
        salesNet.setText(transactionsNet);
        salesQty.setText(transactionsQty);
    }

    private void load_YearlyReport(Realm realm, String viewType, String year){
        listOfSales = ChartHelper.getYearlyView(realm, year);
        salesEntries = ChartHelper.getYearlySales(realm, year);
        refundEntries = ChartHelper.getYearlyRefund(realm, year);
        String[] chartVariables = ChartHelper.getXVariables(viewType);
        BarDataSet salesData = new BarDataSet(salesEntries, "Sales");
        BarDataSet refundsData = new BarDataSet(refundEntries, "Refunds");
        salesData.setColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
        refundsData.setColor(ContextCompat.getColor(getActivity(), R.color.red));

        init_Chart(salesData, refundsData, chartVariables);
    }

    private void load_MonthlyReport(Realm realm, String viewType, String year, String month){
        listOfSales = ChartHelper.getMonthlyView(realm, year, month);
        salesEntries = ChartHelper.getMonthlySales(realm, year, month);
        refundEntries = ChartHelper.getMonthlyRefund(realm, year, month);
        String[] chartVariables = ChartHelper.getXVariables(viewType);
        BarDataSet salesData = new BarDataSet(salesEntries, "Sales");
        BarDataSet refundsData = new BarDataSet(refundEntries, "Refunds");
        salesData.setColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
        refundsData.setColor(ContextCompat.getColor(getActivity(), R.color.red));

        init_Chart(salesData, refundsData, chartVariables);
    }

    private void load_WeeklyReport(Realm realm, String viewType, String year, String month, String week){
        listOfSales = ChartHelper.getWeeklyView(realm, year, month, week);
        salesEntries = ChartHelper.getWeeklySales(realm, year, month, week);
        refundEntries = ChartHelper.getWeeklyRefund(realm, year, month, week);
        String[] chartVariables = ChartHelper.getXVariables(viewType);
        BarDataSet salesData = new BarDataSet(salesEntries, "Sales");
        BarDataSet refundsData = new BarDataSet(refundEntries, "Refunds");
        salesData.setColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
        refundsData.setColor(ContextCompat.getColor(getActivity(), R.color.red));

        init_Chart(salesData, refundsData, chartVariables);
    }

    private void load_DailyReport(Realm realm, String viewType, String year, String month, String day){
        listOfSales = ChartHelper.getDailyView(realm, year, month, day);
        salesEntries = ChartHelper.getDailySales(realm, year, month, day);
        refundEntries = ChartHelper.getDailyRefund(realm, year, month, day);
        String[] chartVariables = ChartHelper.getXVariables(viewType);
        BarDataSet salesData = new BarDataSet(salesEntries, "Sales");
        BarDataSet refundsData = new BarDataSet(refundEntries, "Refunds");
        salesData.setColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
        refundsData.setColor(ContextCompat.getColor(getActivity(), R.color.red));

        init_Chart(salesData, refundsData, chartVariables);
    }

    private void init_Chart(BarDataSet salesData, BarDataSet refundsData, String[] chartVariables){
        BarData data = new BarData(salesData, refundsData);
        //X AXIS
        XAxis axis = chart.getXAxis();
        axis.setValueFormatter(new IndexAxisValueFormatter(chartVariables));
        axis.setCenterAxisLabels(true);
        axis.setPosition(XAxis.XAxisPosition.BOTTOM);
        axis.setGranularity(1.0f);
        axis.setGranularityEnabled(true);
        axis.setDrawGridLinesBehindData(false);
        axis.setDrawAxisLine(true);
        axis.setAxisLineColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
        //Y AXIS | LEFT
        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setGranularity(1.0f);
        leftAxis.setGranularityEnabled(true);
        leftAxis.setDrawGridLinesBehindData(false);
        leftAxis.setDrawAxisLine(true);
        leftAxis.setAxisLineColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
        leftAxis.setAxisMinimum(0);
        //Y AXIS | RIGHT
        YAxis rightAxis = chart.getAxisRight();
        rightAxis.setEnabled(false);
        //CHART
        float barSpc = 0.1f;
        float grpSpc = 0.3f;
        data.setBarWidth(0.25f);
        chart.setData(data);
        calculateMinMax(chart, listOfSales.size() + 10);
        chart.setDragEnabled(true);
        chart.setVisibleXRangeMaximum(3);
        chart.setMaxVisibleValueCount(5);
        chart.groupBars(0, grpSpc, barSpc);
        chart.getDescription().setEnabled(false);
        chart.invalidate();
    }

    private void calculateMinMax(BarLineChartBase chart, int labelCount) {
        float maxValue = chart.getData().getYMax();
        float minValue = chart.getData().getYMin();

        if ((maxValue - minValue) < labelCount) {
            float diff = labelCount - (maxValue - minValue);
            maxValue = maxValue + diff;
            chart.getAxisLeft().setAxisMaximum(maxValue);
            chart.getAxisLeft().setAxisMinimum(minValue);
        }
    }

    private void load_Statistics(String year, String month){
        //SetView
        statisticText.setText("Statistics - " + year + " " + DateHelper.getMonthName(month));

        //Initialize RecyclerView for PopItems
        listOfPopItems = (year.equals(currentYear) && month.equals(currentMonth))
                       ? StatisticsHelper.getCurrentMonthPopItems()
                       : (!month.equals("N/A"))
                       ? StatisticsHelper.getMonthlyPopItems(realm, year, month)
                       : StatisticsHelper.getYearlyPopItems(realm, year);
        LinearLayoutManager layoutItem = new LinearLayoutManager(getActivity());
        layoutItem.setOrientation(LinearLayoutManager.VERTICAL);
        popItemsRVA = new M04F07SF01_PopItemRVA(getActivity(), realm, listOfPopItems);
        popItemsRV.setAdapter(popItemsRVA);
        popItemsRV.setLayoutManager(layoutItem);

        //Load List Of Pop Combos
        listOfPopCombos = (year.equals(currentYear) && month.equals(currentMonth))
                        ? StatisticsHelper.getCurrentMonthPopCombos()
                        : (!month.equals("N/A"))
                        ? StatisticsHelper.getMonthlyPopCombos(realm, year, month)
                        : StatisticsHelper.getYearlyPopCombos(realm, year);
        LinearLayoutManager layoutCombo = new LinearLayoutManager(getActivity());
        layoutCombo.setOrientation(LinearLayoutManager.VERTICAL);
        popCombosRVA = new M04F07SF01_PopCombosRVA(getActivity(), realm, listOfPopCombos);
        popCombosRV.setAdapter(popCombosRVA);
        popCombosRV.setLayoutManager(layoutCombo);
    }

    private void init_Dialogs(){
        srDG01 = DialogHelper.create(getActivity(), R.layout.act04_main_frag07_admin_subfrag01_salesreport_dg01_searchsettings);
        srDG01_YearTxt = srDG01.findViewById(R.id.M04F07SF01D01_YearText);
        srDG01_MonthTxt = srDG01.findViewById(R.id.M04F07SF01D01_MonthText);
        srDG01_WeekTxt = srDG01.findViewById(R.id.M04F07SF01D01_WeekDayText);
        srDG01_SubDisplayBtn = srDG01.findViewById(R.id.M04F07SF01D01_DisplaySubBtn);
        srDG01_SubYearBtn = srDG01.findViewById(R.id.M04F07SF01D01_YearSubBtn);
        srDG01_SubMonthBtn = srDG01.findViewById(R.id.M04F07SF01D01_MonthSubBtn);
        srDG01_SubWeekBtn = srDG01.findViewById(R.id.M04F07SF01D01_WeekSubBtn);
        srDG01_Display = srDG01.findViewById(R.id.M04F07SF01D01_DisplayInput);
        srDG01_Year = srDG01.findViewById(R.id.M04F07SF01D01_YearInput);
        srDG01_Month = srDG01.findViewById(R.id.M04F07SF01D01_MonthInput);
        srDG01_Week = srDG01.findViewById(R.id.M04F07SF01D01_WeekInput);
        srDG01_AddDisplayBtn = srDG01.findViewById(R.id.M04F07SF01D01_DisplayAddBtn);
        srDG01_AddYearBtn = srDG01.findViewById(R.id.M04F07SF01D01_YearAddBtn);
        srDG01_AddMonthBtn = srDG01.findViewById(R.id.M04F07SF01D01_MonthAddBtn);
        srDG01_AddWeekBtn = srDG01.findViewById(R.id.M04F07SF01D01_WeekAddBtn);
        srDG01_ConfirmBtn = srDG01.findViewById(R.id.M04F07SF01D01_ConfirmBtn);
        closeDG01Btn = srDG01.findViewById(R.id.M04F07SF01D01_CloseDGBtn);
    }

    private void load_DG01Functionalities(DialogBundle bundle){
        //Unpack Bundle
        String year = bundle.getYear();
        String month = DateHelper.getMonthName(bundle.getMonth());
        String week = (bundle.getWeek().equals("N/A"))
                    ? "1"
                    : bundle.getDay();
        String day = (bundle.getDay().equals("N/A"))
                   ? "01"
                   : bundle.getDay();

        //SetViews
        setVisibility(year, month, week);
        srDG01_Display.setText("Daily");
        srDG01_Year.setText(currentYear);
        srDG01_Month.setText(DateHelper.getMonthName(currentMonth));
        srDG01_Week.setText(currentDay);
        srDG01_WeekTxt.setText("Day :");


        //Modify View Type
        srDG01_SubDisplayBtn.setOnClickListener(sub -> {
            String display = srDG01_Display.getText().toString();
            switch (display) {
                case "Daily":
                    srDG01_Display.setText("Yearly");
                    set_YearlyView(year);
                    break;
                case "Weekly":
                    srDG01_Display.setText("Daily");
                    srDG01_WeekTxt.setText("Day :");
                    set_DailyView(year, month, day);
                    break;
                case "Monthly":
                    srDG01_Display.setText("Weekly");
                    srDG01_WeekTxt.setText("Week :");
                    set_WeeklyView(year, month, week);
                    break;
                case "Yearly":
                    srDG01_Display.setText("Monthly");
                    set_MonthlyView(year, month);
                    break;
            }
        });
        srDG01_AddDisplayBtn.setOnClickListener(add -> {
            String display = srDG01_Display.getText().toString();
            switch (display) {
                case "Daily":
                    srDG01_Display.setText("Weekly");
                    srDG01_WeekTxt.setText("Week :");
                    set_WeeklyView(year, month, week);
                    break;
                case "Weekly":
                    srDG01_Display.setText("Monthly");
                    set_MonthlyView(year, month);
                    break;
                case "Monthly":
                    srDG01_Display.setText("Yearly");
                    set_YearlyView(year);
                    break;
                case "Yearly":
                    srDG01_Display.setText("Daily");
                    srDG01_WeekTxt.setText("Day :");
                    set_DailyView(year, month, day);
                    break;
            }
        });

        //Modify Year
        srDG01_SubYearBtn.setOnClickListener(sub -> {
            int yearInt = Integer.parseInt(srDG01_Year.getText().toString());
            yearInt--;
            srDG01_Year.setText(String.valueOf(yearInt));
        });
        srDG01_AddYearBtn.setOnClickListener(add -> {
            int yearInt = Integer.parseInt(srDG01_Year.getText().toString());
            yearInt++;
            srDG01_Year.setText(String.valueOf(yearInt));
        });

        //Modify Month
        srDG01_SubMonthBtn.setOnClickListener(sub -> {
            if(!srDG01_Display.getText().toString().equals("Yearly")) {
                String displayedMonth = DateHelper.getSubMonth(srDG01_Month.getText().toString());
                srDG01_Month.setText(displayedMonth);
                if(srDG01_Display.getText().toString().equals("Weekly")){
                    srDG01_WeekTxt.setText("Week");
                    srDG01_Week.setText("1");
                } else {
                    srDG01_WeekTxt.setText("Day");
                    srDG01_Week.setText("01");
                }
            }
        });
        srDG01_AddMonthBtn.setOnClickListener(add -> {
            if(!srDG01_Display.getText().toString().equals("Yearly")) {
                String displayedMonth = DateHelper.getAddMonth(srDG01_Month.getText().toString());
                srDG01_Month.setText(displayedMonth);
                if(srDG01_Display.getText().toString().equals("Weekly")){
                    srDG01_WeekTxt.setText("Week");
                    srDG01_Week.setText("1");
                } else {
                    srDG01_WeekTxt.setText("Day");
                    srDG01_Week.setText("01");
                }
            }
        });

        //ModifyWeek
        srDG01_SubWeekBtn.setOnClickListener(sub -> {
            if(!srDG01_Display.getText().toString().equals("Yearly") || !srDG01_Display.getText().toString().equals("Monthly")){
                if(srDG01_Display.getText().toString().equals("Weekly")){
                    int weekInt = Integer.parseInt(srDG01_Week.getText().toString());
                    if(weekInt != 1){
                        weekInt--;
                    } else {
                        weekInt = 5;
                    }
                    srDG01_Week.setText(String.valueOf(weekInt));
                } else if (srDG01_Display.getText().toString().equals("Daily")){
                    int dayNo = Integer.parseInt(srDG01_Week.getText().toString());
                    int daysOfTheMonth = DateHelper.getDaysCount(srDG01_Month.getText().toString());
                    if(daysOfTheMonth == 29){
                        if(dayNo == 1) {
                            dayNo = 29;
                        } else {
                            dayNo--;
                        }
                    } else if(daysOfTheMonth == 30){
                        if(dayNo == 1) {
                            dayNo = 30;
                        } else {
                            dayNo--;
                        }
                    } else if(daysOfTheMonth == 31)   {
                        if(dayNo == 1) {
                            dayNo = 31;
                        } else {
                            dayNo--;
                        }
                    }
                    String number = (dayNo <= 9)
                            ? StringHelper.addZero(String.valueOf(dayNo))
                            : String.valueOf(dayNo);
                    srDG01_Week.setText(number);
                }

            }
        });
        srDG01_AddWeekBtn.setOnClickListener(add -> {
            if(!srDG01_Display.getText().toString().equals("Yearly") || !srDG01_Display.getText().toString().equals("Monthly")){
                if(srDG01_Display.getText().toString().equals("Weekly")){
                    int weekInt = Integer.parseInt(srDG01_Week.getText().toString());
                    if(weekInt != 5){
                        weekInt++;
                    } else {
                        weekInt = 1;
                    }
                    srDG01_Week.setText(String.valueOf(weekInt));
                } else if(srDG01_Display.getText().toString().equals("Daily")){
                    int dayNo = Integer.parseInt(srDG01_Week.getText().toString());
                    int daysOfTheMonth = DateHelper.getDaysCount(srDG01_Month.getText().toString());
                    if(daysOfTheMonth == 29){
                        if(dayNo == 29) {
                            dayNo = 1;
                        } else {
                            dayNo++;
                        }
                    } else if(daysOfTheMonth == 30){
                        if(dayNo == 30) {
                            dayNo = 1;
                        } else {
                            dayNo++;
                        }
                    } else if(daysOfTheMonth == 31){
                        if(dayNo == 31) {
                            dayNo = 1;
                        } else {
                            dayNo++;
                        }
                    }
                    String number = (dayNo <= 9)
                            ? StringHelper.addZero(String.valueOf(dayNo))
                            : String.valueOf(dayNo);
                    srDG01_Week.setText(number);
                }
            }
        });

        //On Confirm
        srDG01_ConfirmBtn.setOnClickListener(confirm -> {
            String newYear;
            String newMonth;
            String newWeek;
            String newDay;
            switch(srDG01_Display.getText().toString()){
                case "Daily":
                     newYear = srDG01_Year.getText().toString();
                     newMonth = DateHelper.getMonthNo(srDG01_Month.getText().toString());
                     newDay = srDG01_Week.getText().toString();
                     load_Header(newYear, newMonth, "N/A", newDay);
                     load_Chart(newYear, newMonth, "N/A", newDay);
                     load_Statistics(newYear, newMonth);
                     srDG01.dismiss();
                     break;
                case "Weekly":
                    newYear = srDG01_Year.getText().toString();
                    newMonth = DateHelper.getMonthNo(srDG01_Month.getText().toString());
                    newWeek = srDG01_Week.getText().toString();
                    load_Header(newYear, newMonth, newWeek, "N/A");
                    load_Chart(newYear, newMonth, newWeek, "N/A");
                    load_Statistics(newYear, newMonth);
                    srDG01.dismiss();
                    break;
                case "Monthly":
                    newYear = srDG01_Year.getText().toString();
                    newMonth = DateHelper.getMonthNo(srDG01_Month.getText().toString());
                    load_Header(newYear, newMonth, "N/A", "N/A");
                    load_Chart(newYear, newMonth, "N/A", "N/A");
                    load_Statistics(newYear, newMonth);
                    srDG01.dismiss();
                    break;
                case "Yearly" :
                    newYear = srDG01_Year.getText().toString();
                    load_Header(newYear, "N/A", "N/A", "N/A");
                    load_Chart(newYear, "N/A", "N/A", "N/A");
                    load_Statistics(newYear, "N/A");
                    srDG01.dismiss();
                    break;
            }
        });

        //On Close
        closeDG01Btn.setOnClickListener(close -> {
            srDG01.dismiss();
        });
    }

    private void set_YearlyView(String year){
        //YEAR
        srDG01_YearTxt.setVisibility(View.VISIBLE);
        srDG01_SubYearBtn.setVisibility(View.VISIBLE);
        srDG01_Year.setVisibility(View.VISIBLE);
        srDG01_AddYearBtn.setVisibility(View.VISIBLE);
        srDG01_Year.setText(year);
        //MONTH
        srDG01_MonthTxt.setVisibility(View.INVISIBLE);
        srDG01_SubMonthBtn.setVisibility(View.INVISIBLE);
        srDG01_Month.setVisibility(View.INVISIBLE);
        srDG01_AddMonthBtn.setVisibility(View.INVISIBLE);
        //WEEK
        srDG01_WeekTxt.setVisibility(View.INVISIBLE);
        srDG01_SubWeekBtn.setVisibility(View.INVISIBLE);
        srDG01_Week.setVisibility(View.INVISIBLE);
        srDG01_AddWeekBtn.setVisibility(View.INVISIBLE);

    }

    private void set_MonthlyView(String year, String month){
        //YEAR
        srDG01_YearTxt.setVisibility(View.VISIBLE);
        srDG01_SubYearBtn.setVisibility(View.VISIBLE);
        srDG01_Year.setVisibility(View.VISIBLE);
        srDG01_AddYearBtn.setVisibility(View.VISIBLE);
        srDG01_Year.setText(year);
        //MONTH
        srDG01_MonthTxt.setVisibility(View.VISIBLE);
        srDG01_SubMonthBtn.setVisibility(View.VISIBLE);
        srDG01_Month.setVisibility(View.VISIBLE);
        srDG01_AddMonthBtn.setVisibility(View.VISIBLE);
        srDG01_Month.setText(month);
        //WEEK
        srDG01_WeekTxt.setVisibility(View.INVISIBLE);
        srDG01_SubWeekBtn.setVisibility(View.INVISIBLE);
        srDG01_Week.setVisibility(View.INVISIBLE);
        srDG01_AddWeekBtn.setVisibility(View.INVISIBLE);

    }

    private void set_WeeklyView(String year, String month, String week){
        //YEAR
        srDG01_YearTxt.setVisibility(View.VISIBLE);
        srDG01_SubYearBtn.setVisibility(View.VISIBLE);
        srDG01_Year.setVisibility(View.VISIBLE);
        srDG01_AddYearBtn.setVisibility(View.VISIBLE);
        srDG01_Year.setText(year);
        //MONTH
        srDG01_MonthTxt.setVisibility(View.VISIBLE);
        srDG01_SubMonthBtn.setVisibility(View.VISIBLE);
        srDG01_Month.setVisibility(View.VISIBLE);
        srDG01_AddMonthBtn.setVisibility(View.VISIBLE);
        srDG01_Month.setText(month);
        //WEEK
        srDG01_WeekTxt.setVisibility(View.VISIBLE);
        srDG01_SubWeekBtn.setVisibility(View.VISIBLE);
        srDG01_Week.setVisibility(View.VISIBLE);
        srDG01_AddWeekBtn.setVisibility(View.VISIBLE);
        srDG01_Week.setText("1");
        //WEEK TEXT
        srDG01_WeekTxt.setText("Week :");
    }

    private void set_DailyView(String year, String month, String week){
        //YEAR
        srDG01_YearTxt.setVisibility(View.VISIBLE);
        srDG01_SubYearBtn.setVisibility(View.VISIBLE);
        srDG01_Year.setVisibility(View.VISIBLE);
        srDG01_AddYearBtn.setVisibility(View.VISIBLE);
        srDG01_Year.setText(year);
        //MONTH
        srDG01_MonthTxt.setVisibility(View.VISIBLE);
        srDG01_SubMonthBtn.setVisibility(View.VISIBLE);
        srDG01_Month.setVisibility(View.VISIBLE);
        srDG01_AddMonthBtn.setVisibility(View.VISIBLE);
        srDG01_Month.setText(month);
        //WEEK
        srDG01_WeekTxt.setVisibility(View.VISIBLE);
        srDG01_SubWeekBtn.setVisibility(View.VISIBLE);
        srDG01_Week.setVisibility(View.VISIBLE);
        srDG01_AddWeekBtn.setVisibility(View.VISIBLE);
        srDG01_Week.setText("01");
        //DAY
        srDG01_WeekTxt.setText("Day :");
    }

    private void setVisibility(String year, String month, String week){
        //YEAR
        srDG01_YearTxt.setVisibility(View.VISIBLE);
        srDG01_SubYearBtn.setVisibility(View.VISIBLE);
        srDG01_Year.setVisibility(View.VISIBLE);
        srDG01_AddYearBtn.setVisibility(View.VISIBLE);
        srDG01_Year.setText(year);
        //MONTH
        srDG01_MonthTxt.setVisibility(View.VISIBLE);
        srDG01_SubMonthBtn.setVisibility(View.VISIBLE);
        srDG01_Month.setVisibility(View.VISIBLE);
        srDG01_AddMonthBtn.setVisibility(View.VISIBLE);
        srDG01_Month.setText(month);
        //WEEK
        srDG01_WeekTxt.setVisibility(View.VISIBLE);
        srDG01_SubWeekBtn.setVisibility(View.VISIBLE);
        srDG01_Week.setVisibility(View.VISIBLE);
        srDG01_AddWeekBtn.setVisibility(View.VISIBLE);
        srDG01_Week.setText("01");
        //DAY
        srDG01_WeekTxt.setText("Day :");
    }
}
