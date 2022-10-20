package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.M04F02OP_CRUD.operationForM04F02;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.M04F03OP_CRUD.operationForM04F03;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Adapters.M04F03_CategoryRVA.listOfProductCategories;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Adapters.M04F03_ItemRVA.listOfProductItems;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Database.Instances.OpenProductsInstance;
import com.wabizabi.wazabipos.Database.Schemas.ProductsItem;
import com.wabizabi.wazabipos.Database.Schemas.ProductsList;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Operations.M04F02OP_CRUD;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Adapters.M04F03_CategoryRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Adapters.M04F03_ItemRVA;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Interfaces.Update_ProductsCurrentCategory;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Interfaces.Update_ProductsItemList;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Operations.M04F03OP_CRUD;
import com.wabizabi.wazabipos.R;

import io.realm.Realm;
import io.realm.RealmResults;

public class M04F03_Products extends Fragment implements Update_ProductsItemList, Update_ProductsCurrentCategory {
    public static int M04F03_CurrentCategoryIndex = -1;
    public static int M04F03_CurrentItemIndex = -1;
    public static String M04F03_CurrentCategory;
    public static String M04F03_CurrentItem;

    Realm realm;
    Dialog dialogCreateCRUD, dialogCategoryCRUD, dialogItemCRUD;
    ImageButton createButton;
    RecyclerView productCategoryRV, productItemRV;
    RecyclerView.Adapter productCategoryRVA, productItemRVA;
    //--DIALOG--//
    TextView createCategoryText, createItemText;
    TextView categoryNameText, categoryViewText, categoryEditText, categoryDeleteText;
    TextView itemNameText, itemViewText, itemEditText, itemDeleteText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag03_products, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        init_Views(v);
        init_DBInstance();
        init_Buttons();
        init_Dialogs();
        init_RecyclerView();
    }

    private void init_Views(View v){
        createButton = v.findViewById(R.id.M04F03_CreateButton);
        productCategoryRV = v.findViewById(R.id.M04F03_CategoryRV);
        productItemRV = v.findViewById(R.id.M04F03_ItemRV);

    }

    private void init_DBInstance(){
        realm = Realm.getDefaultInstance();
    }

    private void init_Dialogs(){
        //--ADD--//
        dialogCreateCRUD = new Dialog(getActivity());
        dialogCreateCRUD.setContentView(R.layout.act04_main_frag03_products_operation_crud_popupadd);
        dialogCreateCRUD.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        createCategoryText = dialogCreateCRUD.findViewById(R.id.M04F03OPDA_CategoryText);
        createItemText = dialogCreateCRUD.findViewById(R.id.M04F03OPDA_ItemText);
        createCategoryText.setOnClickListener(v -> {
            operationForM04F03 = "Create Category";
            dialogCreateCRUD.dismiss();
            startActivity(new Intent(getActivity(), M04F03OP_CRUD.class));
        });
        createItemText.setOnClickListener(v -> {
            operationForM04F03 = "Create Item";
            dialogCreateCRUD.dismiss();
            startActivity(new Intent(getActivity(), M04F03OP_CRUD.class));
        });

        //--CATEGORY--//
        dialogCategoryCRUD = new Dialog(getActivity());
        dialogCategoryCRUD.setContentView(R.layout.act04_main_frag03_products_operation_crud_popupcategory);
        dialogCategoryCRUD.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        categoryNameText = dialogCategoryCRUD.findViewById(R.id.M04F03OPCD_CategoryName);
        categoryViewText = dialogCategoryCRUD.findViewById(R.id.M04F03OPCD_ViewText);
        categoryEditText = dialogCategoryCRUD.findViewById(R.id.M04F03OPCD_EditText);
        categoryDeleteText = dialogCategoryCRUD.findViewById(R.id.M04F03OPCD_DeleteText);
        categoryViewText.setOnClickListener(v -> {
            operationForM04F03 = "Read Category";
            dialogCategoryCRUD.dismiss();
            startActivity(new Intent(getActivity(), M04F03OP_CRUD.class));
        });
        categoryEditText.setOnClickListener(v -> {
            operationForM04F03 = "Edit Category";
            dialogCategoryCRUD.dismiss();
            startActivity(new Intent(getActivity(), M04F03OP_CRUD.class));
        });
        categoryDeleteText.setOnClickListener(v -> {
            OpenProductsInstance.toDeleteCategory();
            M04F03_CurrentCategoryIndex = -1;
            productCategoryRVA.notifyDataSetChanged();
            productItemRVA.notifyDataSetChanged();
            dialogCategoryCRUD.dismiss();
        });
        //--ITEM--//
        dialogItemCRUD = new Dialog(getActivity());
        dialogItemCRUD.setContentView(R.layout.act04_main_frag03_products_operation_crud_popupitem);
        dialogItemCRUD.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        itemNameText = dialogItemCRUD.findViewById(R.id.M04F03OPDI_ItemName);
        itemViewText = dialogItemCRUD.findViewById(R.id.M04F03OPDI_ViewText);
        itemEditText = dialogItemCRUD.findViewById(R.id.M04F03OPDI_EditText);
        itemDeleteText = dialogItemCRUD.findViewById(R.id.M04F03OPDI_DeleteText);
        itemViewText.setOnClickListener(v -> {
            operationForM04F03 = "Read Item";
            dialogItemCRUD.dismiss();
            startActivity(new Intent(getActivity(), M04F03OP_CRUD.class));
        });
        itemEditText.setOnClickListener(v -> {
            operationForM04F03 = "Edit Item";
            dialogItemCRUD.dismiss();
            startActivity(new Intent(getActivity(), M04F03OP_CRUD.class));
        });
        itemDeleteText.setOnClickListener(v -> {
            OpenProductsInstance.toDeleteItem();
            productItemRVA.notifyDataSetChanged();
            dialogItemCRUD.dismiss();
        });
    }

    private void init_Buttons(){
        createButton.setOnClickListener(v -> {
            dialogCreateCRUD.show();
        });
    }

    private void init_RecyclerView(){
        //--CATEGORY--//
        LinearLayoutManager categoryLayout = new LinearLayoutManager(getActivity());
        categoryLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        listOfProductCategories = realm.where(ProductsList.class).sort("categoryName").findAll();
        productCategoryRVA = new M04F03_CategoryRVA(this, this, dialogCategoryCRUD, getActivity(), realm);
        productCategoryRV.setLayoutManager(categoryLayout);
        productCategoryRV.setAdapter(productCategoryRVA);
        //--ITEM--//
        LinearLayoutManager itemLayout = new LinearLayoutManager(getActivity());
        itemLayout.setOrientation(LinearLayoutManager.VERTICAL);
        listOfProductItems = realm.where(ProductsItem.class).equalTo("itemCategory", M04F03_CurrentCategory).sort("itemName").findAll();
        productItemRVA = new M04F03_ItemRVA(dialogItemCRUD, getActivity(), realm);
        productItemRV.setLayoutManager(itemLayout);
        productItemRV.setAdapter(productItemRVA);
    }

    @Override
    public void refreshItemList(int position, RealmResults<ProductsItem> products) {
        productItemRVA = new M04F03_ItemRVA(dialogItemCRUD, getActivity(), realm);
        productItemRVA.notifyDataSetChanged();
        productItemRV.setAdapter(productItemRVA);
    }

    @Override
    public void updateCurrentProduct() {
        categoryNameText.setText(M04F03_CurrentCategory);
    }

    @Override
    public void onResume() {
        productCategoryRVA.notifyDataSetChanged();
        productItemRVA.notifyDataSetChanged();
        super.onResume();
    }
}
