package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Adapters;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.M04F02_Stocks.M04F02_CurrentItem;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.M04F02_Stocks.M04F02_CurrentItemIndex;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.M04F02OP_CRUD.operationForM04F02OP;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.Schemas.StockItem;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.M04F02OP_CRUD;
import com.wabizabi.wazabipos.R;

import io.realm.Realm;
import io.realm.RealmResults;

public class M04F02_ItemRVA extends RecyclerView.Adapter<M04F02_ItemRVA.ViewHolder> {
    public static RealmResults<StockItem> listOfStockItems;
    Dialog itemDialog;
    Context context;
    Realm realm;

    public M04F02_ItemRVA(Dialog itemDialog, Context context, Realm realm) {
        this.itemDialog = itemDialog;
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
        holder.showItems(item, position);
        holder.onHoldLayout(item, position);
        holder.onClickManage(item, position);
    }

    @Override
    public int getItemCount() {
        return listOfStockItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        ImageView itemImage;
        TextView itemName, itemAmount, updateItemBtn;
        CardView itemLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.M04F02_RVItemImage);
            itemName = itemView.findViewById(R.id.M04F02_RVItemName);
            itemAmount = itemView.findViewById(R.id.M04F02_RVItemAmount);
            updateItemBtn = itemView.findViewById(R.id.M04F02_RVItemManage);
            itemLayout = itemView.findViewById(R.id.M04F02_RVItemContainer);
        }

        public void showItems(StockItem item, int position){
            this.position = position;
            itemName.setText(item.getItemName());
            itemAmount.setText("In stock: " + item.getItemAmount() + " " + item.getItemUnit());
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

        public void onHoldLayout(StockItem item, int position){
            itemLayout.setOnLongClickListener(v -> {
                M04F02_CurrentItemIndex = position;
                M04F02_CurrentItem = item.getItemName();
                itemDialog.show();
                return false;
            });
        }

        public void onClickManage(StockItem item, int position){
            updateItemBtn.setOnClickListener(v -> {
                M04F02_CurrentItemIndex = position;
                M04F02_CurrentItem = item.getItemName();
                operationForM04F02OP = "Update Item";
                context.startActivity(new Intent(context, M04F02OP_CRUD.class));
            });
        }
    }
}
