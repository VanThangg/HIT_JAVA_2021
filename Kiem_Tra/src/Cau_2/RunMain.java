package Cau_2;

import java.util.ArrayList;
import java.util.Scanner;

public class RunMain {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Book> books = new ArrayList<>();

    public static void addBook() {
        Book book = new Book();
        int dem = 0;
        while(dem==0) {
            dem = 1;
            System.out.print("Id: ");
            int x = sc.nextInt();
            sc.nextLine();
            for(int i = 0; i < books.size(); i++) {
                if(x == books.get(i).getId()){
                    dem=0;
                }
            }
            if(dem==0) {
                System.out.println("Id already exists, please re-enter!");
            }
            else {
                book.setId(x);
            }
        }
        System.out.print("Name: ");
        book.setName(sc.nextLine());
        System.out.print("Publisher: ");
        book.setPublisher(sc.nextLine());
        System.out.print("Price: ");
        book.setPrice(sc.nextDouble());
        System.out.print("Number of page: ");
        book.setNumberOfPage(sc.nextInt());
        sc.nextLine();
        System.out.print("Author: ");
        book.setAuthor(sc.nextLine());
        books.add(book);
        System.out.println("==> Added.");
    }
    public static void editBook() {
        int x, d = 0;
        System.out.print("Id cua book can chinh sua: ");
        x = sc.nextInt();
        for(int i = 0; i < books.size(); i++) {
            if(x == books.get(i).getId()) {
                d++;
            }
        }
        if (d == 0) {
            System.out.println("==> Id does not exist!");
        }
        else {
            for(int i = 0; i < books.size(); i++) {
                if(x == books.get(i).getId()) {
                    System.out.println("1. Id \n" + "2. name \n" + "3. publisher \n" + "4. price \n" + "5. numberOfPages\n" + "6. author");
                    System.out.print("Enter your choose: ");
                    int edit = sc.nextInt();
                    switch (edit) {
                        case 1:
                            int dem = 0;
                            while(dem==0) {
                                dem = 1;
                                System.out.print("Enter id: ");
                                int id = sc.nextInt();
                                sc.nextLine();
                                for(int j = 0; j < books.size(); j++) {
                                    if(id == books.get(j).getId()){
                                        dem=0;
                                        break;
                                    }
                                }
                                if(dem==0) {
                                    System.out.println("Id already exists, please re-enter");
                                }
                                else {
                                    books.get(i).setId(id);
                                }
                            }
                            break;
                        case 2:
                            System.out.print("Enter name: ");
                            sc.nextLine();
                            books.get(i).setName(sc.nextLine());
                            break;
                        case 3:
                            System.out.print("Enter publisher: ");
                            sc.nextLine();
                            books.get(i).setPublisher(sc.nextLine());
                            break;
                        case 4:
                            System.out.print("Enter price: ");
                            sc.nextLine();
                            books.get(i).setPrice(sc.nextFloat());
                            break;
                        case 5:
                            System.out.print("Enter number of page: ");
                            sc.nextLine();
                            books.get(i).setNumberOfPage(sc.nextInt());
                            break;
                        case 6:
                            System.out.print("Enter author: ");
                            sc.nextLine();
                            books.get(i).setAuthor(sc.nextLine());
                            break;
                    }
                }
            }
            System.out.println("==> Edited");
        }
    }
    public static void deleteBook() {
        int x;
        boolean ok = false;
        System.out.print("Id cua book can xoa: ");
        x = sc.nextInt();
        for(int i = 0; i < books.size(); i++) {
            if(x == books.get(i).getId()) {
                books.remove(i);
                ok = true;
            }
        }
        if (!ok) {
            System.out.println("==> Id does not exist!");
        }
        else {
            System.out.println("==> Deleted");
        }
    }
    public static void sortName() {
        for(int i = 0; i < books.size()-1; i++) {
            for(int j = i+1; j < books.size(); j++) {
                if(books.get(i).getName().compareTo(books.get(j).getName()) > 0) {
                    Book temp = books.get(i);
                    books.set(i, books.get(j));
                    books.set(j, temp);
                }
            }
        }
        System.out.println("==> Sorted");
    }
    public static void sortPrice() {
        for(int i = 0; i < books.size()-1; i++) {
            for(int j = i+1; j < books.size(); j++) {
                if(books.get(i).getPrice() < books.get(j).getPrice()) {
                    Book temp = books.get(i);
                    books.set(i, books.get(j));
                    books.set(j, temp);
                }
            }
        }
        System.out.println("==> Sorted");
    }
    public static void show() {
        System.out.printf("%10s %20s %20s %10s %20s %20s", "Id", "Name", "Publisher", "Price", "Nummber Of Page", "Author");
        System.out.println();
        for(int i = 0; i < books.size(); i++) {
            books.get(i).Xuat();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int chon;
        do {
            System.out.println("============MENU============");
            System.out.println("1. Add book.");
            System.out.println("2. Edit book by id.");
            System.out.println("3. Delete book by id.");
            System.out.println("4. Sort books by name.");
            System.out.println("5. Sort books by price.");
            System.out.println("6. Show all books.");
            System.out.println("7. Exit.");
            System.out.print("Moi ban chon: ");
            chon = sc.nextInt();

            switch (chon) {
                case 1:
                    System.out.println("You choose add book.");
                    addBook();
                    break;
                case 2:
                    System.out.println("You choose edit book by id.");
                    editBook();
                    break;
                case 3:
                    System.out.println("You choose delete book by id.");
                    deleteBook();
                    break;
                case 4:
                    System.out.println("You choose sort books by name.");
                    sortName();
                    break;
                case 5:
                    System.out.println("You choose sort books by price.");
                    sortPrice();
                    break;
                case 6:
                    System.out.println("You choose show all books.");
                    show();
                    break;
                case 7:
                    System.out.println("Exit the program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please re-enter!");
            }

        }while (chon != 7);
    }
}