package Bai_3;

import java.util.Scanner;

public class SINHVIEN extends NGUOI {
    private String maSV;
    private String nganh;
    private int khoaHoc;

    public SINHVIEN() {
    }

    public SINHVIEN(String hoTen, String ngaySinh, String queQuan, String maSV, String nganh, int khoaHoc) {
        super(hoTen, ngaySinh, queQuan);
        this.maSV = maSV;
        this.nganh = nganh;
        this.khoaHoc = khoaHoc;
    }

    // Viết hàm Nhap(), Xuat() ở class RunMain sẽ đúng yêu cầu đề bài
    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        super.Nhap();
        System.out.print("Ma sinh vien: ");
        maSV = sc.nextLine();
        System.out.print("Nganh: ");
        nganh = sc.nextLine();
        System.out.print("Khoa hoc: ");
        khoaHoc = sc.nextInt();
    }
    public void Xuat() {
        super.Xuat();
        System.out.printf("%15s %15s %5s", maSV, nganh, khoaHoc);
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    public int getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(int khoaHoc) {
        this.khoaHoc = khoaHoc;
    }
}
