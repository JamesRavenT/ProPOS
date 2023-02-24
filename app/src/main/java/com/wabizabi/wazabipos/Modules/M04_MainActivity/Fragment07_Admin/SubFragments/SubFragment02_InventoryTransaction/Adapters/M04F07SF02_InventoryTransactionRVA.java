package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment07_Admin.SubFragments.SubFragment02_InventoryTransaction.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.ObjectSchemas.InventoryTransaction;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Interfaces.DialogLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.Bundles.DialogBundle;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.LayoutHelper;

import java.util.List;

import io.realm.Realm;

public class M04F07SF02_InventoryTransactionRVA extends RecyclerView.Adapter<M04F07SF02_InventoryTransactionRVA.ViewHolder> {

    Context context;
    Realm realm;
    List<InventoryTransaction> listOfInventoryTransaction;
    DialogLoader dialogLoader;

    public M04F07SF02_InventoryTransactionRVA(Context context, Realm realm, List<InventoryTransaction> listOfInventoryTransaction, DialogLoader dialogLoader) {
        this.context = context;
        this.realm = realm;
        this.listOfInventoryTransaction = listOfInventoryTransaction;
        this.dialogLoader = dialogLoader;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutHelper.inflateRV(parent, R.layout.act04_main_frag07_admin_subfrag02_inventorytransaction_rvlayout);
        ViewHolder layout = new ViewHolder(view);
        return layout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        InventoryTransaction inventory = listOfInventoryTransaction.get(position);
        holder.loadFunctionalities(inventory, position);

    }

    @Override
    public int getItemCount() {
        return listOfInventoryTransaction.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        private TextView transDate, transID, transOP, transItemName, transAmount, transNewAmount;
        private CardView voidBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            transDate = itemView.findViewById(R.id.M04F07SF02_RVDateAndTime);
            transID = itemView.findViewById(R.id.M04F07SF02_RVTicketNo);
            transOP = itemView.findViewById(R.id.M04F07SF02_RVItemTransactionText);
            transItemName = itemView.findViewById(R.id.M04F07SF02_RVItemName);
            transAmount = itemView.findViewById(R.id.M04F07SF02_RVAmountSettled);
            transNewAmount = itemView.findViewById(R.id.M04F07SF02_RVAmountRemaining);
            voidBtn = itemView.findViewById(R.id.M04F07SF02_RVDeleteBtn);
        }

        public void loadFunctionalities(InventoryTransaction transaction, int position){
            //Load Details
            String transactionDT = transaction.getTransactionDT();
            String transactionID = "#" + transaction.getTransactionID();
            String transactionOP = transaction.getTransactionType().toUpperCase();
            String transactionItemName = transaction.getItemName();
            String transactionAmount = (transactionOP.equals("Stock In"))
                                     ? "Stocked In " + transaction.getAmount() + " " + transaction.getItemUnit()
                                     : "Stocked Out " + transaction.getAmount() + " " + transaction.getItemUnit();
            String newAmount = "Value after Transaction : " + transaction.getAmount() + " " + transaction.getItemUnit();

            //SetViews
            this.position = position;
            transDate.setText(transactionDT);
            transID.setText(transactionID);
            transOP.setText(transactionOP);
            transItemName.setText(transactionItemName);
            transAmount.setText(transactionAmount);
            transNewAmount.setText(newAmount);

            //On Void
            voidBtn.setOnClickListener(confirm -> {
                dialogLoader.load_DGContents(new DialogBundle(2, transaction));
            });
        }
    }
}
