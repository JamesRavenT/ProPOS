package com.wabizabi.wazabipos.Utilities.Libraries.Helper;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.text.DecimalFormat;

public class IntegerHelper extends IndexAxisValueFormatter {
    private DecimalFormat mFormat;

    public IntegerHelper() {
        mFormat = new DecimalFormat("###,##0");
    }

    @Override
    public String getBarLabel(BarEntry barEntry) {
        return mFormat.format(barEntry.getY());
    }
}
