package Bai_1;

import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so cuon sach: ");
        int n = sc.nextInt();
        Sach[] sach = new Sach[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Thong tin cuon sach " + (i+1));
            sach[i] = new Sach();
            sach[i].NHAP();
        }

        System.out.println("------------------------------------");

        for (int i = 0; i < n; i++) {
            System.out.println("Thong tin cuon sach " + (i+1));
            sach[i].XUAT();
        }
    }
}
