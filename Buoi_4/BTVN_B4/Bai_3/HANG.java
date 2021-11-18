package Bai_3;

import java.util.Scanner;

public class HANG {
    private String maHang;
    private String tenHang;
    private double donGia;

    public void NHAP() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ma hang: ");
        maHang = sc.nextLine();
        System.out.print("Ten hang: ");
        tenHang = sc.nextLine();
        System.out.print("Don gia: ");
        donGia = sc.nextDouble();
    }

    public void XUAT() {
        System.out.println("Ma hang: " + maHang);
        System.out.println("Ten hang: " + tenHang);
        System.out.println("Don gia: " + donGia);
    }

    public double getDonGia() {
        return donGia;
    }
}
