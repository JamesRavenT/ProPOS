package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.LayoutHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.StringHelper;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Object.CartItem;

import java.util.List;
import java.util.Map;

import io.realm.Realm;

public class M04F01SF03D15_TransactionCompleteRVA extends RecyclerView.Adapter<M04F01SF03D15_TransactionCompleteRVA.ViewHolder> {

    Context context;
    Realm realm;
    List<CartItem> listOfItems;
    Map<CartItem, Integer> mapOfItems;

    public M04F01SF03D15_TransactionCompleteRVA(Context context, Realm realm, List<CartItem> listOfItems, Map<CartItem, Integer> mapOfItems) {
        this.context = context;
        this.realm = realm;
        this.listOfItems = listOfItems;
        this.mapOfItems = mapOfItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutHelper.inflateRV(parent, R.layout.act04_main_frag01_pos_subfrag03_order_dg15_transactioncomplete_rvlayout);
        ViewHolder layout = new ViewHolder(view);
        return layout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CartItem item = listOfItems.get(position);
        int quantity = mapOfItems.get(item);
        holder.loadFunctionalities(item, quantity, position);
    }

    @Override
    public int getItemCount() {
        return listOfItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        private TextView itemQty, itemName, itemPrice, itemDiscount, itemDiscountPercentage, itemDiscountPrice, itemTotal;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemQty = itemView.findViewById(R.id.M04F01SF03D15_RVItemQty);
            itemName = itemView.findViewById(R.id.M04F01SF03D15_RVItemName);
            itemPrice = itemView.findViewById(R.id.M04F01SF03D15_RVItemPrice);
            itemDiscount = itemView.findViewById(R.id.M04F01SF03D15_RVDiscountName);
            itemDiscountPercentage = itemView.findViewById(R.id.M04F01SF03D15_RVDiscountPercentage);
            itemDiscountPrice = itemView.findViewById(R.id.M04F01SF03D15_RVDiscountAmount);
            itemTotal = itemView.findViewById(R.id.M04F01SF03D15_RVItemTotalPrice);
        }

        public void loadFunctionalities(CartItem item, int qty, int position){
            //Load Details
            String quantity = "x" + qty;
            String name = item.getItemPOSName();
            String price = StringHelper.convertToCurrency(item.getItemPrice());
            String discountName = StringHelper.getDiscountNames(item);
            String discountPercent = StringHelper.getDiscountPercentage(item);
            String discountPrice = StringHelper.getDiscountAmount(item, qty);
            String finalPrice = StringHelper.getDiscountedTotal(item, qty);

            //Set Views
            this.position = position;
            itemQty.setText(quantity);
            itemName.setText(name);
            itemPrice.setText(price);
            itemDiscount.setText(discountName);
            itemDiscountPercentage.setText(discountPercent);
            itemDiscountPrice.setText(discountPrice);
            itemTotal.setText(finalPrice);
        }
    }
}
