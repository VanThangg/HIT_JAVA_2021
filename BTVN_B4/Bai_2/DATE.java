package Bai_2;

import java.util.Scanner;

public class DATE {
    private int d;
    private int m;
    private int y;

    public void NHAP() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ngay: ");
        d = sc.nextInt();
        System.out.print("Thang: ");
        m = sc.nextInt();
        System.out.print("Nam: ");
        y = sc.nextInt();
    }

    public void XUAT() {
        System.out.println("Ngay sinh: " + d + "/"+ m + "/"+ y);
    }
}
