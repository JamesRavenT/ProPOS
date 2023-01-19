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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.wabizabi.wazabipos.Database.Instances.OpenProductsInstance;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuItem;
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
                itemImage.setImageResource(R.drawable.icon_products00_default);
                break;
            case 1:
                itemImage.setImageResource(R.drawable.icon_products01_deepfried);
                break;
            case 2:
                itemImage.setImageResource(R.drawable.icon_products02_desserts);
                break;
            case 3:
                itemImage.setImageResource(R.drawable.icon_products03_donburi);
                break;
            case 4:
                itemImage.setImageResource(R.drawable.icon_products04_drinks);
                break;
            case 5:
                itemImage.setImageResource(R.drawable.icon_products05_nigiri);
                break;
            case 6:
                itemImage.setImageResource(R.drawable.icon_products06_noodles);
                break;
            case 7:
                itemImage.setImageResource(R.drawable.icon_products07_salad);
                break;
            case 8:
                itemImage.setImageResource(R.drawable.icon_products08_sashimi);
                break;
            case 9:
                itemImage.setImageResource(R.drawable.icon_products09_sushi);
                break;
            case 10:
                itemImage.setImageResource(R.drawable.icon_products10_sushirolls);
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
                RealmResults<RealmMenuItem> items = realm.where(RealmMenuItem.class).findAll();
                List<String> listOfItemNames = new ArrayList<>();
                for(RealmMenuItem item : items){
                    listOfItemNames.add(item.getItemName());
                }
                String itemName = itemNameInput.getText().toString();
                String itemAmountString = itemPriceInput.getText().toString();

                if(M04F03OPIC_SelectedCategoryText.equals("No Category Selected")){
                    Toast.makeText(getActivity(), "Please select a category", Toast.LENGTH_SHORT).show();
                }
                else if(listOfItemNames.contains(itemName)){
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
                    M04F03OPIC_SelectedCategoryText = "No Category Selected";
                    getActivity().finish();
                }
            }
        });
    }
}

