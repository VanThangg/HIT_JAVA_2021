package Bai_3;

import java.util.Scanner;

public class NGUOI {
    protected String hoTen;
    protected String ngaySinh;
    protected String queQuan;

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ho ten: ");
        hoTen = sc.nextLine();
        System.out.print("Ngay sinh: ");
        ngaySinh = sc.nextLine();
        System.out.print("Que quan: ");
        queQuan = sc.nextLine();
    }
    public void Xuat() {
        System.out.printf("%20s %12s %20s", hoTen, ngaySinh, queQuan);
    }

    public NGUOI() {
    }

    public NGUOI(String hoTen, String ngaySinh, String queQuan) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
    }
}
