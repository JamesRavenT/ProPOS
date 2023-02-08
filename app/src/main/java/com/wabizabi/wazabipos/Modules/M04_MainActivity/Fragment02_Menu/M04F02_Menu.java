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
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Menu.Adapters.M04F02D01_SelectIconRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Menu.Adapters.M04F02D07_CombinationRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Menu.Adapters.M04F02_CategoryRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Menu.Adapters.M04F02_ItemRVA;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Interfaces.DialogLoader;
import com.wabizabi.wazabipos.Utilities.Interfaces.RVLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.Bundles.DialogBundle;
import com.wabizabi.wazabipos.Utilities.Libraries.Bundles.RVBundle;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.DialogHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.IconLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.ListHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.RVHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.StringHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.ToastHelper;

import org.bson.types.ObjectId;

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

    //--DG03 EDIT CATEGORY--//
    Dialog menuDG03;
    ImageView menuDG03_CategoryImg;
    CardView menuDG03_SelectIconBtn;
    EditText menuDG03_CategoryNameInput;
    CardView menuDG03_ApplyChangesBtn, menuDG03_DeleteBtn;
    ImageView closeDG03Btn;

    //--DG04 DELETE CATEGORY--//
    Dialog menuDG04;
    TextView menuDG04_CategoryName;
    CardView menuDG04_YesBtn, menuDG04_NoBtn;
    ImageView closeDG04Btn;

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
        createBtn.setOnClickListener(create -> {
            if(currentFragment.equals("Menu01")){
                load_DG02Functionalities(new DialogBundle(2, new MenuCategory(0, "")));
                menuDG02.show();
            }
        });
    }

    private void load_ItemCreation(RVBundle bundle){
        createBtn.setOnClickListener(create -> {
            if(currentFragment.equals("Menu02")){
                load_DG05Functionalities(new DialogBundle(3, new MenuItem(0, bundle.getMenuCategory(), "", "", 0.00), bundle));
                menuDG05.show();
            }
        });
    }

    private void load_SearchBar(){
        searchbar.setText("");
        searchbar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

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

        //Initialize RecyclerView
        listOfMenuCategories = RVHelper.getMenuCategories(realm);
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        menuRVA = new M04F02_CategoryRVA(getActivity(), realm, searchbar, listOfMenuCategories, this, this);
        menuRV.setAdapter(menuRVA);
        menuRV.setLayoutManager(layout);
    }

    private void load_FilteredCategoryRV(String input){
        //Initialize RecyclerView
        List<MenuCategory> filteredCategory = RVHelper.getFilteredMenuCategories(listOfMenuCategories, input);
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        menuRVA = new M04F02_CategoryRVA(getActivity(), realm, searchbar, filteredCategory, this, this);
        menuRV.setAdapter(menuRVA);
        menuRV.setLayoutManager(layout);
    }

    private void load_ItemRV(RVBundle bundle){
        //Initialize RV Text
        displayText.setText("「 " + bundle.getMenuCategory() + " 」");

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
        List<MenuItem> filteredItem = RVHelper.getFilteredMenuItems(listOfMenuItems, input);
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        menuRVA = new M04F02_ItemRVA(getActivity(), realm, filteredItem, this);
        menuRV.setAdapter(menuRVA);
        menuRV.setLayoutManager(layout);
    }

    private void init_Dialogs(){
        //--DG01 SELECT ICON--//
        menuDG01 = DialogHelper.create(getActivity(), R.layout.act04_main_frag02_menu_dg01_selecticon);
        menuDG01_RecyclerView = menuDG01.findViewById(R.id.M04F02D01_IconsRV);
        closeDG01Btn = menuDG01.findViewById(R.id.M04F02D01_CloseDGBtn);

        //--DG02 CREATE CATEGORY--//
        menuDG02 = DialogHelper.create(getActivity(), R.layout.act04_main_frag02_menu_dg02_createcategory);
        menuDG02_CategoryImg = menuDG02.findViewById(R.id.M04F02D02_CategoryImage);
        menuDG02_SelectIconBtn = menuDG02.findViewById(R.id.M04F02D02_SelectIconBtn);
        menuDG02_CategoryNameInput = menuDG02.findViewById(R.id.M04F02D02_CategoryNameInput);
        menuDG02_ConfirmBtn = menuDG02.findViewById(R.id.M04F02D02_ConfirmBtn);
        closeDG02Btn = menuDG02.findViewById(R.id.M04F02D02_CloseDGBtn);

        //--DG03 EDIT CATEGORY--//
        menuDG03 = DialogHelper.create(getActivity(), R.layout.act04_main_frag02_menu_dg03_editcategory);
        menuDG03_CategoryImg = menuDG03.findViewById(R.id.M04F02D03_CategoryImage);
        menuDG03_CategoryNameInput = menuDG03.findViewById(R.id.M04F02D03_CategoryNameInput);
        menuDG03_SelectIconBtn = menuDG03.findViewById(R.id.M04F02D03_SelectIconBtn);
        menuDG03_ApplyChangesBtn = menuDG03.findViewById(R.id.M04F02D03_ApplyChangesBtn);
        menuDG03_DeleteBtn = menuDG03.findViewById(R.id.M04F02D03_DeleteBtn);
        closeDG03Btn = menuDG03.findViewById(R.id.M04F02D03_CloseDGBtn);

        //--DG04 DELETE CATEGORY--//
        menuDG04 = DialogHelper.create(getActivity(), R.layout.act04_main_frag02_menu_dg04_deletecategory);
        menuDG04_CategoryName = menuDG04.findViewById(R.id.M04F02D04_CategoryNameText);
        menuDG04_YesBtn = menuDG04.findViewById(R.id.M04F02D04_YesBtn);
        menuDG04_NoBtn = menuDG04.findViewById(R.id.M04F02D04_NoBtn);
        closeDG04Btn = menuDG04.findViewById(R.id.M04F02D04_CloseDGBtn);

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

    //Select Icon
    private void load_DG01Functionalities(DialogBundle bundle){
        //Initialize RecyclerView
        List<Integer> icons = RVHelper.getMenuIcons();
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        menuDG01_RecyclerViewAdapter = new M04F02D01_SelectIconRVA(getActivity(), realm, menuDG01, bundle, icons, this);
        menuDG01_RecyclerView.setAdapter(menuDG01_RecyclerViewAdapter);
        menuDG01_RecyclerView.setLayoutManager(layout);

        //On Close Button
        closeDG01Btn.setOnClickListener(close->{
            if(bundle.getDialogDestinationNo() == 2){
                load_DG02Functionalities(bundle);
                menuDG01.dismiss();
                menuDG02.show();
            } else if(bundle.getDialogDestinationNo() == 4){
                load_DG03Functionalities(bundle);
                menuDG01.dismiss();
                menuDG03.show();
            }
        });
    }

    //Create Category
    private void load_DG02Functionalities(DialogBundle bundle){
        //Unpack Bundle
        int image = bundle.getMenuCategory().getCategoryImage();
        String name = bundle.getMenuCategory().getCategoryName();

        //Set Image and Name;
        IconLoader.setMenuIcon(menuDG02_CategoryImg, image);
        menuDG02_CategoryNameInput.setText(name);

        //On Click SelectIconButton
        menuDG02_SelectIconBtn.setOnClickListener(select -> {
            //Extract String from Edit Text
            String input = menuDG02_CategoryNameInput.getText().toString();

            //Load DG01 and pass the Bundle
            bundle.getMenuCategory().setCategoryName(input);
            load_DG01Functionalities(bundle);
            menuDG02.dismiss();
            menuDG01.show();
        });

        //On Confirm Button
        menuDG02_ConfirmBtn.setOnClickListener(create -> {
            //Extract String from Edit Text
            String input = menuDG02_CategoryNameInput.getText().toString();

            //Check String
            List<String> listOfCategories = ListHelper.getMenuCategoryNames(realm);
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

    //Edit Category
    private void load_DG03Functionalities(DialogBundle bundle){
        //Unpack Bundle
        int image = bundle.getMenuCategory().getCategoryImage();
        String name = bundle.getMenuCategory().getCategoryName();

        //Set Image and Name;
        IconLoader.setMenuIcon(menuDG03_CategoryImg, image);
        menuDG03_CategoryNameInput.setText(name);

        //On Click SelectIconButton
        menuDG03_SelectIconBtn.setOnClickListener(select -> {
            load_DG01Functionalities(bundle);
            menuDG01.show();
        });

        //On Apply Button
        menuDG03_ApplyChangesBtn.setOnClickListener(apply -> {
            String input = menuDG03_CategoryNameInput.getText().toString();
            List<String> listOfCategories = ListHelper.getMenuCategoryNames(realm);
            if(name.equals(input)){
                ToastHelper.show(getActivity(), "No Changes were made");
                menuDG03_CategoryNameInput.setText("");
                menuDG03.dismiss();
            } else if(listOfCategories.contains(input) && !name.equals(input)){
                menuDG03_CategoryNameInput.setError("Name Already Exists");
            } else {
                OpenMenuInstance.toUpdateCategory(name, image, input);
                load_CategoryRV();
                menuDG03_CategoryNameInput.setText("");
                menuDG03.dismiss();
            }
        });

        //On Delete Button
        menuDG03_DeleteBtn.setOnClickListener(delete -> {
            load_DG04Functionalities(bundle);
            menuDG03.dismiss();
            menuDG04.show();
        });

        //On Close Button
        closeDG03Btn.setOnClickListener(close -> {
            menuDG03.dismiss();
        });
    }

    //Delete Category
    private void load_DG04Functionalities(DialogBundle bundle){
        //Unpack Bundle
        String name = bundle.getMenuCategory().getCategoryName();

        //Set Category Name
        menuDG04_CategoryName.setText(name);

        //On Yes Btn
        menuDG04_YesBtn.setOnClickListener(delete -> {
            OpenMenuInstance.toDeleteCategory(name);
            load_CategoryRV();
            menuDG04.dismiss();
        });
        //On No Btn
        menuDG04_NoBtn.setOnClickListener(delete -> {
            load_DG03Functionalities(bundle);
            menuDG04.dismiss();
            menuDG03.show();
        });
        //On Close Btn
        closeDG04Btn.setOnClickListener(close -> {
            load_DG03Functionalities(bundle);
            menuDG04.dismiss();
            menuDG03.show();
        });
    }

    //Create Item
    private void load_DG05Functionalities(DialogBundle bundle){
        //Unpack Bundle
        int image = bundle.getMenuItem().getItemIcon();
        String category = bundle.getMenuItem().getItemCategory();
        RVBundle items = bundle.getRvBundle();

        //Set Image and Name
        IconLoader.setMenuIcon(menuDG05_ItemImg, image);
        menuDG06_ItemWebNameInput.setText("");
        menuDG05_ItemPOSNameInput.setText("");
        menuDG05_ItemPriceInput.setText("");

        //On Confirm Button
        menuDG05_ConfirmBtn.setOnClickListener(create -> {
            String nameWebInput = menuDG05_ItemWebNameInput.getText().toString();
            String namePOSInput = menuDG05_ItemPOSNameInput.getText().toString();
            String priceInput = menuDG05_ItemPriceInput.getText().toString();
            List<String> listOfPOSItems = ListHelper.getMenuItemNames(realm);
            if(listOfPOSItems.contains(namePOSInput)){
                menuDG05_ItemPOSNameInput.setError("Name already exists.");
            } else {
                OpenMenuInstance.toCreateItem(image, category, namePOSInput, namePOSInput, Double.parseDouble(priceInput));
                load_ItemRV(items);
                menuDG05_ItemPOSNameInput.setText("");
                menuDG05_ItemPriceInput.setText("");
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
        String name = bundle.getMenuItem().getItemPOSName();
        String price = StringHelper.convertToCurrency(bundle.getMenuItem().getItemPrice());
        RVBundle items = bundle.getRvBundle();

        //Set Image and Name;
        IconLoader.setMenuIcon(menuDG06_ItemImg, image);
        menuDG06_ItemPOSNameInput.setText(name);
        menuDG06_ItemPriceInput.setText("₱" + price);

        //On Apply Button
        menuDG06_ApplyChangesBtn.setOnClickListener(apply -> {
            String nameInput = menuDG06_ItemPOSNameInput.getText().toString();
            String priceInput = menuDG06_ItemPriceInput.getText().toString();
            List<String> listOfItems = ListHelper.getMenuItemNames(realm);
            if(name.equals(nameInput) && price.equals(priceInput)){
                ToastHelper.show(getActivity(), "No changes were made");
                menuDG06.dismiss();
            } else if(name.equals(nameInput) && !price.equals(priceInput)){
                OpenMenuInstance.toUpdateItem(name, image, category, nameInput, nameInput, Double.parseDouble(priceInput));
                load_ItemRV(items);
                menuDG06_ItemPOSNameInput.setText("");
                menuDG06_ItemPriceInput.setText("");
                menuDG06.dismiss();
            } else if(listOfItems.contains(nameInput)){
                menuDG06_ItemPOSNameInput.setError("Name already exists");
            } else {
                OpenMenuInstance.toUpdateItem(name, image, category, nameInput, nameInput, Double.parseDouble(priceInput));
                load_ItemRV(items);
                menuDG06_ItemPOSNameInput.setText("");
                menuDG06_ItemPriceInput.setText("");
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
        ObjectId id = bundle.getMenuItem().getId();
        int image = bundle.getMenuItem().getItemIcon();
        String name = bundle.getMenuItem().getItemPOSName();
        String price = StringHelper.convertToCurrency(bundle.getMenuItem().getItemPrice());

        //Load Item Details
        IconLoader.setMenuIcon(menuDG07_ItemImage, image);
        menuDG07_ItemPOSName.setText(name);
        menuDG07_ItemPrice.setText("₱" + price);

        //On Edit Button
        menuDG07_EditBtn.setOnClickListener(edit -> {
            load_DG06Functionalities(bundle);
            menuDG07.dismiss();
            menuDG06.show();
        });

        //Initialize RecyclerView
        List<List<String>> listOfCombinations = RVHelper.getPopularCombinations(name);
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
        RVBundle items = bundle.getRvBundle();

        //Set Item Name
        menuDG08_ItemName.setText(name);
        //On Yes Btn
        menuDG08_YesBtn.setOnClickListener(delete -> {
            OpenMenuInstance.toDeleteItem(category, name);
            load_ItemRV(items);
            menuDG08.dismiss();
        });

        //On No Btn
        menuDG08_NoBtn.setOnClickListener(delete -> {
            load_DG07Functionalities(bundle);
            menuDG07.show();
            menuDG08.dismiss();
        });

        //On Close Btn
        closeDG08Btn.setOnClickListener(close -> {
            load_DG07Functionalities(bundle);
            menuDG07.show();
            menuDG08.dismiss();
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
                menuDG02.show();
                break;
            case 4:
                load_DG03Functionalities(bundle);
                menuDG03.show();
                break;
            case 6:
                load_DG07Functionalities(bundle);
                menuDG07.show();
                break;
        }
    }
}