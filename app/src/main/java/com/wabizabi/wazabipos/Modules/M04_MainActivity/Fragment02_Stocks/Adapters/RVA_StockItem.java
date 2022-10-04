package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Adapters;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.Schemas.StockItem;
import com.wabizabi.wazabipos.R;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class RVA_StockItem extends RecyclerView.Adapter<RVA_StockItem.RVH_StockItem> {
    public static RealmResults<StockItem> listOfStockItems;
    Context context;
    Realm realm;

    public RVA_StockItem(Context context, Realm realm) {
        this.context = context;
        this.realm = realm;
    }

    @NonNull
    @Override
    public RVH_StockItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.act04_main_frag02_stocks_category_rvlayout, parent, false);
        RVH_StockItem categoryLayout = new RVH_StockItem(viewLayout);
        return categoryLayout;
    }

    @Override
    public void onBindViewHolder(@NonNull RVH_StockItem holder, int position) {
        StockItem item = listOfStockItems.get(position);
        holder.getStockItems(item, position);

    }

    @Override
    public int getItemCount() {
        return listOfStockItems.size();
    }

    public class RVH_StockItem extends RecyclerView.ViewHolder {
        private int position;
        TextView itemName, itemAmount, viewItemBtn;
        public RVH_StockItem(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.StocksRV_ItemName);
            itemAmount = itemView.findViewById(R.id.StocksRV_ItemAmount);
            viewItemBtn = itemView.findViewById(R.id.StocksRV_ItemView);
        }

        public void getStockItems(StockItem item, int position){
            this.position = position;
            itemName.setText(item.getItemName());
            itemAmount.setText("In stock: " + item.getItemAmount());
        }
    }
}
