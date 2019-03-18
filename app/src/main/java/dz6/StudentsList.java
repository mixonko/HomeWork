package dz6;

import java.util.ArrayList;
import java.util.List;

import test.com.homework.R;

class StudentsList {
    private String firstName, secondName;
    private int idImg;

    public StudentsList(String firstName, String srcondName, int id){
        this.firstName = firstName;
        this.secondName = srcondName;
        this.idImg = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getIdImg() {
        return idImg;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setIdImg(int idImg) {
        this.idImg = idImg;
    }


    public static List<StudentsList> StudentsList() {
        ArrayList<StudentsList> list = new ArrayList<>();
        list.add(new StudentsList("Игорь", "Блажевич", R.drawable.student12));
        list.add(new StudentsList("Виктория", "Волошина", R.drawable.student11));
        list.add(new StudentsList("Валерий", "Кузнецов", R.drawable.student10));
        list.add(new StudentsList("Никита", "Носиков", R.drawable.student9));
        list.add(new StudentsList("Иван", "Сафонов", R.drawable.student8));
        list.add(new StudentsList("Надежда", "Синько", R.drawable.student7));
        list.add(new StudentsList("Павел", "Хомякова", R.drawable.student6));
        list.add(new StudentsList("Илья", "Шергин", R.drawable.student5));
        list.add(new StudentsList("Николай", "Мареев", R.drawable.student4));
        list.add(new StudentsList("Артём", "Юдаков", R.drawable.student3));
        list.add(new StudentsList("Георгий", "Щекалев", R.drawable.student2));
        list.add(new StudentsList("Сергей", "Калашников", R.drawable.student1));
        return list;
    }


}
