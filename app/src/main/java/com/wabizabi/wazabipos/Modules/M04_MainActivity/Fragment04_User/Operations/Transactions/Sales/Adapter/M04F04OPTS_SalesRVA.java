package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_User.Operations.Transactions.Sales.Adapter;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_User.Operations.M04F04OP_Management.viewsSaleTransactionFragment;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_User.Operations.Transactions.Sales.M04F04OPTS_SalesView.tid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.RealmSchemas.SalesTransaction;
import com.wabizabi.wazabipos.R;

import io.realm.RealmResults;

public class M04F04OPTS_SalesRVA extends RecyclerView.Adapter<M04F04OPTS_SalesRVA.ViewHolder> {

    RealmResults<SalesTransaction> listOfSalesTransactions;
    Context context;

    public M04F04OPTS_SalesRVA(RealmResults<SalesTransaction> listOfSalesTransactions, Context context) {
        this.listOfSalesTransactions = listOfSalesTransactions;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.act04_main_frag04_admin_operation_management_transactions_sales_rvlayout, parent, false);
        ViewHolder rvlayout = new ViewHolder(layout);
        return rvlayout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SalesTransaction transaction = listOfSalesTransactions.get(position);
        holder.showSales(transaction, position);
        holder.onClickViewMore(transaction, position);
    }

    @Override
    public int getItemCount() {
        return listOfSalesTransactions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        int position;
        TextView salesDate, salesOperation, salesItems, salesPrices, viewMore;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            salesDate = itemView.findViewById(R.id.M04F04OPTS_RVDate);
            salesOperation = itemView.findViewById(R.id.M04F04OPTS_RVOperation);
            salesItems = itemView.findViewById(R.id.M04F04OPTS_RVItemsSold);
            salesPrices = itemView.findViewById(R.id.M04F04OPTS_RVTotalPrice);
            viewMore = itemView.findViewById(R.id.M04F04OPTS_RVViewMore);
        }

        public void showSales(SalesTransaction transaction, int position){
            this.position = position;
            salesDate.setText(transaction.getMonth() + " " + transaction.getDayNumber() + ", " + transaction.getYear() + " ; " + transaction.getTime());
            salesOperation.setText(transaction.getOperation());
            salesItems.setText("Sold " + transaction.getName().size() + " items");
            salesPrices.setText("₱" + transaction.getPriceOfAllItems());
        }

        public void onClickViewMore(SalesTransaction transaction, int position){
            this.position = position;
            viewMore.setOnClickListener(v->{
                tid = transaction.getTimestamp();
                ((FragmentActivity) context)
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.M04F04OP_FragmentContainer, viewsSaleTransactionFragment)
                        .commit();
            });
        }
    }
}
