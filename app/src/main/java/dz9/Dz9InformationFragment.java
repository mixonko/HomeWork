package dz9;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import test.com.homework.R;

import static dz9.Dz9ListFragment.exampleList;

public class Dz9InformationFragment extends Fragment implements View.OnClickListener {

    private TextView firstNameTv, secondNameTv;
    private EditText firstNameEt, secondNameEt;
    private Button save, cancel, change;
    private String firstName, secondName;
    private LinearLayout layoutView, layoutChange;
    private int position;
    private Dz9ExampleItem student;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dz9_fragment_b, container, false);
        firstNameTv = (TextView) v.findViewById(R.id.firstNameTv);
        secondNameTv = (TextView) v.findViewById(R.id.secondNameTv);
        firstNameEt = (EditText) v.findViewById(R.id.firstNameEt);
        secondNameEt = (EditText) v.findViewById(R.id.secondNameEt);
        save = (Button) v.findViewById(R.id.save);
        cancel = (Button) v.findViewById(R.id.cancel);
        change = (Button) v.findViewById(R.id.change);
        layoutView = (LinearLayout) v.findViewById(R.id.layoutView);
        layoutChange = (LinearLayout) v.findViewById(R.id.layoutChange);

        save.setOnClickListener(this);
        cancel.setOnClickListener(this);
        change.setOnClickListener(this);

        //Intent intent = getIntent();
        //position = Integer.parseInt(intent.getStringExtra(Dz9ListFragment.POSITION));
//        student = exampleList.get(position);
//        firstName = student.getFirstName();
//        secondName = student.getSecondName();
//
//        firstNameTv.setText(firstName);
//        secondNameTv.setText(secondName);
        return v;

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
 //         finish();
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
        Dz9ExampleItem student = exampleList.get(position);
        student.setFirstName(firstNameEt.getText().toString());
        student.setSecondName(secondNameEt.getText().toString());
        Toast.makeText(getContext(), "информация обновлена", Toast.LENGTH_LONG).show();
       // finish();

    }


}
