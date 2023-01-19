package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Orders;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Orders.Adapter.M04F01SF03_CartRVA.cart;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.RealmSchemas.RealmOrderDiscount;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Orders.Adapter.M04F01SF03D01_AppliedDiscountCurrentItemRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Orders.Adapter.M04F01SF03D02_SelectDiscountToApplyRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Orders.Adapter.M04F01SF03D04_ViewAppliedDiscountsRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Orders.Adapter.M04F01SF03D05_ViewItemsOfCurrentDiscountRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Orders.Adapter.M04F01SF03D06_SelectDiscountToApplyRVA;
import com.wabizabi.wazabipos.Utilities.Interfaces.DialogLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.DialogBuilder;
import com.wabizabi.wazabipos.Utilities.Objects.CartObject;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Orders.Adapter.M04F01SF03_CartRVA;
import com.wabizabi.wazabipos.Utilities.Interfaces.FragmentLoader;
import com.wabizabi.wazabipos.R;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import io.realm.Realm;
import io.realm.RealmResults;

public class M04F01SF03_Orders extends Fragment implements FragmentLoader, DialogLoader {
    //--DATABASE--//
    Realm realm = Realm.getDefaultInstance();

    //--RECYCLER VIEW--//
    RecyclerView cartRV;
    RecyclerView.Adapter cartRVA;

    //--ORDER DETAILS DISPLAY--//
    ConstraintLayout orderDetailsLayout;
    CardView selectOrderTypeBtn;
    TextView orderTypeText;
    TextView cartDiscount,
             cartTax,
             cartTotal;

    //--DG01 DISCOUNTS APPLIED ON SELECTED CART ITEM--//
    public static CartObject currentCartItem;
    Dialog orderDG01;
    TextView orderDG01_ItemName;
    RecyclerView orderDG01_RecyclerView;
    RecyclerView.Adapter orderDG01_RecyclerViewAdapter;
    CardView orderDG01_AddDiscountBtn;
    ImageView orderDG01_CloseBtn;

    //--DG02 SELECT DISCOUNTS TO APPLY ON CURRENT ITEM--//
    Dialog orderDG02;
    RecyclerView orderDG02_RecyclerView;
    RecyclerView.Adapter orderDG02_RecyclerViewAdapter;
    CardView orderDG02_ConfirmBtn;
    ImageView orderDG02_CloseBtn;

    //--DG03 SELECT ORDER TYPE--//
    String currentOrderType;
    Dialog orderDG03;
    CardView orderDG03_DineInBtn, orderDG03_TakeOutBtn, orderDG03_DeliveryBtn, orderDG03_PickUpBtn;
    ImageView orderDG03_CLoseBtn;

    //--DG04 VIEW APPLIED DISCOUNTS--//
    Dialog orderDG04;
    RecyclerView orderDG04_RecyclerView;
    RecyclerView.Adapter orderDG04_RecyclerViewAdapter;
    CardView orderDG04_AddDiscountBtn;
    ImageView orderDG04_CloseBtn;

    //--DG05 VIEW ITEMS APPLIED WITH SELECTED DISCOUNT--//
    public static String currentDiscount;
    Dialog orderDG05;
    TextView orderDG05_DiscountName;
    RecyclerView orderDG05_RecyclerView;
    RecyclerView.Adapter orderDG05_RecyclerViewAdapter;
    ImageView orderDG05_CloseBtn;

    //--DG06 SELECT DISCOUNTS TO APPLY--//
    Dialog orderDG06;
    RecyclerView orderDG06_RecyclerView;
    RecyclerView.Adapter orderDG06_RecyclerViewAdapter;
    CardView orderDG06_ApplyToAllBtn;
    ImageView orderDG06_CloseBtn;

