package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.Items.Read;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.M04F02_Stocks.M04F02_CurrentItem;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.Items.Read.Adapter.M04F02OPIR_ReadItemRVA.listOfAssociatedStockTransactions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.RealmSchemas.StockItem;
import com.wabizabi.wazabipos.Database.RealmSchemas.InventoryTransaction;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.Items.Read.Adapter.M04F02OPIR_ReadItemRVA;
import com.wabizabi.wazabipos.R;

import io.realm.Realm;

public class M04F02OPIR_ReadItem extends Fragment {
    Realm realm;
    ImageView itemImage;
    TextView itemName;
    RecyclerView transactionsRV;
    RecyclerView.Adapter transactionsRVA;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag02_stocks_operation_crud_itemread, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        init_Views(v);
        init_DB();
        init_ItemDetails();
        init_RecyclerView();
    }

    private void init_Views(View v){
        itemImage = v.findViewById(R.id.M04F02OPIR_ItemImage);
        itemName = v.findViewById(R.id.M04F02OPIR_ItemName);
        transactionsRV = v.findViewById(R.id.M04F02OPIR_TransactionsRV);
    }

    private void init_DB(){
        realm = Realm.getDefaultInstance();
    }

    private void init_ItemDetails(){
        StockItem item = realm.where(StockItem.class).equalTo("itemName", M04F02_CurrentItem).findFirst();
        itemName.setText(item.getItemName());
        switch(item.getItemImage()){
            case 0:
                itemImage.setImageResource(R.drawable.icon_stocks00_default);
                break;
            case 1:
                itemImage.setImageResource(R.drawable.icon_stocks01_meat);
                break;
            case 2:
                itemImage.setImageResource(R.drawable.icon_stocks02_fish);
                break;
            case 3:
                itemImage.setImageResource(R.drawable.icon_stocks03_fruit);
                break;
            case 4:
                itemImage.setImageResource(R.drawable.icon_stocks04_vegetable);
                break;
            case 5:
                itemImage.setImageResource(R.drawable.icon_stocks05_grains);
                break;
            case 6:
                itemImage.setImageResource(R.drawable.icon_stocks06_spices);
                break;
            case 7:
                itemImage.setImageResource(R.drawable.icon_stocks07_japanese);
                break;
        }

    }

    private void init_RecyclerView(){
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        listOfAssociatedStockTransactions = realm.where(InventoryTransaction.class).equalTo("itemName", M04F02_CurrentItem).findAll();
        transactionsRVA = new M04F02OPIR_ReadItemRVA(realm, getActivity());
        transactionsRV.setLayoutManager(layout);
        transactionsRV.setAdapter(transactionsRVA);
    }
}

