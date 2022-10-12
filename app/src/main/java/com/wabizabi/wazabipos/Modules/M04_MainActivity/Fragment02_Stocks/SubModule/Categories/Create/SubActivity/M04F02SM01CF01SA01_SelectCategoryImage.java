package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.SubModule.Categories.Create.SubActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.SubModule.Categories.Create.SubActivity.Adapter.StockImg_CategoryRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.SubModule.Categories.Create.SubActivity.Model.StockImg_CategoryModel;
import com.wabizabi.wazabipos.R;

import java.util.ArrayList;
import java.util.List;

public class M04F02SM01CF01SA01_SelectCategoryImage extends AppCompatActivity {

    List<StockImg_CategoryModel> listOfIcons = new ArrayList<>();
    RecyclerView selectCategoryImageRV;
    RecyclerView.Adapter selectCategoryImageRVA;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act04_main_frag02_stocks_sm01_crud_category_frag01_subact01_selectimg);
        init_ContentFunctionalities();
    }

    private void init_ContentFunctionalities(){
        init_Views();
        init_ListOfIcons();
        init_RecyclerView();
    }

    private void init_Views(){
        selectCategoryImageRV = findViewById(R.id.M04F02SM01CF01SA01_RecyclerView);
    }

    private void init_ListOfIcons(){
        listOfIcons.add(new StockImg_CategoryModel(0, "Default"));
        listOfIcons.add(new StockImg_CategoryModel(1, "Meat"));
        listOfIcons.add(new StockImg_CategoryModel(2, "Fish"));
        listOfIcons.add(new StockImg_CategoryModel(3, "Fruit"));
        listOfIcons.add(new StockImg_CategoryModel(4, "Vegetable"));
        listOfIcons.add(new StockImg_CategoryModel(5, "Grains"));
        listOfIcons.add(new StockImg_CategoryModel(6, "Spices"));
        listOfIcons.add(new StockImg_CategoryModel(7, "Japanese Condiments"));

    }

    private void init_RecyclerView(){
        LinearLayoutManager layout = new LinearLayoutManager(this);
        layout.setOrientation(LinearLayoutManager.VERTICAL);

        selectCategoryImageRVA = new StockImg_CategoryRVA(listOfIcons, this);
        selectCategoryImageRV.setAdapter(selectCategoryImageRVA);
        selectCategoryImageRV.setLayoutManager(layout);

    }
}
