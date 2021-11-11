package Bai_2;

import java.util.Scanner;

public class DateTime {
    private int ngay;
    private int thang;
    private int nam;

    public void InputDate() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ngay: ");
        ngay = sc.nextInt();
        System.out.print("Thang: ");
        thang = sc.nextInt();
        System.out.print("Nam: ");
        nam = sc.nextInt();
    }
    public void OutputDate() {
        System.out.println("Ngay: " + ngay + "/" + thang + "/" + nam);
    }
}
