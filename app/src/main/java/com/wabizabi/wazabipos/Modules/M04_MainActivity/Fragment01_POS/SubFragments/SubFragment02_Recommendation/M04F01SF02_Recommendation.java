package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment02_Recommendation;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Orders.Adapter.M04F01SF03_CartRVA.cart;
import static com.wabizabi.wazabipos.Utilities.BackgroundThreads.W01_Algorithm.fpList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuItem;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.M04F01_POS;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment01_Header.M04F01SF01_Header;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment02_Recommendation.Adapters.M04F01SF02_RecommendationRVA;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Objects.CartObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.realm.Realm;

public class M04F01SF02_Recommendation extends Fragment {
    TextView itemName, itemQuantity;
    ImageView addtoCartBtn;
    RecyclerView recommendedItemsRV;
    RecyclerView.Adapter recommendedItemsRVA;
    List<String> recommendedItemsListString = new ArrayList<>();
    List<CartObject> recommendedItemsListObject = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag01_pos_subfrag02_recommendation, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        itemName = v.findViewById(R.id.M04F01SF02_ItemName);
        itemQuantity = v.findViewById(R.id.M04F01SF02_RecommendedQuantity);
        recommendedItemsRV = v.findViewById(R.id.M04F01SF02_RecommendedRV);
        addtoCartBtn = v.findViewById(R.id.M04F01SF02_AddToCartBtn);
        load_Recommendations();
        load_Buttons();
    }

    private void load_Recommendations(){
        Random random = new Random();
        List<CartObject> keys = new ArrayList<>(cart.keySet());
        recommendedItemsListString.clear();
        switch(keys.size()) {
            case 1:
                CartObject c1_ObjectNo1 = keys.get(0);
                String c1_ItemNo1 = c1_ObjectNo1.getItemName();
                if(fpList.containsKey(c1_ItemNo1)){
                    load_CaseOneSuggestion(c1_ItemNo1, random);
                }
                break;
            case 2:
                CartObject c2_ObjectNo1 = keys.get(0);
                CartObject c2_ObjectNo2 = keys.get(1);
                String c2_ItemNo1 = c2_ObjectNo1.getItemName();
                String c2_ItemNo2 = c2_ObjectNo2.getItemName();
                if(fpList.containsKey(c2_ItemNo1)){
                    load_CaseTwoSuggestion(c2_ItemNo1, c2_ItemNo2, random);
                }
                break;
            case 3:
                CartObject c3_ObjectNo1 = keys.get(0);
                CartObject c3_ObjectNo2 = keys.get(1);
                CartObject c3_ObjectNo3 = keys.get(2);
                String c3_ItemNo1 = c3_ObjectNo1.getItemName();
                String c3_ItemNo2 = c3_ObjectNo2.getItemName();
                String c3_ItemNo3 = c3_ObjectNo3.getItemName();
                if(fpList.containsKey(c3_ItemNo1)){
                    load_CaseThreeSuggestion(c3_ItemNo1, c3_ItemNo2, c3_ItemNo3, random);
                }
                break;
            default:
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.M04F01_HeaderFragmentContainer, new M04F01SF01_Header())
                        .commit();
                break;
        }

    }

    private void load_RecyclerViews(){
        LinearLayoutManager recommendedItemsLayout = new LinearLayoutManager(getActivity());
        recommendedItemsLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        recommendedItemsRVA = new M04F01SF02_RecommendationRVA(recommendedItemsListObject);
        recommendedItemsRV.setLayoutManager(recommendedItemsLayout);
        recommendedItemsRV.setAdapter(recommendedItemsRVA);
    }

    private void load_Buttons(){
        addtoCartBtn.setOnClickListener(add -> {
            List<CartObject> keys = new ArrayList<>(cart.keySet());
            List<String> validator = new ArrayList<>();
            for(CartObject object : keys){
                validator.add(object.getItemName());
            }
            for(CartObject item : recommendedItemsListObject){
                String name = item.getItemName();
                if(!validator.contains(name)){
                    cart.put(item, 1);
                }
            }
            recommendedItemsListObject.clear();
            Toast.makeText(getActivity(), "Items Added Into Cart!", Toast.LENGTH_SHORT).show();
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.MainActivityContainer, new M04F01_POS())
                    .commit();
        });
    }

    private void load_CaseOneSuggestion(String itemNo1, Random random){
        List<List<String>> values = new ArrayList<>(fpList.get(itemNo1).keySet());
        recommendedItemsListString = values.get(random.nextInt(fpList.get(itemNo1).keySet().size()));
        for(String singleItem : recommendedItemsListString) {
            try(Realm realm = Realm.getDefaultInstance()){
                RealmMenuItem product = realm.where(RealmMenuItem.class).equalTo("itemName", singleItem).findFirst();
                CartObject cartItem = new CartObject(product.getItemImage(), product.getItemName(), product.getItemPrice());
                recommendedItemsListObject.add(cartItem);
            }
        }
        if(itemNo1.length() < 25) {
            itemName.setText(itemNo1);
        } else {
            itemName.setText(itemNo1.substring(0, Math.min(itemNo1.length(), 20)) + "...");
        }
        itemQuantity.setText("(" + recommendedItemsListString.size() + ") Items");
        load_RecyclerViews();
    }

    private void load_CaseTwoSuggestion(String itemNo1, String itemNo2, Random random){
        List<List<String>> values = new ArrayList<>(fpList.get(itemNo1).keySet());
        List<List<String>> relativevalues = new ArrayList<>();
        for(List<String> value : values){
            if(value.contains(itemNo1) && value.contains(itemNo2)){
                relativevalues.add(value);
            }
        }
        if(!relativevalues.isEmpty()){
            recommendedItemsListString = relativevalues.get(random.nextInt(relativevalues.size()));
            for(String item : recommendedItemsListString) {
                try(Realm realm = Realm.getDefaultInstance()){
                    RealmMenuItem product = realm.where(RealmMenuItem.class).equalTo("itemName", item).findFirst();
                    CartObject cartItem = new CartObject(product.getItemImage(), product.getItemName(), product.getItemPrice());
                    recommendedItemsListObject.add(cartItem);
                }
            }
            if(recommendedItemsListString.size() == cart.size()) {
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.M04F01_HeaderFragmentContainer, new M04F01SF01_Header())
                        .commit();
            }
        } else {
            load_CaseOneSuggestion(itemNo1, random);
        }
        String recommendedItems = itemNo1 + " & " + itemNo2;
        if(recommendedItems.length() < 50) {
            itemName.setText(recommendedItems);
        } else {
            itemName.setText(recommendedItems.substring(0, Math.min(recommendedItems.length(), 40)) + "...");
        }
        itemQuantity.setText("(" + recommendedItemsListString.size() + ") Items");
        load_RecyclerViews();
    }

    private void load_CaseThreeSuggestion(String itemNo1, String itemNo2, String itemNo3, Random random){
        List<List<String>> values = new ArrayList<>(fpList.get(itemNo1).keySet());
        List<List<String>> relativevalues = new ArrayList<>();
        for(List<String> value : values){
            if(value.contains(itemNo1) && value.contains(itemNo2) && value.contains(itemNo3)){
                relativevalues.add(value);
            }
        }
        if(!relativevalues.isEmpty()){
            recommendedItemsListString = relativevalues.get(random.nextInt(relativevalues.size()));
            for(String item : recommendedItemsListString) {
                try(Realm realm = Realm.getDefaultInstance()){
                    RealmMenuItem product = realm.where(RealmMenuItem.class).equalTo("itemName", item).findFirst();
                    CartObject cartItem = new CartObject(product.getItemImage(), product.getItemName(), product.getItemPrice());
                    recommendedItemsListObject.add(cartItem);
                }
            }
            if(recommendedItemsListString.size() == cart.size()) {
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.M04F01_HeaderFragmentContainer, new M04F01SF01_Header())
                        .commit();
            }
        } else {
            load_CaseTwoSuggestion(itemNo1, itemNo2, random);
        }
        String recommendedItems = itemNo1 + " & " + itemNo2 + " & " + itemNo3;
        if(recommendedItems.length() < 50) {
            itemName.setText(recommendedItems);
        } else {
            itemName.setText(recommendedItems.substring(0, Math.min(recommendedItems.length(), 40)) + "...");
        }
        itemQuantity.setText("(" + recommendedItemsListString.size() + ") Items");
        load_RecyclerViews();
    }
}

