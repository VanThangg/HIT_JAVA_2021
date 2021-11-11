package Bai_3;

public class RunMain {
    public static void main(String[] args) {
        LOPHOC a = new LOPHOC();
        a.Nhap();
        a.Xuat();

        System.out.println("So sinh vien khoa 15: " + a.SV_K15());

        a.sx();
        System.out.println("Lop hoc sau khi sap xep.");
        a.Xuat();
    }
}
