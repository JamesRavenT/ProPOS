package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_User.Operations.Transactions.Sales;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.Schemas.SalesTransaction;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_User.Operations.Transactions.Sales.Adapter.M04F040OPTS_SalesViewRVA;
import com.wabizabi.wazabipos.R;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class M04F04OPTS_SalesView extends Fragment {
    public static String tid;
    Realm realm = Realm.getDefaultInstance();
    RecyclerView rvSalesView;
    RecyclerView.Adapter rvaSalesView;
    TextView noTID;
    TextView txtSubtotal, txtTax, txtTotal;
    TextView noSubtotal, noTax, noTotal;
    CardView btnRefund;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag04_admin_operation_management_transactions_sales_view, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        init_Views(v);
        init_TransactionDetails();
        init_RecyclerView();
    }

    private void init_Views(View v){
        rvSalesView = v.findViewById(R.id.M04F04OPTSV_RecyclerView);
        noTID = v.findViewById(R.id.M04F04OPTSV_TID);
        noSubtotal = v.findViewById(R.id.M04F04OPTSV_SubTotalNo);
        noTax = v.findViewById(R.id.M04F04OPTSV_TaxNo);
        noTotal = v.findViewById(R.id.M04F04OPTSV_TotalNo);
    }

    private void init_TransactionDetails(){
        SalesTransaction transaction = realm
                .where(SalesTransaction.class)
                .equalTo("timestamp", tid)
                .findFirst();
        List<String> itemNames = transaction.getName();
        List<String> listItemName = new ArrayList<>(itemNames);
        List<Integer> itemAmount = transaction.getQuantity();
        List<Integer> listItemAmount = new ArrayList<>(itemAmount);
        List<Double> itemPrices = transaction.getPrice();
        List<Double> listItemPrice = new ArrayList<>(itemPrices);
        double subtotal = listItemPrice.stream().mapToDouble(Double::doubleValue).sum();
        double tax = subtotal * 0.03;
        double total = subtotal + tax;

        noTID.setText("TID " + transaction.getTimestamp());
        noSubtotal.setText("₱" + subtotal);
        noTax.setText("₱" + tax);
        noTotal.setText("₱" + total);

        rvaSalesView = new M04F040OPTS_SalesViewRVA(listItemName, listItemAmount, listItemPrice, getActivity());
    }

    private void init_RecyclerView(){
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        rvSalesView.setLayoutManager(layout);
        rvSalesView.setAdapter(rvaSalesView);
    }
}
