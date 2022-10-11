package com.wabizabi.wazabipos.Modules.M05_CRUD;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.wabizabi.wazabipos.Modules.M05_CRUD.Fragment03.M05F03_ReadProducts;
import com.wabizabi.wazabipos.R;

public class Activity_CRUD extends AppCompatActivity {

    M05F03_ReadProducts readproducts = new M05F03_ReadProducts();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act05_crud);
        getSupportFragmentManager().beginTransaction().replace(R.id.CRUDContainer, readproducts).commit();
    }
}
