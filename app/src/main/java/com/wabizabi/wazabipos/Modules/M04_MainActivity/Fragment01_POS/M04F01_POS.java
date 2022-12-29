package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.M04_Main.currentFragment;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Adapters.M04F01_CategoryRVA.listOfPOSCategories;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Adapters.M04F01_ItemRVA.listOfPOSItems;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.RVA_Cart.cart;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.M04_Main.currentPOSCategory;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.M04_Main.currentPOSCategoryIndex;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.M04_Main.pos_cart;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.M04_Main.pos_header;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.M04_Main.pos_recommendation;
import static com.wabizabi.wazabipos.Utilities.BackgroundThreads.W01_Algorithm.fpList;

import android.content.Context;
import android.content.res.Configuration;
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
import com.wabizabi.wazabipos.Utilities.Interfaces.Update_POS;
import com.wabizabi.wazabipos.Utilities.Interfaces.Update_POSItemList;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Objects.CartObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.realm.Realm;
import io.realm.RealmResults;

public class M04F01_POS extends Fragment implements Update_POSItemList, Update_POS {
    //--DATABASE--//
    Realm realm = Realm.getDefaultInstance();
    //--RECYCLERVIEWS--//
    RecyclerView posCategoryRV, posItemRV;
    RecyclerView.Adapter posCategoryRVA, posItemRVA;
    TextView goToCartText;

    //--BUTTONS--//
    CardView goToCartButton;

    //--TEMP RECOMMENDATION--//


    //--PHONE EXCLUSIVE VARIABLES--//



    //--TABLET EXCLUSIVE VARIABLES--//

    ImageView toggleOrientationBtn;


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

        toggleOrientationBtn = v.findViewById(R.id.M04F01_OrientationToggleBtn);
        goToCartText = v.findViewById(R.id.POS_CartCounterTxt);


        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            load_PortraitFunctionalities();
        } else {
            load_LandscapeFunctionalities();
        }
    }

    private void load_PortraitFunctionalities(){
        load_Header();
        load_RecyclerViews();
    }

    private void load_LandscapeFunctionalities(){

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
                    .replace(R.id.M04F01_HeaderFragmentContainer, pos_recommendation)
                    .commit();
            }
        } else {
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.M04F01_HeaderFragmentContainer, pos_header)
                    .commit();
        }

    }

    private void setCartCounter(View v){

        if(!cart.isEmpty()){
            String cartsize = String.valueOf(cart.size());
            goToCartText.setText("C a r t (" + cartsize + ")");
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
            posItemRVA = new M04F01_ItemRVA(this, getActivity(), realm);
            posItemRV.setLayoutManager(itemLayout);
            posItemRV.setAdapter(posItemRVA);
        } else {
            listOfPOSItems = realm.where(ProductsItem.class).equalTo("itemCategory", currentPOSCategory).sort("itemName").findAll();
            posItemRVA = new M04F01_ItemRVA(this, getActivity(), realm);
            posItemRV.setLayoutManager(itemLayout);
            posItemRV.setAdapter(posItemRVA);
        }
    }

    private void setButtons(View v){
        goToCartButton = v.findViewById(R.id.POS_CheckOutBtn);
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
        posItemRVA = new M04F01_ItemRVA(this, getActivity(), realm);
        posItemRVA.notifyDataSetChanged();
        posItemRV.setAdapter(posItemRVA);
    }

    @Override
    public void refreshCartCount(Context context) {
        if(!cart.isEmpty()){
            String cartsize = String.valueOf(cart.size());
            goToCartText.setText("C a r t (" + cartsize + ")");
        }
        load_Header();
    }








//    int screenLayoutSize = getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
//        if (screenLayoutSize == Configuration.SCREENLAYOUT_SIZE_SMALL || screenLayoutSize == Configuration.SCREENLAYOUT_SIZE_NORMAL) {
//        Toast.makeText(getActivity(), "Landscape mode is only available for Tablets", Toast.LENGTH_SHORT).show();
//    } else {
//        getActivity().setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//    }
//});
}
