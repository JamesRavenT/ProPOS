package com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment08_Printer.Adapters;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment08_Printer.M04F08_Printer.printer;
import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment08_Printer.M04F08_Printer.socket;

import android.Manifest;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.wabizabi.wazabipos.R;
import com.wabizabi.wazabipos.Utilities.Interfaces.FragmentLoader;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.LayoutHelper;
import com.wabizabi.wazabipos.Utilities.Libraries.Helper.LogHelper;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

public class M04F08_PrinterRVA extends RecyclerView.Adapter<M04F08_PrinterRVA.ViewHolder> {
    Activity context;
    BluetoothAdapter btAdapter;
    List<BluetoothDevice> listOfBluetoothDevices;
    FragmentLoader fragmentLoader;

    OutputStream outputStream;
    InputStream inputStream;
    Thread thread;
    byte[] readBuffer;
    int readBUfferPosition;
    volatile boolean stopWorker;

    public M04F08_PrinterRVA(Activity context, BluetoothAdapter btAdapter, List<BluetoothDevice> listOfBluetoothDevices, FragmentLoader fragmentLoader) {
        this.context = context;
        this.btAdapter = btAdapter;
        this.listOfBluetoothDevices = listOfBluetoothDevices;
        this.fragmentLoader = fragmentLoader;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutHelper.inflateRV(parent, R.layout.act04_main_frag08_print_rvlayout);
        ViewHolder layout = new ViewHolder(view);
        return layout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BluetoothDevice device = listOfBluetoothDevices.get(position);
        holder.loadFunctionalities(device, position);
    }

    @Override
    public int getItemCount() {
        return listOfBluetoothDevices.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int position;
        private TextView deviceName;
        private CardView connectBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            deviceName = itemView.findViewById(R.id.M04F08_RVPairedDeviceName);
            connectBtn = itemView.findViewById(R.id.M04F08_RVConnectBtn);
        }

        public void loadFunctionalities(BluetoothDevice device, int position){
            //Check For Permissions
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_DENIED) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.BLUETOOTH_CONNECT}, 2);
                    return;
                }
            }

            //Load Details
            String name = String.valueOf(device.getName());

            //Set Views
            this.position = position;
            deviceName.setText(name);

            //On ConnectBtn
            connectBtn.setOnClickListener(connect -> {
                if(printer != device){
                    try {
                        printer = device;
                        UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
                        socket = printer.createRfcommSocketToServiceRecord(uuid);
                        socket.connect();
                        outputStream = socket.getOutputStream();
                        inputStream = socket.getInputStream();
                        listenForOutput();
                        listOfBluetoothDevices.remove(device);
                        notifyDataSetChanged();
                        fragmentLoader.load_FGContents();
                    } catch (Exception e) { e.printStackTrace(); }
                }
            });
        }

        public void listenForOutput(){
            try{
                final Handler handler = new Handler();
                byte delimiter = 10;
                stopWorker = false;
                readBUfferPosition = 0;
                readBuffer = new byte[1024];
                thread = new Thread(() -> {
                    while(!Thread.currentThread().isInterrupted() && !stopWorker){
                        try{
                            int byteAvailable = inputStream.available();
                            if(byteAvailable > 0){
                                byte[] packetByte = new byte[byteAvailable];
                                inputStream.read(packetByte);

                                for(int i = 0 ; i < byteAvailable ; i++){
                                    byte b = packetByte[i];
                                    if(b == delimiter){
                                        byte[] encodedByte = new byte[readBUfferPosition];
                                        System.arraycopy(
                                                readBuffer ,0,
                                                encodedByte, 0,
                                                encodedByte.length
                                        );
                                        final String data = new String(encodedByte, "US-ASCII");
                                        readBUfferPosition = 0;
                                        handler.post(new Runnable() {
                                            @Override
                                            public void run() {
                                                LogHelper.debug(data);
                                            }
                                        });
                                    } else {
                                        readBuffer [readBUfferPosition++] = b;
                                    }
                                }
                            }
                        } catch (Exception e) {
                            stopWorker = true;
                        }
                    }
                });
                thread.start();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
