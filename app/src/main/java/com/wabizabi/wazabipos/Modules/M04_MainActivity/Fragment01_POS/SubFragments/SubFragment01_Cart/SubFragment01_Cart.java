package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment01_Cart;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Activity_Main.currentFragment;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Activity_Main.pos;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment01_Cart.Adapter.RVA_Cart.cart;

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
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Fragment01_POS;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Objects.CartObject;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment01_Cart.Adapter.RVA_Cart;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment01_Cart.Interfaces.Update_Cart;
import com.wabizabi.wazabipos.R;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import io.realm.RealmList;

public class SubFragment01_Cart extends Fragment implements Update_Cart {

    TextView cartCount;
    CardView confirmBtn;
    RecyclerView cartRV;
    RecyclerView.Adapter cartRVA;
    TextView itemAllPrice, itemTax, itemFinalPrice;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag01_pos_subfrag01_cart, container, false);
        setViews(v);
        setRecyclerView();
        setContent();
        return v;
    }

    private void setViews(View v){
        cartCount = v.findViewById(R.id.POS_CartTxt);
        cartRV = v.findViewById(R.id.POS_CartRV);
        itemAllPrice = v.findViewById(R.id.POS_CartTotalPriceNo);
        itemTax = v.findViewById(R.id.POS_CartTotalTaxNo);
        itemFinalPrice = v.findViewById(R.id.POS_CartFinalNo);
        confirmBtn = v.findViewById(R.id.POS_CartCheckOutBtn);
    }

    private void setContent(){
        setCartCount();
        setPrices();
        confirmBtn.setOnClickListener((v)-> createTransaction());
    }
    private void setCartCount(){
        cartCount.setText("屋台Cart ( " + cart.size() + " )");
    }
    private void setRecyclerView(){
        LinearLayoutManager cartLayout = new LinearLayoutManager(getActivity());
        cartLayout.setOrientation(LinearLayoutManager.VERTICAL);
        cartRVA = new RVA_Cart(getActivity(), this);
        cartRV.setAdapter(cartRVA);
        cartRV.setLayoutManager(cartLayout);
    }
    private void setPrices(){
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
        itemAllPrice.setText("₱" + String.valueOf(allprice));
        itemTax.setText("₱" + String.valueOf(tax));
        itemFinalPrice.setText("₱" + String.valueOf(finalprice));
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

            DateFormat currentTime = new SimpleDateFormat("h:mm a");
            DateFormat currentMonth = new SimpleDateFormat("MMM");
            DateFormat currentDay = new SimpleDateFormat("d");
            DateFormat currentYear = new SimpleDateFormat("yyyy");
            String time = currentTime.format(new Date());
            String month = currentMonth.format(new Date());
            String day = currentDay.format(new Date());
            String year = currentYear.format(new Date());

            OpenTransactionsInstance.toCreateSalesTransaction(itemName, itemPrice, itemAmount, totalPrice, time, month, day, year);
            Toast.makeText(getActivity(), "Transaction Created!", Toast.LENGTH_SHORT).show();
            cart.clear();
            currentFragment = "POS";
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.MainActivityContainer, pos)
                    .commit();
        }
    }

    @Override
    public void refreshCart(Context context) {
        setCartCount();
        setPrices();
    }
}
