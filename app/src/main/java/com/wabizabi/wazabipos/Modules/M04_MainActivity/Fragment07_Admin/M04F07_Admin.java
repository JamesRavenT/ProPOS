package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment07_Admin;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment07_Admin.SubFragments.SubFragment02_InventoryTransaction.M04F07SF02_InventoryTransaction;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment07_Admin.SubFragments.SubFragment03_SalesTransaction.M04F07SF03_SalesTransaction;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.DialogBuilder;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.LayoutHelper;

public class M04F07_Admin extends Fragment {

    //--User Details--//

    //--View Buttons--//
    CardView viewProfileManagerBtn,
             viewSalesReportBtn,
             viewTransactionsBtn;

    //--DG04 TRANSACTION--//
    Dialog adminDG04;
    CardView adminDG04_InventoryBtn,
             adminDG04_SalesBtn;
    ImageView closeDG04Btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutHelper.inflateFragment(inflater, container, R.layout.act04_main_frag07_admin);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        viewTransactionsBtn = v.findViewById(R.id.M04F07_TransactionsViewBtn);
    }

    private void load_ProfileManager(){

    }

    private void load_ViewSalesReport(){

    }
    private void load_ViewTransaction(){
        viewTransactionsBtn.setOnClickListener(transcation -> {
            load_DG04Functionalities();
            adminDG04.show();
        });
    }

    private void init_Dialogs(){
        //--DG04--//
        adminDG04 = DialogBuilder.create(getActivity(), R.layout.act04_main_frag07_admin_dg04_selecttransaction);
        adminDG04_InventoryBtn = adminDG04.findViewById(R.id.M04F07D04_InventoryBtn);
        adminDG04_SalesBtn = adminDG04.findViewById(R.id.M04F07D04_SalesBtn);
        closeDG04Btn = adminDG04.findViewById(R.id.M04F07D04_CloseDGBtn);
    }

    private void load_DG04Functionalities(){
        //On Inventory Btn
        adminDG04_InventoryBtn.setOnClickListener(inventory -> {
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.MainActivityContainer, new M04F07SF02_InventoryTransaction())
                    .commit();
        });

        //On Sales Btn
        adminDG04_SalesBtn.setOnClickListener(sales -> {
            getActivity().getSupportFragmentManager()
                         .beginTransaction()
                         .replace(R.id.MainActivityContainer, new M04F07SF03_SalesTransaction())
                         .commit();
        });

        //On Close Btn
        closeDG04Btn.setOnClickListener(close -> {
            adminDG04.dismiss();
        });
    }

}
