package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Menu;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.M04_Main.currentFragment;
import static com.wabizabi.wazabipos.Utilities.BackgroundThreads.W01_Algorithm.fpList;

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

import com.wabizabi.wazabipos.Database.Instances.OpenMenuInstance;
import com.wabizabi.wazabipos.Database.ObjectSchemas.MenuCategory;
import com.wabizabi.wazabipos.Database.ObjectSchemas.MenuItem;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuCategory;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuItem;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Menu.Adapters.M04F02D01_SelectIconRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Menu.Adapters.M04F02D06_CombinationRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Menu.Adapters.M04F02_CategoryRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Menu.Adapters.M04F02_ItemRVA;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Interfaces.DialogLoader;
import com.wabizabi.wazabipos.Utilities.Interfaces.RVMenuLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.DialogBuilder;
import com.wabizabi.wazabipos.Utilities.Libraries.IconLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.ListBuilder;
import com.wabizabi.wazabipos.Utilities.Libraries.ToastMessage;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmResults;

public class M04F02_Menu extends Fragment implements RVMenuLoader, DialogLoader {
    //--DATABASE--//
    Realm realm = Realm.getDefaultInstance();

    //--CREATE BUTTON--//
    ImageView createBtn;

    //--SEARCH BAR--//
    EditText searchbar;

    //--RECYCLERVIEW--//
    public static String currentMenuRV = "Categories";
    TextView displayText;
    RecyclerView menuRV;
    RecyclerView.Adapter menuRVA;
    List<MenuCategory> listOfMenuCategories;
    List<MenuItem> listOfMenuItems;

    //--Dialogs--//
    //--DG01 SELECT ICON--//
    Dialog menuDG01;
    RecyclerView menuDG01_RecyclerView;
    RecyclerView.Adapter menuDG01_RecyclerViewAdapter;
    ImageView closeDG01Btn;

    //--DG02 CREATE CATEGORY--//
    Dialog menuDG02;
    ImageView menuDG02_CategoryImg;
    CardView menuDG02_SelectIconBtn;
    EditText menuDG02_CategoryNameInput;
    CardView menuDG02_ConfirmBtn;
    ImageView closeDG02Btn;

    //--DG03 CREATE ITEM--//
    Dialog menuDG03;
    ImageView menuDG03_ItemImg;
    EditText menuDG03_ItemNameInput,
             menuDG03_ItemPriceInput;
    CardView menuDG03_ConfirmBtn;
    ImageView closeDG03Btn;

    //--DG04 EDIT CATEGORY--//
    Dialog menuDG04;
    ImageView menuDG04_CategoryImg;
    CardView menuDG04_SelectIconBtn;
    EditText menuDG04_CategoryNameInput;
    CardView menuDG04_ApplyChangesBtn, menuDG04_DeleteBtn;
    ImageView closeDG04Btn;

    //--DG05 EDIT ITEM--//
    Dialog menuDG05;
    ImageView menuDG05_ItemImg;
    EditText menuDG05_ItemNameInput,
             menuDG05_ItemPriceInput;
    CardView menuDG05_ApplyChangesBtn, menuDG05_DeleteBtn;
    ImageView closeDG05Btn;

    //--DG06 VIEW ITEM--//
    Dialog menuDG06;
    ImageView menuDG06_ItemImage;
    CardView menuDG06_EditBtn;
    TextView menuDG06_ItemName,
             menuDG06_ItemPrice;
    RecyclerView menuDG06_RecyclerView;
    RecyclerView.Adapter menuDG06_RecyclerViewAdapter;
    ImageView closeDG06Btn;

    //--DG07 DELETE CATEGORY--//
    Dialog menuDG07;
    TextView menuDG07_CategoryName;
    CardView menuDG07_YesBtn, menuDG07_NoBtn;
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

