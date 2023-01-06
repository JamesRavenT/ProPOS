package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.M04_Main.currentFragment;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.RVA_Cart.cart;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.M04_Main.pos_cart;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.Instances.OpenTransactionsInstance;
import com.wabizabi.wazabipos.Utilities.Objects.CartObject;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.RVA_Cart;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Interfaces.Update_Cart;
import com.wabizabi.wazabipos.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class M04F01SF03_Cart extends Fragment implements Update_Cart {
    //--RECYCLER VIEW--//
    RecyclerView cartRV;
    RecyclerView.Adapter cartRVA;
    //--DISCOUNT DISPLAY--//
    CardView discountBtn;
    TextView discountText;
    //--ORDER DETAILS--//
    TextView cartTotalPrice, cartTax, cartFinal;
    //--CONFIRM ORDERS BUTTON--//
    CardView confirmOrdersBtn;
    //--CONFIRMATION DIALOG--//
    Dialog confirmOrdersDG;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag01_pos_subfrag01_cart, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        cartRV = v.findViewById(R.id.M04F01SF03_RecyclerView);
        cartTotalPrice = v.findViewById(R.id.M04F01SF03_TotalNo);
        cartTax = v.findViewById(R.id.M04F01SF03_TaxNo);
        cartFinal = v.findViewById(R.id.M04F01SF03_FinalNo);
        confirmOrdersBtn = v.findViewById(R.id.M04F01SF03_CheckOutBtn);

        init_Dialogs();
        load_RecyclerView();
        load_OrderDetails();
        load_Buttons();

    }

    private void init_Dialogs(){
        confirmOrdersDG = new Dialog(getActivity());


    }

    private void load_RecyclerView(){
        LinearLayoutManager cartLayout = new LinearLayoutManager(getActivity());
        cartLayout.setOrientation(LinearLayoutManager.VERTICAL);
        cartRVA = new RVA_Cart(getActivity(), this);
        cartRV.setAdapter(cartRVA);
        cartRV.setLayoutManager(cartLayout);
    }

    private void load_OrderDetails(){
        double allprice = 0.00;
        for(Map.Entry<CartObject, Integer> basket : cart.entrySet()){
            CartObject item = basket.getKey();
            int quantity = basket.getValue();
            double individualprice = item.getItemPrice();
            double product = individualprice * quantity;
            allprice = allprice + product;
        }

        double tax = allprice * 0.03;
        double finalprice = allprice + tax;
        cartTotalPrice.setText("₱" + allprice);
        cartTax.setText("₱" + tax);
        cartFinal.setText("₱" + finalprice);
    }

    private void load_Buttons(){
        confirmOrdersBtn.setOnClickListener(confirm -> {
            confirmOrdersDG.show();
        });
    }

    private void createTransaction(){
        if(!cart.isEmpty()){
            List<String> itemName = new ArrayList<>();
            List<Double> itemPrice = new ArrayList<>();
            List<Integer> itemAmount = new ArrayList<>();
            double sumOfAllPrices = 0;

            for(Map.Entry<CartObject, Integer> cartItem : cart.entrySet()){
                CartObject item = cartItem.getKey();
                int qty = cartItem.getValue();
                itemName.add(item.getItemName());
                itemPrice.add(item.getItemPrice());
                itemAmount.add(qty);

                sumOfAllPrices = sumOfAllPrices + item.getItemPrice() * qty;
            }
            double totalPrice = sumOfAllPrices * 0.03;

            OpenTransactionsInstance.toCreateSales(itemName, itemPrice, itemAmount, totalPrice);
            Toast.makeText(getActivity(), "Transaction Created!", Toast.LENGTH_SHORT).show();
            cart.clear();
            currentFragment = "POS";
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.MainActivityContainer, pos_cart)
                    .commit();
        }
    }

    @Override
    public void refreshCart(Context context) {
        load_OrderDetails();
    }
}
