package Cau_2;

public class Book extends Document {
    private int numberOfPage;
    private String author;

//    public void Nhap() {
//        super.Nhap();
//        System.out.print("Number of page: ");
//        numberOfPage = sc.nextInt();
//        sc.nextLine();
//        System.out.print("Author: ");
//        author = sc.nextLine();
//    }
    public void Xuat() {
        super.Xuat();
        System.out.printf("%20s %20s", numberOfPage, author);
    }

    public Book() {
    }

    public Book(int numberOfPage, String author) {
        this.numberOfPage = numberOfPage;
        this.author = author;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
