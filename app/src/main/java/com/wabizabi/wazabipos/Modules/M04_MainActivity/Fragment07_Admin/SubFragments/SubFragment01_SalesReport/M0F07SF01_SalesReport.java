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
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.charts.BarChart;
import com.wabizabi.wazabipos.Database.ObjectSchemas.PopCombination;
import com.wabizabi.wazabipos.Database.ObjectSchemas.PopItem;
import com.wabizabi.wazabipos.Database.ObjectSchemas.SalesTransaction;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Libraries.Bundles.DialogBundle;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.ChartHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.DateHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.DialogHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.LayoutHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.StringHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import io.realm.Realm;

public class M0F07SF01_SalesReport extends Fragment {
    //--DATABASE--//
    Realm realm = Realm.getDefaultInstance();

    //--HEADER--//
    ImageView settingsBtn;

    //--CHART--//
    TextView salesDate;
    BarChart salesChart;
    List<SalesTransaction> listOfSales;
    TextView salesGross, salesNet, salesQty;
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
    ImageView srDG01_SubDisplayBtn,
              srDG01_SubYearBtn,
              srDG01_SubMonthBtn,
              srDG01_SubWeekBtn,
              srDG01_SubDayBtn;
    TextView srDG01_Display,
             srDG01_Year,
             srDG01_Month,
             srDG01_Week,
             srDG01_Day;
    ImageView srDG01_AddDisplayBtn,
              srDG01_AddYearBtn,
              srDG01_AddMonthBtn,
              srDG01_AddWeekBtn,
              srDG01_AddDayBtn;
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
        salesChart = v.findViewById(R.id.M04F07SF01_Chart);
        salesGross = v.findViewById(R.id.M04F07SF01_GrossSalesNo);
        salesNet = v.findViewById(R.id.M04F07SF01_NetSalesNo);
        salesQty = v.findViewById(R.id.M04F07SF01_TranscationsCountNo);
        statisticText = v.findViewById(R.id.M04F07SF01_StatisticsText);
        popItemsRV = v.findViewById(R.id.M04F07SF01_PopularItemRV);
        popCombosRV = v.findViewById(R.id.M04F07SF01_PopularCombinationRV);

        init_Dialogs();
        load_Header(currentYear, currentMonth, currentWeek, currentDay);
        load_Chart("Daily", currentYear, currentMonth, currentWeek, currentDay);

    }

    private void load_Header(String year, String month, String week, String day){
        String text
                = (!year.equals("N/A") && !month.equals("N/A") && week.equals("N/A") && day.equals("N/A"))
                ? "「 " + DateHelper.getMonthOfTheYear(month) + " " + year + " 」"
                : (!year.equals("N/A") && !month.equals("N/A") && !week.equals("N/A") && day.equals("N/A"))
                ?  "「 " + "Week " + week + ", " + DateHelper.getMonthOfTheYear(month) + " " + year + " 」"
                : (!year.equals("N/A") && !month.equals("N/A") && !week.equals("N/A") && !day.equals(currentDay))
                ? "「 " + "Week " + week + ", " + DateHelper.getMonthOfTheYear(month) + " " + day + " " + year + " 」"
                : "「 Today 」";
        salesDate.setText(text);

        settingsBtn.setOnClickListener(settings -> {
            load_DG01Functionalities(new DialogBundle(year, month, week, day));
        });
    }

    private void load_Chart(String viewType, String year, String month, String week, String day){
        List<SalesTransaction> salesList
                 = (!viewType.equals("N/A") && !year.equals("N/A") && month.equals("N/A") && week.equals("N/A") && day.equals("N/A"))
                 ? ChartHelper.getYearlyView(realm, year)
                 : (!viewType.equals("N/A") && !year.equals("N/A") && !month.equals("N/A") && week.equals("N/A") && day.equals("N/A"))
                 ? ChartHelper.getMonthlyView(realm, year, month)
                 : (!viewType.equals("N/A") && !year.equals("N/A") && !month.equals("N/A") && !week.equals("N/A") && day.equals("N/A"))
                 ? ChartHelper.getWeeklyView(realm, year, month, week)
                 : ChartHelper.getDailyView(realm, year, month, week, day);

        //Prepare Variables
        double gross = 0.00;
        double net = 0.00;
        for(SalesTransaction sale : salesList){
            if(sale.getTransactionType().equals("Sales")) {
                gross += sale.getTotalSubTotal();
                net += sale.getTotalAmountDue();
            } else {
                gross -= sale.getTotalSubTotal();
                net -= sale.getTotalAmountDue();
            }

        }
        String transactionsGross = StringHelper.convertToCurrency(gross);
        String transactionsNet = StringHelper.convertToCurrency(net);
        String transactionsQty = String.valueOf(salesList.size());

        //Set Views
        salesGross.setText(transactionsGross);
        salesNet.setText(transactionsNet);
        salesQty.setText(transactionsQty);
    }

    private void load_Statistics(String year, String month){

    }

    private void init_Dialogs(){

        srDG01 = DialogHelper.create(getActivity(), R.layout.act04_main_frag07_admin_subfrag01_salesreport_dg01_searchsettings);
        srDG01_SubDisplayBtn = srDG01.findViewById(R.id.M04F07SF01D01_DisplaySubBtn);
        srDG01_SubYearBtn = srDG01.findViewById(R.id.M04F07SF01D01_YearSubBtn);
        srDG01_SubMonthBtn = srDG01.findViewById(R.id.M04F07SF01D01_MonthSubBtn);
        srDG01_SubWeekBtn = srDG01.findViewById(R.id.M04F07SF01D01_WeekSubBtn);
        srDG01_SubDayBtn = srDG01.findViewById(R.id.M04F07SF01D01_DaySubBtn);
        srDG01_Display = srDG01.findViewById(R.id.M04F07SF01D01_DisplayInput);
        srDG01_Year = srDG01.findViewById(R.id.M04F07SF01D01_YearInput);
        srDG01_Month = srDG01.findViewById(R.id.M04F07SF01D01_MonthInput);
        srDG01_Week = srDG01.findViewById(R.id.M04F07SF01D01_WeekInput);
        srDG01_Day = srDG01.findViewById(R.id.M04F07SF01D01_DayInput);
        srDG01_AddDisplayBtn = srDG01.findViewById(R.id.M04F07SF01D01_DisplayAddBtn);
        srDG01_AddYearBtn = srDG01.findViewById(R.id.M04F07SF01D01_YearAddBtn);
        srDG01_AddMonthBtn = srDG01.findViewById(R.id.M04F07SF01D01_MonthAddBtn);
        srDG01_AddWeekBtn = srDG01.findViewById(R.id.M04F07SF01D01_WeekAddBtn);
        srDG01_AddDayBtn = srDG01.findViewById(R.id.M04F07SF01D01_DayAddBtn);
        srDG01_ConfirmBtn = srDG01.findViewById(R.id.M04F07SF01D01_ConfirmBtn);
        closeDG01Btn = srDG01.findViewById(R.id.M04F07SF01D01_CloseDGBtn);
    }

    private void load_DG01Functionalities(DialogBundle bundle){


    }
}
