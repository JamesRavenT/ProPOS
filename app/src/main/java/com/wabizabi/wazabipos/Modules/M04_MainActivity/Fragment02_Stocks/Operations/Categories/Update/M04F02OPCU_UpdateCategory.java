package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.Categories.Update;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.M04F02_Stocks.M04F02_CurrentCategory;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.M04F02_Stocks.M04F02_CurrentCategoryIndex;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.M04F02OP_CRUD.operationForM04F02OP;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.M04F02OP_CRUD.stockCategorySelectIconFragment;

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
import com.wabizabi.wazabipos.R;

import io.realm.Realm;
import io.realm.RealmResults;

public class M04F02OPCU_UpdateCategory extends Fragment {
    public static int M04F02OPCU_CategoryImgNo;
    public static int oldCategoryDetail;
    Realm realm;
    ImageView categoryImage;
    EditText categoryNameInput;
    CardView categorySelectImage, categoryConfirmChanges;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag02_stocks_operation_crud_categoryupdate, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        init_Views(v);
        init_DB();
        init_Buttons();
        init_CategoryDetails();
    }

    private void init_Views(View v){
        categoryImage = v.findViewById(R.id.M04F02OPCU_Image);
        categoryNameInput = v.findViewById(R.id.M04F02OPCU_CategoryNameInput);
        categorySelectImage = v.findViewById(R.id.M04F02OPCU_SelectImageButton);
        categoryConfirmChanges = v.findViewById(R.id.M04F02OPCU_ConfirmChangesButton);
    }

    private void init_DB(){
        realm = Realm.getDefaultInstance();
    }

    private void init_Buttons(){
        categorySelectImage.setOnClickListener(v -> init_ImageSelectionPage());
        categoryConfirmChanges.setOnClickListener(v -> init_Updates());
    }

    private void init_CategoryDetails(){
        StockList category = realm.where(StockList.class).equalTo("categoryName", M04F02_CurrentCategory).findFirst();
        categoryNameInput.setHint(category.getCategoryName());
        if(oldCategoryDetail == 0){
            M04F02OPCU_CategoryImgNo = category.getCategoryImage();
        }
        switch(M04F02OPCU_CategoryImgNo){
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

    private void init_ImageSelectionPage(){
        operationForM04F02OP = "Select Icon For Category Revision";
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.M04F02OP_FragmentContainer, stockCategorySelectIconFragment)
                .commit();
    }

    private void init_Updates(){
        String name = categoryNameInput.getText().toString();
        if(name.equals("")) {
            categoryNameInput.setError("This field can't be empty.");
        }
        else {
            OpenStocksInstance.toEditCategory(M04F02OPCU_CategoryImgNo, name, M04F02_CurrentCategoryIndex);
            M04F02OPCU_CategoryImgNo = 0;
            getActivity().finish();
        }
    }
}
