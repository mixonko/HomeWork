package dz3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import test.com.homework.R;

public class Dz3Activity extends Activity {
    ImageView imageView;
    Button button;
    EditText editText;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dz3);

        imageView = (ImageView) findViewById(R.id.imageView);
        button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                Picasso.get()
                        .load(editText.getText().toString())
                        .resize(700, 700)
                        .centerCrop()
                        .transform(new CircularTransformation(0))
                        .into(imageView, callback);
            }
        });
    }

    Callback callback = new Callback() {
        @Override
        public void onSuccess() {
            progressBar.setVisibility(View.INVISIBLE);
        }

        @Override
        public void onError(Exception e) {
        }
    };
}
