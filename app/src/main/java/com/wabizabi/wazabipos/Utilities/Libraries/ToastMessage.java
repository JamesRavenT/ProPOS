package com.wabizabi.wazabipos.Utilities.Libraries;

import android.content.Context;
import android.widget.Toast;

public abstract class ToastMessage {
    public static void show(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();

    }
}