        load_Creation();
        load_CategoryRV();
        load_SearchBar();
        init_Dialogs();
    }

    private void load_Creation(){
        createBtn.setOnClickListener(create -> {
            if(currentFragment.equals("Menu01")){
                load_DG02Functionalities(0, "");
                menuDG02.show();
            } else {
                RealmMenuCategory icon = realm.where(RealmMenuCategory.class).equalTo("categoryName", currentMenuRV).findFirst();
                load_DG03Functionalities(icon.getCategoryImage(), currentMenuRV);
                menuDG03.show();
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
                if(currentFragment.equals("Menu01")){
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

        //Initialize RecyclerViewItems
        listOfMenuCategories = new ArrayList<>();
        RealmResults<RealmMenuCategory> queriedCategories = realm.where(RealmMenuCategory.class).sort("categoryName").findAll();
        for(RealmMenuCategory query : queriedCategories){
            listOfMenuCategories.add(new MenuCategory(query.getCategoryImage(), query.getCategoryName(), query.getLastUpdatedID(), query.getLastUpdatedText()));
        }

        //Initialize RecyclerView
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        menuRVA = new M04F02_CategoryRVA(getActivity(), realm, searchbar, listOfMenuCategories, this, this);
        menuRV.setAdapter(menuRVA);
        menuRV.setLayoutManager(layout);
    }

    private void load_FilteredCategoryRV(String input){
        List<MenuCategory> filteredCategory = new ArrayList<>();
        for(MenuCategory category : listOfMenuCategories){
            if(category.getCategoryName().toLowerCase().contains(input.toLowerCase())){
                filteredCategory.add(category);
            }
        }
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        menuRVA = new M04F02_CategoryRVA(getActivity(), realm, searchbar, filteredCategory, this, this);
        menuRV.setAdapter(menuRVA);
        menuRV.setLayoutManager(layout);
    }

    private void load_ItemRV(String category){
        //Initialize RecyclerViewItems and State
        displayText.setText("「 " + category.toUpperCase() + " 」");

        //Initialize RecyclerViewItems
        listOfMenuItems = new ArrayList<>();
        RealmResults<RealmMenuItem> queriedItems = realm.where(RealmMenuItem.class).equalTo("itemCategory", category).sort("itemName").findAll();
        for(RealmMenuItem query : queriedItems){
            listOfMenuItems.add(new MenuItem(query.getItemImage(), query.getItemName(), query.getItemPrice()));
        }

        //Initialize RecyclerView
        GridLayoutManager layout = new GridLayoutManager(getActivity(), 2);
        layout.setOrientation(GridLayoutManager.VERTICAL);
        menuRVA = new M04F02_ItemRVA(getActivity(), realm, listOfMenuItems, this);
        menuRV.setAdapter(menuRVA);
        menuRV.setLayoutManager(layout);
    }

    private void load_FilteredItemRV(String input){
        List<MenuItem> filteredItem = new ArrayList<>();
        for(MenuItem item : listOfMenuItems){
            if(item.getItemName().toLowerCase().contains(input.toLowerCase())){
                filteredItem.add(item);
            }
        }
        GridLayoutManager layout = new GridLayoutManager(getActivity(), 2);
        layout.setOrientation(GridLayoutManager.VERTICAL);
        menuRVA = new M04F02_ItemRVA(getActivity(), realm, filteredItem, this);
        menuRV.setAdapter(menuRVA);
        menuRV.setLayoutManager(layout);
    }

    private void init_Dialogs(){
        //--DG01 SELECT ICON--//
        menuDG01 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag02_menu_dg01_selecticon);
        menuDG01_RecyclerView = menuDG01.findViewById(R.id.M04F02D01_IconsRV);
        closeDG01Btn = menuDG01.findViewById(R.id.M04F02D01_CloseDGBtn);

        //--DG02 CREATE CATEGORY--//
        menuDG02 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag02_menu_dg02_createcategory);
        menuDG02_CategoryImg = menuDG02.findViewById(R.id.M04F02D02_CategoryImage);
        menuDG02_SelectIconBtn = menuDG02.findViewById(R.id.M04F02D02_SelectIconBtn);
        menuDG02_CategoryNameInput = menuDG02.findViewById(R.id.M04F02D02_CategoryNameInput);
        menuDG02_ConfirmBtn = menuDG02.findViewById(R.id.M04F02D02_ConfirmBtn);
        closeDG02Btn = menuDG02.findViewById(R.id.M04F02D02_CloseDGBtn);

        //--DG03 CREATE ITEM--//
        menuDG03 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag02_menu_dg03_createitem);
        menuDG03_ItemImg = menuDG03.findViewById(R.id.M04F02D03_CategoryImage);
        menuDG03_ItemNameInput= menuDG03.findViewById(R.id.M04F02D03_ItemNameInput);
        menuDG03_ItemPriceInput = menuDG03.findViewById(R.id.M04F02D03_ItemPriceInput);
        menuDG03_ConfirmBtn = menuDG03.findViewById(R.id.M04F02D03_ConfirmBtn);
        closeDG03Btn = menuDG03.findViewById(R.id.M04F02D03_CloseDGBtn);

        //--DG04 EDIT CATEGORY--//
        menuDG04 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag02_menu_dg04_editcategory);
        menuDG04_CategoryImg = menuDG04.findViewById(R.id.M04F02D04_CategoryImage);
        menuDG04_CategoryNameInput = menuDG04.findViewById(R.id.M04F02D04_CategoryNameInput);
        menuDG04_SelectIconBtn = menuDG04.findViewById(R.id.M04F02D04_SelectIconBtn);
        menuDG04_ApplyChangesBtn = menuDG04.findViewById(R.id.M04F02D04_ApplyChangesBtn);
        menuDG04_DeleteBtn = menuDG04.findViewById(R.id.M04F02D04_DeleteBtn);
        closeDG04Btn = menuDG04.findViewById(R.id.M04F02D04_CloseDGBtn);

        //--DG05 EDIT ITEM--//
        menuDG05 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag02_menu_dg05_edititem);
        menuDG05_ItemImg = menuDG05.findViewById(R.id.M04F02D05_CategoryImage);
        menuDG05_ItemNameInput = menuDG05.findViewById(R.id.M04F02D05_ItemNameInput);
        menuDG05_ItemPriceInput = menuDG05.findViewById(R.id.M04F02D05_ItemPriceInput);
        menuDG05_ApplyChangesBtn = menuDG05.findViewById(R.id.M04F02D05_ApplyChangesBtn);
        menuDG05_DeleteBtn = menuDG05.findViewById(R.id.M04F02D05_DeleteBtn);
        closeDG05Btn = menuDG05.findViewById(R.id.M04F02D05_CloseDGBtn);

        //--DG06 VIEW ITEM --//
        menuDG06 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag02_menu_dg06_viewitem);
        menuDG06_ItemImage = menuDG06.findViewById(R.id.M04F02D06_ItemImage);
        menuDG06_EditBtn = menuDG06.findViewById(R.id.M04F02D06_EditBtn);
        menuDG06_ItemName = menuDG06.findViewById(R.id.M04F02D06_ItemName);
        menuDG06_ItemPrice = menuDG06.findViewById(R.id.M04F02D06_ItemPrice);
        menuDG06_RecyclerView = menuDG06.findViewById(R.id.M04F02D06_FPGRV);
        closeDG06Btn = menuDG06.findViewById(R.id.M04F02D06_CloseDGBtn);

        //--DG07 DELETE CATEGORY--//
        menuDG07 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag02_menu_dg07_deletecategory);
        menuDG07_CategoryName = menuDG07.findViewById(R.id.M04F02D07_CategoryNameText);
        menuDG07_YesBtn = menuDG07.findViewById(R.id.M04F02D07_YesBtn);
        menuDG07_NoBtn = menuDG07.findViewById(R.id.M04F02D07_NoBtn);
        closeDG07Btn = menuDG07.findViewById(R.id.M04F02D07_CloseDGBtn);

        //--DG08 DELETE ITEM--//
        menuDG08 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag02_menu_dg08_deleteitem);
        menuDG08_ItemName = menuDG08.findViewById(R.id.M04F02D08_ItemNameText);
        menuDG08_YesBtn = menuDG08.findViewById(R.id.M04F02D08_YesBtn);
        menuDG08_NoBtn = menuDG08.findViewById(R.id.M04F02D08_NoBtn);
        closeDG08Btn = menuDG08.findViewById(R.id.M04F02D08_CloseDGBtn);

    }

    //Select Icon
    private void load_DG01Functionalities(int image, String operation, String name){
        //Initialize ReyclerView Items
        List<Integer> icons = new ArrayList<>();
        int counter = 0;
        while (counter != 9){
            icons.add(counter);
            counter++;
        }

        //Initialize RecyclerView
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        menuDG01_RecyclerViewAdapter = new M04F02D01_SelectIconRVA(getActivity(), realm, operation, name, menuDG01, icons, this);
        menuDG01_RecyclerView.setAdapter(menuDG01_RecyclerViewAdapter);
        menuDG01_RecyclerView.setLayoutManager(layout);

        //On Close Button
        closeDG01Btn.setOnClickListener(close->{
            if(operation.equals("Create Category")){
                load_DG02Functionalities(image, name);
                menuDG01.dismiss();
                menuDG02.show();
            } else if(operation.equals("Edit Category")){
                load_DG04Functionalites(image, name);
                menuDG01.dismiss();
                menuDG04.show();
            }
        });
    }

    //Create Category
    private void load_DG02Functionalities(int image, String name){
        //Set Image and Name;
        IconLoader.setMenuIcon(menuDG02_CategoryImg, image);
        menuDG02_CategoryNameInput.setText(name);

        //On Click SelectIconButton
        menuDG02_SelectIconBtn.setOnClickListener(select -> {
            load_DG01Functionalities(image,"Create Category", menuDG02_CategoryNameInput.getText().toString());
            menuDG02.dismiss();
            menuDG01.show();
        });

        //On Confirm Button
        menuDG02_ConfirmBtn.setOnClickListener(create -> {
            //Extract String from Edit Text
            String input = menuDG02_CategoryNameInput.getText().toString();

            //Check String
            List<String> listOfCategories = ListBuilder.getMenuCategoryNames(realm);
            if(listOfCategories.contains(input)){
                menuDG02_CategoryNameInput.setError("Name already exists.");
            } else {
                OpenMenuInstance.toCreateCategory(image, input);
                load_CategoryRV();
                menuDG02_CategoryNameInput.setText("");
                menuDG02.dismiss();
            }
        });

        //On Close Button
        closeDG02Btn.setOnClickListener(close -> {
            menuDG02.dismiss();
        });
    }

    //Create Item
    private void load_DG03Functionalities(int image, String category){
        //Set Image and Name
        IconLoader.setMenuIcon(menuDG03_ItemImg, image);
        menuDG03_ItemNameInput.setText("");
        menuDG03_ItemPriceInput.setText("");

        //On Confirm Button
        menuDG03_ConfirmBtn.setOnClickListener(create -> {
            String name = menuDG03_ItemNameInput.getText().toString();
            String price = menuDG03_ItemPriceInput.getText().toString();
            List<String> listOfItems = ListBuilder.getMenuItemNames(realm);
            if(listOfItems.contains(name)){
                menuDG03_ItemNameInput.setError("Name already exists.");
            } else {
                OpenMenuInstance.toCreateItem(image, category, name, Double.parseDouble(price));
                load_ItemRV(category);
                menuDG03_ItemNameInput.setText("");
                menuDG03_ItemPriceInput.setText("");
                menuDG03.dismiss();
            }
        });

        //On Close
        closeDG03Btn.setOnClickListener(close -> {
            menuDG03.dismiss();
        });
    }

    //Edit Category
    private void load_DG04Functionalites(int image, String name){
        //Set Image and Name;
        IconLoader.setMenuIcon(menuDG04_CategoryImg, image);
        menuDG04_CategoryNameInput.setText(name);

        //On Click SelectIconButton
        menuDG04_SelectIconBtn.setOnClickListener(select -> {
            load_DG01Functionalities(image,"Edit Category", menuDG04_CategoryNameInput.getText().toString());
            menuDG01.show();
        });

        //On Apply Button
        menuDG04_ApplyChangesBtn.setOnClickListener(apply -> {
            String input = menuDG04_CategoryNameInput.getText().toString();
            List<String> listOfCategories = ListBuilder.getMenuCategoryNames(realm);
            if(name.equals(input)){
                ToastMessage.show(getActivity(), "No Changes were made");
                menuDG04_CategoryNameInput.setText("");
                menuDG04.dismiss();
            } else if(listOfCategories.contains(input) && !name.equals(input)){
                menuDG04_CategoryNameInput.setError("Name Already Exists");
            } else {
                OpenMenuInstance.toUpdateCategory(name, image, input);
                load_CategoryRV();
                menuDG04_CategoryNameInput.setText("");
                menuDG04.dismiss();
            }
        });

        //On Delete Button
        menuDG04_DeleteBtn.setOnClickListener(delete -> {
            load_DG07Functionalities(image, name);
            menuDG04.dismiss();
            menuDG07.show();
        });

        //On Close Button
        closeDG04Btn.setOnClickListener(close -> {
            menuDG04.dismiss();
        });
    }

    //Edit Item
    private void load_DG05Functionalities(RealmMenuItem item){
        //Set Image and Name;
        IconLoader.setMenuIcon(menuDG05_ItemImg, item.getItemImage());
        menuDG05_ItemNameInput.setText(item.getItemName());
        menuDG05_ItemPriceInput.setText(new BigDecimal(item.getItemPrice()).setScale(2, RoundingMode.HALF_UP).toString());

        //On Apply Button
        menuDG05_ApplyChangesBtn.setOnClickListener(apply -> {
            String nameInput = menuDG05_ItemNameInput.getText().toString();
            String priceInput = menuDG05_ItemPriceInput.getText().toString();
            List<String> listOfItems = ListBuilder.getMenuItemNames(realm);
            if(item.getItemName().equals(nameInput) && String.valueOf(item.getItemPrice()).equals(priceInput)){
                ToastMessage.show(getActivity(), "No changes were made");
                menuDG05.dismiss();
            } else if(item.getItemName().equals(nameInput) && !String.valueOf(item.getItemPrice()).equals(priceInput)){
                OpenMenuInstance.toUpdateItem(item.getItemName(), item.getItemImage(), item.getItemCategory(), nameInput, Double.parseDouble(priceInput));
                menuDG05_ItemNameInput.setText("");
                menuDG05_ItemPriceInput.setText("");
                load_ItemRV(item.getItemCategory());
                menuDG05.dismiss();
            } else if(listOfItems.contains(nameInput)){
                menuDG05_ItemNameInput.setError("Name already exists");
            } else {
                OpenMenuInstance.toUpdateItem(item.getItemName(), item.getItemImage(), item.getItemCategory(), nameInput, Double.parseDouble(priceInput));
                load_ItemRV(item.getItemCategory());
                menuDG05_ItemNameInput.setText("");
                menuDG05_ItemPriceInput.setText("");
                menuDG05.dismiss();
            }
        });

        //On Delete Button
        menuDG05_DeleteBtn.setOnClickListener(delete -> {
            load_DG08Functionalities(item);
            menuDG05.dismiss();
            menuDG08.show();
        });

        //On Close
        closeDG05Btn.setOnClickListener(close -> {
            load_DG06Functionalities(item);
            menuDG05.dismiss();
            menuDG06.show();
        });
    }

    //View Item
    private void load_DG06Functionalities(RealmMenuItem item){
        //Load Item Details
        IconLoader.setMenuIcon(menuDG06_ItemImage, item.getItemImage());
        menuDG06_ItemName.setText(item.getItemName());
        menuDG06_ItemPrice.setText("₱" + new BigDecimal(item.getItemPrice()).setScale(2, RoundingMode.HALF_UP).toString());

        //On Edit Button
        menuDG06_EditBtn.setOnClickListener(edit -> {
            load_DG05Functionalities(item);
            menuDG06.dismiss();
            menuDG05.show();
        });

        //Initialize RecyclerView Items
        List<List<String>> listOfCombinations = new ArrayList<>();
        for(Map.Entry<String, Map<List<String>, Integer>> list : fpList.entrySet()){
            if(item.getItemName().equals(list.getKey())){
                for(List<String> itemsets : list.getValue().keySet()){
                    listOfCombinations.add(itemsets);
                }
            }
        }

        //Initialize RecyclerView
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        menuDG06_RecyclerViewAdapter = new M04F02D06_CombinationRVA(listOfCombinations);
        menuDG06_RecyclerView.setAdapter(menuDG06_RecyclerViewAdapter);
        menuDG06_RecyclerView.setLayoutManager(layout);

        //On Close Button
        closeDG06Btn.setOnClickListener(close -> {
            menuDG06.dismiss();
        });
    }

    //Delete Category
    private void load_DG07Functionalities(int image, String name){
        //Set Category Name
        menuDG07_CategoryName.setText(name);

        //On Yes Btn
        menuDG07_YesBtn.setOnClickListener(delete -> {
            OpenMenuInstance.toDeleteCategory(name);
            load_CategoryRV();
            menuDG07.dismiss();
        });
        //On No Btn
        menuDG07_NoBtn.setOnClickListener(delete -> {
            load_DG04Functionalites(image, name);
            menuDG07.dismiss();
            menuDG04.show();
        });
        //On Close Btn
        closeDG07Btn.setOnClickListener(close -> {
            load_DG04Functionalites(image, name);
            menuDG07.dismiss();
            menuDG04.show();
        });
    }

    //Delete Item
    private void load_DG08Functionalities(RealmMenuItem item){
        //Set Item Name
        menuDG08_ItemName.setText(item.getItemName());
        //On Yes Btn
        menuDG08_YesBtn.setOnClickListener(delete -> {
            OpenMenuInstance.toDeleteItem(item.getItemCategory(), item.getItemName());
            load_ItemRV(currentMenuRV);
            menuDG08.dismiss();
        });

        //On No Btn
        menuDG08_NoBtn.setOnClickListener(delete -> {
            load_DG06Functionalities(item);
            menuDG06.show();
            menuDG08.dismiss();
        });

        //On Close Btn
        closeDG08Btn.setOnClickListener(close -> {
            load_DG06Functionalities(item);
            menuDG06.show();
            menuDG08.dismiss();
        });
    }

    @Override
    public void load_RVContents(List<MenuItem> listOfItems) {
        listOfMenuItems = new ArrayList<>();
        listOfMenuItems.addAll(listOfItems);
        currentFragment = "Menu02";
        displayText.setText("「 " + currentMenuRV + " 」");
        GridLayoutManager layout = new GridLayoutManager(getActivity(), 2);
        layout.setOrientation(GridLayoutManager.VERTICAL);
        menuRVA = new M04F02_ItemRVA(getActivity(), realm, listOfMenuItems, this);
        menuRV.setAdapter(menuRVA);
        menuRV.setLayoutManager(layout);
    }

    @Override
    public void load_DGContents(int dialogNo, int image, String name) {
        switch(dialogNo){
            case 2:
                load_DG02Functionalities(image, name);
                menuDG02.show();
                break;
            case 4:
                RealmMenuCategory category = realm.where(RealmMenuCategory.class).equalTo("categoryName", name).findFirst();
                load_DG04Functionalites(category.getCategoryImage(), category.getCategoryName());
                menuDG04.show();
                break;
            case 44:
                load_DG04Functionalites(image, name);
                menuDG04.show();
                break;
            case 6:
                RealmMenuItem item = realm.where(RealmMenuItem.class).equalTo("itemName", name).findFirst();
                load_DG06Functionalities(item);
                menuDG06.show();
                break;
        }
    }

}