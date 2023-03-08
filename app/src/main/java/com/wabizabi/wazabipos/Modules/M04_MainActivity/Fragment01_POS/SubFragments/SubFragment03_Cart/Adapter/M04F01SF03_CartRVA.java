package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Interfaces.DialogLoader;
import com.wabizabi.wazabipos.Utilities.Interfaces.FragmentLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.Bundles.DialogBundle;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.StringHelper;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Object.CartItem;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class M04F01SF03_CartRVA extends RecyclerView.Adapter<M04F01SF03_CartRVA.ViewHolder> {

    public static Map<CartItem, Integer> cart = new LinkedHashMap<>();
    Context context;
    Dialog dialog;
    FragmentLoader fragmentLoader;
    DialogLoader dialogLoader;

    public M04F01SF03_CartRVA(Context context, Dialog dialog, FragmentLoader fragmentLoader, DialogLoader dialogLoader) {
        this.context = context;
        this.dialog = dialog;
        this.fragmentLoader = fragmentLoader;
        this.dialogLoader = dialogLoader;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.act04_main_frag01_pos_subfrag03_order_rvlayout, parent, false);
        ViewHolder cartLayout = new ViewHolder(viewLayout);
        return cartLayout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        List<CartItem> items = new ArrayList<>(cart.keySet());
        List<Integer> quantities = new ArrayList<>(cart.values());
        CartItem item = items.get(position);
        int quantity = quantities.get(position);
        holder.loadFunctionalities(item, quantity, position);
    }

    @Override
    public int getItemCount() {
        return cart.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        private CardView itemContainer;
        private ImageView itemDiscountsImg;
        private TextView itemDiscountsTxt, itemName, itemIDPrice, itemQty, itemTotalPrice;
        private ImageButton addQtyBtn, subQtyBtn;
        private ImageView deleteBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemContainer = itemView.findViewById(R.id.M04F01SF03_RVContainer);
            itemDiscountsImg = itemView.findViewById(R.id.M04F01SF03_RVDiscountsAppliedImg);
            itemDiscountsTxt = itemView.findViewById(R.id.M04F01SF03_RVDiscountsAppliedNo);
            itemName = itemView.findViewById(R.id.M04F01SF03_RVItemName);
            itemIDPrice = itemView.findViewById(R.id.M04F01SF03_RVIndividualItemPrice);
            itemQty = itemView.findViewById(R.id.M04F01SF03_RVItemQty);
            itemTotalPrice = itemView.findViewById(R.id.M04F01SF03_RVTotalPrice);
            addQtyBtn = itemView.findViewById(R.id.M04F01SF03_RVQtyAddBtn);
            subQtyBtn = itemView.findViewById(R.id.M04F01SF03_RVQtySubBtn);
            deleteBtn = itemView.findViewById(R.id.M04F01SF03_RVRemoveItemBtn);
        }

        public void loadFunctionalities(CartItem item, int quantity, int position){
            //Load Details
            double subTotal = item.getItemPrice() * quantity;
            String name = StringHelper.limitDisplay(item.getItemPOSName(), 0, 18, 15);
            String discountsApplied = (!item.getItemDiscounts().isEmpty()) ? item.getItemDiscounts().size() + " Discounts Applied" : "0 Discounts Applied";

            //Set Views
            this.position = position;
            itemName.setText(name);
            itemIDPrice.setText("₱" + new BigDecimal(item.getItemPrice()).setScale(2, RoundingMode.HALF_UP).toString());
            itemDiscountsTxt.setText(discountsApplied);
            itemQty.setText("x" + quantity);

            //Discount Percentage
            if(!item.getItemDiscounts().isEmpty()){
                int percent = 0;
                for(Map.Entry<String, Integer> discount : item.getItemDiscounts().entrySet()){
                    percent = percent + discount.getValue();
                }
                itemDiscountsImg.setImageResource(R.drawable.icon_button_discount_green);
                itemDiscountsTxt.setTextColor(ContextCompat.getColor(context, R.color.green));
                double discountInDecimal = (double) percent / 100;
                double discount = subTotal * discountInDecimal;
                double total = subTotal - discount;
                itemTotalPrice.setText("₱" + new BigDecimal(total).setScale(2, RoundingMode.HALF_UP).toString());
            } else {
                itemDiscountsImg.setImageResource(R.drawable.icon_button_discount_gray);
                itemDiscountsTxt.setTextColor(ContextCompat.getColor(context, R.color.gray));
                itemTotalPrice.setText("₱" + new BigDecimal(subTotal).setScale(2, RoundingMode.HALF_UP).toString());
            }

            //On Select
            itemContainer.setOnClickListener(discounts -> {
                dialogLoader.load_DGContents(new DialogBundle(1, item));
                dialog.show();
            });

            //On Delete
            deleteBtn.setOnClickListener(remove -> {
                cart.remove(item);
                notifyDataSetChanged();
                fragmentLoader.load_FGContents();
            });

            //On Add
            addQtyBtn.setOnClickListener(add -> {
                if(cart.containsKey(item)){
                    if(cart.get(item) < 99){
                        cart.put(item, cart.get(item) +1);
                        notifyDataSetChanged();
                        fragmentLoader.load_FGContents();
                    }
                }
            });

            //On Sub
            subQtyBtn.setOnClickListener(sub -> {
                if(cart.containsKey(item)){
                    if(cart.get(item)!= 1){
                        cart.put(item, cart.get(item) -1);
                    }
                }
                notifyDataSetChanged();
                fragmentLoader.load_FGContents();
            });
        }
    }
}
