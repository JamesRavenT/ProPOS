package com.wabizabi.wazabipos.Modules.M04_MainActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import com.wabizabi.wazabipos.Database.DB;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmUser;
import com.wabizabi.wazabipos.Modules.M02_UserVerification.M02_UserVerification;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.M04F01_POS;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Menu.M04F02_Menu;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Tables.M04F03_Tables;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_Discount.M04F04_Discounts;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment05_PaymentMethods.M04F05_PaymentMethods;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment06_IngredientStock.M04F06_IngredientStock;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment07_Admin.M04F07_Admin;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment08_Printer.M04F08_Printer;
import com.wabizabi.wazabipos.R;

import io.realm.Realm;

public class M04_Main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //--DATABASE--//
    Realm realm = Realm.getDefaultInstance();
    //--DEVICE TYPE AND ORIENTATION--//
    InputMethodManager keyBoard;
    int screenLayoutSize;
    int orientation;
    //--NAVIGATION DRAWER VARIABLES--//
    Toolbar toolbar;
    DrawerLayout drawer;
    NavigationView navigation;
    View navi;
    TextView username;
    //--GLOBAL VARIABLES--//
    public static String currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_WaZabiPOS);
        setContentView(R.layout.act04_main);
        screenLayoutSize = getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
        orientation = getResources().getConfiguration().orientation;
        init_Functionalities();
        if(savedInstanceState == null) {
            currentFragment = "POS01";
            setTheme(R.style.Theme_WaZabiPOS);
            getSupportFragmentManager().beginTransaction().replace(R.id.MainActivityContainer, new M04F01_POS()).commit();
        }
    }

    private void init_Functionalities(){
        toolbar = findViewById(R.id.toolbar);
        drawer = findViewById(R.id.drawerLayout);
        navigation = findViewById(R.id.NavigationLayout);
        init_Toolbar();
        init_NavigationDrawer();
        init_Printer();
    }

    private void init_Toolbar(){
            toolbar.setVisibility(View.VISIBLE);
            drawer.setVisibility(View.VISIBLE);
            navigation.setVisibility(View.VISIBLE);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("");
//        if(orientation == Configuration.ORIENTATION_LANDSCAPE && currentFragment.equals("Cart")) {
//            getSupportActionBar().setBackgroundDrawable();
//        }
    }

    private void init_NavigationDrawer(){
        navigation.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //--USERNAME IN DRAWER--//
        navi = navigation.getHeaderView(0);
        username = navi.findViewById(R.id.nav_username);
        RealmUser user = realm.where(RealmUser.class).findFirst();
        username.setText(user.getUserName());
    }

    private void init_Printer(){
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.nav_POS:
                hideKeyBoard();
                currentFragment = "POS01";
                if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.MainActivityContainer, new M04F01_POS())
                        .commit();
                break;
            case R.id.nav_Menu:
                hideKeyBoard();
                currentFragment = "Menu01";
                if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.MainActivityContainer, new M04F02_Menu())
                        .commit();
                break;
            case R.id.nav_Tables:
                hideKeyBoard();
                currentFragment = "Table";
                if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.MainActivityContainer, new M04F03_Tables())
                        .commit();
                break;
            case R.id.nav_Discounts:
                hideKeyBoard();
                currentFragment = "Discount";
                if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.MainActivityContainer, new M04F04_Discounts())
                        .commit();
                break;
            case R.id.nav_PaymentMethods:
                hideKeyBoard();
                currentFragment = "PaymentMethod";
                if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.MainActivityContainer, new M04F05_PaymentMethods())
                        .commit();
                break;
            case R.id.nav_Inventory:
                hideKeyBoard();
                currentFragment = "Stock01";
                if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.MainActivityContainer, new M04F06_IngredientStock())
                        .commit();
                break;
            case R.id.nav_Admin:
                hideKeyBoard();
                if(currentFragment != "Admin") {
                    if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
                        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                    }
                    startActivity(new Intent(this, M02_UserVerification.class));
                } else {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.MainActivityContainer, new M04F07_Admin())
                            .commit();
                }
            case R.id.nav_Printer:
                hideKeyBoard();
                currentFragment = "Printer";
                if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.MainActivityContainer, new M04F08_Printer())
                        .commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void hideKeyBoard(){
        keyBoard = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        keyBoard.hideSoftInputFromWindow(getWindow().getDecorView().getRootView().getWindowToken() , 0);
    }

    @Override
    public void onBackPressed() {
        screenLayoutSize = getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
        orientation = getResources().getConfiguration().orientation;
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else if(currentFragment == "POS02") {
            currentFragment = "POS01";
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.MainActivityContainer, new M04F01_POS())
                    .commit();
        } else if(currentFragment == "Cart") {
            currentFragment = "POS01";
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.MainActivityContainer, new M04F01_POS())
                    .commit();
        } else if(currentFragment == "Menu02") {
            currentFragment = "Menu01";
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.MainActivityContainer, new M04F02_Menu())
                    .commit();

        } else if(currentFragment == "Stock02") {
            currentFragment = "Stock02";
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.MainActivityContainer, new M04F06_IngredientStock())
                    .commit();

        } else if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        } else {
            return;
        }
    }

    @Override
    protected void onStart(){
        super.onStart();
        DB.syncRealmAndFirestore(this);
    }

    @Override
    protected void onResume(){
        super.onResume();
        switch (currentFragment){
            case "POS01":
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.MainActivityContainer, new M04F01_POS())
                        .commit();
                break;
            case "Menu01":
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.MainActivityContainer, new M04F02_Menu())
                        .commit();
                break;
            case "Table":
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.MainActivityContainer, new M04F03_Tables())
                        .commit();
                break;
            case "Discount":
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.MainActivityContainer, new M04F04_Discounts())
                        .commit();
                break;
            case "Method":
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.MainActivityContainer, new M04F05_PaymentMethods())
                        .commit();
                break;
            case "Stock01":
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.MainActivityContainer, new M04F06_IngredientStock())
                        .commit();
                break;
            case "Admin":
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.MainActivityContainer, new M04F07_Admin())
                        .commit();
                break;
        }
    }
}

