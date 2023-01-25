package com.wabizabi.wazabipos.Utilities.Interfaces;

import com.wabizabi.wazabipos.Database.ObjectSchemas.MenuItem;
import com.wabizabi.wazabipos.Database.ObjectSchemas.StockItem;

import java.util.List;

public interface RVStockLoader {
    void load_RVContents(List<StockItem> listOfItems);
}
