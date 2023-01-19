package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Adapters;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.M04F03_Products.M04F03_CurrentCategory;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.M04F03_Products.M04F03_CurrentCategoryIndex;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Adapters.M04F03_ItemRVA.listOfProductItems;

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

import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuCategory;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuItem;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Interfaces.Update_ProductsCurrentCategory;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Interfaces.Update_ProductsItemList;
import com.wabizabi.wazabipos.R;

import io.realm.RealmResults;

public class M04F03_CategoryRVA extends RecyclerView.Adapter<M04F03_CategoryRVA.RVH_ProductCategory> {
    public static RealmResults<RealmMenuCategory> listOfProductCategories;
    Update_ProductsCurrentCategory updateCurrentProduct;
    Update_ProductsItemList updateProducts;
    Dialog categoryDialog;
    Context context;
    io.realm.Realm realm;

    public M04F03_CategoryRVA(Update_ProductsCurrentCategory updateCurrentProduct, Update_ProductsItemList updateProducts, Dialog categoryDialog, Context context, io.realm.Realm realm) {
        this.updateCurrentProduct = updateCurrentProduct;
        this.updateProducts = updateProducts;
        this.categoryDialog = categoryDialog;
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
        RealmMenuCategory category = listOfProductCategories.get(position);
        holder.showCategory(category, position);
        holder.onClick(position);
        holder.onHold(category, position);
        holder.highlight(position);
    }

    @Override
    public int getItemCount() {
        return listOfProductCategories.size();
    }

    public class RVH_ProductCategory extends RecyclerView.ViewHolder {
        private int position;
        CardView categoryLayout;
        ImageView categoryImage;
        TextView categoryName;
        public RVH_ProductCategory(@NonNull View itemView) {
            super(itemView);
            categoryLayout = itemView.findViewById(R.id.M04F03_RVCategoryContainer);
            categoryImage = itemView.findViewById(R.id.M04F03_RVCategoryImage);
            categoryName = itemView.findViewById(R.id.M04F03_RVCategoryName);
        }

        public void showCategory(RealmMenuCategory category, int position){
            this.position  = position;
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

        public void onClick(int position){
            categoryLayout.setOnClickListener(v -> {
                M04F03_CurrentCategoryIndex = position;
                notifyDataSetChanged();
                RealmResults<RealmMenuCategory> categories = realm.where(RealmMenuCategory.class).sort("categoryName").findAll();
                RealmMenuCategory currentIndex = categories.get(M04F03_CurrentCategoryIndex);
                M04F03_CurrentCategory = currentIndex.getCategoryName();
                listOfProductItems = realm.where(RealmMenuItem.class).equalTo("itemCategory", M04F03_CurrentCategory).sort("itemName").findAll();
                updateProducts.refreshItemList(position, listOfProductItems);
            });
        }

        public void onHold(RealmMenuCategory category, int position){
            categoryLayout.setOnLongClickListener(v -> {
                M04F03_CurrentCategoryIndex = position;
                M04F03_CurrentCategory = category.getCategoryName();
                notifyDataSetChanged();
                updateCurrentProduct.updateCurrentProduct();
                updateProducts.refreshItemList(position, listOfProductItems);
                categoryDialog.show();
                return false;
            });
        }

        public void highlight(int position){
            if(M04F03_CurrentCategoryIndex == position){
                categoryLayout.setCardBackgroundColor(ContextCompat.getColor(context, R.color.white));
            } else {
                categoryLayout.setCardBackgroundColor(ContextCompat.getColor(context, R.color.gray));
            }
        }
    }
}
