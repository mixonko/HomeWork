package dz9;

import android.content.Intent;
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
        if (conteinerB == null){
            tablet = false;
        }


        if(tablet){
            tabletView();
        }else{
            phoneView();
        }

    }

    private void phoneView(){
        getSupportFragmentManager().beginTransaction().
                replace(R.id.conteiner_a, listFragment)
                .commit();
    }

    private void phoneInformatin(int position){
        Intent intent = new Intent(this, Dz9StudentInformation.class);
        intent.putExtra(Dz9ListFragment.POSITION, String.valueOf(position));
        startActivity(intent);
    }

    private void tabletView(){
        getSupportFragmentManager().beginTransaction().
                replace(R.id.conteiner_a, listFragment)
                .replace(R.id.conteiner_b, informationFragment)
                .commit();
    }

    private void tabletInformatin(int position){

    }

    @Override
    public void onItemClick(int position) {
        if(tablet){
            tabletInformatin(position);
        }else{
            phoneInformatin(position);
        }
    }



}
