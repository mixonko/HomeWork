package dz6;

import java.util.ArrayList;

import test.com.homework.R;

public class ExampleItem {
    private int imageResource;
    private String firstName;
    private String secondName;

    public ExampleItem(String firstName, String secondName, int imageResource){
        this.firstName = firstName;
        this.secondName = secondName;
        this.imageResource = imageResource;
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


    public static ArrayList<ExampleItem> getList(){
        ArrayList<ExampleItem> list = new ArrayList<>();
        list.add(new ExampleItem("Игорь", "Блажевич", R.drawable.student12));
        list.add(new ExampleItem("Виктория", "Волошина", R.drawable.student11));
        list.add(new ExampleItem("Валерий", "Кузнецов", R.drawable.student10));
        list.add(new ExampleItem("Никита", "Носиков", R.drawable.student9));
        list.add(new ExampleItem("Иван", "Сафонов", R.drawable.student8));
        list.add(new ExampleItem("Надежда", "Синько", R.drawable.student7));
        list.add(new ExampleItem("Павел", "Хомякова", R.drawable.student6));
        list.add(new ExampleItem("Илья", "Шергин", R.drawable.student5));
        list.add(new ExampleItem("Николай", "Мареев", R.drawable.student4));
        list.add(new ExampleItem("Артём", "Юдаков", R.drawable.student3));
        list.add(new ExampleItem("Георгий", "Щекалев", R.drawable.student2));
        list.add(new ExampleItem("Сергей", "Калашников", R.drawable.student1));
        list.add(new ExampleItem("Игорь", "Блажевич", R.drawable.student12));
        list.add(new ExampleItem("Виктория", "Волошина", R.drawable.student11));
        list.add(new ExampleItem("Валерий", "Кузнецов", R.drawable.student10));
        list.add(new ExampleItem("Никита", "Носиков", R.drawable.student9));
        list.add(new ExampleItem("Иван", "Сафонов", R.drawable.student8));
        list.add(new ExampleItem("Надежда", "Синько", R.drawable.student7));
        list.add(new ExampleItem("Павел", "Хомякова", R.drawable.student6));
        list.add(new ExampleItem("Илья", "Шергин", R.drawable.student5));
        list.add(new ExampleItem("Николай", "Мареев", R.drawable.student4));
        list.add(new ExampleItem("Артём", "Юдаков", R.drawable.student3));
        list.add(new ExampleItem("Георгий", "Щекалев", R.drawable.student2));
        list.add(new ExampleItem("Сергей", "Калашников", R.drawable.student1));
        list.add(new ExampleItem("Игорь", "Блажевич", R.drawable.student12));
        list.add(new ExampleItem("Виктория", "Волошина", R.drawable.student11));
        list.add(new ExampleItem("Валерий", "Кузнецов", R.drawable.student10));
        list.add(new ExampleItem("Никита", "Носиков", R.drawable.student9));
        list.add(new ExampleItem("Иван", "Сафонов", R.drawable.student8));
        list.add(new ExampleItem("Надежда", "Синько", R.drawable.student7));
        list.add(new ExampleItem("Павел", "Хомякова", R.drawable.student6));
        list.add(new ExampleItem("Илья", "Шергин", R.drawable.student5));
        list.add(new ExampleItem("Николай", "Мареев", R.drawable.student4));
        list.add(new ExampleItem("Артём", "Юдаков", R.drawable.student3));
        list.add(new ExampleItem("Георгий", "Щекалев", R.drawable.student2));
        list.add(new ExampleItem("Сергей", "Калашников", R.drawable.student1));
        return list;
    }

}
