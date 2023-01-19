package com.wabizabi.wazabipos.Utilities.Interfaces;

import android.content.Context;

public interface DialogLoader {
    void load_DGContents();

    void load_DGContents(int dialogNo);

    void load_DGContents(int image, String name, double price);
}
