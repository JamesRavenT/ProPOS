package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_User.Operations.Transactions.Inventory.Adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.Schemas.InventoryTransaction;
import com.wabizabi.wazabipos.R;

import io.realm.RealmResults;

public class M04F04OPTI_InventoryRVA extends RecyclerView.Adapter<M04F04OPTI_InventoryRVA.ViewHolder> {
    RealmResults<InventoryTransaction> listOfInventoryTransaction;
    Context context;

    public M04F04OPTI_InventoryRVA(RealmResults<InventoryTransaction> listOfInventoryTransaction, Context context) {
        this.listOfInventoryTransaction = listOfInventoryTransaction;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.act04_main_frag04_admin_operation_management_transactions_inventory_rvlayout, parent, false);
        ViewHolder rvlayout = new ViewHolder(layout);
        return rvlayout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        InventoryTransaction transaction = listOfInventoryTransaction.get(position);
        holder.showTransaction(transaction, position);
    }

    @Override
    public int getItemCount() {
        return listOfInventoryTransaction.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        int position;
        TextView transactionDate, transactionItem, transactionOperation;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            transactionDate = itemView.findViewById(R.id.M04F04OPTI_RVDate);
            transactionItem = itemView.findViewById(R.id.M04F04OPTI_RVItemName);
            transactionOperation = itemView.findViewById(R.id.M04F04OPTI_RVOperation);
        }

        public void showTransaction(InventoryTransaction transaction, int position){
            this.position = position;
            transactionDate.setText(transaction.getMonth() + " " + transaction.getDay() + ", " + transaction.getYear() + " ; " + transaction.getTime());
            transactionItem.setText(transaction.getItemName());
            switch(transaction.getOperation()){
                case "Stock In":
                    transactionOperation.setText("Stocked In : " + transaction.getItemName() + " " + transaction.getItemUnit());
                    break;
                case "Stock Out":
                    transactionOperation.setText("Stocked Out : " + transaction.getItemName() + " " + transaction.getItemUnit());
                    break;
            }
        }
    }
}
