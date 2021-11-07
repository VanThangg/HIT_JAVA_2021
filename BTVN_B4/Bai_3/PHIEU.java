package Bai_3;

import java.util.Scanner;

public class PHIEU {
    private String maPhieu;
    private HANG[] x;
    private int n;

    public void NHAP() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma phieu: ");
        maPhieu = sc.nextLine();

        System.out.print("So mat hang trong phieu: ");
        n = sc.nextInt();
        x = new HANG[n];
        for(int i = 0; i < n; i++) {
            x[i] = new HANG();
            System.out.println("Nhap thong tin mat hang " + (i+1));
            x[i].NHAP();
        }
    }
    public void XUAT() {
        System.out.println("Ma phieu: " + maPhieu);
        double tong = 0;
        for(int i = 0; i < n; i++) {
            System.out.println("Thong tin mat hang " + (i+1));
            x[i].XUAT();
            tong += x[i].getDonGia();
        }
        System.out.println("Tong tien cua phieu la: " + tong);
    }
}
