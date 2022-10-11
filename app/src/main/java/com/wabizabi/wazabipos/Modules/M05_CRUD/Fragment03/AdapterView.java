package com.wabizabi.wazabipos.Modules.M05_CRUD.Fragment03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.R;

import java.util.List;

public class AdapterView extends RecyclerView.Adapter<AdapterView.Holder> {

    List<List<String>> items;
    Context context;

    public AdapterView(List<List<String>> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.act05_crud_frag03_viewproducts_rvlayout, parent, false);
        Holder fpLayout = new Holder(viewLayout);
        return fpLayout;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        List<String> itemz = items.get(position);
        holder.getFpItems(itemz, position);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private int position;
        TextView fpitems;
        public Holder(@NonNull View itemView) {
            super(itemView);
            fpitems = itemView.findViewById(R.id.fpItemsTxt);
        }

        public void getFpItems(List<String> strings, int position){
            this.position = position;
            String fqItemset = strings.toString()
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", " +");
            fpitems.setText(fqItemset);

        }
    }
}
