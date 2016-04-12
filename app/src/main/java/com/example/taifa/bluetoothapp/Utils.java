package com.example.taifa.bluetoothapp;

/**
 * Created by taifa on 4/12/16.
 */
import android.bluetooth.BluetoothAdapter;
import com.example.taifa.lmbluetoothsdk.base.State;

public class Utils {


    public static String transConnStateAsString(int state) {
        String result;
        if (state == State.STATE_NONE) {
            result = "NONE";
        } else if (state == State.STATE_LISTEN) {
            result = "LISTEN";
        } else if (state == State.STATE_CONNECTING) {
            result = "CONNECTING";
        } else if (state == State.STATE_CONNECTED) {
            result = "CONNECTED";
        } else if (state == State.STATE_DISCONNECTED) {
            result = "DISCONNECTED";
        } else if (state == State.STATE_GOT_CHARACTERISTICS) {
            result = "CONNECTED, GOT ALL CHARACTERISTICS";
        } else {
            result = "UNKNOWN";
        }
        return result;
    }

    public static String transBtStateAsString(int state) {
        String result = "UNKNOWN";
        if (state == BluetoothAdapter.STATE_TURNING_ON) {
            result = "TURNING_ON";
        } else if (state == BluetoothAdapter.STATE_ON) {
            result = "ON";
        } else if (state == BluetoothAdapter.STATE_TURNING_OFF) {
            result = "TURNING_OFF";
        } else if (state == BluetoothAdapter.STATE_OFF) {
            result = "OFF";
        }
        return result;
    }

}