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
import android.util.Log;
import android.widget.ImageView;

import test.com.homework.R;

public class Dz5Activity extends Activity {
    private Intent intentService;
    private ServiceConnection serviceConnection;
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dz5);


        IntentFilter filter= new IntentFilter();
        filter.addAction("wifi");

        BroadcastReceiver localBroadcastManager = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.i("УРА", String.valueOf(intent.getBooleanExtra("wifi", false)));
            }
        };
        LocalBroadcastManager.getInstance(this).registerReceiver(localBroadcastManager, filter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        onBindService();

    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(serviceConnection);
        Log.i("service", "onStop: ");
    }

    public void onBindService () {
        intentService = new Intent(this, MyWifiService.class);
        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Log.i("service", "onServiceConnected: ");
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                Log.i("service", "onServiceDisconnected: ");
            }
        };

        intentService = new Intent(this, MyWifiService.class);
        bindService(intentService, serviceConnection, BIND_AUTO_CREATE);
        Log.i("service", "onStart: ");
    }
}
