package Bai_4;

import java.util.Scanner;

public class PHONGMAY {
    private String maPhong;
    private String tenPhong;
    private double dienTich;
    private QUANLY x;
    private MAY[] y;
    private int n;

    public void NHAP() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ma phong: ");
        maPhong = sc.nextLine();
        System.out.print("Ten phong: ");
        tenPhong = sc.nextLine();
        System.out.print("Dien tich: ");
        dienTich = sc.nextDouble();
        x = new QUANLY();
        x.NHAP();
        System.out.print("So luong may: ");
        n = sc.nextInt();
        y = new MAY[n];
        for(int i = 0; i < n; i++) {
            y[i] = new MAY();
            System.out.println("Nhap thong tin may " + (i+1));
            y[i].NHAP();
        }
    }
    public void XUAT() {
        System.out.println("Ma phong: " + maPhong);
        System.out.println("Ten phong: " + tenPhong);
        System.out.println("Dien tich: " + dienTich);
        x.XUAT();
        for(int i = 0; i < n; i++) {
            System.out.println("Thong tin may " + (i+1));
            y[i].XUAT();
        }
    }
}
