package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.Items.Read;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.M04F03_Products.M04F03_CurrentItem;
import static com.wabizabi.wazabipos.Utilities.BackgroundThreads.W01_Algorithm.fpList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.Schemas.ProductsItem;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.Items.Read.Adapter.M04F03OPIR_ReadItemRVA;
import com.wabizabi.wazabipos.R;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class M04F03OPIR_ReadItem extends Fragment {

    Realm realm;
    ImageView itemImage;
    TextView itemName;
    RecyclerView fqPatternsRV;
    RecyclerView.Adapter fqPatternsRVA;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag03_products_operation_crud_itemread, container, false);
        init_Functionalities(v);
        return v;
    }

    private void init_Functionalities(View v){
        init_Views(v);
        init_DB();
        init_ItemDetails();
        init_RecyclerView();
    }

    private void init_Views(View v){
        itemImage = v.findViewById(R.id.M04F03OPIR_ItemImage);
        itemName = v.findViewById(R.id.M04F03OPIR_ItemName);
        fqPatternsRV = v.findViewById(R.id.M04F03OPIR_FrequentPatternsRV);
    }

    private void init_DB(){
        realm = Realm.getDefaultInstance();
    }

    private void init_ItemDetails(){
        ProductsItem item = realm.where(ProductsItem.class).equalTo("itemName", M04F03_CurrentItem).findFirst();
        itemName.setText(item.getItemName());
        switch(item.getItemImage()){
            case 0:
                itemImage.setImageResource(R.drawable.icon_products00_default);
                break;
            case 1:
                itemImage.setImageResource(R.drawable.icon_products01_carpaccio);
                break;
            case 2:
                itemImage.setImageResource(R.drawable.icon_products02_deepfried);
                break;
            case 3:
                itemImage.setImageResource(R.drawable.icon_products03_dessert);
                break;
            case 4:
                itemImage.setImageResource(R.drawable.icon_products04_donburi);
                break;
            case 5:
                itemImage.setImageResource(R.drawable.icon_products05_drinks);
                break;
            case 6:
                itemImage.setImageResource(R.drawable.icon_products06_nigiri);
                break;
            case 7:
                itemImage.setImageResource(R.drawable.icon_products07_noodles);
                break;
            case 8:
                itemImage.setImageResource(R.drawable.icon_products08_platter);
                break;
            case 9:
                itemImage.setImageResource(R.drawable.icon_products09_salad);
                break;
            case 10:
                itemImage.setImageResource(R.drawable.icon_products10_sushi);
                break;
        }
    }

    private void init_RecyclerView(){
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        if(!fpList.isEmpty() && fpList.containsKey(M04F03_CurrentItem)){
            List<List<String>> fpItemSets = new ArrayList<>(fpList.get(M04F03_CurrentItem).keySet());
            if(!fpItemSets.isEmpty()){
                fqPatternsRVA = new M04F03OPIR_ReadItemRVA(fpItemSets, getActivity());
                fqPatternsRV.setLayoutManager(layout);
                fqPatternsRV.setAdapter(fqPatternsRVA);
            }
        }
    }
}
