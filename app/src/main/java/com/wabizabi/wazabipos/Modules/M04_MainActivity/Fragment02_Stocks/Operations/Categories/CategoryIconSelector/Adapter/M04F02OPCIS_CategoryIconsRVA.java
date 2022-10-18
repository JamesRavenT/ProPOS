package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.Categories.CategoryIconSelector.Adapter;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.Categories.Create.M04F02OPCC_CreateCategory.M04F02OPCC_CategoryImage;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.Categories.Update.M04F02OPCU_UpdateCategory.M04F02OPCU_CategoryImgNo;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.Categories.Update.M04F02OPCU_UpdateCategory.oldCategoryDetail;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.M04F02OP_CRUD.operationForM04F02OP;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.M04F02OP_CRUD.stockCreateCategoryFragment;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.M04F02OP_CRUD.stockUpdateCategoryFragment;


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

import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.Categories.CategoryIconSelector.Model.M04F02OPCIS_CategoryIconsModel;
import com.wabizabi.wazabipos.R;

import java.util.List;

public class M04F02OPCIS_CategoryIconsRVA extends RecyclerView.Adapter<M04F02OPCIS_CategoryIconsRVA.ViewHolder> {

    List<M04F02OPCIS_CategoryIconsModel> listOfStockCategoryIcons;
    Context context;

    public M04F02OPCIS_CategoryIconsRVA(List<M04F02OPCIS_CategoryIconsModel> listOfStockCategoryIcons, Context context) {
        this.listOfStockCategoryIcons = listOfStockCategoryIcons;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.act04_main_frag02_stocks_operation_crud_categoryiconselector_rvlayout, parent, false);
        ViewHolder rvlayout = new ViewHolder(viewLayout);
        return rvlayout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        M04F02OPCIS_CategoryIconsModel icons = listOfStockCategoryIcons.get(position);
        holder.showIcons(icons, position);
        holder.iconSelectButton.setOnClickListener(v -> {
            if(operationForM04F02OP.equals("Select Icon For Category Creation")) {
                M04F02OPCC_CategoryImage = holder.getAdapterPosition();
                init_CreateCategoryPage();
            } else if(operationForM04F02OP.equals("Select Icon For Category Revision")){
                M04F02OPCU_CategoryImgNo = holder.getAdapterPosition();
                init_UpdateCategoryPage();
            }

        });

    }

    @Override
    public int getItemCount() {
        return listOfStockCategoryIcons.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        int position;
        ImageView iconImage;
        TextView iconName;
        CardView iconSelectButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iconImage = itemView.findViewById(R.id.M04F02OPCIS_IconImage);
            iconName = itemView.findViewById(R.id.M04F02OPCIS_IconName);
            iconSelectButton = itemView.findViewById(R.id.M04F02OPCIS_SelectButton);
        }

        public void showIcons(M04F02OPCIS_CategoryIconsModel icon, int position){
            this.position = position;
            iconName.setText(icon.getIconName());
            switch(position){
                case 0:
                    iconImage.setImageResource(R.drawable.icon_stocks00_default);
                    break;
                case 1:
                    iconImage.setImageResource(R.drawable.icon_stocks01_meat);
                    break;
                case 2:
                    iconImage.setImageResource(R.drawable.icon_stocks02_fish);
                    break;
                case 3:
                    iconImage.setImageResource(R.drawable.icon_stocks03_fruit);
                    break;
                case 4:
                    iconImage.setImageResource(R.drawable.icon_stocks04_vegetable);
                    break;
                case 5:
                    iconImage.setImageResource(R.drawable.icon_stocks05_grains);
                    break;
                case 6:
                    iconImage.setImageResource(R.drawable.icon_stocks06_spices);
                    break;
                case 7:
                    iconImage.setImageResource(R.drawable.icon_stocks07_japanese);
                    break;
            }
        }
    }

    private void init_CreateCategoryPage(){
        operationForM04F02OP = "Create Category";
        ((FragmentActivity) context)
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.M04F02OP_FragmentContainer, stockCreateCategoryFragment)
                .commit();
    }

    private void init_UpdateCategoryPage(){
        oldCategoryDetail = 1;
        operationForM04F02OP = "Edit Category";
        ((FragmentActivity) context)
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.M04F02OP_FragmentContainer, stockUpdateCategoryFragment)
                .commit();
    }
}
