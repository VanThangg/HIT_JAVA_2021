
package Bai_1;
import java.util.Scanner;

public class RunMain {
    public static int maximum(int a, int b, int c){
        int max = a;
        max = (max > b) ? max : b;
        max = (max > c) ? max : c;
        return max;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap a: ");
        int a = sc.nextInt();
        System.out.print("Nhap b: ");
        int b = sc.nextInt();
        System.out.print("Nhap c: ");
        int c = sc.nextInt();
        
        System.out.println("Số lớn nhất trong ba số trên là: " + maximum(a, b, c));

    }

}
