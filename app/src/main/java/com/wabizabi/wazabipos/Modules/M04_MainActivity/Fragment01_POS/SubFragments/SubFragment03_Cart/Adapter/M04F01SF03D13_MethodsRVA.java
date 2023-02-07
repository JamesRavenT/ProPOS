package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.M04F01SF03_Cart.selectedMethod;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.ObjectSchemas.PaymentMethod;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.LayoutHelper;

import java.util.List;

import io.realm.Realm;

public class M04F01SF03D13_MethodsRVA extends RecyclerView.Adapter<M04F01SF03D13_MethodsRVA.ViewHolder> {

    Context context;
    Realm realm;
    List<PaymentMethod> listOfMethods;

    public M04F01SF03D13_MethodsRVA(Context context, Realm realm, List<PaymentMethod> listOfMethods) {
        this.context = context;
        this.realm = realm;
        this.listOfMethods = listOfMethods;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutHelper.inflateRV(parent, R.layout.act04_main_frag01_pos_subfrag03_order_dg13_charge_rvlayout);
        ViewHolder layout = new ViewHolder(view);
        return layout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PaymentMethod method = listOfMethods.get(position);
        holder.loadFunctionalities(method, position);
    }

    @Override
    public int getItemCount() {
        return listOfMethods.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        private ConstraintLayout methodContainer;
        private ImageView methodImage;
        private TextView methodName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            methodContainer = itemView.findViewById(R.id.M04F01SF03D13_RVContainer);
            methodImage = itemView.findViewById(R.id.M04F01SF03D13_RVMethodImage);
            methodName = itemView.findViewById(R.id.M04F01SF03D13_RVMethodName);
        }

        public void loadFunctionalities(PaymentMethod method, int position){
            //Load Details
            String name = method.getMethodName();

            //Set Views
            methodName.setText(name);

            //Check if Method is Selected
            if(selectedMethod != null){
               if(name.equals(selectedMethod)){
                   methodContainer.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
                   methodName.setTextColor(ContextCompat.getColor(context, R.color.white));
                   methodImage.setImageResource(R.drawable.icon_button_payment_white);
               } else {
                   methodContainer.setBackgroundColor(ContextCompat.getColor(context, R.color.green));
                   methodName.setTextColor(ContextCompat.getColor(context, R.color.black));
                   methodImage.setImageResource(R.drawable.icon_button_payment_dark);
               }
            } else {
                methodContainer.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
                methodName.setTextColor(ContextCompat.getColor(context, R.color.black));
                methodImage.setImageResource(R.drawable.icon_button_payment_dark);
            }

            //On Select
            methodContainer.setOnClickListener(select -> {
               if(selectedMethod != null){
                   if(name.equals(selectedMethod)){
                       selectedMethod = null;
                       notifyDataSetChanged();
                   } else {
                       selectedMethod = name;
                       notifyDataSetChanged();
                   }
               } else {
                   selectedMethod = name;
                   notifyDataSetChanged();
               }
            });
        }
    }
}
