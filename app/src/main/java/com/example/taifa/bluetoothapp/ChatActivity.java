package com.example.taifa.bluetoothapp;

/**
 * Created by taifa on 4/12/16.
 */

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import co.lujun.lmbluetoothsdk.BluetoothController;
import co.lujun.lmbluetoothsdk.base.BluetoothListener;
import co.lujun.lmbluetoothsdk.base.State;

//public class ChatActivity {
//}

public class ChatActivity extends Activity {
    private BluetoothController mBluetoothController;

    private Button btnDisconnect, btnSend;
    private EditText etSend;
    private TextView tvConnectState, tvContent, tvDeviceName, tvDeviceMac;

    private int mConnectState;
    private String mMacAddress = "", mDeviceName = "";

    private static final String TAG = "LMBluetoothSdk";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_main);

        init();
    }