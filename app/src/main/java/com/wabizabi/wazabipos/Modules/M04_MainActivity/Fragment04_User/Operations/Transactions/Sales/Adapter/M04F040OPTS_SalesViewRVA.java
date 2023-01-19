package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_User.Operations.Transactions.Sales.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.R;

import java.util.List;


public class M04F040OPTS_SalesViewRVA extends RecyclerView.Adapter<M04F040OPTS_SalesViewRVA.ViewHolder> {
    List<String> namesOfEachItem;
    List<Integer> amountOfEachItem;
    List<Double> priceOfEachItem;
    Context context;

    public M04F040OPTS_SalesViewRVA(List<String> namesOfEachItem, List<Integer> amountOfEachItem, List<Double> priceOfEachItem, Context context) {
        this.namesOfEachItem = namesOfEachItem;
        this.amountOfEachItem = amountOfEachItem;
        this.priceOfEachItem = priceOfEachItem;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.act04_main_frag04_admin_operation_management_transactions_sales_view_rvlayout, parent, false);
        ViewHolder rvlayout = new ViewHolder(layout);
        return rvlayout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String name = namesOfEachItem.get(position);
        int amount = amountOfEachItem.get(position);
        double price = priceOfEachItem.get(position);
        holder.showTransaction(amount, name, price, position);
    }

    @Override
    public int getItemCount() {
        return namesOfEachItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        int position;
        TextView itemAmount, itemName, itemPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemAmount = itemView.findViewById(R.id.M04F04OPTSV_RVItemAmount);
            itemName = itemView.findViewById(R.id.M04F04OPTSV_RVItemName);
            itemPrice = itemView.findViewById(R.id.M04F04OPTSV_RVItemPrice);
        }

        public void showTransaction(int amount, String name, double price, int position){
            this.position = position;
            itemAmount.setText(String.valueOf(amount));
            itemName.setText(name);
            itemPrice.setText("₱" + price * (double) amount);
        }
    }
}
