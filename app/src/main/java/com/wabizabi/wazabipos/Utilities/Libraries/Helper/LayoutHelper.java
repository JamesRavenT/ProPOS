package com.wabizabi.wazabipos.Utilities.Libraries.Helper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

public abstract class LayoutHelper {
    
    public static View inflateRV(@NonNull ViewGroup parent, int resource){
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return view;
    }
    public static View inflateFragment(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, int resource){
        View view = inflater.inflate(resource, container, false);
        return view;
    }
}
