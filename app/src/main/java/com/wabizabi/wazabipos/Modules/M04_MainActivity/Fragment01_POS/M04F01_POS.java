package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.M04_Main.currentFragment;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.M04F01SF03_CartRVA.cart;
import static com.wabizabi.wazabipos.Utilities.BackgroundThreads.W01_Algorithm.fpList;

import android.app.Dialog;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.ObjectSchemas.MenuCategory;
import com.wabizabi.wazabipos.Database.ObjectSchemas.MenuItem;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuCategory;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuItem;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Adapters.M04F01_CategoryRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Adapters.M04F01_ItemRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment01_Header.M04F01SF01_Header;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment02_Recommendation.M04F01SF02_Recommendation;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.M04F01SF03_Cart;
import com.wabizabi.wazabipos.Utilities.Interfaces.DialogLoader;
import com.wabizabi.wazabipos.Utilities.Interfaces.RVMenuLoader;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Libraries.IconLoader;
import com.wabizabi.wazabipos.Utilities.Objects.CartObject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class M04F01_POS extends Fragment implements RVMenuLoader, DialogLoader {
    //--DATABASE--//
    Realm realm = Realm.getDefaultInstance();

    //--RECYCLER VIEW(S)--//
    //Category RV
    RecyclerView posCategoryRV;
    RecyclerView.Adapter posCategoryRVA;
    TextView currentCategoryText;
    public static int currentPOSCategoryIndex = -1;
    public static String currentPOSCategoryName;

    //Item RV
    RecyclerView posItemRV;
    RecyclerView.Adapter posItemRVA;
    public static int currentPOSItemImage;
    public static String currentPOSItemName;
    public static double currentPOSItemPrice;

    //--GO TO CART BUTTON--//
    CardView goToCartButton;
    TextView goToCartText;
    //--ADD ITEM DIALOG--//
    Dialog posDG01;
    int itemQtyCount = 1;
    TextView posDG01_ItemName, posDG01_ItemPrice, posDG01_ItemQty;
    ImageView posDG01_ItemImage, posDG01_ItemSubBtn, posDG01_ItemAddBtn;
    CardView posDG01_AddToCartBtn;
    ImageView posDG01_CloseDGBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag01_pos, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        posCategoryRV = v.findViewById(R.id.M04F01_CategoryRV);
        posItemRV = v.findViewById(R.id.M04F01_ItemsRV);
        currentCategoryText = v.findViewById(R.id.M04F01_ItemText);
        goToCartText = v.findViewById(R.id.M04F01_OrdersBtnText);
        goToCartButton = v.findViewById(R.id.M04F01_OrdersBtn);

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            load_PortraitFunctionalities();
        } else {
            load_LandscapeFunctionalities();
        }
    }

    private void load_PortraitFunctionalities() {
        init_Dialogs();
        load_Header();
        load_RecyclerViews();
        load_OrderSize();
        load_ButtonFunctions();
    }

    private void load_LandscapeFunctionalities(){

    }

    private void load_Header(){
        if(!cart.isEmpty()){
            List<CartObject> keys = new ArrayList<>(cart.keySet());
            CartObject firstItem = keys.get(0);
            String item = firstItem.getItemName();
            if(fpList.containsKey(item)) {
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.M04F01_HeaderFragmentContainer, new M04F01SF02_Recommendation())
                        .commit();
            } else {
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.M04F01_HeaderFragmentContainer, new M04F01SF01_Header())
                        .commit();
            }
        } else {
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.M04F01_HeaderFragmentContainer, new M04F01SF01_Header())
                    .commit();
        }
    }

    private void load_RecyclerViews() {
        //Initialize the List of Categories to be displayed
        List<MenuCategory> listOfCategories = new ArrayList<>();
        RealmResults<RealmMenuCategory> queriedCategoryList = realm.where(RealmMenuCategory.class).sort("categoryName").findAll();
        for(RealmMenuCategory queriedCategory : queriedCategoryList){
            listOfCategories.add(new MenuCategory(queriedCategory.getCategoryImage(), queriedCategory.getCategoryName()));
        }
        //Initialize the List of Items to be displayed
        List<MenuItem> listOfItems = new ArrayList<>();
        if(currentPOSCategoryIndex == -1){
            RealmResults<RealmMenuItem> queriedItemList = realm.where(RealmMenuItem.class).sort("itemName").findAll();
            for(RealmMenuItem queriedItem : queriedItemList){
                listOfItems.add(new MenuItem(queriedItem.getItemImage(), queriedItem.getItemName(), queriedItem.getItemPrice()));
            }
        } else {
            RealmResults<RealmMenuItem> queriedItemList = realm.where(RealmMenuItem.class).equalTo("itemCategory", currentPOSCategoryName).sort("itemName").findAll();
            for(RealmMenuItem queriedItem : queriedItemList){
                listOfItems.add(new MenuItem(queriedItem.getItemImage(), queriedItem.getItemName(), queriedItem.getItemPrice()));
            }
        }

        //Set the Layout and the Adapter of the Category RecyclerView
        LinearLayoutManager categoryLayout = new LinearLayoutManager(getActivity());
        categoryLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        posCategoryRVA = new M04F01_CategoryRVA(getActivity(), realm, listOfCategories, listOfItems, this);
        posCategoryRV.setLayoutManager(categoryLayout);
        posCategoryRV.setAdapter(posCategoryRVA);

        //Set the Layout and the Adapter of the Item RecyclerView
        GridLayoutManager itemLayout = new GridLayoutManager(getActivity(), 2);
        itemLayout.setOrientation(GridLayoutManager.VERTICAL);
        posItemRVA = new M04F01_ItemRVA(getActivity(), realm, listOfItems, posDG01,this);;
        posItemRV.setLayoutManager(itemLayout);
        posItemRV.setAdapter(posItemRVA);
    }

    private void load_OrderSize(){
        goToCartText.setText("Orders [" + cart.size() + "]");
    }

    private void load_ButtonFunctions(){
        goToCartButton.setOnClickListener((btn) -> {
            currentFragment = "Cart";
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.MainActivityContainer, new M04F01SF03_Cart())
                    .commit();
        });
    }

    private void init_Dialogs() {
        //--DG01 ADD ITEM DIALOG--//
        posDG01 = new Dialog(getActivity());
        posDG01.setContentView(R.layout.act04_main_frag01_pos_dg01_additem);
        posDG01.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        posDG01_ItemImage = posDG01.findViewById(R.id.M04F01D01_ItemImage);
        posDG01_ItemPrice = posDG01.findViewById(R.id.M04F01D01_ItemPrice);
        posDG01_ItemName = posDG01.findViewById(R.id.M04F01D01_ItemName);
        posDG01_ItemQty = posDG01.findViewById(R.id.M04F01D01_ItemQty);
        posDG01_ItemSubBtn = posDG01.findViewById(R.id.M04F01D01_SubBtn);
        posDG01_ItemAddBtn = posDG01.findViewById(R.id.M04F01D01_AddBtn);
        posDG01_AddToCartBtn = posDG01.findViewById(R.id.M04F01D01_AddToCartBtn);
        posDG01_CloseDGBtn = posDG01.findViewById(R.id.M04F01D01_CloseDGBtn);
    }

    private void load_DG01Functionalities(String name){
        //Get Item
        RealmMenuItem item = realm.where(RealmMenuItem.class).equalTo("itemName", name).findFirst();

        //Set Views
        String itemName = (name.length() < 25) ? name : name.substring(0, Math.min(item.getItemName().length(), 20)) + "...";
        IconLoader.setMenuIcon(posDG01_ItemImage, item.getItemImage());
        posDG01_ItemName.setText(itemName);
        posDG01_ItemPrice.setText("₱" + new BigDecimal(item.getItemPrice()).setScale(2, RoundingMode.HALF_UP).toString());

        //On Sub Btn
        posDG01_ItemSubBtn.setOnClickListener(dec -> {
            if(itemQtyCount > 1) {
                itemQtyCount--;
                posDG01_ItemQty.setText(String.valueOf(itemQtyCount));
            }
        });

        //On Add Btn
        posDG01_ItemAddBtn.setOnClickListener(inc -> {
            itemQtyCount++;
            posDG01_ItemQty.setText(String.valueOf(itemQtyCount));
        });

        //On Add To Cart Btn
        posDG01_AddToCartBtn.setOnClickListener(add -> {
            List<CartObject> items = new ArrayList<>(cart.keySet());
            List<CartObject> basket = new ArrayList<>();
            for(CartObject cartItem : items){
                if(cartItem.getItemName().equalsIgnoreCase(name)){
                    basket.add(cartItem);
                }
            }
            if(!basket.isEmpty()){
                CartObject itemkey = basket.get(0);
                cart.put(itemkey, cart.get(itemkey) + 1);
            } else {
                cart.put(new CartObject(name, item.getItemPrice()), itemQtyCount);
            }
            load_Header();
            load_RecyclerViews();
            load_OrderSize();
            itemQtyCount = 1;
            posDG01.dismiss();
        });

        //On Close Btn
        posDG01_CloseDGBtn.setOnClickListener(close -> {
            posDG01.dismiss();
        });
    }

    @Override
    public void load_RVContents(List<MenuItem> listOfItems) {
        posItemRVA = new M04F01_ItemRVA(getActivity(), realm, listOfItems, posDG01, this);
        posItemRVA.notifyDataSetChanged();
        posItemRV.setAdapter(posItemRVA);
    }

    @Override
    public void load_DGContents(int dialogNo, int image, String name) {
        load_DG01Functionalities(name);
        posDG01.show();
    }


//    int screenLayoutSize = getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
//        if (screenLayoutSize == Configuration.SCREENLAYOUT_SIZE_SMALL || screenLayoutSize == Configuration.SCREENLAYOUT_SIZE_NORMAL) {
//        Toast.makeText(getActivity(), "Landscape mode is only available for Tablets", Toast.LENGTH_SHORT).show();
//    } else {
//        getActivity().setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//    }
//});
}
