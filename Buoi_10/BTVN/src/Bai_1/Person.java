package Bai_1;

import java.util.Scanner;

public class Person implements Comparable<Person> {
    private int id;
    private String name;
    private String address;

    public Person() {
    }

    public Person(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Id: ");
            id = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            name = sc.nextLine();
            System.out.print("Address: ");
            address = sc.nextLine();
        } catch(Exception ex) {
            System.out.println("Nhập sai kiểu dữ liệu");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void Xuat() {
        System.out.printf("%10s %30s %30s", getId(), getName(), getAddress());
        System.out.println();
    }

    @Override
    public int compareTo(Person o) {
        if(getName().compareTo(o.getName()) == 0) {
            return getAddress().compareTo(o.getAddress());
        }
        return getName().compareTo(o.getName());
    }
}
