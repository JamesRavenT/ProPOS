package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.Categories.CategoryIconSelector.Adapter;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.M04F02OP_CRUD.stockCreateCategoryFragment;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.Categories.Create.M04F03OPCC_CreateCategory.M04F03OPCC_CategoryImage;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.Categories.Update.M04F03OPCU_UpdateCategory.M04F03OPCU_CategoryImage;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.Categories.Update.M04F03OPCU_UpdateCategory.M04F03OPCU_IsEdited;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.M04F03OP_CRUD.operationForM04F03;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.M04F03OP_CRUD.productCreateCategoryFragment;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.M04F03OP_CRUD.productUpdateCategoryFragment;

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

import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.Categories.CategoryIconSelector.Model.M04F03OPCIS_CategoryIconsModel;
import com.wabizabi.wazabipos.R;

import java.util.List;

public class M04F03OPCIS_CategoryIconsRVA extends RecyclerView.Adapter<M04F03OPCIS_CategoryIconsRVA.ViewHolder> {
    List<M04F03OPCIS_CategoryIconsModel> listOfProductCategoryIcons;
    Context context;

    public M04F03OPCIS_CategoryIconsRVA(List<M04F03OPCIS_CategoryIconsModel> listOfProductCategoryIcons, Context context) {
        this.listOfProductCategoryIcons = listOfProductCategoryIcons;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.act04_main_frag03_products_operation_crud_categoryiconselector_rvlayout, parent, false);
        ViewHolder viewLayout = new ViewHolder(layout);
        return viewLayout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        M04F03OPCIS_CategoryIconsModel icons = listOfProductCategoryIcons.get(position);
        holder.showIcons(icons, position);
        holder.onClickSelectButton(position);
    }

    @Override
    public int getItemCount() {
        return listOfProductCategoryIcons.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        int position;
        ImageView iconImage;
        TextView iconName;
        CardView iconSelectButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iconImage = itemView.findViewById(R.id.M04F03OPCIS_IconImage);
            iconName = itemView.findViewById(R.id.M04F03OPCIS_IconName);
            iconSelectButton = itemView.findViewById(R.id.M04F03OPCIS_SelectButton);
        }

        public void showIcons(M04F03OPCIS_CategoryIconsModel icon, int position){
            this.position = position;
            iconName.setText(icon.getIconName());
            switch(position){
                case 0:
                    iconImage.setImageResource(R.drawable.icon_products00_default);
                    break;
                case 1:
                    iconImage.setImageResource(R.drawable.icon_products01_deepfried);
                    break;
                case 2:
                    iconImage.setImageResource(R.drawable.icon_products02_desserts);
                    break;
                case 3:
                    iconImage.setImageResource(R.drawable.icon_products03_donburi);
                    break;
                case 4:
                    iconImage.setImageResource(R.drawable.icon_products04_drinks);
                    break;
                case 5:
                    iconImage.setImageResource(R.drawable.icon_products05_nigiri);
                    break;
                case 6:
                    iconImage.setImageResource(R.drawable.icon_products06_noodles);
                    break;
                case 7:
                    iconImage.setImageResource(R.drawable.icon_products07_salad);
                    break;
                case 8:
                    iconImage.setImageResource(R.drawable.icon_products08_sashimi);
                    break;
                case 9:
                    iconImage.setImageResource(R.drawable.icon_products09_sushi);
                    break;
                case 10:
                    iconImage.setImageResource(R.drawable.icon_products10_sushirolls);
                    break;
            }
        }

        public void onClickSelectButton(int position) {
            iconSelectButton.setOnClickListener(v -> {
                if(operationForM04F03.equals("Select Icon For Category Creation")){
                    M04F03OPCC_CategoryImage = position;
                    operationForM04F03 = "Create Category";
                    ((FragmentActivity) context)
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.M04F03OP_FragmentContainer, productCreateCategoryFragment)
                            .commit();
                } else if(operationForM04F03.equals("Select Icon For Category Revision")){
                    M04F03OPCU_CategoryImage = position;
                    M04F03OPCU_IsEdited = 1;
                    operationForM04F03 = "Edit Category";
                    ((FragmentActivity) context)
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.M04F03OP_FragmentContainer, productUpdateCategoryFragment)
                            .commit();
                }
            });
        }
    }
}
