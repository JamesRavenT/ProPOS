package com.wabizabi.wazabipos.Modules.M04_MainActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmUser;
import com.wabizabi.wazabipos.Modules.M02_UserVerification.M02_UserVerification;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.M04F01_POS;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment02_Recommendation.M04F01SF02_Recommendation;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.M04F01SF03_Cart;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment02_Menu.M04F02_Menu;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment03_Tables.M04F03_Tables;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment04_Discount.M04F04_Discounts;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment05_PaymentMethods.M04F05_PaymentMethods;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment06_IngredientStock.M04F06_IngredientStock;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment07_Admin.M04F07_Admin;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment08_Printer.M04F08_Printer;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.StringHelper;

import io.realm.Realm;

public class M04_Main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, M04F01SF02_Recommendation.RefreshHeader, M04F01SF03_Cart.RefreshPOS, M04F01_POS.RefreshCart, M04F01SF02_Recommendation.AddRecommendations {
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
    TextView email;
    //--GLOBAL VARIABLES--//
    public static String currentFragment;
    public static M04F01_POS landscapePOS = new M04F01_POS();
    public static M04F01SF03_Cart landscapeCART = new M04F01SF03_Cart();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_WaZabiPOS);
        setContentView(R.layout.act04_main);
        orientation = getResources().getConfiguration().orientation;
        screenLayoutSize = getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
//        landscapePOS = new M04F01_POS();
//        landscapeCART = new M04F01SF03_Cart();
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.wabizabi));
            window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        } else {
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.dirtywhite));
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        init_Functionalities();
        if(savedInstanceState == null) {
            if(currentFragment != null) {
                load_CurrentFragment();
            } else {
                currentFragment = "POS01";
                setTheme(R.style.Theme_WaZabiPOS);
                getSupportFragmentManager().beginTransaction().replace(R.id.MainActivityContainer, landscapePOS).commit();
            }
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
        if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            toggle.getDrawerArrowDrawable().setColor(ContextCompat.getColor(this, R.color.white));
        } else {
            toggle.getDrawerArrowDrawable().setColor(ContextCompat.getColor(this, R.color.wabizabi));
        }
        //--USERNAME IN DRAWER--//
        navi = navigation.getHeaderView(0);
        username = navi.findViewById(R.id.nav_username);
        email = navi.findViewById(R.id.nav_email);
        RealmUser user = realm.where(RealmUser.class).findFirst();
        username.setText(user.getUserName());
        if(user.getEmail().length() > 18){
            email.setText(StringHelper.limitDisplay(user.getEmail(), 0, 28, 25));
        } else {
            email.setText(user.getEmail());
        }
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
                break;
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

    private void load_CurrentFragment(){
        if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.MainActivityContainer, landscapePOS)
                    .replace(R.id.MainActivityContainer2, landscapeCART)
                    .commit();
        } else if(currentFragment != null) {
             if(orientation == Configuration.ORIENTATION_LANDSCAPE){
                 getSupportFragmentManager()
                         .beginTransaction()
                         .replace(R.id.MainActivityContainer, landscapePOS)
                         .replace(R.id.MainActivityContainer2, landscapeCART)
                         .commit();
             } else {
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
        } else if (currentFragment == "POS04"){
            currentFragment = "POS03";
            landscapePOS.backToCategory();
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
            currentFragment = "Stock01";
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.MainActivityContainer, new M04F06_IngredientStock())
                    .commit();
        } else if(currentFragment == "Sales Report" || currentFragment == "Inventory Transaction" || currentFragment == "Sales Transaction") {
            currentFragment = "Admin";
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.MainActivityContainer, new M04F07_Admin())
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
//        DB.syncRealmAndFirestore(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        load_CurrentFragment();
    }

    @Override
    public void updateCart() {
        landscapeCART.refreshCartAdapter();
    }


    @Override
    public void updatePOS() {
        landscapePOS.refreshPOSAdapter();
    }

    @Override
    public void updateCartAfter() {
        landscapeCART.refreshCartAdapter();
    }

    @Override
    public void updateHeaderContent() {
        landscapePOS.refreshPOSAdapter();
    }
}

