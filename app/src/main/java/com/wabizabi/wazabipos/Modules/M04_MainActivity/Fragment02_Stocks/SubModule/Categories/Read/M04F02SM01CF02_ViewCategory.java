package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.SubModule.Categories.Read;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.M04F02_Stocks.currentStockCategory;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.M04F02_Stocks.currentStockCategoryIndex;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.SubModule.Categories.Read.Adapter.M04F02SM01CF02_RVA.listOfAssociatedStockItems;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.Schemas.StockItem;
import com.wabizabi.wazabipos.Database.Schemas.StockList;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.SubModule.Categories.Read.Adapter.M04F02SM01CF02_RVA;
import com.wabizabi.wazabipos.R;

import io.realm.Realm;
import io.realm.RealmResults;

public class M04F02SM01CF02_ViewCategory extends Fragment {

    Realm realm;
    ImageView categoryImage;
    ImageButton editButton;
    TextView categoryName, associatedItemsTxt;
    RecyclerView associatedItemsRV;
    RecyclerView.Adapter associatedItemsRVA;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag02_stocks_sm01_crud_category_frag02_read, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        init_Views(v);
        init_DB();
        init_CategoryDetails();
//        init_Button();
        init_RecyclerView();
    }

    private void init_Views(View v){
        categoryImage = v.findViewById(R.id.M04F02SM01CF02_CategoryImage);
        editButton = v.findViewById(R.id.M04F02SM01CF02_EditButton);
        categoryName = v.findViewById(R.id.M04F02SM01CF02_CategoryName);
        associatedItemsTxt = v.findViewById(R.id.M04F02SM01CF02_AssociatedItemsText);
        associatedItemsRV = v.findViewById(R.id.M04F02SM01CF02_AssociatedItemsRV);
    }

    private void init_DB() {
        realm = Realm.getDefaultInstance();
        //AAAA
    }

    private void init_CategoryDetails(){
        RealmResults<StockList> listOfStocks = realm.where(StockList.class).sort("categoryName").findAll();
        StockList category = listOfStocks.get(currentStockCategoryIndex);
        categoryName.setText(category.getCategoryName());
        switch (category.getCategoryImage()) {
            case 0:
                categoryImage.setImageResource(R.drawable.icon_stocks00_default);
                break;
            case 1:
                categoryImage.setImageResource(R.drawable.icon_stocks01_meat);
                break;
            case 2:
                categoryImage.setImageResource(R.drawable.icon_stocks02_fish);
                break;
            case 3:
                categoryImage.setImageResource(R.drawable.icon_stocks03_fruit);
                break;
            case 4:
                categoryImage.setImageResource(R.drawable.icon_stocks04_vegetable);
                break;
            case 5:
                categoryImage.setImageResource(R.drawable.icon_stocks05_grains);
                break;
            case 6:
                categoryImage.setImageResource(R.drawable.icon_stocks06_spices);
                break;
            case 7:
                categoryImage.setImageResource(R.drawable.icon_stocks07_japanese);
                break;
        }
    }

    private void init_Button(){
        editButton.setOnClickListener(v -> {

        });
    }

    private void init_RecyclerView(){
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);

        listOfAssociatedStockItems = realm.where(StockItem.class).equalTo("itemCategory", currentStockCategory).sort("itemName").findAll();
        associatedItemsRVA = new M04F02SM01CF02_RVA(getActivity());
        associatedItemsRV.setLayoutManager(layout);
    }
}
