package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment02_Recommendation;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.RVA_Cart.cart;
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

import com.wabizabi.wazabipos.Database.Schemas.ProductsItem;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment02_Recommendation.Adapters.M04F01SF02_RecommendationRVA;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Interfaces.FragmentContentUpdater;
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
    FragmentContentUpdater onclick;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag01_pos_caption_recommendation, container, false);
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
        CartObject firstItem = keys.get(0);
        String item = firstItem.getItemName();
        if(fpList.containsKey(item)){
            recommendedItemsListString.clear();
            recommendedItemsListObject.clear();
            List<List<String>> values = new ArrayList<>(fpList.get(item).keySet());
            recommendedItemsListString = values.get(random.nextInt(fpList.get(item).keySet().size()));
            for(String singleItem : recommendedItemsListString) {
                try(Realm realm = Realm.getDefaultInstance()){
                    ProductsItem product = realm.where(ProductsItem.class).equalTo("itemName", singleItem).findFirst();
                    CartObject cartItem = new CartObject(product.getItemImage(), product.getItemName(), product.getItemPrice());
                    recommendedItemsListObject.add(cartItem);
                }
            }
            itemName.setText(item);
            itemQuantity.setText("(" + recommendedItemsListString.size() + ") Items");
            load_RecyclerViews();
        }

    }

    private void load_RecyclerViews(){
        LinearLayoutManager recommendedItemsLayout = new LinearLayoutManager(getActivity());
        recommendedItemsLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        recommendedItemsRVA = new M04F01SF02_RecommendationRVA(getActivity(), recommendedItemsListObject);
        recommendedItemsRV.setLayoutManager(recommendedItemsLayout);
        recommendedItemsRV.setAdapter(recommendedItemsRVA);
    }

    private void load_Buttons(){
        addtoCartBtn.setOnClickListener(add -> {
            List<CartObject> keys = new ArrayList<>(cart.keySet());
            CartObject firstItem = keys.get(0);
            for(CartObject item : recommendedItemsListObject){
                String name = item.getItemName();
                if(name.equals(firstItem.getItemName())){
                    recommendedItemsListObject.remove(item);
                } else {
                    cart.put(item, 1);
                }
            }
            Toast.makeText(getActivity(), "Items Added Into Cart!", Toast.LENGTH_SHORT).show();
            onclick.updateFragment();
        });
    }
}

