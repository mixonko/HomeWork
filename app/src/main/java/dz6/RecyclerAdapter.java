package dz6;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import test.com.homework.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{
    private ArrayList<StudentsList> list = new ArrayList<>();


    public void addAll(List<StudentsList> studentsLists) {
        int pos = getItemCount();
        list.addAll(studentsLists);
        notifyItemRangeInserted(pos, list.size());
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dz6_item, viewGroup, false);

        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int position) {
        recyclerViewHolder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
