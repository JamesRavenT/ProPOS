package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter;


import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.M04F01SF03_Cart.selectedTable;

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
        holder.loadFunctionalities(table, position);
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

        public void loadFunctionalities(Table table, int position){
            //Load Details
            String name = table.getTableName();

            //Set Views
            this.position = position;
            tableName.setText(name);
            if(table.getTableNo() < 10){
                tableNo.setText("0" + table.getTableNo());
            } else {
                tableNo.setText(String.valueOf(table.getTableNo()));
            }

            //Check if Method is Selected
            if(selectedTable != null){
                if(selectedTable == table){
                    tableContainer.setBackgroundColor(ContextCompat.getColor(context, R.color.green));
                } else {
                    tableContainer.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
                }
            } else {
                tableContainer.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
            }

            //On Select
            tableContainer.setOnClickListener(select -> {
                if(selectedTable != null){
                    if(selectedTable == table){
                        selectedTable = new Table();
                        notifyDataSetChanged();
                    } else {
                        selectedTable = table;
                        notifyDataSetChanged();
                    }
                } else {
                    selectedTable = table;
                    notifyDataSetChanged();
                }
            });

        }
    }
}
