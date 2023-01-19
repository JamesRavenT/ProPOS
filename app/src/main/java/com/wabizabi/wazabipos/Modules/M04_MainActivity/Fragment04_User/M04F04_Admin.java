package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_User;

import static com.wabizabi.wazabipos.Modules.M02_UserVerification.Fragments.M02F02_UserLogIn.operationForM02F02;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_User.Operations.M04F04OP_Management.operationForM04F04;

import android.app.Dialog;
import android.content.Intent;
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
import com.wabizabi.wazabipos.Database.RealmSchemas.InventoryTransaction;
import com.wabizabi.wazabipos.Database.RealmSchemas.SalesTransaction;
import com.wabizabi.wazabipos.Modules.M02_UserVerification.M02_UserVerification;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_User.Operations.M04F04OP_Management;
import com.wabizabi.wazabipos.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

public class M04F04_Admin extends Fragment {
    Realm realm = Realm.getDefaultInstance();
    String year, month, day;
    //--HEADER--//
    ImageButton settingsBtn;
    //--SALES REPORT--//
    TextView numberOfSales, viewMoreSalesReportButton;
    BarChart chart;
    //--TRANSACTION--//
    TextView recentSalesTransactionText, viewMoreSalesTransactionButton;
    TextView recentInventoryTranscationText, viewMoreInventoryTransactionButton;
    //--DIALOG--//
    Dialog settingsDialog;
    TextView changeUsername, changePassword;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag04_admin, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        init_Views(v);
        init_Dialogs();
        init_CurrentDate();
        init_SalesReport();
        init_Transactions();
        init_Buttons();
    }

    private void init_Views(View v){
        numberOfSales = v.findViewById(R.id.M04F04_SalesReportCurrentDateSalesNumber);
        settingsBtn = v.findViewById(R.id.M04F04_SettingsButton);
        chart = v.findViewById(R.id. M04F04_SalesReportChart);

        viewMoreSalesReportButton = v.findViewById(R.id.M04F04_SalesReportViewMoreButton);
        viewMoreSalesTransactionButton = v.findViewById(R.id.M04F04_SalesTransactionViewMoreButton);
        viewMoreInventoryTransactionButton = v.findViewById(R.id.M04F04_InventoryTransactionViewMoreButton);
        recentSalesTransactionText = v.findViewById(R.id.M04F04_SalesTransactionRecentTransactionText);
        recentInventoryTranscationText = v.findViewById(R.id.M04F04_InventoryTransactionRecentTransactionText);
    }

    private void init_Dialogs(){
        settingsDialog = new Dialog(getActivity());
        settingsDialog.setContentView(R.layout.act04_main_frag04_admin_window_settingsdialog);
        settingsDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        changeUsername = settingsDialog.findViewById(R.id.M04F04WDS_ChangeUsernameText);
        changePassword = settingsDialog.findViewById(R.id.M04F04WDS_ChangePasswordText);
        changeUsername.setOnClickListener(v -> {
            operationForM02F02 = "Change Username";
            settingsDialog.dismiss();
            startActivity(new Intent(getActivity(), M02_UserVerification.class));
        });
        changePassword.setOnClickListener(v -> {
            operationForM02F02 = "Change Password";
            settingsDialog.dismiss();
            startActivity(new Intent(getActivity(), M02_UserVerification.class));
        });
    }
    private void init_CurrentDate(){
        DateFormat currentYear = new SimpleDateFormat("yyyy");
        DateFormat currentMonth = new SimpleDateFormat("MMMM");
        DateFormat currentDay = new SimpleDateFormat("d");
        year = currentYear.format(new Date());
        month = currentMonth.format(new Date());
        day = currentDay.format(new Date());
    }

    private void init_SalesReport(){
        RealmResults<SalesTransaction> transactions = realm.where(SalesTransaction.class)
                .equalTo("year", year)
                .and()
                .equalTo("month", month)
                .and()
                .equalTo("dayNumber", day)
                .findAll();
        numberOfSales.setText(String.valueOf(transactions.size()));

        String[] timeSlots = new String[] {
                "11AM", //0
                "1PM",  //1
                "3PM",  //2
                "5PM",  //3
                "7PM",  //4
        };

        RealmResults<SalesTransaction> set01 = realm.where(SalesTransaction.class)
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
        RealmResults<SalesTransaction> set02 = realm.where(SalesTransaction.class)
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
        RealmResults<SalesTransaction> set03 = realm.where(SalesTransaction.class)
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
        RealmResults<SalesTransaction> set04 = realm.where(SalesTransaction.class)
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
        RealmResults<SalesTransaction> set05 = realm.where(SalesTransaction.class)
                .equalTo("year", year)
                .and()
                .equalTo("month", month)
                .and()
                .equalTo("dayNumber", day)
                .and()
                .equalTo("hour", "19")
                .or()
                .equalTo("year", year)
                .and()
                .equalTo("month", month)
                .and()
                .equalTo("dayNumber", day)
                .and()
                .equalTo("hour", "20")
                .findAll();

        List<BarEntry> dataEntries = new ArrayList<>();
        dataEntries.add(new BarEntry(0, set01.size()));
        dataEntries.add(new BarEntry(1, set02.size()));
        dataEntries.add(new BarEntry(2, set03.size()));
        dataEntries.add(new BarEntry(3, set04.size()));
        dataEntries.add(new BarEntry(4, set05.size()));

        BarDataSet dataSet = new BarDataSet(dataEntries, "DailyData");
        dataSet.setColor(Color.rgb(38, 38, 43));
        BarData data = new BarData();
        data.addDataSet(dataSet);
        chart.setData(data);

        XAxis axis = chart.getXAxis();
        axis.setValueFormatter(new IndexAxisValueFormatter(timeSlots));
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


    private void init_Transactions(){
        SalesTransaction recentSale = realm.where(SalesTransaction.class).sort("timestamp", Sort.DESCENDING).findFirst();
        InventoryTransaction recentInventory = realm.where(InventoryTransaction.class).sort("timestamp", Sort.DESCENDING).findFirst();
        if(recentSale != null){
            recentSalesTransactionText.setText(recentSale.getMonth() + " " + recentSale.getDayNumber() + ", " + recentSale.getYear() + " at " + recentSale.getTime());
        } else {
            recentSalesTransactionText.setText("N / A");
        }
        if(recentInventory != null){
            recentInventoryTranscationText.setText(recentInventory.getMonth() + " " + recentInventory.getDay() + ", " + recentInventory.getYear() + " at " + recentInventory.getTime());
        } else {
            recentInventoryTranscationText.setText("N / A");
        }

    }

    private void init_Buttons(){
        settingsBtn.setOnClickListener(v -> {
            settingsDialog.show();
        });
        viewMoreSalesReportButton.setOnClickListener(v -> {
            operationForM04F04 = "View Sales Report";
            startActivity(new Intent(getActivity(), M04F04OP_Management.class));
        });
        viewMoreSalesTransactionButton.setOnClickListener(v -> {
            operationForM04F04 = "View Sale Transactions List";
            startActivity(new Intent(getActivity(), M04F04OP_Management.class));
        });
        viewMoreInventoryTransactionButton.setOnClickListener(v -> {
            operationForM04F04 = "View Inventory Transactions List";
            startActivity(new Intent(getActivity(), M04F04OP_Management.class));
        });
    }
}
