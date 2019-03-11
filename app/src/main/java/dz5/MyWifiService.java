package dz5;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;

public class MyWifiService extends Service {
    private BroadcastReceiver broadcastReceiver;
    private IntentFilter intentFilter;
    private Boolean wifiState;
    private Intent intent;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        registerReceiver();
        return new Binder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        unregisterReceiver();
        return super.onUnbind(intent);
    }

    private void registerReceiver() {
        intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                int extra = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, 0);
                if (extra == WifiManager.WIFI_STATE_ENABLED) {
                    wifiState = true;

                }
                if (extra == WifiManager.WIFI_STATE_DISABLED) {
                    wifiState = false;
                }

                localReceiver(wifiState);

            }

        };
        registerReceiver(broadcastReceiver, intentFilter);

    }

    private void unregisterReceiver() {
        unregisterReceiver(broadcastReceiver);
    }

    private void localReceiver(Boolean wifiState) {
        intent = new Intent("wifi");
        intent.putExtra("wifi", wifiState);
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        localBroadcastManager.sendBroadcast(intent);

    }

}
