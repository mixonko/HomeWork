package dz9;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import test.com.homework.R;

import static dz9.Dz9ListFragment.exampleList;

public class Dz9StudentInformation extends FragmentActivity {

    private Dz9InformationFragment informationFragment;
    private int position;
    private Dz9ExampleItem item;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dz9_student_information);

        informationFragment = new Dz9InformationFragment();
        getSupportFragmentManager().beginTransaction().
                replace(R.id.conteiner_b, informationFragment)
                .commit();

        position = Integer.parseInt(getIntent().getStringExtra(Dz9ListFragment.POSITION));
        item = exampleList.get(position);



        Toast.makeText(this,item.getFirstName() , Toast.LENGTH_LONG).show();
    }
}
