
package Bai_2;

import java.util.Scanner;

public class Array {
    Scanner sc = new Scanner(System.in);

    private int[] a;
    private int n;
    
    public Array() {
        n = 0;
        a = null;
    }
    public Array(int[] a, int n) {
        this.n = n;
        for(int i = 0; i < n; i++) {
            this.a[i] = a[i];
        }
    }
    
    public void InputData() {
        System.out.print("Nhap so phan tu mang: ");
        n = sc.nextInt();
        a = new int[n];
        for(int i = 0; i < n; i++) {
            System.out.print("a[" + i + "]: ");
            a[i] = sc.nextInt();
        }
    }
    public void Show() {
        for(int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
    public int Sum() {
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += a[i];
        }
        return sum;
    }
    public void Filter(boolean flag) {
        if(flag) {
            System.out.print("Cac so chan la: ");
            for(int i = 0; i < n; i++) {
                if(a[i] % 2 == 0) {
                    System.out.print(a[i] + " ");
                }
            }
        }
        else {
            System.out.print("Cac so le la: ");
            for(int i = 0; i < n; i++) {
                if(a[i] % 2 != 0) {
                    System.out.print(a[i] + " ");
                }
            }
        }
    }


    public void setA(int[] a) {
        this.a = a;
    }
    public int[] getA() {
        return a;
    }

    public void setN(int n) {
        this.n = n;
    }
    public int getN() {
        return n;
    }
    
}
