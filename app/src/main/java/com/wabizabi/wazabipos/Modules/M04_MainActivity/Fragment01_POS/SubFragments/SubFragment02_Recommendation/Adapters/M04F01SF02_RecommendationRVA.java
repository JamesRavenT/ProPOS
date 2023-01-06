package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment02_Recommendation.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Objects.CartObject;

import java.util.List;

public class M04F01SF02_RecommendationRVA extends RecyclerView.Adapter<M04F01SF02_RecommendationRVA.ViewHolder> {

    Context context;
    List<CartObject> recommendedItems;

    public M04F01SF02_RecommendationRVA(Context context, List<CartObject> recommendedItems){
        this.context = context;
        this.recommendedItems = recommendedItems;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.act04_main_frag01_pos_subfrag02_recommendation_rvlayout, parent, false);
        ViewHolder rvLayout = new ViewHolder(layout);
        return rvLayout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CartObject recommendedItem = recommendedItems.get(position);
        holder.getRecommendedItems(recommendedItem, position);
    }

    @Override
    public int getItemCount() {
        return recommendedItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        ImageView itemImage;
        TextView itemName, itemPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.M04F01SF02_RVItemImage);
            itemName = itemView.findViewById(R.id.M04F01SF02_RVItemName);
            itemPrice = itemView.findViewById(R.id.M04F01SF02_RVItemPrice);
        }

        public void getRecommendedItems(CartObject item, int position){
            this.position = position;
            itemName.setText(item.getItemName());
            itemPrice.setText(String.valueOf(item.getItemPrice()));
        }
    }
}
