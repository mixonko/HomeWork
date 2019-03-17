package dz5;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import test.com.homework.R;

public class Dz5Activity extends Activity {
    private Intent intentService;
    private ServiceConnection serviceConnection;
    private ImageView imageView;
    private Button button;
    private Boolean wifi;
    private Boolean bound;
    private BroadcastReceiver localBroadcastManager;
    private MyWifiService myService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dz5);
        imageView = (ImageView) findViewById(R.id.wifi);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bound) {
                    myService.getWifiState();
                }
            }

        });

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
        LocalBroadcastManager.getInstance(this).unregisterReceiver(localBroadcastManager);
        unbindService(serviceConnection);

    }

    private void onBindService() {
        intentService = new Intent(this, MyWifiService.class);
        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                myService = ((MyWifiService.MyBinder) iBinder).getService();
                bound = true;

            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                bound = false;

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

                    wifi = intent.getBooleanExtra(MyWifiService.EXTRA_KEY, false);
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
