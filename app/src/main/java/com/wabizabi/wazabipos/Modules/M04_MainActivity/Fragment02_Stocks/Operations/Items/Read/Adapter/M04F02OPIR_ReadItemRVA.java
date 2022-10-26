package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.Items.Read.Adapter;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.M04F02_Stocks.M04F02_CurrentItem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.Schemas.StockItem;
import com.wabizabi.wazabipos.Database.Schemas.InventoryTransaction;
import com.wabizabi.wazabipos.R;

import io.realm.Realm;
import io.realm.RealmResults;

public class M04F02OPIR_ReadItemRVA extends RecyclerView.Adapter<M04F02OPIR_ReadItemRVA.ViewHolder> {
    public static RealmResults<InventoryTransaction> listOfAssociatedStockTransactions;
    Realm realm;
    Context context;

    public M04F02OPIR_ReadItemRVA(Realm realm, Context context) {
        this.realm = realm;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.act04_main_frag02_stocks_operation_crud_itemread_rvlayout, parent, false);
        ViewHolder viewLayout = new ViewHolder(layout);
        return viewLayout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        InventoryTransaction transaction = listOfAssociatedStockTransactions.get(position);
        holder.showTransactions(transaction, position);

    }

    @Override
    public int getItemCount() {
        return listOfAssociatedStockTransactions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        TextView transactionDate, operation;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            transactionDate = itemView.findViewById(R.id.M04F02OPIR_RVDate);
            operation = itemView.findViewById(R.id.M04F02OPIR_RVOperation);
        }

        public void showTransactions(InventoryTransaction transaction, int position){
            this.position = position;
            StockItem item = realm.where(StockItem.class).equalTo("itemName", M04F02_CurrentItem).findFirst();
            String date = transaction.getMonth() + " " + transaction.getDay() + ", " + transaction.getYear();
            transactionDate.setText(date);
            operation.setText(transaction.getOperation() + " : " + transaction.getAmount() + " " + item.getItemUnit());


        }
    }
}
