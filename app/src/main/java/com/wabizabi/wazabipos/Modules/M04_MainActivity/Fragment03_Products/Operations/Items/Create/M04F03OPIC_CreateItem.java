package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.Items.Create;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.M04F03OP_CRUD.operationForM04F03;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.M04F03OP_CRUD.productItemCategorySelectFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.wabizabi.wazabipos.Database.Instances.OpenProductsInstance;
import com.wabizabi.wazabipos.Database.Schemas.ProductsItem;
import com.wabizabi.wazabipos.R;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class M04F03OPIC_CreateItem extends Fragment {
    public static int M04F03OPIC_SelectedCategoryImage;
    public static String M04F03OPIC_SelectedCategoryText = "No Category Selected";
    ImageView itemImage;
    TextView itemCategory;
    EditText itemNameInput, itemPriceInput;
    CardView selectCategoryButton, confirmCreationButton;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag03_products_operation_crud_itemcreate, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        init_Views(v);
        init_ItemCategory();
        init_Buttons();
    }

    private void init_Views(View v){
        itemImage = v.findViewById(R.id.M04F03OPIC_Image);
        itemCategory = v.findViewById(R.id.M04F03OPIC_ItemCategoryText);
        itemNameInput = v.findViewById(R.id.M04F03OPIC_ItemNameInput);
        itemPriceInput = v.findViewById(R.id.M04F03OPIC_ItemAmountInput);
        selectCategoryButton = v.findViewById(R.id.M04F03OPIC_SelectCategoryButton);
        confirmCreationButton = v.findViewById(R.id.M04F03OPIC_ConfirmCreationButton);
    }

    private void init_ItemCategory(){
        itemCategory.setText(M04F03OPIC_SelectedCategoryText);
        switch(M04F03OPIC_SelectedCategoryImage){
            case 0:
                itemImage.setImageResource(R.drawable.icon_stocks00_default);
                break;
            case 1:
                itemImage.setImageResource(R.drawable.icon_stocks01_meat);
                break;
            case 2:
                itemImage.setImageResource(R.drawable.icon_stocks02_fish);
                break;
            case 3:
                itemImage.setImageResource(R.drawable.icon_stocks03_fruit);
                break;
            case 4:
                itemImage.setImageResource(R.drawable.icon_stocks04_vegetable);
                break;
            case 5:
                itemImage.setImageResource(R.drawable.icon_stocks05_grains);
                break;
            case 6:
                itemImage.setImageResource(R.drawable.icon_stocks06_spices);
                break;
            case 7:
                itemImage.setImageResource(R.drawable.icon_stocks07_japanese);
                break;
        }
    }

    private void init_Buttons(){
        selectCategoryButton.setOnClickListener(v -> {
            operationForM04F03 = "Select Category for Item Creation";
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.M04F03OP_FragmentContainer, productItemCategorySelectFragment)
                    .commit();
        });
        confirmCreationButton.setOnClickListener(v -> {
            try(Realm realm = Realm.getDefaultInstance()){
                RealmResults<ProductsItem> items = realm.where(ProductsItem.class).findAll();
                List<String> listOfItemNames = new ArrayList<>();
                for(ProductsItem item : items){
                    listOfItemNames.add(item.getItemName());
                }
                String itemName = itemNameInput.getText().toString();
                String itemAmountString = itemPriceInput.getText().toString();

                if(listOfItemNames.contains(itemName)){
                    itemNameInput.setError("Item Name Already Exists");
                }
                else if(itemName.equals("")){
                    itemNameInput.setError("This field can't be empty");
                }
                else if(itemPriceInput.getText().toString().equals("")){
                    itemPriceInput.setError("This field can't be empty");
                }
                else {
                    int itemPrice = Integer.parseInt(itemAmountString);
                    OpenProductsInstance.toCreateItem(M04F03OPIC_SelectedCategoryImage, M04F03OPIC_SelectedCategoryText, itemName, itemPrice);
                    getActivity().finish();
                }
            }
        });
    }
}

