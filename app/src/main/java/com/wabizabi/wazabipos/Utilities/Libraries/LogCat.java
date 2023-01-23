package com.wabizabi.wazabipos.Utilities.Libraries;

import android.util.Log;

public abstract class LogCat {
    String name = "Tester";

    public static void debug(String message) {
        Log.d("-------DEBUG-------", "log: ");
    }

}
