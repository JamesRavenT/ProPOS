package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Objects.CartObject;

import java.util.LinkedHashMap;
import java.util.Map;

public class RVA_POSCart extends RecyclerView.Adapter<RVA_POSCart.RVH_POSCart> {

    public static Map<CartObject, Integer> cart = new LinkedHashMap<>();

    @NonNull
    @Override
    public RVH_POSCart onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RVH_POSCart holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class RVH_POSCart extends RecyclerView.ViewHolder {
        public RVH_POSCart(@NonNull View itemView) {
            super(itemView);
        }
    }
}
