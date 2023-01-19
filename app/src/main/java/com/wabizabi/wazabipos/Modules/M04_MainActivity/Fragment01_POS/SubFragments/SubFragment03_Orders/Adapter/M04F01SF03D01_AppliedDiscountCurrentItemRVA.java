package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Orders.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.R;

import java.util.List;
import java.util.Map;

import io.realm.Realm;

public class M04F01SF03D01_AppliedDiscountCurrentItemRVA extends RecyclerView.Adapter<M04F01SF03D01_AppliedDiscountCurrentItemRVA.ViewHolder> {

    Context context;
    Realm realm;
    Map<String, Integer> listOfDiscountsApplied;
    List<String> listOfDiscountsAppliedKeyset;

    public M04F01SF03D01_AppliedDiscountCurrentItemRVA(Context context, Realm realm, Map<String, Integer> listOfDiscountsApplied, List<String> listOfDiscountsAppliedKeyset) {
        this.context = context;
        this.realm = realm;
        this.listOfDiscountsApplied = listOfDiscountsApplied;
        this.listOfDiscountsAppliedKeyset = listOfDiscountsAppliedKeyset;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.act04_main_frag01_pos_subfrag03_order_dg01_itemdiscount_rvlayout, parent, false);
        ViewHolder layout = new ViewHolder(view);
        return layout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String discountName = listOfDiscountsAppliedKeyset.get(position);
        int discountPercentage = listOfDiscountsApplied.get(discountName);
        holder.loadDetails(discountName, discountPercentage, position);
        holder.onClickRemoveButton(discountName, discountPercentage, position);
    }

    @Override
    public int getItemCount() {
        return listOfDiscountsApplied.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        private TextView discountName,
                         discountPercentage;
        private ImageView removeDiscountBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            discountName = itemView.findViewById(R.id.M04F01SF03D01_RVDiscountName);
            discountPercentage = itemView.findViewById(R.id.M04F01SF03D01_RVDiscountPercentage);
            removeDiscountBtn = itemView.findViewById(R.id.M04F01SF03D01_RVRemoveBtn);
        }

        public void loadDetails(String name, int percent, int position){
            this.position = position;
            discountName.setText(name);
            discountPercentage.setText(percent + "% Discount");
        }

        public void onClickRemoveButton(String name, int percent, int position){
            this.position = position;
            removeDiscountBtn.setOnClickListener(delete -> {
                listOfDiscountsApplied.remove(name, percent);
                notifyDataSetChanged();
            });
        }
    }
}
