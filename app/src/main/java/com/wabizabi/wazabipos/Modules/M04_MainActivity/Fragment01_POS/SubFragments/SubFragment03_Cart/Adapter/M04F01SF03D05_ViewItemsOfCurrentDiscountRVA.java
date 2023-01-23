package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.M04F01SF03_Cart.currentCartDiscount;

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
import com.wabizabi.wazabipos.Utilities.Objects.CartObject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import io.realm.Realm;

public class M04F01SF03D05_ViewItemsOfCurrentDiscountRVA extends RecyclerView.Adapter<M04F01SF03D05_ViewItemsOfCurrentDiscountRVA.ViewHolder> {
    Context context;
    Realm realm;
    Dialog dialog;
    List<CartObject> listOfItemsWithDiscount;
    FragmentLoader fragmentLoader;
    DialogLoader dialogLoader;

    public M04F01SF03D05_ViewItemsOfCurrentDiscountRVA(Context context, Realm realm, Dialog dialog, List<CartObject> listOfItemsWithDiscount, FragmentLoader fragmentLoader, DialogLoader dialogLoader) {
        this.context = context;
        this.realm = realm;
        this.dialog = dialog;
        this.listOfItemsWithDiscount = listOfItemsWithDiscount;
        this.fragmentLoader = fragmentLoader;
        this.dialogLoader = dialogLoader;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.act04_main_frag01_pos_subfrag03_order_dg05_discountitemview_rvlayout, parent, false);
        ViewHolder layout = new ViewHolder(view);
        return layout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CartObject item = listOfItemsWithDiscount.get(position);
        holder.loadDetails(item, position);
        holder.onClickRemoveButton(item, position);
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

        public void loadDetails(CartObject item, int position){
            this.position = position;
            int discountInPercentage = item.getItemDiscounts().get(currentCartDiscount);
            double discountInDecimal = (double) discountInPercentage / 100;
            double tax = item.getItemPrice() * 0.03;
            double subtotal = item.getItemPrice() + tax;
            double discount = subtotal * discountInDecimal;
            double beforeDiscount = subtotal;
            double afterDiscount =  subtotal - discount;
            itemName.setText(item.getItemName());
            itemPriceBefore.setText(new BigDecimal(beforeDiscount).setScale(2, RoundingMode.HALF_UP).toString());
            itemPriceAfter.setText(new BigDecimal(afterDiscount).setScale(2, RoundingMode.HALF_UP).toString());
        }

        public void onClickRemoveButton(CartObject item, int position){
            this.position = position;
            deleteBtn.setOnClickListener(delete -> {
                listOfItemsWithDiscount.remove(position);
                item.getItemDiscounts().remove(currentCartDiscount);
                notifyDataSetChanged();
                fragmentLoader.load_FGContents();
                dialog.dismiss();
                dialogLoader.load_DGContents(4);
            });

        }

    }
}
