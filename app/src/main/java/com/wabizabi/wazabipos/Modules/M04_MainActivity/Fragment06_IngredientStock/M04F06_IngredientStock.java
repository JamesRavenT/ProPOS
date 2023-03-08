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
import com.wabizabi.wazabipos.Database.Instances.OpenTransactionsInstance;
import com.wabizabi.wazabipos.Database.ObjectSchemas.StockCategory;
import com.wabizabi.wazabipos.Database.ObjectSchemas.StockItem;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmStockCategory;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment06_IngredientStock.Adapters.M04F06D01_SelectIconRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment06_IngredientStock.Adapters.M04F06_CategoryRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment06_IngredientStock.Adapters.M04F06_ItemRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment06_IngredientStock.Helpers.SCHelper;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment06_IngredientStock.Helpers.SIHelper;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Interfaces.DialogLoader;
import com.wabizabi.wazabipos.Utilities.Interfaces.RVLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.Bundles.DialogBundle;
import com.wabizabi.wazabipos.Utilities.Libraries.Bundles.RVBundle;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.DialogHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.IconHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.ToastHelper;

import java.util.List;

import io.realm.Realm;

public class M04F06_IngredientStock extends Fragment implements RVLoader, DialogLoader {
    //--DATABASE--//
    Realm realm = Realm.getDefaultInstance();

    //--CREATE BUTTON--//
    ImageView createBtn;

    //--SEARCH BAR--//
    EditText searchbar;

    //--RECYCLERVIEW--//
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

    //--DG03 EDIT CATEGORY--//
    Dialog stockDG03;
    ImageView stockDG03_CategoryImg;
    CardView stockDG03_SelectIconBtn;
    EditText stockDG03_CategoryNameInput;
    CardView stockDG03_ApplyChangesBtn, stockDG03_DeleteBtn;
    ImageView closeDG03Btn;

    //--DG04 DELETE CATEGORY--//
    Dialog stockDG04;
    TextView stockDG04_CategoryName;
    CardView stockDG04_YesBtn, stockDG04_NoBtn;
    ImageView closeDG04Btn;

    //--DG05 CREATE ITEM--//
    Dialog stockDG05;
    ImageView stockDG05_ItemImg;
    EditText stockDG05_ItemNameInput,
            stockDG05_ItemInitialAmountInput,
            stockDG05_ItemMeasurementInput;
    CardView stockDG05_ConfirmBtn;
    ImageView closeDG05Btn;

    //--DG06 EDIT ITEM--//
    Dialog stockDG06;
    ImageView stockDG06_ItemImg;
    EditText stockDG06_ItemNameInput,
             stockDG06_ItemMeasurementInput;
    CardView stockDG06_ApplyChangesBtn, stockDG06_DeleteBtn;
    ImageView closeDG06Btn;

