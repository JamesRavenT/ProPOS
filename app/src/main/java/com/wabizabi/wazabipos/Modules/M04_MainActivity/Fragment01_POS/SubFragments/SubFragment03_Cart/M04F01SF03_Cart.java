package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.M04F01SF03_CartRVA.cart;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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

import com.wabizabi.wazabipos.Database.Instances.OpenTableInstance;
import com.wabizabi.wazabipos.Database.Instances.OpenTicketInstance;
import com.wabizabi.wazabipos.Database.ObjectSchemas.Table;
import com.wabizabi.wazabipos.Database.ObjectSchemas.Ticket;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmDiscount;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmTable;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmTicket;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmUser;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.M04F01SF03D01_AppliedDiscountCurrentItemRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.M04F01SF03D02_SelectDiscountToApplyRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.M04F01SF03D04_ViewAppliedDiscountsRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.M04F01SF03D05_ViewItemsOfCurrentDiscountRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.M04F01SF03D06_SelectDiscountToApplyRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.M04F01SF03D07_SelectTableRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.M04F01SF03D09_SaveTicketRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.M04F01SF03D10_ManageTicketRVA;
import com.wabizabi.wazabipos.Utilities.Interfaces.DialogLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.DialogBuilder;
import com.wabizabi.wazabipos.Utilities.Libraries.ToastMessage;
import com.wabizabi.wazabipos.Utilities.Objects.CartObject;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.M04F01SF03_CartRVA;
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

public class M04F01SF03_Cart extends Fragment implements FragmentLoader, DialogLoader {
    //--DATABASE--//
    Realm realm = Realm.getDefaultInstance();

    //--RECYCLER VIEW--//
    RecyclerView cartRV;
    RecyclerView.Adapter cartRVA;

    //--ORDER DETAILS DISPLAY--//
    public static Ticket currentCartTicket = null;
    ConstraintLayout orderDetailsLayout;
    CardView selectOrderTypeBtn;
    TextView orderTypeText;
    TextView cartDiscount,
             cartTax,
             cartTotal;
    CardView saveTicketBtn;
    TextView saveTicketBtnTxt;
    CardView ticketsBtn;
    TextView ticketsBtnTxt;
    CardView chargeBtn;

    //--DG01 DISCOUNTS APPLIED ON SELECTED CART ITEM--//
    public static CartObject currentCartItem;
    Dialog cartDG01;
    TextView cartDG01_ItemName;
    RecyclerView cartDG01_RecyclerView;
    RecyclerView.Adapter cartDG01_RecyclerViewAdapter;
    CardView cartDG01_AddDiscountBtn;
    ImageView cartDG01_CloseBtn;

    //--DG02 SELECT DISCOUNTS TO APPLY ON CURRENT ITEM--//
    Dialog cartDG02;
    RecyclerView cartDG02_RecyclerView;
    RecyclerView.Adapter cartDG02_RecyclerViewAdapter;
    CardView cartDG02_ConfirmBtn;
    ImageView cartDG02_CloseBtn;

    //--DG03 SELECT ORDER TYPE--//
    public static String currentCartOrderType;
    Dialog cartDG03;
    CardView cartDG03_DineInBtn,
             cartDG03_TakeOutBtn,
             cartDG03_DeliveryBtn,
             cartDG03_PickUpBtn;
    ImageView cartDG03_CLoseBtn;

    //--DG04 VIEW APPLIED DISCOUNTS--//
    Dialog cartDG04;
    RecyclerView cartDG04_RecyclerView;
    RecyclerView.Adapter cartDG04_RecyclerViewAdapter;
    CardView cartDG04_AddDiscountBtn;
    ImageView cartDG04_CloseBtn;

    //--DG05 VIEW ITEMS APPLIED WITH SELECTED DISCOUNT--//
    Dialog cartDG05;
    TextView cartDG05_DiscountName;
    RecyclerView cartDG05_RecyclerView;
    RecyclerView.Adapter cartDG05_RecyclerViewAdapter;
    ImageView cartDG05_CloseBtn;

    //--DG06 SELECT DISCOUNTS TO APPLY--//
    Dialog cartDG06;
    RecyclerView cartDG06_RecyclerView;
    RecyclerView.Adapter cartDG06_RecyclerViewAdapter;
    CardView cartDG06_ApplyToAllBtn;
    ImageView cartDG06_CloseBtn;

    //--DG07 SELECT TABLE--//
    public static Table currentCartTable = null;
    Dialog cartDG07;
    RecyclerView cartDG07_RecyclerView;
    RecyclerView.Adapter cartDG07_RecyclerViewAdapter;
    CardView cartDG07_ConfirmBtn;
    ImageView cartDG07_CloseBtn;

    //--DG08 ENTER DETAILS--//
    public static String currentCartCustomer = "N/A";
    public static String currentCartCustomerDetails;
    Dialog cartDG08;
    EditText cartDG08_NameInput,
             cartDG08_DetailInput;
    CardView cartDG08_ConfirmBtn;
    ImageView cartDG08_CloseBtn;

