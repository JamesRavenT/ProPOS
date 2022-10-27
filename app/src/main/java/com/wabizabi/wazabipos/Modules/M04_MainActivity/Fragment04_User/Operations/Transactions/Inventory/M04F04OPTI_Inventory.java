package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_User.Operations.Transactions.Inventory;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.work.impl.background.systemalarm.SystemAlarmScheduler;

import com.wabizabi.wazabipos.Database.Schemas.InventoryTransaction;
import com.wabizabi.wazabipos.Database.Schemas.SalesTransaction;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_User.Operations.Transactions.Inventory.Adapter.M04F04OPTI_InventoryRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_User.Operations.Transactions.Sales.Adapter.M04F04OPTS_SalesRVA;
import com.wabizabi.wazabipos.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

public class M04F04OPTI_Inventory extends Fragment {
    RealmResults<InventoryTransaction> listOfInventoryTransaction;
    Realm realm = Realm.getDefaultInstance();
    ImageView changeDateButton;
    TextView dateQueryText;
    RecyclerView inventoryRV;
    RecyclerView.Adapter inventoryRVA;
    //--CurrentDate--//
    String year, month, day;
    //--DIALOG--//
    Dialog dateDialog;
    ImageButton subYearBtn,subMonthBtn, subDayBtn;
    TextView yearTxt, monthTxt, dayTxt;
    ImageButton addYearBtn, addMonthBtn, addDayBtn;
    CardView searchBtn;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag04_admin_operation_management_transactions_inventory, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        init_Views(v);
        init_CurrentDate();
        init_Dialog();
        init_RecyclerView();
        init_Buttons();
    }

    private void init_Views(View v){
        changeDateButton = v.findViewById(R.id.M04F04OPTI_CalendarButton);
        dateQueryText = v.findViewById(R.id.M04F04OPTI_DateText);
        inventoryRV = v.findViewById(R.id.M04F04OPTI_RecyclerView);
    }

    private void init_CurrentDate(){
        DateFormat currentYear = new SimpleDateFormat("yyyy");
        DateFormat currentMonth = new SimpleDateFormat("MMMM");
        DateFormat currentDay = new SimpleDateFormat("d");
        year = currentYear.format(new Date());
        month = currentMonth.format(new Date());
        day = currentDay.format(new Date());
    }

    private void init_Dialog(){
        dateDialog = new Dialog(getActivity());
        dateDialog.setContentView(R.layout.act04_main_frag04_admin_operation_management_transactions_inventory_window_searchdialog);
        dateDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        subYearBtn = dateDialog.findViewById(R.id.M04F04OPDQI_SubYearBtn);
        subMonthBtn = dateDialog.findViewById(R.id.M04F04OPDQI_SubMonthBtn);
        subDayBtn = dateDialog.findViewById(R.id.M04F04OPDQI_SubDayBtn);
        yearTxt = dateDialog.findViewById(R.id.M04F04OPDQI_YearText);
        monthTxt = dateDialog.findViewById(R.id.M04F04OPDQI_MonthText);
        dayTxt = dateDialog.findViewById(R.id.M04F04OPDQI_DayText);
        addYearBtn = dateDialog.findViewById(R.id.M04F04OPDQI_AddYearBtn);
        addMonthBtn = dateDialog.findViewById(R.id.M04F04OPDQI_AddMonthBtn);
        addDayBtn = dateDialog.findViewById(R.id.M04F04OPDQI_AddDayBtn);
        searchBtn = dateDialog.findViewById(R.id.M04F04OPDQI_SearchBtn);
        //--INITIALIZE CONTENTS--//
        yearTxt.setText(year);
        monthTxt.setText(month);
        dayTxt.setText(day);
        //--SUB & ADD BUTTONS--//
        subYearBtn.setOnClickListener(v -> {
            int yearNo = Integer.parseInt(yearTxt.getText().toString());
            yearTxt.setText(String.valueOf(yearNo - 1));
        });
        addYearBtn.setOnClickListener(v -> {
            int yearNo = Integer.parseInt(yearTxt.getText().toString());
            yearTxt.setText(String.valueOf(yearNo + 1));
        });
        subMonthBtn.setOnClickListener(v -> {
            String currentMonth = monthTxt.getText().toString();
            switch(currentMonth){
                case "January":
                    monthTxt.setText("None");
                    monthTxt.setTextColor(Color.parseColor("#808080"));
                    dayTxt.setText("None");
                    break;
                case "February":
                    monthTxt.setText("January");
                    dayTxt.setText("None");
                    break;
                case "March":
                    monthTxt.setText("February");
                    dayTxt.setText("None");
                    break;
                case "April":
                    monthTxt.setText("March");
                    dayTxt.setText("None");
                    break;
                case "May":
                    monthTxt.setText("April");
                    dayTxt.setText("None");
                    break;
                case "June":
                    monthTxt.setText("May");
                    dayTxt.setText("None");
                    break;
                case "July":
                    monthTxt.setText("June");
                    dayTxt.setText("None");
                    break;
                case "August":
                    monthTxt.setText("July");
                    dayTxt.setText("None");
                    break;
                case "September":
                    monthTxt.setText("August");
                    dayTxt.setText("None");
                    break;
                case "October":
                    monthTxt.setText("September");
                    dayTxt.setText("None");
                    break;
                case "November":
                    monthTxt.setText("October");
                    dayTxt.setText("None");
                    break;
                case "December":
                    monthTxt.setText("November");
                    dayTxt.setText("None");
                    break;
            }
        });
        addMonthBtn.setOnClickListener(v -> {
            String currentMonth = monthTxt.getText().toString();
            switch(currentMonth){
                case "None":
                    monthTxt.setText("January");
                    monthTxt.setTextColor(Color.parseColor("#26262B"));
                    dayTxt.setText("None");
                    break;
                case "January":
                    monthTxt.setText("February");
                    dayTxt.setText("None");
                    break;
                case "February":
                    monthTxt.setText("March");
                    dayTxt.setText("None");
                    break;
                case "March":
                    monthTxt.setText("April");
                    dayTxt.setText("None");
                    break;
                case "April":
                    monthTxt.setText("May");
                    dayTxt.setText("None");
                    break;
                case "May":
                    monthTxt.setText("June");
                    dayTxt.setText("None");
                    break;
                case "June":
                    monthTxt.setText("July");
                    dayTxt.setText("None");
                    break;
                case "July":
                    monthTxt.setText("August");
                    dayTxt.setText("None");
                    break;
                case "August":
                    monthTxt.setText("September");
                    dayTxt.setText("None");
                    break;
                case "September":
                    monthTxt.setText("October");
                    dayTxt.setText("None");
                    break;
                case "October":
                    monthTxt.setText("November");
                    dayTxt.setText("None");
                    break;
                case "November":
                    monthTxt.setText("December");
                    dayTxt.setText("None");
                    break;
            }
        });
        subDayBtn.setOnClickListener(v -> {
            String dayStatus = dayTxt.getText().toString();
            if(!dayStatus.equals("None")){
                int dayNo = Integer.parseInt(dayStatus);
                if(dayNo == 1){
                    dayTxt.setText("None");
                    dayTxt.setTextColor(Color.parseColor("#808080"));
                } else {
                    dayTxt.setText(String.valueOf(dayNo - 1));
                }
            }

        });
        addDayBtn.setOnClickListener(v -> {
            String monthStatus = monthTxt.getText().toString();
            if(!monthStatus.equals("None")){
                String dayStatus = dayTxt.getText().toString();
                if(dayStatus.equals("None")){
                    dayTxt.setText("1");
                    dayTxt.setTextColor(Color.parseColor("#26262B"));
                } else {
                    int dayNo = Integer.parseInt(dayStatus);
                    switch(monthStatus){
                        case "January":
                        case "March":
                        case "May":
                        case "July":
                        case "August":
                        case "October":
                        case "December":
                            if(dayNo != 31)
                                dayTxt.setText(String.valueOf(dayNo + 1));
                            break;
                        case "April":
                        case "June":
                        case "September":
                        case "November":
                            if(dayNo != 30)
                                dayTxt.setText(String.valueOf(dayNo + 1));
                            break;
                        case "February":
                            if(dayNo != 28)
                                dayTxt.setText(String.valueOf(dayNo + 1));
                    }
                }
            }
        });
        //--CONFIRM QUERY--//
        searchBtn.setOnClickListener(v -> {
            String chosenYear = yearTxt.getText().toString();
            String chosenMonth = monthTxt.getText().toString();
            String chosenDay = dayTxt.getText().toString();
            if(chosenMonth.equals("") && chosenDay.equals("")){
                RealmResults<InventoryTransaction> listOfInventoryTransaction = realm
                        .where(InventoryTransaction.class)
                        .equalTo("year", chosenYear)
                        .sort("timestamp", Sort.DESCENDING)
                        .findAll();
                inventoryRVA = new M04F04OPTI_InventoryRVA(listOfInventoryTransaction, getActivity());
                inventoryRVA.notifyDataSetChanged();
                inventoryRV.setAdapter(inventoryRVA);
                dateQueryText.setText(chosenMonth + " " + chosenDay + ", " + chosenYear);
                dateDialog.dismiss();
                dateQueryText.setText(chosenYear);
                dateDialog.dismiss();
            }
            else if(chosenDay.equals("")){
                RealmResults<InventoryTransaction> listOfInventoryTransaction = realm
                        .where(InventoryTransaction.class)
                        .equalTo("year", chosenYear)
                        .and()
                        .equalTo("month", chosenMonth)
                        .sort("timestamp", Sort.DESCENDING)
                        .findAll();
                inventoryRVA = new M04F04OPTI_InventoryRVA(listOfInventoryTransaction, getActivity());
                inventoryRVA.notifyDataSetChanged();
                inventoryRV.setAdapter(inventoryRVA);
                dateQueryText.setText(chosenMonth + " " + chosenDay + ", " + chosenYear);
                dateDialog.dismiss();
            } else {
                RealmResults<InventoryTransaction> listOfInventoryTransaction = realm
                        .where(InventoryTransaction.class)
                        .equalTo("year", chosenYear)
                        .and()
                        .equalTo("month", chosenMonth)
                        .and()
                        .equalTo("day", chosenDay)
                        .sort("timestamp", Sort.DESCENDING)
                        .findAll();
                inventoryRVA = new M04F04OPTI_InventoryRVA(listOfInventoryTransaction, getActivity());
                inventoryRVA.notifyDataSetChanged();
                inventoryRV.setAdapter(inventoryRVA);
                dateQueryText.setText(chosenMonth + " " + chosenDay + ", " + chosenYear);
                dateDialog.dismiss();
            }
        });
    }

    private void init_RecyclerView(){
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        listOfInventoryTransaction = realm
                .where(InventoryTransaction.class)
                .equalTo("year", year)
                .and()
                .equalTo("month", month)
                .and()
                .equalTo("day", day)
                .sort("timestamp", Sort.DESCENDING)
                .findAll();
        inventoryRVA = new M04F04OPTI_InventoryRVA(listOfInventoryTransaction, getActivity());
        inventoryRV.setLayoutManager(layout);
        inventoryRV.setAdapter(inventoryRVA);
    }

    private void init_Buttons(){
        changeDateButton.setOnClickListener(v -> {
            dateDialog.show();
        });
    }
}