    //--DG07 VIEW ITEM--//
    Dialog stockDG07;
    ImageView stockDG07_ItemImage;
    CardView stockDG07_EditBtn, stockDG07_UpdateBtn;
    TextView stockDG07_ItemName,
             stockDG07_ItemQty,
             stockDG07_ItemMeasurement;
    ImageView stockDG07_SubBtn,
              stockDG07_AddBtn,
              closeDG07Btn;

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
        String categoryName = bundle.getStockCategory();
        RealmStockCategory query = realm.where(RealmStockCategory.class).equalTo("categoryName", categoryName).findFirst();
        createBtn.setOnClickListener(create -> {
            if(currentFragment.equals("Stock02")){
                load_DG05Functionalities(new DialogBundle(5, new StockItem(query.getCategoryIcon(), query.getCategoryName(),"", 1, ""), bundle));
                stockDG05.show();
            }
        });
    }

    private void load_SearchBar(){
        searchbar.removeTextChangedListener(searchEngine);
        searchbar.setText("");
        searchbar.addTextChangedListener(searchEngine);
    }

    private void load_CategoryRV(){
        //Initialize RecyclerViewItems and State
        displayText.setText("「 CATEGORIES 」");

        //Initialize RecyclerView
        listOfStockCategories = SCHelper.getStockCategories(realm);
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        stockRVA = new M04F06_CategoryRVA(getActivity(), realm, searchbar, listOfStockCategories, this, this);
        stockRV.setAdapter(stockRVA);
        stockRV.setLayoutManager(layout);
    }

    private void load_FilteredCategoryRV(String input){
        List<StockCategory> filteredCategory = SCHelper.getFilteredStockCategories(listOfStockCategories, input);
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
        listOfStockItems = SIHelper.getStockItems(realm, bundle.getStockCategory());
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        stockRVA = new M04F06_ItemRVA(getActivity(), realm, listOfStockItems, this);
        stockRV.setAdapter(stockRVA);
        stockRV.setLayoutManager(layout);

        //Load Create Item Functionality
        load_ItemCreation(bundle);
    }

    private void load_FilteredItemRV(String input){
        List<StockItem> filteredItem = SIHelper.getFilteredStockItems(listOfStockItems, input);
        GridLayoutManager layout = new GridLayoutManager(getActivity(), 2);
        layout.setOrientation(GridLayoutManager.VERTICAL);
        stockRVA = new M04F06_ItemRVA(getActivity(), realm, filteredItem, this);
        stockRV.setAdapter(stockRVA);
        stockRV.setLayoutManager(layout);
    }

    private void init_Dialogs(){
        //--DG01 SELECT ICON--//
        stockDG01 = DialogHelper.create(getActivity(), R.layout.act04_main_frag06_stocks_dg01_selecticon);
        stockDG01_RecyclerView = stockDG01.findViewById(R.id.M04F06D01_IconsRV);
        closeDG01Btn = stockDG01.findViewById(R.id.M04F06D01_CloseDGBtn);

        //--DG02 CREATE CATEGORY--//
        stockDG02 = DialogHelper.create(getActivity(), R.layout.act04_main_frag06_stocks_dg02_createcategory);
        stockDG02_CategoryImg = stockDG02.findViewById(R.id.M04F06D02_CategoryImage);
        stockDG02_SelectIconBtn = stockDG02.findViewById(R.id.M04F06D02_SelectIconBtn);
        stockDG02_CategoryNameInput = stockDG02.findViewById(R.id.M04F06D02_CategoryNameInput);
        stockDG02_ConfirmBtn = stockDG02.findViewById(R.id.M04F06D02_ConfirmBtn);
        closeDG02Btn = stockDG02.findViewById(R.id.M04F06D02_CloseDGBtn);

        //--DG03 EDIT CATEGORY--//
        stockDG03 = DialogHelper.create(getActivity(), R.layout.act04_main_frag06_stocks_dg03_editcategory);
        stockDG03_CategoryImg = stockDG03.findViewById(R.id.M04F06D03_CategoryImage);
        stockDG03_CategoryNameInput = stockDG03.findViewById(R.id.M04F06D03_CategoryNameInput);
        stockDG03_SelectIconBtn = stockDG03.findViewById(R.id.M04F06D03_SelectIconBtn);
        stockDG03_ApplyChangesBtn = stockDG03.findViewById(R.id.M04F06D03_ApplyChangesBtn);
        stockDG03_DeleteBtn = stockDG03.findViewById(R.id.M04F06D03_DeleteBtn);
        closeDG03Btn = stockDG03.findViewById(R.id.M04F06D03_CloseDGBtn);

        //--DG04 DELETE CATEGORY--//
        stockDG04 = DialogHelper.create(getActivity(), R.layout.act04_main_frag06_stocks_dg04_deletecategory);
        stockDG04_CategoryName = stockDG04.findViewById(R.id.M04F06D04_CategoryNameText);
        stockDG04_YesBtn = stockDG04.findViewById(R.id.M04F06D04_YesBtn);
        stockDG04_NoBtn = stockDG04.findViewById(R.id.M04F06D04_NoBtn);
        closeDG04Btn = stockDG04.findViewById(R.id.M04F06D04_CloseDGBtn);

        //--DG05 CREATE ITEM--//
        stockDG05 = DialogHelper.create(getActivity(), R.layout.act04_main_frag06_stocks_dg05_createitem);
        stockDG05_ItemImg = stockDG05.findViewById(R.id.M04F06D05_CategoryImage);
        stockDG05_ItemNameInput = stockDG05.findViewById(R.id.M04F06D05_ItemNameInput);
        stockDG05_ItemMeasurementInput = stockDG05.findViewById(R.id.M04F06D05_ItemMeasurementInput);
        stockDG05_ItemInitialAmountInput = stockDG05.findViewById(R.id.M04F06D05_ItemInitialAmountInput);
        stockDG05_ConfirmBtn = stockDG05.findViewById(R.id.M04F06D05_ConfirmBtn);
        closeDG05Btn = stockDG05.findViewById(R.id.M04F06D05_CloseDGBtn);

        //--DG06 EDIT ITEM--//
        stockDG06 = DialogHelper.create(getActivity(), R.layout.act04_main_frag06_stocks_dg06_edititem);
        stockDG06_ItemImg = stockDG06.findViewById(R.id.M04F06D06_CategoryImage);
        stockDG06_ItemNameInput = stockDG06.findViewById(R.id.M04F06D06_ItemNameInput);
        stockDG06_ItemMeasurementInput = stockDG06.findViewById(R.id.M04F06D06_ItemMeasurementInput);
        stockDG06_ApplyChangesBtn = stockDG06.findViewById(R.id.M04F06D06_ApplyChangesBtn);
        stockDG06_DeleteBtn = stockDG06.findViewById(R.id.M04F06D06_DeleteBtn);
        closeDG06Btn = stockDG06.findViewById(R.id.M04F06D06_CloseDGBtn);

        //--DG07 VIEW ITEM --//
        stockDG07 = DialogHelper.create(getActivity(), R.layout.act04_main_frag06_stocks_dg07_viewitem);
        stockDG07_ItemImage = stockDG07.findViewById(R.id.M04F06D07_ItemImage);
        stockDG07_EditBtn = stockDG07.findViewById(R.id.M04F06D07_EditBtn);
        stockDG07_ItemName = stockDG07.findViewById(R.id.M04F06D07_ItemName);
        stockDG07_ItemQty = stockDG07.findViewById(R.id.M04F06D07_ItemQty);
        stockDG07_ItemMeasurement = stockDG07.findViewById(R.id.M04F06D07_UnitOfMeasurement);
        stockDG07_SubBtn = stockDG07.findViewById(R.id.M04F06D07_QtySubBtn);
        stockDG07_AddBtn = stockDG07.findViewById(R.id.M04F06D07_QtyAddBtn);
        stockDG07_UpdateBtn = stockDG07.findViewById(R.id.M04F06D07_UpdateBtn);
        closeDG07Btn = stockDG07.findViewById(R.id.M04F06D07_CloseDGBtn);


        //--DG08 DELETE ITEM--//
        stockDG08 = DialogHelper.create(getActivity(), R.layout.act04_main_frag06_stocks_dg08_deleteitem);
        stockDG08_ItemName = stockDG08.findViewById(R.id.M04F06D08_ItemNameText);
        stockDG08_YesBtn = stockDG08.findViewById(R.id.M04F06D08_YesBtn);
        stockDG08_NoBtn = stockDG08.findViewById(R.id.M04F06D08_NoBtn);
        closeDG08Btn = stockDG08.findViewById(R.id.M04F06D08_CloseDGBtn);
    }

    //Select Icon
    private void load_DG01Functionalities(DialogBundle bundle){
        //Initialize RecyclerView
        List<Integer> icons = SCHelper.getStockIcons();
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
                load_DG03Functionalites(bundle);
                stockDG01.dismiss();
                stockDG03.show();
            }
        });
    }

    //Create Category
    private void load_DG02Functionalities(DialogBundle bundle){
        //Unpack Bundle
        int image = bundle.getStockCategory().getCategoryImage();
        String name = bundle.getStockCategory().getCategoryName();

        //Set Image and Name;
        IconHelper.setStockIcon(stockDG02_CategoryImg, image);
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
            List<String> listOfCategories = SCHelper.getStockCategoryNames(realm);
            if(listOfCategories.contains(input)){
                stockDG02_CategoryNameInput.setError("Name already exists.");
            } else {
                OpenStocksInstance.toCreateCategory(image, input);
                load_CategoryRV();
                stockDG02.dismiss();
            }
        });

        //On Close Button
        closeDG02Btn.setOnClickListener(close -> {
            stockDG02.dismiss();
        });
    }

    //Edit Category
    private void load_DG03Functionalites(DialogBundle bundle){
        //Unpack Bundle
        int image = bundle.getStockCategory().getCategoryImage();
        String name = bundle.getStockCategory().getCategoryName();

        //Set Image and Name;
        IconHelper.setStockIcon(stockDG03_CategoryImg, image);
        stockDG03_CategoryNameInput.setText(name);
        int focus = stockDG03_CategoryNameInput.getText().toString().length();
        stockDG03_CategoryNameInput.requestFocus();
        stockDG03_CategoryNameInput.setSelection(focus);

        //On Click SelectIconButton
        stockDG03_SelectIconBtn.setOnClickListener(select -> {
            load_DG01Functionalities(bundle);
            stockDG03.dismiss();
            stockDG01.show();
        });

        //On Apply Button
        stockDG03_ApplyChangesBtn.setOnClickListener(apply -> {
            String input = stockDG03_CategoryNameInput.getText().toString();
            List<String> listOfCategories = SCHelper.getStockCategoryNames(realm);
            if(name.equals(input)){
                ToastHelper.show(getActivity(), "No Changes were made");
                stockDG03_CategoryNameInput.setText("");
                stockDG03.dismiss();
            } else if(listOfCategories.contains(input) && !name.equals(input)){
                stockDG03_CategoryNameInput.setError("Name Already Exists");
            } else {
                OpenStocksInstance.toUpdateCategory(name, image, input);
                load_CategoryRV();
                stockDG03.dismiss();
            }
        });

        //On Delete Button
        stockDG03_DeleteBtn.setOnClickListener(delete -> {
            load_DG04Functionalities(bundle);
            stockDG03.dismiss();
            stockDG04.show();
        });

        //On Close Button
        closeDG03Btn.setOnClickListener(close -> {
            stockDG03.dismiss();
        });
    }

    //Delete Category
    private void load_DG04Functionalities(DialogBundle bundle){
        //Unpack Bundle
        String name = bundle.getStockCategory().getCategoryName();

        //Set Category Name
        stockDG04_CategoryName.setText(name);

        //On Yes Btn
        stockDG04_YesBtn.setOnClickListener(delete -> {
            OpenStocksInstance.toDeleteCategory(name);
            load_CategoryRV();
            stockDG04.dismiss();
        });
        //On No Btn
        stockDG04_NoBtn.setOnClickListener(delete -> {
            load_DG03Functionalites(bundle);
            stockDG04.dismiss();
            stockDG03.show();
        });
        //On Close Btn
        closeDG04Btn.setOnClickListener(close -> {
            load_DG03Functionalites(bundle);
            stockDG04.dismiss();
            stockDG03.show();
        });
    }

    //Create Item
    private void load_DG05Functionalities(DialogBundle bundle){
        //Unpack Bundle
        int image = bundle.getStockItem().getItemImage();
        String category = bundle.getStockItem().getItemCategory();

        //Set Image and Name
        IconHelper.setStockIcon(stockDG05_ItemImg, image);
        stockDG05_ItemNameInput.setText("");
        stockDG05_ItemMeasurementInput.setText("");
        stockDG05_ItemInitialAmountInput.setText("");

        //On Confirm Button
        stockDG05_ConfirmBtn.setOnClickListener(create -> {
            String nameInput = stockDG05_ItemNameInput.getText().toString();
            String measurementInput = stockDG05_ItemMeasurementInput.getText().toString();
            int initialAmountInput = Integer.parseInt(stockDG05_ItemInitialAmountInput.getText().toString());
            List<String> listOfItems = SIHelper.getStockItemNames(realm);
            if(listOfItems.contains(nameInput)){
                stockDG05_ItemNameInput.setError("Name already exists.");
            } else {
                OpenStocksInstance.toCreateItem(image, category, nameInput, initialAmountInput, measurementInput);
                List<StockItem> listOfNewItems = SIHelper.getStockItems(realm, category);
                load_ItemRV(new RVBundle(listOfNewItems, category));
                stockDG05.dismiss();
            }
        });

        //On Close
        closeDG05Btn.setOnClickListener(close -> {
            stockDG05.dismiss();
        });
    }

    //Edit Item
    private void load_DG06Functionalities(DialogBundle bundle){
        //Unpack Bundle
        int image = bundle.getStockItem().getItemImage();
        String category = bundle.getStockItem().getItemCategory();
        String name = bundle.getStockItem().getItemName();
        String measurement = bundle.getStockItem().getUnitOfMeasurement();
        RVBundle items = bundle.getRvBundle();

        //Set Image and Name;
        IconHelper.setStockIcon(stockDG06_ItemImg, image);
        stockDG06_ItemNameInput.setText(name);
        stockDG06_ItemMeasurementInput.setText(measurement);

        int focus = stockDG06_ItemNameInput.getText().toString().length();
        stockDG06_ItemNameInput.requestFocus();
        stockDG06_ItemNameInput.setSelection(focus);

        //On Apply Button
        stockDG06_ApplyChangesBtn.setOnClickListener(apply -> {
            String nameInput = stockDG06_ItemNameInput.getText().toString();
            String measurementInput = stockDG06_ItemMeasurementInput.getText().toString();
            List<String> listOfItems = SIHelper.getStockItemNames(realm);
            if(name.equals(nameInput) && measurement.equals(measurementInput)){
                ToastHelper.show(getActivity(), "No changes were made");
                stockDG06.dismiss();
            } else if(name.equals(nameInput) && !measurement.equals(measurementInput)){
                OpenStocksInstance.toUpdateItem(name, image, category, nameInput, measurementInput);
                List<StockItem> listOfNewItems = SIHelper.getStockItems(realm, category);
                load_ItemRV(new RVBundle(listOfNewItems, category));
                stockDG06.dismiss();
            } else if(listOfItems.contains(nameInput)){
                stockDG06_ItemNameInput.setError("Name already exists");
            } else {
                OpenStocksInstance.toUpdateItem(name, image, category, nameInput, measurementInput);
                List<StockItem> listOfNewItems = SIHelper.getStockItems(realm, category);
                load_ItemRV(new RVBundle(listOfNewItems, category));
                stockDG06.dismiss();
            }
        });

        //On Delete Button
        stockDG06_DeleteBtn.setOnClickListener(delete -> {
            load_DG08Functionalities(bundle);
            stockDG06.dismiss();
            stockDG08.show();
        });

        //On Close
        closeDG06Btn.setOnClickListener(close -> {
            stockDG06.dismiss();
        });
    }

    //View Item
    private void load_DG07Functionalities(DialogBundle bundle){
        //Unpack Bundle
        int image = bundle.getStockItem().getItemImage();
        String category = bundle.getStockItem().getItemCategory();
        String name = bundle.getStockItem().getItemName();
        int amount = bundle.getStockItem().getItemAmount();
        String measurement = bundle.getStockItem().getUnitOfMeasurement();
        RVBundle items = bundle.getRvBundle();

        //Load Item Details
        IconHelper.setStockIcon(stockDG07_ItemImage, image);
        stockDG07_ItemName.setText(name);
        stockDG07_ItemQty.setText(String.valueOf(amount));
        stockDG07_ItemMeasurement.setText(measurement);

        //On Edit Button
        stockDG07_EditBtn.setOnClickListener(edit -> {
            load_DG06Functionalities(bundle);
            stockDG07.dismiss();
            stockDG06.show();
        });

        //On Add and Sub Button
        stockDG07_SubBtn.setOnClickListener(sub -> {
            int counter = Integer.parseInt(stockDG07_ItemQty.getText().toString());
            if(counter != 1){
                counter--;
                stockDG07_ItemQty.setText(String.valueOf(counter));
            }
        });

        stockDG07_AddBtn.setOnClickListener(add -> {
            int counter = Integer.parseInt(stockDG07_ItemQty.getText().toString());
            if(counter < 99){
                counter++;
                stockDG07_ItemQty.setText(String.valueOf(counter));
            }
        });

        //On Update Button
        stockDG07_UpdateBtn.setOnClickListener(update -> {
            int newAmount = Integer.parseInt(stockDG07_ItemQty.getText().toString());
            if(newAmount != amount){
                OpenTransactionsInstance.toCreateInventoryTransaction(name, amount, newAmount, measurement);
                OpenStocksInstance.toUpdateAmount(category, name, newAmount);
                List<StockItem> listOfNewItems = SIHelper.getStockItems(realm, category);
                load_ItemRV(new RVBundle(listOfNewItems, category));
                stockDG07.dismiss();
            }
        });
        //On Close Button
        closeDG07Btn.setOnClickListener(close -> {
            stockDG07.dismiss();
        });
    }

    //Delete Item
    private void load_DG08Functionalities(DialogBundle bundle){
        //Unpack Bundle
        String category = bundle.getStockItem().getItemCategory();
        String name = bundle.getStockItem().getItemName();
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
            stockDG08.dismiss();
        });

        //On Close Btn
        closeDG08Btn.setOnClickListener(close -> {
            stockDG08.dismiss();
        });
    }

    protected TextWatcher searchEngine = new TextWatcher() {
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
    };

    @Override
    public void load_RVContents(RVBundle bundle) {
        load_SearchBar();
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
            case 3:
                load_DG03Functionalites(bundle);
                stockDG03.show();
                break;
            case 7:
                load_DG07Functionalities(bundle);
                stockDG07.show();
                break;
        }
    }
}