    //--CONFIRM ORDERS BUTTON--//
    CardView ticketsBtn, chargeBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag01_pos_subfrag03_order, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        cartRV = v.findViewById(R.id.M04F01SF03_RecyclerView);
        selectOrderTypeBtn = v.findViewById(R.id.M04F01SF03_OrderTypeBtn);
        orderTypeText = v.findViewById(R.id.M04F01SF03_OrderTypeBtnTxt);
        orderDetailsLayout = v.findViewById(R.id.M04F01SF03_OrderDetailsLayout);
        cartDiscount = v.findViewById(R.id.M04F01SF03_DiscountNo);
        cartTax = v.findViewById(R.id.M04F01SF03_TaxNo);
        cartTotal = v.findViewById(R.id.M04F01SF03_TotalNo);
        ticketsBtn = v.findViewById(R.id.M04F01SF03_ManageTicketBtn);
        chargeBtn = v.findViewById(R.id.M04F01SF03_ChargeBtn);

        init_Dialogs();
        load_RecyclerView();
        load_OrderDetails();
    }

    private void load_RecyclerView(){
        LinearLayoutManager cartLayout = new LinearLayoutManager(getActivity());
        cartLayout.setOrientation(LinearLayoutManager.VERTICAL);
        cartRVA = new M04F01SF03_CartRVA(getActivity(), orderDG01, this, this);
        cartRV.setAdapter(cartRVA);
        cartRV.setLayoutManager(cartLayout);
        cartRVA.notifyDataSetChanged();

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(cartRV);
    }

    private void load_OrderDetails(){
        //--ORDER TYPE SELECTION--//
        selectOrderTypeBtn.setOnClickListener(select -> {
            load_DG03Functionalities();
            orderDG03.show();
        });

        if(currentOrderType != null){
            orderTypeText.setText(currentOrderType);
        } else {
            orderTypeText.setText("Select Order Type");
        }

        //--ORDER DETAILS--//
        orderDetailsLayout.setOnClickListener(click -> {
            load_DG04Functionalities();
            orderDG04.show();
        });

        //Calculate the discount
        double finalDiscount = 0.00; //Discount
        double finalTax = 0.00; //Tax
        double finalTotal = 0.00; //Total
        for(CartObject item : cart.keySet()){
            int quantity = cart.get(item);
            double subTotal = item.getItemPrice() * quantity;
            double tax = subTotal * 0.03;
            double total = subTotal + tax;
            int discountInPercentage = 0;
            for(Map.Entry<String, Integer> discount : item.getItemDiscounts().entrySet()){
                discountInPercentage += discount.getValue();
                Log.d("AAAAIYAAAAAAA", discount.getValue().toString());
            }
            double discountInDecimal = (double) discountInPercentage / 100;
            Log.d("AAAAIYAAAAAAA", String.valueOf(discountInDecimal));
            double discount = total * discountInDecimal;
            double finalPrice = total - discount;
            finalDiscount += discount;
            Log.d("AAAAIYAAAAAAA", String.valueOf(finalDiscount));
            finalTax += tax;
            finalTotal += finalPrice;
        }
        Log.d("AAAAIYAAAAAAA", String.valueOf(finalDiscount));
        cartDiscount.setText("₱" + new BigDecimal(finalDiscount).setScale(2, RoundingMode.HALF_UP).toString());
        cartTax.setText("₱" + new BigDecimal(finalTax).setScale(2, RoundingMode.HALF_UP).toString());
        cartTotal.setText("₱" + new BigDecimal(finalTotal).setScale(2, RoundingMode.HALF_UP).toString());
    }

    private void init_Dialogs(){
        //--DG01 SELECTED ITEM DISCOUNTS--//
        orderDG01 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag01_pos_subfrag03_order_dg01_itemdiscount);
        orderDG01_ItemName = orderDG01.findViewById(R.id.M04F01SF03D01_ItemName);
        orderDG01_RecyclerView = orderDG01.findViewById(R.id.M04F01SF03D01_DiscountsAppliedRV);
        orderDG01_AddDiscountBtn = orderDG01.findViewById(R.id.M04F01SF03D01_AddDiscountBtn);
        orderDG01_CloseBtn = orderDG01.findViewById(R.id.M04F01SF03D01_CloseDGBtn);

        //--DG02 SELECTED ITEM DISCOUNTS--//
        orderDG02 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag01_pos_subfrag03_order_dg02_itemdiscountapply);
        orderDG02_RecyclerView = orderDG02.findViewById(R.id.M04F01SF03D02_DiscountsRV);
        orderDG02_ConfirmBtn = orderDG02.findViewById(R.id.M04F01SF03D02_ConfirmBtn);
        orderDG02_CloseBtn = orderDG02.findViewById(R.id.M04F01SF03D02_CloseDGBtn);

        //--DG03 SELECT ORDER TYPE--//
        orderDG03 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag01_pos_subfrag03_order_dg03_selectordertype);
        orderDG03_DineInBtn = orderDG03.findViewById(R.id.M04F01SF03D03_DineInButton);
        orderDG03_TakeOutBtn = orderDG03.findViewById(R.id.M04F01SF03D03_TakeOutButton);
        orderDG03_DeliveryBtn = orderDG03.findViewById(R.id.M04F01SF03D03_DeliveryButton);
        orderDG03_PickUpBtn = orderDG03.findViewById(R.id.M04F01SF03D03_PickUpButton);
        orderDG03_CLoseBtn = orderDG03.findViewById(R.id.M04F01SF03D03_CloseDGBtn);

        //--DG04 VIEW APPLIED DISCOUNTS DG--//
        orderDG04 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag01_pos_subfrag03_order_dg04_discountsapplied);
        orderDG04_RecyclerView = orderDG04.findViewById(R.id.M04F01SF03D04_AppliedDiscountsRV);
        orderDG04_AddDiscountBtn = orderDG04.findViewById(R.id.M04F01SF03D04_AddDiscountBtn);
        orderDG04_CloseBtn = orderDG04.findViewById(R.id.M04F01SF03D04_CloseDGBtn);

        //--DG05 ITEMS OF CURRENT DISCOUNT DG--//
        orderDG05 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag01_pos_subfrag03_order_dg05_discountitemview);
        orderDG05_DiscountName = orderDG05.findViewById(R.id.M04F01SF03D05_DiscountName);
        orderDG05_RecyclerView = orderDG05.findViewById(R.id.M04F01SF03D05_ItemsAppliedWithSelectedDiscountRV);
        orderDG05_CloseBtn = orderDG05.findViewById(R.id.M04F01SF03D05_CloseDGBtn);

        //--DG06 SELECT DISCOUNTS TO APPLY TO ALL DG--//
        orderDG06= DialogBuilder.create(getActivity(), R.layout.act04_main_frag01_pos_subfrag03_order_dg06_discountapply);
        orderDG06_RecyclerView = orderDG06.findViewById(R.id.M04F01SF03D06_DiscountsRV);
        orderDG06_ApplyToAllBtn = orderDG06.findViewById(R.id.M04F01SF03D06_ApplyBtn);
        orderDG06_CloseBtn = orderDG06.findViewById(R.id.M04F01SF03D06_CloseDGBtn);
    }

    //DG to display the Applied Discounts to the Selected Item upon clicking an Item in the cart
    private void load_DG01Functionalities(){
        //Check if currentCartItem is not null to prevent crash
        if(currentCartItem != null){
            //Set Text
            orderDG01_ItemName.setText(currentCartItem.getItemName());

            //Initialize RecyclerView Items
            List<String> listOfDiscountsKeyset = new ArrayList<>(currentCartItem.getItemDiscounts().keySet());

            //Initialize RecyclerView
            LinearLayoutManager layout = new LinearLayoutManager(getActivity());
            layout.setOrientation(LinearLayoutManager.VERTICAL);
            orderDG01_RecyclerViewAdapter = new M04F01SF03D01_AppliedDiscountCurrentItemRVA(getActivity(), realm, currentCartItem.getItemDiscounts(), listOfDiscountsKeyset);
            orderDG01_RecyclerView.setAdapter(orderDG01_RecyclerViewAdapter);
            orderDG01_RecyclerView.setLayoutManager(layout);

            //On Apply Discount Button
            orderDG01_AddDiscountBtn.setOnClickListener(apply -> {
                load_DG02Functionalities();
                orderDG01.dismiss();
                orderDG02.show();

            });

            //On Close Button
            orderDG01_CloseBtn.setOnClickListener(close -> {
                orderDG01.dismiss();
            });
        }
    }

    //DG to display the Selectable Discounts to Apply to the Selected Item upon clicking the "Add Discount" from DG01
    private void load_DG02Functionalities(){
        //Check if currentCartItem is not null to prevent crash
        if(currentCartItem != null){
            //Initialize RecyclerView Items
            Map<String, Integer> listOfDiscounts = new TreeMap<>();
            RealmResults<RealmOrderDiscount> queriedDiscounts = realm.where(RealmOrderDiscount.class).sort("discountName").findAll();
            for(RealmOrderDiscount query : queriedDiscounts){
                if(!currentCartItem.getItemDiscounts().containsKey(query.getDiscountName())){
                    listOfDiscounts.put(query.getDiscountName(), query.getDiscountPercentage());
                }
            }
            List<String> listOfDiscountsKeyset = new ArrayList<>(listOfDiscounts.keySet());
            Map<String, Integer> listOfDiscountsToApply = new TreeMap<>();

            //Initialize RecyclerView
            LinearLayoutManager layout = new LinearLayoutManager(getActivity());
            layout.setOrientation(LinearLayoutManager.VERTICAL);
            orderDG02_RecyclerViewAdapter = new M04F01SF03D02_SelectDiscountToApplyRVA(getActivity(), realm, listOfDiscounts, listOfDiscountsKeyset, listOfDiscountsToApply);
            orderDG02_RecyclerView.setAdapter(orderDG02_RecyclerViewAdapter);
            orderDG02_RecyclerView.setLayoutManager(layout);

            //Initialize Confirm Button
            orderDG02_ConfirmBtn.setOnClickListener(confirm -> {
                if(!listOfDiscountsToApply.isEmpty()){
                    for(Map.Entry<String, Integer> discount : listOfDiscountsToApply.entrySet()){
                        currentCartItem.getItemDiscounts().put(discount.getKey(), discount.getValue());
                    }
                    cartRVA.notifyDataSetChanged();
                    load_OrderDetails();
                    load_DG01Functionalities();
                    orderDG02.dismiss();
                    orderDG01.show();
                } else {
                    Toast.makeText(getActivity(), "Please Select A Discount", Toast.LENGTH_SHORT).show();
                }
            });

            //Initialize CloseDG Button
            orderDG02_CloseBtn.setOnClickListener(close -> {
                load_DG01Functionalities();
                orderDG02.dismiss();
                orderDG01.show();
            });
        }
    }

    //DG to display the Selectable Order Types upon clicking the "Select Order Type" Button from the Cart Fragment
    private void load_DG03Functionalities(){
        //Check if currentOrderType is not null to prevent crash
        if(currentOrderType != null){
            switch(currentOrderType){
                case "Dine In":
                    orderDG03_DineInBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.green));
                    orderDG03_TakeOutBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
                    orderDG03_DeliveryBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
                    orderDG03_PickUpBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
                    break;
                case "Take Out":
                    orderDG03_DineInBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
                    orderDG03_TakeOutBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.green));
                    orderDG03_DeliveryBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
                    orderDG03_PickUpBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
                    break;
                case "Delivery":
                    orderDG03_DineInBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
                    orderDG03_TakeOutBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
                    orderDG03_DeliveryBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.green));
                    orderDG03_PickUpBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
                    break;
                case "Pick Up":
                    orderDG03_DineInBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
                    orderDG03_TakeOutBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
                    orderDG03_DeliveryBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
                    orderDG03_PickUpBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.green));
                    break;
            }
        }

        orderDG03_DineInBtn.setOnClickListener(di -> {
            currentOrderType = "Dine In";
            load_OrderDetails();
            orderDG03.dismiss();
        });

        orderDG03_TakeOutBtn.setOnClickListener(to -> {
            currentOrderType = "Take Out";
            load_OrderDetails();
            orderDG03.dismiss();

        });

        orderDG03_DeliveryBtn.setOnClickListener(dv -> {
            currentOrderType = "Delivery";
            load_OrderDetails();
            orderDG03.dismiss();
        });

        orderDG03_PickUpBtn.setOnClickListener(pu -> {
            currentOrderType = "Pick Up";
            load_OrderDetails();
            orderDG03.dismiss();
        });

        orderDG03_CLoseBtn.setOnClickListener(close -> {
            orderDG03.dismiss();
        });
    }

    //DG to display the Discounts Applied and their items upon clicking
    private void load_DG04Functionalities(){
        //Initialize RecyclerView Items
        Map<String, Integer> listOfDiscountsApplied = new TreeMap<>();
        for(CartObject cartItem : cart.keySet()){
            Map<String, Integer> discountsWithinTheItem = cartItem.getItemDiscounts();
            if(!discountsWithinTheItem.isEmpty()){
                for(Map.Entry<String, Integer> discount : discountsWithinTheItem.entrySet()){
                    if(listOfDiscountsApplied.containsKey(discount.getKey())){
                        listOfDiscountsApplied.put(discount.getKey(),  listOfDiscountsApplied.get(discount.getKey())+ 1);
                    } else {
                        listOfDiscountsApplied.put(discount.getKey(), 1);
                    }
                }
            }
        }
        List<String> listOfDiscountsAppliedKeyset = new ArrayList<>(listOfDiscountsApplied.keySet());

        //Initialize RecyclerView
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        orderDG04_RecyclerViewAdapter = new M04F01SF03D04_ViewAppliedDiscountsRVA(getActivity(), realm, orderDG04, listOfDiscountsApplied, listOfDiscountsAppliedKeyset, this, this);
        orderDG04_RecyclerView.setAdapter(orderDG04_RecyclerViewAdapter);
        orderDG04_RecyclerView.setLayoutManager(layout);

        //On Click Add Discount Btn
        orderDG04_AddDiscountBtn.setOnClickListener(add -> {
            load_DG06Functionalities();
            orderDG04.dismiss();
            orderDG06.show();
        });

        //On Close Button
        orderDG04_CloseBtn.setOnClickListener(close -> {
            orderDG04.dismiss();
        });
    }

    //DG to display the Items Applied with the Selected Discount
    private void load_DG05Functionalities(){
        //check if currentDiscount if null to prevent crash
        if(currentDiscount != null){
            //Set Discount Name
            orderDG05_DiscountName.setText(currentDiscount);

            //Initialize RecyclerView Items
            List<CartObject> itemsAppliedWithCurrentDiscount = new ArrayList<>();
            for(CartObject cartItem : cart.keySet()){
                if(cartItem.getItemDiscounts().containsKey(currentDiscount)){
                    itemsAppliedWithCurrentDiscount.add(cartItem);
                }
            }

            //Initialize RecyclerView
            LinearLayoutManager layout = new LinearLayoutManager(getActivity());
            layout.setOrientation(LinearLayoutManager.VERTICAL);
            orderDG05_RecyclerViewAdapter = new M04F01SF03D05_ViewItemsOfCurrentDiscountRVA(getActivity(), realm, itemsAppliedWithCurrentDiscount, this);
            orderDG05_RecyclerView.setAdapter(orderDG05_RecyclerViewAdapter);
            orderDG05_RecyclerView.setLayoutManager(layout);

            //On Close
            orderDG05_CloseBtn.setOnClickListener(close -> {
                load_DG04Functionalities();
                orderDG05.dismiss();
                orderDG04.show();
            });
        }
    }

    //DG to display the Selectable Discounts to Apply to All Items
    private void load_DG06Functionalities(){
        //Initialize RecyclerView Items
        Map<String, Integer> listOfDiscounts = new TreeMap<>();
        RealmResults<RealmOrderDiscount> queriedDiscounts = realm.where(RealmOrderDiscount.class).sort("discountName").findAll();
        for(RealmOrderDiscount query : queriedDiscounts){
            listOfDiscounts.put(query.getDiscountName(), query.getDiscountPercentage());
        }
        List<String> listOfDiscountsKeyset = new ArrayList<>(listOfDiscounts.keySet());
        Map<String, Integer> listOfDiscountsToApply = new TreeMap<>();

        //Initialize RecyclerView
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        orderDG06_RecyclerViewAdapter = new M04F01SF03D06_SelectDiscountToApplyRVA(getActivity(), realm, listOfDiscounts, listOfDiscountsKeyset, listOfDiscountsToApply);
        orderDG06_RecyclerView.setAdapter(orderDG06_RecyclerViewAdapter);
        orderDG06_RecyclerView.setLayoutManager(layout);

        //Initialize Confirm Button
        orderDG06_ApplyToAllBtn.setOnClickListener(confirm -> {
            if(!listOfDiscountsToApply.isEmpty()){
                for(Map.Entry<String, Integer> discount : listOfDiscountsToApply.entrySet()){
                    for(CartObject item : cart.keySet()){
                        item.getItemDiscounts().put(discount.getKey(), discount.getValue());
                    }
                }
                cartRVA.notifyDataSetChanged();
                load_OrderDetails();
                load_DG04Functionalities();
                orderDG06.dismiss();
                orderDG04.show();
            } else {
                Toast.makeText(getActivity(), "Please Select A Discount", Toast.LENGTH_SHORT).show();
            }
        });

        //Initialize CloseDG Button
        orderDG06_CloseBtn.setOnClickListener(close -> {
            load_DG04Functionalities();
            orderDG06.dismiss();
            orderDG04.show();
        });

    }
    //--INTERFACES--//

    @Override
    public void load_FGContents() {
        cartRVA.notifyDataSetChanged();
        load_OrderDetails();
    }

    @Override
    public void load_DGContents(int dialogNo) {
        switch(dialogNo){
            case 1:
                load_DG01Functionalities();
                orderDG01.show();
                break;
            case 2:
                load_DG02Functionalities();
                orderDG02.show();
                break;
            case 3:
                load_DG03Functionalities();
                orderDG03.show();
                break;
            case 4:
                load_DG04Functionalities();
                orderDG04.show();
                break;
            case 5:
                load_DG05Functionalities();
                orderDG05.show();
                break;
            case 6:
                load_DG06Functionalities();
                orderDG06.show();
                break;
        }
    }

    //--SLIDE TO DELETE--//
    ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
            //Remove swiped item from list and notify the RecyclerView
            int position = viewHolder.getAdapterPosition();
            List<CartObject> items = new ArrayList<>(cart.keySet());
            CartObject item = items.get(position);
            cart.remove(item);
            cartRVA.notifyDataSetChanged();
            load_OrderDetails();

        }
    };

    //--UNUSED OVERLOADED INTERFACES--//

    @Override
    public void load_DGContents() {}
    @Override
    public void load_DGContents(int image, String name, double price) {}



}

//TO DO LIST
//1. DG View Items applied with the selected Discount
//2. DG Select Discount To Add
//3. DG Select Item To Apply
//4. Order Detail
//5. DG Select Table
//6. DG Enter Customer Detail
//7. DG Manage Ticket
//8. DG Charge
//9. DG Receipt