package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Menu;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.Instances.OpenMenuInstance;
import com.wabizabi.wazabipos.Database.ObjectSchemas.MenuCategory;
import com.wabizabi.wazabipos.Database.ObjectSchemas.MenuItem;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuCategory;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Menu.Adapters.M04F02D01_SelectIconRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Menu.Adapters.M04F02D07_CombinationRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Menu.Adapters.M04F02_CategoryRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Menu.Adapters.M04F02_ItemRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Menu.Helpers.MCHelper;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Menu.Helpers.MIHelper;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Interfaces.DialogLoader;
import com.wabizabi.wazabipos.Utilities.Interfaces.RVLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.Bundles.DialogBundle;
import com.wabizabi.wazabipos.Utilities.Libraries.Bundles.RVBundle;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.DialogHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.IconHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.StringHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.ToastHelper;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class M04F02_Menu extends Fragment implements RVLoader, DialogLoader {
    //--DATABASE--//
    Realm realm = Realm.getDefaultInstance();

    //--CREATE BUTTON--//
    ImageView createBtn;

    //--SEARCH BAR--//
    EditText searchbar;

    //--RECYCLERVIEW--//
    TextView displayText;
    RecyclerView menuRV;
    RecyclerView.Adapter menuRVA;
    List<MenuCategory> listOfMenuCategories;
    List<MenuItem> listOfMenuItems;

    //--Dialogs--//

    //--DG05 CREATE ITEM--//
    Dialog menuDG05;
    ImageView menuDG05_ItemImg;
    EditText menuDG05_ItemWebNameInput,
             menuDG05_ItemPOSNameInput,
             menuDG05_ItemPriceInput;
    CardView menuDG05_ConfirmBtn;
    ImageView closeDG05Btn;

    //--DG06 EDIT ITEM--//
    Dialog menuDG06;
    ImageView menuDG06_ItemImg;
    EditText menuDG06_ItemWebNameInput,
             menuDG06_ItemPOSNameInput,
             menuDG06_ItemPriceInput;
    CardView menuDG06_ApplyChangesBtn, menuDG06_DeleteBtn;
    ImageView closeDG06Btn;

    //--DG07 VIEW ITEM--//
    Dialog menuDG07;
    ImageView menuDG07_ItemImage;
    CardView menuDG07_EditBtn;
    TextView menuDG07_ItemWebName,
             menuDG07_ItemPOSName,
             menuDG07_ItemPrice;
    RecyclerView menuDG07_RecyclerView;
    RecyclerView.Adapter menuDG07_RecyclerViewAdapter;
    ImageView closeDG07Btn;

    //--DG08 DELETE ITEM--//
    Dialog menuDG08;
    TextView menuDG08_ItemName;
    CardView menuDG08_YesBtn, menuDG08_NoBtn;
    ImageView closeDG08Btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag02_menu, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        createBtn = v.findViewById(R.id.M04F02_CreateBtn);
        searchbar = v.findViewById(R.id.M04F02_SearchBarInput);
        displayText = v.findViewById(R.id.M04F02_RecyclerViewItemText);
        menuRV = v.findViewById(R.id.M04F02_RecyclerView);

        load_CategoryCreation();
        load_CategoryRV();
        load_SearchBar();
        init_Dialogs();
    }

    private void load_CategoryCreation(){
        createBtn.setVisibility(View.INVISIBLE);
    }

    private void load_ItemCreation(RVBundle bundle){
        createBtn.setVisibility(View.VISIBLE);
        int categoryIcon = bundle.getMenuIcon();
        String categoryName = bundle.getMenuCategory();
        createBtn.setOnClickListener(create -> {
            if(currentFragment.equals("Menu02")){
                load_DG05Functionalities(new DialogBundle(5, new MenuItem(categoryIcon, categoryName, "", "", 0.00), bundle));
                menuDG05.show();
            }
        });
    }

    private void load_SearchBar(){
        searchbar.setText("");
        searchbar.addTextChangedListener(searchEngine);
    }

    private void load_CategoryRV(){
        //Initialize RecyclerViewItems and State
        displayText.setText("「 CATEGORIES 」");

        //Initialize RecyclerView
        listOfMenuCategories = new ArrayList<>();
        if(listOfMenuCategories.size() < 1){
            listOfMenuCategories.add(new MenuCategory(1 ,"Deep fried"));
            listOfMenuCategories.add(new MenuCategory(2 ,"Dessert"));
            listOfMenuCategories.add(new MenuCategory(3 ,"Donburi"));
            listOfMenuCategories.add(new MenuCategory(4 ,"Drinks"));
            listOfMenuCategories.add(new MenuCategory(6 ,"Noodles"));
            listOfMenuCategories.add(new MenuCategory(7 ,"Salads"));
            listOfMenuCategories.add(new MenuCategory(5 ,"Sashimi and Nigiri"));
            listOfMenuCategories.add(new MenuCategory(9 ,"Sushi Platter"));
            listOfMenuCategories.add(new MenuCategory(10 ,"Sushi Roll"));
            listOfMenuCategories.add(new MenuCategory(0 ,"Others"));
        }
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        menuRVA = new M04F02_CategoryRVA(getActivity(), realm, searchbar, listOfMenuCategories, this, this);
        menuRV.setAdapter(menuRVA);
        menuRV.setLayoutManager(layout);
    }

    private void load_FilteredCategoryRV(String input){
        //Initialize RecyclerView
        List<MenuCategory> filteredCategory = MCHelper.getFilteredMenuCategories(listOfMenuCategories, input);
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        menuRVA = new M04F02_CategoryRVA(getActivity(), realm, searchbar, filteredCategory, this, this);
        menuRV.setAdapter(menuRVA);
        menuRV.setLayoutManager(layout);
    }

    private void load_ItemRV(RVBundle bundle){
        //Initialize RV Text
        displayText.setText("「 " + bundle.getMenuCategory().toUpperCase() + " 」");

        //Initialize RecyclerView
        listOfMenuItems = bundle.getListOfMenuItems();
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        menuRVA = new M04F02_ItemRVA(getActivity(), realm, listOfMenuItems, this);
        menuRV.setAdapter(menuRVA);
        menuRV.setLayoutManager(layout);

        //Load Create Item Functionality
        load_ItemCreation(bundle);
    }

    private void load_FilteredItemRV(String input){
        //Initialize RecyclerView
        List<MenuItem> filteredItem = MIHelper.getFilteredMenuItems(listOfMenuItems, input);
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        menuRVA = new M04F02_ItemRVA(getActivity(), realm, filteredItem, this);
        menuRV.setAdapter(menuRVA);
        menuRV.setLayoutManager(layout);
    }

    private void init_Dialogs(){
        //--DG05 CREATE ITEM--//
        menuDG05 = DialogHelper.create(getActivity(), R.layout.act04_main_frag02_menu_dg05_createitem);
        menuDG05_ItemImg = menuDG05.findViewById(R.id.M04F02D05_CategoryImage);
        menuDG05_ItemWebNameInput = menuDG05.findViewById(R.id.M04F02D05_ItemWebNameInput);
        menuDG05_ItemPOSNameInput = menuDG05.findViewById(R.id.M04F02D05_ItemPOSNameInput);
        menuDG05_ItemPriceInput = menuDG05.findViewById(R.id.M04F02D05_ItemPriceInput);
        menuDG05_ConfirmBtn = menuDG05.findViewById(R.id.M04F02D05_ConfirmBtn);
        closeDG05Btn = menuDG05.findViewById(R.id.M04F02D05_CloseDGBtn);

        //--DG06 EDIT ITEM--//
        menuDG06 = DialogHelper.create(getActivity(), R.layout.act04_main_frag02_menu_dg06_edititem);
        menuDG06_ItemImg = menuDG06.findViewById(R.id.M04F02D06_CategoryImage);
        menuDG06_ItemWebNameInput = menuDG06.findViewById(R.id.M04F02D06_ItemWebNameInput);
        menuDG06_ItemPOSNameInput = menuDG06.findViewById(R.id.M04F02D06_ItemPOSNameInput);
        menuDG06_ItemPriceInput = menuDG06.findViewById(R.id.M04F02D06_ItemPriceInput);
        menuDG06_ApplyChangesBtn = menuDG06.findViewById(R.id.M04F02D06_ApplyChangesBtn);
        menuDG06_DeleteBtn = menuDG06.findViewById(R.id.M04F02D06_DeleteBtn);
        closeDG06Btn = menuDG06.findViewById(R.id.M04F02D06_CloseDGBtn);

        //--DG07 VIEW ITEM --//
        menuDG07 = DialogHelper.create(getActivity(), R.layout.act04_main_frag02_menu_dg07_viewitem);
        menuDG07_ItemImage = menuDG07.findViewById(R.id.M04F02D07_ItemImage);
        menuDG07_EditBtn = menuDG07.findViewById(R.id.M04F02D07_EditBtn);
        menuDG07_ItemPOSName = menuDG07.findViewById(R.id.M04F02D07_ItemName);
        menuDG07_ItemPrice = menuDG07.findViewById(R.id.M04F02D07_ItemPrice);
        menuDG07_RecyclerView = menuDG07.findViewById(R.id.M04F02D07_FPGRV);
        closeDG07Btn = menuDG07.findViewById(R.id.M04F02D07_CloseDGBtn);

        //--DG08 DELETE ITEM--//
        menuDG08 = DialogHelper.create(getActivity(), R.layout.act04_main_frag02_menu_dg08_deleteitem);
        menuDG08_ItemName = menuDG08.findViewById(R.id.M04F02D08_ItemNameText);
        menuDG08_YesBtn = menuDG08.findViewById(R.id.M04F02D08_YesBtn);
        menuDG08_NoBtn = menuDG08.findViewById(R.id.M04F02D08_NoBtn);
        closeDG08Btn = menuDG08.findViewById(R.id.M04F02D08_CloseDGBtn);
    }

    //Create Item
    private void load_DG05Functionalities(DialogBundle bundle){
        //Unpack Bundle
        int image = bundle.getMenuItem().getItemIcon();
        String category = bundle.getMenuItem().getItemCategory();

        //Set Image and Name
        IconHelper.setMenuIcon(menuDG05_ItemImg, image);
        menuDG05_ItemWebNameInput.setText("");
        menuDG05_ItemPOSNameInput.setText("");
        menuDG05_ItemPriceInput.setText("");

        int focus = menuDG05_ItemWebNameInput.getText().toString().length();
        menuDG05_ItemWebNameInput.requestFocus();
        menuDG05_ItemWebNameInput.setSelection(focus);

        //On Confirm Button
        menuDG05_ConfirmBtn.setOnClickListener(create -> {
            String nameWebInput = menuDG05_ItemWebNameInput.getText().toString();
            String namePOSInput = menuDG05_ItemPOSNameInput.getText().toString();
            String priceInput = menuDG05_ItemPriceInput.getText().toString();
            List<String> listOfWebItems = MIHelper.getMenuWebItemNames(realm);
            List<String> listOfPOSItems = MIHelper.getMenuPOSItemNames(realm);
            if(listOfWebItems.contains(nameWebInput)){
                menuDG05_ItemWebNameInput.setError("Name already exists.");
            } else if(listOfPOSItems.contains(namePOSInput)){
                menuDG05_ItemPOSNameInput.setError("Name already exists.");
            } else if(nameWebInput.equals("")) {
                menuDG05_ItemWebNameInput.setError("Please input name");
            } else if(namePOSInput.equals("")) {
                menuDG05_ItemPOSNameInput.setError("Please input name");
            } else if(priceInput.equals("")) {
                menuDG05_ItemPriceInput.setError("Please input price");
            } else {
                OpenMenuInstance.toCreateItem(image, category, nameWebInput, namePOSInput, Double.parseDouble(priceInput));
                List<MenuItem> listOfItems = MIHelper.getMenuItems(realm, category);
                load_ItemRV(new RVBundle(image, category, listOfItems));
                menuDG05.dismiss();
            }
        });

        //On Close
        closeDG05Btn.setOnClickListener(close -> {
            menuDG05.dismiss();
        });
    }

    //Edit Item
    private void load_DG06Functionalities(DialogBundle bundle){
        //Unpack Bundle
        int image = bundle.getMenuItem().getItemIcon();
        String category = bundle.getMenuItem().getItemCategory();
        String webName = bundle.getMenuItem().getItemWebName();
        String posName = bundle.getMenuItem().getItemPOSName();
        String price = String.valueOf(bundle.getMenuItem().getItemPrice());

        //Set Image and Name;
        IconHelper.setMenuIcon(menuDG06_ItemImg, image);
        menuDG06_ItemWebNameInput.setText(webName);
        menuDG06_ItemPOSNameInput.setText(posName);
        menuDG06_ItemPriceInput.setText(price);

        int focus = menuDG06_ItemWebNameInput.getText().toString().length();
        menuDG06_ItemWebNameInput.requestFocus();
        menuDG06_ItemWebNameInput.setSelection(focus);

        //On Apply Button
        menuDG06_ApplyChangesBtn.setOnClickListener(apply -> {
            String webNameInput = menuDG06_ItemWebNameInput.getText().toString();
            String posNameInput = menuDG06_ItemPOSNameInput.getText().toString();
            String priceInput = menuDG06_ItemPriceInput.getText().toString();
            List<String> listOfWebItems = MIHelper.getMenuWebItemNames(realm);
            List<String> listOfPOSItems = MIHelper.getMenuPOSItemNames(realm);
            if(webName.equals(webNameInput) && posName.equals(posNameInput) && price.equals(priceInput)){
                ToastHelper.show(getActivity(), "No changes were made");
                menuDG06.dismiss();
            } else if(webName.equals(webNameInput) && posName.equals(posNameInput) && !price.equals(priceInput)){
                OpenMenuInstance.toUpdateItem(posName, image, category, webNameInput, posNameInput, Double.parseDouble(priceInput));
                List<MenuItem> listOfItems = MIHelper.getMenuItems(realm, category);
                load_ItemRV(new RVBundle(image, category, listOfItems));
                menuDG06.dismiss();
            } else if(webName.equals(webNameInput) && !posName.equals(posNameInput) && price.equals(priceInput)){
                OpenMenuInstance.toUpdateItem(posName, image, category, webNameInput, posNameInput, Double.parseDouble(priceInput));
                List<MenuItem> listOfItems = MIHelper.getMenuItems(realm, category);
                load_ItemRV(new RVBundle(image, category, listOfItems));
                menuDG06.dismiss();
            } else if(!webName.equals(webNameInput) && posName.equals(posNameInput) && price.equals(priceInput)){
                OpenMenuInstance.toUpdateItem(posName, image, category, webNameInput, posNameInput, Double.parseDouble(priceInput));
                List<MenuItem> listOfItems = MIHelper.getMenuItems(realm, category);
                load_ItemRV(new RVBundle(image, category, listOfItems));
                menuDG06.dismiss();
            } else if(!webName.equals(webNameInput) && posName.equals(posNameInput) && !price.equals(priceInput)){
                OpenMenuInstance.toUpdateItem(posName, image, category, webNameInput, posNameInput, Double.parseDouble(priceInput));
                List<MenuItem> listOfItems = MIHelper.getMenuItems(realm, category);
                load_ItemRV(new RVBundle(image, category, listOfItems));
                menuDG06.dismiss();
            } else if(listOfWebItems.contains(webNameInput)){
                menuDG06_ItemWebNameInput.setError("Name already exists");
            } else if(listOfPOSItems.contains(posNameInput)){
                menuDG06_ItemPOSNameInput.setError("Name already exists");
            } else {
                OpenMenuInstance.toUpdateItem(posName, image, category, posNameInput, posNameInput, Double.parseDouble(priceInput));
                List<MenuItem> listOfItems = MIHelper.getMenuItems(realm, category);
                load_ItemRV(new RVBundle(image, category, listOfItems));
                menuDG06.dismiss();
            }
        });

        //On Delete Button
        menuDG06_DeleteBtn.setOnClickListener(delete -> {
            load_DG08Functionalities(bundle);
            menuDG06.dismiss();
            menuDG08.show();
        });

        //On Close
        closeDG06Btn.setOnClickListener(close -> {
            load_DG07Functionalities(bundle);
            menuDG06.dismiss();
            menuDG07.show();
        });
    }

    //View Item
    private void load_DG07Functionalities(DialogBundle bundle){
        //Unpack Bundle
        int image = bundle.getMenuItem().getItemIcon();
        String posName = bundle.getMenuItem().getItemWebName();
        String price = StringHelper.convertToCurrency(bundle.getMenuItem().getItemPrice());

        //Load Item Details
        IconHelper.setMenuIcon(menuDG07_ItemImage, image);
        menuDG07_ItemPOSName.setText(posName);
        menuDG07_ItemPrice.setText(price);

        //On Edit Button
        menuDG07_EditBtn.setOnClickListener(edit -> {
            load_DG06Functionalities(bundle);
            menuDG07.dismiss();
            menuDG06.show();
        });

        //Initialize RecyclerView
        List<List<String>> listOfCombinations = MIHelper.getPopularCombinations(posName);
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        menuDG07_RecyclerViewAdapter = new M04F02D07_CombinationRVA(listOfCombinations);
        menuDG07_RecyclerView.setAdapter(menuDG07_RecyclerViewAdapter);
        menuDG07_RecyclerView.setLayoutManager(layout);

        //On Close Button
        closeDG07Btn.setOnClickListener(close -> {
            menuDG07.dismiss();
        });
    }

    //Delete Item
    private void load_DG08Functionalities(DialogBundle bundle){
        //Unpack Bundle
        String category = bundle.getMenuItem().getItemCategory();
        String name = bundle.getMenuItem().getItemPOSName();

        //Set Item Name
        menuDG08_ItemName.setText(name);
        //On Yes Btn
        menuDG08_YesBtn.setOnClickListener(delete -> {
            OpenMenuInstance.toDeleteItem(category, name);
            List<MenuItem> listOfItems = MIHelper.getMenuItems(realm, category);
            load_ItemRV(new RVBundle(category, listOfItems));
            menuDG08.dismiss();
        });

        //On No Btn
        menuDG08_NoBtn.setOnClickListener(delete -> {
            menuDG08.dismiss();
        });

        //On Close Btn
        closeDG08Btn.setOnClickListener(close -> {
            menuDG08.dismiss();
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
            if(currentFragment.equals("Menu01")){
                load_FilteredCategoryRV(input.toString());
            } else {
                load_FilteredItemRV(input.toString());
            }
        }
    };

    @Override
    public void load_RVContents(RVBundle bundle) {
        searchbar.removeTextChangedListener(searchEngine);
        load_SearchBar();
        load_ItemRV(bundle);
    }

    @Override
    public void load_DGContents(DialogBundle bundle) {
        int dialogNo = bundle.getDialogDestinationNo();
        switch(dialogNo){
            case 7:
                load_DG07Functionalities(bundle);
                menuDG07.show();
                break;
        }
    }
}