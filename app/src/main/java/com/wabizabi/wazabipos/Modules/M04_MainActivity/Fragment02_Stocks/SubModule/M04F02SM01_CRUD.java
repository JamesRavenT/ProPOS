package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.SubModule;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.wabizabi.wazabipos.Modules.M04_MainActivity.Activity_Main;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.SubModule.Categories.Create.M04F02SM01CF01_CreateCategory;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.SubModule.Categories.Read.M04F02SM01CF02_ViewCategory;
import com.wabizabi.wazabipos.R;

public class M04F02SM01_CRUD extends AppCompatActivity {

    public static String setOperationForM04F02;
    Toolbar toolbar;

    M04F02SM01CF01_CreateCategory createCategoryFragment = new M04F02SM01CF01_CreateCategory();
    M04F02SM01CF02_ViewCategory viewCategoryFragment = new M04F02SM01CF02_ViewCategory();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act04_main_frag02_stocks_sm01_crud);
        setContentFunctionalities();
    }

    private void setContentFunctionalities(){
        setToolbar();
        setFragment();
    }

    private void setToolbar(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
    }

    private void setFragment(){
        switch(setOperationForM04F02){
            case "Create Category":
                getSupportFragmentManager().beginTransaction().replace(R.id.M04F02SM01_FragmentContainer, createCategoryFragment).commit();
                break;
            case "View Category":
                getSupportFragmentManager().beginTransaction().replace(R.id.M04F02SM01_FragmentContainer, viewCategoryFragment).commit();
                break;
            case "Update Category":
                getSupportFragmentManager().beginTransaction().replace(R.id.M04F02SM01_FragmentContainer, createCategoryFragment).commit();
                break;
            case "Create Item":
                getSupportFragmentManager().beginTransaction().replace(R.id.M04F02SM01_FragmentContainer, createCategoryFragment).commit();
                break;
            case "View Item":
                getSupportFragmentManager().beginTransaction().replace(R.id.M04F02SM01_FragmentContainer, createCategoryFragment).commit();
                break;
            case "Update Item":
                getSupportFragmentManager().beginTransaction().replace(R.id.M04F02SM01_FragmentContainer, createCategoryFragment).commit();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, Activity_Main.class));
    }
}
