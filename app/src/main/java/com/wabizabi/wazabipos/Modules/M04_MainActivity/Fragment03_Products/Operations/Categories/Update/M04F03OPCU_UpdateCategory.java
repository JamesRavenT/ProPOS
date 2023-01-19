package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.Categories.Update;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.M04F03_Products.M04F03_CurrentCategory;
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
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuCategory;
import com.wabizabi.wazabipos.R;

public class M04F03OPCU_UpdateCategory extends Fragment {
    public static int M04F03OPCU_CategoryImage;
    public static int M04F03OPCU_IsEdited;
    io.realm.Realm realm;
    ImageView categoryImage;
    EditText categoryNameInput;
    CardView categorySelectImage, categoryConfirmChanges;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag03_products_operation_crud_categoryupdate, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        init_Views(v);
        init_DB();
        init_CategoryDetails();
        init_Buttons();
    }

    private void init_Views(View v){
        categoryImage = v.findViewById(R.id.M04F03OPCU_Image);
        categoryNameInput = v.findViewById(R.id.M04F03OPCU_CategoryNameInput);
        categorySelectImage = v.findViewById(R.id.M04F03OPCU_SelectImageButton);
        categoryConfirmChanges = v.findViewById(R.id.M04F03OPCU_ConfirmChangesButton);
    }

    private void init_DB(){
        realm = io.realm.Realm.getDefaultInstance();
    }

    private void init_CategoryDetails(){
        RealmMenuCategory category = realm.where(RealmMenuCategory.class).equalTo("categoryName", M04F03_CurrentCategory).findFirst();
        categoryNameInput.setHint(category.getCategoryName());
        if(M04F03OPCU_IsEdited == 0){
            M04F03OPCU_CategoryImage = category.getCategoryImage();
        }
        switch(M04F03OPCU_CategoryImage){
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
        categorySelectImage.setOnClickListener(v -> {
            operationForM04F03 = "Select Icon For Category Revision";
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.M04F03OP_FragmentContainer, productCategorySelectIconFragment)
                    .commit();
        });

        categoryConfirmChanges.setOnClickListener(v -> {
            String name = categoryNameInput.getText().toString();
            if(name.equals("")) {
                categoryNameInput.setError("This field can't be empty.");
            }
            else {
                OpenProductsInstance.toEditCategory(M04F03OPCU_CategoryImage, name);
                M04F03OPCU_IsEdited = 0;
                getActivity().finish();
            }
        });
    }
}
