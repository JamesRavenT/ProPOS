package com.wabizabi.wazabipos.Utilities.Interfaces;

import com.wabizabi.wazabipos.Database.ObjectSchemas.MenuItem;

import java.util.List;

public interface RVMenuLoader {
    void load_RVContents(List<MenuItem> listOfItems);
}
