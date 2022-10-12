package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.SubModule.Categories.Create;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.wabizabi.wazabipos.Database.Instances.OpenStocksInstance;
import com.wabizabi.wazabipos.Database.Schemas.StockList;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.M04F02_Stocks;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.SubModule.Categories.Create.SubActivity.M04F02SM01CF01SA01_SelectCategoryImage;
import com.wabizabi.wazabipos.R;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class M04F02SM01CF01_CreateCategory extends Fragment {
    public static int M04F02SM01FA01_CategoryImgNo;
    ImageView categoryImg;
    EditText categoryNameInput;
    CardView selectImgBtn, confirmCreationBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag02_stocks_sm01_crud_category_frag01_create, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }
    private void init_FragmentFunctionalities(View v){
        init_Views(v);
        init_CategoryImage();
        init_Buttons();
    }
    private void init_Views(View v){
        categoryImg = v.findViewById(R.id.M04F02SM01FA01_Image);
        categoryNameInput = v.findViewById(R.id.M04F02SM01FA01_CategoryNameInput);
        selectImgBtn = v.findViewById(R.id.M04F02SM01FA01_SelectImageButton);
        confirmCreationBtn = v.findViewById(R.id.M04F02SM01FA01_ConfirmCreationButton);
    }

    private void init_CategoryImage(){
        switch(M04F02SM01FA01_CategoryImgNo){
            case 0:
                categoryImg.setImageResource(R.drawable.icon_stocks00_default);
                break;
            case 1:
                categoryImg.setImageResource(R.drawable.icon_stocks01_meat);
                break;
            case 2:
                categoryImg.setImageResource(R.drawable.icon_stocks02_fish);
                break;
            case 3:
                categoryImg.setImageResource(R.drawable.icon_stocks03_fruit);
                break;
            case 4:
                categoryImg.setImageResource(R.drawable.icon_stocks04_vegetable);
                break;
            case 5:
                categoryImg.setImageResource(R.drawable.icon_stocks05_grains);
                break;
            case 6:
                categoryImg.setImageResource(R.drawable.icon_stocks06_spices);
                break;
            case 7:
                categoryImg.setImageResource(R.drawable.icon_stocks07_japanese);
                break;
        }
    }

    private void init_Buttons(){
        selectImgBtn.setOnClickListener(v -> init_ImageSelectionPage());
        confirmCreationBtn.setOnClickListener(v -> init_Creation());
    }

    private void init_ImageSelectionPage(){
        startActivity(new Intent(getActivity(), M04F02SM01CF01SA01_SelectCategoryImage.class));
    }

    private void init_Creation(){
        try(Realm realm = Realm.getDefaultInstance()){
            RealmResults<StockList> listOfStockList = realm.where(StockList.class).findAll();
            List<String> listOfStockListName = new ArrayList<>();
            for(StockList category : listOfStockList){
                listOfStockListName.add(category.getCategoryName());
            }

            String categoryName = categoryNameInput.getText().toString();

            if(listOfStockListName.contains(categoryName)){
                categoryNameInput.setError("Category Name Already Exists");
            }
            else if(categoryName.equals("")){
                categoryNameInput.setError("Please enter a name");
            }
            else {
                OpenStocksInstance.toCreateCategory(M04F02SM01FA01_CategoryImgNo, categoryName);
                M04F02SM01FA01_CategoryImgNo = 0;
                categoryNameInput.setText("");
                startActivity(new Intent(getActivity(), M04F02_Stocks.class));
            }
        }
    }
}
