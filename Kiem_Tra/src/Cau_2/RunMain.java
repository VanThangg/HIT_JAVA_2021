package Cau_2;

import java.util.ArrayList;
import java.util.Scanner;

public class RunMain {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Book> books = new ArrayList<>();

    public static void addBook() {
        Book book = new Book();
        book.Nhap();
        books.add(book);
    }
    public static void editBook() {
        int x, dem = 0;
        System.out.print("Id cua book can chinh sua: ");
        x = sc.nextInt();
        for(int i = 0; i < books.size(); i++) {
            if(x == books.get(i).getId()) {
                Book bEdit = new Book();
                bEdit.Nhap();
                books.remove(i);
                books.add(i, bEdit);
                dem++;
            }
        }
        if (dem == 0) {
            System.out.println("==> Not found, please re-enter id.");
            editBook();
        }
    }
    public static void deleteBook() {
        int x, dem = 0;
        System.out.print("Id cua book can xoa: ");
        x = sc.nextInt();
        for(int i = 0; i < books.size(); i++) {
            if(x == books.get(i).getId()) {
                books.remove(i);
                dem++;
            }
        }
        if (dem == 0) {
            System.out.println("==> Not found, please re-enter id.");
            deleteBook();
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
                    System.out.println("==> Added.");
                    break;
                case 2:
                    System.out.println("You choose edit book by id.");
                    editBook();
                    System.out.println("==> Edited");
                    break;
                case 3:
                    System.out.println("You choose delete book by id.");
                    deleteBook();
                    System.out.println("==> Deleted");
                    break;
                case 4:
                    System.out.println("You choose sort books by name.");
                    sortName();
                    System.out.println("==> Sorted");
                    break;
                case 5:
                    System.out.println("You choose sort books by price.");
                    sortPrice();
                    System.out.println("==> Sorted");
                    break;
                case 6:
                    System.out.println("You choose show all books.");
                    show();
                    break;
                case 7:
                    System.out.println("Thoát chương trình.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Mời bạn nhập lại!");
            }

        }while (chon != 7);
    }


}