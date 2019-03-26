package dz9;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.FrameLayout;
import android.widget.Toast;

import test.com.homework.R;

public class Dz9Activity extends FragmentActivity implements Dz9ListFragment.ListFragmentListener {
    private Dz9ListFragment listFragment;
    private Dz9InformationFragment informationFragment;
    Boolean tablet = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dz9);

        listFragment = new Dz9ListFragment();
        informationFragment = new Dz9InformationFragment();


        FrameLayout conteinerB = (FrameLayout)findViewById(R.id.conteiner_b);
        if(conteinerB == null){
            phoneView();
        }else{
            tabletView();
        }


    }

    private void phoneView(){
        getSupportFragmentManager().beginTransaction().
                replace(R.id.conteiner_a, listFragment)
                .commit();
    }

    private void tabletView(){
        getSupportFragmentManager().beginTransaction().
                replace(R.id.conteiner_a, listFragment)
                .replace(R.id.conteiner_b, informationFragment)
                .commit();
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(this, String.valueOf(position), Toast.LENGTH_LONG).show();
    }
}
