package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Orders.Adapter;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Orders.Adapter.M04F01SF03_CartRVA.cart;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Orders.M04F01SF03_Orders.currentDiscount;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.RealmSchemas.RealmOrderDiscount;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Interfaces.DialogLoader;
import com.wabizabi.wazabipos.Utilities.Interfaces.FragmentLoader;

import java.util.List;
import java.util.Map;

import io.realm.Realm;

public class M04F01SF03D04_ViewAppliedDiscountsRVA extends RecyclerView.Adapter<M04F01SF03D04_ViewAppliedDiscountsRVA.ViewHolder> {

    Context context;
    Realm realm;
    Dialog currentDialog;
    Map<String, Integer> listOfDiscountsApplied;
    List<String> listOfDiscountsAppliedKeySet;
    FragmentLoader fragmentLoader;
    DialogLoader dialogLoader;

    public M04F01SF03D04_ViewAppliedDiscountsRVA(Context context, Realm realm, Dialog currentDialog, Map<String, Integer> listOfDiscountsApplied, List<String> listOfDiscountsAppliedKeySet, FragmentLoader fragmentLoader, DialogLoader dialogLoader) {
        this.context = context;
        this.realm = realm;
        this.currentDialog = currentDialog;
        this.listOfDiscountsApplied = listOfDiscountsApplied;
        this.listOfDiscountsAppliedKeySet = listOfDiscountsAppliedKeySet;
        this.fragmentLoader = fragmentLoader;
        this.dialogLoader = dialogLoader;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.act04_main_frag01_pos_subfrag03_order_dg04_discountsapplied_rvlayout, parent, false);
        ViewHolder layout = new ViewHolder(view);
        return layout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String discountName = listOfDiscountsAppliedKeySet.get(position);
        RealmOrderDiscount query = realm.where(RealmOrderDiscount.class).equalTo("discountName", discountName).findFirst();
        int discountPercentage = query.getDiscountPercentage();
        int discountFrequency = listOfDiscountsApplied.get(discountName);
        holder.loadDetails(discountName, discountPercentage, discountFrequency, position);
        holder.onClickDiscount(discountName, position);
        holder.onClickRemoveButton(discountName, discountFrequency, position);
    }

    @Override
    public int getItemCount() {
        return listOfDiscountsApplied.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        private ConstraintLayout discountContainer;
        private TextView discountName, discountPercentage, discountFrequency;
        private ImageView removeButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            discountContainer = itemView.findViewById(R.id.M04F01SF03D04_RVContainer);
            discountName = itemView.findViewById(R.id.M04F01SF03D04_RVDiscountName);
            discountPercentage = itemView.findViewById(R.id.M04F01SF03D04_RVDiscountPercentage);
            discountFrequency = itemView.findViewById(R.id.M04F01SF03D04_RVDiscountFrequency);
            removeButton = itemView.findViewById(R.id.M04F01SF03D04_RVRemoveBtn);
        }

        public void loadDetails(String name, int percentage, int frequency, int position){
            this.position = position;
            discountName.setText(name);
            discountPercentage.setText(percentage + "% Discount");
            if(frequency == cart.size()){
                discountFrequency.setText("All Items");
            } else {
                discountFrequency.setText(frequency + " item(s)");
            }
        }

        public void onClickDiscount(String name, int position){
            this.position = position;
            discountContainer.setOnClickListener(select -> {
                currentDiscount = name;
                currentDialog.dismiss();
                dialogLoader.load_DGContents(5);
            });
        }

        public void onClickRemoveButton(String name, int frequency, int position){
            this.position = position;
            removeButton.setOnClickListener(remove -> {
                listOfDiscountsApplied.remove(name, frequency);
                fragmentLoader.load_FGContents();
                notifyDataSetChanged();
            });
        }
    }
}
