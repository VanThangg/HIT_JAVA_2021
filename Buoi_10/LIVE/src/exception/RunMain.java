package exception;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RunMain {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        Person[] people = new Person[5];
//        people[5] = new Person();

//        people[8].name = "123";


//        System.out.println("Nhap a = ");
//        int a = 0;

//        show();


        try {
//            System.out.printf("%L", a);
//            Integer integer = new Integer("mothaiba");
//            a = sc.nextInt();
            String s = "123";
//            System.out.println(s.charAt(2));
            if(s.contains("1")) {
                throw new Exception("Chuỗi này có chứa số 1");
            }
            System.out.println("Huân");
            System.out.println("Huân");
            System.out.println("Huân");
        } catch (Exception ex) {
//            System.out.println("Nhập dữ liệu sai");
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Dù có sai đi chăng nữa, java vẫn là nhất");
        }

//        System.out.println("a = " + a);
    }

    static void show() throws IOException, IndexOutOfBoundsException {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    }
}
