package com.wabizabi.wazabipos.Utilities.Libraries.Helper;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

public abstract class DialogBuilder {

    public static Dialog create(Context context, int resource) {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(resource);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setDimAmount(0.5f);
        dialog.setCanceledOnTouchOutside(false);
        return dialog;

    }

}
