package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.M04F01SF03_CartRVA.cart;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.M04F01SF03_Cart.currentCartTicket;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.ObjectSchemas.Ticket;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Interfaces.DialogLoader;
import com.wabizabi.wazabipos.Utilities.Interfaces.FragmentLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.Bundles.DialogBundle;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.StringHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Objects.CartItem;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.realm.Realm;

public class M04F01SF03D10_ManageTicketRVA extends RecyclerView.Adapter<M04F01SF03D10_ManageTicketRVA.ViewHolder> {

    Context context;
    Realm realm;
    Dialog dialog;
    List<Ticket> listOfTickets;
    FragmentLoader fragmentLoader;
    DialogLoader dialogLoader;

    public M04F01SF03D10_ManageTicketRVA(Context context, Realm realm, Dialog dialog, List<Ticket> listOfTickets, FragmentLoader fragmentLoader, DialogLoader dialogLoader) {
        this.context = context;
        this.realm = realm;
        this.dialog = dialog;
        this.listOfTickets = listOfTickets;
        this.fragmentLoader = fragmentLoader;
        this.dialogLoader = dialogLoader;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.act04_main_frag01_pos_subfrag03_order_dg10_managetickets_rvlayout, parent, false);
        ViewHolder layout = new ViewHolder(view);
        return layout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Ticket ticket = listOfTickets.get(position);
        holder.loadFunctionalities(ticket, position);
    }

    @Override
    public int getItemCount() {
        return listOfTickets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        private ConstraintLayout ticketContainer;
        private TextView dateAndTime, orderType, customerTable, cashier, itemCounter, orderDetails;
        private ImageView deleteBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ticketContainer = itemView.findViewById(R.id.M04F01SF03D10_RVContainer);
            dateAndTime = itemView.findViewById(R.id.M04F01SF03D10_RVTimeLapsed);
            orderType = itemView.findViewById(R.id.M04F01SF03D10_RVOrderType);
            customerTable = itemView.findViewById(R.id.M04F01SF03D10_RVTableOrCustomerDetail);
            cashier = itemView.findViewById(R.id.M04F01SF03D10_RVCashierName);
            itemCounter = itemView.findViewById(R.id.M04F01SF03D10_RVItemCount);
            orderDetails = itemView.findViewById(R.id.M04F01SF03D10_RVOrderDetails);
            deleteBtn = itemView.findViewById(R.id.M04F01SF03D10_RVRemoveBtn);

        }

        public void loadFunctionalities(Ticket ticket, int position){
            //Load Details
            String orderName = ticket.getOrderType();
            String order = ticket.getOrder();
            String cashierName = ticket.getCashier();
            String itemCount = String.valueOf(ticket.getItems().values().stream().mapToInt(i->i).sum());
            String details = StringHelper.trim(ticket.getDetails(), 15);
            String timeLapsed = StringHelper.getTimeLapse(ticket.getYear(), ticket.getMonth(), ticket.getDay(), ticket.getHour(), ticket.getMinute());

            //Set Views
            this.position = position;
            dateAndTime.setText(timeLapsed);
            orderType.setText(orderName);
            customerTable.setText("Order : " + order);
            cashier.setText("Cashier : " + cashierName);
            itemCounter.setText("[" + itemCount + "] items");
            orderDetails.setText(details);


            //On Ticket
            ticketContainer.setOnClickListener(load -> {
                cart.clear();
                Map<CartItem, Integer> newCart = new LinkedHashMap<>(ticket.getItems());
                for(Map.Entry<CartItem, Integer> cartItem : newCart.entrySet()){
                    cart.put(cartItem.getKey(), cartItem.getValue());
                }
                currentCartTicket = ticket;
                fragmentLoader.load_FGContents();
                dialog.dismiss();
            });

            //On Delete
            deleteBtn.setOnClickListener(delete -> {
                dialogLoader.load_DGContents(new DialogBundle(11, ticket));
                dialog.dismiss();
            });
        }
    }
}
