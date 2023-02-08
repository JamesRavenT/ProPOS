package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.M04F01SF03_Cart.currentCartTicket;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Interfaces.FragmentLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.LayoutHelper;

import java.util.List;
import java.util.Map;

import io.realm.Realm;

public class M04F01SF03D01_AppliedDiscountsRVA extends RecyclerView.Adapter<M04F01SF03D01_AppliedDiscountsRVA.ViewHolder> {

    Context context;
    Realm realm;
    Map<String, Integer> listOfDiscountsApplied;
    List<String> listOfDiscountsAppliedKeyset;
    FragmentLoader fragmentLoader;

    public M04F01SF03D01_AppliedDiscountsRVA(Context context, Realm realm, Map<String, Integer> listOfDiscountsApplied, List<String> listOfDiscountsAppliedKeyset, FragmentLoader fragmentLoader) {
        this.context = context;
        this.realm = realm;
        this.listOfDiscountsApplied = listOfDiscountsApplied;
        this.listOfDiscountsAppliedKeyset = listOfDiscountsAppliedKeyset;
        this.fragmentLoader = fragmentLoader;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutHelper.inflateRV(parent, R.layout.act04_main_frag01_pos_subfrag03_order_dg01_itemdiscount_rvlayout);
        ViewHolder layout = new ViewHolder(view);
        return layout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String discountName = listOfDiscountsAppliedKeyset.get(position);
        int discountPercentage = listOfDiscountsApplied.get(discountName);
        holder.loadFunctionalities(discountName, discountPercentage, position);
    }

    @Override
    public int getItemCount() {
        return listOfDiscountsApplied.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        private TextView discountName,
                         discountPercentage;
        private ImageView removeDiscountBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            discountName = itemView.findViewById(R.id.M04F01SF03D01_RVDiscountName);
            discountPercentage = itemView.findViewById(R.id.M04F01SF03D01_RVDiscountPercentage);
            removeDiscountBtn = itemView.findViewById(R.id.M04F01SF03D01_RVRemoveBtn);
        }

        public void loadFunctionalities(String name, int percent, int position){
            //Set Views
            this.position = position;
            discountName.setText(name);
            discountPercentage.setText(percent + "% Discount");

            //On Remove
            removeDiscountBtn.setOnClickListener(delete -> {
                if(currentCartTicket != null) {
                    currentCartTicket.setTicketStatus("Voidable");
                }
                listOfDiscountsApplied.remove(name, percent);
                notifyDataSetChanged();
                fragmentLoader.load_FGContents();
            });
        }
    }
}
