package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Adapters;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.M04F03_Products.M04F03_CurrentItem;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.M04F03_Products.M04F03_CurrentItemIndex;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.Schemas.ProductsItem;
import com.wabizabi.wazabipos.R;

import io.realm.Realm;
import io.realm.RealmResults;

public class M04F03_ItemRVA extends RecyclerView.Adapter<M04F03_ItemRVA.RVH_ProductItem> {
    public static RealmResults<ProductsItem> listOfProductItems;
    Dialog itemDialog;
    Context context;
    Realm realm;


    public M04F03_ItemRVA(Dialog itemDialog, Context context, Realm realm) {
        this.itemDialog = itemDialog;
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
        holder.showItems(item, position);
        holder.onHold(item, position);

    }

    @Override
    public int getItemCount() {
        return listOfProductItems.size();
    }

    public class RVH_ProductItem extends RecyclerView.ViewHolder {
        private int position;
        CardView itemLayout;
        ImageView itemImage;
        TextView itemName, itemPrice;
        public RVH_ProductItem(@NonNull View itemView) {
            super(itemView);
            itemLayout = itemView.findViewById(R.id.M04F03_RVItemContainer);
            itemImage = itemView.findViewById(R.id.M04F03_RVItemImage);
            itemName = itemView.findViewById(R.id.M04F03_RVItemName);
            itemPrice = itemView.findViewById(R.id.M04F03_RVItemPrice);
        }

        public void showItems(ProductsItem item, int position){
            this.position = position;
            itemName.setText(item.getItemName());
            itemPrice.setText("₱" + item.getItemPrice() + "0");
            switch(item.getItemImage()){
                case 0:
                    itemImage.setImageResource(R.drawable.icon_products00_default);
                    break;
                case 1:
                    itemImage.setImageResource(R.drawable.icon_products01_deepfried);
                    break;
                case 2:
                    itemImage.setImageResource(R.drawable.icon_products02_desserts);
                    break;
                case 3:
                    itemImage.setImageResource(R.drawable.icon_products03_donburi);
                    break;
                case 4:
                    itemImage.setImageResource(R.drawable.icon_products04_drinks);
                    break;
                case 5:
                    itemImage.setImageResource(R.drawable.icon_products05_nigiri);
                    break;
                case 6:
                    itemImage.setImageResource(R.drawable.icon_products06_noodles);
                    break;
                case 7:
                    itemImage.setImageResource(R.drawable.icon_products07_salad);
                    break;
                case 8:
                    itemImage.setImageResource(R.drawable.icon_products08_sashimi);
                    break;
                case 9:
                    itemImage.setImageResource(R.drawable.icon_products09_sushi);
                    break;
                case 10:
                    itemImage.setImageResource(R.drawable.icon_products10_sushirolls);
                    break;
            }
        }

        public void onHold(ProductsItem item, int position){
            itemLayout.setOnLongClickListener(v -> {
                M04F03_CurrentItemIndex = position;
                M04F03_CurrentItem = item.getItemName();
                itemDialog.show();
                return false;
            });
        }
    }
}
