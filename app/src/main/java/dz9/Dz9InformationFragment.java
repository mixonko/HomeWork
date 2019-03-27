package dz9;

import android.content.Context;
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

import static dz9.Dz9Activity.theTablet;
import static dz9.Dz9ListFragment.exampleList;


public class Dz9InformationFragment extends Fragment implements View.OnClickListener {

    private TextView firstNameTv, secondNameTv;
    private EditText firstNameEt, secondNameEt;
    private Button save, change;
    private String firstName, secondName;
    private LinearLayout layoutView, layoutChange;
    private Dz9ExampleItem student;
    private int position;
    private InformationFragmentListener listener;

    public interface InformationFragmentListener{
        void onSave( );
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dz9_fragment_b, container, false);

        return v;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        firstNameTv = (TextView) getView().findViewById(R.id.firstNameTv);
        secondNameTv = (TextView) getView().findViewById(R.id.secondNameTv);
        firstNameEt = (EditText) getView().findViewById(R.id.firstNameEt);
        secondNameEt = (EditText) getView().findViewById(R.id.secondNameEt);
        save = (Button) getView().findViewById(R.id.save);
        change = (Button) getView().findViewById(R.id.change);
        layoutView = (LinearLayout) getView().findViewById(R.id.layoutView);
        layoutChange = (LinearLayout) getView().findViewById(R.id.layoutChange);

        save.setOnClickListener(this);
        change.setOnClickListener(this);

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
        if(theTablet){
            listener.onSave();
        }else{
            getActivity().finish();
        }

    }

    public void setPosition(int position) {
        this.position = position;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof InformationFragmentListener ) {
            listener = (InformationFragmentListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

}
