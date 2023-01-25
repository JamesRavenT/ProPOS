package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Menu.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.ObjectSchemas.MenuItem;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Interfaces.DialogLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.IconLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.LayoutBuilder;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import io.realm.Realm;

public class M04F02_ItemRVA extends RecyclerView.Adapter<M04F02_ItemRVA.ViewHolder> {

    Context context;
    Realm realm;
    List<MenuItem> listOfItems;
    DialogLoader dialogLoader;

    public M04F02_ItemRVA(Context context, Realm realm, List<MenuItem> listOfItems, DialogLoader dialogLoader) {
        this.context = context;
        this.realm = realm;
        this.listOfItems = listOfItems;
        this.dialogLoader = dialogLoader;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutBuilder.inflate(parent, R.layout.act04_main_frag02_menu_item_rvlayout);
        ViewHolder layout = new ViewHolder(view);
        return layout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MenuItem item = listOfItems.get(position);
        holder.loadDetails(item, position);
        holder.onClickContainer(item, position);
    }

    @Override
    public int getItemCount() {
        return listOfItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        private CardView itemContainer;
        private ImageView itemImage;
        private TextView itemName, itemPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemContainer = itemView.findViewById(R.id.M04F02_IRVContainer);
            itemImage = itemView.findViewById(R.id.M04F02_IRVItemImage);
            itemName = itemView.findViewById(R.id.M04F02_IRVItemName);
            itemPrice = itemView.findViewById(R.id.M04F02_IRVItemPrice);
        }

        public void loadDetails(MenuItem item, int position){
            this.position = position;
            IconLoader.setMenuIcon(itemImage, item.getItemImage());
            itemName.setText(item.getItemName());
            itemPrice.setText("₱" + new BigDecimal(item.getItemPrice()).setScale(2, RoundingMode.HALF_UP));
        }

        public void onClickContainer(MenuItem item, int position){
            this.position = position;
            itemContainer.setOnClickListener(click -> {
                dialogLoader.load_DGContents(6, item.getItemImage(), item.getItemName());
            });
        }
    }
}
