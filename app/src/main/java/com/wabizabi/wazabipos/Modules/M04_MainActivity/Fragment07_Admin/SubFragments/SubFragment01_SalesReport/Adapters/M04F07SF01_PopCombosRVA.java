package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment07_Admin.SubFragments.SubFragment01_SalesReport.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.ObjectSchemas.PopCombination;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.LayoutHelper;

import java.util.List;

import io.realm.Realm;

public class M04F07SF01_PopCombosRVA extends RecyclerView.Adapter<M04F07SF01_PopCombosRVA.ViewHolder> {
    Context context;
    Realm realm;
    List<PopCombination> listOfCombos;

    public M04F07SF01_PopCombosRVA(Context context, Realm realm, List<PopCombination> listOfCombos) {
        this.context = context;
        this.realm = realm;
        this.listOfCombos = listOfCombos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutHelper.inflateRV(parent, R.layout.act04_main_frag07_admin_subfrag01_salesreport_popcombo_rvlayout);
        ViewHolder layout = new ViewHolder(view);
        return layout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PopCombination itemSet = listOfCombos.get(position);
        holder.loadFunctionalities(itemSet, position);
    }

    @Override
    public int getItemCount() {
        return listOfCombos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        private TextView setFrequency, setItems;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            setFrequency = itemView.findViewById(R.id.M04F07SF01_CRVFrequency);
            setItems = itemView.findViewById(R.id.M04F07SF01_CRVItemSet);
        }

        public void loadFunctionalities(PopCombination itemSet, int position){
            //Load Details
            String frequency = "「　Sold " + itemSet.getFrequency() + " times　」";
            String fqItemset = itemSet.getItemSet().toString()
                    .replace("[", "・")
                    .replace("]", "")
                    .replace(",", "\n・");
            //Set Views
            this.position = position;
            setFrequency.setText(frequency);
            setItems.setText(fqItemset);
        }
    }
}
