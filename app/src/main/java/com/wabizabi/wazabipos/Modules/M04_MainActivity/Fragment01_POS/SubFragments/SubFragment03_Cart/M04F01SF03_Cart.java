package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.M04F01SF03_CartRVA.cart;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
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
import com.wabizabi.wazabipos.Database.Instances.OpenTransactionsInstance;
import com.wabizabi.wazabipos.Database.ObjectSchemas.PaymentMethod;
import com.wabizabi.wazabipos.Database.ObjectSchemas.SalesTransaction;
import com.wabizabi.wazabipos.Database.ObjectSchemas.Table;
import com.wabizabi.wazabipos.Database.ObjectSchemas.Ticket;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmDiscount;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmTicket;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmUser;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.M04F01_POS;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.M04F01SF03D01_AppliedDiscountsRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.M04F01SF03D02_SelectDiscountToApplyRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.M04F01SF03D04_AppliedDiscountsRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.M04F01SF03D05_ItemsAppliedWithDiscountRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.M04F01SF03D06_SelectDiscountToApplyRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.M04F01SF03D07_SelectTableRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.M04F01SF03D09_SaveTicketRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.M04F01SF03D10_ManageTicketRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.M04F01SF03D14_ConfirmTransactionRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.M04F01SF03D15_TransactionCompleteRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.M04F01SF03_CartRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Helper.CartHelper;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Interfaces.DialogLoader;
import com.wabizabi.wazabipos.Utilities.Interfaces.FragmentLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.Bundles.DialogBundle;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.DialogHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.PrintHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.StringHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.ToastHelper;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Object.CartItem;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
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
    public static Ticket currentCartTicket;
    ConstraintLayout orderDetailsLayout;
    CardView selectOrderTypeBtn;
    TextView orderTypeText;
    double finalSubTotal = 0.00; //SubTotal
    double finalTax = 0.00; //Tax
    double finalServiceFee = 0.00; //Service Fee
    double finalDiscount = 0.00; //Discount
    double finalTotal = 0.00; //Total
    TextView cartTax,
             cartServiceFee,
             cartDiscount,
             cartTotal;
    CardView saveTicketBtn;
    TextView saveTicketBtnTxt;
    CardView ticketsBtn;
    TextView ticketsBtnTxt;
    CardView chargeBtn;

    //--DG01 DISCOUNTS APPLIED ON SELECTED CART ITEM--//
    Dialog cartDG01;
    TextView cartDG01_ItemName;
    RecyclerView cartDG01_RecyclerView;
    RecyclerView.Adapter cartDG01_RecyclerViewAdapter;
    CardView cartDG01_AddDiscountBtn;
    ImageView closeDG01Btn;

    //--DG02 SELECT DISCOUNTS TO APPLY ON CURRENT ITEM--//
    Dialog cartDG02;
    RecyclerView cartDG02_RecyclerView;
    RecyclerView.Adapter cartDG02_RecyclerViewAdapter;
    CardView cartDG02_ConfirmBtn;
    ImageView closeDG02Btn;

    //--DG03 SELECT ORDER TYPE--//
    public static String currentCartOrderType;
    Dialog cartDG03;
    CardView cartDG03_DineInBtn,
             cartDG03_TakeOutBtn,
             cartDG03_DeliveryBtn,
             cartDG03_PickUpBtn;
    TextView cartDG03_ClearBtn;
    ImageView closeDG03Btn;

    //--DG04 VIEW APPLIED DISCOUNTS--//
    Dialog cartDG04;
    RecyclerView cartDG04_RecyclerView;
    RecyclerView.Adapter cartDG04_RecyclerViewAdapter;
    CardView cartDG04_AddDiscountBtn;
    ImageView closeDG04Btn;

    //--DG05 VIEW ITEMS APPLIED WITH SELECTED DISCOUNT--//
    Dialog cartDG05;
    TextView cartDG05_DiscountName;
    RecyclerView cartDG05_RecyclerView;
    RecyclerView.Adapter cartDG05_RecyclerViewAdapter;
    ImageView closeDG05Btn;

    //--DG06 SELECT DISCOUNTS TO APPLY--//
    Dialog cartDG06;
    RecyclerView cartDG06_RecyclerView;
    RecyclerView.Adapter cartDG06_RecyclerViewAdapter;
    CardView cartDG06_ApplyToAllBtn;
    ImageView closeDG06Btn;

    //--DG07 SELECT TABLE--//
    public static Table selectedTable;
    Dialog cartDG07;
    RecyclerView cartDG07_RecyclerView;
    RecyclerView.Adapter cartDG07_RecyclerViewAdapter;
    EditText cartDG07_DetailsInput;
    CardView cartDG07_ConfirmBtn;
    ImageView closeDG07Btn;

    //--DG08 ENTER DETAILS--//
    Dialog cartDG08;
    EditText cartDG08_NameInput,
             cartDG08_DetailInput;
    CardView cartDG08_ConfirmBtn;
    ImageView closeDG08Btn;

    //--DG09 CONFIRM TO SAVE--//
    Dialog cartDG09;
    TextView cartDG09_OrderType,
             cartDG09_TableCustomerDetail,
             cartDG09_Cashier,
             cartDG09_OrderDetails;
    RecyclerView cartDG09_RecyclerView;
    RecyclerView.Adapter cartDG09_RecyclerViewAdapter;
    TextView cartDG09_SubTotal,
             cartDG09_Tax,
             cartDG09_ServiceFee,
             cartDG09_Discount,
             cartDG09_AmountDue,
             cartDG09_ItemCount,
             cartDG09_DateAndTime;
    CardView cartDG09_YesBtn, cartDG09_NoBtn;
    ImageView closeDG09Btn;

    //--DG10 MANAGE TICKETS--//
    Dialog cartDG10;
    TextView cartDG10_TicketCount;
    CardView cartDG10_DineInBtn,
             cartDG10_TakeOutBtn,
             cartDG10_DeliveryBtn,
             cartDG10_PickUpBtn;
    RecyclerView cartDG10_RecyclerView;
    RecyclerView.Adapter cartDG10_RecyclerViewAdapter;
    ImageView closeDG10Btn;

    //--DG11 CONFIRM VOID TICKET--//
    Dialog cartDG11;
    TextView cartDG11_TicketText;
    CardView cartDG11_YesBtn,
            cartDG11_NoBtn;
    ImageView closeDG11Btn;

    //--DG12 VIEW ORDER DETAILS--//
    Dialog cartDG12;
    TextView cartDG12_DetailsText;
    ImageView closeDG12Btn;

    //--DG13 PAYMENT--//
    int indexMethod = -1;
    public static String selectedMethod;
    Dialog cartDG13;
    TextView cartDG13_AmountDue,
             cartDG13_OrderName,
             cartDG13_SubTotal,
             cartDG13_Tax,
             cartDG13_ServiceFee,
             cartDG13_Discount;
    EditText cartDG13_AmountInput;
    ImageView cartDG13_PrevMethod;
    TextView cartDG13_Method;
    ImageView cartDG13_NextMethod;
    CardView cartDG13_ConfirmBtn;
    ImageView closeDG13Btn;

    //--DG14 CONFIRM TRANSACTION--//
    Dialog cartDG14;
    TextView cartDG14_OrderType,
            cartDG14_TableCustomerDetail,
            cartDG14_Cashier;
    RecyclerView cartDG14_RecyclerView;
    RecyclerView.Adapter cartDG14_RecyclerViewAdapter;
    TextView cartDG14_SubTotal,
            cartDG14_Tax,
            cartDG14_ServiceFee,
            cartDG14_Discount,
            cartDG14_AmountDue,
            cartDG14_PaymentMethod,
            cartDG14_AmountRecieved,
            cartDG14_Change,
            cartDG14_ItemCount,
            cartDG14_DateAndTime;
    CardView cartDG14_YesBtn, cartDG14_NoBtn;
    ImageView closeDG14Btn;

    //--DG15 TRANSACTION COMPLETE--//
    Dialog cartDG15;
    TextView cartDG15_SalesNumber,
             cartDG15_OrderType,
             cartDG15_TableCustomerDetail,
             cartDG15_Cashier;
    RecyclerView cartDG15_RecyclerView;
    RecyclerView.Adapter cartDG15_RecyclerViewAdapter;
    TextView cartDG15_SubTotal,
             cartDG15_Tax,
             cartDG15_ServiceFee,
             cartDG15_Discount,
             cartDG15_AmountDue,
             cartDG15_PaymentMethod,
             cartDG15_AmountRecieved,
             cartDG15_Change,
             cartDG15_ItemCount,
             cartDG15_DateAndTime;
    CardView cartDG15_PrintBtn, cartDG15_CloseBtn;
    ImageView closeDG15Btn;

    //--DG16 OVERWRITE--//
    Dialog cartDG16;
    TextView cartDG16_OrderName;
    CardView cartDG16_YesBtn, cartDG16_NoBtn;
    ImageView closeDG16Btn;

    RefreshPOS posContent;
    public interface RefreshPOS {
        void updatePOS();
    }

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
        cartTax = v.findViewById(R.id.M04F01SF03_TaxNo);
        cartServiceFee = v.findViewById(R.id.M04F01SF03_ServiceFeeNo);
        cartDiscount = v.findViewById(R.id.M04F01SF03_DiscountNo);
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
            } else {
                load_DG12Functionalities();
                cartDG12.show();
            }
        });

        if(currentCartOrderType != null && currentCartTicket == null){
            orderTypeText.setText(currentCartOrderType);
        } else if(currentCartTicket != null) {
            orderTypeText.setText(currentCartTicket.getOrder() + " - " + currentCartTicket.getOrderType());
        } else {
            orderTypeText.setText("Select Order Type");
        }

        //--ORDER DETAILS--//
        orderDetailsLayout.setOnClickListener(click -> {
            load_DG04Functionalities();
            cartDG04.show();
        });

        //Calculate the discount
        finalSubTotal = 0.00; //SubTotal
        finalTax = 0.00; //Tax
        finalServiceFee = 0.00; //Service Fee
        finalDiscount = 0.00; //Discount
        finalTotal = 0.00; //Total
        for(CartItem item : cart.keySet()){
            int quantity = cart.get(item);
            double subTotal = item.getItemPrice() * quantity;
            double tax = subTotal * 0.03;
            double fee = (currentCartTicket != null && currentCartTicket.getOrderType().equals("Dine In"))
                        ? subTotal * 0.05
                        : (currentCartOrderType != null && currentCartOrderType.equals("Dine In"))
                        ? subTotal * 0.05
                        : 0.00;
            double taxedTotal = subTotal + tax + fee;
            int discountInPercentage = 0;
            for(Map.Entry<String, Integer> discount : item.getItemDiscounts().entrySet()){
                discountInPercentage += discount.getValue();
            }
            double discountInDecimal = (double) discountInPercentage / 100;
            double discount = subTotal * discountInDecimal;
            double discountedTotal = taxedTotal - discount;
            finalSubTotal += subTotal;
            finalTax += tax;
            finalServiceFee += fee;
            finalDiscount += discount;
            finalTotal += discountedTotal;
        }
        cartTax.setText(StringHelper.convertToCurrency(finalTax));
        cartServiceFee.setText(StringHelper.convertToCurrency(finalServiceFee));
        cartDiscount.setText(StringHelper.convertToCurrency(finalDiscount));
        cartTotal.setText(StringHelper.convertToCurrency(finalTotal));

        //--TICKET AND CHARGE SECTION--//
        if(currentCartTicket != null && currentCartTicket.getTicketStatus().equals("Original")) {
            //Save Ticket Btn
            saveTicketBtnTxt.setText("Print Ticket");
            saveTicketBtn.setOnClickListener(print -> {
                try {
                    PrintHelper.printTicket(currentCartTicket);
                    cart.clear();
                    cartRVA.notifyDataSetChanged();
                    currentCartTicket = null;
                    load_OrderDetails();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } else if(currentCartTicket != null && currentCartTicket.getTicketStatus().equals("Voidable")){
            //Save Ticket Btn
            saveTicketBtnTxt.setText("Overwrite Ticket");
            saveTicketBtn.setOnClickListener(print -> {
                load_DG16Functionalities();
                cartDG16.show();
            });
        } else if(currentCartOrderType != null){
            //Save Ticket Button
            saveTicketBtnTxt.setText("Save Ticket");
            saveTicketBtn.setOnClickListener(save -> {
                if(currentCartOrderType.equals("Dine In") || currentCartOrderType.equals("Take Out")) {
                    load_DG07Functionalities(new DialogBundle(7, finalSubTotal, finalTax, finalServiceFee, finalDiscount, finalTotal));
                    cartDG07.show();
                } else if(currentCartOrderType.equals("Delivery") || currentCartOrderType.equals("Pick Up")) {
                    load_DG08Functionalities(new DialogBundle(8, finalSubTotal, finalTax, finalServiceFee, finalDiscount, finalTotal));
                    cartDG08.show();
                }  else {
                    ToastHelper.show(getActivity(), "Please Select an Order Type");
                }
            });
        } else {
            saveTicketBtnTxt.setText("Save Ticket");
            saveTicketBtn.setOnClickListener(error -> {
                ToastHelper.show(getActivity(), "Please Select an Order Type");
            });
        }

        //ManageTickets
        ticketsBtn.setOnClickListener(tickets -> {
            if(currentCartTicket != null){
                cart.clear();
                cartRVA.notifyDataSetChanged();
                currentCartTicket = null;
                load_OrderDetails();
                posContent.updatePOS();
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

        //Charge Ticket
        double amountDue = finalTotal;
        chargeBtn.setOnClickListener(charge -> {
            if(currentCartTicket != null){
                String order = currentCartTicket.getOrder();
                String orderType = currentCartTicket.getOrderType();
                load_DG13Functionalities(new DialogBundle(13, order, orderType, finalSubTotal, finalTax, finalServiceFee, finalDiscount, amountDue));
                cartDG13.show();
            } else if(currentCartOrderType != null && currentCartTicket == null){
                String order = "Table 00 [Default]";
                String orderType = currentCartOrderType;
                load_DG13Functionalities(new DialogBundle(13, order, orderType, finalSubTotal, finalTax, finalServiceFee, finalDiscount, amountDue));
                cartDG13.show();
            } else {
                ToastHelper.show(getActivity(), "Please select an Order Type");
            }
        });
    }

    private void init_Dialogs(){
        //--DG01 SELECTED ITEM DISCOUNTS--//
        cartDG01 = DialogHelper.create(getActivity(), R.layout.act04_main_frag01_pos_subfrag03_order_dg01_itemdiscount);
        cartDG01_ItemName = cartDG01.findViewById(R.id.M04F01SF03D01_ItemName);
        cartDG01_RecyclerView = cartDG01.findViewById(R.id.M04F01SF03D01_DiscountsAppliedRV);
        cartDG01_AddDiscountBtn = cartDG01.findViewById(R.id.M04F01SF03D01_AddDiscountBtn);
        closeDG01Btn = cartDG01.findViewById(R.id.M04F01SF03D01_CloseDGBtn);

        //--DG02 SELECTED ITEM DISCOUNTS--//
        cartDG02 = DialogHelper.create(getActivity(), R.layout.act04_main_frag01_pos_subfrag03_order_dg02_itemdiscountapply);
        cartDG02_RecyclerView = cartDG02.findViewById(R.id.M04F01SF03D02_DiscountsRV);
        cartDG02_ConfirmBtn = cartDG02.findViewById(R.id.M04F01SF03D02_ConfirmBtn);
        closeDG02Btn = cartDG02.findViewById(R.id.M04F01SF03D02_CloseDGBtn);

        //--DG03 SELECT ORDER TYPE--//
        cartDG03 = DialogHelper.create(getActivity(), R.layout.act04_main_frag01_pos_subfrag03_order_dg03_selectordertype);
        cartDG03_DineInBtn = cartDG03.findViewById(R.id.M04F01SF03D03_DineInButton);
        cartDG03_TakeOutBtn = cartDG03.findViewById(R.id.M04F01SF03D03_TakeOutButton);
        cartDG03_DeliveryBtn = cartDG03.findViewById(R.id.M04F01SF03D03_DeliveryButton);
        cartDG03_PickUpBtn = cartDG03.findViewById(R.id.M04F01SF03D03_PickUpButton);
        cartDG03_ClearBtn = cartDG03.findViewById(R.id.M04F01SF03D03_ClearButton);
        closeDG03Btn = cartDG03.findViewById(R.id.M04F01SF03D03_CloseDGBtn);

        //--DG04 VIEW APPLIED DISCOUNTS DG--//
        cartDG04 = DialogHelper.create(getActivity(), R.layout.act04_main_frag01_pos_subfrag03_order_dg04_discountsapplied);
        cartDG04_RecyclerView = cartDG04.findViewById(R.id.M04F01SF03D04_AppliedDiscountsRV);
        cartDG04_AddDiscountBtn = cartDG04.findViewById(R.id.M04F01SF03D04_AddDiscountBtn);
        closeDG04Btn = cartDG04.findViewById(R.id.M04F01SF03D04_CloseDGBtn);

        //--DG05 ITEMS OF CURRENT DISCOUNT DG--//
        cartDG05 = DialogHelper.create(getActivity(), R.layout.act04_main_frag01_pos_subfrag03_order_dg05_discountitemview);
        cartDG05_DiscountName = cartDG05.findViewById(R.id.M04F01SF03D05_DiscountName);
        cartDG05_RecyclerView = cartDG05.findViewById(R.id.M04F01SF03D05_ItemsAppliedWithSelectedDiscountRV);
        closeDG05Btn = cartDG05.findViewById(R.id.M04F01SF03D05_CloseDGBtn);

        //--DG06 SELECT DISCOUNTS TO APPLY TO ALL DG--//
        cartDG06= DialogHelper.create(getActivity(), R.layout.act04_main_frag01_pos_subfrag03_order_dg06_discountapply);
        cartDG06_RecyclerView = cartDG06.findViewById(R.id.M04F01SF03D06_DiscountsRV);
        cartDG06_ApplyToAllBtn = cartDG06.findViewById(R.id.M04F01SF03D06_ApplyBtn);
        closeDG06Btn = cartDG06.findViewById(R.id.M04F01SF03D06_CloseDGBtn);

        //--DG07 SELECT TABLE TO SAVE TICKET--//
        cartDG07 = DialogHelper.create(getActivity(), R.layout.act04_main_frag01_pos_subfrag03_order_dg07_selecttable);
        cartDG07_RecyclerView = cartDG07.findViewById(R.id.M04F01SF03D07_TablesRV);
        cartDG07_DetailsInput = cartDG07.findViewById(R.id.M04F01SF03D07_DetailsInput);
        cartDG07_ConfirmBtn = cartDG07.findViewById(R.id.M04F01SF03D07_ConfirmBtn);
        closeDG07Btn = cartDG07.findViewById(R.id.M04F01SF03D07_CloseDGBtn);

        //--DG08 ENTER CUSTOMER DETAIL TO SAVE TICKET--//
        cartDG08 = DialogHelper.create(getActivity(), R.layout.act04_main_frag01_pos_subfrag03_order_dg08_customerdetail);
        cartDG08_NameInput = cartDG08.findViewById(R.id.M04F01SF03D08_CustomerNameInput);
        cartDG08_DetailInput = cartDG08.findViewById(R.id.M04F01SF03D08_DetailsInput);
        cartDG08_ConfirmBtn = cartDG08.findViewById(R.id.M04F01SF03D08_ConfirmBtn);
        closeDG08Btn = cartDG08.findViewById(R.id.M04F01SF03D08_CloseDGBtn);

        //--DG09 CONFIRM TO SAVE TICKET--//
        cartDG09 = DialogHelper.create(getActivity(), R.layout.act04_main_frag01_pos_subfrag03_order_dg09_confirmsaveticket);
        cartDG09_OrderType = cartDG09.findViewById(R.id.M04F01SF03D09_OrderType);
        cartDG09_TableCustomerDetail = cartDG09.findViewById(R.id.M04F01SF03D09_TableOrCustomer);
        cartDG09_Cashier = cartDG09.findViewById(R.id.M04F01SF03D09_Cashier);
        cartDG09_OrderDetails = cartDG09.findViewById(R.id.M04F01SF03D09_OrderDetails);
        cartDG09_RecyclerView = cartDG09.findViewById(R.id.M04F01SF03D09_ItemsRV);
        cartDG09_SubTotal = cartDG09.findViewById(R.id.M04F01SF03D09_SubTotalNo);
        cartDG09_Tax = cartDG09.findViewById(R.id.M04F01SF03D09_TaxNo);
        cartDG09_ServiceFee = cartDG09.findViewById(R.id.M04F01SF03D09_ServiceFeeNo);
        cartDG09_Discount = cartDG09.findViewById(R.id.M04F01SF03D09_DiscountNo);
        cartDG09_AmountDue = cartDG09.findViewById(R.id.M04F01SF03D09_AmountDueNo);
        cartDG09_ItemCount = cartDG09.findViewById(R.id.M04F01SF03D09_TotalItemsNo);
        cartDG09_DateAndTime = cartDG09.findViewById(R.id.M04F01SF03D09_DateAndTime);
        cartDG09_YesBtn = cartDG09.findViewById(R.id.M04F01SF03D09_YesBtn);
        cartDG09_NoBtn = cartDG09.findViewById(R.id.M04F01SF03D09_NoBtn);
        closeDG09Btn = cartDG09.findViewById(R.id.M04F01SF03D09_CloseDGBtn);

        //--DG10 MANAGE TICKET--//
        cartDG10 = DialogHelper.create(getActivity(), R.layout.act04_main_frag01_pos_subfrag03_order_dg10_managetickets);
        cartDG10_TicketCount = cartDG10.findViewById(R.id.M04F01SF03D10_TicketsText);
        cartDG10_DineInBtn = cartDG10.findViewById(R.id.M04F01SF03D10_DineInBtn);
        cartDG10_TakeOutBtn = cartDG10.findViewById(R.id.M04F01SF03D10_TakeOutBtn);
        cartDG10_DeliveryBtn = cartDG10.findViewById(R.id.M04F01SF03D10_DeliveryBtn);
        cartDG10_PickUpBtn = cartDG10.findViewById(R.id.M04F01SF03D10_PickUpBtn);
        cartDG10_RecyclerView = cartDG10.findViewById(R.id.M04F01SF03D10_TicketsRV);
        closeDG10Btn = cartDG10.findViewById(R.id.M04F01SF03D10_CloseDGBtn);

        //--DG11 CONFIRM TO DELETE TICKET--//
        cartDG11 = DialogHelper.create(getActivity(), R.layout.act04_main_frag01_pos_subfrag03_order_dg11_confirmdeleteticket);
        cartDG11_TicketText = cartDG11.findViewById(R.id.M04F01SF03D11_TicketNameText);
        cartDG11_YesBtn = cartDG11.findViewById(R.id.M04F01SF03D11_YesBtn);
        cartDG11_NoBtn = cartDG11.findViewById(R.id.M04F01SF03D11_NoBtn);
        closeDG11Btn = cartDG11.findViewById(R.id.M04F01SF03D11_CloseDGBtn);

        //--DG12 LOAD CURRENT TICKET ORDER DETAILS--//
        cartDG12 = DialogHelper.create(getActivity(), R.layout.act04_main_frag01_pos_subfrag03_order_dg12_orderdetails);
        cartDG12_DetailsText = cartDG12.findViewById(R.id.M04F01SF03D12_OrderDetails);
        closeDG12Btn = cartDG12.findViewById(R.id.M04F01SF03D12_CloseDGBtn);

        //--DG13 INPUT PAYMENT--//
        cartDG13 = DialogHelper.create(getActivity(), R.layout.act04_main_frag01_pos_subfrag03_order_dg13_charge);
        cartDG13_AmountDue = cartDG13.findViewById(R.id.M04F01SF03D13_AmountDue);
        cartDG13_OrderName = cartDG13.findViewById(R.id.M04F01SF03D13_OrderNo);
        cartDG13_SubTotal = cartDG13.findViewById(R.id.M04F01SF03D13_SubTotalNo);
        cartDG13_Tax = cartDG13.findViewById(R.id.M04F01SF03D13_TaxNo);
        cartDG13_ServiceFee = cartDG13.findViewById(R.id.M04F01SF03D13_ServiceFeeNo);
        cartDG13_Discount = cartDG13.findViewById(R.id.M04F01SF03D13_DiscountNo);
        cartDG13_PrevMethod = cartDG13.findViewById(R.id.M04F01SF03D13_PrevMethodBtn);
        cartDG13_Method = cartDG13.findViewById(R.id.M04F01SF03D13_Method);
        cartDG13_NextMethod = cartDG13.findViewById(R.id.M04F01SF03D13_NextMethodBtn);
        cartDG13_AmountInput = cartDG13.findViewById(R.id.M04F01SF03D13_AmountInput);
        cartDG13_ConfirmBtn = cartDG13.findViewById(R.id.M04F01SF03D13_ConfirmBtn);
        closeDG13Btn = cartDG13.findViewById(R.id.M04F01SF03D13_CloseDGBtn);

        //--DG14 CONFIRM TRANSACTION--//
        cartDG14 = DialogHelper.create(getActivity(), R.layout.act04_main_frag01_pos_subfrag03_order_dg14_confirmcharge);
        cartDG14_OrderType = cartDG14.findViewById(R.id.M04F01SF03D14_OrderType);
        cartDG14_TableCustomerDetail = cartDG14.findViewById(R.id.M04F01SF03D14_TableOrCustomer);
        cartDG14_Cashier = cartDG14.findViewById(R.id.M04F01SF03D14_Cashier);
        cartDG14_RecyclerView = cartDG14.findViewById(R.id.M04F01SF03D14_ItemsRV);
        cartDG14_SubTotal = cartDG14.findViewById(R.id.M04F01SF03D14_SubTotalNo);
        cartDG14_Tax = cartDG14.findViewById(R.id.M04F01SF03D14_TaxNo);
        cartDG14_ServiceFee = cartDG14.findViewById(R.id.M04F01SF03D14_ServiceFeeNo);
        cartDG14_Discount = cartDG14.findViewById(R.id.M04F01SF03D14_DiscountNo);
        cartDG14_AmountDue = cartDG14.findViewById(R.id.M04F01SF03D14_AmountDueNo);
        cartDG14_PaymentMethod = cartDG14.findViewById(R.id.M04F01SF03D14_PaymentMethod);
        cartDG14_AmountRecieved = cartDG14.findViewById(R.id.M04F01SF03D14_AmountRecieved);
        cartDG14_Change = cartDG14.findViewById(R.id.M04F01SF03D14_ChangeNo);
        cartDG14_ItemCount = cartDG14.findViewById(R.id.M04F01SF03D14_TotalItemsNo);
        cartDG14_DateAndTime = cartDG14.findViewById(R.id.M04F01SF03D14_DateAndTime);
        cartDG14_YesBtn = cartDG14.findViewById(R.id.M04F01SF03D14_YesBtn);
        cartDG14_NoBtn = cartDG14.findViewById(R.id.M04F01SF03D14_NoBtn);
        closeDG14Btn = cartDG14.findViewById(R.id.M04F01SF03D14_CloseDGBtn);

        //--DG15 TRANSACTION COMPLETE--//
        cartDG15 = DialogHelper.create(getActivity(), R.layout.act04_main_frag01_pos_subfrag03_order_dg15_transactioncomplete);
        cartDG15_SalesNumber = cartDG15.findViewById(R.id.M04F01SF03D15_ReceiptNo);
        cartDG15_OrderType = cartDG15.findViewById(R.id.M04F01SF03D15_OrderType);
        cartDG15_TableCustomerDetail = cartDG15.findViewById(R.id.M04F01SF03D15_TableOrCustomer);
        cartDG15_Cashier = cartDG15.findViewById(R.id.M04F01SF03D15_Cashier);
        cartDG15_RecyclerView = cartDG15.findViewById(R.id.M04F01SF03D15_ItemsRV);
        cartDG15_SubTotal = cartDG15.findViewById(R.id.M04F01SF03D15_SubTotalNo);
        cartDG15_Tax = cartDG15.findViewById(R.id.M04F01SF03D15_TaxNo);
        cartDG15_ServiceFee = cartDG15.findViewById(R.id.M04F01SF03D15_ServiceFeeNo);
        cartDG15_Discount = cartDG15.findViewById(R.id.M04F01SF03D15_DiscountNo);
        cartDG15_AmountDue = cartDG15.findViewById(R.id.M04F01SF03D15_AmountDueNo);
        cartDG15_PaymentMethod = cartDG15.findViewById(R.id.M04F01SF03D15_PaymentMethod);
        cartDG15_AmountRecieved = cartDG15.findViewById(R.id.M04F01SF03D15_AmountRecieved);
        cartDG15_Change = cartDG15.findViewById(R.id.M04F01SF03D15_ChangeNo);
        cartDG15_ItemCount = cartDG15.findViewById(R.id.M04F01SF03D15_TotalItemsNo);
        cartDG15_DateAndTime = cartDG15.findViewById(R.id.M04F01SF03D15_DateAndTime);
        cartDG15_PrintBtn = cartDG15.findViewById(R.id.M04F01SF03D15_PrintBtn);
        cartDG15_CloseBtn = cartDG15.findViewById(R.id.M04F01SF03D15_CloseBtn);
        closeDG15Btn = cartDG15.findViewById(R.id.M04F01SF03D15_CloseDGBtn);

        //--DG16 OVERWRITE TICKET--//
        cartDG16 = DialogHelper.create(getActivity(), R.layout.act04_main_frag01_pos_subfrag03_order_dg16_confirmoverwriteticket);
        cartDG16_OrderName = cartDG16.findViewById(R.id.M04F01SF03D16_TicketNameText);
        cartDG16_YesBtn = cartDG16.findViewById(R.id.M04F01SF03D16_YesBtn);
        cartDG16_NoBtn = cartDG16.findViewById(R.id.M04F01SF03D16_NoBtn);
        closeDG16Btn = cartDG16.findViewById(R.id.M04F01SF03D16_CloseDGBtn);
    }

    //DG to display the Applied Discounts to the Selected Item upon clicking an Item in the cart
    private void load_DG01Functionalities(DialogBundle bundle){
        //Unpack Bundle
        CartItem item = bundle.getCartItem();

        //Set Text
        cartDG01_ItemName.setText(item.getItemPOSName());

        //Initialize RecyclerView Items
        List<String> listOfDiscountsKeyset = new ArrayList<>(item.getItemDiscounts().keySet());

        //Initialize RecyclerView
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        cartDG01_RecyclerViewAdapter = new M04F01SF03D01_AppliedDiscountsRVA(getActivity(), realm, item.getItemDiscounts(), listOfDiscountsKeyset, this);
        cartDG01_RecyclerView.setAdapter(cartDG01_RecyclerViewAdapter);
        cartDG01_RecyclerView.setLayoutManager(layout);

        //On Apply Discount Button
        cartDG01_AddDiscountBtn.setOnClickListener(apply -> {
            load_DG02Functionalities(bundle);
            cartDG01.dismiss();
            cartDG02.show();
        });

        //On Close Button
        closeDG01Btn.setOnClickListener(close -> {
            cartDG01.dismiss();
        });
    }

    //DG to display the Selectable Discounts to Apply to the Selected Item upon clicking the "Add Discount" from DG01
    private void load_DG02Functionalities(DialogBundle bundle){
        //Unpack Bundle
        CartItem item = bundle.getCartItem();

        //Initialize RecyclerView Items
        Map<String, Integer> listOfDiscounts = new TreeMap<>();
        RealmResults<RealmDiscount> queriedDiscounts = realm.where(RealmDiscount.class).sort("discountName").findAll();
        for(RealmDiscount query : queriedDiscounts){
            if(!item.getItemDiscounts().containsKey(query.getDiscountName())){
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
                if(currentCartTicket != null) {
                    currentCartTicket.setTicketStatus("Voidable");
                }
                for(Map.Entry<String, Integer> discount : listOfDiscountsToApply.entrySet()){
                    item.getItemDiscounts().put(discount.getKey(), discount.getValue());
                }
                cartRVA.notifyDataSetChanged();
                load_OrderDetails();
                cartDG02.dismiss();
                ToastHelper.show(getActivity(), "Discount Applied!");
            } else {
                Toast.makeText(getActivity(), "Please Select A Discount", Toast.LENGTH_SHORT).show();
            }
        });

        //Initialize CloseDG Button
        closeDG02Btn.setOnClickListener(close -> {
            cartDG02.dismiss();
        });
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
        } else {
            cartDG03_DineInBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
            cartDG03_TakeOutBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
            cartDG03_DeliveryBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
            cartDG03_PickUpBtn.setCardBackgroundColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
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

        cartDG03_ClearBtn.setOnClickListener(cl -> {
            currentCartOrderType = null;
            load_OrderDetails();
            cartDG03.dismiss();
        });

        closeDG03Btn.setOnClickListener(close -> {
            cartDG03.dismiss();
        });
    }

    //DG to display the Discounts Applied and their items upon clicking
    private void load_DG04Functionalities(){
        //Initialize RecyclerView
        Map<String, Integer> listOfDiscountsApplied = CartHelper.getAppliedDiscounts();
        List<String> listOfDiscountsAppliedKeyset = new ArrayList<>(listOfDiscountsApplied.keySet());
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        cartDG04_RecyclerViewAdapter = new M04F01SF03D04_AppliedDiscountsRVA(getActivity(), realm, cartDG04, listOfDiscountsApplied, listOfDiscountsAppliedKeyset, this, this);
        cartDG04_RecyclerView.setAdapter(cartDG04_RecyclerViewAdapter);
        cartDG04_RecyclerView.setLayoutManager(layout);

        //On Click Add Discount Btn
        cartDG04_AddDiscountBtn.setOnClickListener(add -> {
            load_DG06Functionalities();
            cartDG04.dismiss();
            cartDG06.show();
        });

        //On Close Button
        closeDG04Btn.setOnClickListener(close -> {
            cartDG04.dismiss();
        });
    }

    //DG to display the Items Applied with the Selected Discount
    private void load_DG05Functionalities(DialogBundle bundle){
        //Unpack Bundle
        String discount = bundle.getDiscount().getDiscountName();

        //Set Discount Name
        cartDG05_DiscountName.setText(discount);

        //Initialize RecyclerView
        List<CartItem> itemsAppliedWithCurrentDiscount = CartHelper.getItemsAppliedWith(discount);
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        cartDG05_RecyclerViewAdapter = new M04F01SF03D05_ItemsAppliedWithDiscountRVA(getActivity(), realm, discount, cartDG05, itemsAppliedWithCurrentDiscount, this, this);
        cartDG05_RecyclerView.setAdapter(cartDG05_RecyclerViewAdapter);
        cartDG05_RecyclerView.setLayoutManager(layout);

        //On Close
        closeDG05Btn.setOnClickListener(close -> {
            cartDG05.dismiss();
        });
    }

    //DG to display the Selectable Discounts to Apply to All Items
    private void load_DG06Functionalities(){
        //Initialize RecyclerView
        Map<String, Integer> listOfDiscounts = CartHelper.getListOfDiscounts(realm);
        List<String> listOfDiscountsKeyset = new ArrayList<>(listOfDiscounts.keySet());
        Map<String, Integer> listOfDiscountsToApply = new TreeMap<>();
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        cartDG06_RecyclerViewAdapter = new M04F01SF03D06_SelectDiscountToApplyRVA(getActivity(), realm, listOfDiscounts, listOfDiscountsKeyset, listOfDiscountsToApply);
        cartDG06_RecyclerView.setAdapter(cartDG06_RecyclerViewAdapter);
        cartDG06_RecyclerView.setLayoutManager(layout);

        //Initialize Confirm Button
        cartDG06_ApplyToAllBtn.setOnClickListener(confirm -> {
            if(!listOfDiscountsToApply.isEmpty()){
                if(currentCartTicket != null) {
                    currentCartTicket.setTicketStatus("Voidable");
                }
                for(Map.Entry<String, Integer> discount : listOfDiscountsToApply.entrySet()){
                    for(CartItem item : cart.keySet()){
                        item.getItemDiscounts().put(discount.getKey(), discount.getValue());
                    }
                }
                cartRVA.notifyDataSetChanged();
                load_OrderDetails();
                cartDG06.dismiss();
            } else {
                Toast.makeText(getActivity(), "Please Select A Discount", Toast.LENGTH_SHORT).show();
            }
        });

        //Initialize CloseDG Button
        closeDG06Btn.setOnClickListener(close -> {
            cartDG06.dismiss();
        });
    }

    //DG to display the when saving a ticket under Dine In and Take out
    private void load_DG07Functionalities(DialogBundle bundle){
        //Initialize RecyclerView
        List<Table> listOfTables = CartHelper.getListOfFreeTable(realm);
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        cartDG07_RecyclerViewAdapter = new M04F01SF03D07_SelectTableRVA(getActivity(), realm, listOfTables);
        cartDG07_RecyclerView.setAdapter(cartDG07_RecyclerViewAdapter);
        cartDG07_RecyclerView.setLayoutManager(layout);

        //On Confirm Btn
        cartDG07_ConfirmBtn.setOnClickListener(confirm -> {
            String input = cartDG07_DetailsInput.getText().toString();
            if(selectedTable != null){
                Table table = selectedTable;
                bundle.setDialogDestinationNo(9);
                bundle.setTable(table);
                bundle.setAdditionalDetails(input);
                load_DG09Functionalities(bundle);
                cartDG07.dismiss();
                cartDG09.show();
            } else {
                ToastHelper.show(getActivity(), "Please select a Table");
            }
        });

        //On Close DG Btn
        closeDG07Btn.setOnClickListener(close -> {
            cartDG07.dismiss();
        });

        //On Dismiss
        cartDG07.setOnDismissListener(dismiss -> {
            selectedTable = null;
        });

    }

    //DG to display the when saving a ticket under Delivery and Pick Up
    private void load_DG08Functionalities(DialogBundle bundle){
        //On Load
        cartDG08_NameInput.getText().clear();
        cartDG08_DetailInput.getText().clear();
        //On Confirm
        cartDG08_ConfirmBtn.setOnClickListener(confirm -> {
            //Extract String
            String nameInput = cartDG08_NameInput.getText().toString();
            String detailInput = cartDG08_DetailInput.getText().toString();
            //Check if nameInput Is Empty
            if(nameInput.equals("")){
                ToastHelper.show(getActivity(), "Please Enter A Customer Name");
            } else {
                bundle.setDialogDestinationNo(9);
                bundle.setCustomerName(nameInput);
                bundle.setAdditionalDetails(detailInput);
                load_DG09Functionalities(bundle);
                cartDG08.dismiss();
                cartDG09.show();
            }
        });
        //On Close
        closeDG08Btn.setOnClickListener(close -> {
            cartDG08.dismiss();
        });
    }

    //DG to display the when confirming to save ticket
    private void load_DG09Functionalities(DialogBundle bundle){
        //Unpack Bundle
        Table table = bundle.getTable();
        String customerName = bundle.getCustomerName();
        String details = bundle.getAdditionalDetails();
        double subTotalAmount = bundle.getSubTotalAmount();
        double taxAmount = bundle.getTaxAmount();
        double serviceFeeAmount = bundle.getServiceFeeAmount();
        double discountAmount = bundle.getDiscountAmount();
        double totalAmount = bundle.getAmountDue();

        //Load Details
        RealmUser user = realm.where(RealmUser.class).findFirst();
        String tcDetail = (table != null) ? (table.getTableNo() < 9)
                        ? table.getTableName() + " 0" + table.getTableNo()
                        : table.getTableName() + " " + table.getTableNo()
                        : customerName;
        String cashier = user.getUserName();
        String orderDetails = details;

//                (!details.equals("") && details.length() > 60)
//                            ? StringHelper.trim(details, 15) + "\n" + StringHelper.resume(details, 16)
//                            : (!details.equals("") && details.length() <  15)
//                            ? details
//                            : " N/A";
        String orderType = currentCartOrderType;
        String itemCount = String.valueOf(cart.values().stream().mapToInt(i->i).sum());
        String dateAndtime = new SimpleDateFormat("MMMM dd , yyyy | hh:mm a").format(new Date());

        //Set Views
        cartDG09_TableCustomerDetail.setText("Order : " + tcDetail);
        cartDG09_Cashier.setText("Cashier : " + cashier);
        cartDG09_OrderDetails.setText(orderDetails);
        cartDG09_OrderType.setText(orderType.toUpperCase());
        cartDG09_ItemCount.setText("[" + itemCount + "] Items");
        cartDG09_DateAndTime.setText(dateAndtime);

        //Initialize RecyclerView
        List<CartItem> cartItems = new ArrayList<>(cart.keySet());
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        cartDG09_RecyclerViewAdapter = new M04F01SF03D09_SaveTicketRVA(getActivity(), realm, cartItems);
        cartDG09_RecyclerView.setAdapter(cartDG09_RecyclerViewAdapter);
        cartDG09_RecyclerView.setLayoutManager(layout);

        //Set Views
        cartDG09_SubTotal.setText(StringHelper.convertToCurrency(subTotalAmount));
        cartDG09_Tax.setText(StringHelper.convertToCurrency(taxAmount));
        cartDG09_ServiceFee.setText(StringHelper.convertToCurrency(serviceFeeAmount));
        cartDG09_Discount.setText(StringHelper.convertToCurrency(discountAmount));
        cartDG09_AmountDue.setText(StringHelper.convertToCurrency(totalAmount));

        //Initialize Yes and No Buttons
        cartDG09_YesBtn.setOnClickListener(save -> {
            //Save the Ticket to Database
            List<String> itemWebName = new ArrayList<>();
            List<String> itemPOSName = new ArrayList<>();
            List<Double> itemPrice = new ArrayList<>();
            List<Integer> itemQty = new ArrayList<>();
            List<String> discountItem = new ArrayList<>();
            List<String> discountName = new ArrayList<>();
            List<Integer> discountPercentage = new ArrayList<>();
            for(Map.Entry<CartItem, Integer> cartItem : cart.entrySet()){
                String webName = cartItem.getKey().getItemWebName();
                String name = cartItem.getKey().getItemPOSName();
                double price = cartItem.getKey().getItemPrice();
                int frequency = cartItem.getValue();
                Map<String, Integer> discounts = cartItem.getKey().getItemDiscounts();
                itemWebName.add(webName);
                itemPOSName.add(name);
                itemPrice.add(price);
                itemQty.add(frequency);
                for(Map.Entry<String, Integer> discount : discounts.entrySet()){
                    discountItem.add(name);
                    discountName.add(discount.getKey());
                    discountPercentage.add(discount.getValue());
                }
            }

            OpenTicketInstance.toCreateTicket(tcDetail, cashier, details, orderType, itemWebName, itemPOSName, itemPrice, itemQty, discountItem, discountName, discountPercentage);
            Map<CartItem, Integer> tempCart = new LinkedHashMap<>();
            for(Map.Entry<CartItem, Integer> item : cart.entrySet()){
                tempCart.put(item.getKey(), item.getValue());
            }
            Ticket ticket = new Ticket(tcDetail, cashier, orderType, tempCart, dateAndtime);
            if(table != null) {
                OpenTableInstance.toSetTableStatusToOccupied(table.getTableName(), table.getTableNo());
            }
            cart.clear();
            cartRVA.notifyDataSetChanged();
            currentCartOrderType = "None";
            load_OrderDetails();
            cartDG09.dismiss();
            try {
                PrintHelper.printTicket(ticket);
            } catch (IOException e) {
                e.printStackTrace();
            }
            ToastHelper.show(getActivity(), "Ticket Saved");
        });

        //On No
        cartDG09_NoBtn.setOnClickListener(close -> {
            cartDG09.dismiss();
        });

        //Initialize Close DG Button
        closeDG09Btn.setOnClickListener(close -> {
            cartDG09.dismiss();
        });
    }

    //DG to display tickets
    private void load_DG10Functionalities(){
        //Initialize RecyclerView
        List<Ticket> listOfTickets = CartHelper.getListOfTickets(realm);
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        cartDG10_RecyclerViewAdapter = new M04F01SF03D10_ManageTicketRVA(getActivity(), realm, cartDG10, listOfTickets, this, this);
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
            cartDG10_RecyclerViewAdapter = new M04F01SF03D10_ManageTicketRVA(getActivity(), realm, cartDG10, dineInTickets, this, this);
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
            cartDG10_RecyclerViewAdapter = new M04F01SF03D10_ManageTicketRVA(getActivity(), realm, cartDG10, takeOutTickets, this, this);
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
            cartDG10_RecyclerViewAdapter = new M04F01SF03D10_ManageTicketRVA(getActivity(), realm, cartDG10, deliveryTickets, this, this);
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
            cartDG10_RecyclerViewAdapter = new M04F01SF03D10_ManageTicketRVA(getActivity(), realm, cartDG10, pickUpTickets, this, this);
            cartDG10_RecyclerViewAdapter.notifyDataSetChanged();
            cartDG10_RecyclerView.setAdapter(cartDG10_RecyclerViewAdapter);
        });

        //Initialize Close Button
        closeDG10Btn.setOnClickListener(close -> {
            cartDG10.dismiss();
        });
    }

    //DG to display upon trying to delete a saved ticket
    private void load_DG11Functionalities(DialogBundle bundle){
        //Unpack Bundle
        Ticket ticket = bundle.getTicket();

        //Load Details
        String order = ticket.getOrder();
        String orderType = ticket.getOrderType();
        String ticketName = ticket.getOrderType() + " - " + ticket.getOrder();

        //Set View
        cartDG11_TicketText.setText(ticketName + "?");

        //On Yes Btn
        cartDG11_YesBtn.setOnClickListener(yes -> {
            PrintHelper.voidTicket(ticket);
            if(orderType.equals("Dine In") || orderType.equals("Take Out")){
                String tableName = StringHelper.getTableName(order);
                int tableNo = StringHelper.getTableNumber(order);
                OpenTableInstance.toSetTableStatusToFree(tableName, tableNo);
            }
            if(currentCartTicket == ticket) {
                currentCartTicket = null;
            }
            OpenTicketInstance.toDeleteTicket(ticket.getTicketID());
            load_OrderDetails();
            cartDG11.dismiss();
        });

        //On Delete Btn
        cartDG11_NoBtn.setOnClickListener(no -> {
            cartDG11.dismiss();
        });

        //On Close Btn
        closeDG11Btn.setOnClickListener(not -> {
            load_DG10Functionalities();
            cartDG11.dismiss();
            cartDG10.show();
        });
    }

    //DG to display upon clicking the order details if currentTicket is !null
    private void load_DG12Functionalities(){
        //Load Details
        String details = currentCartTicket.getDetails();

        //SetView
        cartDG12_DetailsText.setText(details);

        //On Close
        closeDG12Btn.setOnClickListener(close -> {
            cartDG12.dismiss();
        });
    }

    //DG to display upon clicking charge
    private void load_DG13Functionalities(DialogBundle bundle){
        //Unpack Bundle
        double amountDue = bundle.getAmountDue();
        String order = bundle.getOrderName();
        String orderType = bundle.getOrderType();
        double subTotalAmount = bundle.getSubTotalAmount();
        double taxAmount = bundle.getTaxAmount();
        double serviceFeeAmount = bundle.getServiceFeeAmount();
        double discountAmount = bundle.getDiscountAmount();

        //Load Details
        List<PaymentMethod> listOfMethods = CartHelper.getPaymentMethods(realm);
        String amountToBePaid = "「" + StringHelper.convertToCurrency(amountDue) + "」";
        String orderName = orderType + " - " + order;
        String subTotalVal = StringHelper.convertToCurrency(subTotalAmount);
        String taxVal = StringHelper.convertToCurrency(taxAmount);
        String serviceFeeVal = StringHelper.convertToCurrency(serviceFeeAmount);
        String discountVal = StringHelper.convertToCurrency(discountAmount);

        //SetViews
        cartDG13_AmountDue.setText(amountToBePaid);
        cartDG13_OrderName.setText(orderName);
        cartDG13_SubTotal.setText(subTotalVal);
        cartDG13_Tax.setText(taxVal);
        cartDG13_ServiceFee.setText(serviceFeeVal);
        cartDG13_Discount.setText(discountVal);
        cartDG13_AmountInput.setText("");
        cartDG13_Method.setText("None");

        cartDG13_PrevMethod.setOnClickListener(prev -> {
            if(!listOfMethods.isEmpty()){
                if(indexMethod == -1){
                    indexMethod = listOfMethods.size()-1;
                    selectedMethod = listOfMethods.get(indexMethod).getMethodName();
                    cartDG13_Method.setText(selectedMethod);
                } else if(indexMethod == 0){
                    indexMethod = listOfMethods.size()-1;
                    selectedMethod = listOfMethods.get(indexMethod).getMethodName();
                    cartDG13_Method.setText(selectedMethod);
                } else {
                    indexMethod--;
                    selectedMethod = listOfMethods.get(indexMethod).getMethodName();
                    cartDG13_Method.setText(selectedMethod);
                }
            }
        });

        //On Prev Btn
        cartDG13_NextMethod.setOnClickListener(next -> {
            if(!listOfMethods.isEmpty()){
                if(indexMethod == -1){
                    indexMethod = 0;
                    selectedMethod = listOfMethods.get(indexMethod).getMethodName();
                    cartDG13_Method.setText(selectedMethod);
                } else if(indexMethod + 1 < listOfMethods.size()){
                    indexMethod++;
                    selectedMethod = listOfMethods.get(indexMethod).getMethodName();
                    cartDG13_Method.setText(selectedMethod);
                } else if(indexMethod + 1 == listOfMethods.size()){
                    indexMethod = 0;
                    selectedMethod = listOfMethods.get(indexMethod).getMethodName();
                    cartDG13_Method.setText(selectedMethod);
                }
            }
        });

        //On Confirm
        cartDG13_ConfirmBtn.setOnClickListener(confirm -> {
            if(selectedMethod != null){
                double amountInput = Double.parseDouble(cartDG13_AmountInput.getText().toString());
                if(amountInput < amountDue){
                    ToastHelper.show(getActivity(), "Cannot accept payment that's lower than the due amount");
                } else {
                    bundle.setAmountRecieved(amountInput);
                    bundle.setPaymentMethod(selectedMethod);
                    load_DG14Functionalities(bundle);
                    cartDG13.dismiss();
                    cartDG14.show();
                }

            } else {
                ToastHelper.show(getActivity(), "Please select Payment Method");
            }
        });

        //On Close DG Btn
        closeDG13Btn.setOnClickListener(close -> {
            cartDG13.dismiss();
        });

        //On Dismiss
        cartDG13.setOnDismissListener(dismiss -> {
            indexMethod = -1;
            selectedMethod = null;
        });
    }

    //DG to display to confirm the charge
    private void load_DG14Functionalities(DialogBundle bundle){
        //Unpack Bundle
        String order = bundle.getOrderName();
        String orderType = bundle.getOrderType();
        String paymentMethod = bundle.getPaymentMethod();
        double subTotalAmount = bundle.getSubTotalAmount();
        double taxAmount = bundle.getTaxAmount();
        double serviceFeeAmount = bundle.getServiceFeeAmount();
        double discountAmount = bundle.getDiscountAmount();
        double totalAmount = bundle.getAmountDue();
        double amountRecieved = bundle.getAmountRecieved();
        double change = amountRecieved - totalAmount;

        //Load Other Details
        RealmUser user = realm.where(RealmUser.class).findFirst();
        String cashier = user.getUserName();
        String amountSubTotal = StringHelper.convertToCurrency(subTotalAmount);
        String amountTax = StringHelper.convertToCurrency(taxAmount);
        String amountServiceFee = StringHelper.convertToCurrency(serviceFeeAmount);
        String amountDiscount = StringHelper.convertToCurrency(discountAmount);
        String amountToPay = StringHelper.convertToCurrency(totalAmount);
        String amountPaid = StringHelper.convertToCurrency(amountRecieved);
        String changeAmount = StringHelper.convertToCurrency(change);
        String itemCount = String.valueOf(cart.values().stream().mapToInt(i->i).sum());
        String dateAndtime = new SimpleDateFormat("MMMM dd , yyyy | hh:mm a").format(new Date());

        //Set Views
        cartDG14_TableCustomerDetail.setText("Order : " + order);
        cartDG14_Cashier.setText("Cashier : " + cashier);
        cartDG14_OrderType.setText(orderType.toUpperCase());
        cartDG14_ItemCount.setText("[" + itemCount + "] Items");
        cartDG14_DateAndTime.setText(dateAndtime);

        //Initialize RecyclerView
        List<CartItem> cartItems = new ArrayList<>(cart.keySet());
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        cartDG14_RecyclerViewAdapter = new M04F01SF03D14_ConfirmTransactionRVA(getActivity(), realm, cartItems);
        cartDG14_RecyclerView.setAdapter(cartDG14_RecyclerViewAdapter);
        cartDG14_RecyclerView.setLayoutManager(layout);

        //Set Views 02
        cartDG14_SubTotal.setText(amountSubTotal);
        cartDG14_Tax.setText(amountTax);
        cartDG14_ServiceFee.setText(amountServiceFee);
        cartDG14_Discount.setText(amountDiscount);
        cartDG14_AmountDue.setText(amountToPay);
        cartDG14_PaymentMethod.setText(paymentMethod);
        cartDG14_AmountRecieved.setText(amountPaid);
        cartDG14_Change.setText(changeAmount);

        //On Yes Btn
        double subTotalTotal = finalSubTotal;
        double taxesTotal = finalTax;
        double serviceFeeTotal = finalServiceFee;
        double discountTotal = finalDiscount;
        cartDG14_YesBtn.setOnClickListener(yes -> {
            //Save the Tranasction to Database
            List<String> itemWebName = new ArrayList<>();
            List<String> itemPOSName = new ArrayList<>();
            List<Double> itemPrice = new ArrayList<>();
            List<Integer> itemQty = new ArrayList<>();
            List<String> discountItem = new ArrayList<>();
            List<String> discountName = new ArrayList<>();
            List<Integer> discountPercentage = new ArrayList<>();
            for(Map.Entry<CartItem, Integer> cartItem : cart.entrySet()){
                String webName = cartItem.getKey().getItemWebName();
                String posName = cartItem.getKey().getItemPOSName();
                double price = cartItem.getKey().getItemPrice();
                int frequency = cartItem.getValue();
                Map<String, Integer> discounts = cartItem.getKey().getItemDiscounts();
                itemWebName.add(webName);
                itemPOSName.add(posName);
                itemPrice.add(price);
                itemQty.add(frequency);
                for(Map.Entry<String, Integer> discount : discounts.entrySet()){
                    discountItem.add(posName);
                    discountName.add(discount.getKey());
                    discountPercentage.add(discount.getValue());
                }
            }
            OpenTransactionsInstance.toCreateSales(order,
                                                    cashier,
                                                    orderType,
                                                    itemWebName,
                                                    itemPOSName,
                                                    itemPrice,
                                                    itemQty,
                                                    discountItem,
                                                    discountName,
                                                    discountPercentage,
                                                    Integer.parseInt(itemCount),
                                                    subTotalTotal,
                                                    taxesTotal,
                                                    serviceFeeTotal,
                                                    discountTotal,
                                                    totalAmount,
                                                    paymentMethod,
                                                    amountRecieved,
                                                    change);
            if(orderType.equals("Dine In") || orderType.equals("Take Out")){
                if(!order.equals("Table 00 [Default]")){
                    String name = StringHelper.getTableName(order);
                    int no = StringHelper.getTableNumber(order);
                    OpenTableInstance.toSetTableStatusToFree(name, no);
                }
            }
            if(currentCartTicket != null){
                OpenTicketInstance.toDeleteTicket(currentCartTicket.getTicketID());
            }
            currentCartTicket = null;
            currentCartOrderType = null;
            cart.clear();
            cartRVA.notifyDataSetChanged();
            load_OrderDetails();
            load_DG15Functionalities();
            cartDG14.dismiss();
            cartDG15.show();
        });

        //On No Btn
        cartDG14_NoBtn.setOnClickListener(no -> {
            cartDG14.dismiss();
        });

        //On Close
        closeDG14Btn.setOnClickListener(close -> {
            cartDG14.dismiss();
        });
    }

    //DG to display upon saving the transaction
    private void load_DG15Functionalities(){
        //Get Latest Transaction
        SalesTransaction latestSale = CartHelper.getLatestTranscation(realm);
        try {
            PrintHelper.printSalesReceipt(latestSale);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Unpack Sales
        Map<CartItem, Integer> items = latestSale.getItems();
        String transactionNo = latestSale.getTransactionNo();
        String dateAndTime = latestSale.getDateAndTime();
        String order = latestSale.getOrder();
        String cashier = latestSale.getCashier();
        String orderType = latestSale.getOrderType();
        String total = StringHelper.convertToCurrency(latestSale.getTotalAmountDue());
        String discount = StringHelper.convertToCurrency(latestSale.getTotalDiscount());
        String tax = StringHelper.convertToCurrency(latestSale.getTotalTax());
        String paymentMethod = latestSale.getPaymentMethod();
        String amountPaid = StringHelper.convertToCurrency(latestSale.getTotalPayment());
        String change = StringHelper.convertToCurrency(latestSale.getChange());
        String itemCount = String.valueOf(latestSale.getTotalItems());

        //Set Views
        cartDG15_SalesNumber.setText(transactionNo);
        cartDG15_OrderType.setText(orderType.toUpperCase());
        cartDG15_TableCustomerDetail.setText("Order : " + order);
        cartDG15_Cashier.setText("Cashier : " + cashier);
        cartDG15_AmountDue.setText(total);
        cartDG15_Discount.setText(discount);
        cartDG15_Tax.setText(tax);
        cartDG15_PaymentMethod.setText(paymentMethod);
        cartDG15_AmountRecieved.setText(amountPaid);
        cartDG15_Change.setText(change);
        cartDG15_ItemCount.setText("[" + itemCount + "] items");
        cartDG15_DateAndTime.setText(dateAndTime);

        //Initialize RecyclerView
        List<CartItem> itemList = new ArrayList<>(items.keySet());
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        cartDG15_RecyclerViewAdapter = new M04F01SF03D15_TransactionCompleteRVA(getActivity(), realm, itemList, items);
        cartDG15_RecyclerView.setAdapter(cartDG15_RecyclerViewAdapter);
        cartDG15_RecyclerView.setLayoutManager(layout);

        //On Print
        cartDG15_PrintBtn.setOnClickListener(print -> {
            try {
                PrintHelper.printSalesReceipt(latestSale);
            } catch (IOException e) {
                e.printStackTrace();
            }
            cartDG15.dismiss();
        });

        //On Close [Close]
        cartDG15_CloseBtn.setOnClickListener(close -> {
            cartDG15.dismiss();
        });

        //On Close [x]
        closeDG15Btn.setOnClickListener(close -> {
            cartDG15.dismiss();
        });
    }

    //DG to display if currentticket is voidable
    private void load_DG16Functionalities(){
        //Unpack Bundle
        Ticket ticket = currentCartTicket;

        //Set Views
        cartDG16_OrderName.setText(ticket.getOrder() + "?");

        //On Yes
        cartDG16_YesBtn.setOnClickListener(yes -> {
            PrintHelper.voidTicket(ticket);
            List<String> itemWebName = new ArrayList<>();
            List<String> itemPOSName = new ArrayList<>();
            List<Double> itemPrice = new ArrayList<>();
            List<Integer> itemQty = new ArrayList<>();
            List<String> discountItem = new ArrayList<>();
            List<String> discountName = new ArrayList<>();
            List<Integer> discountPercentage = new ArrayList<>();
            for(Map.Entry<CartItem, Integer> cartItem : cart.entrySet()){
                String webName = cartItem.getKey().getItemWebName();
                String name = cartItem.getKey().getItemPOSName();
                double price = cartItem.getKey().getItemPrice();
                int frequency = cartItem.getValue();
                Map<String, Integer> discounts = cartItem.getKey().getItemDiscounts();
                itemWebName.add(webName);
                itemPOSName.add(name);
                itemPrice.add(price);
                itemQty.add(frequency);
                for(Map.Entry<String, Integer> discount : discounts.entrySet()){
                    discountItem.add(name);
                    discountName.add(discount.getKey());
                    discountPercentage.add(discount.getValue());
                }
            }
            OpenTicketInstance.toCreateTicket(ticket.getOrder(), ticket.getCashier(), ticket.getDetails(), ticket.getOrderType(), itemWebName, itemPOSName, itemPrice, itemQty, discountItem, discountName, discountPercentage);
            OpenTicketInstance.toDeleteTicket(ticket.getTicketID());
            currentCartTicket = null;
            cart.clear();
            cartRVA.notifyDataSetChanged();
            load_OrderDetails();
            posContent.updatePOS();
            cartDG16.dismiss();
        });

        //On No
        cartDG16_NoBtn.setOnClickListener(no -> {
            cartDG16.dismiss();
        });

        //On Close
        closeDG16Btn.setOnClickListener(close -> {
            cartDG16.dismiss();
        });
    }

    public void refreshCartAdapter(){
        int orientation = getActivity().getResources().getConfiguration().orientation;
        int screenLayoutSize = getActivity().getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
        if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            cartRVA.notifyDataSetChanged();
            load_OrderDetails();
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof RefreshPOS){
            posContent = (RefreshPOS) context;
        } else {
            throw new RuntimeException(context.toString() + "Must implement Fragment");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        posContent = null;
    }

    @Override
    public void load_FGContents() {
        cartRVA.notifyDataSetChanged();
        load_OrderDetails();
        int orientation = getActivity().getResources().getConfiguration().orientation;
        int screenLayoutSize = getActivity().getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
        if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            posContent.updatePOS();
        }
    }

    @Override
    public void load_DGContents(DialogBundle bundle) {
        int dialogNo = bundle.getDialogDestinationNo();
        switch(dialogNo){
            case 1:
                load_DG01Functionalities(bundle);
                cartDG01.show();
                break;
            case 5:
                load_DG05Functionalities(bundle);
                cartDG05.show();
                break;
            case 11:
                load_DG11Functionalities(bundle);
                cartDG11.show();
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
            List<CartItem> items = new ArrayList<>(cart.keySet());
            CartItem item = items.get(position);
            cart.remove(item);
            cartRVA.notifyDataSetChanged();
            load_OrderDetails();
            int orientation = getActivity().getResources().getConfiguration().orientation;
            int screenLayoutSize = getActivity().getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
            if(orientation == Configuration.ORIENTATION_LANDSCAPE){
                posContent.updatePOS();
            }
        }
    };
}
