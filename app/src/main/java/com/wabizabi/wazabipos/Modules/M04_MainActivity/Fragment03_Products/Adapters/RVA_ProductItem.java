package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Adapters;

import static com.wabizabi.wazabipos.Utilities.GlobalVariables.currentIndex;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.Schemas.ProductsItem;
import com.wabizabi.wazabipos.Modules.M05_CRUD.Activity_CRUD;
import com.wabizabi.wazabipos.R;

import io.realm.Realm;
import io.realm.RealmResults;

public class RVA_ProductItem extends RecyclerView.Adapter<RVA_ProductItem.RVH_ProductItem> {
    public static RealmResults<ProductsItem> listOfProductItems;
    Context context;
    Realm realm;


    public RVA_ProductItem(Context context, Realm realm) {
        this.context = context;
        this.realm = realm;

    }

    @NonNull
    @Override
    public RVH_ProductItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.act04_main_frag03_products_item_rvlayout, parent, false);
        RVH_ProductItem itemLayout = new RVH_ProductItem(viewLayout);
        return itemLayout;
    }

    @Override
    public void onBindViewHolder(@NonNull RVH_ProductItem holder, int position) {
        ProductsItem item = listOfProductItems.get(position);
        holder.getProducts(item, position);
        holder.itemRead.setOnClickListener((v) -> {
            currentIndex = holder.getAdapterPosition();
            context.startActivity(new Intent(context, Activity_CRUD.class));
        });
    }

    @Override
    public int getItemCount() {
        return listOfProductItems.size();
    }

    public class RVH_ProductItem extends RecyclerView.ViewHolder {
        private int position;
        TextView itemName, itemPrice, itemRead;
        public RVH_ProductItem(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.ProductsRV_ItemName);
            itemPrice = itemView.findViewById(R.id.ProductsRV_ItemPrice);
            itemRead = itemView.findViewById(R.id.ProductsRV_ItemView);
        }

        public void getProducts(ProductsItem item, int position){
            this.position = position;
            itemName.setText(item.getItemName());
            itemPrice.setText("₱" + String.valueOf(item.getItemPrice()) + "0");

        }
    }
}
