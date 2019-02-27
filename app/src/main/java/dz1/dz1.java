package dz1;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import test.com.homework.R;

public class dz1 extends Activity implements View.OnClickListener {
    private TextView text1, text2;
    private Button bt;
    private String text3;
    private Drawable color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dz1);

        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        bt = (Button) findViewById(R.id.button);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change();
            }
        };

        text1.setOnClickListener(clickListener);
        text2.setOnClickListener(this);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change();
            }
        });
    }

    @Override
    public void onClick(View view) {
        change();
    }

    private void change() {
        text3 = text2.getText().toString();
        text2.setText(text1.getText().toString());
        text1.setText(text3);
        color = text2.getBackground();
        text2.setBackground(text1.getBackground());
        text1.setBackground(color);
    }
}