    //--DG09 CONFIRM TO SAVE--//
    Dialog cartDG09;
    TextView cartDG09_OrderType,
             cartDG09_TableCustomerDetail,
             cartDG09_Cashier,
             cartDG09_OrderDetails;
    RecyclerView cartDG09_RecyclerView;
    RecyclerView.Adapter cartDG09_RecyclerViewAdapter;
    TextView cartDG09_Discount,
             cartDG09_Tax,
             cartDG09_Total;
    CardView cartDG09_YesBtn, cartDG09_NoBtn;
    ImageView cartDG09_CloseBtn;

    //--DG10 MANAGE TICKETS--//
    Dialog cartDG10;
    TextView cartDG10_TicketCount;
    CardView cartDG10_DineInBtn,
             cartDG10_TakeOutBtn,
             cartDG10_DeliveryBtn,
             cartDG10_PickUpBtn;
    RecyclerView cartDG10_RecyclerView;
    RecyclerView.Adapter cartDG10_RecyclerViewAdapter;
    ImageView cartDG10_CloseBtn;

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
        saveTicketBtn = v.findViewById(R.id.M04F01SF03_SaveTicketBtn);
        saveTicketBtnTxt = v.findViewById(R.id.M04F01SF03_SaveTicketBtnText);
        ticketsBtn = v.findViewById(R.id.M04F01SF03_ManageTicketBtn);
        ticketsBtnTxt = v.findViewById(R.id.M04F01SF03_ManageTicketBtnText);
        chargeBtn = v.findViewById(R.id.M04F01SF03_ChargeBtn);

