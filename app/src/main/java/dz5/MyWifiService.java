package dz5;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;

public class MyWifiService extends Service {
    private BroadcastReceiver broadcastReceiver;
    private IntentFilter intentFilter;
    private Intent intent;
    private boolean WifiConnected;
    static final String EXTRA_KEY = "wifi";
    static final String MY_ACTION = "MY_WIFI_ACTION";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        registerReceiver();
        return new MyBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        unregisterReceiver();
        return super.onUnbind(intent);
    }

    class MyBinder extends Binder {

        MyWifiService getService() {
            return MyWifiService.this;
        }

    }

    private void registerReceiver() {
        intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.SUPPLICANT_CONNECTION_CHANGE_ACTION);
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                final String action = intent.getAction();
                if (action.equals(WifiManager.SUPPLICANT_CONNECTION_CHANGE_ACTION)) {
                    if (intent.getBooleanExtra(WifiManager.EXTRA_SUPPLICANT_CONNECTED, false)) {
                        localReceiverSend(true);
                    } else {
                        localReceiverSend(false);
                    }
                }

            }

        };

        registerReceiver(broadcastReceiver, intentFilter);

    }

    private void unregisterReceiver() {
        unregisterReceiver(broadcastReceiver);
    }

    public void getWifiState() {
        ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        WifiConnected = mWifi.isConnected();
        localReceiverSend();
    }

    private void localReceiverSend() {
        localReceiverSend(WifiConnected);
    }

    private void localReceiverSend(Boolean wifiState) {
        intent = new Intent(MY_ACTION);
        intent.putExtra(EXTRA_KEY, wifiState);
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        localBroadcastManager.sendBroadcast(intent);

    }

}
