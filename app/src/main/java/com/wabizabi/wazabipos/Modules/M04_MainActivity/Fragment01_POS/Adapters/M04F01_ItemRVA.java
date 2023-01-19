package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Adapters;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.M04F01_POS.currentItemImage;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.M04F01_POS.currentItemName;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.M04F01_POS.currentItemPrice;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Orders.Adapter.M04F01SF03_CartRVA.cart;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.ObjectSchemas.MenuItem;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Interfaces.DialogLoader;
import com.wabizabi.wazabipos.Utilities.Objects.CartObject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class M04F01_ItemRVA extends RecyclerView.Adapter<M04F01_ItemRVA.ViewHolder>{

    Context context;
    Realm realm;
    Dialog addItemDG;
    DialogLoader load;
    List<MenuItem> listOfItems;


    public M04F01_ItemRVA(Context context, Realm realm, List<MenuItem> listOfItems, Dialog addItemDG, DialogLoader load) {
        this.context = context;
        this.realm = realm;
        this.listOfItems = listOfItems;
        this.addItemDG = addItemDG;
        this.load = load;
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
        MenuItem item = listOfItems.get(position);
        holder.loadItem(item, position);
        holder.onClick(item, position);
    }

    @Override
    public int getItemCount() {
        return listOfItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        private ConstraintLayout itemStatus;
        private CardView itemContainer;
        private ImageView itemImage;
        private TextView itemName, itemPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemStatus = itemView.findViewById(R.id.M04F01_IRVStatusLayout);
            itemContainer = itemView.findViewById(R.id.M04F01_IRVContainer);
            itemImage = itemView.findViewById(R.id.M04F01_IRVItemImage);
            itemName = itemView.findViewById(R.id.M04F01_IRVItemName);
            itemPrice = itemView.findViewById(R.id.M04F01_IRVItemPrice);
        }

        public void loadItem(MenuItem item, int position){
            this.position = position;
            itemPrice.setText("₱" + new BigDecimal(item.getItemPrice()).setScale(2, RoundingMode.HALF_UP).toString());
            if(item.getItemName().length() < 25) {
                itemName.setText(item.getItemName());
            } else {
                itemName.setText(item.getItemName().substring(0, Math.min(item.getItemName().length(), 20)) + "...");
            }
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

            //Code to check if Item is in cart
            List<String> itemChecker = new ArrayList<>();
            List<CartObject> itemList = new ArrayList<>(cart.keySet());
            for(CartObject itemObject : itemList){
                String itemString = itemObject.getItemName();
                if(itemString.equals(item.getItemName())){
                    itemChecker.add(itemString);
                }
            }
            if(!itemChecker.isEmpty()){
                itemStatus.setVisibility(View.VISIBLE);
            } else {
                itemStatus.setVisibility(View.GONE);
            }
        }

        public void onClick(MenuItem item, int position){
            this.position = position;
            itemContainer.setOnClickListener(select -> {
                currentItemImage = item.getItemImage();
                currentItemName = item.getItemName();
                currentItemPrice = item.getItemPrice();
                load.load_DGContents(currentItemImage, currentItemName, currentItemPrice);
                addItemDG.show();
            });
        }
    }
}
