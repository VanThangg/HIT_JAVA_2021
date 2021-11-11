package Bai_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LOPHOC {
    private String maLH;
    private String tenLH;
    private String ngayMo;
    private int n;
    private String giaoVien;
    ArrayList<SINHVIEN> x = new ArrayList<>(n);

    public LOPHOC() {
    }

    public LOPHOC(String maLH, String tenLH, String ngayMo, int n, ArrayList<SINHVIEN> x, String giaoVien) {
        this.maLH = maLH;
        this.tenLH = tenLH;
        this.ngayMo = ngayMo;
        this.n = n;
        this.x = x;
        this.giaoVien = giaoVien;
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ma lop hoc: ");
        maLH = sc.nextLine();
        System.out.print("Ten lop hoc: ");
        tenLH = sc.nextLine();
        System.out.print("Ngay mo: ");
        ngayMo = sc.nextLine();
        System.out.print("Giao vien: ");
        giaoVien = sc.nextLine();

        System.out.print("So sinh vien: ");
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            SINHVIEN sv = new SINHVIEN();
            System.out.println("Nhap thong tin sinh vien " + (i+1));
            sv.Nhap();
            x.add(sv);
        }

    }

    public void Xuat() {
        System.out.println("Ma lop hoc: " + maLH);
        System.out.println("Ten lop hoc: " + tenLH);
        System.out.println("Ngay mo: " + ngayMo);

        System.out.printf("%20s %12s %20s %15s %15s %5s", "Ho ten", "Ngay sinh", "Que quan", "Ma sinh vien", "Nganh", "Khoa hoc");
        System.out.println();

        for(int i = 0; i < n; i++) {
            x.get(i).Xuat();
            System.out.println();
        }
        System.out.println("Giao vien: " + giaoVien);

    }

    public int SV_K15() {
        int dem = 0;
        for(int i = 0; i < n; i++) {
            if (x.get(i).getKhoaHoc() == 15) {
                dem++;
            }
        }
        return dem;
    }

    public void sx() {
        for(int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if(x.get(i).getKhoaHoc() > x.get(j).getKhoaHoc()) {
                    Collections.swap(x, i, j);
                }
            }
        }
    }

    public String getMaLH() {
        return maLH;
    }

    public void setMaLH(String maLH) {
        this.maLH = maLH;
    }

    public String getTenLH() {
        return tenLH;
    }

    public void setTenLH(String tenLH) {
        this.tenLH = tenLH;
    }

    public String getNgayMo() {
        return ngayMo;
    }

    public void setNgayMo(String ngayMo) {
        this.ngayMo = ngayMo;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public ArrayList<SINHVIEN> getX() {
        return x;
    }

    public void setX(ArrayList<SINHVIEN> x) {
        this.x = x;
    }

    public String getGiaoVien() {
        return giaoVien;
    }

    public void setGiaoVien(String giaoVien) {
        this.giaoVien = giaoVien;
    }

}
