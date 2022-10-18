package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.Categories.CategoryIconSelector.M04F02OPCIS_SelectCategoryImage;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.Categories.Create.M04F02OPCC_CreateCategory;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.Categories.Read.M04F02OPCR_ReadCategory;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.Categories.Update.M04F02OPCU_UpdateCategory;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.Items.CategoryItemSelector.M04F02OPICS_SelectItemCategory;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.Items.Create.M04F02OPIC_CreateItem;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.Items.Read.M04F02OPIR_ReadItem;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.Items.Update.M04F02OPIT_UpdateItemTransaction;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.Items.Update.M04F02OPIU_UpdateItem;
import com.wabizabi.wazabipos.R;

public class M04F02OP_CRUD extends AppCompatActivity {
    public static M04F02OPCIS_SelectCategoryImage stockCategorySelectIconFragment = new M04F02OPCIS_SelectCategoryImage();
    public static M04F02OPCC_CreateCategory stockCreateCategoryFragment = new M04F02OPCC_CreateCategory();
    public static M04F02OPCR_ReadCategory stockReadCategoryFragment = new M04F02OPCR_ReadCategory();
    public static M04F02OPCU_UpdateCategory stockUpdateCategoryFragment = new M04F02OPCU_UpdateCategory();

    public static M04F02OPICS_SelectItemCategory stockItemCategorySelectFragment = new M04F02OPICS_SelectItemCategory();
    public static M04F02OPIC_CreateItem stockCreateItemFragment = new M04F02OPIC_CreateItem();
    public static M04F02OPIR_ReadItem stockReadItemFragment = new M04F02OPIR_ReadItem();
    public static M04F02OPIU_UpdateItem stockUpdateItemFragment = new M04F02OPIU_UpdateItem();
    public static M04F02OPIT_UpdateItemTransaction stockTransactionItemFragment = new M04F02OPIT_UpdateItemTransaction();


    public static String operationForM04F02OP;
    Toolbar toolbar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act04_main_frag02_stocks_operation_crud);
        init_ContentFunctionalities();
    }

    private void init_ContentFunctionalities(){
        init_Toolbar();
        init_Fragment();
    }

    private void init_Toolbar(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void init_Fragment(){
        switch(operationForM04F02OP){
            case "Create Category":
                getSupportFragmentManager().beginTransaction().replace(R.id.M04F02OP_FragmentContainer, stockCreateCategoryFragment).commit();
                break;
            case "Read Category":
                getSupportFragmentManager().beginTransaction().replace(R.id.M04F02OP_FragmentContainer, stockReadCategoryFragment).commit();
                break;
            case "Edit Category":
                getSupportFragmentManager().beginTransaction().replace(R.id.M04F02OP_FragmentContainer, stockUpdateCategoryFragment).commit();
                break;
            case "Create Item":
                getSupportFragmentManager().beginTransaction().replace(R.id.M04F02OP_FragmentContainer, stockCreateItemFragment).commit();
                break;
            case "Read Item":
                getSupportFragmentManager().beginTransaction().replace(R.id.M04F02OP_FragmentContainer, stockReadItemFragment).commit();
                break;
            case "Edit Item":
                getSupportFragmentManager().beginTransaction().replace(R.id.M04F02OP_FragmentContainer, stockUpdateItemFragment).commit();
                break;
            case "Update Item":
                getSupportFragmentManager().beginTransaction().replace(R.id.M04F02OP_FragmentContainer, stockTransactionItemFragment).commit();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if(operationForM04F02OP.equals("Select Icon For Category Creation")){
            getSupportFragmentManager().beginTransaction().replace(R.id.M04F02OP_FragmentContainer, stockCreateCategoryFragment).commit();
            operationForM04F02OP = "Create Category";
        }
        else if(operationForM04F02OP.equals("Select Icon For Category Revision")){
            getSupportFragmentManager().beginTransaction().replace(R.id.M04F02OP_FragmentContainer, stockUpdateCategoryFragment).commit();
            operationForM04F02OP = "Update Category";
        }
        else if(operationForM04F02OP.equals("Select Category for Item Creation")){
            getSupportFragmentManager().beginTransaction().replace(R.id.M04F02OP_FragmentContainer, stockCreateItemFragment).commit();
            operationForM04F02OP = "Create Item";
        }
        else {
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
