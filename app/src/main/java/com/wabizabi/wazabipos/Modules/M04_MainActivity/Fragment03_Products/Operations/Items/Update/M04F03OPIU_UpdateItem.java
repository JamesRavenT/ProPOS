package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.Items.Update;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.M04F03_Products.M04F03_CurrentItem;

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
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuItem;
import com.wabizabi.wazabipos.R;

import io.realm.Realm;

public class M04F03OPIU_UpdateItem extends Fragment {

    Realm realm;
    ImageView itemImage;
    EditText itemNameInput, itemPriceInput;
    CardView confirmChangesButton;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag03_products_operation_crud_itemupdate, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        init_Views(v);
        init_DB();
        init_ItemDetails();
        init_Buttons();
    }

    private void init_Views(View v){
        itemImage = v.findViewById(R.id.M04F03OPIU_Image);
        itemNameInput = v.findViewById(R.id.M04F03OPIU_ItemNameInput);
        itemPriceInput = v.findViewById(R.id.M04F03OPIU_ItemPriceInput);
        confirmChangesButton = v.findViewById(R.id.M04F03OPIU_ConfirmChangesButton);
    }

    private void init_DB(){
        realm = Realm.getDefaultInstance();
    }

    private void init_ItemDetails(){
        RealmMenuItem item = realm.where(RealmMenuItem.class).equalTo("itemName", M04F03_CurrentItem).findFirst();
        itemNameInput.setHint(item.getItemName());
        itemPriceInput.setHint(String.valueOf(item.getItemPrice()));
        switch(item.getItemImage()){
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
        confirmChangesButton.setOnClickListener(v -> {
            String name = itemNameInput.getText().toString();
            String price = itemPriceInput.getText().toString();
            if(name.equals("")) {
                itemNameInput.setError("This field can't be empty.");
            }
            else if(price.equals("")){
                itemPriceInput.setError("This field can't be empty.");
            }
            else {
                OpenProductsInstance.toEditItem(name, Integer.parseInt(price));
                getActivity().finish();
            }
        });
    }

}
