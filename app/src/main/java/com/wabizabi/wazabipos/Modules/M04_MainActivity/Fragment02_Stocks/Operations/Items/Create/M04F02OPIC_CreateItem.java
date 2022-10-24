package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.Items.Create;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.M04F02OP_CRUD.operationForM04F02;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.M04F02OP_CRUD.stockItemCategorySelectFragment;

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

import com.wabizabi.wazabipos.Database.Instances.OpenStocksInstance;
import com.wabizabi.wazabipos.Database.Instances.OpenTransactionsInstance;
import com.wabizabi.wazabipos.Database.Schemas.StockItem;
import com.wabizabi.wazabipos.R;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class M04F02OPIC_CreateItem extends Fragment {
    public static int M04F02OPIC_SelectedCategoryImage;
    public static String M04F02OPIC_SelectedCategoryText = "No Category Selected";
    ImageView itemImage;
    TextView itemCategory;
    EditText itemNameInput, itemAmountInput, itemUnitInput;
    CardView selectCategoryBtn, confirmCreationBtn;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag02_stocks_operation_crud_itemcreate, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        init_Views(v);
        init_ItemCategory();
        init_Buttons();
    }

    private void init_Views(View v){
        itemImage = v.findViewById(R.id.M04F02OPIC_Image);
        itemCategory = v.findViewById(R.id.M04F02OPIC_ItemCategoryText);
        itemNameInput = v.findViewById(R.id.M04F02OPIC_ItemNameInput);
        itemAmountInput = v.findViewById(R.id.M04F02OPIC_ItemAmountInput);
        itemUnitInput = v.findViewById(R.id.M04F02OPIC_ItemMeasurementInput);
        selectCategoryBtn = v.findViewById(R.id.M04F02OPIC_SelectCategoryButton);
        confirmCreationBtn = v.findViewById(R.id.M04F02OPIC_ConfirmCreationButton);
    }

    private void init_ItemCategory(){
        itemCategory.setText(M04F02OPIC_SelectedCategoryText);
        switch(M04F02OPIC_SelectedCategoryImage){
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
        selectCategoryBtn.setOnClickListener(v -> init_CategorySelectionPage());
        confirmCreationBtn.setOnClickListener(v -> init_Creation());
    }

    private void init_CategorySelectionPage(){
        operationForM04F02 = "Select Category for Item Creation";
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.M04F02OP_FragmentContainer, stockItemCategorySelectFragment)
                .commit();
    }

    private void init_Creation(){
        try(Realm realm = Realm.getDefaultInstance()){
            RealmResults<StockItem> items = realm.where(StockItem.class).findAll();
            List<String> listOfItemNames = new ArrayList<>();
            for(StockItem item : items){
                listOfItemNames.add(item.getItemName());
            }

            String itemName = itemNameInput.getText().toString();
            String itemAmountString = itemAmountInput.getText().toString();

            String itemUnit = itemUnitInput.getText().toString();

            if(M04F02OPIC_SelectedCategoryText.equals("No Category Selected")){
                Toast.makeText(getActivity(), "Please select a category", Toast.LENGTH_SHORT).show();
            }
            else if(listOfItemNames.contains(itemName)){
                itemNameInput.setError("Item Name Already Exists");
            }
            else if(itemName.equals("")){
                itemNameInput.setError("This field can't be empty");
            }
            else if(itemAmountInput.getText().toString().equals("")){
                itemAmountInput.setError("This field can't be empty");
            }
            else if(itemUnit.equals("")){
                itemUnitInput.setError("This field can't be empty");
            }
            else {
                int itemAmount = Integer.parseInt(itemAmountString);
                OpenStocksInstance.toCreateItem(M04F02OPIC_SelectedCategoryImage, M04F02OPIC_SelectedCategoryText, itemName, itemAmount, itemUnit);
                OpenTransactionsInstance.toUpdateInventory("create", itemName, itemAmount, 0, itemUnit);
                M04F02OPIC_SelectedCategoryText = "No Category Selected";
                getActivity().finish();
            }
        }
    }
}
