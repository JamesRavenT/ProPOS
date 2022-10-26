package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_User.Operations;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_User.Operations.Profile.M04F04OPUP_ChangePassword;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_User.Operations.Profile.M04F04OPUU_ChangeUsername;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_User.Operations.SalesReport.M04F04OPSR_SalesReport;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_User.Operations.Transactions.Inventory.M04F04OPTI_Inventory;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_User.Operations.Transactions.Sales.M04F04OPTS_Sales;
import com.wabizabi.wazabipos.R;

public class M04F04OP_Management extends AppCompatActivity {
    public static M04F04OPUU_ChangeUsername changeUsernameFragment = new M04F04OPUU_ChangeUsername();
    public static M04F04OPUP_ChangePassword changePasswordFragment = new M04F04OPUP_ChangePassword();
    public static M04F04OPSR_SalesReport salesReportFragment = new M04F04OPSR_SalesReport();
    public static M04F04OPTS_Sales transactionSalesFragment = new M04F04OPTS_Sales();
    public static M04F04OPTI_Inventory transactionInventoryFragment = new M04F04OPTI_Inventory();
    public static String operationForM04F04;
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act04_main_frag04_admin_operation_management);
        init_Functionalities();
    }

    private void init_Functionalities(){
        init_Toolbar();
        init_Fragments();
    }

    private void init_Toolbar(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void init_Fragments(){
        switch (operationForM04F04){
            case "Change Username":
                getSupportFragmentManager().beginTransaction().replace(R.id.M04F04OP_FragmentContainer, changeUsernameFragment).commit();
                break;
            case "Change Password":
                getSupportFragmentManager().beginTransaction().replace(R.id.M04F04OP_FragmentContainer, changePasswordFragment).commit();
                break;
            case "View Sales Report":
                getSupportFragmentManager().beginTransaction().replace(R.id.M04F04OP_FragmentContainer, salesReportFragment).commit();
                break;
            case "View Sale Transactions List":
                getSupportFragmentManager().beginTransaction().replace(R.id.M04F04OP_FragmentContainer, transactionSalesFragment).commit();
                break;
            case "View Inventory Transactions List":
                getSupportFragmentManager().beginTransaction().replace(R.id.M04F04OP_FragmentContainer, transactionInventoryFragment).commit();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if(operationForM04F04.equals("View Sale Transaction")){
            operationForM04F04 = "View Sale Transactions List";
            getSupportFragmentManager().beginTransaction().replace(R.id.M04F04OP_FragmentContainer, transactionSalesFragment).commit();
        }
        else if(operationForM04F04.equals("View Inventory Transaction")){
            operationForM04F04 = "View Inventory Transactions List";
            getSupportFragmentManager().beginTransaction().replace(R.id.M04F04OP_FragmentContainer, transactionInventoryFragment).commit();
        } else {
            finish();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
