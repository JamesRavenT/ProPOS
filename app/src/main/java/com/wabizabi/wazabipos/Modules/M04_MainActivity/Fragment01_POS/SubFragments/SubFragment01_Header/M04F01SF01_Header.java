package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment01_Header;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Adapter.M04F01SF03_CartRVA.cart;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.M04_Main.currentFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.M04F01SF03_Cart;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Libraries.Objects.CartItem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class M04F01SF01_Header extends Fragment {
    //--DATE AND TIME--//
    TextView dateText, timeText;
    ImageView posBtn;
    ConstraintLayout posLayout;
    TextView posText;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag01_pos_subfrag01_header, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        dateText = v.findViewById(R.id.M04F01SF01_DateText);
        timeText = v.findViewById(R.id.M04F01SF01_TimeText);
        posBtn = v.findViewById(R.id.M04F01SF01_POSButton);
        posText = v.findViewById(R.id.M04F01SF01_POSButtonNumberText);
        posLayout = v.findViewById(R.id.M04F01SF01_POSButtonNumberLayout);

        load_CurrentDate();
        load_CurrentTime();
        load_POSFunctionalities();
    }

    private void load_CurrentDate(){
        DateFormat currentYear = new SimpleDateFormat("yyyy");
        DateFormat currentMonth = new SimpleDateFormat("MMMM");
        DateFormat currentDay = new SimpleDateFormat("d");
        DateFormat currentDoW = new SimpleDateFormat("EEEE");
        String year = currentYear.format(new Date());
        String month = currentMonth.format(new Date());
        String day = currentDay.format(new Date());
        String dow = currentDoW.format(new Date());

        dateText.setText(dow + ", " + month + " " + day + ", " + year);
    }

    private void load_CurrentTime(){
        DateFormat currentTime = new SimpleDateFormat("h:mm a");
        String time = currentTime.format(new Date());

        timeText.setText("Greetings!");
    }

    private void load_POSFunctionalities(){
        posBtn.setOnClickListener(pos -> {
            currentFragment = "Cart";
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.MainActivityContainer, new M04F01SF03_Cart())
                    .commit();
        });

        if(cart.isEmpty()){
            posText.setText("0");
            posText.setTextColor(ContextCompat.getColor(getActivity(), R.color.wabizabi));
            posLayout.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.bg_shape_number_white));
        } else {
            int size = cart.values().stream().mapToInt(Integer::intValue).sum();
            posText.setText(String.valueOf(size));
            posText.setTextColor(ContextCompat.getColor(getActivity(), R.color.white));
            posLayout.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.bg_shape_number_red));
        }
    }
}
