package Cau_2;

import java.util.Scanner;

public class Document {
    protected int id;
    protected String name;
    protected String publisher;
    protected double price;

    Scanner sc = new Scanner(System.in);

    public void Nhap() {
        System.out.print("Id: ");
        id = sc.nextInt();
        sc.nextLine();
        System.out.print("Name: ");
        name = sc.nextLine();
        System.out.print("Publisher: ");
        publisher = sc.nextLine();
        System.out.print("Price: ");
        price = sc.nextDouble();
    }
    public void Xuat() {
        System.out.printf("%10s %20s %20s %10s", id, name, publisher, price);
    }

    public Document() {
    }

    public Document(int id, String name, String publisher, double price, Scanner sc) {
        this.id = id;
        this.name = name;
        this.publisher = publisher;
        this.price = price;
        this.sc = sc;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }


}
