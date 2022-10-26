package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_User.Operations.Transactions.Inventory;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.work.impl.background.systemalarm.SystemAlarmScheduler;

import com.wabizabi.wazabipos.Database.Schemas.SalesTransaction;
import com.wabizabi.wazabipos.R;

import io.realm.Realm;
import io.realm.RealmResults;

public class M04F04OPTI_Inventory extends Fragment {
    RealmResults<SalesTransaction> listOfInventoryTransaction;
    Realm realm = Realm.getDefaultInstance();
    ImageView changeDateButton;
    TextView showingText;
    RecyclerView inventoryRV;
    RecyclerView.Adapter inventoryRVA;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag04_admin_operation_management_transactions_inventory, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        init_Views(v);
    }

    private void init_Views(View v){
        changeDateButton = v.findViewById(R.id.M04F04OPTI_CalendarButton);
        showingText = v.findViewById(R.id.M04F04OPTI_ShowingText);
        inventoryRV = v.findViewById(R.id.M04F04OPTI_RecyclerView);
    }

    private void init_Dialog(){

    }

    private void init_RecyclerView(){

    }
}
