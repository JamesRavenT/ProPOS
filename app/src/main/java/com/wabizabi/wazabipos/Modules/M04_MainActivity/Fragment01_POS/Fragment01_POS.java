package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.M04_Main.currentFragment;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.M04_Main.currentPOSCategory;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.M04_Main.currentPOSCategoryIndex;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Adapters.RVA_POSCategory.listOfPOSCategories;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Adapters.RVA_POSItem.listOfPOSItems;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment01_Cart.Adapter.RVA_Cart.cart;
import static com.wabizabi.wazabipos.Utilities.Global.Variables.fpList;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.Schemas.ProductsList;
import com.wabizabi.wazabipos.Database.Schemas.ProductsItem;
import com.wabizabi.wazabipos.Database.Schemas.UserProfile;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Adapters.RVA_POSCategory;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Adapters.RVA_POSItem;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Interfaces.Update_POS;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Interfaces.Update_POSItemList;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Objects.CartObject;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment01_Cart.SubFragment01_Cart;
import com.wabizabi.wazabipos.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import io.realm.Realm;
import io.realm.RealmResults;

public class Fragment01_POS extends Fragment implements Update_POSItemList, Update_POS {

    SubFragment01_Cart pos_cart = new SubFragment01_Cart();
    Realm realm;
    TextView header1, header2, header3;
    RecyclerView posCategoryRV, posItemRV;
    RecyclerView.Adapter posCategoryRVA, posItemRVA;
    CardView goToCartButton;
    TextView goToCartText;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag01_pos, container, false);
        setDBInstance();
        setHeader(v);
        setCartCounter(v);
        setRecyclerview(v);
        setButtons(v);
        return v;
    }

    private void setDBInstance(){
        realm = Realm.getDefaultInstance();
    }

    private void setHeader(View v){
        header1 = v.findViewById(R.id.POS_HeaderText);
        header2 = v.findViewById(R.id.POS_HeaderText2);
        header3 = v.findViewById(R.id.POS_HeaderText3);
        recommendItemsIfCartIsNotEmpty();

    }

    private void setCartCounter(View v){
        goToCartText = v.findViewById(R.id.POS_CartCounterTxt);
        if(!cart.isEmpty()){
            String cartsize = String.valueOf(cart.size());
            goToCartText.setText("C a r t (" + cartsize + ")");
        }
    }

    private void setRecyclerview(View v){
        //--CATEGORY--//
        LinearLayoutManager categoryLayout = new LinearLayoutManager(getActivity());
        categoryLayout.setOrientation(LinearLayoutManager.HORIZONTAL);

        listOfPOSCategories = realm.where(ProductsList.class).sort("categoryName").findAll();
        posCategoryRVA = new RVA_POSCategory(this, getActivity(), realm);
        posCategoryRV = v.findViewById(R.id.POS_CategoryRV);
        posCategoryRV.setLayoutManager(categoryLayout);
        posCategoryRV.setAdapter(posCategoryRVA);

        //--ITEM--//
        LinearLayoutManager itemLayout = new LinearLayoutManager(getActivity());
        itemLayout.setOrientation(LinearLayoutManager.VERTICAL);
        if(currentPOSCategoryIndex == -1){
            listOfPOSItems = realm.where(ProductsItem.class).sort("itemName").findAll();
            posItemRVA = new RVA_POSItem(this, getActivity(), realm);
            posItemRV = v.findViewById(R.id.POS_ItemRV);
            posItemRV.setLayoutManager(itemLayout);
            posItemRV.setAdapter(posItemRVA);
        } else {
            listOfPOSItems = realm.where(ProductsItem.class).equalTo("itemCategory", currentPOSCategory).sort("itemName").findAll();
            posItemRVA = new RVA_POSItem(this, getActivity(), realm);
            posItemRV = v.findViewById(R.id.POS_ItemRV);
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
        posItemRVA = new RVA_POSItem(this, getActivity(), realm);
        posItemRVA.notifyDataSetChanged();
        posItemRV.setAdapter(posItemRVA);
    }

    @Override
    public void refreshCartCount(Context context) {
        if(!cart.isEmpty()){
            String cartsize = String.valueOf(cart.size());
            goToCartText.setText("C a r t (" + cartsize + ")");
        }
        recommendItemsIfCartIsNotEmpty();
    }

    private void recommendItemsIfCartIsNotEmpty(){
        if (!cart.isEmpty() && !fpList.isEmpty()){
            Random random = new Random();
            List<CartObject> keys = new ArrayList<>(cart.keySet());
            CartObject firstItem = keys.get(0);
            String item = firstItem.getItemName();
            if(fpList.containsKey(item)){
                List<List<String>> values = new ArrayList<>(fpList.get(item).keySet());
                List<String> frequentItemSet = values.get(random.nextInt(fpList.get(item).keySet().size()));
                String fqItemset = frequentItemSet.toString()
                        .replace("[", "・")
                        .replace("]", "")
                        .replace(",", "\n・");

                header1.setText("Popular Combinations with ");
                header2.setText("\"" + item +"\"");
                header3.setText(fqItemset);
            }

        } else {
            UserProfile user = realm.where(UserProfile.class).findFirst();
            DateFormat currentTime = new SimpleDateFormat("h:mm a");
            DateFormat currentMonth = new SimpleDateFormat("MMM");
            DateFormat currentDay = new SimpleDateFormat("d");
            DateFormat currentYear = new SimpleDateFormat("yyyy");
            String time = currentTime.format(new Date());
            String month = currentMonth.format(new Date());
            String day = currentDay.format(new Date());
            String year = currentYear.format(new Date());
            String owner = user.getUserName();

            header1.setText(month + " " + day + " " + year + ", " + time);
            header2.setText("Greetings," + owner);
            header3.setText("");
        }
    }

}
