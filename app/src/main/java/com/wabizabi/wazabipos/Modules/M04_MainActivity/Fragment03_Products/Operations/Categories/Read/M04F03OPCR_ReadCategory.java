package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.Categories.Read;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.M04F03_Products.M04F03_CurrentCategory;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.Categories.Read.Adapter.M04F03OPCR_ReadCategoryRVA.listOfAssociatedProductItems;

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

import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuCategory;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuItem;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.Categories.Read.Adapter.M04F03OPCR_ReadCategoryRVA;
import com.wabizabi.wazabipos.R;

public class M04F03OPCR_ReadCategory extends Fragment {

    io.realm.Realm realm;
    ImageView categoryImage;
    TextView categoryName;
    RecyclerView associatedItemsRV;
    RecyclerView.Adapter associatedItemsRVA;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag03_products_operation_crud_categoryread, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        init_Views(v);
        init_DB();
        init_CategoryDetails();
        init_RecyclerView();
    }

    private void init_Views(View v){
        categoryImage = v.findViewById(R.id.M04F03OPCR_CategoryImage);
        categoryName = v.findViewById(R.id.M04F03OPCR_CategoryName);
        associatedItemsRV = v.findViewById(R.id.M04F03OPCR_AssociatedItemsRV);
    }

    private void init_DB(){
        realm = io.realm.Realm.getDefaultInstance();
    }

    private void init_CategoryDetails(){
        RealmMenuCategory category = realm.where(RealmMenuCategory.class).equalTo("categoryName", M04F03_CurrentCategory).findFirst();
        categoryName.setText(category.getCategoryName());
        switch(category.getCategoryImage()){
            case 0:
                categoryImage.setImageResource(R.drawable.icon_products00_default);
                break;
            case 1:
                categoryImage.setImageResource(R.drawable.icon_products01_deepfried);
                break;
            case 2:
                categoryImage.setImageResource(R.drawable.icon_products02_desserts);
                break;
            case 3:
                categoryImage.setImageResource(R.drawable.icon_products03_donburi);
                break;
            case 4:
                categoryImage.setImageResource(R.drawable.icon_products04_drinks);
                break;
            case 5:
                categoryImage.setImageResource(R.drawable.icon_products05_nigiri);
                break;
            case 6:
                categoryImage.setImageResource(R.drawable.icon_products06_noodles);
                break;
            case 7:
                categoryImage.setImageResource(R.drawable.icon_products07_salad);
                break;
            case 8:
                categoryImage.setImageResource(R.drawable.icon_products08_sashimi);
                break;
            case 9:
                categoryImage.setImageResource(R.drawable.icon_products09_sushi);
                break;
            case 10:
                categoryImage.setImageResource(R.drawable.icon_products10_sushirolls);
                break;
        }
    }

    private void init_RecyclerView(){
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        listOfAssociatedProductItems = realm.where(RealmMenuItem.class).equalTo("itemCategory", M04F03_CurrentCategory).sort("itemName").findAll();
        associatedItemsRVA = new M04F03OPCR_ReadCategoryRVA(getActivity());
        associatedItemsRV.setLayoutManager(layout);
        associatedItemsRV.setAdapter(associatedItemsRVA);

    }
}
