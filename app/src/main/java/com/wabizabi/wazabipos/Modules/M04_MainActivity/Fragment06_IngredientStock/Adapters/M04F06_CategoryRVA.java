package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment06_IngredientStock.Adapters;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Menu.M04F02_Menu.currentMenuRV;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment06_IngredientStock.M04F06_IngredientStock.currentStockRV;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.ObjectSchemas.MenuCategory;
import com.wabizabi.wazabipos.Database.ObjectSchemas.StockCategory;
import com.wabizabi.wazabipos.Database.ObjectSchemas.StockItem;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmStockItem;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Interfaces.DialogLoader;
import com.wabizabi.wazabipos.Utilities.Interfaces.RVMenuLoader;
import com.wabizabi.wazabipos.Utilities.Interfaces.RVStockLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.LayoutBuilder;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class M04F06_CategoryRVA extends RecyclerView.Adapter<M04F06_CategoryRVA.ViewHolder> {

    Context context;
    Realm realm;
    EditText searchbar;
    List<StockCategory> listOfCategories;
    RVStockLoader recyclerViewLoader;
    DialogLoader dialogLoader;

    public M04F06_CategoryRVA(Context context, Realm realm, EditText searchbar, List<StockCategory> listOfCategories, RVStockLoader recyclerViewLoader, DialogLoader dialogLoader) {
        this.context = context;
        this.realm = realm;
        this.searchbar = searchbar;
        this.listOfCategories = listOfCategories;
        this.recyclerViewLoader = recyclerViewLoader;
        this.dialogLoader = dialogLoader;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutBuilder.inflate(parent, R.layout.act04_main_frag06_stocks_category_rvlayout);
        ViewHolder layout = new ViewHolder(view);
        return layout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StockCategory category = listOfCategories.get(position);
        holder.loadDetails(category, position);
        holder.onClickEditButton(category, position);
        holder.onClickViewButton(category, position);
    }

    @Override
    public int getItemCount() {
        return listOfCategories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        private TextView categoryName;
        private ImageView editBtn;
        private TextView lastUpdate;
        private CardView viewBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.M04F06_CRVCategoryName);
            editBtn = itemView.findViewById(R.id.M04F06_CRVEditBtn);
            lastUpdate = itemView.findViewById(R.id.M04F06_CRVDateAndTime);
            viewBtn = itemView.findViewById(R.id.M04F06_CRVViewBtn);
        }

        public void loadDetails(StockCategory category, int position){
            this.position = position;
            categoryName.setText(category.getCategoryName());
            lastUpdate.setText(category.getLastUpdatedText());
        }

        public void onClickViewButton(StockCategory category, int position){
            this.position = position;
            viewBtn.setOnClickListener(open -> {
                List<StockItem> listOfItems = new ArrayList<>();
                RealmResults<RealmStockItem> queriedItems = realm.where(RealmStockItem.class).equalTo("itemCategory", category.getCategoryName()).sort("itemName").findAll();
                for(RealmStockItem query : queriedItems){
                    listOfItems.add(new StockItem(query.getItemImage(), query.getItemCategory(), query.getItemName(), query.getItemAmount(), query.getUnitOfMeasurement()));
                }
                currentStockRV = category.getCategoryName();
                searchbar.setText("");
                recyclerViewLoader.load_RVContents(listOfItems);
            });
        }

        public void onClickEditButton(StockCategory category, int position){
            this.position = position;
            editBtn.setOnClickListener(edit -> {
                dialogLoader.load_DGContents(4, 0, category.getCategoryName());
            });
        }


    }
}
