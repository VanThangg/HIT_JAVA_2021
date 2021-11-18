package ArrayList;

import Generic.Student;

import java.util.ArrayList;
import java.util.Collections;

public class RunMain {
    public static void main(String[] args) {

        //
        ArrayList<Integer> integerArrayList = new ArrayList<>();

        integerArrayList.add(2); //add vào cuối danh sách
        integerArrayList.add(2);
        integerArrayList.add(2);
        integerArrayList.add(2);

//        integerArrayList.add(1, 3);

//        integerArrayList.remove(0);
//        integerArrayList.clear();

//        System.out.println(integerArrayList.indexOf(2));
//        System.out.println(integerArrayList.lastIndexOf(2));
//        integerArrayList.set(0, 10);
//
//        System.out.println(integerArrayList);

////        System.out.println(integerArrayList.get(1));
//        for(int i=0; i<integerArrayList.size(); i++){
//            System.out.println(integerArrayList.get(i));
//        }

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("Huân"));
        students.add(new Student("Dương"));
        students.add(new Student("Hùng"));

//        Collections.swap(students, 0, 1);
//        Student temp = students.get(0);
//        students.set(0, students.get(1));
//        students.set(1, temp);
//        students.get(0) = students.get(1);
//        students.get(1) = temp;

//        students.remove(new Student("Huân"));
//        System.out.println(students);
//
//        System.out.println(students.isEmpty());

        ArrayList<Student> students1 = (ArrayList<Student>) students.clone();
        System.out.println(students1);

        Collections.rotate(students1.subList(0, 1+2), 2);
        System.out.println(students1);
    }



}
