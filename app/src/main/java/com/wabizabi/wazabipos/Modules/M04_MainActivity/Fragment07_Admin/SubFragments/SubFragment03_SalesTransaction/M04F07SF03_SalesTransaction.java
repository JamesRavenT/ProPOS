package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment07_Admin.SubFragments.SubFragment03_SalesTransaction;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.Instances.OpenTransactionsInstance;
import com.wabizabi.wazabipos.Database.ObjectSchemas.SalesTransaction;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment07_Admin.SubFragments.SubFragment03_SalesTransaction.Adapters.M04F07SF03D02_ViewSalesRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment07_Admin.SubFragments.SubFragment03_SalesTransaction.Adapters.M04F07SF03D04_ViewRefundsRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment07_Admin.SubFragments.SubFragment03_SalesTransaction.Adapters.M04F07SF03_SalesTransactionRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment07_Admin.SubFragments.SubFragment03_SalesTransaction.Helpers.STHelper;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Interfaces.DialogLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.Bundles.DialogBundle;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.DateHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.DialogHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.LayoutHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.StringHelper;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Object.CartItem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import io.realm.Realm;

public class M04F07SF03_SalesTransaction extends Fragment implements DialogLoader {
    //--DATABASE--//
    Realm realm = Realm.getDefaultInstance();

    //--HEADER--//
    ImageView settingsBtn;

    //--SEARCH BAR--//
    EditText searchbar;

    //--RECYCLERVIEW--//
    RecyclerView transactionsRV;
    RecyclerView.Adapter transactionsRVA;
    List<SalesTransaction> listOfSalesTransactions;

    //--DG01 SEARCH SETTINGS--//
    String selectedOrder = "Any";
    Dialog transSalesDG01;
    CardView transSalesDG01_AscendingBtn, transSalesDG01_DescendingBtn;
    ImageView transSalesDG01_subTransBtn,
              transSalesDG01_subOrderBtn,
              transSalesDG01_subYearBtn,
              transSalesDG01_SubMonthBtn,
              transSalesDG01_SubDayBtn;
    TextView transSalesDG01_Trans,
             transSalesDG01_Order,
             transSalesDG01_Year,
             transSalesDG01_Month,
             transSalesDG01_Day;
    ImageView transSalesDG01_addTransBtn,
              transSalesDG01_addOrderBtn,
              transSalesDG01_addYearBtn,
              transSalesDG01_addMonthBtn,
              transSalesDG01_addDayBtn;
    TextView transSalesDG01_ResetBtn;
    CardView transSalesDG01_ConfirmBtn;
    ImageView closeDG01Btn;

    //--DG02 VIEW SALES--//
    Dialog transSalesDG02;
    TextView transSalesDG02_SalesNumber,
            transSalesDG02_OrderType,
            transSalesDG02_TableCustomerDetail,
            transSalesDG02_Cashier;
    RecyclerView transSalesDG02_RecyclerView;
    RecyclerView.Adapter transSalesDG02_RecyclerViewAdapter;
    TextView transSalesDG02_SubTotal,
            transSalesDG02_Tax,
            transSalesDG02_ServiceFee,
            transSalesDG02_Discount,
            transSalesDG02_AmountDue,
            transSalesDG02_PaymentMethod,
            transSalesDG02_AmountRecieved,
            transSalesDG02_Change,
            transSalesDG02_ItemCount,
            transSalesDG02_DateAndTime;
    CardView transSalesDG02_PrintBtn, transSalesDG02_RefundBtn;
    ImageView closeDG02Btn;

    //--DG03 CONFIRM REFUND--//
    Dialog transSalesDG03;
    TextView transSalesDG03_TransNo;
    CardView transSalesDG03_YesBtn, transSalesDG03_NoBtn;
    ImageView closeDG03Btn;

