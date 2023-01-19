package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Orders.Adapter;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Orders.M04F01SF03_Orders.currentCartItem;

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

import com.wabizabi.wazabipos.Utilities.Interfaces.DialogLoader;
import com.wabizabi.wazabipos.Utilities.Interfaces.FragmentLoader;
import com.wabizabi.wazabipos.Utilities.Objects.CartObject;
import com.wabizabi.wazabipos.R;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class M04F01SF03_CartRVA extends RecyclerView.Adapter<M04F01SF03_CartRVA.ViewHolder> {

    public static Map<CartObject, Integer> cart = new LinkedHashMap<>();
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
        List<CartObject> items = new ArrayList<>(cart.keySet());
        List<Integer> quantities = new ArrayList<>(cart.values());
        CartObject item = items.get(position);
        int quantity = quantities.get(position);
        holder.getCart(item, quantity, position);
        holder.onClickItem(item, position);
        holder.addQtyBtn.setOnClickListener((v) -> addQuantity(item));
        holder.subQtyBtn.setOnClickListener((v) -> subQuantity(item));
        holder.onClickDeleteButton(item, position);
    }

    @Override
    public int getItemCount() {
        return cart.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        private CardView itemContainer;
        private ImageView itemImage, itemDiscountsImg;
        private TextView itemDiscountsTxt, itemName, itemIDPrice, itemQty, itemTotalPrice;
        private ImageButton addQtyBtn, subQtyBtn;
        private ImageView deleteBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemContainer = itemView.findViewById(R.id.M04F01SF03_RVContainer);
            itemDiscountsImg = itemView.findViewById(R.id.M04F01SF03_RVDiscountsAppliedImg);
            itemDiscountsTxt = itemView.findViewById(R.id.M04F01SF03_RVDiscountsAppliedNo);
            itemImage = itemView.findViewById(R.id.M04F01SF03_RVItemImage);
            itemName = itemView.findViewById(R.id.M04F01SF03_RVItemName);
            itemIDPrice = itemView.findViewById(R.id.M04F01SF03_RVIndividualItemPrice);
            itemQty = itemView.findViewById(R.id.M04F01SF03_RVItemQty);
            itemTotalPrice = itemView.findViewById(R.id.M04F01SF03_RVTotalPrice);
            addQtyBtn = itemView.findViewById(R.id.M04F01SF03_RVQtyAddBtn);
            subQtyBtn = itemView.findViewById(R.id.M04F01SF03_RVQtySubBtn);
            deleteBtn = itemView.findViewById(R.id.M04F01SF03_RVRemoveItemBtn);
        }

        public void getCart(CartObject item, int quantity, int position){
            this.position = position;
            double subTotal = item.getItemPrice() * quantity;
            double tax = subTotal * 0.03;
            double total = subTotal + tax;
            if(item.getItemName().length() < 25) {
                itemName.setText(item.getItemName());
            } else {
                itemName.setText(item.getItemName().substring(0, Math.min(item.getItemName().length(), 20)) + "...");
            }
            itemIDPrice.setText("₱" + new BigDecimal(item.getItemPrice()).setScale(2, RoundingMode.HALF_UP).toString());
            itemQty.setText(String.valueOf(quantity));

            if(!item.getItemDiscounts().isEmpty()){
                int percent = 0;
                for(Map.Entry<String, Integer> discount : item.getItemDiscounts().entrySet()){
                    percent = percent + discount.getValue();
                }
                itemDiscountsImg.setImageResource(R.drawable.icon_button_discount_green);
                itemDiscountsTxt.setTextColor(ContextCompat.getColor(context, R.color.green));
                itemDiscountsTxt.setText(percent + "%");
                double discountInDecimal = (double) percent / 100;
                double discount = total * discountInDecimal;
                double finalPrice = total - discount;
                itemTotalPrice.setText("₱" + new BigDecimal(finalPrice).setScale(2, RoundingMode.HALF_UP).toString());
            } else {
                itemDiscountsImg.setImageResource(R.drawable.icon_button_discount_gray);
                itemDiscountsTxt.setTextColor(ContextCompat.getColor(context, R.color.gray));
                itemDiscountsTxt.setText("0%");

                itemTotalPrice.setText("₱" + new BigDecimal(total).setScale(2, RoundingMode.HALF_UP).toString());
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
        }

        public void onClickItem(CartObject item, int position){
            this.position = position;
            itemContainer.setOnClickListener(discounts -> {
                currentCartItem = item;
                dialogLoader.load_DGContents(1);
                dialog.show();
            });
        }

        public void onClickDeleteButton(CartObject item, int position){
            this.position = position;
            deleteBtn.setOnClickListener(remove -> {
                cart.remove(item);
                notifyDataSetChanged();
            });
        }
    }

    public void addQuantity(CartObject item){
        if(cart.containsKey(item)){
            cart.put(item, cart.get(item) +1);
        }
        notifyDataSetChanged();
    }

    public void subQuantity(CartObject item){
        if(cart.containsKey(item)){
            if(cart.get(item)!= 1){
                cart.put(item, cart.get(item) -1);
            }
        }
        notifyDataSetChanged();
    }



}
