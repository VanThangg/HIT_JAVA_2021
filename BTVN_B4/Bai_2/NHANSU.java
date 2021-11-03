package Bai_2;

import java.util.Scanner;

public class NHANSU {
    private String maNS;
    private String hoTen;
    DATE NS;

    public void NHAP() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ma nhan su: ");
        maNS = sc.nextLine();
        System.out.print("Ho ten: ");
        hoTen = sc.nextLine();
        NS = new DATE();
        NS.NHAP();
    }

    public void XUAT() {
        System.out.println("Ma nhan su: " + maNS);
        System.out.println("Ho ten: " + hoTen);
        NS.XUAT();
    }
}
