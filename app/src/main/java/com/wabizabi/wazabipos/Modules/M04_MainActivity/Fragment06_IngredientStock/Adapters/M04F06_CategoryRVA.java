package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment06_IngredientStock.Adapters;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.M04_Main.currentFragment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.ObjectSchemas.StockCategory;
import com.wabizabi.wazabipos.Database.ObjectSchemas.StockItem;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment06_IngredientStock.Helpers.SIHelper;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Interfaces.DialogLoader;
import com.wabizabi.wazabipos.Utilities.Interfaces.RVLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.Bundles.DialogBundle;
import com.wabizabi.wazabipos.Utilities.Libraries.Bundles.RVBundle;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.LayoutHelper;

import java.util.List;

import io.realm.Realm;

public class M04F06_CategoryRVA extends RecyclerView.Adapter<M04F06_CategoryRVA.ViewHolder> {

    Context context;
    Realm realm;
    EditText searchbar;
    List<StockCategory> listOfCategories;
    RVLoader itemRV;
    DialogLoader dialogLoader;

    public M04F06_CategoryRVA(Context context, Realm realm, EditText searchbar, List<StockCategory> listOfCategories, RVLoader recyclerViewLoader, DialogLoader dialogLoader) {
        this.context = context;
        this.realm = realm;
        this.searchbar = searchbar;
        this.listOfCategories = listOfCategories;
        this.itemRV = recyclerViewLoader;
        this.dialogLoader = dialogLoader;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutHelper.inflateRV(parent, R.layout.act04_main_frag06_stocks_category_rvlayout);
        ViewHolder layout = new ViewHolder(view);
        return layout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StockCategory category = listOfCategories.get(position);
        holder.loadDetails(category, position);
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
            //Load Details
            String name = category.getCategoryName();
            String recentChanges = category.getLastUpdatedText();

            //SetViews
            this.position = position;
            categoryName.setText(category.getCategoryName());
            lastUpdate.setText(recentChanges);

            //On Edit Btn
            editBtn.setOnClickListener(edit -> {
                dialogLoader.load_DGContents(new DialogBundle(3, category));
            });

            //On View Btn
            viewBtn.setOnClickListener(click -> {
                currentFragment = "Stock02";
                List<StockItem> listOfItems = SIHelper.getStockItems(realm, name);
                itemRV.load_RVContents(new RVBundle(listOfItems, name));
            });
        }


    }
}
