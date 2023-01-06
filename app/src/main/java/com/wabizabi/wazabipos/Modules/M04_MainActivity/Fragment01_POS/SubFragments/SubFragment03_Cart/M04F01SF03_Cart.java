package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.M04_Main.currentFragment;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.M04F01SF03_CartRVA.cart;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.M04_Main.pos_cart;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.Instances.OpenTransactionsInstance;
import com.wabizabi.wazabipos.Utilities.Objects.CartObject;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.M04F01SF03_CartRVA;
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
    public static List<Double> discountApplied;
    CardView discountBtn;
    TextView discountText;
    //--ORDER DETAILS--//
    TextView cartTotal, cartTax, cartFinal;
    //--CONFIRM ORDERS BUTTON--//
    CardView confirmOrdersBtn;
    //--CONFIRMATION DIALOG--//
    Dialog confirmOrdersDG;
    CardView yesBtn, noBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag01_pos_subfrag03_cart, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        cartRV = v.findViewById(R.id.M04F01SF03_RecyclerView);
        cartTotal = v.findViewById(R.id.M04F01SF03_TotalNo);
        cartTax = v.findViewById(R.id.M04F01SF03_TaxNo);
        cartFinal = v.findViewById(R.id.M04F01SF03_FinalNo);
        discountBtn = v.findViewById(R.id.M04F01SF03_DiscountDisplay);
        discountText = v.findViewById(R.id.M04F01SF03_DiscountDisplayText);
        confirmOrdersBtn = v.findViewById(R.id.M04F01SF03_CheckOutBtn);

        init_Dialogs();
        load_RecyclerView();
        load_OrderDetails();
        load_Buttons();
    }

    private void init_Dialogs(){
        confirmOrdersDG = new Dialog(getActivity());
        confirmOrdersDG.setContentView(R.layout.act04_main_frag01_pos_subfrag03_cart_dg_confirmorder);
        confirmOrdersDG.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        yesBtn = confirmOrdersBtn.findViewById(R.id.M04F01SF03D_YesBtn);
        noBtn = confirmOrdersBtn.findViewById(R.id.M04F01SF03D_NoBtn);

        yesBtn.setOnClickListener(yes -> {
            if(!cart.isEmpty()){
                //Collect the items in the cart as a table by using lists
                double sumOfAllPrices = 0;
                List<String> itemName = new ArrayList<>();
                List<Double> itemPrice = new ArrayList<>();
                List<Integer> itemAmount = new ArrayList<>();
                for(Map.Entry<CartObject, Integer> cartItem : cart.entrySet()){
                    CartObject item = cartItem.getKey();
                    int qty = cartItem.getValue();
                    itemName.add(item.getItemName());
                    itemPrice.add(item.getItemPrice());
                    itemAmount.add(qty);
                    sumOfAllPrices = sumOfAllPrices + item.getItemPrice() * qty;
                }

                //Calculates all the discount that is applied
                double discount = 0.00;
                if(!discountApplied.isEmpty()){
                    for(Double percent : discountApplied){
                        discount = discount + percent;
                    }
                }

                //Calculates the final price of the transaction
                double totalPrice = sumOfAllPrices * 0.03 - discount;

                //Saves the transaction in the Database
                OpenTransactionsInstance.toCreateSales(itemName, itemPrice, itemAmount, totalPrice);
                Toast.makeText(getActivity(), "Transaction Created!", Toast.LENGTH_SHORT).show();
                cart.clear();
                currentFragment = "POS";
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.MainActivityContainer, pos_cart)
                        .commit();

            } else {
                //Closes the dialog and displays the error message.
                confirmOrdersDG.dismiss();
                Toast.makeText(getActivity(), "Cart is Empty", Toast.LENGTH_SHORT).show();
            }
        });

        noBtn.setOnClickListener(no -> {
            //Closes the dialog
            confirmOrdersDG.dismiss();
        });
    }

    private void load_RecyclerView(){
        LinearLayoutManager cartLayout = new LinearLayoutManager(getActivity());
        cartLayout.setOrientation(LinearLayoutManager.VERTICAL);
        cartRVA = new M04F01SF03_CartRVA(getActivity(), this);
        cartRV.setAdapter(cartRVA);
        cartRV.setLayoutManager(cartLayout);
    }

    private void load_OrderDetails(){
        double discount = 0.00;
        if(discountApplied.isEmpty()){
            discountText.setText("+");
            discountText.setGravity(Gravity.CENTER);
        } else {
            for(Double percent : discountApplied){
                discount = discount + percent;
            }
            String discountInPercentage = String.valueOf((int) discount * 100);
            discountText.setText(discountInPercentage + "%");
            discountText.setGravity(Gravity.END);
        }

        double allprice = 0.00;
        for(Map.Entry<CartObject, Integer> basket : cart.entrySet()){
            CartObject item = basket.getKey();
            int quantity = basket.getValue();
            double individualprice = item.getItemPrice();
            double product = individualprice * quantity;
            allprice = allprice + product;
        }
        double tax = allprice * 0.03;
        double finalprice = allprice + tax - discount;
        cartTotal.setText("₱" + allprice);
        cartTax.setText("₱" + tax);
        cartFinal.setText("₱" + finalprice);
    }

    private void load_Buttons(){
        confirmOrdersBtn.setOnClickListener(confirm -> {
            confirmOrdersDG.show();
        });
    }

    @Override
    public void refreshCart(Context context) {
        load_OrderDetails();
    }

    ItemTouchHelper.SimpleCallback swipeToDelete = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
           return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            cart.remove(viewHolder.getAdapterPosition());
            cartRVA.notifyDataSetChanged();
        }
    };
}
