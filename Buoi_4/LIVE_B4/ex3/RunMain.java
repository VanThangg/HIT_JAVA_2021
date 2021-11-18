package ex3;


import ex2.Address;

import java.util.Arrays;
import java.util.Scanner;

public class RunMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //ctrl + P
        int n=3;
        Person[] people = new Person[n];
        int[]    a      = new int[n];

        for(int i=0; i<n; i++) {
            people[i] = new Person(); //
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            people[i].setName(name);
            System.out.print("Enter age: ");
            int age = sc.nextInt();
            people[i].setAge(age);
            sc.nextLine(); //\n
//            System.out.println();
//            fflush(stdin);
//            cin.ignore();
        }

        System.out.println(Arrays.toString(people));


    }

}
