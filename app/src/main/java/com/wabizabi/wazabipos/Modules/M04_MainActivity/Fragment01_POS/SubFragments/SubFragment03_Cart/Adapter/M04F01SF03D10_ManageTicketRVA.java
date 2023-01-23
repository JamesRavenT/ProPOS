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

import com.wabizabi.wazabipos.Database.Instances.OpenTableInstance;
import com.wabizabi.wazabipos.Database.Instances.OpenTicketInstance;
import com.wabizabi.wazabipos.Database.ObjectSchemas.Ticket;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Interfaces.FragmentLoader;
import com.wabizabi.wazabipos.Utilities.Objects.CartObject;

import java.util.List;
import java.util.Map;

import io.realm.Realm;

public class M04F01SF03D10_ManageTicketRVA extends RecyclerView.Adapter<M04F01SF03D10_ManageTicketRVA.ViewHolder> {

    Context context;
    Realm realm;
    Dialog dialog;
    List<Ticket> listOfTickets;
    FragmentLoader fragmentLoader;

    public M04F01SF03D10_ManageTicketRVA(Context context, Realm realm, Dialog dialog, List<Ticket> listOfTickets, FragmentLoader fragmentLoader) {
        this.context = context;
        this.realm = realm;
        this.dialog = dialog;
        this.listOfTickets = listOfTickets;
        this.fragmentLoader = fragmentLoader;
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
        holder.loadDetails(ticket, position);
        holder.onClickTicket(ticket, position);
        holder.onClickDeleteBtn(ticket, position);
    }

    @Override
    public int getItemCount() {
        return listOfTickets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        private ConstraintLayout ticketContainer;
        private TextView dateAndTime, orderType, customerTable, cashier, orderDetails;
        private ImageView deleteBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ticketContainer = itemView.findViewById(R.id.M04F01SF03D10_RVContainer);
            dateAndTime = itemView.findViewById(R.id.M04F01SF03D10_RVDateAndTimeText);
            orderType = itemView.findViewById(R.id.M04F01SF03D10_RVOrderType);
            customerTable = itemView.findViewById(R.id.M04F01SF03D10_RVTableOrCustomerDetail);
            cashier = itemView.findViewById(R.id.M04F01SF03D10_RVCashierName);
            orderDetails = itemView.findViewById(R.id.M04F01SF03D10_RVOrderDetails);
            deleteBtn = itemView.findViewById(R.id.M04F01SF03D10_RVRemoveBtn);
        }

        public void loadDetails(Ticket ticket, int position){
            this.position = position;
            dateAndTime.setText(ticket.getDateAndTime());
            orderType.setText(ticket.getOrderType());
            if(ticket.getOrderType().equals("Dine In") || ticket.getOrderType().equals("Take Out")){
                if(ticket.getTableNumber() < 9) {
                    customerTable.setText(ticket.getTableName() + " " + "0" + ticket.getTableNumber());
                } else {
                    customerTable.setText(ticket.getTableName() + " " + ticket.getTableNumber());
                }

            }
            customerTable.setText(ticket.getCustomerName());
            cashier.setText(ticket.getCashierName());
        }

        public void onClickTicket(Ticket ticket, int position){
            this.position = position;
            ticketContainer.setOnClickListener(load -> {
                cart.clear();
                for(Map.Entry<CartObject, Integer> cartItem : ticket.getItems().entrySet()){
                    cart.put(cartItem.getKey(), cartItem.getValue());
                }
                currentCartTicket = ticket;
                fragmentLoader.load_FGContents();
                dialog.dismiss();
            });
        }

        public void onClickDeleteBtn(Ticket ticket, int position){
            this.position = position;
            deleteBtn.setOnClickListener(delete -> {
                if(ticket.getOrderType().equals("Dine In") || ticket.getOrderType().equals("Take Out")){
                    OpenTableInstance.toSetTableStatusToFree(ticket.getTableName(), ticket.getTableNumber());
                }
                listOfTickets.remove(position);
                OpenTicketInstance.toDeleteTicket(ticket.getTicketID());
                notifyDataSetChanged();
                fragmentLoader.load_FGContents();
            });
        }
    }
}
