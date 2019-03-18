package dz6;

import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import test.com.homework.R;

class RecyclerViewHolder extends RecyclerView.ViewHolder {
    private TextView firstName, secondName;
    private ImageView imageView;

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        firstName = (TextView) itemView.findViewById(R.id.firstName);
        secondName = (TextView) itemView.findViewById(R.id.secondName);
        imageView = (ImageView) itemView.findViewById(R.id.image);
    }

    public void bind(StudentsList studentsList) {
        imageView.setImageBitmap(BitmapFactory.decodeResource(itemView.getResources(), studentsList.getIdImg()));
        firstName.setText(studentsList.getFirstName());
        secondName.setText(studentsList.getSecondName());
    }
}
