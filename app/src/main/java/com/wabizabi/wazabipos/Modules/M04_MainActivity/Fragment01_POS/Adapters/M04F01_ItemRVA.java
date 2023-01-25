package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Adapters;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.M04F01SF03_CartRVA.cart;

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
import com.wabizabi.wazabipos.Utilities.Libraries.IconLoader;
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
            String name = (item.getItemName().length() < 25) ? item.getItemName() : item.getItemName().substring(0, Math.min(item.getItemName().length(), 20)) + "...";
            IconLoader.setMenuIcon(itemImage, item.getItemImage());
            itemName.setText(name);
            itemPrice.setText("₱" + new BigDecimal(item.getItemPrice()).setScale(2, RoundingMode.HALF_UP).toString());

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
                load.load_DGContents(1, item.getItemImage(), item.getItemName());
                addItemDG.show();
            });
        }
    }
}
