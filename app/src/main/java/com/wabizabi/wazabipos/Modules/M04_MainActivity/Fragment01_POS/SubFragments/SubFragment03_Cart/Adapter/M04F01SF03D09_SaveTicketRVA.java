package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.M04F01SF03_CartRVA.cart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Objects.CartObject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

import io.realm.Realm;

public class M04F01SF03D09_SaveTicketRVA extends RecyclerView.Adapter<M04F01SF03D09_SaveTicketRVA.ViewHolder> {

    Context context;
    Realm realm;
    List<CartObject> listOfItems;

    public M04F01SF03D09_SaveTicketRVA(Context context, Realm realm, List<CartObject> listOfItems) {
        this.context = context;
        this.realm = realm;
        this.listOfItems = listOfItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.act04_main_frag01_pos_subfrag03_order_dg09_confirmsaveticket_rvlayout, parent, false);
        ViewHolder layout = new ViewHolder(view);
        return layout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CartObject cartItem = listOfItems.get(position);
        int quantity = cart.get(cartItem);
        holder.loadDetails(cartItem, quantity, position);
    }

    @Override
    public int getItemCount() {
        return listOfItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        private TextView itemQty, itemName, itemPrice, itemDiscountPercentage, itemTotal;
        private ImageView itemDiscount;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemQty = itemView.findViewById(R.id.M04F01SF03D09_RVItemQty);
            itemName = itemView.findViewById(R.id.M04F01SF03D09_RVItemName);
            itemPrice = itemView.findViewById(R.id.M04F01SF03D09_RVItemPrice);
            itemDiscount = itemView.findViewById(R.id.M04F01SF03D09_RVDiscountsAppliedImg);
            itemDiscountPercentage = itemView.findViewById(R.id.M04F01SF03D09_RVDiscountsAppliedNo);
            itemTotal = itemView.findViewById(R.id.M04F01SF03D09_RVItemTotalPrice);
        }

        public void loadDetails(CartObject item, int qty, int position){
            itemQty.setText("x" + qty);
            itemName.setText(item.getItemName());
            itemPrice.setText(new BigDecimal(item.getItemPrice()).setScale(2,  RoundingMode.HALF_UP).toString());
            //Calculate the Discount Percentage
            int discountPercent = 0;
            for(Map.Entry<String, Integer> discount : item.getItemDiscounts().entrySet()){
                discountPercent += discount.getValue();
            }
            itemDiscountPercentage.setText(discountPercent + "%");

            //Calculate the Total
            double tax = item.getItemPrice() * 0.03;
            double taxedPrice = item.getItemPrice() + tax;
            double discountInDecimal = (double) discountPercent / 100;
            double discount = taxedPrice * discountInDecimal;
            double discountedPrice = taxedPrice - discount;
            double totalPrice = discountedPrice * qty;

            itemTotal.setText("₱" + new BigDecimal(totalPrice).setScale(2, RoundingMode.HALF_UP).toString());
        }
    }
}
