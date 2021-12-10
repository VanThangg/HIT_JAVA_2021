package Bai3;

import java.util.ArrayList;
import java.util.Scanner;

public class RunMain {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<News> list = new ArrayList<>();
    public static void main(String[] args) {

        int choose;
        do {
            System.out.println("----------MENU----------");
            System.out.println("1. Insert news");
            System.out.println("2. View list news");
            System.out.println("3. Average rate");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    InsertNews();
                    break;
                case 2:
                    ViewListNews();
                    break;
                case 3:
                    AverageRate();
                    break;
                case 4:
                    System.out.println("Exit program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please re-enter!");
            }
        }while(choose != 4);
    }
    public static void InsertNews() {
        News news = new News();
        news.Input();
        list.add(news);
    }

    public static void ViewListNews() {
        System.out.printf("%15s %15s %20s %20s", "Title", "Publish date", "Author", "Content\n");
        list.forEach((ele) -> {
            ele.Display();
            System.out.println();
        });
    }

    public static void AverageRate() {
        System.out.printf("%15s %15s %20s %20s %15s", "Title", "Public date", "Author", "Content", "Average rate\n");
        list.forEach((ele) -> {
            ele.Display();
            System.out.printf("%15s", ele.getAverageRate());
            System.out.println();
        });
    }
}
