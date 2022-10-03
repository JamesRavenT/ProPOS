package com.wabizabi.wazabipos.Modules.M03_LoadResources;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.wabizabi.wazabipos.Modules.M04_MainActivity.Activity_Main;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.BackgroundThreads.WorkOrders;

public class Activity_LoadResources extends AppCompatActivity {

    TextView loading;
    Handler zero, one, two, three;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setScreenOrientation();
        setActivityContents();

    }

    private void setScreenOrientation(){
        int screenLayoutSize = getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
        if (screenLayoutSize == Configuration.SCREENLAYOUT_SIZE_SMALL || screenLayoutSize == Configuration.SCREENLAYOUT_SIZE_NORMAL) {
            setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            setContentView(R.layout.act03_loadresources);
        } else {
            setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            setContentView(R.layout.act03_loadresources);
        }
    }
    private void setActivityContents(){
        initBackgroundResources();
    }
    private void initBackgroundResources(){
        //GET TRANSACTIONS ON ZERO WHILE START THE ALGORITHM ON TWO
        zero = new Handler();
        one = new Handler();
        two = new Handler();
        three = new Handler();
        loading = findViewById(R.id.LoadResoures_LoadingText);
        zero.postDelayed(()->{ loading.setText("L O A D I N G ."); WorkOrders.getTransactions(this);
            one.postDelayed(()->{ loading.setText("L O A D I N G . .");
                two.postDelayed(()->{ loading.setText("L O A D I N G . . .");
                    three.postDelayed(()->{ WorkOrders.startAlgorithm(this); startActivity(new Intent(this, Activity_Main.class));
                    },1000);
                },1000);
            },1000);
        }, 500);
    }

}