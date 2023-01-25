package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment05_PaymentMethods.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.ObjectSchemas.PaymentMethod;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Interfaces.DialogLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.LayoutBuilder;

import java.util.List;

import io.realm.Realm;

public class M04F05_PaymentMethodsRVA extends RecyclerView.Adapter<M04F05_PaymentMethodsRVA.ViewHolder> {

    Context context;
    Realm realm;
    List<PaymentMethod> listOfPaymentMethods;
    DialogLoader dialogLoader;

    public M04F05_PaymentMethodsRVA(Context context, Realm realm, List<PaymentMethod> listOfPaymentMethods, DialogLoader dialogLoader) {
        this.context = context;
        this.realm = realm;
        this.listOfPaymentMethods = listOfPaymentMethods;
        this.dialogLoader = dialogLoader;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutBuilder.inflate(parent, R.layout.act04_main_frag05_paymentmethods_rvlayout);
        ViewHolder layout = new ViewHolder(view);
        return layout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PaymentMethod method = listOfPaymentMethods.get(position);
        holder.loadDetails(method, position);
        holder.onClickEditBtn(method, position);
    }

    @Override
    public int getItemCount() {
        return listOfPaymentMethods.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        private TextView methodName, lastUpdatedText;
        private ImageView editBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            methodName = itemView.findViewById(R.id.M04F05_RVPaymentMethodName);
            lastUpdatedText = itemView.findViewById(R.id.M04F05_RVDateAndTime);
            editBtn = itemView.findViewById(R.id.M04F05_RVEditBtn);
        }

        public void loadDetails(PaymentMethod method, int position){
            this.position = position;
            methodName.setText(method.getMethodName());
            lastUpdatedText.setText(method.getLastUpdatedText());
        }

        public void onClickEditBtn(PaymentMethod method, int position){
            this.position = position;
            editBtn.setOnClickListener(edit -> {
                dialogLoader.load_DGContents(2, -1, method.getMethodName());
            });
        }
    }
}
