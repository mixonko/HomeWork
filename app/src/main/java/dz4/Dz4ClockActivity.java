package dz4;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import test.com.homework.R;

public class Dz4ClockActivity extends Activity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dz4_clock);

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setBackgroundResource(R.drawable.animation_sova);
        ((AnimationDrawable) imageView.getBackground()).start();

    }

}
