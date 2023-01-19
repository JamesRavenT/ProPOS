package com.wabizabi.wazabipos.Utilities.Interfaces;

import com.wabizabi.wazabipos.Database.ObjectSchemas.MenuItem;

import java.util.List;

public interface RecyclerViewLoader {
    void load_RVContents(int position, List<MenuItem> products);
}
