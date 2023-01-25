package com.wabizabi.wazabipos.Modules.M04_MainActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmUser;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.M04F01_POS;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.M04F01SF03_Cart;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Menu.M04F02_Menu;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Tables.M04F03_Tables;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_Discount.M04F04_Discounts;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment05_PaymentMethods.M04F05_PaymentMethods;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment06_IngredientStock.M04F06_IngredientStock;
import com.wabizabi.wazabipos.R;

import io.realm.Realm;

public class M04_Main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //--DATABASE--//
    Realm realm = Realm.getDefaultInstance();
    //--DEVICE TYPE AND ORIENTATION--//
    int screenLayoutSize;
    int orientation;
    //--NAVIGATION DRAWER VARIABLES--//
    Toolbar toolbar;
    DrawerLayout drawer;
    NavigationView navigation;
    View navi;
    TextView username;
    //--FRAGMENTS--//
    //--SUBFRAGMENTS--//
    public static M04F01SF03_Cart pos_cart = new M04F01SF03_Cart();
    //--GLOBAL VARIABLES--//
    public static String currentFragment;
    public static int currentPOSCategoryIndex = -1;
    public static String currentPOSCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act04_main);
        screenLayoutSize = getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
        orientation = getResources().getConfiguration().orientation;
        init_Functionalities();
        if(savedInstanceState == null) {
            currentFragment = "POS";
            getSupportFragmentManager().beginTransaction().replace(R.id.MainActivityContainer, new M04F01_POS()).commit();
        }
    }

    private void init_Functionalities(){
        toolbar = findViewById(R.id.toolbar);
        drawer = findViewById(R.id.drawerLayout);
        navigation = findViewById(R.id.NavigationLayout);
        init_Toolbar();
        init_NavigationDrawer();
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

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.nav_POS:
                currentFragment = "POS";
                if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.MainActivityContainer, new M04F01_POS())
                        .commit();
                break;
            case R.id.nav_Menu:
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
                currentFragment = "Stock01";
                if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.MainActivityContainer, new M04F06_IngredientStock())
                        .commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        screenLayoutSize = getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
        orientation = getResources().getConfiguration().orientation;
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else if(currentFragment == "Cart") {
            currentFragment = "POS";
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




}

