package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.Categories.CategoryIconSelector;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.Categories.CategoryIconSelector.Adapter.M04F02OPCIS_CategoryIconsRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.Categories.CategoryIconSelector.Model.M04F02OPCIS_CategoryIconsModel;
import com.wabizabi.wazabipos.R;

import java.util.ArrayList;
import java.util.List;

public class M04F02OPCIS_SelectCategoryImage extends Fragment {
    List<M04F02OPCIS_CategoryIconsModel> listOfStockCategoryIcons = new ArrayList<>();
    RecyclerView selectCategoryImageRV;
    RecyclerView.Adapter selectCategoryImageRVA;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag02_stocks_operation_crud_categoryiconselector, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        init_Views(v);
        init_ListOfIcons();
        init_RecyclerView();
    }

    private void init_Views(View v){
        selectCategoryImageRV = v.findViewById(R.id.M04F02OPCIS_RecyclerView);
    }

    private void init_ListOfIcons(){
        if(listOfStockCategoryIcons.size() != 8){
            listOfStockCategoryIcons.add(new M04F02OPCIS_CategoryIconsModel(0, "Default"));
            listOfStockCategoryIcons.add(new M04F02OPCIS_CategoryIconsModel(1, "Meat"));
            listOfStockCategoryIcons.add(new M04F02OPCIS_CategoryIconsModel(2, "Fish"));
            listOfStockCategoryIcons.add(new M04F02OPCIS_CategoryIconsModel(3, "Fruit"));
            listOfStockCategoryIcons.add(new M04F02OPCIS_CategoryIconsModel(4, "Vegetable"));
            listOfStockCategoryIcons.add(new M04F02OPCIS_CategoryIconsModel(5, "Grains"));
            listOfStockCategoryIcons.add(new M04F02OPCIS_CategoryIconsModel(6, "Spices"));
            listOfStockCategoryIcons.add(new M04F02OPCIS_CategoryIconsModel(7, "Japanese Condiments"));
        }
    }

    private void init_RecyclerView(){
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        selectCategoryImageRVA = new M04F02OPCIS_CategoryIconsRVA(listOfStockCategoryIcons, getActivity());
        selectCategoryImageRV.setAdapter(selectCategoryImageRVA);
        selectCategoryImageRV.setLayoutManager(layout);
    }
}
