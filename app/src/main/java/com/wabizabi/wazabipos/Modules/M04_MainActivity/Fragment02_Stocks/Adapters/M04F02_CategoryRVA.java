package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Adapters;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Adapters.M04F02_ItemRVA.listOfStockItems;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.M04F02_Stocks.M04F02_CurrentCategory;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.M04F02_Stocks.M04F02_CurrentCategoryIndex;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.Schemas.StockItem;
import com.wabizabi.wazabipos.Database.Schemas.StockList;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Interfaces.Update_StocksCurrentCategory;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Interfaces.Update_StocksItemList;
import com.wabizabi.wazabipos.R;

import io.realm.Realm;
import io.realm.RealmResults;

public class M04F02_CategoryRVA extends RecyclerView.Adapter<M04F02_CategoryRVA.ViewHolder> {

    public static RealmResults<StockList> listOfStockCategories;
    Update_StocksCurrentCategory updateCurrentStock;
    Update_StocksItemList updateItemsRV;
    Dialog categoryDialog;
    Context context;
    Realm realm;

    public M04F02_CategoryRVA(Update_StocksCurrentCategory updateCurrentStock, Update_StocksItemList updateItemsRV, Dialog categoryDialog, Context context, Realm realm) {
        this.updateCurrentStock = updateCurrentStock;
        this.updateItemsRV = updateItemsRV;
        this.categoryDialog = categoryDialog;
        this.context = context;
        this.realm = realm;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.act04_main_frag02_stocks_category_rvlayout, parent, false);
        ViewHolder categoryLayout = new ViewHolder(viewLayout);
        return categoryLayout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StockList category = listOfStockCategories.get(position);
        holder.showCategory(category, position);
        holder.onClick(position);
        holder.onHold(category, position);
        holder.highlight();
    }

    @Override
    public int getItemCount() {
        return listOfStockCategories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        CardView categoryLayout;
        ImageView categoryImage;
        TextView categoryName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.M04F02_RVCategoryNameTxt);
            categoryImage = itemView.findViewById(R.id.M04F02_RVCategoryImage);
            categoryLayout = itemView.findViewById(R.id.M04F02_RVCategoryContainer);
        }

        public void showCategory(StockList category, int position){
            this.position = position;
            categoryName.setText(category.getCategoryName());
            switch (category.getCategoryImage()) {
                case 0:
                    categoryImage.setImageResource(R.drawable.icon_stocks00_default);
                    break;
                case 1:
                    categoryImage.setImageResource(R.drawable.icon_stocks01_meat);
                    break;
                case 2:
                    categoryImage.setImageResource(R.drawable.icon_stocks02_fish);
                    break;
                case 3:
                    categoryImage.setImageResource(R.drawable.icon_stocks03_fruit);
                    break;
                case 4:
                    categoryImage.setImageResource(R.drawable.icon_stocks04_vegetable);
                    break;
                case 5:
                    categoryImage.setImageResource(R.drawable.icon_stocks05_grains);
                    break;
                case 6:
                    categoryImage.setImageResource(R.drawable.icon_stocks06_spices);
                    break;
                case 7:
                    categoryImage.setImageResource(R.drawable.icon_stocks07_japanese);
                    break;
            }
        }

        public void onClick(int position){
            categoryLayout.setOnClickListener(v -> {
                M04F02_CurrentCategoryIndex = position;
                notifyDataSetChanged();
                RealmResults<StockList> categories = realm.where(StockList.class).sort("categoryName").findAll();
                StockList currentIndex = categories.get(M04F02_CurrentCategoryIndex);
                M04F02_CurrentCategory = currentIndex.getCategoryName();
                listOfStockItems = realm.where(StockItem.class).equalTo("itemCategory", M04F02_CurrentCategory).sort("itemName").findAll();
                updateItemsRV.refreshItemList(position, listOfStockItems);
            });
        }

        public void onHold(StockList category, int position){
            categoryLayout.setOnLongClickListener((v) -> {
                M04F02_CurrentCategoryIndex = position;
                M04F02_CurrentCategory = category.getCategoryName();
                notifyDataSetChanged();
                updateCurrentStock.updateCurrentStock();
                updateItemsRV.refreshItemList(position, listOfStockItems);
                categoryDialog.show();
                return false;
            });
        }

        public void highlight(){
            if(M04F02_CurrentCategoryIndex == position){
                categoryLayout.setCardBackgroundColor(ContextCompat.getColor(context, R.color.white));
            } else {
                categoryLayout.setCardBackgroundColor(ContextCompat.getColor(context, R.color.gray));
            }
        }
    }
}
