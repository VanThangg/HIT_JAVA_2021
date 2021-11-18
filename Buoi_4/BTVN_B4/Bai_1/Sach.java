package Bai_1;

import java.util.Scanner;

public class Sach {
    private String maSach;
    private String tenSach;
    private String nhaXuatBan;
    private int soTrang;
    private double giaTien;

    public void NHAP() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ma sach: ");
        maSach = sc.nextLine();
        System.out.print("Ten sach: ");
        tenSach = sc.nextLine();
        System.out.print("Nha xuat ban: ");
        nhaXuatBan = sc.nextLine();
        System.out.print("So trang: ");
        soTrang = sc.nextInt();
        System.out.print("Gia tien: ");
        giaTien = sc.nextDouble();
    }

    public void XUAT() {
        System.out.println("Ma sach: " + maSach);
        System.out.println("Ten sach: " + tenSach);
        System.out.println("Nha xuat ban: " + nhaXuatBan);
        System.out.println("So trang: " + soTrang);
        System.out.println("Gia tien: " + giaTien);
    }
}