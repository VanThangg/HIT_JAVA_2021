package Bai_4;

import java.util.Scanner;

public class QUANLY {
    private String maQL;
    private String hoTen;

    public void NHAP() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ma quan ly: ");
        maQL = sc.nextLine();
        System.out.print("Ho ten: ");
        hoTen = sc.nextLine();
    }

    public void XUAT() {
        System.out.println("Ma quan ly: " + maQL);
        System.out.println("Ho ten: " + hoTen);
    }
}
