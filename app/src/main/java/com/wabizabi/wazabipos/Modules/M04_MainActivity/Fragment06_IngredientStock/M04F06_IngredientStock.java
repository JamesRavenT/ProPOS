package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment06_IngredientStock;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.M04_Main.currentFragment;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.Instances.OpenStocksInstance;
import com.wabizabi.wazabipos.Database.ObjectSchemas.StockCategory;
import com.wabizabi.wazabipos.Database.ObjectSchemas.StockItem;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment06_IngredientStock.Adapters.M04F06D01_SelectIconRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment06_IngredientStock.Adapters.M04F06_CategoryRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment06_IngredientStock.Adapters.M04F06_ItemRVA;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Interfaces.DialogLoader;
import com.wabizabi.wazabipos.Utilities.Interfaces.RVLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.Bundles.DialogBundle;
import com.wabizabi.wazabipos.Utilities.Libraries.Bundles.RVBundle;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.DialogBuilder;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.IconLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.ListHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.RVHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.ToastMessage;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class M04F06_IngredientStock extends Fragment implements RVLoader, DialogLoader {
    //--DATABASE--//
    Realm realm = Realm.getDefaultInstance();

    //--CREATE BUTTON--//
    ImageView createBtn;

    //--SEARCH BAR--//
    EditText searchbar;

    //--RECYCLERVIEW--//
    public static String currentStockRV = "Categories";
    TextView displayText;
    RecyclerView stockRV;
    RecyclerView.Adapter stockRVA;
    List<StockCategory> listOfStockCategories;
    List<StockItem> listOfStockItems;

    //--Dialogs--//
    //--DG01 SELECT ICON--//
    Dialog stockDG01;
    RecyclerView stockDG01_RecyclerView;
    RecyclerView.Adapter stockDG01_RecyclerViewAdapter;
    ImageView closeDG01Btn;

    //--DG02 CREATE CATEGORY--//
    Dialog stockDG02;
    ImageView stockDG02_CategoryImg;
    CardView stockDG02_SelectIconBtn;
    EditText stockDG02_CategoryNameInput;
    CardView stockDG02_ConfirmBtn;
    ImageView closeDG02Btn;

    //--DG03 CREATE ITEM--//
    Dialog stockDG03;
    ImageView stockDG03_ItemImg;
    EditText stockDG03_ItemNameInput,
             stockDG03_ItemMeasurementInput;
    CardView stockDG03_ConfirmBtn;
    ImageView closeDG03Btn;

    //--DG04 EDIT CATEGORY--//
    Dialog stockDG04;
    ImageView stockDG04_CategoryImg;
    CardView stockDG04_SelectIconBtn;
    EditText stockDG04_CategoryNameInput;
    CardView stockDG04_ApplyChangesBtn, stockDG04_DeleteBtn;
    ImageView closeDG04Btn;

    //--DG05 EDIT ITEM--//
    Dialog stockDG05;
    ImageView stockDG05_ItemImg;
    EditText stockDG05_ItemNameInput,
             stockDG05_ItemMeasurementInput;
    CardView stockDG05_ApplyChangesBtn, stockDG05_DeleteBtn;
    ImageView closeDG05Btn;

    //--DG06 VIEW ITEM--//
    Dialog stockDG06;
    ImageView stockDG06_ItemImage;
    CardView stockDG06_EditBtn, stockDG06_UpdateBtn;
    TextView stockDG06_ItemName,
             stockDG06_ItemQty,
             stockDG06_ItemMeasurement;
    ImageView stockDG06_SubBtn,
              stockDG06_AddBtn,
              closeDG06Btn;

    //--DG07 DELETE CATEGORY--//
    Dialog stockDG07;
    TextView stockDG07_CategoryName;
    CardView stockDG07_YesBtn, stockDG07_NoBtn;
    ImageView closeDG07Btn;

    //--DG08 DELETE ITEM--//
    Dialog stockDG08;
    TextView stockDG08_ItemName;
    CardView stockDG08_YesBtn, stockDG08_NoBtn;
    ImageView closeDG08Btn;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag06_stocks, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        createBtn = v.findViewById(R.id.M04F06_CreateBtn);
        searchbar = v.findViewById(R.id.M04F06_SearchBarInput);
        displayText = v.findViewById(R.id.M04F06_RecyclerViewItemText);
        stockRV = v.findViewById(R.id.M04F06_RecyclerView);

        init_Dialogs();
        load_CategoryCreation();
        load_SearchBar();
        load_CategoryRV();

    }
    private void load_CategoryCreation(){
        createBtn.setOnClickListener(create -> {
            if(currentFragment.equals("Stock01")){
                load_DG02Functionalities(new DialogBundle(2, new StockCategory(0, "")));
                stockDG02.show();
            }
        });
    }

    private void load_ItemCreation(RVBundle bundle){
        createBtn.setOnClickListener(create -> {
            if(currentFragment.equals("Stock02")){
                load_DG03Functionalities(new DialogBundle(3, new StockItem(0, bundle.getMenuCategory(),"", 0, ""), bundle));
                stockDG03.show();
            }
        });
    }

    private void load_SearchBar(){
        searchbar.setText("");
        searchbar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable input) {
                if(currentFragment.equals("Stock01")){
                    load_FilteredCategoryRV(input.toString());
                } else {
                    load_FilteredItemRV(input.toString());
                }
            }
        });
    }

    private void load_CategoryRV(){
        //Initialize RecyclerViewItems and State
        displayText.setText("「 CATEGORIES 」");

        //Initialize RecyclerView
        listOfStockCategories = RVHelper.getStockCategories(realm);
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        stockRVA = new M04F06_CategoryRVA(getActivity(), realm, searchbar, listOfStockCategories, this, this);
        stockRV.setAdapter(stockRVA);
        stockRV.setLayoutManager(layout);
    }

    private void load_FilteredCategoryRV(String input){
        List<StockCategory> filteredCategory = RVHelper.getFilteredStockCategories(listOfStockCategories, input);
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        stockRVA = new M04F06_CategoryRVA(getActivity(), realm, searchbar, filteredCategory, this, this);
        stockRV.setAdapter(stockRVA);
        stockRV.setLayoutManager(layout);
    }

    private void load_ItemRV(RVBundle bundle){
        //Initialize RecyclerViewItems and State
        displayText.setText("「 " + bundle.getStockCategory().toUpperCase() + " 」");

        //Initialize RecyclerViewItems
        listOfStockItems = RVHelper.getStockItems(realm, bundle.getStockCategory());
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        stockRVA = new M04F06_ItemRVA(getActivity(), realm, listOfStockItems, this);
        stockRV.setAdapter(stockRVA);
        stockRV.setLayoutManager(layout);

        //Load Create Item Functionality
        load_ItemCreation(bundle);
    }

    private void load_FilteredItemRV(String input){
        List<StockItem> filteredItem = RVHelper.getFilteredStockItems(listOfStockItems, input);
        GridLayoutManager layout = new GridLayoutManager(getActivity(), 2);
        layout.setOrientation(GridLayoutManager.VERTICAL);
        stockRVA = new M04F06_ItemRVA(getActivity(), realm, filteredItem, this);
        stockRV.setAdapter(stockRVA);
        stockRV.setLayoutManager(layout);
    }

    private void init_Dialogs(){
        //--DG01 SELECT ICON--//
        stockDG01 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag06_stocks_dg01_selecticon);
        stockDG01_RecyclerView = stockDG01.findViewById(R.id.M04F06D01_IconsRV);
        closeDG01Btn = stockDG01.findViewById(R.id.M04F06D01_CloseDGBtn);

        //--DG02 CREATE CATEGORY--//
        stockDG02 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag06_stocks_dg02_createcategory);
        stockDG02_CategoryImg = stockDG02.findViewById(R.id.M04F06D02_CategoryImage);
        stockDG02_SelectIconBtn = stockDG02.findViewById(R.id.M04F06D02_SelectIconBtn);
        stockDG02_CategoryNameInput = stockDG02.findViewById(R.id.M04F06D02_CategoryNameInput);
        stockDG02_ConfirmBtn = stockDG02.findViewById(R.id.M04F06D02_ConfirmBtn);
        closeDG02Btn = stockDG02.findViewById(R.id.M04F06D02_CloseDGBtn);

        //--DG03 CREATE ITEM--//
        stockDG03 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag06_stocks_dg03_createitem);
        stockDG03_ItemImg = stockDG03.findViewById(R.id.M04F06D03_CategoryImage);
        stockDG03_ItemNameInput= stockDG03.findViewById(R.id.M04F06D03_ItemNameInput);
        stockDG03_ItemMeasurementInput = stockDG03.findViewById(R.id.M04F06D03_ItemMeasurementInput);
        stockDG03_ConfirmBtn = stockDG03.findViewById(R.id.M04F06D03_ConfirmBtn);
        closeDG03Btn = stockDG03.findViewById(R.id.M04F06D03_CloseDGBtn);

        //--DG04 EDIT CATEGORY--//
        stockDG04 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag06_stocks_dg04_editcategory);
        stockDG04_CategoryImg = stockDG04.findViewById(R.id.M04F06D04_CategoryImage);
        stockDG04_CategoryNameInput = stockDG04.findViewById(R.id.M04F06D04_CategoryNameInput);
        stockDG04_SelectIconBtn = stockDG04.findViewById(R.id.M04F06D04_SelectIconBtn);
        stockDG04_ApplyChangesBtn = stockDG04.findViewById(R.id.M04F06D04_ApplyChangesBtn);
        stockDG04_DeleteBtn = stockDG04.findViewById(R.id.M04F06D04_DeleteBtn);
        closeDG04Btn = stockDG04.findViewById(R.id.M04F06D04_CloseDGBtn);

        //--DG05 EDIT ITEM--//
        stockDG05 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag06_stocks_dg05_edititem);
        stockDG05_ItemImg = stockDG05.findViewById(R.id.M04F06D05_CategoryImage);
        stockDG05_ItemNameInput = stockDG05.findViewById(R.id.M04F06D05_ItemNameInput);
        stockDG05_ItemMeasurementInput = stockDG05.findViewById(R.id.M04F06D05_ItemMeasurementInput);
        stockDG05_ApplyChangesBtn = stockDG05.findViewById(R.id.M04F06D05_ApplyChangesBtn);
        stockDG05_DeleteBtn = stockDG05.findViewById(R.id.M04F06D05_DeleteBtn);
        closeDG05Btn = stockDG05.findViewById(R.id.M04F06D05_CloseDGBtn);

        //--DG06 VIEW ITEM --//
        stockDG06 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag06_stocks_dg06_viewitem);
        stockDG06_ItemImage = stockDG06.findViewById(R.id.M04F06D06_ItemImage);
        stockDG06_EditBtn = stockDG06.findViewById(R.id.M04F06D06_EditBtn);
        stockDG06_ItemName = stockDG06.findViewById(R.id.M04F06D06_ItemName);
        stockDG06_ItemQty = stockDG06.findViewById(R.id.M04F06D06_ItemQty);
        stockDG06_ItemMeasurement = stockDG06.findViewById(R.id.M04F06D06_UnitOfMeasurement);
        stockDG06_SubBtn = stockDG06.findViewById(R.id.M04F06D06_QtySubBtn);
        stockDG06_AddBtn = stockDG06.findViewById(R.id.M04F06D06_QtyAddBtn);
        stockDG06_UpdateBtn = stockDG06.findViewById(R.id.M04F06D06_UpdateBtn);
        closeDG06Btn = stockDG06.findViewById(R.id.M04F06D06_CloseDGBtn);

        //--DG07 DELETE CATEGORY--//
        stockDG07 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag06_stocks_dg07_deletecategory);
        stockDG07_CategoryName = stockDG07.findViewById(R.id.M04F06D07_CategoryNameText);
        stockDG07_YesBtn = stockDG07.findViewById(R.id.M04F06D07_YesBtn);
        stockDG07_NoBtn = stockDG07.findViewById(R.id.M04F06D07_NoBtn);
        closeDG07Btn = stockDG07.findViewById(R.id.M04F06D07_CloseDGBtn);

        //--DG08 DELETE ITEM--//
        stockDG08 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag06_stocks_dg08_deleteitem);
        stockDG08_ItemName = stockDG08.findViewById(R.id.M04F06D08_ItemNameText);
        stockDG08_YesBtn = stockDG08.findViewById(R.id.M04F06D08_YesBtn);
        stockDG08_NoBtn = stockDG08.findViewById(R.id.M04F06D08_NoBtn);
        closeDG08Btn = stockDG08.findViewById(R.id.M04F06D08_CloseDGBtn);
    }

    //Select Icon
    private void load_DG01Functionalities(DialogBundle bundle){
        //Initialize RecyclerView
        List<Integer> icons = RVHelper.getStockIcons();
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        stockDG01_RecyclerViewAdapter = new M04F06D01_SelectIconRVA(getActivity(), realm, stockDG01, bundle, icons, this);
        stockDG01_RecyclerView.setAdapter(stockDG01_RecyclerViewAdapter);
        stockDG01_RecyclerView.setLayoutManager(layout);

        //On Close Button
        closeDG01Btn.setOnClickListener(close->{
            if(bundle.getDialogDestinationNo() == 2){
                load_DG02Functionalities(bundle);
                stockDG01.dismiss();
                stockDG02.show();
            } else if(bundle.getDialogDestinationNo() == 4){
                load_DG04Functionalites(bundle);
                stockDG01.dismiss();
                stockDG04.show();
            }
        });
    }

    //Create Category
    private void load_DG02Functionalities(DialogBundle bundle){
        //Unpack Bundle
        int image = bundle.getStockCategory().getCategoryImage();
        String name = bundle.getStockCategory().getCategoryName();


        //Set Image and Name;
        IconLoader.setStockIcon(stockDG02_CategoryImg, image);
        stockDG02_CategoryNameInput.setText(name);

        //On Click SelectIconButton
        stockDG02_SelectIconBtn.setOnClickListener(select -> {
            //Extract String from Edit Text
            String input = stockDG02_CategoryNameInput.getText().toString();

            //Load DG01 and pass the Bundle
            bundle.getStockCategory().setCategoryName(input);
            load_DG01Functionalities(bundle);
            stockDG02.dismiss();
            stockDG01.show();
        });

        //On Confirm Button
        stockDG02_ConfirmBtn.setOnClickListener(create -> {
            //Extract String from Edit Text
            String input = stockDG02_CategoryNameInput.getText().toString();

            //Check String
            List<String> listOfCategories = ListHelper.getStockCategoryNames(realm);
            if(listOfCategories.contains(input)){
                stockDG02_CategoryNameInput.setError("Name already exists.");
            } else {
                OpenStocksInstance.toCreateCategory(image, input);
                load_CategoryRV();
                stockDG02_CategoryNameInput.setText("");
                stockDG02.dismiss();
            }
        });

        //On Close Button
        closeDG02Btn.setOnClickListener(close -> {
            stockDG02.dismiss();
        });
    }

    //Create Item
    private void load_DG03Functionalities(DialogBundle bundle){
        //Unpack Bundle
        int image = bundle.getStockItem().getItemImage();
        String category = bundle.getStockItem().getItemCategory();
        String name = bundle.getStockItem().getItemName();
        RVBundle items = bundle.getRvBundle();

        //Set Image and Name
        IconLoader.setStockIcon(stockDG03_ItemImg, image);
        stockDG03_ItemNameInput.setText("");
        stockDG03_ItemMeasurementInput.setText("");

        //On Confirm Button
        stockDG03_ConfirmBtn.setOnClickListener(create -> {
            String nameInput = stockDG03_ItemNameInput.getText().toString();
            String measurementInput = stockDG03_ItemMeasurementInput.getText().toString();
            List<String> listOfItems = ListHelper.getStockItemNames(realm);
            if(listOfItems.contains(nameInput)){
                stockDG03_ItemNameInput.setError("Name already exists.");
            } else {
                OpenStocksInstance.toCreateItem(image, category, nameInput, 1, measurementInput);
                load_ItemRV(items);
                stockDG03_ItemNameInput.setText("");
                stockDG03_ItemMeasurementInput.setText("");
                stockDG03.dismiss();
            }
        });

        //On Close
        closeDG03Btn.setOnClickListener(close -> {
            stockDG03.dismiss();
        });
    }

    //Edit Category
    private void load_DG04Functionalites(DialogBundle bundle){
        //Unpack Bundle
        int image = bundle.getStockCategory().getCategoryImage();
        String name = bundle.getStockCategory().getCategoryName();

        //Set Image and Name;
        IconLoader.setStockIcon(stockDG04_CategoryImg, image);
        stockDG04_CategoryNameInput.setText(name);

        //On Click SelectIconButton
        stockDG04_SelectIconBtn.setOnClickListener(select -> {
            bundle.getStockCategory().setCategoryName(stockDG04_CategoryNameInput.getText().toString());
            load_DG01Functionalities(bundle);
            stockDG04.dismiss();
            stockDG01.show();
        });

        //On Apply Button
        stockDG04_ApplyChangesBtn.setOnClickListener(apply -> {
            String input = stockDG04_CategoryNameInput.getText().toString();
            List<String> listOfCategories = ListHelper.getStockCategoryNames(realm);
            if(name.equals(input)){
                ToastMessage.show(getActivity(), "No Changes were made");
                stockDG04_CategoryNameInput.setText("");
                stockDG04.dismiss();
            } else if(listOfCategories.contains(input) && !name.equals(input)){
                stockDG04_CategoryNameInput.setError("Name Already Exists");
            } else {
                OpenStocksInstance.toUpdateCategory(name, image, input);
                load_CategoryRV();
                stockDG04_CategoryNameInput.setText("");
                stockDG04.dismiss();
            }
        });

        //On Delete Button
        stockDG04_DeleteBtn.setOnClickListener(delete -> {
            load_DG07Functionalities(bundle);
            stockDG04.dismiss();
            stockDG07.show();
        });

        //On Close Button
        closeDG04Btn.setOnClickListener(close -> {
            stockDG04.dismiss();
        });
    }

    //Edit Item
    private void load_DG05Functionalities(DialogBundle bundle){
        //Unpack Bundle
        int image = bundle.getStockItem().getItemImage();
        String category = bundle.getStockItem().getItemCategory();
        String name = bundle.getStockItem().getItemName();
        String measurement = bundle.getStockItem().getUnitOfMeasurement();
        RVBundle items = bundle.getRvBundle();

        //Set Image and Name;
        IconLoader.setStockIcon(stockDG05_ItemImg, image);
        stockDG05_ItemNameInput.setText(name);
        stockDG05_ItemMeasurementInput.setText(measurement);

        //On Apply Button
        stockDG05_ApplyChangesBtn.setOnClickListener(apply -> {
            String nameInput = stockDG05_ItemNameInput.getText().toString();
            String measurementInput = stockDG05_ItemMeasurementInput.getText().toString();
            List<String> listOfItems = ListHelper.getStockItemNames(realm);
            if(name.equals(nameInput) && measurement.equals(measurementInput)){
                ToastMessage.show(getActivity(), "No changes were made");
                stockDG05.dismiss();
            } else if(name.equals(nameInput) && !measurement.equals(measurementInput)){
                OpenStocksInstance.toUpdateItem(name, image, category, nameInput, measurementInput);
                load_ItemRV(items);
                stockDG05_ItemNameInput.setText("");
                stockDG05_ItemMeasurementInput.setText("");
                stockDG05.dismiss();
            } else if(listOfItems.contains(nameInput)){
                stockDG05_ItemNameInput.setError("Name already exists");
            } else {
                OpenStocksInstance.toUpdateItem(name, image, category, nameInput, measurementInput);
                load_ItemRV(items);
                stockDG05_ItemNameInput.setText("");
                stockDG05_ItemMeasurementInput.setText("");
                stockDG05.dismiss();
            }
        });

        //On Delete Button
        stockDG05_DeleteBtn.setOnClickListener(delete -> {
            load_DG08Functionalities(bundle);
            stockDG05.dismiss();
            stockDG08.show();
        });

        //On Close
        closeDG05Btn.setOnClickListener(close -> {
            load_DG06Functionalities(bundle);
            stockDG05.dismiss();
            stockDG06.show();
        });
    }

    //View Item
    private void load_DG06Functionalities(DialogBundle bundle){
        //Unpack Bundle
        int image = bundle.getStockItem().getItemImage();
        String category = bundle.getStockItem().getItemCategory();
        String name = bundle.getStockItem().getItemName();
        int amount = bundle.getStockItem().getItemAmount();
        String measurement = bundle.getStockItem().getUnitOfMeasurement();
        RVBundle items = bundle.getRvBundle();

        //Load Item Details
        IconLoader.setStockIcon(stockDG06_ItemImage, image);
        stockDG06_ItemName.setText(name);
        stockDG06_ItemQty.setText(String.valueOf(amount));
        stockDG06_ItemMeasurement.setText(measurement);

        //On Edit Button
        stockDG06_EditBtn.setOnClickListener(edit -> {
            load_DG05Functionalities(bundle);
            stockDG06.dismiss();
            stockDG05.show();
        });

        //On Add and Sub Button
        stockDG06_SubBtn.setOnClickListener(sub -> {
            int counter = Integer.parseInt(stockDG06_ItemQty.getText().toString());
            if(counter != 0){
                counter--;
                stockDG06_ItemQty.setText(String.valueOf(counter));
            }
        });

        stockDG06_AddBtn.setOnClickListener(add -> {
            int counter = Integer.parseInt(stockDG06_ItemQty.getText().toString());
            counter++;
            stockDG06_ItemQty.setText(String.valueOf(counter));
        });

        //On Update Button
        stockDG06_UpdateBtn.setOnClickListener(update -> {
            int newAmount = Integer.parseInt(stockDG06_ItemQty.getText().toString());
            if(newAmount != amount){
                OpenStocksInstance.toUpdateAmount(category, name, newAmount);
                load_ItemRV(items);
                stockDG06.dismiss();
            }
        });


        //On Close Button
        closeDG06Btn.setOnClickListener(close -> {
            stockDG06.dismiss();
        });
    }

    //Delete Category
    private void load_DG07Functionalities(DialogBundle bundle){
        //Unpack Bundle
        int image = bundle.getStockCategory().getCategoryImage();
        String name = bundle.getStockCategory().getCategoryName();

        //Set Category Name
        stockDG07_CategoryName.setText(name);

        //On Yes Btn
        stockDG07_YesBtn.setOnClickListener(delete -> {
            OpenStocksInstance.toDeleteCategory(name);
            load_CategoryRV();
            stockDG07.dismiss();
        });
        //On No Btn
        stockDG07_NoBtn.setOnClickListener(delete -> {
            load_DG04Functionalites(bundle);
            stockDG07.dismiss();
            stockDG04.show();
        });
        //On Close Btn
        closeDG07Btn.setOnClickListener(close -> {
            load_DG04Functionalites(bundle);
            stockDG07.dismiss();
            stockDG04.show();
        });
    }

    //Delete Item
    private void load_DG08Functionalities(DialogBundle bundle){
        //Unpack Bundle
        int image = bundle.getStockItem().getItemImage();
        String category = bundle.getStockItem().getItemCategory();
        String name = bundle.getStockItem().getItemName();
        int amount = bundle.getStockItem().getItemAmount();
        String measurement = bundle.getStockItem().getUnitOfMeasurement();
        RVBundle items = bundle.getRvBundle();

        //Set Item Name
        stockDG08_ItemName.setText(name);
        //On Yes Btn
        stockDG08_YesBtn.setOnClickListener(delete -> {
            OpenStocksInstance.toDeleteItem(category, name);
            load_ItemRV(items);
            stockDG08.dismiss();
        });

        //On No Btn
        stockDG08_NoBtn.setOnClickListener(delete -> {
            load_DG06Functionalities(bundle);
            stockDG06.show();
            stockDG08.dismiss();
        });

        //On Close Btn
        closeDG08Btn.setOnClickListener(close -> {
            load_DG06Functionalities(bundle);
            stockDG06.show();
            stockDG08.dismiss();
        });
    }

    @Override
    public void load_RVContents(RVBundle bundle) {
        load_ItemRV(bundle);
    }

    @Override
    public void load_DGContents(DialogBundle bundle) {
        int dialogNo = bundle.getDialogDestinationNo();
        switch(dialogNo){
            case 2:
                load_DG02Functionalities(bundle);
                stockDG02.show();
                break;
            case 4:
                load_DG04Functionalites(bundle);
                stockDG04.show();
                break;
            case 6:
                load_DG06Functionalities(bundle);
                stockDG06.show();
                break;
        }
    }
}