    //--DG04 VIEW REFUND--//
    Dialog transSalesDG04;
    TextView transSalesDG04_SalesNumber,
            transSalesDG04_OrderType,
            transSalesDG04_TableCustomerDetail,
            transSalesDG04_Cashier;
    RecyclerView transSalesDG04_RecyclerView;
    RecyclerView.Adapter transSalesDG04_RecyclerViewAdapter;
    TextView transSalesDG04_SubTotal,
            transSalesDG04_Tax,
            transSalesDG04_ServiceFee,
            transSalesDG04_Discount,
            transSalesDG04_AmountDue,
            transSalesDG04_PaymentMethod,
            transSalesDG04_AmountRecieved,
            transSalesDG04_Change,
            transSalesDG04_ItemCount,
            transSalesDG04_DateAndTime;
    CardView transSalesDG04_PrintBtn;
    ImageView closeDG04Btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutHelper.inflateFragment(inflater, container, R.layout.act04_main_frag07_admin_subfrag03_salestransaction);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        settingsBtn = v.findViewById(R.id.M04F07SF03_FilterBtn);
        searchbar = v.findViewById(R.id.M04F07SF03_SearchBarInput);
        transactionsRV = v.findViewById(R.id.M04F07SF03_RecyclerView);

        init_Dialogs();
        load_Header("Descending", "Any", "Any", "Any", "Any", "Any");
        load_SearchBar();
        load_RecyclerView("Descending", "Any", "Any", "Any", "Any", "Any");
    }

    private void load_Header(String sortOrder, String transactionType, String orderType, String year, String month, String day){
        settingsBtn.setOnClickListener(settings -> {
            load_DG01Functionalities(sortOrder, transactionType, orderType, year, month, day);
            transSalesDG01.show();
        });
    }

    private void load_SearchBar(){
        searchbar.removeTextChangedListener(searchEngine);
        searchbar.setText("");
        searchbar.addTextChangedListener(searchEngine);
    }

    private void load_RecyclerView(String sortOrder, String transactionType, String orderType, String year, String month, String day){
        listOfSalesTransactions = (sortOrder.equals("Ascending"))
                                ? STHelper.getSalesTransactionAscending(realm, transactionType, orderType, year, month, day)
                                : STHelper.getSalesTransactionDescending(realm, transactionType, orderType, year, month, day);
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        transactionsRVA = new M04F07SF03_SalesTransactionRVA(getActivity(), realm, listOfSalesTransactions, this);
        transactionsRV.setAdapter(transactionsRVA);
        transactionsRV.setLayoutManager(layout);
    }

    private void load_FilteredRecyclerView(String input){
        List<SalesTransaction> filteredSalesTransactions = STHelper.getFilteredSalesTransaction(listOfSalesTransactions, input);
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        transactionsRVA = new M04F07SF03_SalesTransactionRVA(getActivity(), realm, filteredSalesTransactions, this);
        transactionsRV.setAdapter(transactionsRVA);
        transactionsRV.setLayoutManager(layout);
    }


    private void init_Dialogs(){
        //--DG01--//
        transSalesDG01 = DialogHelper.create(getActivity(), R.layout.act04_main_frag07_admin_subfrag03_salestransaction_dg01_searchsettings);
        transSalesDG01_AscendingBtn = transSalesDG01.findViewById(R.id.M04F07SF03D01_AscendingBtn);
        transSalesDG01_DescendingBtn = transSalesDG01.findViewById(R.id.M04F07SF03D01_DescendingBtn);

        transSalesDG01_subTransBtn = transSalesDG01.findViewById(R.id.M04F07SF03D01_TransactionSubBtn);
        transSalesDG01_subOrderBtn = transSalesDG01.findViewById(R.id.M04F07SF03D01_OrderSubBtn);
        transSalesDG01_subYearBtn = transSalesDG01.findViewById(R.id.M04F07SF03D01_YearSubBtn);
        transSalesDG01_SubMonthBtn = transSalesDG01.findViewById(R.id.M04F07SF03D01_MonthSubBtn);
        transSalesDG01_SubDayBtn = transSalesDG01.findViewById(R.id.M04F07SF03D01_DaySubBtn);

        transSalesDG01_Trans = transSalesDG01.findViewById(R.id.M04F07SF03D01_TransactionInput);
        transSalesDG01_Order = transSalesDG01.findViewById(R.id.M04F07SF03D01_OrderInput);
        transSalesDG01_Year = transSalesDG01.findViewById(R.id.M04F07SF03D01_YearInput);
        transSalesDG01_Month = transSalesDG01.findViewById(R.id.M04F07SF03D01_MonthInput);
        transSalesDG01_Day = transSalesDG01.findViewById(R.id.M04F07SF03D01_DayInput);

        transSalesDG01_addTransBtn = transSalesDG01.findViewById(R.id.M04F07SF03D01_TransactionAddBtn);
        transSalesDG01_addOrderBtn = transSalesDG01.findViewById(R.id.M04F07SF03D01_OrderAddBtn);
        transSalesDG01_addYearBtn = transSalesDG01.findViewById(R.id.M04F07SF03D01_YearAddBtn);
        transSalesDG01_addMonthBtn = transSalesDG01.findViewById(R.id.M04F07SF03D01_MonthAddBtn);
        transSalesDG01_addDayBtn = transSalesDG01.findViewById(R.id.M04F07SF03D01_DayAddBtn);

        transSalesDG01_ResetBtn = transSalesDG01.findViewById(R.id.M04F07SF03D01_ResetBtn);

        transSalesDG01_ConfirmBtn = transSalesDG01.findViewById(R.id.M04F07SF03D01_ConfirmBtn);
        closeDG01Btn = transSalesDG01.findViewById(R.id.M04F07SF03D01_CloseDGBtn);

        //--DG02--//
        transSalesDG02 = DialogHelper.create(getActivity(), R.layout.act04_main_frag07_admin_subfrag03_salestransaction_dg02_viewsales);
        transSalesDG02_SalesNumber = transSalesDG02.findViewById(R.id.M04F07SF03D02_ReceiptNo);
        transSalesDG02_OrderType = transSalesDG02.findViewById(R.id.M04F07SF03D02_OrderType);
        transSalesDG02_TableCustomerDetail = transSalesDG02.findViewById(R.id.M04F07SF03D02_TableOrCustomer);
        transSalesDG02_Cashier = transSalesDG02.findViewById(R.id.M04F07SF03D02_Cashier);

        transSalesDG02_RecyclerView = transSalesDG02.findViewById(R.id.M04F07SF03D02_ItemsRV);

        transSalesDG02_SubTotal = transSalesDG02.findViewById(R.id.M04F07SF03D02_SubTotalNo);
        transSalesDG02_Tax = transSalesDG02.findViewById(R.id.M04F07SF03D02_TaxNo);
        transSalesDG02_ServiceFee = transSalesDG02.findViewById(R.id.M04F07SF03D02_ServiceFeeNo);
        transSalesDG02_Discount = transSalesDG02.findViewById(R.id.M04F07SF03D02_DiscountNo);
        transSalesDG02_AmountDue = transSalesDG02.findViewById(R.id.M04F07SF03D02_AmountDueNo);
        transSalesDG02_PaymentMethod = transSalesDG02.findViewById(R.id.M04F07SF03D02_PaymentMethod);
        transSalesDG02_AmountRecieved = transSalesDG02.findViewById(R.id.M04F07SF03D02_AmountRecieved);
        transSalesDG02_Change = transSalesDG02.findViewById(R.id.M04F07SF03D02_ChangeNo);
        transSalesDG02_ItemCount = transSalesDG02.findViewById(R.id.M04F07SF03D02_TotalItemsNo);
        transSalesDG02_DateAndTime = transSalesDG02.findViewById(R.id.M04F07SF03D02_DateAndTime);

        transSalesDG02_PrintBtn = transSalesDG02.findViewById(R.id.M04F07SF03D02_PrintBtn);
        transSalesDG02_RefundBtn = transSalesDG02.findViewById(R.id.M04F07SF03D02_RefundBtn);
        closeDG02Btn = transSalesDG02.findViewById(R.id.M04F07SF03D02_CloseDGBtn);

        //--DG03--//
        transSalesDG03 = DialogHelper.create(getActivity(), R.layout.act04_main_frag07_admin_subfrag03_salestransaction_dg03_confirmrefund);
        transSalesDG03_TransNo = transSalesDG03.findViewById(R.id.M04F07SF03D03_SalesNoText);
        transSalesDG03_YesBtn = transSalesDG03.findViewById(R.id.M04F07SF03D03_YesBtn);
        transSalesDG03_NoBtn = transSalesDG03.findViewById(R.id.M04F07SF03D03_NoBtn);
        closeDG03Btn = transSalesDG03.findViewById(R.id.M04F07SF03D03_CloseDGBtn);

        //--DG04--//
        transSalesDG04 = DialogHelper.create(getActivity(), R.layout.act04_main_frag07_admin_subfrag03_salestransaction_dg04_viewrefund);
        transSalesDG04_SalesNumber = transSalesDG04.findViewById(R.id.M04F07SF03D04_ReceiptNo);
        transSalesDG04_OrderType = transSalesDG04.findViewById(R.id.M04F07SF03D04_OrderType);
        transSalesDG04_TableCustomerDetail = transSalesDG04.findViewById(R.id.M04F07SF03D04_TableOrCustomer);
        transSalesDG04_Cashier = transSalesDG04.findViewById(R.id.M04F07SF03D04_Cashier);

        transSalesDG04_RecyclerView = transSalesDG04.findViewById(R.id.M04F07SF03D04_ItemsRV);

        transSalesDG04_SubTotal = transSalesDG04.findViewById(R.id.M04F07SF03D04_SubTotalNo);
        transSalesDG04_Tax = transSalesDG04.findViewById(R.id.M04F07SF03D04_TaxNo);
        transSalesDG04_ServiceFee = transSalesDG04.findViewById(R.id.M04F07SF03D04_ServiceFeeNo);
        transSalesDG04_Discount = transSalesDG04.findViewById(R.id.M04F07SF03D04_DiscountNo);
        transSalesDG04_AmountDue = transSalesDG04.findViewById(R.id.M04F07SF03D04_AmountDueNo);
        transSalesDG04_PaymentMethod = transSalesDG04.findViewById(R.id.M04F07SF03D04_PaymentMethod);
        transSalesDG04_AmountRecieved = transSalesDG04.findViewById(R.id.M04F07SF03D04_AmountRecieved);
        transSalesDG04_Change = transSalesDG04.findViewById(R.id.M04F07SF03D04_ChangeNo);
        transSalesDG04_ItemCount = transSalesDG04.findViewById(R.id.M04F07SF03D04_TotalItemsNo);
        transSalesDG04_DateAndTime = transSalesDG04.findViewById(R.id.M04F07SF03D04_DateAndTime);

        transSalesDG04_PrintBtn = transSalesDG04.findViewById(R.id.M04F07SF03D04_PrintBtn);
        closeDG04Btn = transSalesDG04.findViewById(R.id.M04F07SF03D04_CloseDGBtn);
    }

    private void load_DG01Functionalities(String sortOrder, String transType, String transOrderType, String transYear, String transMonth, String transDay){
        //LoadDetails
        selectedOrder = sortOrder;

        //Set Views
        transSalesDG01_Trans.setText(transType);
        transSalesDG01_Order.setText(transOrderType);
        transSalesDG01_Year.setText(transYear);
        transSalesDG01_Month.setText(transMonth);
        transSalesDG01_Day.setText(transDay);
        if(selectedOrder.equals("Descending")){
            transSalesDG01_DescendingBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.green));
            transSalesDG01_AscendingBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
        } else {
            transSalesDG01_AscendingBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.green));
            transSalesDG01_DescendingBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
        }

        //Modify Ascending/Descending
        transSalesDG01_AscendingBtn.setOnClickListener(select -> {
            transSalesDG01_AscendingBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.green));
            transSalesDG01_DescendingBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
            selectedOrder = "Ascending";
        });
        transSalesDG01_DescendingBtn.setOnClickListener(select -> {
            transSalesDG01_DescendingBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.green));
            transSalesDG01_AscendingBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
            selectedOrder = "Descending";
        });

        //Modify TransactionType
        transSalesDG01_subTransBtn.setOnClickListener(sub -> {
            String transactionType = transSalesDG01_Trans.getText().toString();
            String newType = (transactionType.equals("Any"))
                    ? "Refund"
                    : (transactionType.equals("Refund"))
                    ? "Sales"
                    : "Any";
            transSalesDG01_Trans.setText(newType);
            transSalesDG01_Order.setText("Any");
        });
        transSalesDG01_addTransBtn.setOnClickListener(add -> {
            String transactionType = transSalesDG01_Trans.getText().toString();
            String newType = (transactionType.equals("Any"))
                    ? "Sales"
                    : (transactionType.equals("Sales"))
                    ? "Refund"
                    : "Any";
            transSalesDG01_Trans.setText(newType);
            transSalesDG01_Order.setText("Any");
        });

        //Modify OrderType
        transSalesDG01_subOrderBtn.setOnClickListener(sub -> {
            if(!transSalesDG01_Trans.getText().equals("Any")){
                String orderType = transSalesDG01_Order.getText().toString();
                String newType = (orderType.equals("Any"))
                        ? "Pick Up"
                        : (orderType.equals("Pick Up"))
                        ? "Delivery"
                        : (orderType.equals("Delivery"))
                        ? "Take Out"
                        : (orderType.equals("Take Out"))
                        ? "Dine In"
                        : "Any";
                transSalesDG01_Order.setText(newType);
                transSalesDG01_Year.setText("Any");
            }
        });
        transSalesDG01_addOrderBtn.setOnClickListener(add -> {
            if(!transSalesDG01_Trans.getText().equals("Any")){
                String orderType = transSalesDG01_Order.getText().toString();
                String newType = (orderType.equals("Any"))
                        ? "Dine In"
                        : (orderType.equals("Dine In"))
                        ? "Take Out"
                        : (orderType.equals("Take Out"))
                        ? "Delivery"
                        : (orderType.equals("Delivery"))
                        ? "Pick Up"
                        : "Any";
                transSalesDG01_Order.setText(newType);
                transSalesDG01_Year.setText("Any");
            }
        });

        //Modify Year
        transSalesDG01_subYearBtn.setOnClickListener(sub -> {
            if(!transSalesDG01_Order.getText().equals("Any")) {
                if(!transSalesDG01_Year.getText().toString().equals("Any")){
                int yearInt = Integer.parseInt(transSalesDG01_Year.getText().toString());
                yearInt--;
                transSalesDG01_Year.setText(String.valueOf(yearInt));
                } else {
                    int yearInt = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));
                    yearInt--;
                    transSalesDG01_Year.setText(String.valueOf(yearInt));
                }
                transSalesDG01_Month.setText("Any");
            }
        });
        transSalesDG01_addYearBtn.setOnClickListener(add -> {
            if(!transSalesDG01_Order.getText().equals("Any")) {
                if(!transSalesDG01_Year.getText().toString().equals("Any")){
                    int yearInt = Integer.parseInt(transSalesDG01_Year.getText().toString());
                    yearInt++;
                    transSalesDG01_Year.setText(String.valueOf(yearInt));
                } else {
                    int yearInt = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));
                    yearInt++;
                    transSalesDG01_Year.setText(String.valueOf(yearInt));
                }
                transSalesDG01_Month.setText("Any");
            }
        });

        //Modify Month
        transSalesDG01_SubMonthBtn.setOnClickListener(sub -> {
            if(!transSalesDG01_Year.getText().equals("Any")) {
                if(!transSalesDG01_Month.getText().toString().equals("Any")) {
                    String currentMonth = transSalesDG01_Month.getText().toString();
                    if (currentMonth.equals("January")) {
                        transSalesDG01_Month.setText("Any");
                    } else {
                        String displayedMonth = DateHelper.getSubMonth(transSalesDG01_Month.getText().toString());
                        transSalesDG01_Month.setText(displayedMonth);
                    }
                } else {
                    transSalesDG01_Month.setText("December");
                }
                transSalesDG01_Day.setText("Any");
            }
        });
        transSalesDG01_addMonthBtn.setOnClickListener(add -> {
            if(!transSalesDG01_Year.getText().equals("Any")) {
                if(!transSalesDG01_Month.getText().toString().equals("Any")) {
                    String currentMonth = transSalesDG01_Month.getText().toString();
                    if (currentMonth.equals("December")) {
                        transSalesDG01_Month.setText("Any");
                    } else {
                        String displayedMonth = DateHelper.getAddMonth(transSalesDG01_Month.getText().toString());
                        transSalesDG01_Month.setText(displayedMonth);
                    }
                } else {
                    transSalesDG01_Month.setText("January");
                }
                transSalesDG01_Day.setText("Any");
            }
        });

        //Modify Day
        transSalesDG01_SubDayBtn.setOnClickListener(sub -> {
            if(!transSalesDG01_Month.getText().equals("Any")) {
                String dayText = transSalesDG01_Day.getText().toString();
                int daysOfTheMonth = DateHelper.getDaysCount(transSalesDG01_Month.getText().toString());
                if(daysOfTheMonth == 29){
                    if(dayText.equals("01")) {
                        transSalesDG01_Day.setText("Any");
                    } else if(dayText.equals("Any")){
                        transSalesDG01_Day.setText(String.valueOf(daysOfTheMonth));
                    } else {
                        int dayNo = Integer.parseInt(transSalesDG01_Day.getText().toString());
                        dayNo--;
                        String number = (dayNo <= 9)
                                ? StringHelper.addZero(String.valueOf(dayNo))
                                : String.valueOf(dayNo);
                        transSalesDG01_Day.setText(number);
                    }
                } else if(daysOfTheMonth == 30){
                    if(dayText.equals("01")) {
                        transSalesDG01_Day.setText("Any");
                    } else if(dayText.equals("Any")){
                        transSalesDG01_Day.setText(String.valueOf(daysOfTheMonth));
                    } else {
                        int dayNo = Integer.parseInt(transSalesDG01_Day.getText().toString());
                        dayNo--;
                        String number = (dayNo <= 9)
                                ? StringHelper.addZero(String.valueOf(dayNo))
                                : String.valueOf(dayNo);
                        transSalesDG01_Day.setText(number);
                    }
                } else if(daysOfTheMonth == 31)   {
                    if(dayText.equals("01")) {
                        transSalesDG01_Day.setText("Any");
                    } else if(dayText.equals("Any")){
                        transSalesDG01_Day.setText(String.valueOf(daysOfTheMonth));
                    } else {
                        int dayNo = Integer.parseInt(transSalesDG01_Day.getText().toString());
                        dayNo--;
                        String number = (dayNo <= 9)
                                ? StringHelper.addZero(String.valueOf(dayNo))
                                : String.valueOf(dayNo);
                        transSalesDG01_Day.setText(number);
                    }
                }
            }
        });
        transSalesDG01_addDayBtn.setOnClickListener(add -> {
            if(!transSalesDG01_Month.getText().equals("Any")) {
                String dayText = transSalesDG01_Day.getText().toString();

                int daysOfTheMonth = DateHelper.getDaysCount(transSalesDG01_Month.getText().toString());
                if(daysOfTheMonth == 29){
                    if(dayText.equals(String.valueOf(daysOfTheMonth))) {
                        transSalesDG01_Day.setText("Any");
                    } else if(dayText.equals("Any")){
                        transSalesDG01_Day.setText("01");
                    } else {
                        int dayNo = Integer.parseInt(transSalesDG01_Day.getText().toString());
                        dayNo++;
                        String number = (dayNo <= 9)
                                ? StringHelper.addZero(String.valueOf(dayNo))
                                : String.valueOf(dayNo);
                        transSalesDG01_Day.setText(number);
                    }
                } else if(daysOfTheMonth == 30){
                    if(dayText.equals(String.valueOf(daysOfTheMonth))) {
                        transSalesDG01_Day.setText("Any");
                    } else if(dayText.equals("Any")){
                        transSalesDG01_Day.setText("01");
                    } else {
                        int dayNo = Integer.parseInt(transSalesDG01_Day.getText().toString());
                        dayNo++;
                        String number = (dayNo <= 9)
                                ? StringHelper.addZero(String.valueOf(dayNo))
                                : String.valueOf(dayNo);
                        transSalesDG01_Day.setText(number);
                    }
                } else if(daysOfTheMonth == 31)   {
                    if(dayText.equals(String.valueOf(daysOfTheMonth))) {
                        transSalesDG01_Day.setText("Any");
                    } else if(dayText.equals("Any")){
                        transSalesDG01_Day.setText("01");
                    } else {
                        int dayNo = Integer.parseInt(transSalesDG01_Day.getText().toString());
                        dayNo++;
                        String number = (dayNo <= 9)
                                ? StringHelper.addZero(String.valueOf(dayNo))
                                : String.valueOf(dayNo);
                        transSalesDG01_Day.setText(number);
                    }
                }
            }
        });

        //On Reset
        transSalesDG01_ResetBtn.setOnClickListener(reset -> {
            selectedOrder = "Descending";
            transSalesDG01_Trans.setText("Any");
            transSalesDG01_Order.setText("Any");
            transSalesDG01_Year.setText("Any");
            transSalesDG01_Month.setText("Any");
            transSalesDG01_Day.setText("Any");
            transSalesDG01_DescendingBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.green));
            transSalesDG01_AscendingBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
        });

        //On Confirm
        transSalesDG01_ConfirmBtn.setOnClickListener(confirm -> {
            String trans = transSalesDG01_Trans.getText().toString();
            String order = transSalesDG01_Order.getText().toString();
            String year = transSalesDG01_Year.getText().toString();
            String month = (!transSalesDG01_Month.getText().toString().equals("Any"))
                         ? DateHelper.getMonthNo(transSalesDG01_Month.getText().toString())
                         : "Any";
            String day = transSalesDG01_Day.getText().toString();
            load_SearchBar();
            load_RecyclerView(selectedOrder, trans, order, year, month, day);
            transSalesDG01.dismiss();
        });

        closeDG01Btn.setOnClickListener(close -> {
            transSalesDG01.dismiss();
        });
    }

    private void load_DG02Functionalities(DialogBundle bundle){
        //Unpack Bundle
        SalesTransaction sales = bundle.getSales();

        //Unpack Sales
        Map<CartItem, Integer> items = sales.getItems();
        String transactionNo = sales.getTransactionNo();
        String dateAndTime = sales.getDateAndTime();
        String order = sales.getOrder();
        String cashier = sales.getCashier();
        String orderType = sales.getOrderType();
        String total = StringHelper.convertToCurrency(sales.getTotalAmountDue());
        String discount = StringHelper.convertToCurrency(sales.getTotalDiscount());
        String tax = StringHelper.convertToCurrency(sales.getTotalTax());
        String paymentMethod = sales.getPaymentMethod();
        String amountPaid = StringHelper.convertToCurrency(sales.getTotalPayment());
        String change = StringHelper.convertToCurrency(sales.getChange());
        String itemCount = String.valueOf(sales.getTotalItems());

        //Set Views
        transSalesDG02_SalesNumber.setText(transactionNo);
        transSalesDG02_OrderType.setText(orderType.toUpperCase());
        transSalesDG02_TableCustomerDetail.setText("Order : " + order);
        transSalesDG02_Cashier.setText("Cashier : " + cashier);
        transSalesDG02_AmountDue.setText(total);
        transSalesDG02_Discount.setText(discount);
        transSalesDG02_Tax.setText(tax);
        transSalesDG02_PaymentMethod.setText(paymentMethod);
        transSalesDG02_AmountRecieved.setText(amountPaid);
        transSalesDG02_Change.setText(change);
        transSalesDG02_ItemCount.setText("[" + itemCount + "] items");
        transSalesDG02_DateAndTime.setText(dateAndTime);

        //Initialize RecyclerView
        List<CartItem> itemList = new ArrayList<>(items.keySet());
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        transSalesDG02_RecyclerViewAdapter = new M04F07SF03D02_ViewSalesRVA(getActivity(), realm, itemList, items);
        transSalesDG02_RecyclerView.setAdapter(transSalesDG02_RecyclerViewAdapter);
        transSalesDG02_RecyclerView.setLayoutManager(layout);

        //On Print
        transSalesDG02_PrintBtn.setOnClickListener(print -> {

        });

        //On Refund
        transSalesDG02_RefundBtn.setOnClickListener(refund -> {
            load_DG03Functionalities(bundle);
            transSalesDG02.dismiss();
            transSalesDG03.show();
        });

        //On Close
        closeDG02Btn.setOnClickListener(close -> {
            transSalesDG02.dismiss();
        });
    }

    private void load_DG03Functionalities(DialogBundle bundle){
        //Unpack Bundle
        SalesTransaction sales = bundle.getSales();

        //Set Views
        transSalesDG03_TransNo.setText("#" + sales.getTransactionNo());

        //On Yes
        transSalesDG03_YesBtn.setOnClickListener(yes -> {
            OpenTransactionsInstance.toCreateRefund(sales);
            load_SearchBar();
            load_RecyclerView("Descending", "Any", "Any", "Any", "Any", "Any");
            transSalesDG03.dismiss();
        });

        //On No
        transSalesDG03_NoBtn.setOnClickListener(no -> {
            transSalesDG03.dismiss();
        });

        //On Close
        closeDG03Btn.setOnClickListener(close -> {
            transSalesDG03.dismiss();
        });
    }

    private void load_DG04Functionalities(DialogBundle bundle){
        //Unpack Bundle
        SalesTransaction sales = bundle.getSales();

        //Unpack Sales
        Map<CartItem, Integer> items = sales.getItems();
        String transactionNo = sales.getTransactionNo();
        String dateAndTime = sales.getDateAndTime();
        String order = sales.getOrder();
        String cashier = sales.getCashier();
        String orderType = sales.getOrderType();
        String total = StringHelper.convertToCurrency(sales.getTotalAmountDue());
        String discount = StringHelper.convertToCurrency(sales.getTotalDiscount());
        String tax = StringHelper.convertToCurrency(sales.getTotalTax());
        String paymentMethod = sales.getPaymentMethod();
        String amountPaid = StringHelper.convertToCurrency(sales.getTotalPayment());
        String change = StringHelper.convertToCurrency(sales.getChange());
        String itemCount = String.valueOf(sales.getTotalItems());

        //Set Views
        transSalesDG04_SalesNumber.setText(transactionNo);
        transSalesDG04_OrderType.setText(orderType.toUpperCase());
        transSalesDG04_TableCustomerDetail.setText("Order : " + order);
        transSalesDG04_Cashier.setText("Cashier : " + cashier);
        transSalesDG04_AmountDue.setText(total);
        transSalesDG04_Discount.setText(discount);
        transSalesDG04_Tax.setText(tax);
        transSalesDG04_PaymentMethod.setText(paymentMethod);
        transSalesDG04_AmountRecieved.setText(amountPaid);
        transSalesDG04_Change.setText(change);
        transSalesDG04_ItemCount.setText("[" + itemCount + "] items");
        transSalesDG04_DateAndTime.setText(dateAndTime);

        //Initialize RecyclerView
        List<CartItem> itemList = new ArrayList<>(items.keySet());
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        transSalesDG04_RecyclerViewAdapter = new M04F07SF03D04_ViewRefundsRVA(getActivity(), realm, itemList, items);
        transSalesDG04_RecyclerView.setAdapter(transSalesDG04_RecyclerViewAdapter);
        transSalesDG04_RecyclerView.setLayoutManager(layout);

        //On Print
        transSalesDG04_PrintBtn.setOnClickListener(print -> {

            transSalesDG04.dismiss();
        });

        //On Close
        closeDG04Btn.setOnClickListener(close -> {
            transSalesDG04.dismiss();
        });
    }

    protected TextWatcher searchEngine = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable input) {
            load_FilteredRecyclerView(input.toString());
        }
    };

    @Override
    public void load_DGContents(DialogBundle bundle) {
        switch(bundle.getDialogDestinationNo()){
            case 2:
                load_DG02Functionalities(bundle);
                transSalesDG02.show();
                break;
            case 4:
                load_DG04Functionalities(bundle);
                transSalesDG04.show();
                break;
        }
    }
}
