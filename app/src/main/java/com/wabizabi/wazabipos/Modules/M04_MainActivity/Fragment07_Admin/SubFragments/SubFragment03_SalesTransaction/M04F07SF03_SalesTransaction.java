package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment07_Admin.SubFragments.SubFragment03_SalesTransaction;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.LayoutHelper;

import io.realm.Realm;

public class M04F07SF03_SalesTransaction extends Fragment {
    //--DATABASE--//
    Realm realm = Realm.getDefaultInstance();

    //--RECYCLERVIEW--//
    RecyclerView transactionsRV;
    RecyclerView.Adapter transactionsRVA;

    //--SEARCH BAR--//
    EditText searchbar;

    //--DG01 SEARCH SETTINGS--//


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutHelper.inflateFragment(inflater, container, R.layout.act04_main_frag07_admin_subfrag03_salestransaction);
        return v;
    }

    private void init_FragmentFunctionalities(){

    }

    private void load_SearchBar(){
        searchbar.setText("");
        searchbar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void load_FilteredSearchBar(){}

    private void load_RecyclerView(){

    }


    private void init_Dialogs(){

    }

    private void load_DG01Functionalities(){

    }

    private void load_DG02Functionalities(){

    }
}
