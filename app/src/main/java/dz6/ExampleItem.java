package dz6;

import java.util.ArrayList;

import test.com.homework.R;

public class ExampleItem {
    private int imageResource;
    private String firstName;
    private String secondName;
    private int defaultImage = R.drawable.student11;

    public ExampleItem(String firstName, String secondName, int imageResource){
        this.firstName = firstName;
        this.secondName = secondName;
        this.imageResource = imageResource;
    }

    public ExampleItem(String firstName, String secondName ){
        this.firstName = firstName;
        this.secondName = secondName;
        this.imageResource = defaultImage;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public static ArrayList<ExampleItem> getList(){
        ArrayList<ExampleItem> list = new ArrayList<>();
        list.add(new ExampleItem("Игорь", "Блажевич", R.drawable.student12));

        return list;
    }

}
