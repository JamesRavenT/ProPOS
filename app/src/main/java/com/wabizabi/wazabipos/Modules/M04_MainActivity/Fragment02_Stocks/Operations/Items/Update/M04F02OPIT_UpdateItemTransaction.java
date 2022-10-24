package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.Items.Update;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.M04F02_Stocks.M04F02_CurrentItem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.wabizabi.wazabipos.Database.Instances.OpenStocksInstance;
import com.wabizabi.wazabipos.Database.Instances.OpenTransactionsInstance;
import com.wabizabi.wazabipos.Database.Schemas.StockItem;
import com.wabizabi.wazabipos.R;

import io.realm.Realm;

public class M04F02OPIT_UpdateItemTransaction extends Fragment {
    int itemAmount, stockIn, stockOut;
    String itemUnit;
    Realm realm;
    ImageView itemImage;
    TextView itemName, itemQty, stockInQty, stockOutQty;
    ImageButton stockInSubBtn, stockInAddBtn, stockOutSubBtn, stockOutAddBtn;
    CardView confirmTransaction;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag02_stocks_operation_crud_itemupdateinventory, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        init_Views(v);
        init_DB();
        init_ItemDetails();
        init_Buttons();
        init_Transaction();
    }

    private void init_Views(View v){
        itemImage = v.findViewById(R.id.M04F02OPIT_ItemImage);
        itemName = v.findViewById(R.id.M04F02OPIT_ItemName);
        itemQty = v.findViewById(R.id.M04F02OPIT_ItemQty);
        stockInSubBtn = v.findViewById(R.id.M04F02OPIT_StockInQtySubBtn);
        stockInQty = v.findViewById(R.id.M04F02OPIT_StockInQty);
        stockInAddBtn = v.findViewById(R.id.M04F02OPIT_StockInQtyAddBtn);
        stockOutSubBtn = v.findViewById(R.id.M04F02OPIT_StockOutQtySubBtn);
        stockOutQty = v.findViewById(R.id.M04F02OPIT_StockOutQty);
        stockOutAddBtn = v.findViewById(R.id.M04F02OPIT_StockOutQtyAddBtn);
        confirmTransaction = v.findViewById(R.id.M04F02OPIT_ConfirmTransactionButton);
    }

    private void init_DB(){
        realm = Realm.getDefaultInstance();
    }

    private void init_ItemDetails(){
        StockItem item = realm.where(StockItem.class).equalTo("itemName", M04F02_CurrentItem).findFirst();
        itemUnit = item.getItemUnit();
        itemAmount = item.getItemAmount();
        itemName.setText(item.getItemName());
        itemQty.setText(item.getItemAmount() + " " + item.getItemUnit());
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
        stockInQty.setText(String.valueOf(stockIn));
        stockOutQty.setText(String.valueOf(stockOut));
    }

    private void init_Buttons(){
        stockInSubBtn.setOnClickListener(v -> {
            if(stockIn != 0){
                stockIn--;
                stockInQty.setText(String.valueOf(stockIn));
            }
        });
        stockInAddBtn.setOnClickListener(v -> {
            if(stockOut == 0){
                stockIn++;
                stockInQty.setText(String.valueOf(stockIn));
            } else {
                Toast.makeText(getActivity(),"Please choose only one process", Toast.LENGTH_SHORT).show();
            }
        });

        stockOutSubBtn.setOnClickListener(v -> {
            if(stockOut != 0){
                stockOut--;
                stockOutQty.setText(String.valueOf(stockOut));
            }
        });

        stockOutAddBtn.setOnClickListener(v -> {
            if(stockIn == 0){
                stockOut++;
                stockOutQty.setText(String.valueOf(stockOut));
            } else {
                Toast.makeText(getActivity(),"Please choose only one process", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init_Transaction(){
        confirmTransaction.setOnClickListener(v -> {
            if(stockIn != 0 || stockOut != 0){
                OpenTransactionsInstance.toUpdateInventory("Update", M04F02_CurrentItem, stockIn, stockOut, itemUnit);
                if(stockIn != 0){
                    OpenStocksInstance.toStockIn(stockIn);
                    stockIn = 0;
                    Toast.makeText(getActivity(), "Success!", Toast.LENGTH_SHORT).show();
                    getActivity().finish();
                }
                else if(stockOut != 0) {
                    if(itemAmount > stockOut){
                        OpenStocksInstance.toStockOut(stockOut);
                        stockOut = 0;
                        Toast.makeText(getActivity(), "Success!", Toast.LENGTH_SHORT).show();
                        getActivity().finish();
                    } else {
                        Toast.makeText(getActivity(), "Stock Out can't be greater than current amount", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
