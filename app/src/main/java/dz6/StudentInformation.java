package dz6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import test.com.homework.R;

public class StudentInformation extends Activity implements View.OnClickListener {
    TextView firstNameTv, secontNameTv;
    EditText firstNameEt, secondNameEt;
    Button save, cancel, change;
    String firstName, secondName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_information);
        firstNameTv = (TextView) findViewById(R.id.firstNameTv);
        secontNameTv = (TextView) findViewById(R.id.secondNameTv);
        firstNameEt = (EditText) findViewById(R.id.firstNameEt);
        secondNameEt = (EditText) findViewById(R.id.secondNameEt);
        save = (Button) findViewById(R.id.save);
        cancel = (Button) findViewById(R.id.cancel);
        change = (Button) findViewById(R.id.change);

        save.setOnClickListener(this);
        cancel.setOnClickListener(this);
        change.setOnClickListener(this);

        Intent intent = getIntent();
        firstName = intent.getStringExtra(Dz6Activity.firstName);
        secondName = intent.getStringExtra(Dz6Activity.secondName);

        firstNameTv.setText(firstName);
        secontNameTv.setText(secondName);
    }

    @Override
    public void onClick(View view) {

    }
}
