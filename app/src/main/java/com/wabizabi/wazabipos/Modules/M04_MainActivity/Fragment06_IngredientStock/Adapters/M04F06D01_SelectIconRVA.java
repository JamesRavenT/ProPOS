package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment06_IngredientStock.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Interfaces.DialogLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.Bundles.DialogBundle;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.IconLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.LayoutHelper;

import java.util.List;

import io.realm.Realm;

public class M04F06D01_SelectIconRVA extends RecyclerView.Adapter<M04F06D01_SelectIconRVA.ViewHolder> {

    Context context;
    Realm realm;
    Dialog dialog;
    DialogBundle bundle;
    List<Integer> listOfIcons;
    DialogLoader dialogLoader;

    public M04F06D01_SelectIconRVA(Context context, Realm realm, Dialog dialog, DialogBundle bundle, List<Integer> listOfIcons, DialogLoader dialogLoader) {
        this.context = context;
        this.realm = realm;
        this.dialog = dialog;
        this.bundle = bundle;
        this.listOfIcons = listOfIcons;
        this.dialogLoader = dialogLoader;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutHelper.inflateRV(parent, R.layout.act04_main_frag06_stocks_dg01_selecticon_rvlayout);
        ViewHolder layout = new ViewHolder(view);
        return layout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int icon = listOfIcons.get(position);
        holder.loadDetails(icon, position);
    }

    @Override
    public int getItemCount() {
        return listOfIcons.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        private ImageView iconImage;
        private TextView iconName;
        private CardView selectBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iconImage = itemView.findViewById(R.id.M04F06D01_RVIconImage);
            iconName = itemView.findViewById(R.id.M04F06D01_RVIconName);
            selectBtn = itemView.findViewById(R.id.M04F06D01_RVSelectBtn);
        }

        public void loadDetails(int icon, int position){
            this.position = position;
            IconLoader.setStockIconSelection(iconImage, iconName, icon);

            //On Select Btn
            selectBtn.setOnClickListener(select -> {
                switch(bundle.getDialogDestinationNo()){
                    case 2:
                    case 4:
                        bundle.getStockCategory().setCategoryImage(icon);
                        dialogLoader.load_DGContents(bundle);
                        dialog.dismiss();
                        break;

                }
            });
        }
    }
}
