
package Bai_2;
import java.util.Scanner;

public class RunMain {
    public static int n;
    public static Scanner sc = new Scanner(System.in);
    public static int[] a = new int[1000];

    // Nhập mảng với n số nguyên
    public static void nhap_Mang(){
        System.out.print("Nhap n: ");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Nhap a[" + i + "] = ");
            a[i] = sc.nextInt();
        }
    }

    // Hiển thị mảng vừa tạo
    public static void xuat_Mang() {
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]+ " ");
        }
        System.out.println();
    }

    // Thêm 1 phần tử vào vị trí k bất kỳ
    public static void them() {
        System.out.print("Nhập phần tử cần thêm: ");
        int gt = sc.nextInt();
        System.out.print("Nhập vị trí cần thêm: ");
        int k = sc.nextInt();

        if(k>=0 && k<=n){
            for(int i = n; i > k; i--){
                a[i] = a[i-1];
            }
            a[k] = gt;
            n++;
            System.out.print("Mảng sau khi thêm: ");
            xuat_Mang();
        }
        else {
            System.out.println("Vị trí không hợp lệ");
        }
    }

    // Xóa 1 phần tử tại vị trí k bất kỳ
    public static void xoa() {
        System.out.print("Nhập vị trí cần xóa: ");
        int k = sc.nextInt();

        if(k>=0 && k<=n) {
            for(int i = k; i < n; i++) {
                a[i] = a[i+1];
            }
            n--;
            System.out.print("Mảng sau khi xóa: ");
            xuat_Mang();
        }
        else {
            System.out.println("Vị trí không hợp lệ");
        }
    }

    // Đảo ngược mảng
    public static void dao() {
        for(int i = 0; i < n/2; i++){
            int temp = a[i];
            a[i] = a[n-i-1];
            a[n-i-1] = temp;
        }
    }

    // Hiển thị phần tử a[1] và các số chia hết cho a[1]
    public static void chia_het() {
        System.out.println("a[1] = " + a[1]);
        System.out.print("Các số chia hết cho a[1] la: ");
        for(int i = 0; i < n; i++) {
            if(a[i] % a[1] == 0){
                System.out.print(a[i] + " ");
            }
        }
        System.out.println();
    }

    // Kiểm tra số nguyên tố
    public static boolean ngTo(int a){
        for(int i=2; i*i<=a; i++){
            if (a % i == 0) {
                return false;
            }
        }
        return n>1;
    }

    // Tổng các số nguyên tố trong mảng
    public static int tong() {
        int tong=0;
        for(int i = 0; i < n; i++) {
            if(ngTo(a[i])) {
                tong += a[i];
            }
        }
        return tong;
    }

    public static void main(String[] args) {
        int chon;
        do {
            System.out.println("--------------- MENU ---------------");
            System.out.println("1. Nhập mảng.");
            System.out.println("2. Hiển thị mảng.");
            System.out.println("3. Thêm 1 phần tử vào vị trí bất kỳ.");
            System.out.println("4. Xóa 1 phần tử tại vị trí bất kỳ.");
            System.out.println("5. Đảo ngược mảng.");
            System.out.println("6. Hiển thị phần tử a[1] và các số chia hết cho a[1].");
            System.out.println("7. Tổng các số nguyên tố có trong mảng.");
            System.out.println("8. Thoát.");

            System.out.print("Mời bạn chọn: ");
            chon = sc.nextInt();

            switch(chon){
                case 1:
                    System.out.println("Nhập mảng.");
                    nhap_Mang();
                    break;
                case 2:
                    System.out.print("Mảng vừa tạo: ");
                    xuat_Mang();
                    break;
                case 3:
                    System.out.println("Thêm phần tử.");
                    them();

                    break;
                case 4:
                    System.out.println("Xóa phần tử.");
                    xoa();

                    break;
                case 5:
                    System.out.println("Đảo ngược mảng.");
                    dao();
                    System.out.print("Mảng sau khi đảo ngược: ");
                    xuat_Mang();
                    break;
                case 6:
                    chia_het();
                    break;
                case 7:
                    System.out.print("Tổng các số nguyên tố là: " + tong() + "\n");
                    break;
                case 8:
                    System.out.println("Thoát chương trình.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Mời bạn nhập lại!");
            }
        }while(chon != 8);
    }
}
