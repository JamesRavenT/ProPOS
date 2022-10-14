package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.Schemas.StockItem;
import com.wabizabi.wazabipos.R;

import io.realm.Realm;
import io.realm.RealmResults;

public class RVA_StockItem extends RecyclerView.Adapter<RVA_StockItem.ViewHolder> {
    public static RealmResults<StockItem> listOfStockItems;
    Context context;
    Realm realm;

    public RVA_StockItem(Context context, Realm realm) {
        this.context = context;
        this.realm = realm;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.act04_main_frag02_stocks_item_rvlayout, parent, false);
        ViewHolder categoryLayout = new ViewHolder(viewLayout);
        return categoryLayout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StockItem item = listOfStockItems.get(position);
        holder.getStockItems(item, position);

    }

    @Override
    public int getItemCount() {
        return listOfStockItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        ImageView itemImage;
        TextView itemName, itemAmount, viewItemBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.M04F02_RVItemImage);
            itemName = itemView.findViewById(R.id.M04F02_RVItemName);
            itemAmount = itemView.findViewById(R.id.M04F02_RVItemAmount);
            viewItemBtn = itemView.findViewById(R.id.M04F02_RVItemView);
        }

        public void getStockItems(StockItem item, int position){
            this.position = position;
            itemName.setText(item.getItemName());
            itemAmount.setText("In stock: " + item.getItemAmount());
            switch(item.getItemImage()){
                case 0:
                    itemImage.setImageResource(R.drawable.icon_stocks00_default);
                    break;
                case 1:
                    itemImage.setImageResource(R.drawable.icon_stocks01_meat);
                    break;
                case 2:
                    itemImage.setImageResource(R.drawable.icon_stocks02_fish);
                    break;
                case 3:
                    itemImage.setImageResource(R.drawable.icon_stocks03_fruit);
                    break;
                case 4:
                    itemImage.setImageResource(R.drawable.icon_stocks04_vegetable);
                    break;
                case 5:
                    itemImage.setImageResource(R.drawable.icon_stocks05_grains);
                    break;
                case 6:
                    itemImage.setImageResource(R.drawable.icon_stocks06_spices);
                    break;
                case 7:
                    itemImage.setImageResource(R.drawable.icon_stocks07_japanese);
                    break;
            }
        }
    }
}
