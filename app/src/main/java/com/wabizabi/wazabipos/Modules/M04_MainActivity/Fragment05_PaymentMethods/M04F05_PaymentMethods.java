package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment05_PaymentMethods;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.wabizabi.wazabipos.R;

public class M04F05_PaymentMethods extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act04_main_frag05_paymentmethods, container, false);
        return v;
    }
}
