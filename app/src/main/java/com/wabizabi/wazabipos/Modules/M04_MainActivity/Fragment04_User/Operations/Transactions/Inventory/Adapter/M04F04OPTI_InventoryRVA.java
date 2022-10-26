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
        }
    }
}
