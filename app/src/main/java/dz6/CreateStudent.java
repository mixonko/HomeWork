package dz6;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import test.com.homework.R;

public class CreateStudent extends Activity implements View.OnClickListener {
    private TextView firstName;
    private TextView secondName;
    private Button save;
    private Button cancel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dz6_create_student);

        firstName = (TextView) findViewById(R.id.firstName);
        secondName = (TextView) findViewById(R.id.secondName);
        save = (Button) findViewById(R.id.save);
        cancel = (Button) findViewById(R.id.cancel);

        save.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.save:
                if (firstName.getText().toString().length() != 0 && secondName.getText().toString().length() != 0) {
                    createStudent(firstName.getText().toString(), secondName.getText().toString());
                }
                break;
            case R.id.cancel:
                finish();
                break;
        }
    }

    private void createStudent(String firstName, String secondName) {
        Dz6Activity.exampleList.add(new ExampleItem(firstName, secondName));
        Toast.makeText(this, secondName + " " + firstName + " добавлен", Toast.LENGTH_LONG).show();
        finish();
    }
}
