package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.Categories.Read.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.Schemas.ProductsItem;
import com.wabizabi.wazabipos.R;

import io.realm.RealmResults;

public class M04F03OPCR_ReadCategoryRVA extends RecyclerView.Adapter<M04F03OPCR_ReadCategoryRVA.ViewHolder> {
    public static RealmResults<ProductsItem> listOfAssociatedProductItems;
    Context context;

    public M04F03OPCR_ReadCategoryRVA(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.act04_main_frag03_products_operation_crud_categoryread_rvlayout, parent, false);
        ViewHolder viewLayout = new ViewHolder(layout);
        return viewLayout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductsItem item = listOfAssociatedProductItems.get(position);
        holder.showItems(item, position);
    }

    @Override
    public int getItemCount() {
        return listOfAssociatedProductItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        int position;
        ImageView itemImage;
        TextView itemName, itemPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.M04F03OPCR_RVItemImage);
            itemName = itemView.findViewById(R.id.M04F03OPCR_RVItemName);
            itemPrice = itemView.findViewById(R.id.M04F03OPCR_RVItemPrice);
        }

        public void showItems(ProductsItem item, int position){
            this.position = position;
            itemName.setText(item.getItemName());
            switch(item.getItemImage()){
                case 0:
                    itemImage.setImageResource(R.drawable.icon_products00_default);
                    break;
                case 1:
                    itemImage.setImageResource(R.drawable.icon_products01_carpaccio);
                    break;
                case 2:
                    itemImage.setImageResource(R.drawable.icon_products02_deepfried);
                    break;
                case 3:
                    itemImage.setImageResource(R.drawable.icon_products03_dessert);
                    break;
                case 4:
                    itemImage.setImageResource(R.drawable.icon_products04_donburi);
                    break;
                case 5:
                    itemImage.setImageResource(R.drawable.icon_products05_drinks);
                    break;
                case 6:
                    itemImage.setImageResource(R.drawable.icon_products06_nigiri);
                    break;
                case 7:
                    itemImage.setImageResource(R.drawable.icon_products07_noodles);
                    break;
                case 8:
                    itemImage.setImageResource(R.drawable.icon_products08_platter);
                    break;
                case 9:
                    itemImage.setImageResource(R.drawable.icon_products09_salad);
                    break;
                case 10:
                    itemImage.setImageResource(R.drawable.icon_products10_sushi);
                    break;
            }
        }
    }
}