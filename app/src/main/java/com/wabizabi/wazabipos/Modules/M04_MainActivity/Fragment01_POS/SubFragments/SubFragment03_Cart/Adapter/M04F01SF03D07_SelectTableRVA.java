package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.M04F01SF03_Cart.currentCartTable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.ObjectSchemas.Table;
import com.wabizabi.wazabipos.R;

import java.util.List;

import io.realm.Realm;

public class M04F01SF03D07_SelectTableRVA extends RecyclerView.Adapter<M04F01SF03D07_SelectTableRVA.ViewHolder> {

    Context context;
    Realm realm;
    List<Table> listOfTables;

    public M04F01SF03D07_SelectTableRVA(Context context, Realm realm, List<Table> listOfTables) {
        this.context = context;
        this.realm = realm;
        this.listOfTables = listOfTables;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.act04_main_frag01_pos_subfrag03_order_dg07_selecttable_rvlayout, parent, false);
        ViewHolder layout = new ViewHolder(view);
        return layout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Table table = listOfTables.get(position);
        holder.loadDetails(table, position);
        holder.onSelect(table, position);
    }

    @Override
    public int getItemCount() {
        return listOfTables.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        private ConstraintLayout tableContainer;
        private TextView tableNo, tableName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tableContainer = itemView.findViewById(R.id.M04F01SF03D07_RVContainer);
            tableNo = itemView.findViewById(R.id.M04F01SF03D07_RVTableNo);
            tableName = itemView.findViewById(R.id.M04F01SF03D07_RVTableName);
        }

        public void loadDetails(Table table, int position){
            this.position = position;
            if(table.getTableNo() < 10){
                tableNo.setText("0" + table.getTableNo());
            } else {
                tableNo.setText(String.valueOf(table.getTableNo()));
            }

            tableName.setText(table.getTableName());
            if(currentCartTable != null){
                if(currentCartTable == table){
                    tableContainer.setBackgroundColor(ContextCompat.getColor(context, R.color.green));
                } else {
                    tableContainer.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
                }
            } else {
                tableContainer.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
            }

        }

        public void onSelect(Table table, int position){
            this.position = position;
            tableContainer.setOnClickListener(select -> {
                if(currentCartTable != null){
                    if(currentCartTable == table){
                        currentCartTable = new Table();
                        notifyDataSetChanged();
                    } else {
                        currentCartTable = table;
                        notifyDataSetChanged();
                    }
                } else {
                    currentCartTable = table;
                    notifyDataSetChanged();
                }
            });
        }
    }
}
