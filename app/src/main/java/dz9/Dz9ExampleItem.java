package dz9;

import java.util.ArrayList;

import test.com.homework.R;

public class Dz9ExampleItem {
    private int imageResource;
    private String firstName;
    private String secondName;
    private int defaultImage = R.drawable.student11;

    public Dz9ExampleItem(String firstName, String secondName, int imageResource) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.imageResource = imageResource;
    }

    public Dz9ExampleItem(String firstName, String secondName) {
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

    public static ArrayList<Dz9ExampleItem> getList() {
        ArrayList<Dz9ExampleItem> list = new ArrayList<>();
        list.add(new Dz9ExampleItem("Игорь", "Блажевич", R.drawable.student12));
        list.add(new Dz9ExampleItem("Виктория", "Волошина", R.drawable.student11));
        list.add(new Dz9ExampleItem("Валерий", "Кузнецов", R.drawable.student10));
        list.add(new Dz9ExampleItem("Никита", "Носиков", R.drawable.student9));
        list.add(new Dz9ExampleItem("Иван", "Сафонов", R.drawable.student8));
        list.add(new Dz9ExampleItem("Надежда", "Синько", R.drawable.student7));
        list.add(new Dz9ExampleItem("Павел", "Хомякова", R.drawable.student6));
        list.add(new Dz9ExampleItem("Илья", "Шергин", R.drawable.student5));
        list.add(new Dz9ExampleItem("Николай", "Мареев", R.drawable.student4));
        list.add(new Dz9ExampleItem("Артём", "Юдаков", R.drawable.student3));
        list.add(new Dz9ExampleItem("Георгий", "Щекалев", R.drawable.student2));
        list.add(new Dz9ExampleItem("Сергей", "Калашников", R.drawable.student1));
        list.add(new Dz9ExampleItem("Игорь", "Блажевич", R.drawable.student12));
        list.add(new Dz9ExampleItem("Виктория", "Волошина", R.drawable.student11));
        list.add(new Dz9ExampleItem("Валерий", "Кузнецов", R.drawable.student10));
        list.add(new Dz9ExampleItem("Никита", "Носиков", R.drawable.student9));
        list.add(new Dz9ExampleItem("Иван", "Сафонов", R.drawable.student8));
        list.add(new Dz9ExampleItem("Надежда", "Синько", R.drawable.student7));
        list.add(new Dz9ExampleItem("Павел", "Хомякова", R.drawable.student6));
        list.add(new Dz9ExampleItem("Илья", "Шергин", R.drawable.student5));
        list.add(new Dz9ExampleItem("Николай", "Мареев", R.drawable.student4));
        list.add(new Dz9ExampleItem("Артём", "Юдаков", R.drawable.student3));
        list.add(new Dz9ExampleItem("Георгий", "Щекалев", R.drawable.student2));
        list.add(new Dz9ExampleItem("Сергей", "Калашников", R.drawable.student1));
        list.add(new Dz9ExampleItem("Игорь", "Блажевич", R.drawable.student12));
        list.add(new Dz9ExampleItem("Виктория", "Волошина", R.drawable.student11));
        list.add(new Dz9ExampleItem("Валерий", "Кузнецов", R.drawable.student10));
        list.add(new Dz9ExampleItem("Никита", "Носиков", R.drawable.student9));
        list.add(new Dz9ExampleItem("Иван", "Сафонов", R.drawable.student8));
        list.add(new Dz9ExampleItem("Надежда", "Синько", R.drawable.student7));
        list.add(new Dz9ExampleItem("Павел", "Хомякова", R.drawable.student6));
        list.add(new Dz9ExampleItem("Илья", "Шергин", R.drawable.student5));
        list.add(new Dz9ExampleItem("Николай", "Мареев", R.drawable.student4));
        list.add(new Dz9ExampleItem("Артём", "Юдаков", R.drawable.student3));
        list.add(new Dz9ExampleItem("Георгий", "Щекалев", R.drawable.student2));
        list.add(new Dz9ExampleItem("Сергей", "Калашников", R.drawable.student1));

        return list;
    }

}

