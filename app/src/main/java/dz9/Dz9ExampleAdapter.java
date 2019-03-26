package dz9;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import test.com.homework.R;

public class Dz9ExampleAdapter extends RecyclerView.Adapter<Dz9ExampleAdapter.ExampleViewHolder> {
    private ArrayList<Dz9ExampleItem> exampleList;
    private ArrayList<Dz9ExampleItem> exampleListFull;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);

        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView firstName;
        public TextView secondName;
        public ImageView deleteImage;

        public ExampleViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            deleteImage = itemView.findViewById(R.id.deleteImage);
            firstName = itemView.findViewById(R.id.firstName);
            secondName = itemView.findViewById(R.id.secondName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });

            deleteImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });

        }
    }

    public Dz9ExampleAdapter(ArrayList<Dz9ExampleItem> exampleList) {
        this.exampleList = exampleList;
        exampleListFull = new ArrayList<>(exampleList);
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dz6_item, viewGroup, false);
        ExampleViewHolder evh = new ExampleViewHolder(v, listener);
        return evh;

    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        Dz9ExampleItem currentItem = exampleList.get(position);
        holder.imageView.setImageResource(currentItem.getImageResource());
        holder.firstName.setText(currentItem.getFirstName());
        holder.secondName.setText(currentItem.getSecondName());
    }

    @Override
    public int getItemCount() {
        return exampleList.size();
    }

    public void filterList(ArrayList<Dz9ExampleItem> filteredList) {
        exampleList = filteredList;
        notifyDataSetChanged();
    }

}
