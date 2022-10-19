package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.Items.Read.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.R;

import java.util.List;

public class M04F03OPIR_ReadItemRVA extends RecyclerView.Adapter<M04F03OPIR_ReadItemRVA.ViewHolder> {
    List<List<String>> items;
    Context context;

    public M04F03OPIR_ReadItemRVA(List<List<String>> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.act04_main_frag03_products_operation_crud_itemread_rvlayout, parent, false);
        ViewHolder viewLayout = new ViewHolder(layout);
        return viewLayout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        List<String> itemset = items.get(position);
        holder.showPatterns(itemset, position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        int position;
        TextView frequentPatterns;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            frequentPatterns = itemView.findViewById(R.id.M04F03OPIR_RVFrequentlyBoughtItems);
        }

        public void showPatterns(List<String> itemset, int position){
            this.position = position;
            String fqItemset = itemset.toString()
                    .replace("[", "・")
                    .replace("]", "")
                    .replace(",", "\n・");
            frequentPatterns.setText(fqItemset);
        }
    }
}
