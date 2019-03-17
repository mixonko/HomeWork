package dz5;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.ImageView;

import test.com.homework.R;

public class Dz5Activity extends Activity {
    private Intent intentService;
    private ServiceConnection serviceConnection;
    private ImageView imageView;
    private Boolean wifi;
    private BroadcastReceiver localBroadcastManager;
    private MyWifiService myService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dz5);
        imageView = (ImageView) findViewById(R.id.wifi);

    }

    @Override
    protected void onStart() {
        super.onStart();
        onBindService();
        registerLocalReceiver();

    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(serviceConnection);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(localBroadcastManager);
    }

    private void onBindService() {
        intentService = new Intent(this, MyWifiService.class);
        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
            }
        };

        bindService(intentService, serviceConnection, BIND_AUTO_CREATE);
    }


    private void registerLocalReceiver() {
        IntentFilter filter = new IntentFilter(MyWifiService.MY_ACTION);

        localBroadcastManager = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent != null) {

                    boolean wifi = intent.getBooleanExtra(MyWifiService.EXTRA_KEY, false);
                    if (wifi == true) {
                        imageView.setImageResource(R.drawable.wifi_is_on);
                    } else {
                        imageView.setImageResource(R.drawable.wifi_is_off);

                    }
                }
            }
        };
        LocalBroadcastManager.getInstance(this).registerReceiver(localBroadcastManager, filter);
    }


}
