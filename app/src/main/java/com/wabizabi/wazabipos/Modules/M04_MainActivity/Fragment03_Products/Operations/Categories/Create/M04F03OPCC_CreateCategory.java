package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.Categories.Create;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.M04F02OP_CRUD.stockCategorySelectIconFragment;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.M04F03OP_CRUD.operationForM04F03;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.M04F03OP_CRUD.productCategorySelectIconFragment;

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

import com.wabizabi.wazabipos.Database.Instances.OpenProductsInstance;
import com.wabizabi.wazabipos.Database.Schemas.ProductsList;
import com.wabizabi.wazabipos.R;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class M04F03OPCC_CreateCategory extends Fragment {
    public static int M04F03OPCC_CategoryImage;
    ImageView categoryImage;
    EditText categoryNameInput;
    CardView selectImgBtn, confirmCreatitonBtn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag03_products_operation_crud_categorycreate, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        init_Views(v);
        init_CategoryImage();
        init_Buttons();
    }

    private void init_Views(View v){
        categoryImage = v.findViewById(R.id.M04F03OPCC_Image);
        categoryNameInput = v.findViewById(R.id.M04F03OPCC_CategoryNameInput);
        selectImgBtn = v.findViewById(R.id.M04F03OPCC_SelectImageButton);
        confirmCreatitonBtn = v.findViewById(R.id.M04F03OPCC_ConfirmCreationButton);
    }

    private void init_CategoryImage(){
        switch(M04F03OPCC_CategoryImage){
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

    private void init_Buttons(){
        selectImgBtn.setOnClickListener(v -> {
            operationForM04F03 = "Select Icon For Category Creation";
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.M04F03OP_FragmentContainer, productCategorySelectIconFragment)
                    .commit();
        });

        confirmCreatitonBtn.setOnClickListener(v -> {
            try(Realm realm = Realm.getDefaultInstance()){
                RealmResults<ProductsList> listOfProductsList = realm.where(ProductsList.class).findAll();
                List<String> listOfProductsListName = new ArrayList<>();
                for(ProductsList category : listOfProductsList){
                    listOfProductsListName.add(category.getCategoryName());
                }

                String categoryName = categoryNameInput.getText().toString();

                if(listOfProductsListName.contains(categoryName)){
                    categoryNameInput.setError("Category name already exists");
                }
                else if(categoryName.equals("")){
                    categoryNameInput.setError("This field cannot be empty.");
                }
                else {
                    OpenProductsInstance.toCreateCategory(M04F03OPCC_CategoryImage,categoryName);
                    M04F03OPCC_CategoryImage = 0;
                    categoryNameInput.setText("");
                    getActivity().finish();
                }
            }
        });

    }}
