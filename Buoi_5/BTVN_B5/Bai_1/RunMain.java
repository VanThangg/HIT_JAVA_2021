package Bai_1;

import java.util.ArrayList;
import java.util.Scanner;

public class RunMain  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("So dieu hoa: ");
        n = sc.nextInt();
        ArrayList<DieuHoa> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            DieuHoa dh = new DieuHoa();
            System.out.println("Thong tin dieu hoa " + (i+1));
            dh.Nhap();
            list.add(dh);
        }
        int dem = 0;
        System.out.println("Danh sach cac dieu hoa co hang san xuat Electrolux:");
        for(int i = 0; i < n; i++) {
            if(list.get(i).getTenHSX().compareTo("Electrolux") == 0) {
                list.get(i).Xuat();
                dem++;
            }
        }
        if(dem==0) {
            System.out.println("Khong co.");
        }
        double min = list.get(0).getGiaBan();
        for(int i = 0; i < n; i++) {
            if(list.get(i).getGiaBan() < min) {
                min = list.get(i).getGiaBan();
            }
        }
        System.out.println("Danh sach cac dieu hoa co gia ban thap nhat:");
        for (int i = 0; i < n; i++) {
            if(list.get(i).getGiaBan() == min) {
                list.get(i).Xuat();
            }
        }
    }
}
