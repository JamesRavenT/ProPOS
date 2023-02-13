package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment06_IngredientStock.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.ObjectSchemas.StockItem;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Interfaces.DialogLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.Bundles.DialogBundle;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.IconLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.LayoutHelper;

import java.util.List;

import io.realm.Realm;

public class M04F06_ItemRVA extends RecyclerView.Adapter<M04F06_ItemRVA.ViewHolder> {

    Context context;
    Realm realm;
    List<StockItem> listOfItems;
    DialogLoader dialogLoader;

    public M04F06_ItemRVA(Context context, Realm realm, List<StockItem> listOfItems, DialogLoader dialogLoader) {
        this.context = context;
        this.realm = realm;
        this.listOfItems = listOfItems;
        this.dialogLoader = dialogLoader;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutHelper.inflateRV(parent, R.layout.act04_main_frag06_stocks_item_rvlayout);
        ViewHolder layout = new ViewHolder(view);
        return layout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StockItem item = listOfItems.get(position);
        holder.loadFunctionalities(item, position);
    }

    @Override
    public int getItemCount() {
        return listOfItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        private CardView itemContainer;
        private ImageView itemImage;
        private TextView itemName, itemAmount;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemContainer = itemView.findViewById(R.id.M04F06_IRVContainer);
            itemImage = itemView.findViewById(R.id.M04F06_IRVItemImage);
            itemName = itemView.findViewById(R.id.M04F06_IRVItemName);
            itemAmount = itemView.findViewById(R.id.M04F06_IRVAmount);
        }

        public void loadFunctionalities(StockItem item, int position){
            this.position = position;
            IconLoader.setMenuIcon(itemImage, item.getItemImage());
            itemName.setText(item.getItemName());
            itemAmount.setText(item.getItemAmount() + " " + item.getUnitOfMeasurement());

            //On Container
            itemContainer.setOnClickListener(click -> {
                dialogLoader.load_DGContents(new DialogBundle(7, item));
            });
        }

    }


}