        init_Dialogs();
        load_RecyclerView();
        load_OrderDetails();
    }

    private void load_RecyclerView(){
        LinearLayoutManager cartLayout = new LinearLayoutManager(getActivity());
        cartLayout.setOrientation(LinearLayoutManager.VERTICAL);
        cartRVA = new M04F01SF03_CartRVA(getActivity(), cartDG01, this, this);
        cartRV.setAdapter(cartRVA);
        cartRV.setLayoutManager(cartLayout);
        cartRVA.notifyDataSetChanged();

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(cartRV);
    }

    private void load_OrderDetails(){
        //--ORDER TYPE SELECTION--//
        selectOrderTypeBtn.setOnClickListener(select -> {
            if (currentCartTicket == null) {
                load_DG03Functionalities();
                cartDG03.show();
            }
        });

        if(currentCartOrderType != null){
            orderTypeText.setText(currentCartOrderType);
        } else if(currentCartTicket != null) {
            orderTypeText.setText(currentCartTicket.getTableName() + " " + currentCartTicket.getTableName() + " - " + currentCartTicket.getOrderType());
        } else {
            orderTypeText.setText("Select Order Type");
        }

        //--ORDER DETAILS--//
        orderDetailsLayout.setOnClickListener(click -> {
            load_DG04Functionalities();
            cartDG04.show();
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
            }
            double discountInDecimal = (double) discountInPercentage / 100;
            double discount = total * discountInDecimal;
            double finalPrice = total - discount;
            finalDiscount += discount;
            finalTax += tax;
            finalTotal += finalPrice;
        }
        cartDiscount.setText("₱" + new BigDecimal(finalDiscount).setScale(2, RoundingMode.HALF_UP).toString());
        cartTax.setText("₱" + new BigDecimal(finalTax).setScale(2, RoundingMode.HALF_UP).toString());
        cartTotal.setText("₱" + new BigDecimal(finalTotal).setScale(2, RoundingMode.HALF_UP).toString());

        //--TICKET AND CHARGE SECTION--//
        if(currentCartTicket != null) {
            //Save Ticket Btn
            saveTicketBtn.setOnClickListener(print -> {
                ToastMessage.show(getActivity(), "Printed!");
            });
            //Save Ticket Text
            if(currentCartTicket != null){
                saveTicketBtnTxt.setText("Print Ticket");
            } else {
                saveTicketBtnTxt.setText("Save Ticket");
            }

        }

        if(currentCartOrderType != null){
            //Save Ticket Button
            saveTicketBtn.setOnClickListener(save -> {
                if(currentCartOrderType.equals("Dine In") || currentCartOrderType.equals("Take Out")) {
                    load_DG07Functionalities();
                    cartDG07.show();
                } else if(currentCartOrderType.equals("Delivery") || currentCartOrderType.equals("Pick Up")) {
                    load_DG08Functionalities();
                    cartDG08.show();
                }  else {
                    ToastMessage.show(getActivity(), "Please Select an Order Type");
                }
            });

        } else {
            saveTicketBtn.setOnClickListener(error -> {
                ToastMessage.show(getActivity(), "Please Select an Order Type");
            });
        }

        //ManageTickets
        ticketsBtn.setOnClickListener(tickets -> {
            if(currentCartTicket != null){
                cart.clear();
                cartRVA.notifyDataSetChanged();
                currentCartTicket = null;
                load_OrderDetails();
            } else {
                load_DG10Functionalities();
                cartDG10.show();
            }
        });

        //Ticket Counter
        RealmResults<RealmTicket> tickets = realm.where(RealmTicket.class).findAll();
        if(currentCartTicket != null) {
            ticketsBtnTxt.setText("Unload Ticket");
        } else if(!tickets.isEmpty()){
            ticketsBtnTxt.setText("Tickets [" + tickets.size() + "]");
        } else {
            ticketsBtnTxt.setText("Tickets [0]");
        }

    }

    private void init_Dialogs(){
        //--DG01 SELECTED ITEM DISCOUNTS--//
        cartDG01 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag01_pos_subfrag03_order_dg01_itemdiscount);
        cartDG01_ItemName = cartDG01.findViewById(R.id.M04F01SF03D01_ItemName);
        cartDG01_RecyclerView = cartDG01.findViewById(R.id.M04F01SF03D01_DiscountsAppliedRV);
        cartDG01_AddDiscountBtn = cartDG01.findViewById(R.id.M04F01SF03D01_AddDiscountBtn);
        cartDG01_CloseBtn = cartDG01.findViewById(R.id.M04F01SF03D01_CloseDGBtn);

        //--DG02 SELECTED ITEM DISCOUNTS--//
        cartDG02 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag01_pos_subfrag03_order_dg02_itemdiscountapply);
        cartDG02_RecyclerView = cartDG02.findViewById(R.id.M04F01SF03D02_DiscountsRV);
        cartDG02_ConfirmBtn = cartDG02.findViewById(R.id.M04F01SF03D02_ConfirmBtn);
        cartDG02_CloseBtn = cartDG02.findViewById(R.id.M04F01SF03D02_CloseDGBtn);

        //--DG03 SELECT ORDER TYPE--//
        cartDG03 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag01_pos_subfrag03_order_dg03_selectordertype);
        cartDG03_DineInBtn = cartDG03.findViewById(R.id.M04F01SF03D03_DineInButton);
        cartDG03_TakeOutBtn = cartDG03.findViewById(R.id.M04F01SF03D03_TakeOutButton);
        cartDG03_DeliveryBtn = cartDG03.findViewById(R.id.M04F01SF03D03_DeliveryButton);
        cartDG03_PickUpBtn = cartDG03.findViewById(R.id.M04F01SF03D03_PickUpButton);
        cartDG03_CLoseBtn = cartDG03.findViewById(R.id.M04F01SF03D03_CloseDGBtn);

        //--DG04 VIEW APPLIED DISCOUNTS DG--//
        cartDG04 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag01_pos_subfrag03_order_dg04_discountsapplied);
        cartDG04_RecyclerView = cartDG04.findViewById(R.id.M04F01SF03D04_AppliedDiscountsRV);
        cartDG04_AddDiscountBtn = cartDG04.findViewById(R.id.M04F01SF03D04_AddDiscountBtn);
        cartDG04_CloseBtn = cartDG04.findViewById(R.id.M04F01SF03D04_CloseDGBtn);

        //--DG05 ITEMS OF CURRENT DISCOUNT DG--//
        cartDG05 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag01_pos_subfrag03_order_dg05_discountitemview);
        cartDG05_DiscountName = cartDG05.findViewById(R.id.M04F01SF03D05_DiscountName);
        cartDG05_RecyclerView = cartDG05.findViewById(R.id.M04F01SF03D05_ItemsAppliedWithSelectedDiscountRV);
        cartDG05_CloseBtn = cartDG05.findViewById(R.id.M04F01SF03D05_CloseDGBtn);

        //--DG06 SELECT DISCOUNTS TO APPLY TO ALL DG--//
        cartDG06= DialogBuilder.create(getActivity(), R.layout.act04_main_frag01_pos_subfrag03_order_dg06_discountapply);
        cartDG06_RecyclerView = cartDG06.findViewById(R.id.M04F01SF03D06_DiscountsRV);
        cartDG06_ApplyToAllBtn = cartDG06.findViewById(R.id.M04F01SF03D06_ApplyBtn);
        cartDG06_CloseBtn = cartDG06.findViewById(R.id.M04F01SF03D06_CloseDGBtn);

        //--DG07 SELECT TABLE TO SAVE TICKET--//
        cartDG07 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag01_pos_subfrag03_order_dg07_selecttable);
        cartDG07_RecyclerView = cartDG07.findViewById(R.id.M04F01SF03D07_TablesRV);
        cartDG07_ConfirmBtn = cartDG07.findViewById(R.id.M04F01SF03D07_ConfirmBtn);
        cartDG07_CloseBtn = cartDG07.findViewById(R.id.M04F01SF03D07_CloseDGBtn);

        //--DG08 ENTER CUSTOMER DETAIL TO SAVE TICKET--//
        cartDG08 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag01_pos_subfrag03_order_dg08_customerdetail);
        cartDG08_NameInput = cartDG08.findViewById(R.id.M04F01SF03D08_CustomerNameInput);
        cartDG08_DetailInput = cartDG08.findViewById(R.id.M04F01SF03D08_OrderDetailsInput);
        cartDG08_ConfirmBtn = cartDG08.findViewById(R.id.M04F01SF03D08_ConfirmBtn);
        cartDG08_CloseBtn = cartDG08.findViewById(R.id.M04F01SF03D08_CloseDGBtn);

        //--DG09 CONFIRM TO SAVE TICKET--//
        cartDG09 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag01_pos_subfrag03_order_dg09_confirmsaveticket);
        cartDG09_OrderType = cartDG09.findViewById(R.id.M04F01SF03D09_OrderType);
        cartDG09_TableCustomerDetail = cartDG09.findViewById(R.id.M04F01SF03D09_TableOrCustomer);
        cartDG09_Cashier = cartDG09.findViewById(R.id.M04F01SF03D09_Cashier);
        cartDG09_OrderDetails = cartDG09.findViewById(R.id.M04F01SF03D09_OrderDetails);
        cartDG09_RecyclerView = cartDG09.findViewById(R.id.M04F01SF03D09_ItemsRV);
        cartDG09_Discount = cartDG09.findViewById(R.id.M04F01SF03D09_DiscountNo);
        cartDG09_Tax = cartDG09.findViewById(R.id.M04F01SF03D09_TaxNo);
        cartDG09_Total = cartDG09.findViewById(R.id.M04F01SF03D09_TotalNo);
        cartDG09_YesBtn = cartDG09.findViewById(R.id.M04F01SF03D09_YesBtn);
        cartDG09_NoBtn = cartDG09.findViewById(R.id.M04F01SF03D09_NoBtn);
        cartDG09_CloseBtn = cartDG09.findViewById(R.id.M04F01SF03D09_CloseDGBtn);

        //--DG10 MANAGE TICKET--//
        cartDG10 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag01_pos_subfrag03_order_dg10_managetickets);
        cartDG10_TicketCount = cartDG10.findViewById(R.id.M04F01SF03D10_TicketsText);
        cartDG10_DineInBtn = cartDG10.findViewById(R.id.M04F01SF03D10_DineInBtn);
        cartDG10_TakeOutBtn = cartDG10.findViewById(R.id.M04F01SF03D10_TakeOutBtn);
        cartDG10_DeliveryBtn = cartDG10.findViewById(R.id.M04F01SF03D10_DeliveryBtn);
        cartDG10_PickUpBtn = cartDG10.findViewById(R.id.M04F01SF03D10_PickUpBtn);
        cartDG10_RecyclerView = cartDG10.findViewById(R.id.M04F01SF03D10_TicketsRV);
        cartDG10_CloseBtn = cartDG10.findViewById(R.id.M04F01SF03D10_CloseDGBtn);

    }

    //DG to display the Applied Discounts to the Selected Item upon clicking an Item in the cart
    private void load_DG01Functionalities(){
        //Check if currentCartItem is not null to prevent crash
        if(currentCartItem != null){
            //Set Text
            cartDG01_ItemName.setText(currentCartItem.getItemName());

            //Initialize RecyclerView Items
            List<String> listOfDiscountsKeyset = new ArrayList<>(currentCartItem.getItemDiscounts().keySet());

            //Initialize RecyclerView
            LinearLayoutManager layout = new LinearLayoutManager(getActivity());
            layout.setOrientation(LinearLayoutManager.VERTICAL);
            cartDG01_RecyclerViewAdapter = new M04F01SF03D01_AppliedDiscountCurrentItemRVA(getActivity(), realm, currentCartItem.getItemDiscounts(), listOfDiscountsKeyset);
            cartDG01_RecyclerView.setAdapter(cartDG01_RecyclerViewAdapter);
            cartDG01_RecyclerView.setLayoutManager(layout);

            //On Apply Discount Button
            cartDG01_AddDiscountBtn.setOnClickListener(apply -> {
                load_DG02Functionalities();
                cartDG01.dismiss();
                cartDG02.show();
            });

            //On Close Button
            cartDG01_CloseBtn.setOnClickListener(close -> {
                cartDG01.dismiss();
            });
        }
    }

    //DG to display the Selectable Discounts to Apply to the Selected Item upon clicking the "Add Discount" from DG01
    private void load_DG02Functionalities(){
        //Check if currentCartItem is not null to prevent crash
        if(currentCartItem != null){
            //Initialize RecyclerView Items
            Map<String, Integer> listOfDiscounts = new TreeMap<>();
            RealmResults<RealmDiscount> queriedDiscounts = realm.where(RealmDiscount.class).sort("discountName").findAll();
            for(RealmDiscount query : queriedDiscounts){
                if(!currentCartItem.getItemDiscounts().containsKey(query.getDiscountName())){
                    listOfDiscounts.put(query.getDiscountName(), query.getDiscountPercentage());
                }
            }
            List<String> listOfDiscountsKeyset = new ArrayList<>(listOfDiscounts.keySet());
            Map<String, Integer> listOfDiscountsToApply = new TreeMap<>();

            //Initialize RecyclerView
            LinearLayoutManager layout = new LinearLayoutManager(getActivity());
            layout.setOrientation(LinearLayoutManager.VERTICAL);
            cartDG02_RecyclerViewAdapter = new M04F01SF03D02_SelectDiscountToApplyRVA(getActivity(), realm, listOfDiscounts, listOfDiscountsKeyset, listOfDiscountsToApply);
            cartDG02_RecyclerView.setAdapter(cartDG02_RecyclerViewAdapter);
            cartDG02_RecyclerView.setLayoutManager(layout);

            //Initialize Confirm Button
            cartDG02_ConfirmBtn.setOnClickListener(confirm -> {
                if(!listOfDiscountsToApply.isEmpty()){
                    for(Map.Entry<String, Integer> discount : listOfDiscountsToApply.entrySet()){
                        currentCartItem.getItemDiscounts().put(discount.getKey(), discount.getValue());
                    }
                    cartRVA.notifyDataSetChanged();
                    load_OrderDetails();
                    load_DG01Functionalities();
                    cartDG02.dismiss();
                    cartDG01.show();
                } else {
                    Toast.makeText(getActivity(), "Please Select A Discount", Toast.LENGTH_SHORT).show();
                }
            });

            //Initialize CloseDG Button
            cartDG02_CloseBtn.setOnClickListener(close -> {
                load_DG01Functionalities();
                cartDG02.dismiss();
                cartDG01.show();
            });
        }
    }

    //DG to display the Selectable Order Types upon clicking the "Select Order Type" Button from the Cart Fragment
    private void load_DG03Functionalities(){
        //Check if currentOrderType is not null to prevent crash
        if(currentCartOrderType != null){
            switch(currentCartOrderType){
                case "Dine In":
                    cartDG03_DineInBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.green));
                    cartDG03_TakeOutBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
                    cartDG03_DeliveryBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
                    cartDG03_PickUpBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
                    break;
                case "Take Out":
                    cartDG03_DineInBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
                    cartDG03_TakeOutBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.green));
                    cartDG03_DeliveryBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
                    cartDG03_PickUpBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
                    break;
                case "Delivery":
                    cartDG03_DineInBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
                    cartDG03_TakeOutBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
                    cartDG03_DeliveryBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.green));
                    cartDG03_PickUpBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
                    break;
                case "Pick Up":
                    cartDG03_DineInBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
                    cartDG03_TakeOutBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
                    cartDG03_DeliveryBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
                    cartDG03_PickUpBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.green));
                    break;
            }
        }

        cartDG03_DineInBtn.setOnClickListener(di -> {
            currentCartOrderType = "Dine In";
            load_OrderDetails();
            cartDG03.dismiss();
        });

        cartDG03_TakeOutBtn.setOnClickListener(to -> {
            currentCartOrderType = "Take Out";
            load_OrderDetails();
            cartDG03.dismiss();
        });

        cartDG03_DeliveryBtn.setOnClickListener(dv -> {
            currentCartOrderType = "Delivery";
            load_OrderDetails();
            cartDG03.dismiss();
        });

        cartDG03_PickUpBtn.setOnClickListener(pu -> {
            currentCartOrderType = "Pick Up";
            load_OrderDetails();
            cartDG03.dismiss();
        });

        cartDG03_CLoseBtn.setOnClickListener(close -> {
            cartDG03.dismiss();
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
        cartDG04_RecyclerViewAdapter = new M04F01SF03D04_ViewAppliedDiscountsRVA(getActivity(), realm, cartDG04, listOfDiscountsApplied, listOfDiscountsAppliedKeyset, this, this);
        cartDG04_RecyclerView.setAdapter(cartDG04_RecyclerViewAdapter);
        cartDG04_RecyclerView.setLayoutManager(layout);

        //On Click Add Discount Btn
        cartDG04_AddDiscountBtn.setOnClickListener(add -> {
            load_DG06Functionalities();
            cartDG04.dismiss();
            cartDG06.show();
        });

        //On Close Button
        cartDG04_CloseBtn.setOnClickListener(close -> {
            cartDG04.dismiss();
        });
    }

    //DG to display the Items Applied with the Selected Discount
    private void load_DG05Functionalities(String discount){
        //Set Discount Name
        cartDG05_DiscountName.setText(discount);

        //Initialize RecyclerView Items
        List<CartObject> itemsAppliedWithCurrentDiscount = new ArrayList<>();
        for(CartObject cartItem : cart.keySet()){
            if(cartItem.getItemDiscounts().containsKey(discount)){
                itemsAppliedWithCurrentDiscount.add(cartItem);
            }
        }

        //Initialize RecyclerView
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        cartDG05_RecyclerViewAdapter = new M04F01SF03D05_ViewItemsOfCurrentDiscountRVA(getActivity(), realm, discount, cartDG05, itemsAppliedWithCurrentDiscount, this, this);
        cartDG05_RecyclerView.setAdapter(cartDG05_RecyclerViewAdapter);
        cartDG05_RecyclerView.setLayoutManager(layout);

        //On Close
        cartDG05_CloseBtn.setOnClickListener(close -> {
            load_DG04Functionalities();
            cartDG05.dismiss();
            cartDG04.show();
        });
    }

    //DG to display the Selectable Discounts to Apply to All Items
    private void load_DG06Functionalities(){
        //Initialize RecyclerView Items
        Map<String, Integer> listOfDiscounts = new TreeMap<>();
        RealmResults<RealmDiscount> queriedDiscounts = realm.where(RealmDiscount.class).sort("discountName").findAll();
        for(RealmDiscount query : queriedDiscounts){
            listOfDiscounts.put(query.getDiscountName(), query.getDiscountPercentage());
        }
        List<String> listOfDiscountsKeyset = new ArrayList<>(listOfDiscounts.keySet());
        Map<String, Integer> listOfDiscountsToApply = new TreeMap<>();

        //Initialize RecyclerView
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        cartDG06_RecyclerViewAdapter = new M04F01SF03D06_SelectDiscountToApplyRVA(getActivity(), realm, listOfDiscounts, listOfDiscountsKeyset, listOfDiscountsToApply);
        cartDG06_RecyclerView.setAdapter(cartDG06_RecyclerViewAdapter);
        cartDG06_RecyclerView.setLayoutManager(layout);

        //Initialize Confirm Button
        cartDG06_ApplyToAllBtn.setOnClickListener(confirm -> {
            if(!listOfDiscountsToApply.isEmpty()){
                for(Map.Entry<String, Integer> discount : listOfDiscountsToApply.entrySet()){
                    for(CartObject item : cart.keySet()){
                        item.getItemDiscounts().put(discount.getKey(), discount.getValue());
                    }
                }
                cartRVA.notifyDataSetChanged();
                load_OrderDetails();
                load_DG04Functionalities();
                cartDG06.dismiss();
                cartDG04.show();
            } else {
                Toast.makeText(getActivity(), "Please Select A Discount", Toast.LENGTH_SHORT).show();
            }
        });

        //Initialize CloseDG Button
        cartDG06_CloseBtn.setOnClickListener(close -> {
            load_DG04Functionalities();
            cartDG06.dismiss();
            cartDG04.show();
        });

    }

    //DG to display the when saving a ticket under Dine In and Take out
    private void load_DG07Functionalities(){
        //Initialize RecyclerView Items
        List<Table> listOfTables = new ArrayList<>();
        RealmResults<RealmTable> queriedTables = realm.where(RealmTable.class).equalTo("tableStatus", "Free").sort("tableNo").findAll();
        for(RealmTable query : queriedTables){
            listOfTables.add(new Table(query.getTableName(), query.getTableNo()));
        }

        //Initialize RecyclerView
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        cartDG07_RecyclerViewAdapter = new M04F01SF03D07_SelectTableRVA(getActivity(), realm, listOfTables);
        cartDG07_RecyclerView.setAdapter(cartDG07_RecyclerViewAdapter);
        cartDG07_RecyclerView.setLayoutManager(layout);

        //On Confirm Btn
        cartDG07_ConfirmBtn.setOnClickListener(confirm -> {
            if(currentCartTable != null){
                cartDG07.dismiss();
                load_DG09Functionalities();
                cartDG09.show();
            } else {
                ToastMessage.show(getActivity(), "Please select a Table");
            }
        });

        //On Close DG Btn
        cartDG07_CloseBtn.setOnClickListener(close -> {
            cartDG07.dismiss();
        });

    }

    //DG to display the when saving a ticket under Delivery and Pick Up
    private void load_DG08Functionalities(){
        cartDG08_CloseBtn.setOnClickListener(close -> {
            cartDG08.dismiss();
        });
    }

    //DG to display the when confirming to save ticket
    private void load_DG09Functionalities(){
        //Initialize RecyclerView Items
        List<CartObject> cartItems = new ArrayList<>(cart.keySet());

        //Initialize RecyclerView
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        cartDG09_RecyclerViewAdapter = new M04F01SF03D09_SaveTicketRVA(getActivity(), realm, cartItems);
        cartDG09_RecyclerView.setAdapter(cartDG09_RecyclerViewAdapter);
        cartDG09_RecyclerView.setLayoutManager(layout);

        //Initialize Order Details
        RealmUser cashier = realm.where(RealmUser.class).findFirst();
        cartDG09_OrderType.setText(currentCartOrderType);
        if(currentCartOrderType.equals("Dine In") || currentCartOrderType.equals("Take Out")){
            cartDG09_TableCustomerDetail.setText(currentCartTable.getTableName() + " " + currentCartTable.getTableNo());
        } else if(currentCartOrderType.equals("Delivery") || currentCartOrderType.equals("Pick Up")){
            cartDG09_TableCustomerDetail.setText(currentCartCustomer);
        }
        cartDG09_Cashier.setText(cashier.getUserName());
        cartDG09_OrderDetails.setText(currentCartCustomerDetails);

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
            }
            double discountInDecimal = (double) discountInPercentage / 100;
            double discount = total * discountInDecimal;
            double finalPrice = total - discount;
            finalDiscount += discount;
            finalTax += tax;
            finalTotal += finalPrice;
        }
        cartDG09_Discount.setText("₱" + new BigDecimal(finalDiscount).setScale(2, RoundingMode.HALF_UP).toString());
        cartDG09_Tax.setText("₱" + new BigDecimal(finalTax).setScale(2, RoundingMode.HALF_UP).toString());
        cartDG09_Total.setText("₱" + new BigDecimal(finalTotal).setScale(2, RoundingMode.HALF_UP).toString());

        //Initialize Yes and No Buttons
        cartDG09_YesBtn.setOnClickListener(save -> {
            //Save the Ticket to Database
            List<String> itemName = new ArrayList<>();
            List<Double> itemPrice = new ArrayList<>();
            List<Integer> itemQty = new ArrayList<>();
            List<String> discountItem = new ArrayList<>();
            List<String> discountName = new ArrayList<>();
            List<Integer> discountPercentage = new ArrayList<>();
            for(Map.Entry<CartObject, Integer> cartItem : cart.entrySet()){
                String name = cartItem.getKey().getItemName();
                double price = cartItem.getKey().getItemPrice();
                int frequency = cartItem.getValue();
                Map<String, Integer> discounts = cartItem.getKey().getItemDiscounts();
                itemName.add(name);
                itemPrice.add(price);
                itemQty.add(frequency);
                for(Map.Entry<String, Integer> discount : discounts.entrySet()){
                    discountItem.add(name);
                    discountName.add(discount.getKey());
                    discountPercentage.add(discount.getValue());
                }
            }
            if(currentCartOrderType.equals("Dine In") || currentCartOrderType.equals("Take Out")){
                OpenTicketInstance.toCreateTicket(cashier.getUserName(),
                        currentCartOrderType,
                                                 currentCartTable.getTableName(),
                                                 currentCartTable.getTableNo(),
                                                 "N/A",
                                                 "N/A",
                                                 itemName,
                                                 itemPrice,
                                                 itemQty,
                                                 discountItem,
                                                 discountName,
                                                 discountPercentage);
            } else {
                OpenTicketInstance.toCreateTicket(cashier.getUserName(),
                        currentCartOrderType,
                                                 "N/A",
                                                 -1,
                                                 "N/A",
                                                 "N/A",
                                                 itemName,
                                                 itemPrice,
                                                 itemQty,
                                                 discountItem,
                                                 discountName,
                                                 discountPercentage);
            }

            currentCartOrderType = "None";
            if(currentCartTable != null){
                OpenTableInstance.toSetTableStatusToOccupied(currentCartTable.getTableName(), currentCartTable.getTableNo());
                currentCartTable = null;
            } else {
                currentCartTable = null;
            }
            currentCartCustomer = "N/A";
            currentCartCustomerDetails = "N/A";
            cart.clear();
            cartRVA.notifyDataSetChanged();
            load_OrderDetails();
            cartDG09.dismiss();
            ToastMessage.show(getActivity(), "Ticket Saved");
        });

        cartDG09_NoBtn.setOnClickListener(close -> {
            cartDG09.dismiss();
        });

        //Initialize Close DG Button
        cartDG09_CloseBtn.setOnClickListener(close -> {
            cartDG09.dismiss();
        });
    }

    //DG to display tickets
    private void load_DG10Functionalities(){
        //Initialize RecyclerView Items
        List<Ticket> listOfTickets = new ArrayList<>();
        RealmResults<RealmTicket> queriedTickets = realm.where(RealmTicket.class).findAll();
        for(RealmTicket query : queriedTickets){
            Ticket ticket = new Ticket(query.getTicketID(),
                                       query.getDateAndTime(),
                                       query.getOrderType(),
                                       query.getTableName(),
                                       query.getTableNumber(),
                                       query.getCustomerName(),
                                       query.getCashierName(),
                                       query.getAdditionalDetails());
            //CARTOBJECT
            List<String> itemName = new ArrayList<>(query.getItemName());
            List<Double> itemPrice = new ArrayList<>(query.getItemPrice());
            List<Integer> itemQty = new ArrayList<>(query.getItemQty());
            //DISCOUNT
            List<String> discountItem = new ArrayList<>(query.getDiscountItem());
            List<String> discountName = new ArrayList<>(query.getDiscountName());
            List<Integer> discountPercentage = new ArrayList<>(query.getDiscountPercentage());
            for(int i = 0 ; i < itemName.size() ; i++){
                String name = itemName.get(i);
                double price = itemPrice.get(i);
                int quantity = itemQty.get(i);
                Map<String, Integer> discounts = new TreeMap<>();
                for(int j = 0 ; j < discountItem.size() ; j++){
                    String dItem = discountItem.get(j);
                    String dName = discountName.get(j);
                    int dPercentage = discountPercentage.get(j);
                    if(dItem.equals(name)){
                        discounts.put(dName, dPercentage);
                    }
                }
                ticket.getItems().put(new CartObject(name, price, discounts), quantity);
            }
            listOfTickets.add(ticket);
        }

        //Initialize RecyclerView
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        cartDG10_RecyclerViewAdapter = new M04F01SF03D10_ManageTicketRVA(getActivity(), realm, cartDG10, listOfTickets, this);
        cartDG10_RecyclerView.setAdapter(cartDG10_RecyclerViewAdapter);
        cartDG10_RecyclerView.setLayoutManager(layout);

        //Initialize Categories
        cartDG10_DineInBtn.setOnClickListener(dineIn -> {
            cartDG10_DineInBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.green));
            cartDG10_TakeOutBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
            cartDG10_DeliveryBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
            cartDG10_PickUpBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
            List<Ticket> dineInTickets = new ArrayList<>();
            for(Ticket ticket : listOfTickets){
                if(ticket.getOrderType().equals("Dine In")){
                    dineInTickets.add(ticket);
                }
            }
            cartDG10_RecyclerViewAdapter = new M04F01SF03D10_ManageTicketRVA(getActivity(), realm, cartDG10, dineInTickets, this);
            cartDG10_RecyclerViewAdapter.notifyDataSetChanged();
            cartDG10_RecyclerView.setAdapter(cartDG10_RecyclerViewAdapter);
        });

        cartDG10_TakeOutBtn.setOnClickListener(dineIn -> {
            cartDG10_DineInBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
            cartDG10_TakeOutBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.green));
            cartDG10_DeliveryBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
            cartDG10_PickUpBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
            List<Ticket> takeOutTickets = new ArrayList<>();
            for(Ticket ticket : listOfTickets){
                if(ticket.getOrderType().equals("Take Out")){
                    takeOutTickets.add(ticket);
                }
            }
            cartDG10_RecyclerViewAdapter = new M04F01SF03D10_ManageTicketRVA(getActivity(), realm, cartDG10, takeOutTickets, this);
            cartDG10_RecyclerViewAdapter.notifyDataSetChanged();
            cartDG10_RecyclerView.setAdapter(cartDG10_RecyclerViewAdapter);
        });

        cartDG10_DeliveryBtn.setOnClickListener(dineIn -> {
            cartDG10_DineInBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
            cartDG10_TakeOutBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
            cartDG10_DeliveryBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.green));
            cartDG10_PickUpBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
            List<Ticket> deliveryTickets = new ArrayList<>();
            for(Ticket ticket : listOfTickets){
                if(ticket.getOrderType().equals("Delivery")){
                    deliveryTickets.add(ticket);
                }
            }
            cartDG10_RecyclerViewAdapter = new M04F01SF03D10_ManageTicketRVA(getActivity(), realm, cartDG10, deliveryTickets, this);
            cartDG10_RecyclerViewAdapter.notifyDataSetChanged();
            cartDG10_RecyclerView.setAdapter(cartDG10_RecyclerViewAdapter);
        });

        cartDG10_PickUpBtn.setOnClickListener(dineIn -> {
            cartDG10_DineInBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
            cartDG10_TakeOutBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
            cartDG10_DeliveryBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
            cartDG10_PickUpBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.green));
            List<Ticket> pickUpTickets = new ArrayList<>();
            for(Ticket ticket : listOfTickets){
                if(ticket.getOrderType().equals("Pick Up")){
                    pickUpTickets.add(ticket);
                }
            }
            cartDG10_RecyclerViewAdapter = new M04F01SF03D10_ManageTicketRVA(getActivity(), realm, cartDG10, pickUpTickets, this);
            cartDG10_RecyclerViewAdapter.notifyDataSetChanged();
            cartDG10_RecyclerView.setAdapter(cartDG10_RecyclerViewAdapter);
        });

        //Initialize Close Button
        cartDG10_CloseBtn.setOnClickListener(close -> {
            cartDG10.dismiss();
        });
    }

    //--INTERFACES--//
    @Override
    public void load_FGContents() {
        cartRVA.notifyDataSetChanged();
        load_OrderDetails();
    }

    @Override
    public void load_DGContents(int dialogNo, int image, String name) {
        switch(dialogNo){
            case 1:
                load_DG01Functionalities();
                cartDG01.show();
            case 4:
                load_DG04Functionalities();
                cartDG04.show();
                break;
            case 5:
                load_DG05Functionalities(name);
                cartDG05.show();
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
}
