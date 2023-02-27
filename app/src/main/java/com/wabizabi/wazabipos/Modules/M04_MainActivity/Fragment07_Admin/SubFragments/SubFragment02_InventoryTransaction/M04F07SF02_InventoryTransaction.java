package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment07_Admin.SubFragments.SubFragment02_InventoryTransaction;

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
import com.wabizabi.wazabipos.Database.ObjectSchemas.InventoryTransaction;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment07_Admin.SubFragments.SubFragment02_InventoryTransaction.Adapters.M04F07SF02_InventoryTransactionRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment07_Admin.SubFragments.SubFragment02_InventoryTransaction.Helpers.ITHelper;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Interfaces.DialogLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.Bundles.DialogBundle;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.DateHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.DialogHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.LayoutHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.StringHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import io.realm.Realm;

public class M04F07SF02_InventoryTransaction extends Fragment implements DialogLoader {
    //--DATABASE--//
    Realm realm = Realm.getDefaultInstance();

    //--HEADER--//
    ImageView settingsBtn;

    //--SEARCHBAR--//
    EditText searchbar;

    //--RECYCLERVIEW--//
    RecyclerView transactionsRV;
    RecyclerView.Adapter transactionsRVA;
    List<InventoryTransaction> listOfInventoryTransactions;

    //--DG01--//
    String selectedOrder = "Any";
    Dialog invTransDG01;
    CardView invTransDG01_AscendingBtn, invTransDG01_DescendingBtn;
    ImageView invTransDG01_subTransBtn,
            invTransDG01_subYearBtn,
            invTransDG01_SubMonthBtn,
            invTransDG01_SubDayBtn;
    TextView invTransDG01_Trans,
            invTransDG01_Year,
            invTransDG01_Month,
            invTransDG01_Day;
    ImageView invTransDG01_addTransBtn,
            invTransDG01_addYearBtn,
            invTransDG01_addMonthBtn,
            invTransDG01_addDayBtn;
    CardView invTransDG01_ConfirmBtn;
    TextView invTransDG01_ResetChangesBtn;
    ImageView closeDG01Btn;

    //--DG02--//
    Dialog invTransDG02;
    TextView invTransDG02_TransNo;
    CardView invTransDG02_YesBtn, invTransDG02_NoBtn;
    ImageView closeDG02Btn;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutHelper.inflateFragment(inflater, container, R.layout.act04_main_frag07_admin_subfrag02_inventorytransaction);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        settingsBtn = v.findViewById(R.id.M04F07SF02_FilterBtn);
        searchbar = v.findViewById(R.id.M04F07SF02_SearchBarInput);
        transactionsRV = v.findViewById(R.id.M04F07SF02_RecyclerView);

