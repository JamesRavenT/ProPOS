package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.SubModule.Categories.Create.SubActivity.Adapter;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.SubModule.Categories.Create.M04F02SM01CF01_CreateCategory.M04F02SM01FA01_CategoryImgNo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.SubModule.Categories.Create.SubActivity.Model.StockImg_CategoryModel;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.SubModule.M04F02SM01_CRUD;
import com.wabizabi.wazabipos.R;

import java.util.List;

public class StockImg_CategoryRVA extends RecyclerView.Adapter<StockImg_CategoryRVA.ViewHolder> {

    List<StockImg_CategoryModel> images;
    Context context;

    public StockImg_CategoryRVA(List<StockImg_CategoryModel> images, Context context) {
        this.images = images;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.act04_main_frag02_stocks_sm01_crud_category_frag01_subact01_selectimg_rvlayout, parent, false);
        ViewHolder rvlayout = new ViewHolder(viewLayout);
        return rvlayout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StockImg_CategoryModel icons = images.get(position);
        holder.showIcons(icons, position);
        holder.iconSelectButton.setOnClickListener(v -> {
            M04F02SM01FA01_CategoryImgNo = holder.getAdapterPosition();
            context.startActivity(new Intent(context, M04F02SM01_CRUD.class));
        });

    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        int position;
        ImageView iconImage;
        TextView iconName;
        CardView iconSelectButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iconImage = itemView.findViewById(R.id.M04F02SM01CF01SA01_IconImage);
            iconName = itemView.findViewById(R.id.M04F02SM01CF01SA01_IconName);
            iconSelectButton = itemView.findViewById(R.id.M04F02SM01CF01SA01_SelectButton);
        }

        public void showIcons(StockImg_CategoryModel icon, int position){
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
}
