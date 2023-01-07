package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Utilities.Objects.CartObject;
import com.wabizabi.wazabipos.Utilities.Interfaces.Update_Cart;
import com.wabizabi.wazabipos.R;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class M04F01SF03_CartRVA extends RecyclerView.Adapter<M04F01SF03_CartRVA.ViewHolder> {

    public static Map<CartObject, Integer> cart = new LinkedHashMap<>();
    Context context;
    Update_Cart updateCart;

    public M04F01SF03_CartRVA(Context context, Update_Cart updateCart) {
        this.context = context;
        this.updateCart = updateCart;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.act04_main_frag01_pos_subfrag03_cart_rvlayout, parent, false);
        ViewHolder cartLayout = new ViewHolder(viewLayout);
        return cartLayout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        List<CartObject> items = new ArrayList<>(cart.keySet());
        List<Integer> quantities = new ArrayList<>(cart.values());
        CartObject item = items.get(position);
        int quantity = quantities.get(position);
        holder.getCart(item, quantity, position);
        holder.addQtyBtn.setOnClickListener((v) -> addQuantity(item));
        holder.subQtyBtn.setOnClickListener((v) -> subQuantity(item));
    }

    @Override
    public int getItemCount() {
        return cart.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        private ImageView itemImage;
        private TextView itemNo, itemName, itemIDPrice, itemQty, itemTotalPrice;
        private ImageButton addQtyBtn, subQtyBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemNo = itemView.findViewById(R.id.M04F01SF03_RVItemNo);
            itemImage = itemView.findViewById(R.id.M04F01SF03_RVItemImage);
            itemName = itemView.findViewById(R.id.M04F01SF03_RVItemName);
            itemIDPrice = itemView.findViewById(R.id.M04F01SF03_RVIndividualItemPrice);
            itemQty = itemView.findViewById(R.id.M04F01SF03_RVItemQty);
            itemTotalPrice = itemView.findViewById(R.id.M04F01SF03_RVTotalPrice);
            addQtyBtn = itemView.findViewById(R.id.M04F01SF03_RVQtyAddBtn);
            subQtyBtn = itemView.findViewById(R.id.M04F01SF03_RVQtySubBtn);
        }

        public void getCart(CartObject item, int quantity, int position){
            this.position = position;
            int counter = position + 1;
            if(position < 10) {
                itemNo.setText("Item No.0" + counter);
            } else {
                itemNo.setText("Item No." + counter);
            }
            String totalPrice = String.valueOf(item.getItemPrice() * quantity);
            itemName.setText(item.getItemName());
            itemIDPrice.setText("₱" + item.getItemPrice());
            itemQty.setText(String.valueOf(quantity));
            itemTotalPrice.setText("₱" + totalPrice);
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
    }

    public void addQuantity(CartObject item){
        if(cart.containsKey(item)){
            cart.put(item, cart.get(item) +1);
        }
        notifyDataSetChanged();
        updateCart.refreshCart();
    }

    public void subQuantity(CartObject item){
        if(cart.containsKey(item)){
            if(cart.get(item)!= 1){
                cart.put(item, cart.get(item) -1);
            }
        }
        notifyDataSetChanged();
        updateCart.refreshCart();
    }

}