        init_Dialogs();
        load_Header("Descending", "Any", "Any", "Any", "Any");
        load_SearchBar();
        load_RecyclerView("Descending", "Any", "Any", "Any", "Any");
    }

    private void load_Header(String sortOrder, String transactionType, String year, String month, String day){
        settingsBtn.setOnClickListener(settings -> {
            load_DG01Functionalities(sortOrder, transactionType, year, month, day);
            invTransDG01.show();
        });
    }

    private void load_SearchBar(){
        searchbar.removeTextChangedListener(searchEngine);
        searchbar.setText("");
        searchbar.addTextChangedListener(searchEngine);
    }

    private void load_RecyclerView(String sortOrder, String transactionType, String year, String month, String day){
        listOfInventoryTransactions = (sortOrder.equals("Ascending"))
                                    ? ITHelper.getInventoryTransactionAscending(realm, transactionType, year, month, day)
                                    : ITHelper.getInventoryTransactionDescending(realm, transactionType, year, month, day);
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        transactionsRVA = new M04F07SF02_InventoryTransactionRVA(getActivity(), realm, listOfInventoryTransactions, this);
        transactionsRV.setAdapter(transactionsRVA);
        transactionsRV.setLayoutManager(layout);
    }

    private void load_FilteredRecyclerView(String s){
        List<InventoryTransaction> filteredTransaction = ITHelper.getFilteredInventoryTransaction(listOfInventoryTransactions, s);
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        transactionsRVA = new M04F07SF02_InventoryTransactionRVA(getActivity(), realm, filteredTransaction, this);
        transactionsRV.setAdapter(transactionsRVA);
        transactionsRV.setLayoutManager(layout);
    }

    private void init_Dialogs(){
        //--DG01--//
        invTransDG01 = DialogHelper.create(getActivity(), R.layout.act04_main_frag07_admin_subfrag02_inventorytransaction_dg01_searchsettings);
        invTransDG01_AscendingBtn = invTransDG01.findViewById(R.id.M04F07SF02D01_AscendingBtn);
        invTransDG01_DescendingBtn = invTransDG01.findViewById(R.id.M04F07SF02D01_DescendingBtn);

        invTransDG01_subTransBtn = invTransDG01.findViewById(R.id.M04F07SF02D01_TransactionSubBtn);
        invTransDG01_subYearBtn = invTransDG01.findViewById(R.id.M04F07SF02D01_YearSubBtn);
        invTransDG01_SubMonthBtn = invTransDG01.findViewById(R.id.M04F07SF02D01_MonthSubBtn);
        invTransDG01_SubDayBtn = invTransDG01.findViewById(R.id.M04F07SF02D01_DaySubBtn);

        invTransDG01_Trans = invTransDG01.findViewById(R.id.M04F07SF02D01_TransactionInput);
        invTransDG01_Year = invTransDG01.findViewById(R.id.M04F07SF02D01_YearInput);
        invTransDG01_Month = invTransDG01.findViewById(R.id.M04F07SF02D01_MonthInput);
        invTransDG01_Day = invTransDG01.findViewById(R.id.M04F07SF02D01_DayInput);

        invTransDG01_addTransBtn = invTransDG01.findViewById(R.id.M04F07SF02D01_TransactionAddBtn);
        invTransDG01_addYearBtn = invTransDG01.findViewById(R.id.M04F07SF02D01_YearAddBtn);
        invTransDG01_addMonthBtn = invTransDG01.findViewById(R.id.M04F07SF02D01_MonthAddBtn);
        invTransDG01_addDayBtn = invTransDG01.findViewById(R.id.M04F07SF02D01_DayAddBtn);
        invTransDG01_ResetChangesBtn = invTransDG01.findViewById(R.id.M04F07SF02D01_ResetBtn);

        invTransDG01_ConfirmBtn = invTransDG01.findViewById(R.id.M04F07SF02D01_ConfirmBtn);
        closeDG01Btn = invTransDG01.findViewById(R.id.M04F07SF02D01_CloseDGBtn);

        //--DG02--//
        invTransDG02 = DialogHelper.create(getActivity(), R.layout.act04_main_frag07_admin_subfrag02_inventorytransaction_dg02_confirmdelete);
        invTransDG02_TransNo = invTransDG02.findViewById(R.id.M04F07SF02D02_SalesNoText);
        invTransDG02_YesBtn = invTransDG02.findViewById(R.id.M04F07SF02D02_YesBtn);
        invTransDG02_NoBtn = invTransDG02.findViewById(R.id.M04F07SF02D02_NoBtn);
        closeDG02Btn = invTransDG02.findViewById(R.id.M04F07SF02D02_CloseDGBtn);
    }

    private void load_DG01Functionalities(String sortOrder, String transType, String transYear, String transMonth, String transDay){
        //LoadDetails
        selectedOrder = sortOrder;

        //Set Views
        invTransDG01_Trans.setText(transType);
        invTransDG01_Year.setText(transYear);
        invTransDG01_Month.setText(transMonth);
        invTransDG01_Day.setText(transDay);
        if(selectedOrder.equals("Descending")){
            invTransDG01_DescendingBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.green));
            invTransDG01_AscendingBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
        } else {
            invTransDG01_AscendingBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.green));
            invTransDG01_DescendingBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
        }


        //Modify Ascending/Descending
        invTransDG01_AscendingBtn.setOnClickListener(select -> {
            invTransDG01_AscendingBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.green));
            invTransDG01_DescendingBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
            selectedOrder = "Ascending";
        });
        invTransDG01_DescendingBtn.setOnClickListener(select -> {
            invTransDG01_DescendingBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.green));
            invTransDG01_AscendingBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
            selectedOrder = "Descending";
        });

        //Modify TransactionType
        invTransDG01_subTransBtn.setOnClickListener(sub -> {
            String transactionType = invTransDG01_Trans.getText().toString();
            String newType = (transactionType.equals("Any"))
                    ? "Stock Out"
                    : (transactionType.equals("Stock Out"))
                    ? "Stock In"
                    : "Any";
            invTransDG01_Trans.setText(newType);
            invTransDG01_Year.setText("Any");
        });
        invTransDG01_addTransBtn.setOnClickListener(add -> {
            String transactionType = invTransDG01_Trans.getText().toString();
            String newType = (transactionType.equals("Any"))
                    ? "Stock In"
                    : (transactionType.equals("Stock In"))
                    ? "Stock Out"
                    : "Any";
            invTransDG01_Trans.setText(newType);
            invTransDG01_Year.setText("Any");
        });

        //Modify Year
        invTransDG01_subYearBtn.setOnClickListener(sub -> {
            if(!invTransDG01_Trans.getText().equals("Any")) {
                if(!invTransDG01_Year.getText().toString().equals("Any")){
                    int yearInt = Integer.parseInt(invTransDG01_Year.getText().toString());
                    yearInt--;
                    invTransDG01_Year.setText(String.valueOf(yearInt));
                } else {
                    int yearInt = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));
                    yearInt--;
                    invTransDG01_Year.setText(String.valueOf(yearInt));
                }
                invTransDG01_Month.setText("Any");
            }
        });
        invTransDG01_addYearBtn.setOnClickListener(add -> {
            if(!invTransDG01_Trans.getText().equals("Any")) {
                if(!invTransDG01_Year.getText().toString().equals("Any")){
                    int yearInt = Integer.parseInt(invTransDG01_Year.getText().toString());
                    yearInt++;
                    invTransDG01_Year.setText(String.valueOf(yearInt));
                } else {
                    int yearInt = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));
                    yearInt++;
                    invTransDG01_Year.setText(String.valueOf(yearInt));
                }
                invTransDG01_Month.setText("Any");
            }
        });

        //Modify Month
        invTransDG01_SubMonthBtn.setOnClickListener(sub -> {
            if(!invTransDG01_Year.getText().equals("Any")) {
                if(!invTransDG01_Month.getText().toString().equals("Any")) {
                    String currentMonth = invTransDG01_Month.getText().toString();
                    if (currentMonth.equals("January")) {
                        invTransDG01_Month.setText("Any");
                    } else {
                        String displayedMonth = DateHelper.getSubMonth(invTransDG01_Month.getText().toString());
                        invTransDG01_Month.setText(displayedMonth);
                    }
                } else {
                    invTransDG01_Month.setText("December");
                }
                invTransDG01_Day.setText("Any");
            }

        });
        invTransDG01_addMonthBtn.setOnClickListener(add -> {
            if(!invTransDG01_Year.getText().equals("Any")) {
                if(!invTransDG01_Month.getText().toString().equals("Any")) {
                    String currentMonth = invTransDG01_Month.getText().toString();
                    if (currentMonth.equals("December")) {
                        invTransDG01_Month.setText("Any");
                        invTransDG01_Day.setText("Any");
                    } else {
                        String displayedMonth = DateHelper.getAddMonth(invTransDG01_Month.getText().toString());
                        invTransDG01_Month.setText(displayedMonth);
                        invTransDG01_Day.setText("Any");
                    }
                } else {
                    invTransDG01_Month.setText("January");
                    invTransDG01_Day.setText("Any");
                }
            }
        });

        //Modify Day
        invTransDG01_SubDayBtn.setOnClickListener(sub -> {
            if(!invTransDG01_Month.getText().equals("Any")) {
                String dayText = invTransDG01_Day.getText().toString();
                int daysOfTheMonth = DateHelper.getDaysCount(invTransDG01_Month.getText().toString());
                if(daysOfTheMonth == 29){
                    if(dayText.equals("Any")){
                        invTransDG01_Day.setText(String.valueOf(daysOfTheMonth));
                    } else if(dayText.equals("01")) {
                        invTransDG01_Day.setText("Any");
                    } else {
                        int dayNo = Integer.parseInt(invTransDG01_Day.getText().toString());
                        dayNo--;
                        String number = (dayNo <= 9)
                                ? StringHelper.addZero(String.valueOf(dayNo))
                                : String.valueOf(dayNo);
                        invTransDG01_Day.setText(number);
                    }
                } else if(daysOfTheMonth == 30){
                    if(dayText.equals("Any")) {
                        invTransDG01_Day.setText(String.valueOf(daysOfTheMonth));
                    } if(dayText.equals("01")) {
                        invTransDG01_Day.setText("Any");
                    } else {
                        int dayNo = Integer.parseInt(invTransDG01_Day.getText().toString());
                        dayNo--;
                        String number = (dayNo <= 9)
                                ? StringHelper.addZero(String.valueOf(dayNo))
                                : String.valueOf(dayNo);
                        invTransDG01_Day.setText(number);
                    }
                } else if(daysOfTheMonth == 31)   {
                    if(dayText.equals("Any")) {
                        invTransDG01_Day.setText(String.valueOf(daysOfTheMonth));
                    } else if(dayText.equals("01")) {
                        invTransDG01_Day.setText("Any");
                    } else {
                        int dayNo = Integer.parseInt(invTransDG01_Day.getText().toString());
                        dayNo--;
                        String number = (dayNo <= 9)
                                ? StringHelper.addZero(String.valueOf(dayNo))
                                : String.valueOf(dayNo);
                        invTransDG01_Day.setText(number);
                    }
                }
            }
        });
        invTransDG01_addDayBtn.setOnClickListener(add -> {
            if(!invTransDG01_Month.getText().equals("Any")) {
                String dayText = invTransDG01_Day.getText().toString();
                int daysOfTheMonth = DateHelper.getDaysCount(invTransDG01_Month.getText().toString());
                if(daysOfTheMonth == 29){
                    if(dayText.equals("Any")) {
                        invTransDG01_Day.setText("01");
                    } else if(dayText.equals(String.valueOf(daysOfTheMonth))) {
                        invTransDG01_Day.setText("Any");
                    } else {
                        int dayNo = Integer.parseInt(invTransDG01_Day.getText().toString());
                        dayNo++;
                        String number = (dayNo <= 9)
                                ? StringHelper.addZero(String.valueOf(dayNo))
                                : String.valueOf(dayNo);
                        invTransDG01_Day.setText(number);
                    }
                } else if(daysOfTheMonth == 30){
                    if(dayText.equals("Any")) {
                        invTransDG01_Day.setText("01");

                    } else if(dayText.equals(String.valueOf(daysOfTheMonth))) {
                        invTransDG01_Day.setText("Any");
                    } else {
                        int dayNo = Integer.parseInt(invTransDG01_Day.getText().toString());
                        dayNo++;
                        String number = (dayNo <= 9)
                                ? StringHelper.addZero(String.valueOf(dayNo))
                                : String.valueOf(dayNo);
                        invTransDG01_Day.setText(number);
                    }
                } else if(daysOfTheMonth == 31)   {
                    if(dayText.equals("Any")) {
                        invTransDG01_Day.setText("01");
                    } else if(dayText.equals(String.valueOf(daysOfTheMonth))) {
                        invTransDG01_Day.setText("Any");
                    } else {
                        int dayNo = Integer.parseInt(invTransDG01_Day.getText().toString());
                        dayNo++;
                        String number = (dayNo <= 9)
                                ? StringHelper.addZero(String.valueOf(dayNo))
                                : String.valueOf(dayNo);
                        invTransDG01_Day.setText(number);
                    }
                }
            }
        });

        //On Reset
        invTransDG01_ResetChangesBtn.setOnClickListener(reset -> {
            selectedOrder = "Descending";
            invTransDG01_Trans.setText("Any");
            invTransDG01_Year.setText("Any");
            invTransDG01_Month.setText("Any");
            invTransDG01_Day.setText("Any");
            invTransDG01_DescendingBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.green));
            invTransDG01_AscendingBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));

        });

        //On Confirm
        invTransDG01_ConfirmBtn.setOnClickListener(confirm -> {
            String trans = invTransDG01_Trans.getText().toString();
            String year = invTransDG01_Year.getText().toString();
            String month = (!invTransDG01_Month.getText().toString().equals("Any"))
                    ? DateHelper.getMonthNo(invTransDG01_Month.getText().toString())
                    : "Any";
            String day = invTransDG01_Day.getText().toString();
            load_SearchBar();
            load_Header(selectedOrder, trans, year, month, day);
            load_RecyclerView(selectedOrder, trans, year, month, day);
            invTransDG01.dismiss();
        });

        closeDG01Btn.setOnClickListener(close -> {
            invTransDG01.dismiss();
        });

    }

    private void load_DG02Functionalities(DialogBundle bundle){
        //Unpack Bundle
        InventoryTransaction transaction = bundle.getInventoryTransaction();

        //Set Views
        invTransDG02_TransNo.setText("#" + transaction.getTransactionID());

        //On Yes
        invTransDG02_YesBtn.setOnClickListener(yes -> {
            OpenTransactionsInstance.toVoidInventoryTransaction(transaction);
            load_SearchBar();
            load_RecyclerView("Descending", "Any", "Any", "Any", "Any");
            invTransDG02.dismiss();
        });

        //On No
        invTransDG02_NoBtn.setOnClickListener(no -> {
            invTransDG02.dismiss();
        });

        //On Close
        closeDG02Btn.setOnClickListener(close -> {
            invTransDG02.dismiss();
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
        load_DG02Functionalities(bundle);
        invTransDG02.show();
    }
}
