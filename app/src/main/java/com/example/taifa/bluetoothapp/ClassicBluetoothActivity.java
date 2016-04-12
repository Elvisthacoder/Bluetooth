package com.example.taifa.bluetoothapp;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.UUID;

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
        @Override
        public void onActionDiscoveryStateChanged(String discoveryState) {
            if (discoveryState.equals(BluetoothAdapter.ACTION_DISCOVERY_STARTED)) {
                Toast.makeText(ClassicBluetoothActivity.this, "scanning!", Toast.LENGTH_SHORT).show();
            } else if (discoveryState.equals(BluetoothAdapter.ACTION_DISCOVERY_FINISHED)) {
                Toast.makeText(ClassicBluetoothActivity.this, "scan finished!", Toast.LENGTH_SHORT).show();
            }
        }
        @Override
        public void onActionScanModeChanged(int preScanMode, int scanMode) {
            Log.d(TAG, "preScanMode:" + preScanMode + ", scanMode:" + scanMode);
        }
        @Override
        public void onBluetoothServiceStateChanged(int state) {
            Log.d(TAG, "bluetooth service state:" + state);
            if (state == State.STATE_CONNECTED) {
                Intent intent = new Intent(ClassicBluetoothActivity.this, ChatActivity.class);
                startActivityForResult(intent, 4);
            }
        }
        @Override
        public void onActionDeviceFound(BluetoothDevice device, short rssi) {
            mList.add(device.getName() + "@" + device.getAddress());
            mFoundAdapter.notifyDataSetChanged();
        }
        @Override
        public void onReadData(final BluetoothDevice device, final byte[] data) {
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classicbt);
        getSupportActionBar().setTitle("Classic Bluetooth Sample");
        init();
    }
    private void initBT(){
        mBluetoothController = BluetoothController.getInstance().build(this);
        mBluetoothController.setAppUuid(UUID.fromString("fa87c0d0-afac-12de-8a39-0450200c9a66"));
        mBluetoothController.setBluetoothListener(mListener);

        tvBTState.setText("Bluetooth state: "
                + Utils.transBtStateAsString(mBluetoothController.getBluetoothState()));
    }

