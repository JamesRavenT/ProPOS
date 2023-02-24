package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment07_Admin.SubFragments.SubFragment01_SalesReport.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.ObjectSchemas.PopItem;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuItem;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.IconHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.LayoutHelper;

import java.util.List;

import io.realm.Realm;

public class M04F07SF01_PopItemRVA extends RecyclerView.Adapter<M04F07SF01_PopItemRVA.ViewHolder> {
    Context context;
    Realm realm;
    List<PopItem> listOfPopItems;

    public M04F07SF01_PopItemRVA(Context context, Realm realm, List<PopItem> listOfPopItems) {
        this.context = context;
        this.realm = realm;
        this.listOfPopItems = listOfPopItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutHelper.inflateRV(parent, R.layout.act04_main_frag07_admin_subfrag01_salesreport_popitem_rvlayout);
        ViewHolder layout = new ViewHolder(view);
        return layout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PopItem item = listOfPopItems.get(position);
        holder.loadFunctionalities(item, position);
    }

    @Override
    public int getItemCount() {
        return listOfPopItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        private ImageView itemIcon;
        private TextView itemFrequency, itemName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemIcon = itemView.findViewById(R.id.M04F07SF01_IRVItemIcon);
            itemFrequency = itemView.findViewById(R.id.M04F07SF01_IRVFrequency);
            itemName = itemView.findViewById(R.id.M04F07SF01_IRVItemName);
        }

        public void loadFunctionalities(PopItem item, int position){
            //Load Details
            RealmMenuItem i = realm.where(RealmMenuItem.class).equalTo("itemWebName", item.getName()).findFirst();
            if(i != null){
                int icon = i.getItemIcon();
                String frequency = "「　Sold " + item.getFrequency() + " times　」";
                String name = item.getName();

                //Set Views
                this.position = position;
                IconHelper.setMenuIcon(itemIcon, icon);
                itemFrequency.setText(frequency);
                itemName.setText(name);
            } else {
                String frequency = "「　Sold " + item.getFrequency() + " times　」";
                String name = item.getName();

                //Set Views
                this.position = position;
                itemFrequency.setText(frequency);
                itemName.setText(name);
            }
        }
    }
}
