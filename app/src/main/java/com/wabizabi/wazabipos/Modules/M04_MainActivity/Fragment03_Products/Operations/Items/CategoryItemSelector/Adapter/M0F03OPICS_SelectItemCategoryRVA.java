package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.Items.CategoryItemSelector.Adapter;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.Items.Create.M04F02OPIC_CreateItem.M04F02OPIC_SelectedCategoryImage;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.Items.Create.M04F02OPIC_CreateItem.M04F02OPIC_SelectedCategoryText;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.M04F02OP_CRUD.operationForM04F02;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.M04F02OP_CRUD.stockCreateItemFragment;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.Items.Create.M04F03OPIC_CreateItem.M04F03OPIC_SelectedCategoryImage;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.Items.Create.M04F03OPIC_CreateItem.M04F03OPIC_SelectedCategoryText;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.M04F03OP_CRUD.operationForM04F03;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.M04F03OP_CRUD.productCreateItemFragment;

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

import com.wabizabi.wazabipos.Database.Schemas.ProductsList;
import com.wabizabi.wazabipos.Database.Schemas.StockList;
import com.wabizabi.wazabipos.R;

import io.realm.RealmResults;

public class M0F03OPICS_SelectItemCategoryRVA extends RecyclerView.Adapter<M0F03OPICS_SelectItemCategoryRVA.ViewHolder> {
    RealmResults<ProductsList> listOfProductsList;
    Context context;

    public M0F03OPICS_SelectItemCategoryRVA(RealmResults<ProductsList> listOfProductsList, Context context) {
        this.listOfProductsList = listOfProductsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.act04_main_frag03_products_operation_crud_itemcategoryselector_rvlayout, parent, false);
        ViewHolder viewLayout = new ViewHolder(layout);
        return viewLayout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductsList itemCategory = listOfProductsList.get(position);
        holder.showCategories(itemCategory, position);
        holder.onClickSelectButton(itemCategory);

    }

    @Override
    public int getItemCount() {
        return listOfProductsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        int position;
        ImageView categoryImage;
        TextView categoryName;
        CardView selectButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryImage = itemView.findViewById(R.id.M04F03OPICS_RVCategoryImage);
            categoryName = itemView.findViewById(R.id.M04F03OPICS_RVCategoryName);
            selectButton = itemView.findViewById(R.id.M04F03OPICS_RVSelectButton);
        }

        public void showCategories(ProductsList category, int position){
            this.position = position;
            categoryName.setText(category.getCategoryName());
            switch(category.getCategoryImage()){
                case 0:
                    categoryImage.setImageResource(R.drawable.icon_products00_default);
                    break;
                case 1:
                    categoryImage.setImageResource(R.drawable.icon_products01_deepfried);
                    break;
                case 2:
                    categoryImage.setImageResource(R.drawable.icon_products02_desserts);
                    break;
                case 3:
                    categoryImage.setImageResource(R.drawable.icon_products03_donburi);
                    break;
                case 4:
                    categoryImage.setImageResource(R.drawable.icon_products04_drinks);
                    break;
                case 5:
                    categoryImage.setImageResource(R.drawable.icon_products05_nigiri);
                    break;
                case 6:
                    categoryImage.setImageResource(R.drawable.icon_products06_noodles);
                    break;
                case 7:
                    categoryImage.setImageResource(R.drawable.icon_products07_salad);
                    break;
                case 8:
                    categoryImage.setImageResource(R.drawable.icon_products08_sashimi);
                    break;
                case 9:
                    categoryImage.setImageResource(R.drawable.icon_products09_sushi);
                    break;
                case 10:
                    categoryImage.setImageResource(R.drawable.icon_products10_sushirolls);
                    break;
            }
        }

        public void onClickSelectButton(ProductsList category){
            selectButton.setOnClickListener(v -> {
                if(operationForM04F03.equals("Select Category for Item Creation")){
                    M04F03OPIC_SelectedCategoryImage = category.getCategoryImage();
                    M04F03OPIC_SelectedCategoryText = category.getCategoryName();
                    operationForM04F03 = "Create Item";
                    ((FragmentActivity) context)
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.M04F03OP_FragmentContainer, productCreateItemFragment)
                            .commit();
                } else if(operationForM04F03.equals("Select Icon For Item Revision")){
                    //Wow
                }
            });
        }
    }
}
