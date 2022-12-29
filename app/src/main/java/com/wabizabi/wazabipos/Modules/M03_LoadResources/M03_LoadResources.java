package com.wabizabi.wazabipos.Modules.M03_LoadResources;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.wabizabi.wazabipos.Modules.M04_MainActivity.M04_Main;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.BackgroundThreads.WorkOrders;

public class M03_LoadResources extends AppCompatActivity {

    TextView loading;
    Handler zero, one, two, three;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act03_loadresources);
        init_Functionalities();
    }
    private void init_Functionalities() {
        loading = findViewById(R.id.M03A01_LoadingText);
        initBackgroundResources();
    }
    private void initBackgroundResources(){
        zero = new Handler();
        one = new Handler();
        two = new Handler();
        three = new Handler();
        zero.postDelayed(()->{ loading.setText("L O A D I N G ."); WorkOrders.startAlgorithm(this);
            one.postDelayed(()->{ loading.setText("L O A D I N G . .");
                two.postDelayed(()->{ loading.setText("L O A D I N G . . .");
                    three.postDelayed(()->{ WorkOrders.storeFPData(this); startActivity(new Intent(this, M04_Main.class));
                    },1000);
                },1000);
            },1000);
        }, 1000);
    }

}