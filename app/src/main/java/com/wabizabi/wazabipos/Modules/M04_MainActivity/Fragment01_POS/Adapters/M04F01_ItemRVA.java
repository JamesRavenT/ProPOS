package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Adapters;

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
import com.wabizabi.wazabipos.Utilities.Interfaces.DialogContentLoader;
import com.wabizabi.wazabipos.R;

import io.realm.Realm;
import io.realm.RealmResults;

public class M04F01_ItemRVA extends RecyclerView.Adapter<M04F01_ItemRVA.ViewHolder>{

    public static RealmResults<ProductsItem> listOfPOSItems;
    public static int M04F01_CurrentItemImage;
    public static String M04F01_CurrentItemName;
    public static double M04F01_CurrentItemPrice;
    Dialog addItemDG;
    DialogContentLoader content;
    Context context;
    Realm realm;


    public M04F01_ItemRVA(Dialog dialog, DialogContentLoader content, Context context, Realm realm) {
        this.content = content;
        this.addItemDG = dialog;
        this.context = context;
        this.realm = realm;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.act04_main_frag01_pos_item_rvlayout, parent, false);
        ViewHolder itemLayout = new ViewHolder(viewLayout);
        return itemLayout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductsItem item = listOfPOSItems.get(position);
        holder.getPOSItem(item, position);
        holder.addToCartBtn.setOnClickListener((v)-> holder.addToCart(item, position));

    }

    @Override
    public int getItemCount() {
        return listOfPOSItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        private ImageView itemImage;
        private TextView itemName, itemPrice;
        private CardView addToCartBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.M04F01_IRVItemImage);
            itemName = itemView.findViewById(R.id.M04F01_IRVItemName);
            itemPrice = itemView.findViewById(R.id.M04F01_IRVItemPrice);
            addToCartBtn = itemView.findViewById(R.id.M04F01_IRVAddToCartBtn);


        }

        public void getPOSItem(ProductsItem item, int position){
            this.position = position;
            itemName.setText(item.getItemName());
            itemPrice.setText("₱" + String.valueOf(item.getItemPrice()) + "0");
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

        public void addToCart(ProductsItem item, int position){
            this.position = position;
            M04F01_CurrentItemImage = item.getItemImage();
            M04F01_CurrentItemName = item.getItemName();
            M04F01_CurrentItemPrice = item.getItemPrice();
            content.loadDialog();
            addItemDG.show();

        }
    }
}
