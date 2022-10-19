package com.wabizabi.wazabipos.Modules.M04_MainActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.Fragment01_POS;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Stocks.M04F02_Stocks;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Products.M04F03_Products;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_User.Fragment04_User;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment05_Printer.Fragment05_Printer;
import com.wabizabi.wazabipos.R;

public class M04_Main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    DrawerLayout drawer;
    NavigationView navigation;
    public static String currentFragment;

    public static
    Fragment01_POS pos = new Fragment01_POS();
        public static int currentPOSCategoryIndex = -1;
        public static String currentPOSCategory;
    M04F02_Stocks stocks = new M04F02_Stocks();
    M04F03_Products products = new M04F03_Products();
    Fragment04_User user = new Fragment04_User();
    Fragment05_Printer printer = new Fragment05_Printer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act04_main);
        setActivityContents();
        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.MainActivityContainer, pos).commit();
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
            case R.id.nav_Home:
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


//    private void setScreenOrientation(){
//        int screenLayoutSize = getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
//        if (screenLayoutSize == Configuration.SCREENLAYOUT_SIZE_SMALL || screenLayoutSize == Configuration.SCREENLAYOUT_SIZE_NORMAL) {
//            setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//            setContentView(R.layout.act04_main);
//        } else {
//            setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//            setContentView(R.layout.act04_main);
//        }
//    }