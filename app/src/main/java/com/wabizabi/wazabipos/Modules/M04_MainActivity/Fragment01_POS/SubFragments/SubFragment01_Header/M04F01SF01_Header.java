package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment01_Header;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.wabizabi.wazabipos.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class M04F01SF01_Header extends Fragment {
    //--DATE AND TIME--//
    TextView dateText, timeText;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag01_pos_caption_text, container, false);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v){
        dateText = v.findViewById(R.id.M04F01SF01_DateText);
        timeText = v.findViewById(R.id.M04F01SF01_TimeText);

        load_CurrentDate();
        load_CurrentTime();
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

        timeText.setText(time);
    }
}
