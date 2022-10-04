package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment01_Cart.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Objects.CartObject;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment01_Cart.Interfaces.Update_Cart;
import com.wabizabi.wazabipos.R;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RVA_Cart extends RecyclerView.Adapter<RVA_Cart.RVH_Cart> {

    public static Map<CartObject, Integer> cart = new LinkedHashMap<>();
    Context context;
    Update_Cart updateCart;

    public RVA_Cart(Context context, Update_Cart updateCart) {
        this.context = context;
        this.updateCart = updateCart;
    }

    @NonNull
    @Override
    public RVH_Cart onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.act04_main_frag01_pos_subfrag01_cart_rvlayout, parent, false);
        RVH_Cart cartLayout = new RVH_Cart(viewLayout);
        return cartLayout;
    }

    @Override
    public void onBindViewHolder(@NonNull RVH_Cart holder, int position) {
        List<CartObject> items = new ArrayList<>(cart.keySet());
        List<Integer> quantities = new ArrayList<>(cart.values());
        CartObject item = items.get(position);
        int quantity = quantities.get(position);
        holder.getCart(item, quantity, position);
        holder.addQtyBtn.setOnClickListener((v) -> addQuantity(item));
        holder.subQtyBtn.setOnClickListener((v) -> subQuantity(item));
        holder.removeItemBtn.setOnClickListener((v) -> removeItem(item));

    }

    @Override
    public int getItemCount() {
        return cart.size();
    }

    public class RVH_Cart extends RecyclerView.ViewHolder {
        private int position;
        private TextView itemName, itemIDPrice, itemQty, itemTotalPrice;
        private CardView removeItemBtn;
        private ImageButton addQtyBtn, subQtyBtn;
        public RVH_Cart(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.POS_CRTItemName);
            itemIDPrice = itemView.findViewById(R.id.POS_CRTIndividualItemPrice);
            itemQty = itemView.findViewById(R.id.POS_CRTItemQty);
            itemTotalPrice = itemView.findViewById(R.id.POS_CRTSumOfAllItemPrice);
            addQtyBtn = itemView.findViewById(R.id.POS_CRTItemQtyAddBtn);
            subQtyBtn = itemView.findViewById(R.id.POS_CRTItemQtySubBtn);
            removeItemBtn = itemView.findViewById(R.id.POS_CRTRemoveItemBtn);
        }

        public void getCart(CartObject item, int quantity, int position){
            this.position = position;
            String totalPrice = String.valueOf(item.getItemPrice() * quantity);
            itemName.setText(item.getItemName());
            itemIDPrice.setText("₱" + item.getItemPrice());
            itemQty.setText(String.valueOf(quantity));
            itemTotalPrice.setText("₱" + totalPrice);
        }
    }

    public void addQuantity(CartObject item){
        if(cart.containsKey(item)){
            cart.put(item, cart.get(item) +1);
        }
        notifyDataSetChanged();
        updateCart.refreshCart(context);
    }

    public void subQuantity(CartObject item){
        if(cart.containsKey(item)){
            if(cart.get(item)!= 1){
                cart.put(item, cart.get(item) -1);
            }
        }
        notifyDataSetChanged();
        updateCart.refreshCart(context);
    }

    public void removeItem(CartObject item){
        cart.remove(item);
        notifyDataSetChanged();
        updateCart.refreshCart(context);
    }
}
