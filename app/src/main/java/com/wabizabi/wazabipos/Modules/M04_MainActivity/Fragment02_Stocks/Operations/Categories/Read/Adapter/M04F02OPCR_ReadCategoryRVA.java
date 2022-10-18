package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.Categories.Read.Adapter;

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

import io.realm.RealmResults;

public class M04F02OPCR_ReadCategoryRVA extends RecyclerView.Adapter<M04F02OPCR_ReadCategoryRVA.ViewHolder> {

    public static RealmResults<StockItem> listOfAssociatedStockItems;
    Context context;

    public M04F02OPCR_ReadCategoryRVA(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.act04_main_frag02_stocks_operation_crud_categoryread_rvlayout, parent, false);
        ViewHolder itemLayout = new ViewHolder(layout);
        return itemLayout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StockItem item = listOfAssociatedStockItems.get(position);
        holder.showItems(item, position);
    }

    @Override
    public int getItemCount() {
        return listOfAssociatedStockItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        int position;
        ImageView itemImage;
        TextView itemName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.M04F02OPCR_RVItemImage);
            itemName = itemView.findViewById(R.id.M04F02OPCR_RVItemName);
        }

        public void showItems(StockItem item, int position){
            this.position = position;
            setImage(itemImage, item.getItemImage());
            itemName.setText(item.getItemName());
        }

        public void setImage(ImageView image, int iconNumber){
            switch (iconNumber){
                case 0:
                    image.setImageResource(R.drawable.icon_stocks00_default);
                    break;
                case 1:
                    image.setImageResource(R.drawable.icon_stocks01_meat);
                    break;
                case 2:
                    image.setImageResource(R.drawable.icon_stocks02_fish);
                    break;
                case 3:
                    image.setImageResource(R.drawable.icon_stocks03_fruit);
                    break;
                case 4:
                    image.setImageResource(R.drawable.icon_stocks04_vegetable);
                    break;
                case 5:
                    image.setImageResource(R.drawable.icon_stocks05_grains);
                    break;
                case 6:
                    image.setImageResource(R.drawable.icon_stocks06_spices);
                    break;
                case 7:
                    image.setImageResource(R.drawable.icon_stocks07_japanese);
                    break;
            }
        }
    }
}
