package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Adapters;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Activity_Main.currentPOSCategory;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Activity_Main.currentPOSCategoryIndex;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Adapters.RVA_POSItem.listOfPOSItems;

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
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Interfaces.Update_POSItemList;
import com.wabizabi.wazabipos.R;

import io.realm.Realm;
import io.realm.RealmResults;

public class RVA_POSCategory extends RecyclerView.Adapter<RVA_POSCategory.RVH_POSCategory> {

    public static RealmResults<ProductsList> listOfPOSCategories;
    Update_POSItemList updatePOSitemList;
    Context context;
    Realm realm;


    public RVA_POSCategory(Update_POSItemList updatePOS, Context context, Realm realm) {
        this.updatePOSitemList = updatePOS;
        this.context = context;
        this.realm = realm;

    }

    @NonNull
    @Override
    public RVH_POSCategory onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.act04_main_frag01_pos_category_rvlayout, parent, false);
        RVH_POSCategory categoryVH = new RVH_POSCategory(viewLayout);
        return categoryVH;
    }

    @Override
    public void onBindViewHolder(@NonNull RVH_POSCategory holder, int position) {
        ProductsList category = listOfPOSCategories.get(position);
        holder.getPOSCategory(category, position);
        holder.layout.setOnClickListener((v) -> updateItemsRV(holder, position));
        if(currentPOSCategoryIndex == position){
            holder.layout.setCardBackgroundColor(ContextCompat.getColor(context, R.color.white));
        } else {
            holder.layout.setCardBackgroundColor(ContextCompat.getColor(context, R.color.gray));
        }

    }

    @Override
    public int getItemCount() {
        return listOfPOSCategories.size();
    }

    public class RVH_POSCategory extends RecyclerView.ViewHolder {
        private int position;
        private CardView layout;
        private TextView categoryName;
        public RVH_POSCategory(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.POS_CategoryContainer);
            categoryName = itemView.findViewById(R.id.POS_CategoryNameTxt);
        }

        public void getPOSCategory(ProductsList category, int position){
            this.position = position;
            categoryName.setText(category.getCategoryName());
        }
    }

    private void updateItemsRV(@NonNull RVH_POSCategory holder, int position){
        currentPOSCategoryIndex = holder.getAdapterPosition();
        notifyDataSetChanged();

        RealmResults<ProductsList> categories = realm.where(ProductsList.class).sort("categoryName").findAll();
        ProductsList currentIndex = categories.get(currentPOSCategoryIndex);
        currentPOSCategory = currentIndex.getCategoryName();
        listOfPOSItems = realm.where(ProductsItem.class).equalTo("itemCategory", currentPOSCategory).sort("itemName").findAll();
        updatePOSitemList.refreshItemList(position, listOfPOSItems);

    }
}
