package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Menu.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.R;

import java.util.List;

public class M04F02D06_CombinationRVA extends RecyclerView.Adapter<M04F02D06_CombinationRVA.ViewHolder> {

    List<List<String>> itemsets;

    public M04F02D06_CombinationRVA(List<List<String>> itemsets) {
        this.itemsets = itemsets;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.act04_main_frag02_menu_dg06_viewitem_rvlayout, parent, false);
        ViewHolder layout = new ViewHolder(view);
        return layout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        List<String> itemset = itemsets.get(position);
        holder.loadDetails(itemset, position);
    }

    @Override
    public int getItemCount() {
        return itemsets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        private TextView itemSetNo, itemSetItems;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemSetNo = itemView.findViewById(R.id.M04F02D06_RVCombinationText);
            itemSetItems = itemView.findViewById(R.id.M04F02D06_RVItemSet);
        }

        public void loadDetails(List<String> itemset, int position){
            this.position = position;
            int count = position + 1;
            String number = (count < 10) ? "Combination No. 0" + count : "Combination No." + count;
            String fqItemset = itemset.toString()
                    .replace("[", "・")
                    .replace("]", "")
                    .replace(",", "\n・");
            itemSetNo.setText(number);
            itemSetItems.setText(fqItemset);
        }
    }
}
