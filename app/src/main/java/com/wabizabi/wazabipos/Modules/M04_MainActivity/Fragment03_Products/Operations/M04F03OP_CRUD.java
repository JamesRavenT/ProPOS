package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.Categories.CategoryIconSelector.M04F03OPCIS_SelectCategoryImage;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.Categories.Create.M04F03OPCC_CreateCategory;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.Categories.Read.M04F03OPCR_ReadCategory;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.Categories.Update.M04F03OPCU_UpdateCategory;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.Items.CategoryItemSelector.M04F03OPICS_SelectItemCategory;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.Items.Create.M04F03OPIC_CreateItem;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.Items.Read.M04F03OPIR_ReadItem;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.Items.Update.M04F03OPIU_UpdateItem;
import com.wabizabi.wazabipos.R;

public class M04F03OP_CRUD extends AppCompatActivity {
    public static M04F03OPCIS_SelectCategoryImage productCategorySelectIconFragment = new M04F03OPCIS_SelectCategoryImage();
    public static M04F03OPCC_CreateCategory productCreateCategoryFragment = new M04F03OPCC_CreateCategory();
    public static M04F03OPCR_ReadCategory productReadCategoryFragment = new M04F03OPCR_ReadCategory();
    public static M04F03OPCU_UpdateCategory productUpdateCategoryFragment = new M04F03OPCU_UpdateCategory();

    public static M04F03OPICS_SelectItemCategory productItemCategorySelectFragment = new M04F03OPICS_SelectItemCategory();
    public static M04F03OPIC_CreateItem productCreateItemFragment = new M04F03OPIC_CreateItem();
    public static M04F03OPIR_ReadItem productReadItemFragment = new M04F03OPIR_ReadItem();
    public static M04F03OPIU_UpdateItem productUpdateItemFragment = new M04F03OPIU_UpdateItem();

    public static String operationForM04F03;
    Toolbar toolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act04_main_frag03_products_operation_crud);
        init_Functionalities();
    }

    private void init_Functionalities(){
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
        switch(operationForM04F03){
            case "Create Category":
                getSupportFragmentManager().beginTransaction().replace(R.id.M04F03OP_FragmentContainer, productCreateCategoryFragment).commit();
                break;
            case "Read Category":
                getSupportFragmentManager().beginTransaction().replace(R.id.M04F03OP_FragmentContainer, productReadCategoryFragment).commit();
                break;
            case "Edit Category":
                getSupportFragmentManager().beginTransaction().replace(R.id.M04F03OP_FragmentContainer, productUpdateCategoryFragment).commit();
                break;
            case "Create Item":
                getSupportFragmentManager().beginTransaction().replace(R.id.M04F03OP_FragmentContainer, productCreateItemFragment).commit();
                break;
            case "Read Item":
                getSupportFragmentManager().beginTransaction().replace(R.id.M04F03OP_FragmentContainer, productReadItemFragment).commit();
                break;
            case "Edit Item":
                getSupportFragmentManager().beginTransaction().replace(R.id.M04F03OP_FragmentContainer, productUpdateItemFragment).commit();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if(operationForM04F03.equals("Select Icon For Category Creation")){
            getSupportFragmentManager().beginTransaction().replace(R.id.M04F03OP_FragmentContainer, productCreateCategoryFragment).commit();
            operationForM04F03 = "Create Category";
        }
        else if(operationForM04F03.equals("Select Icon For Category Revision")){
            getSupportFragmentManager().beginTransaction().replace(R.id.M04F03OP_FragmentContainer, productUpdateCategoryFragment).commit();
            operationForM04F03 = "Update Category";
        }
        else if(operationForM04F03.equals("Select Category for Item Creation")){
            getSupportFragmentManager().beginTransaction().replace(R.id.M04F03OP_FragmentContainer, productCreateItemFragment).commit();
            operationForM04F03 = "Create Item";
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
