package Bai_1;

import java.util.Scanner;

public class SanPham {
    protected String maSP;
    protected String tenSP;
    protected String tenHSX;
    protected String ngayNhap;

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma san pham: ");
        maSP = sc.nextLine();
        System.out.print("Nhap ten san pham: ");
        tenSP = sc.nextLine();
        System.out.print("Nhap ten hang san xuat: ");
        tenHSX = sc.nextLine();
        System.out.print("Nhap ngay nhap: ");
        ngayNhap = sc.nextLine();
    }
    public void Xuat() {
        System.out.println("Ma san pham: " + maSP);
        System.out.println("Ten san pham: " + tenSP);
        System.out.println("Ten hang san xuat: " + tenHSX);
        System.out.println("Ngay nhap: " + ngayNhap);
    }

    public void setTenHSX(String tenHSX) {
        this.tenHSX = tenHSX;
    }

    public String getTenHSX() {
        return tenHSX;
    }
}
