package dz6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import test.com.homework.R;

import static dz6.Dz6Activity.exampleList;

public class StudentInformation extends Activity implements View.OnClickListener {
    private TextView firstNameTv, secondNameTv;
    private EditText firstNameEt, secondNameEt;
    private Button save, cancel, change;
    private String firstName, secondName;
    private LinearLayout layoutView, layoutChange;
    private int position;
    private ExampleItem student;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dz6_student_information);
        firstNameTv = (TextView) findViewById(R.id.firstNameTv);
        secondNameTv = (TextView) findViewById(R.id.secondNameTv);
        firstNameEt = (EditText) findViewById(R.id.firstNameEt);
        secondNameEt = (EditText) findViewById(R.id.secondNameEt);
        save = (Button) findViewById(R.id.save);
        cancel = (Button) findViewById(R.id.cancel);
        change = (Button) findViewById(R.id.change);
        layoutView = (LinearLayout) findViewById(R.id.layoutView);
        layoutChange = (LinearLayout) findViewById(R.id.layoutChange);

        save.setOnClickListener(this);
        cancel.setOnClickListener(this);
        change.setOnClickListener(this);

        Intent intent = getIntent();
        position = Integer.parseInt(intent.getStringExtra(Dz6Activity.POSITION));
        student = exampleList.get(position);
        firstName = student.getFirstName();
        secondName = student.getSecondName();

        firstNameTv.setText(firstName);
        secondNameTv.setText(secondName);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.change:
                change();
                break;
            case R.id.save:
                saveChanges();
                break;
            case R.id.cancel:
                finish();
                break;
        }
    }

    private void change() {
        layoutView.setVisibility(View.INVISIBLE);
        layoutChange.setVisibility(View.VISIBLE);
        firstNameEt.setText(firstName);
        secondNameEt.setText(secondName);
    }


    private void saveChanges() {
        ExampleItem student = exampleList.get(position);
        student.setFirstName(firstNameEt.getText().toString());
        student.setSecondName(secondNameEt.getText().toString());
        Toast.makeText(this, "информация обновлена", Toast.LENGTH_LONG).show();
        finish();

    }
}
