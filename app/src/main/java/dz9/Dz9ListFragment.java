package dz9;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import test.com.homework.R;

public class Dz9ListFragment extends Fragment implements View.OnClickListener {
    private RecyclerView recyclerView;
    private Dz9ExampleAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private Button create;
    private EditText editText;
    private ListFragmentListener listener;

    public static ArrayList<Dz9ExampleItem> exampleList;

    public static final String POSITION = "POSITION";

    public interface ListFragmentListener{
        void onItemClick(int position);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dz9_fragment_a, container, false);



        create = (Button) v.findViewById(R.id.create);
        create.setOnClickListener(this);
        editText = (EditText) v.findViewById(R.id.editText);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);

        createExampleList();
        buildRecyclerView();

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });

        return v;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    private void filter(String text) {
        ArrayList<Dz9ExampleItem> filteredList = new ArrayList<>();

        for (Dz9ExampleItem item : exampleList) {
            if (item.getFirstName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        adapter.filterList(filteredList);
    }

    public void createExampleList() {
        exampleList = (Dz9ExampleItem.getList());
    }

    public void buildRecyclerView() {

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        adapter = new Dz9ExampleAdapter(exampleList);

         recyclerView.setLayoutManager(layoutManager);
         recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new Dz9ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
         //       changeItem(position);
                listener.onItemClick(position);
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
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    public void createStudent() {
        Intent intent = new Intent(getContext(), Dz9CreateStudent.class);
        startActivity(intent);
    }

    public void removeItem(int position) {
        Toast.makeText(getContext(), exampleList.get(position).getSecondName() + " " +
                exampleList.get(position).getFirstName() + " удален", Toast.LENGTH_LONG).show();
        exampleList.remove(position);
        adapter.notifyItemRemoved(position);

    }

    public void changeItem(int position) {
        Intent intent = new Intent(getContext(), Dz9InformationFragment.class);
        intent.putExtra(POSITION, String.valueOf(position));
        startActivity(intent);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ListFragmentListener ) {
            listener = (ListFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentAListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public void updateList(){
        adapter.notifyDataSetChanged();
    }
}
