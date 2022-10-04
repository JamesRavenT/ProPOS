package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Adapters;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Activity_Main.currentPOSCategory;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Activity_Main.currentPOSCategoryIndex;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Activity_Main.currentProductCategory;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Activity_Main.currentProductCategoryIndex;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Adapters.RVA_POSItem.listOfPOSItems;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Adapters.RVA_ProductItem.listOfProductItems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.Schemas.ProductsItem;
import com.wabizabi.wazabipos.Database.Schemas.ProductsList;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Interfaces.Update_ProductsItemList;
import com.wabizabi.wazabipos.R;

import io.realm.Realm;
import io.realm.RealmResults;

public class RVA_ProductCategory extends RecyclerView.Adapter<RVA_ProductCategory.RVH_ProductCategory> {
    public static RealmResults<ProductsList> listOfProductCategories;
    Update_ProductsItemList updateProducts;
    Context context;
    Realm realm;

    public RVA_ProductCategory(Update_ProductsItemList updateProducts, Context context, Realm realm) {
        this.updateProducts = updateProducts;
        this.context = context;
        this.realm = realm;
    }

    @NonNull
    @Override
    public RVH_ProductCategory onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.act04_main_frag03_products_category_rvlayout, parent, false);
        RVH_ProductCategory categoryLayout = new RVH_ProductCategory(viewLayout);
        return categoryLayout;
    }

    @Override
    public void onBindViewHolder(@NonNull RVH_ProductCategory holder, int position) {
        ProductsList category = listOfProductCategories.get(position);
        holder.getCategories(category, position);
        holder.categoryLayout.setOnClickListener((v) -> updateItemsRV(holder, position));
        if(currentProductCategoryIndex == position){
            holder.categoryLayout.setCardBackgroundColor(ContextCompat.getColor(context, R.color.white));
        } else {
            holder.categoryLayout.setCardBackgroundColor(ContextCompat.getColor(context, R.color.gray));
        }
    }

    @Override
    public int getItemCount() {
        return listOfProductCategories.size();
    }

    public class RVH_ProductCategory extends RecyclerView.ViewHolder {
        private int position;
        CardView categoryLayout;
        TextView categoryName;
        public RVH_ProductCategory(@NonNull View itemView) {
            super(itemView);
            categoryLayout = itemView.findViewById(R.id.ProductsRV_CategoryContainer);
            categoryName = itemView.findViewById(R.id.ProductsRV_CategoryNameTxt);
        }

        public void getCategories(ProductsList item, int position){
            this.position  = position;
            categoryName.setText(item.getCategoryName());
        }
    }

    private void updateItemsRV(@NonNull RVA_ProductCategory.RVH_ProductCategory holder, int position){
        currentProductCategoryIndex = holder.getAdapterPosition();
        notifyDataSetChanged();

        RealmResults<ProductsList> categories = realm.where(ProductsList.class).sort("categoryName").findAll();
        ProductsList currentIndex = categories.get(currentProductCategoryIndex);
        currentProductCategory = currentIndex.getCategoryName();
        listOfProductItems = realm.where(ProductsItem.class).equalTo("itemCategory", currentProductCategory).sort("itemName").findAll();
        updateProducts.refreshItemList(position, listOfProductItems);

    }
}
