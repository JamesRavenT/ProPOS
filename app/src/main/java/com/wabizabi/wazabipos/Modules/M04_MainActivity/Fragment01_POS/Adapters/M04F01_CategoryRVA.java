package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Adapters;


import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Adapters.M04F01_ItemRVA.listOfPOSItems;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.M04_Main.currentPOSCategory;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.M04_Main.currentPOSCategoryIndex;

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

import com.wabizabi.wazabipos.Database.Schemas.ProductsItem;
import com.wabizabi.wazabipos.Database.Schemas.ProductsList;
import com.wabizabi.wazabipos.Utilities.Interfaces.Update_POSItemList;
import com.wabizabi.wazabipos.R;

import io.realm.Realm;
import io.realm.RealmResults;

public class M04F01_CategoryRVA extends RecyclerView.Adapter<M04F01_CategoryRVA.ViewHolder> {

    public static RealmResults<ProductsList> listOfPOSCategories;
    Update_POSItemList updatePOSitemList;
    Context context;
    Realm realm;


    public M04F01_CategoryRVA(Update_POSItemList updatePOS, Context context, Realm realm) {
        this.updatePOSitemList = updatePOS;
        this.context = context;
        this.realm = realm;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.act04_main_frag01_pos_category_rvlayout, parent, false);
        ViewHolder categoryVH = new ViewHolder(viewLayout);
        return categoryVH;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductsList category = listOfPOSCategories.get(position);
        holder.getPOSCategory(category, position);
        holder.categoryLayout.setOnClickListener((v) -> updateItemsRV(holder, position));
        if(currentPOSCategoryIndex == position){
            holder.categoryLayout.setCardBackgroundColor(ContextCompat.getColor(context, R.color.WazabiTheme));
            holder.categoryName.setTextColor(ContextCompat.getColor(context, R.color.white));
        } else {
            holder.categoryLayout.setCardBackgroundColor(ContextCompat.getColor(context, R.color.white));
            holder.categoryName.setTextColor(ContextCompat.getColor(context, R.color.WazabiTheme));
        }

    }

    @Override
    public int getItemCount() {
        return listOfPOSCategories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        private final CardView categoryLayout;
        private final ImageView categoryImage;
        private final TextView categoryName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryLayout = itemView.findViewById(R.id.M04F01_CRVContainer);
            categoryImage = itemView.findViewById(R.id.M04F01_CRVCategoryImage);
            categoryName = itemView.findViewById(R.id.M04F01_CRVCategoryNameTxt);
        }

        public void getPOSCategory(ProductsList category, int position){
            this.position = position;
            categoryName.setText(category.getCategoryName());
            switch(category.getCategoryImage()){
                case 0:
                    categoryImage.setImageResource(R.drawable.icon_products00_default);
                    break;
                case 1:
                    categoryImage.setImageResource(R.drawable.icon_products01_deepfried);
                    break;
                case 2:
                    categoryImage.setImageResource(R.drawable.icon_products02_desserts);
                    break;
                case 3:
                    categoryImage.setImageResource(R.drawable.icon_products03_donburi);
                    break;
                case 4:
                    categoryImage.setImageResource(R.drawable.icon_products04_drinks);
                    break;
                case 5:
                    categoryImage.setImageResource(R.drawable.icon_products05_nigiri);
                    break;
                case 6:
                    categoryImage.setImageResource(R.drawable.icon_products06_noodles);
                    break;
                case 7:
                    categoryImage.setImageResource(R.drawable.icon_products07_salad);
                    break;
                case 8:
                    categoryImage.setImageResource(R.drawable.icon_products08_sashimi);
                    break;
                case 9:
                    categoryImage.setImageResource(R.drawable.icon_products09_sushi);
                    break;
                case 10:
                    categoryImage.setImageResource(R.drawable.icon_products10_sushirolls);
                    break;
            }
        }
    }

    private void updateItemsRV(@NonNull ViewHolder holder, int position){
        currentPOSCategoryIndex = holder.getAdapterPosition();
        notifyDataSetChanged();
        RealmResults<ProductsList> categories = realm.where(ProductsList.class).sort("categoryName").findAll();
        ProductsList currentIndex = categories.get(currentPOSCategoryIndex);
        currentPOSCategory = currentIndex.getCategoryName();
        listOfPOSItems = realm.where(ProductsItem.class).equalTo("itemCategory", currentPOSCategory).sort("itemName").findAll();
        updatePOSitemList.refreshItemList(position, listOfPOSItems);

    }
}
