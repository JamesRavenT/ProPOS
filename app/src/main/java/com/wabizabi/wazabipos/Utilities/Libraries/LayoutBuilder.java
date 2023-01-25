package com.wabizabi.wazabipos.Utilities.Libraries;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

public abstract class LayoutBuilder {
    
    public static View inflate(@NonNull ViewGroup parent, int resource){
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return view;
    }
}
