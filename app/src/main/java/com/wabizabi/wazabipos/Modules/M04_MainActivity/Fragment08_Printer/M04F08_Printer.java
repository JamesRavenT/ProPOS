package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment08_Printer;

import android.Manifest;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment08_Printer.Adapters.M04F08_PrinterRVA;
import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Interfaces.FragmentLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.LayoutHelper;

import android.bluetooth.BluetoothAdapter;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class M04F08_Printer extends Fragment implements FragmentLoader {

    //--BLUETOOTH--//
    BluetoothAdapter btAdapter;
    public static BluetoothDevice printer = null;
    public static BluetoothSocket socket;


    //--IO STREAM--//
    OutputStream outputStream;
    InputStream inputStream;
    Thread thread;
    byte[] readBuffer;
    int readBUfferPosition;
    volatile boolean stopWorker;

    //--SEARCH FOR DEVICES--//
    ImageView searchButton;

    //--CONNECTED DEVICE--//
    CardView connectedDevice;
    TextView connectedDeviceName;
    CardView disconnectBtn;

    //--RECYCLERVIEW--//
    RecyclerView devicesRV;
    RecyclerView.Adapter devicesRVA;
    List<BluetoothDevice> listOfBluetoothDevices;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutHelper.inflateFragment(inflater, container, R.layout.act04_main_frag08_print);
        init_FragmentFunctionalities(v);
        return v;
    }

    private void init_FragmentFunctionalities(View v) {
        searchButton = v.findViewById(R.id.M04F08_SearchForDevices);
        connectedDevice = v.findViewById(R.id.M04F08_ConnectedDeviceContainer);
        connectedDeviceName = v.findViewById(R.id.M04F08_ConnectedDeviceName);
        disconnectBtn = v.findViewById(R.id.M04F08_DisconnectBtn);
        devicesRV = v.findViewById(R.id.M04F08_PairedDevicesRV);

        init_Devices();
        load_SearchFunction();
        load_RecyclerView();
    }
    private void init_Devices(){
        listOfBluetoothDevices = new ArrayList<>();
        try {
            //Check Permissions
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_DENIED) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.BLUETOOTH_CONNECT}, 2);
                    return;
                }
            }
            btAdapter = BluetoothAdapter.getDefaultAdapter();
            if (btAdapter == null || !btAdapter.isEnabled()){
                connectedDevice.setVisibility(View.INVISIBLE);
            }
            if (btAdapter.isEnabled()) {
                startActivity(new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE));
            }

            //Check if there's a connected Device
            if(printer == null){
                connectedDevice.setVisibility(View.INVISIBLE);
            } else if (printer != null){
                //Set Views
                connectedDevice.setVisibility(View.VISIBLE);
                connectedDeviceName.setText(printer.getName());
                //On Clicking Disconnect Btn
                disconnectBtn.setOnClickListener(disconnect -> {
                    try{
                        BluetoothDevice device = printer;
                        stopWorker = true;
                        outputStream = socket.getOutputStream();
                        inputStream = socket.getInputStream();
                        outputStream.close();
                        inputStream.close();
                        socket.close();
                        listOfBluetoothDevices.add(device);
                        printer = null;
                        devicesRVA.notifyDataSetChanged();
                        init_Devices();
                        load_RecyclerView();
                    } catch (Exception e) { e.printStackTrace(); }
                });
            }

            //Load Paired Devices
            Set<BluetoothDevice> devices = btAdapter.getBondedDevices();
            if (devices.size() > 0) {
                for (BluetoothDevice device : devices) {
                    if(printer != null){
                        if(!printer.getName().equals(device.getName())){
                            listOfBluetoothDevices.add(device);
                        }
                    } else {
                        listOfBluetoothDevices.add(device);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void load_SearchFunction(){
        searchButton.setOnClickListener(search -> {
            init_Devices();
            load_RecyclerView();
        });
    }

    private void load_RecyclerView(){
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        devicesRVA = new M04F08_PrinterRVA(getActivity(), btAdapter, listOfBluetoothDevices, this);
        devicesRV.setAdapter(devicesRVA);
        devicesRV.setLayoutManager(layout);
    }

    @Override
    public void load_FGContents() {
        init_Devices();
    }
}
