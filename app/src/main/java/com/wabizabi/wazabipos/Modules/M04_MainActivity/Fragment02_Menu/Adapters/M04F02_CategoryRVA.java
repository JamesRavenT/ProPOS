package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Menu.Adapters;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Menu.M04F02_Menu.currentMenuRV;

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
import com.wabizabi.wazabipos.Database.ObjectSchemas.MenuItem;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuItem;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Interfaces.DialogLoader;
import com.wabizabi.wazabipos.Utilities.Interfaces.RVMenuLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.LayoutBuilder;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class M04F02_CategoryRVA extends RecyclerView.Adapter<M04F02_CategoryRVA.ViewHolder> {
    Context context;
    Realm realm;
    EditText searchbar;
    List<MenuCategory> listOfCategories;
    RVMenuLoader recyclerViewLoader;
    DialogLoader dialogLoader;

    public M04F02_CategoryRVA(Context context, Realm realm, EditText searchbar, List<MenuCategory> listOfCategories, RVMenuLoader recyclerViewLoader, DialogLoader dialogLoader) {
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
        View view = LayoutBuilder.inflate(parent, R.layout.act04_main_frag02_menu_category_rvlayout);
        ViewHolder layout = new ViewHolder(view);
        return layout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MenuCategory category = listOfCategories.get(position);
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
            categoryName = itemView.findViewById(R.id.M04F02_CRVCategoryName);
            editBtn = itemView.findViewById(R.id.M04F02_CRVEditBtn);
            lastUpdate = itemView.findViewById(R.id.M04F02_CRVDateAndTime);
            viewBtn = itemView.findViewById(R.id.M04F02_CRVViewBtn);
        }

        public void loadDetails(MenuCategory category, int position){
            this.position = position;
            categoryName.setText(category.getCategoryName());
            lastUpdate.setText(category.getLastUpdatedText());
        }

        public void onClickViewButton(MenuCategory category, int position){
            this.position = position;
            viewBtn.setOnClickListener(open -> {
                List<MenuItem> listOfItems = new ArrayList<>();
                RealmResults<RealmMenuItem> queriedItems = realm.where(RealmMenuItem.class).equalTo("itemCategory", category.getCategoryName()).sort("itemName").findAll();
                for(RealmMenuItem query : queriedItems){
                    listOfItems.add(new MenuItem(query.getItemImage(), query.getItemCategory(), query.getItemName(), query.getItemPrice()));
                }
                currentMenuRV = category.getCategoryName();
                searchbar.setText("");
                recyclerViewLoader.load_RVContents(listOfItems);
            });
        }

        public void onClickEditButton(MenuCategory category, int position){
            this.position = position;
            editBtn.setOnClickListener(edit -> {
                dialogLoader.load_DGContents(4, 0, category.getCategoryName());
            });
        }
    }
}
