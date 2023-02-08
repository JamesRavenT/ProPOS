package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.M04F01SF03_Cart.currentCartTicket;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Interfaces.DialogLoader;
import com.wabizabi.wazabipos.Utilities.Interfaces.FragmentLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.LayoutHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.StringHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Objects.CartItem;

import java.util.List;

import io.realm.Realm;

public class M04F01SF03D05_ItemsAppliedWithDiscountRVA extends RecyclerView.Adapter<M04F01SF03D05_ItemsAppliedWithDiscountRVA.ViewHolder> {
    Context context;
    Realm realm;
    String currentDiscount;
    Dialog dialog;
    List<CartItem> listOfItemsWithDiscount;
    FragmentLoader fragmentLoader;
    DialogLoader dialogLoader;

    public M04F01SF03D05_ItemsAppliedWithDiscountRVA(Context context, Realm realm, String currentDiscount, Dialog dialog, List<CartItem> listOfItemsWithDiscount, FragmentLoader fragmentLoader, DialogLoader dialogLoader) {
        this.context = context;
        this.realm = realm;
        this.currentDiscount = currentDiscount;
        this.dialog = dialog;
        this.listOfItemsWithDiscount = listOfItemsWithDiscount;
        this.fragmentLoader = fragmentLoader;
        this.dialogLoader = dialogLoader;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutHelper.inflateRV(parent, R.layout.act04_main_frag01_pos_subfrag03_order_dg05_discountitemview_rvlayout);
        ViewHolder layout = new ViewHolder(view);
        return layout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CartItem item = listOfItemsWithDiscount.get(position);
        holder.loadFunctionalities(item, position);
    }

    @Override
    public int getItemCount() {
        return listOfItemsWithDiscount.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        private TextView itemName, itemPriceBefore, itemPriceAfter;
        private ImageView deleteBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.M04F01SF03D05_RVItemName);
            itemPriceBefore = itemView.findViewById(R.id.M04F01SF03D05_RVPriceBeforeNo);
            itemPriceAfter = itemView.findViewById(R.id.M04F01SF03D05_RVPriceAfterNo);
            deleteBtn = itemView.findViewById(R.id.M04F01SF03D05_RVRemoveBtn);
        }

        public void loadFunctionalities(CartItem item, int position){
            //Load Details
            int discountInPercentage = item.getItemDiscounts().get(currentDiscount);
            double discountInDecimal = (double) discountInPercentage / 100;
            double subtotal = item.getItemPrice();
            double discount = subtotal * discountInDecimal;
            double beforeDiscount = subtotal;
            double afterDiscount =  subtotal - discount;

            String name = item.getItemPOSName();
            String bprice = StringHelper.convertToCurrency(beforeDiscount);
            String aprice = StringHelper.convertToCurrency(afterDiscount);

            //Set Views
            this.position = position;
            itemName.setText(name);
            itemPriceBefore.setText(bprice);
            itemPriceAfter.setText(aprice);

            //OnDelete
            deleteBtn.setOnClickListener(delete -> {
                listOfItemsWithDiscount.remove(position);
                item.getItemDiscounts().remove(currentDiscount);
                notifyDataSetChanged();
                fragmentLoader.load_FGContents();
            });
        }
    }
}
