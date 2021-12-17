package compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RunMain {
    public static void main(String[] args) {
        //Comparable, comparator
        List<Student> listStudents = new ArrayList<Student>();
        // add students to list
        listStudents.add(new Student(4, "Quy"));
        listStudents.add(new Student(1, "Vinh"));
        listStudents.add(new Student(3, "Phu"));
        listStudents.add(new Student(2, "Hoa"));
        // sort list student
//        Collections.sort(listStudents);
        Collections.sort(listStudents, new Comparator<Student>() {
            @Override
            public int compare(Student truoc, Student sau) {
//               return truoc.getId() - sau.getId();
                return sau.getId() - truoc.getId();
            }
        });
        // show list students
//        for (Student student : listStudents) {
//            System.out.println(student.toString());
//        }



        IStudent showLower = new IStudent() {
            @Override
            public void show(String name) {
                System.out.println(name.toLowerCase());
            }
        };

        IStudent showUpper = new IStudent() {
            @Override
            public void show(String name) {
                System.out.println(name.toUpperCase());
            }
        };

        showLower.show("Nguyễn Đình Huân");
        showUpper.show("Nguyễn Đình Huân");

    }
}