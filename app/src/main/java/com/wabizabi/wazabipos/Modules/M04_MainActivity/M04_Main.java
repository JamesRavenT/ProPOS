package com.wabizabi.wazabipos.Modules.M04_MainActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.wabizabi.wazabipos.Database.Schemas.UserProfile;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.M04F01_POS;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment01_Header.M04F01SF01_Header;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment02_Recommendation.M04F01SF02_Recommendation;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.M04F01SF03_Cart;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.M04F02_Stocks;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.M04F03_Products;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_User.M04F04_Admin;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment05_Printer.M04F05_Printer;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Interfaces.ContentUpdater;

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
    M04F01_POS pos = new M04F01_POS();
    M04F02_Stocks stocks = new M04F02_Stocks();
    M04F03_Products products = new M04F03_Products();
    M04F04_Admin user = new M04F04_Admin();
    M04F05_Printer printer = new M04F05_Printer();

    //--SUBFRAGMENTS--//
    public static M04F01SF01_Header pos_header = new M04F01SF01_Header();
    public static M04F01SF02_Recommendation pos_recommendation = new M04F01SF02_Recommendation();
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
            getSupportFragmentManager().beginTransaction().replace(R.id.MainActivityContainer, pos).commit();
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
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
    }
    private void init_NavigationDrawer(){
        navigation.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //--USERNAME IN DRAWER--//
        navi = navigation.getHeaderView(0);
        username = navi.findViewById(R.id.nav_username);
        UserProfile user = realm.where(UserProfile.class).findFirst();
        username.setText(user.getUserName());
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.nav_POS:
                currentFragment = "WaZabiPOS";
                if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.MainActivityContainer, pos)
                        .commit();
                break;
            case R.id.nav_Stocks:
                currentFragment = "Stocks";
                if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.MainActivityContainer, stocks)
                        .commit();
                break;
            case R.id.nav_Products:
                currentFragment = "Products";
                if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.MainActivityContainer, products)
                        .commit();
                break;
            case R.id.nav_User:
                currentFragment = "User";
                if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.MainActivityContainer, user)
                        .commit();
                break;
            case R.id.nav_Printer:
                currentFragment = "Printer";
                if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.MainActivityContainer, printer)
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
                    .replace(R.id.MainActivityContainer, pos)
                    .commit();
        } else if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        } else {
            return;
        }
    }




}

