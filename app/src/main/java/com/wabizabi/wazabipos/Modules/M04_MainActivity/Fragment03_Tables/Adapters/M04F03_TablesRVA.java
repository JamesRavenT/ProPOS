package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Tables.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.Instances.OpenTableInstance;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmTable;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmTicket;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Interfaces.DialogLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.LayoutBuilder;
import com.wabizabi.wazabipos.Utilities.Libraries.ToastMessage;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class M04F03_TablesRVA extends RecyclerView.Adapter<M04F03_TablesRVA.ViewHolder> {

    Context context;
    Realm realm;
    List<String> listOfTables;
    DialogLoader dialogLoader;

    public M04F03_TablesRVA(Context context, Realm realm, List<String> listOfTables, DialogLoader dialogLoader) {
        this.context = context;
        this.realm = realm;
        this.listOfTables = listOfTables;
        this.dialogLoader = dialogLoader;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutBuilder.inflate(parent, R.layout.act04_main_frag03_tables_rvlayout);
        ViewHolder layout = new ViewHolder(view);
        return layout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String table = listOfTables.get(position);
        holder.loadDetails(table, position);
        holder.onClickEditBtn(table, position);
        holder.onClickSubBtn(table, position);
        holder.onClickAddBtn(table, position);
    }

    @Override
    public int getItemCount() {
        return listOfTables.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        private TextView tableName, tableQty, lastUpdateText;
        private ImageView editBtn;
        private ImageButton addBtn, subBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tableName = itemView.findViewById(R.id.M04F03_RVTableName);
            tableQty = itemView.findViewById(R.id.M04F03_RVTableQty);
            lastUpdateText = itemView.findViewById(R.id.M04F03_RVDateAndTime);
            editBtn = itemView.findViewById(R.id.M04F03_RVEditBtn);
            addBtn = itemView.findViewById(R.id.M04F03_RVQtyAddBtn);
            subBtn = itemView.findViewById(R.id.M04F03_RVQtySubBtn);
        }

        public void loadDetails(String table, int position){
            this.position = position;
            RealmResults<RealmTable> tableCount = realm.where(RealmTable.class).equalTo("tableName", table).sort("tableNo").findAll();
            RealmTable tableItem = tableCount.get(0);
            tableName.setText(table);
            tableQty.setText(String.valueOf(tableCount.size()));
            lastUpdateText.setText(tableItem.getLastUpdatedText());
        }

        public void onClickEditBtn(String table, int position){
            this.position = position;
            editBtn.setOnClickListener(edit -> {
               dialogLoader.load_DGContents(2, -1, table);
            });
        }

        public void onClickSubBtn(String table, int position){
            this.position = position;
            subBtn.setOnClickListener(sub -> {
                RealmResults<RealmTable> listOfTables = realm.where(RealmTable.class).findAll();
                RealmResults<RealmTicket> listOfTickets = realm.where(RealmTicket.class).findAll();
                if(listOfTables.size() != 1 && listOfTickets.isEmpty()){
                    OpenTableInstance.toSubTableCount(table);
                    notifyDataSetChanged();
                } else if(!listOfTickets.isEmpty()) {
                    ToastMessage.show(context, "Cannot remove tables if Tickets are present");
                } else {
                    ToastMessage.show(context, "Cannot remove remaining table");
                }
            });
        }

        public void onClickAddBtn(String table, int position){
            this.position = position;
            addBtn.setOnClickListener(sub -> {
                OpenTableInstance.toAddTableCount(table);
                notifyDataSetChanged();
            });
        }
    }
}
