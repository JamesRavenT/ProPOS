package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Adapters.M04F01_ItemRVA.M04F01_CurrentItemName;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Adapters.M04F01_ItemRVA.M04F01_CurrentItemPrice;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.M04_Main.currentFragment;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Adapters.M04F01_CategoryRVA.listOfPOSCategories;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Adapters.M04F01_ItemRVA.listOfPOSItems;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.RVA_Cart.cart;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.M04_Main.currentPOSCategory;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.M04_Main.currentPOSCategoryIndex;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.M04_Main.pos_cart;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.Schemas.ProductsList;
import com.wabizabi.wazabipos.Database.Schemas.ProductsItem;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Adapters.M04F01_CategoryRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Adapters.M04F01_ItemRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment01_Header.M04F01SF01_Header;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment02_Recommendation.M04F01SF02_Recommendation;
import com.wabizabi.wazabipos.Utilities.Interfaces.DialogContentLoader;
import com.wabizabi.wazabipos.Utilities.Interfaces.DialogContentUpdater;
import com.wabizabi.wazabipos.Utilities.Interfaces.FragmentContentUpdater;
import com.wabizabi.wazabipos.Utilities.Interfaces.Update_POSItemList;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Objects.CartObject;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class M04F01_POS extends Fragment implements Update_POSItemList, FragmentContentUpdater, DialogContentLoader, DialogContentUpdater{
    //--DATABASE--//
    Realm realm = Realm.getDefaultInstance();
    //--RECYCLER VIEW(S)--//
    RecyclerView posCategoryRV, posItemRV;
    RecyclerView.Adapter posCategoryRVA, posItemRVA;
    //--GO TO CART BUTTON--//
    CardView goToCartButton;
    TextView goToCartText;
    //--ADD ITEM DIALOG--//
    Dialog addItemDG;
    int itemQtyCount = 1;
    TextView itemName, itemPrice, itemQty;
    ImageView itemImage, itemSubBtn, itemAddBtn;
    CardView addToCartBtn, closeDialogBtn;



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
        goToCartText = v.findViewById(R.id.M04F01_CartCounterText);
        goToCartButton = v.findViewById(R.id.M04F01_CheckOutBtn);

//        toggleOrientationBtn = v.findViewById(R.id.M04F01_OrientationToggleBtn);
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
        load_ButtonFunctions();
    }

    private void load_LandscapeFunctionalities(){

    }

    private void init_Dialogs() {
        addItemDG = new Dialog(getActivity());
        addItemDG.setContentView(R.layout.act04_main_frag01_pos_dialog);
        addItemDG.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        itemImage = addItemDG.findViewById(R.id.M04F01D_ItemImage);
        itemPrice = addItemDG.findViewById(R.id.M04F01D_ItemPrice);
        itemName = addItemDG.findViewById(R.id.M04F01D_ItemName);
        itemQty = addItemDG.findViewById(R.id.M04F01D_ItemQty);
        itemSubBtn = addItemDG.findViewById(R.id.M04F01D_SubBtn);
        itemAddBtn = addItemDG.findViewById(R.id.M04F01D_AddBtn);
        addToCartBtn = addItemDG.findViewById(R.id.M04F01D_AddToCartBtn);
        closeDialogBtn = addItemDG.findViewById(R.id.M04F01D_CloseDialogBtn);

        itemSubBtn.setOnClickListener(dec -> {
            if(itemQtyCount > 1) {
                itemQtyCount--;
                updateDialog();
            }
        });
        itemAddBtn.setOnClickListener(inc -> {
            itemQtyCount++;
            updateDialog();
        });
        addToCartBtn.setOnClickListener(add -> {
            List<CartObject> items = new ArrayList<>(cart.keySet());
            List<CartObject> basket = new ArrayList<>();
            for(CartObject cartItem : items){
                if(cartItem.getItemName().equalsIgnoreCase(M04F01_CurrentItemName)){
                    basket.add(cartItem);
                }
            }
            if(!basket.isEmpty()){
                CartObject itemkey = basket.get(0);
                cart.put(itemkey, cart.get(itemkey) + 1);
            } else {
                cart.put(new CartObject(0, M04F01_CurrentItemName, M04F01_CurrentItemPrice), itemQtyCount);
            }
            if(!cart.isEmpty()){
                String cartsize = String.valueOf(cart.size());
                goToCartText.setText("C a r t (" + cartsize + ")");
            }
            load_Header();
            itemQtyCount = 1;
            addItemDG.dismiss();
        });

        closeDialogBtn.setOnClickListener(close -> {
            addItemDG.dismiss();
        });
    }

    private void load_Header(){
        if(cart.size() == 1){
            List<CartObject> keys = new ArrayList<>(cart.keySet());
            CartObject firstItem = keys.get(0);
            String item = firstItem.getItemName();
            if(fpList.containsKey(item)){
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.M04F01_HeaderFragmentContainer, new M04F01SF02_Recommendation())
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

    private void load_RecyclerViews(){
        //--CATEGORY--//
        LinearLayoutManager categoryLayout = new LinearLayoutManager(getActivity());
        categoryLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        listOfPOSCategories = realm.where(ProductsList.class).sort("categoryName").findAll();
        posCategoryRVA = new M04F01_CategoryRVA(this, getActivity(), realm);
        posCategoryRV.setLayoutManager(categoryLayout);
        posCategoryRV.setAdapter(posCategoryRVA);
        //--ITEM--//
        LinearLayoutManager itemLayout = new LinearLayoutManager(getActivity());
        itemLayout.setOrientation(LinearLayoutManager.VERTICAL);
        if(currentPOSCategoryIndex == -1){
            listOfPOSItems = realm.where(ProductsItem.class).sort("itemName").findAll();
            posItemRVA = new M04F01_ItemRVA(    addItemDG,this, getActivity(), realm);
            posItemRV.setLayoutManager(itemLayout);
            posItemRV.setAdapter(posItemRVA);
        } else {
            listOfPOSItems = realm.where(ProductsItem.class).equalTo("itemCategory", currentPOSCategory).sort("itemName").findAll();
            posItemRVA = new M04F01_ItemRVA(addItemDG,this, getActivity(), realm);
            posItemRV.setLayoutManager(itemLayout);
            posItemRV.setAdapter(posItemRVA);
        }
    }

    private void load_ButtonFunctions(){
        goToCartButton.setOnClickListener((btn) -> {
            currentFragment = "Cart";
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.MainActivityContainer, pos_cart)
                    .commit();
        });
    }

    @Override
    public void refreshItemList(int position, RealmResults<ProductsItem> products) {
        posItemRVA = new M04F01_ItemRVA(addItemDG,this, getActivity(), realm);
        posItemRVA.notifyDataSetChanged();
        posItemRV.setAdapter(posItemRVA);
    }

    @Override
    public void updateFragment(){
        if(!cart.isEmpty()){
            String cartsize = String.valueOf(cart.size());
            goToCartText.setText("C a r t (" + cartsize + ")");
        }
    }

    @Override
    public void loadDialog(){
        itemPrice.setText("₱" + M04F01_CurrentItemPrice);
        itemName.setText(M04F01_CurrentItemName);
        itemQty.setText(String.valueOf(itemQtyCount));
    }

    @Override
    public void updateDialog(){
        itemQty.setText(String.valueOf(itemQtyCount));
    }




//    int screenLayoutSize = getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
//        if (screenLayoutSize == Configuration.SCREENLAYOUT_SIZE_SMALL || screenLayoutSize == Configuration.SCREENLAYOUT_SIZE_NORMAL) {
//        Toast.makeText(getActivity(), "Landscape mode is only available for Tablets", Toast.LENGTH_SHORT).show();
//    } else {
//        getActivity().setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//    }
//});
}
