package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.M04F01SF03_CartRVA.cart;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.M04F01SF03_Cart.currentCartTicket;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.M04_Main.currentFragment;
import static com.wabizabi.wazabipos.Utilities.BackgroundThreads.W01_Algorithm.fpList;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
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

import com.wabizabi.wazabipos.Database.ObjectSchemas.MenuCategory;
import com.wabizabi.wazabipos.Database.ObjectSchemas.MenuItem;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Adapters.M04F01_CategoryRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Adapters.M04F01_ItemRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Helpers.POSCHelper;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Helpers.POSIHelper;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment01_Header.M04F01SF01_Header;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment02_Recommendation.M04F01SF02_Recommendation;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Interfaces.DialogLoader;
import com.wabizabi.wazabipos.Utilities.Interfaces.RVLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.Bundles.DialogBundle;
import com.wabizabi.wazabipos.Utilities.Libraries.Bundles.RVBundle;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.DialogHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.IconHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.LogHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.StringHelper;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Object.CartItem;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class M04F01_POS extends Fragment implements RVLoader, DialogLoader {
    //--DATABASE--//
    Realm realm = Realm.getDefaultInstance();

    //--SEARCH BAR--//
    EditText searchBar;

    //--RECYCLER VIEW--//
    TextView currentRVText;
    RecyclerView posRV;
    RecyclerView.Adapter posRVA;
    List<MenuCategory> listOfCategories;
    List<MenuItem> listOfItems;

    //--ADD ITEM DIALOG--//
    Dialog posDG01;
    int itemQtyCount = 1;
    TextView posDG01_ItemName, posDG01_ItemPrice, posDG01_ItemQty;
    ImageView posDG01_ItemImage, posDG01_ItemSubBtn, posDG01_ItemAddBtn;
    CardView posDG01_AddToCartBtn;
    ImageView posDG01_CloseDGBtn;

    //Interface
    RefreshCart cartContent;
    public interface RefreshCart {
        void updateCart();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag01_pos, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        searchBar = v.findViewById(R.id.M04F01_SearchBarInput);
        currentRVText = v.findViewById(R.id.M04F01_RecyclerViewText);
        posRV = v.findViewById(R.id.M04F01_RecyclerView);

        init_Dialogs();
        load_Header();
        load_SearchBar();
        load_CategoryRV();
    }

    private void load_Header(){
        if(!cart.isEmpty()){
            List<CartItem> keys = new ArrayList<>(cart.keySet());
            CartItem firstItem = keys.get(0);
            String item = firstItem.getItemWebName();
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

    private void load_SearchBar(){
        searchBar.removeTextChangedListener(searchEngine);
        searchBar.getText().clear();
        searchBar.addTextChangedListener(searchEngine);
    }

    private void load_CategoryRV() {
        //Initialize Text Display
        currentRVText.setText("「 CATEGORIES 」");
        //Initialize RV Items and then the RecyclerView
        listOfCategories = POSCHelper.getMenuCategories(realm);
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        posRVA = new M04F01_CategoryRVA(getActivity(), realm, listOfCategories, this);
        posRV.setAdapter(posRVA);
        posRV.setLayoutManager(layout);
    }

    private void load_FilteredCategoryRV(String input){
        //Initialize RV Items and then the RecyclerView
        List<MenuCategory> filteredCategory = POSCHelper.getFilteredMenuCategories(listOfCategories, input);
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        posRVA = new M04F01_CategoryRVA(getActivity(), realm, filteredCategory, this);
        posRV.setAdapter(posRVA);
        posRV.setLayoutManager(layout);
    }

    private void load_ItemRV(RVBundle bundle){
        //Initialize Text Display
        currentRVText.setText("「 " + bundle.getMenuCategory().toUpperCase() + " 」");

        //Unpack bundle to get RV Items and then initialize the RecyclerView
        listOfItems = bundle.getListOfMenuItems();
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        posRVA = new M04F01_ItemRVA(getActivity(), realm, listOfItems, this);
        posRV.setAdapter(posRVA);
        posRV.setLayoutManager(layout);
    }

    private void load_FilteredItemRV(String input){
        //Initialize RV Items and then the RecyclerView
        List<MenuItem> filteredListOfItem = POSIHelper.getFilteredMenuItems(listOfItems, input);
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        posRVA = new M04F01_ItemRVA(getActivity(), realm, filteredListOfItem, this);
        posRV.setAdapter(posRVA);
        posRV.setLayoutManager(layout);
    }

    private void init_Dialogs() {
        //--DG01 ADD ITEM DIALOG--//
        posDG01 = DialogHelper.create(getActivity(), R.layout.act04_main_frag01_pos_dg01_additem);
        posDG01_ItemImage = posDG01.findViewById(R.id.M04F01D01_ItemImage);
        posDG01_ItemPrice = posDG01.findViewById(R.id.M04F01D01_ItemPrice);
        posDG01_ItemName = posDG01.findViewById(R.id.M04F01D01_ItemName);
        posDG01_ItemQty = posDG01.findViewById(R.id.M04F01D01_ItemQty);
        posDG01_ItemSubBtn = posDG01.findViewById(R.id.M04F01D01_SubBtn);
        posDG01_ItemAddBtn = posDG01.findViewById(R.id.M04F01D01_AddBtn);
        posDG01_AddToCartBtn = posDG01.findViewById(R.id.M04F01D01_AddToCartBtn);
        posDG01_CloseDGBtn = posDG01.findViewById(R.id.M04F01D01_CloseDGBtn);
    }

    private void load_DG01Functionalities(DialogBundle bundle){
        //Get Screen Configuration
        int orientation = getResources().getConfiguration().orientation;
        //Unpack Bundle
        int itemImage = bundle.getMenuItem().getItemIcon();
        String itemCategory = bundle.getMenuItem().getItemCategory();
        String itemWebName = bundle.getMenuItem().getItemWebName();
        String itemPOSName = bundle.getMenuItem().getItemPOSName();
        double itemPrice = bundle.getMenuItem().getItemPrice();
        List<MenuItem> listOfItems = bundle.getRvBundle().getListOfMenuItems();
        //Load Item Details
        itemQtyCount = 1;
        String price = StringHelper.convertToCurrency(itemPrice);
        IconHelper.setMenuIcon(posDG01_ItemImage, itemImage);
        posDG01_ItemQty.setText(String.valueOf(itemQtyCount));
        posDG01_ItemName.setText(itemPOSName);
        posDG01_ItemPrice.setText(price);

        //On Sub Btn
        posDG01_ItemSubBtn.setOnClickListener(dec -> {
            if(itemQtyCount > 1) {
                itemQtyCount--;
                posDG01_ItemQty.setText(String.valueOf(itemQtyCount));
            }
        });

        //On Add Btn
        posDG01_ItemAddBtn.setOnClickListener(inc -> {
            if(itemQtyCount != 99){
                itemQtyCount++;
                posDG01_ItemQty.setText(String.valueOf(itemQtyCount));
            }
        });

        //On Add To Cart Btn
        posDG01_AddToCartBtn.setOnClickListener(add -> {
            List<CartItem> items = new ArrayList<>(cart.keySet());
            List<CartItem> basket = new ArrayList<>();
            for(CartItem cartItem : items){
                if(cartItem.getItemPOSName().equalsIgnoreCase(itemPOSName)){
                    basket.add(cartItem);
                }
            }
            if(!basket.isEmpty()){
                CartItem itemkey = basket.get(0);
                cart.put(itemkey, cart.get(itemkey) + 1);
            } else {
                cart.put(new CartItem(itemWebName, itemPOSName, itemPrice), itemQtyCount);
            }
            if(currentCartTicket != null) {
                currentCartTicket.setTicketStatus("Voidable");
            }
            load_Header();
            load_ItemRV(new RVBundle(itemCategory, listOfItems));
            itemQtyCount = 1;
            if(orientation == Configuration.ORIENTATION_LANDSCAPE){
                cartContent.updateCart();
            }
            posDG01_ItemQty.setText(String.valueOf(itemQtyCount));
            posDG01.dismiss();
        });

        //On Close Btn
        posDG01_CloseDGBtn.setOnClickListener(close -> {
            posDG01.dismiss();
        });
    }

    public void refreshPOSAdapter(){
        load_Header();
        posRVA.notifyDataSetChanged();
    }

    public void backToCategory(){
        int orientation = getActivity().getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            load_SearchBar();
            load_CategoryRV();
        }
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
            if(currentFragment.equals("POS01") || currentFragment.equals("POS03")){
                load_FilteredCategoryRV(input.toString());
            } else {
                load_FilteredItemRV(input.toString());
            }
        }
    };

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof RefreshCart){
            cartContent = (RefreshCart) context;
        } else {
            throw new RuntimeException(context.toString() + "Must implement Fragment");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        cartContent = null;
    }

    @Override
    public void load_DGContents(DialogBundle bundle) {
        load_DG01Functionalities(bundle);
        posDG01.show();
    }

    @Override
    public void load_RVContents(RVBundle bundle) {
        load_SearchBar();
        load_ItemRV(bundle);
    }


//
//        if (screenLayoutSize == Configuration.SCREENLAYOUT_SIZE_SMALL || screenLayoutSize == Configuration.SCREENLAYOUT_SIZE_NORMAL) {
//        Toast.makeText(getActivity(), "Landscape mode is only available for Tablets", Toast.LENGTH_SHORT).show();
//    } else {
//        getActivity().setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//    }
//});
}
