package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.Categories.CategoryIconSelector;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.Categories.CategoryIconSelector.Adapter.M04F03OPCIS_CategoryIconsRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.Categories.CategoryIconSelector.Model.M04F03OPCIS_CategoryIconsModel;
import com.wabizabi.wazabipos.R;

import java.util.ArrayList;
import java.util.List;

public class M04F03OPCIS_SelectCategoryImage extends Fragment {
    List<M04F03OPCIS_CategoryIconsModel> listOfProductCategoryIcons = new ArrayList<>();
    RecyclerView selectCategoryImageRV;
    RecyclerView.Adapter selectCategoryImageRVA;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag03_products_operation_crud_categoryiconselector, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        init_Views(v);
        init_ListOfIcons();
        init_RecyclerViews();
    }

    private void init_Views(View v){
        selectCategoryImageRV = v.findViewById(R.id.M04F03OPCIS_RecyclerView);
    }

    private void init_ListOfIcons(){
        if(listOfProductCategoryIcons.size() != 11){
            listOfProductCategoryIcons.add(new M04F03OPCIS_CategoryIconsModel(0, "Default"));
            listOfProductCategoryIcons.add(new M04F03OPCIS_CategoryIconsModel(1, "Carpaccio"));
            listOfProductCategoryIcons.add(new M04F03OPCIS_CategoryIconsModel(2, "Deepfried"));
            listOfProductCategoryIcons.add(new M04F03OPCIS_CategoryIconsModel(3, "Dessert"));
            listOfProductCategoryIcons.add(new M04F03OPCIS_CategoryIconsModel(4, "Donburi"));
            listOfProductCategoryIcons.add(new M04F03OPCIS_CategoryIconsModel(5, "Drinks"));
            listOfProductCategoryIcons.add(new M04F03OPCIS_CategoryIconsModel(6, "Nigiri"));
            listOfProductCategoryIcons.add(new M04F03OPCIS_CategoryIconsModel(7, "Noodles"));
            listOfProductCategoryIcons.add(new M04F03OPCIS_CategoryIconsModel(8, "Platter"));
            listOfProductCategoryIcons.add(new M04F03OPCIS_CategoryIconsModel(9, "Salad"));
            listOfProductCategoryIcons.add(new M04F03OPCIS_CategoryIconsModel(10, "Sushi"));
        }
    }

    private void init_RecyclerViews(){
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        selectCategoryImageRVA = new M04F03OPCIS_CategoryIconsRVA(listOfProductCategoryIcons, getActivity());
        selectCategoryImageRV.setAdapter(selectCategoryImageRVA);
        selectCategoryImageRV.setLayoutManager(layout);
    }
}
