package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Adapters;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.M04F01_POS.currentPOSCategoryIndex;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.M04F01_POS.currentPOSCategoryName;

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

import com.wabizabi.wazabipos.Database.ObjectSchemas.MenuCategory;
import com.wabizabi.wazabipos.Database.ObjectSchemas.MenuItem;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuCategory;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuItem;
import com.wabizabi.wazabipos.Utilities.Interfaces.RVMenuLoader;
import com.wabizabi.wazabipos.R;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class M04F01_CategoryRVA extends RecyclerView.Adapter<M04F01_CategoryRVA.ViewHolder> {

    Context context;
    Realm realm;
    RVMenuLoader rvLoader;
    List<MenuCategory> listOfCategories;
    List<MenuItem> listOfItems;

    public M04F01_CategoryRVA(Context context,
                              io.realm.Realm realm,
                              List<MenuCategory> listOfCategories,
                              List<MenuItem> listOfItems,
                              RVMenuLoader rvLoader) {
        this.context = context;
        this.realm = realm;
        this.listOfCategories = listOfCategories;
        this.listOfItems = listOfItems;
        this.rvLoader = rvLoader;
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
        MenuCategory category = listOfCategories.get(position);
        holder.getPOSCategory(category, position);
        holder.onClick(holder, position);
    }

    @Override
    public int getItemCount() {
        return listOfCategories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        private final CardView categoryContainer;
        private final ImageView categoryImage;
        private final TextView categoryName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryContainer = itemView.findViewById(R.id.M04F01_CRVContainer);
            categoryImage = itemView.findViewById(R.id.M04F01_CRVCategoryImage);
            categoryName = itemView.findViewById(R.id.M04F01_CRVCategoryNameTxt);
        }

        public void getPOSCategory(MenuCategory category, int position){
            this.position = position;
            if(category.getCategoryName().length() < 14) {
                categoryName.setText(category.getCategoryName());
            } else {
                categoryName.setText(category.getCategoryName().substring(0, Math.min(category.getCategoryName().length(), 10)) + "...");
            }
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
        public void onClick(ViewHolder holder, int position){
            this.position = position;
            categoryContainer.setOnClickListener(onselect -> updateItems(holder, position));
            if(currentPOSCategoryIndex == position){
                categoryContainer.setCardBackgroundColor(ContextCompat.getColor(context, R.color.wabizabi));
                categoryName.setTextColor(ContextCompat.getColor(context, R.color.white));
            } else {
                categoryContainer.setCardBackgroundColor(ContextCompat.getColor(context, R.color.white));
                categoryName.setTextColor(ContextCompat.getColor(context, R.color.wabizabi));
            }
        }
    }

    private void updateItems(@NonNull ViewHolder holder, int position){
        currentPOSCategoryIndex = holder.getAdapterPosition();
        notifyDataSetChanged();
        RealmResults<RealmMenuCategory> categories = realm.where(RealmMenuCategory.class).sort("categoryName").findAll();
        RealmMenuCategory currentIndex = categories.get(currentPOSCategoryIndex);
        currentPOSCategoryName = currentIndex.getCategoryName();
        RealmResults<RealmMenuItem> query = realm.where(RealmMenuItem.class).equalTo("itemCategory", currentPOSCategoryName).sort("itemName").findAll();
        listOfItems.clear();
        for(RealmMenuItem queriedItem : query){
            listOfItems.add(new MenuItem(queriedItem.getItemImage(), queriedItem.getItemName(), queriedItem.getItemPrice()));
        }
        rvLoader.load_RVContents(listOfItems);
    }
}
