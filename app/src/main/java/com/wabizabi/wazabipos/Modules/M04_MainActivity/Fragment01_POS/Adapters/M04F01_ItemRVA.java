package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Adapters;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment01_Cart.Adapter.RVA_Cart.cart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.Schemas.ProductsItem;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Interfaces.Update_POS;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Objects.CartObject;
import com.wabizabi.wazabipos.R;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class M04F01_ItemRVA extends RecyclerView.Adapter<M04F01_ItemRVA.RVH_POSItem>{

    public static RealmResults<ProductsItem> listOfPOSItems;
    Update_POS updateCartCount;
    Context context;
    Realm realm;


    public M04F01_ItemRVA(Update_POS updateCartCount, Context context, Realm realm) {
        this.updateCartCount = updateCartCount;
        this.context = context;
        this.realm = realm;

    }


    @NonNull
    @Override
    public RVH_POSItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.act04_main_frag01_pos_item_rvlayout, parent, false);
        RVH_POSItem itemLayout = new RVH_POSItem(viewLayout);
        return itemLayout;
    }

    @Override
    public void onBindViewHolder(@NonNull RVH_POSItem holder, int position) {
        ProductsItem item = listOfPOSItems.get(position);
        holder.getPOSItem(item, position);
        holder.addToCartBtn.setOnClickListener((v)-> holder.addToCart(item, position));

    }

    @Override
    public int getItemCount() {
        return listOfPOSItems.size();
    }

    public class RVH_POSItem extends RecyclerView.ViewHolder {
        private int position;
        private TextView itemName, itemPrice;
        private CardView addToCartBtn;
        public RVH_POSItem(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.POS_ItemName);
            itemPrice = itemView.findViewById(R.id.POS_ItemPrice);
            addToCartBtn = itemView.findViewById(R.id.POS_ItemAddToCartBtn);


        }

        public void getPOSItem(ProductsItem item, int position){
            this.position = position;
            itemName.setText(item.getItemName());
            itemPrice.setText("₱" + String.valueOf(item.getItemPrice()) + "0");
        }

        public void addToCart(ProductsItem item, int position){
            this.position = position;
            String name = item.getItemName();
            double price = item.getItemPrice();
            List<CartObject> items = new ArrayList<>(cart.keySet());
            List<CartObject> object = new ArrayList<>();
            for(CartObject cartItem : items){
                if(cartItem.getItemName().equalsIgnoreCase(name)){
                    object.add(cartItem);
                }
            }
            if(!object.isEmpty()){
                CartObject itemkey = object.get(0);
                cart.put(itemkey, cart.get(itemkey) + 1);
            } else {
                cart.put(new CartObject(name, price), 1);
            }
            updateCartCount.refreshCartCount(context);
            Toast.makeText(context, "Item added to Cart!", Toast.LENGTH_SHORT).show();
        }
    }
}
