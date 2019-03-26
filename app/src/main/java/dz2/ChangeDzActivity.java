package dz2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import dz1.Dz1Activity;
import dz3.Dz3Activity;
import dz3.LoginActivity;
import dz4.Dz4ClockActivity;
import dz4.Dz4DiagramActivity;
import dz5.Dz5Activity;
import dz6.Dz6Activity;
import test.com.homework.R;

public class ChangeDzActivity extends Activity implements View.OnClickListener {
    private Button dz1, dz2, dz3, dz3Login, dz4Clock, dz4Diagram, dz5, dz6, dz9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_dz);

        dz1 = (Button) findViewById(R.id.dz1);
        dz2 = (Button) findViewById(R.id.dz2);
        dz3 = (Button) findViewById(R.id.dz3);
        dz3Login = (Button) findViewById(R.id.dz3Login);
        dz4Clock = (Button) findViewById(R.id.dz4Clock);
        dz4Diagram = (Button) findViewById(R.id.dz4Diagram);
        dz5 = (Button) findViewById(R.id.dz5);
        dz6 = (Button) findViewById(R.id.dz6);
        dz9 = (Button) findViewById(R.id.dz9);

        dz1.setOnClickListener(this);
        dz2.setOnClickListener(this);
        dz3.setOnClickListener(this);
        dz3Login.setOnClickListener(this);
        dz4Clock.setOnClickListener(this);
        dz4Diagram.setOnClickListener(this);
        dz5.setOnClickListener(this);
        dz6.setOnClickListener(this);
        dz9.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dz1:
                startActivity(new Intent(this, Dz1Activity.class));
                break;
            case R.id.dz2:
                startActivity(new Intent(this, Dz2Activity.class));
                break;
            case R.id.dz3:
                startActivity(new Intent(this, Dz3Activity.class));
                break;
            case R.id.dz3Login:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.dz4Clock:
                startActivity(new Intent(this, Dz4ClockActivity.class));
                break;
            case R.id.dz4Diagram:
                startActivity(new Intent(this, Dz4DiagramActivity.class));
                break;
            case R.id.dz5:
                startActivity(new Intent(this, Dz5Activity.class));
                break;
            case R.id.dz6:
                startActivity(new Intent(this, Dz6Activity.class));
                break;
            case R.id.dz9:
                startActivity(new Intent(this, Dz6Activity.class));
                break;
        }
    }
}
