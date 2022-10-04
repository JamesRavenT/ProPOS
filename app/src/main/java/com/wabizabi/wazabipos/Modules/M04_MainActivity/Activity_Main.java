package com.wabizabi.wazabipos.Modules.M04_MainActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Fragment01_POS;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.Fragment02_Stocks;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.Fragment03_Products;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_User.Fragment04_User;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment05_Records.Fragment05_Records;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment06_SalesReport.Fragment06_SalesReport;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment07_Printer.Fragment07_Printer;
import com.wabizabi.wazabipos.R;

public class Activity_Main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    DrawerLayout drawer;
    NavigationView navigation;
        public static String currentFragment;

    Fragment01_POS pos = new Fragment01_POS();
        public static int currentPOSCategoryIndex = -1;
        public static String currentPOSCategory;
    Fragment02_Stocks stocks = new Fragment02_Stocks();
        public static int currentStockCategoryIndex = -1;
        public static String currentStockCategory;
    Fragment03_Products products = new Fragment03_Products();
        public static int currentProductCategoryIndex = -1;
        public static String currentProductCategory;
    Fragment04_User user = new Fragment04_User();
    Fragment05_Records records = new Fragment05_Records();
    Fragment06_SalesReport salesReport = new Fragment06_SalesReport();
    Fragment07_Printer printer = new Fragment07_Printer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setScreenOrientation();
        setActivityContents();
        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.MainActivityContainer, pos).commit();
        }
    }

    private void setScreenOrientation(){
        int screenLayoutSize = getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
        if (screenLayoutSize == Configuration.SCREENLAYOUT_SIZE_SMALL || screenLayoutSize == Configuration.SCREENLAYOUT_SIZE_NORMAL) {
            setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            setContentView(R.layout.act04_main);
        } else {
            setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            setContentView(R.layout.act04_main);
        }
    }

    private void setActivityContents(){
        setToolbar();
        setNavigation();
        setDrawer();
    }

    private void setToolbar(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
    }
    private void setDrawer(){
        drawer = findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }
    private void setNavigation(){
        navigation = findViewById(R.id.NavigationLayout);
        navigation.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.nav_POS:
                currentFragment = "WaZabiPOS";
                getSupportFragmentManager().beginTransaction().replace(R.id.MainActivityContainer, pos).commit();
                break;
            case R.id.nav_Stocks:
                currentFragment = "Stocks";
                getSupportFragmentManager().beginTransaction().replace(R.id.MainActivityContainer, stocks).commit();
                break;
            case R.id.nav_Products:
                currentFragment = "Products";
                getSupportFragmentManager().beginTransaction().replace(R.id.MainActivityContainer, products).commit();
                break;
            case R.id.nav_User:
                currentFragment = "User";
                getSupportFragmentManager().beginTransaction().replace(R.id.MainActivityContainer, user).commit();
                break;
            case R.id.nav_Records:
                currentFragment = "Records";
                getSupportFragmentManager().beginTransaction().replace(R.id.MainActivityContainer, records).commit();
                break;
            case R.id.nav_SalesReport:
                currentFragment = "SalesReport";
                getSupportFragmentManager().beginTransaction().replace(R.id.MainActivityContainer, salesReport).commit();
                break;
            case R.id.nav_Printer:
                currentFragment = "Printer";
                getSupportFragmentManager().beginTransaction().replace(R.id.MainActivityContainer, printer).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else if(currentFragment == "Cart") {
            currentFragment = "POS";
            getSupportFragmentManager().beginTransaction().replace(R.id.MainActivityContainer, pos).commit();
        } else {
            return;
        }
    }

}