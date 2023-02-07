package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Adapters;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.M04_Main.currentFragment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.ObjectSchemas.MenuCategory;
import com.wabizabi.wazabipos.Database.ObjectSchemas.MenuItem;
import com.wabizabi.wazabipos.Utilities.Interfaces.RVLoader;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Libraries.Bundles.RVBundle;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.IconLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.LayoutHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.ListHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.RVHelper;

import java.util.List;

import io.realm.Realm;

public class M04F01_CategoryRVA extends RecyclerView.Adapter<M04F01_CategoryRVA.ViewHolder> {

    Context context;
    Realm realm;
    RVLoader itemRV;
    List<MenuCategory> listOfCategories;

    public M04F01_CategoryRVA(Context context,
                              Realm realm,
                              List<MenuCategory> listOfCategories,
                              RVLoader itemRV) {
        this.context = context;
        this.realm = realm;
        this.listOfCategories = listOfCategories;
        this.itemRV = itemRV;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutHelper.inflateRV(parent, R.layout.act04_main_frag01_pos_category_rvlayout);
        ViewHolder layout = new ViewHolder(view);
        return layout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MenuCategory category = listOfCategories.get(position);
        holder.loadFunctionalities(category, position);
    }

    @Override
    public int getItemCount() {
        return listOfCategories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        private final CardView categoryContainer;
        private final TextView categoryName, categorySize;
        private final ImageView categoryImage01, categoryImage02, categoryImage03;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryContainer = itemView.findViewById(R.id.M04F01_CRVContainer);
            categoryName = itemView.findViewById(R.id.M04F01_CRVCategoryName);
            categorySize = itemView.findViewById(R.id.M04F01_CRVCategorySize);
            categoryImage01 = itemView.findViewById(R.id.M04F01_CRVImage01);
            categoryImage02 = itemView.findViewById(R.id.M04F01_CRVImage02);
            categoryImage03 = itemView.findViewById(R.id.M04F01_CRVImage03);
        }

        public void loadFunctionalities(MenuCategory category, int position){
            //Load Details
            String name = category.getCategoryName();
            String size = RVHelper.getMenuCategorySize(realm, name);

            //Set Views
            this.position = position;
            categoryName.setText(name);
            categorySize.setText(size);
            IconLoader.setMenuIcon(categoryImage01, category.getCategoryImage());
            IconLoader.setMenuIcon(categoryImage02, category.getCategoryImage());
            IconLoader.setMenuIcon(categoryImage03, category.getCategoryImage());

            //On Click Container
            categoryContainer.setOnClickListener(click -> {
                currentFragment = "POS02";
                List<MenuItem> listOfItems = RVHelper.getMenuItems(realm, name);
                itemRV.load_RVContents(new RVBundle(name, listOfItems));
            });
        }
    }
}
