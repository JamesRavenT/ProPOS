package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Adapters;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Adapters.RVA_StockItem.listOfStockItems;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.M04F02_Stocks.currentStockCategory;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.M04F02_Stocks.currentStockCategoryIndex;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.SubModule.M04F02SM01_CRUD.setOperationForM04F02;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.Schemas.StockItem;
import com.wabizabi.wazabipos.Database.Schemas.StockList;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Interfaces.Update_StocksItemList;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.SubModule.M04F02SM01_CRUD;
import com.wabizabi.wazabipos.R;

import io.realm.Realm;
import io.realm.RealmResults;

public class RVA_StockCategory extends RecyclerView.Adapter<RVA_StockCategory.ViewHolder> {

    public static RealmResults<StockList> listOfStockCategories;
    Update_StocksItemList updateItemsRV;
    Context context;
    Realm realm;

    public RVA_StockCategory(Update_StocksItemList update, Context context, Realm realm) {
        this.updateItemsRV = update;
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
        holder.categoryLayout.setOnClickListener((v) -> updateItemsRV(holder, position));
        holder.categoryLayout.setOnLongClickListener((v) -> {
            currentStockCategoryIndex = holder.getAdapterPosition();
            currentStockCategory = category.getCategoryName();
            setOperationForM04F02 = "View Category";
            context.startActivity(new Intent(context, M04F02SM01_CRUD.class));
            return false;
        });

        if(currentStockCategoryIndex == position){
            holder.categoryLayout.setCardBackgroundColor(ContextCompat.getColor(context, R.color.white));
        } else {
            holder.categoryLayout.setCardBackgroundColor(ContextCompat.getColor(context, R.color.gray));
        }


    }

    @Override
    public int getItemCount() {
        return listOfStockCategories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        CardView categoryLayout;
        TextView categoryName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.StocksRV_CategoryNameTxt);
            categoryLayout = itemView.findViewById(R.id.StocksRV_CategoryContainer);
        }

        public void showCategory(StockList category, int position){
            this.position = position;
            categoryName.setText(category.getCategoryName());
        }
    }

    private void updateItemsRV(@NonNull ViewHolder holder, int position){
        currentStockCategoryIndex = holder.getAdapterPosition();
        notifyDataSetChanged();

        RealmResults<StockList> categories = realm.where(StockList.class).sort("categoryName").findAll();
        StockList currentIndex = categories.get(currentStockCategoryIndex);
        currentStockCategory = currentIndex.getCategoryName();
        listOfStockItems = realm.where(StockItem.class).equalTo("itemCategory", currentStockCategory).sort("itemName").findAll();
        updateItemsRV.refreshItemList(position, listOfStockItems);
    }

}
