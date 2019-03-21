package dz6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import test.com.homework.R;

public class Dz6Activity extends Activity implements View.OnClickListener {
    public static ArrayList<ExampleItem> exampleList;
    private RecyclerView recyclerView;
    private ExampleAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private Button create;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dz6);

        createExampleList();
        buildRecyclerView();

        create = (Button) findViewById(R.id.create);
        create.setOnClickListener(this);


    }

    public void createExampleList(){
        exampleList= (ExampleItem.getList());
    }

    public void buildRecyclerView(){
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this );
        adapter = new ExampleAdapter(exampleList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                removeItem(position);
            }
        });
    }

    @Override
    public void onClick(View view) {
        createStudent();
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    public void createStudent(){
        Intent intent = new Intent(this, CreateStudent.class);
        startActivity(intent);
    }

    public void removeItem(int position){
        exampleList.remove(position);
        adapter.notifyItemRemoved(position);
    }
}
