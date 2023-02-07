package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Adapters;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.M04F01SF03_CartRVA.cart;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.ObjectSchemas.MenuItem;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Interfaces.DialogLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.Bundles.DialogBundle;
import com.wabizabi.wazabipos.Utilities.Libraries.Bundles.RVBundle;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.IconLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.LayoutHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.StringHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Objects.CartItem;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class M04F01_ItemRVA extends RecyclerView.Adapter<M04F01_ItemRVA.ViewHolder>{

    Context context;
    Realm realm;
    List<MenuItem> listOfItems;
    DialogLoader dialog;

    public M04F01_ItemRVA(Context context, Realm realm, List<MenuItem> listOfItems, DialogLoader dialog) {
        this.context = context;
        this.realm = realm;
        this.listOfItems = listOfItems;
        this.dialog = dialog;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutHelper.inflateRV(parent, R.layout.act04_main_frag01_pos_item_rvlayout);
        ViewHolder layout = new ViewHolder(view);
        return layout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MenuItem item = listOfItems.get(position);
        holder.loadFunctionalities(item, position);
    }

    @Override
    public int getItemCount() {
        return listOfItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        private ConstraintLayout itemStatus;
        private TextView itemStatusText;
        private ImageView itemImage;
        private TextView itemName, itemPrice;
        private CardView addBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemStatus = itemView.findViewById(R.id.M04F01_IRVStatus);
            itemStatusText = itemView.findViewById(R.id.M04F01_IRVStatusCart);
            addBtn = itemView.findViewById(R.id.M04F01_IRVAddToCartBtn);
            itemImage = itemView.findViewById(R.id.M04F01_IRVItemImage);
            itemName = itemView.findViewById(R.id.M04F01_IRVItemName);
            itemPrice = itemView.findViewById(R.id.M04F01_IRVItemPrice);
        }

        public void loadFunctionalities(MenuItem item, int position){
            //Load Details
            String name = StringHelper.limitDisplay(item.getItemPOSName(), 0, 18, 15);
            String price = StringHelper.convertToCurrency(item.getItemPrice());

            //Set Views
            this.position = position;
            IconLoader.setMenuIcon(itemImage, item.getItemIcon());
            itemName.setText(name);
            itemPrice.setText(price);

            //Check if Item is in Cart
            List<String> itemChecker = new ArrayList<>();
            List<Integer> itemAmount = new ArrayList<>();
            List<CartItem> itemList = new ArrayList<>(cart.keySet());
            for(CartItem itemObject : itemList){
                int itemQty = cart.get(itemObject);
                String itemString = itemObject.getItemPOSName();
                if(itemString.equals(item.getItemPOSName())){
                    itemChecker.add(itemString);
                    itemAmount.add(itemQty);
                }
            }
            if(!itemChecker.isEmpty()){
                //Set Item's Status to Occupied
                itemStatus.setVisibility(View.VISIBLE);
                //Disbale Add Btn and count it's frequency in the cart
                itemStatusText.setText("In Cart : " + itemAmount.get(0));
            } else {
                //Set Item's Status to Free
                itemStatus.setVisibility(View.GONE);
                //Enable Add Btn
                addBtn.setOnClickListener(add -> {
                    dialog.load_DGContents(new DialogBundle(1, item, new RVBundle(item.getItemCategory(), listOfItems)));
                });
            }
        }
    }
}
