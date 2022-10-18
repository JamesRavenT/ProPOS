package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.Items.CategoryItemSelector.Adapter;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.Items.Create.M04F02OPIC_CreateItem.M04F02PIC_SelectedCategoryImage;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.Items.Create.M04F02OPIC_CreateItem.M04F02PIC_SelectedCategoryText;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.M04F02OP_CRUD.operationForM04F02OP;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.M04F02OP_CRUD.stockCreateItemFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.Schemas.StockList;
import com.wabizabi.wazabipos.R;

import io.realm.RealmResults;

public class M04F02OPICS_ItemCategoriesRVA extends RecyclerView.Adapter<M04F02OPICS_ItemCategoriesRVA.ViewHolder> {

    RealmResults<StockList> listOfStockList;
    Context context;

    public M04F02OPICS_ItemCategoriesRVA(RealmResults<StockList> listOfStockList, Context context) {
        this.listOfStockList = listOfStockList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.act04_main_frag02_stocks_operation_crud_itemcategoryselector_rvlayout, parent, false);
        ViewHolder viewLayout = new ViewHolder(layout);
        return viewLayout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StockList category = listOfStockList.get(position);
        holder.showCategories(category, position);
        holder.onClickSelectButton(category);
    }

    @Override
    public int getItemCount() {
        return listOfStockList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        int position;
        ImageView categoryImage;
        TextView categoryName;
        CardView selectButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryImage = itemView.findViewById(R.id.M04F02OPICS_RVCategoryImage);
            categoryName = itemView.findViewById(R.id.M04F02OPICS_RVCategoryName);
            selectButton = itemView.findViewById(R.id.M04F02OPICS_RVSelectButton);
        }

        public void showCategories(StockList category, int position){
            this.position = position;
            categoryName.setText(category.getCategoryName());
            switch(category.getCategoryImage()){
                case 0:
                    categoryImage.setImageResource(R.drawable.icon_stocks00_default);
                    break;
                case 1:
                    categoryImage.setImageResource(R.drawable.icon_stocks01_meat);
                    break;
                case 2:
                    categoryImage.setImageResource(R.drawable.icon_stocks02_fish);
                    break;
                case 3:
                    categoryImage.setImageResource(R.drawable.icon_stocks03_fruit);
                    break;
                case 4:
                    categoryImage.setImageResource(R.drawable.icon_stocks04_vegetable);
                    break;
                case 5:
                    categoryImage.setImageResource(R.drawable.icon_stocks05_grains);
                    break;
                case 6:
                    categoryImage.setImageResource(R.drawable.icon_stocks06_spices);
                    break;
                case 7:
                    categoryImage.setImageResource(R.drawable.icon_stocks07_japanese);
                    break;
            }
        }

        public void onClickSelectButton(StockList category){
            selectButton.setOnClickListener(v -> {
                if(operationForM04F02OP.equals("Select Category for Item Creation")){
                    M04F02PIC_SelectedCategoryImage = category.getCategoryImage();
                    M04F02PIC_SelectedCategoryText = category.getCategoryName();
                    operationForM04F02OP = "Create Item";
                    ((FragmentActivity) context)
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.M04F02OP_FragmentContainer, stockCreateItemFragment)
                            .commit();
                } else if(operationForM04F02OP.equals("Select Icon For Item Revision")){
                    //Wow
                }
            });
        }
    }
}
