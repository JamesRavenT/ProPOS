package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment07_Admin.SubFragments.SubFragment03_SalesTransaction.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.ObjectSchemas.SalesTransaction;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmSalesTransaction;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Interfaces.DialogLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.Bundles.DialogBundle;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.LayoutHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.StringHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.TransactionsHelper;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class M04F07SF03_SalesTransactionRVA extends RecyclerView.Adapter<M04F07SF03_SalesTransactionRVA.ViewHolder>{

    Context context;
    Realm realm;
    List<SalesTransaction> listOfSalesTransction;
    DialogLoader dialogLoader;

    public M04F07SF03_SalesTransactionRVA(Context context, Realm realm, List<SalesTransaction> listOfSalesTransction, DialogLoader dialogLoader) {
        this.context = context;
        this.realm = realm;
        this.listOfSalesTransction = listOfSalesTransction;
        this.dialogLoader = dialogLoader;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutHelper.inflateRV(parent, R.layout.act04_main_frag07_admin_subfrag03_salestransaction_rvlayout);
        ViewHolder layout = new ViewHolder(view);
        return layout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SalesTransaction sales = listOfSalesTransction.get(position);
        holder.loadFunctionalities(sales, position);
    }

    @Override
    public int getItemCount() {
        return listOfSalesTransction.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        private TextView transDateAndTime, transNo, transType, transOrder, transItems, transAmountDue, transAmountPaid, transMethod;
        private CardView viewBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            transDateAndTime = itemView.findViewById(R.id.M04F07SF03_RVDateAndTime);
            transNo = itemView.findViewById(R.id.M04F07SF03_RVTicketNo);
            transType = itemView.findViewById(R.id.M04F07SF03_RVInVoiceText);
            transOrder = itemView.findViewById(R.id.M04F07SF03_RVOrder);
            transItems = itemView.findViewById(R.id.M04F07SF03_RVItems);
            transAmountDue = itemView.findViewById(R.id.M04F07SF03_RVAmountDue);
            transAmountPaid = itemView.findViewById(R.id.M04F07SF03_RVAmountReceived);
            transMethod = itemView.findViewById(R.id.M04F07SF03_RVPaymentMethod);
            viewBtn = itemView.findViewById(R.id.M04F07SF03_RVViewBtn);
        }

        public void loadFunctionalities(SalesTransaction sales, int position){
            //Load Details
            String dateAndTime = sales.getDateAndTime();
            String transactionNo = "#" + sales.getTransactionNo();
            String transactionType = sales.getTransactionType().toUpperCase();
            String order = sales.getOrderType() + " | " + sales.getOrder();
            String items = "[" + sales.getTotalItems() + "] items";
            String amountDue = StringHelper.convertToCurrency(sales.getTotalAmountDue());
            String amountPaid = StringHelper.convertToCurrency(sales.getTotalPayment());
            String method = sales.getPaymentMethod();

            //SetViews
            this.position = position;
            transDateAndTime.setText(dateAndTime);
            transNo.setText(transactionNo);
            transType.setText(transactionType);
            transOrder.setText(order);
            transItems.setText(items);
            transAmountDue.setText(amountDue);
            transAmountPaid.setText(amountPaid);
            transMethod.setText(method);

            //On Click
            viewBtn.setOnClickListener(view -> {
                SalesTransaction selectedTransaction = TransactionsHelper.getSelectedTransaction(realm, sales);
                if(sales.getTransactionType().equals("Sales")) {
                    dialogLoader.load_DGContents(new DialogBundle(2, selectedTransaction));
                } else {
                    dialogLoader.load_DGContents(new DialogBundle(4, selectedTransaction));
                }
            });
        }
    }
}
