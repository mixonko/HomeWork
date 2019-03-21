package dz6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import test.com.homework.R;

public class Dz6Activity extends Activity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private ExampleAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private Button create;
    private ExampleItem student;
    private EditText editText;

    public static ArrayList<ExampleItem> exampleList;

    public static final String FIRST_NAME = "FIRST_NAME";
    public static final String SECOND_NAME = "SECOND_NAME";
    public static final String POSITION = "POSITION";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dz6);

        createExampleList();
        buildRecyclerView();

        editText = (EditText) findViewById(R.id.editText);
        create = (Button) findViewById(R.id.create);
        create.setOnClickListener(this);

    }

    public void createExampleList() {
        exampleList = (ExampleItem.getList());
    }

    public void buildRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        adapter = new ExampleAdapter(exampleList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                changeItem(position);
            }

            @Override
            public void onDeleteClick(int position) {
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

    public void createStudent() {
        Intent intent = new Intent(this, CreateStudent.class);
        startActivity(intent);
    }

    public void removeItem(int position) {
        Toast.makeText(this, exampleList.get(position).getSecondName() + " " +
                exampleList.get(position).getFirstName() + " удален", Toast.LENGTH_LONG).show();
        exampleList.remove(position);
        adapter.notifyItemRemoved(position);


    }

    public void changeItem(int position) {
        student = exampleList.get(position);
        Intent intent = new Intent(this, StudentInformation.class);
        intent.putExtra(FIRST_NAME, student.getFirstName());
        intent.putExtra(SECOND_NAME, student.getSecondName());
        intent.putExtra(POSITION, String.valueOf(position));

        startActivity(intent);
    }

}
