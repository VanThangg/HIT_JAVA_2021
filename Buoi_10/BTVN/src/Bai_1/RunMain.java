package Bai_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class RunMain{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Person> persons = new ArrayList<>();
        int n = 0;
        try {
            do {
                System.out.print("Nhập số người: ");
                n = sc.nextInt();
            }while(n <= 0);
        } catch(Exception ex) {
            System.out.println("Nhập sai kiểu dữ liệu của n");
        }

        for(int i = 0; i < n; i++) {
            Person person = new Person();
            System.out.println("Nhập thông tin người " + (i+1));
            person.Nhap();
            persons.add(person);
        }

        //Sắp xếp danh sách theo chiều tăng dần của id và xuất ra màn hình
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getId() - o2.getId();
            }
        });

        //Sắp xếp theo name theo thứ tự trong bảng chữ cái,
        // nếu tên trùng nhau thì sẽ sắp xếp theo address
        // giảm dần trong bảng chữ cái và xuất ra màn hình
        Collections.sort(persons);

        System.out.println("Danh sách sau khi sắp xếp.");
        System.out.printf("%10s %30s %30s", "Id", "Name", "Address\n");
        for (Person person: persons) {
            person.Xuat();
        }
    }
}
