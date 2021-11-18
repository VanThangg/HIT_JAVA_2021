package Bai_4;

import java.util.Scanner;

public class MAY {
    private String maMay;
    private String kieuMay;
    private String tinhTrang;

    public void NHAP() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ma may: ");
        maMay = sc.nextLine();
        System.out.print("Kieu may: ");
        kieuMay = sc.nextLine();
        System.out.print("Tinh trang: ");
        tinhTrang = sc.nextLine();
    }
    public void XUAT() {
        System.out.println("Ma may: " + maMay);
        System.out.println("Kieu may: " + kieuMay);
        System.out.println("Tinh trang: " + tinhTrang);
    }
}
