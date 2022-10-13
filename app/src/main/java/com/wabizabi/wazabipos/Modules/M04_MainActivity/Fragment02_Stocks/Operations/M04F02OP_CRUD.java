package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.wabizabi.wazabipos.Modules.M04_MainActivity.Activity_Main;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.Categories.CategoryIconSelector.M04F02OPCIS_SelectCategoryImage;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.Categories.Create.M04F02OPCC_CreateCategory;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.Categories.Read.M04F02OPCR_ReadCategory;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.Categories.Update.M04F02OPCU_UpdateCategory;
import com.wabizabi.wazabipos.R;

public class M04F02OP_CRUD extends AppCompatActivity {
    public static M04F02OPCIS_SelectCategoryImage stockCategorySelectIconFragment = new M04F02OPCIS_SelectCategoryImage();
    public static M04F02OPCC_CreateCategory stockCreateCategoryFragment = new M04F02OPCC_CreateCategory();
    public static M04F02OPCR_ReadCategory stockReadCategoryFragment = new M04F02OPCR_ReadCategory();
    public static M04F02OPCU_UpdateCategory stockUpdateCategoryFragment = new M04F02OPCU_UpdateCategory();
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
                getSupportFragmentManager().beginTransaction().replace(R.id.M04F02SM01_FragmentContainer, stockCreateCategoryFragment).commit();
                break;
            case "Read Category":
                getSupportFragmentManager().beginTransaction().replace(R.id.M04F02SM01_FragmentContainer, stockReadCategoryFragment).commit();
                break;
            case "Update Category":
                getSupportFragmentManager().beginTransaction().replace(R.id.M04F02SM01_FragmentContainer, stockUpdateCategoryFragment).commit();
                break;
//            case "Create Item":
//                getSupportFragmentManager().beginTransaction().replace(R.id.M04F02SM01_FragmentContainer, stockCreateCategoryFragment).commit();
//                break;
//            case "View Item":
//                getSupportFragmentManager().beginTransaction().replace(R.id.M04F02SM01_FragmentContainer, stockCreateCategoryFragment).commit();
//                break;
//            case "Update Item":
//                getSupportFragmentManager().beginTransaction().replace(R.id.M04F02SM01_FragmentContainer, stockCreateCategoryFragment).commit();
//                break;
        }
    }

    @Override
    public void onBackPressed() {
        if(operationForM04F02OP.equals("SelectIcon_CategoryCreation")){
            getSupportFragmentManager().beginTransaction().replace(R.id.M04F02SM01_FragmentContainer, stockCreateCategoryFragment).commit();
            operationForM04F02OP = "Create Category";
        } else if(operationForM04F02OP.equals("SelectIcon_CategoryEdit")){
            getSupportFragmentManager().beginTransaction().replace(R.id.M04F02SM01_FragmentContainer, stockUpdateCategoryFragment).commit();
            operationForM04F02OP = "Update Category";
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
