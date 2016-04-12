package com.example.taifa.bluetoothapp;

import android.support.v7.app.AppCompatActivity;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by taifa on 4/12/16.
 */
//public class ClassicBluetoothActivity {
//}

public class ClassicBluetoothActivity extends AppCompatActivity {

    private BluetoothController mBluetoothController;

    private Button btnScanAvaliabe, btnScan, btnOpen, btnStartServer;
    private TextView tvBTState;
    private ListView lvDevices;

    private List<String> mList;
    private BaseAdapter mFoundAdapter;
    private String mMacAddress;

    private static final String TAG = "LMBluetoothSdk";

    private BluetoothListener mListener = new BluetoothListener() {
        @Override
        public void onActionStateChanged(int preState, int state) {
            tvBTState.setText("Bluetooth state: " + Utils.transBtStateAsString(state));
        }

