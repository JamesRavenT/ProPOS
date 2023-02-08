package com.wabizabi.wazabipos.Utilities.Libraries.Helper;

import android.content.Context;
import android.widget.Toast;

public abstract class ToastHelper {
    public static void show(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();

    }
}
