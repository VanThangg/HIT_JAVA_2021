package Bai3;

import java.util.Scanner;

public class News implements INews{
    private int id;
    private String title;
    private String publishDate;
    private String author;
    private String content;
    private float averageRate;
    private int[] rateList = new int[3];


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getAverageRate() {
        return averageRate;
    }

    @Override
    public void Display() {
        averageRate = Calculate();
        System.out.printf("%15s %15s %20s %20s", getTitle(), getPublishDate(), getAuthor(), getContent());
    }
    public void Input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Title: ");
        title = sc.nextLine();
        System.out.print("Publish date: ");
        publishDate = sc.nextLine();
        System.out.print("Author: ");
        author = sc.nextLine();
        System.out.print("Content: ");
        content = sc.nextLine();
        System.out.println("Rate list");
        for(int i = 0; i < 3; i++) {
            System.out.print("Rate " + (i+1) + ": ");
            rateList[i] = sc.nextInt();
        }
    }
    public float Calculate() {
        float s = 0;
        for(int i = 0; i < 3; i++) {
            s+=rateList[i];
        }
        return s/3;
    }
}
