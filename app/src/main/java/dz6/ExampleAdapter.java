package dz6;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import test.com.homework.R;

public class ExampleAdapter extends RecyclerView.Adapter <ExampleAdapter.ExampleViewHolder> {
    private ArrayList<ExampleItem> exampleList;
    public static class ExampleViewHolder extends RecyclerView.ViewHolder{
    public ImageView imageView;
    public TextView firstName;
    public TextView secondName;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            firstName = itemView.findViewById(R.id.firstName);
            secondName = itemView.findViewById(R.id.secondName);

        }
    }

    public ExampleAdapter(ArrayList<ExampleItem> exampleList){
        this.exampleList = exampleList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dz6_item, viewGroup, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;

    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        ExampleItem currentItem = exampleList.get(position);
        holder.imageView.setImageResource(currentItem.getImageResource());
        holder.firstName.setText(currentItem.getFirstName());
        holder.secondName.setText(currentItem.getSecondName());
    }

    @Override
    public int getItemCount() {
        return exampleList.size();
    }
}
