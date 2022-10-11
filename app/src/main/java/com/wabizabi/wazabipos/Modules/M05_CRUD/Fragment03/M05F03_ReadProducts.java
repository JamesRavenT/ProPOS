package com.wabizabi.wazabipos.Modules.M05_CRUD.Fragment03;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Activity_Main.currentProductCategory;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Activity_Main.currentProductCategoryIndex;
import static com.wabizabi.wazabipos.Utilities.GlobalVariables.currentIndex;
import static com.wabizabi.wazabipos.Utilities.GlobalVariables.fpList;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.Schemas.ProductsItem;
import com.wabizabi.wazabipos.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmResults;

public class M05F03_ReadProducts extends Fragment {
    Realm realm;
    TextView itemName, itemPrice;
    RecyclerView itemviewRV;
    RecyclerView.Adapter itemviewRVA;
    RealmResults<ProductsItem> itemList;
    ProductsItem item;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act05_crud_frag03_viewproducts, container, false);
        realm = Realm.getDefaultInstance();
        if(currentProductCategoryIndex == -1){
            itemList = realm.where(ProductsItem.class).sort("itemName").findAll();
        } else {
            itemList = realm.where(ProductsItem.class).equalTo("itemCategory", currentProductCategory).sort("itemName").findAll();
        }

        item = itemList.get(currentIndex);
        itemName = v.findViewById(R.id.view_ItemName);
        itemPrice = v.findViewById(R.id.view_ItemPrice);

        itemName.setText(item.getItemName());
        itemPrice.setText(String.valueOf(item.getItemPrice()));

        itemviewRV = v.findViewById(R.id.view_FPRV);

        //RV
        String key = item.getItemName();

        Log.v("tag", "HOOOOORAYYYY");
        List<List<String>> fpitemList = new ArrayList<>(fpList.get(key).keySet());
        Log.v("tagyourit", "aa" + fpitemList.size());





        LinearLayoutManager fpLayout = new LinearLayoutManager(getActivity());
        fpLayout.setOrientation(LinearLayoutManager.VERTICAL);
        itemviewRVA = new AdapterView(fpitemList, getActivity());
        itemviewRV.setLayoutManager(fpLayout);
        itemviewRV.setAdapter(itemviewRVA);




        return v;
    }
}
