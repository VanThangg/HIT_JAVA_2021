/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package live_b2;

import java.util.Scanner;

/**
 *
 * @author Thang02
 */
public class RunMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//      int[] arr = new int[3];
//      int[] arr = {1, 2, 3};
//      int[][] b = new int [5][6];
//        int[][] c = {
//            {1, 2, 3},
//            {2, 3, 4}
//        };
        
//        int a = sc.nextInt();
//        System.out.println("Nhap a = ");
//        System.out.println("Nhap s = ");
//        sc.nextLine();
//        System.out.println("a = " + a);
//        System.out.println("s = " + s);
//        
//        float b = sc.nextFloat();
//        String s = sc.nextLine();
//        double c = sc.nextDouble();
//        long c = sc.nextLong();

          
//        System.out.println("Nhap n = ");
//        int n = sc.nextInt();
//        int[] a = new int[n];
//          
//        for(int i=0; i<n; i++){
//            System.out.print("Nhap a[" + i + "] = ");
//            a[i] = sc.nextInt();
//        }
//          
//        for(int i=0; i<n-1; i++){
//            for(int j=i+1; j<n; j++){
//                if(a[i] > a[j]) {
//                    int temp = a[i];
//                    a[i] = a[j];
//                    a[j] = temp;
//                }
//            }
//        }
//        for(int i=0; i<n; i++){
//            System.out.print(a[i] + " ");
//        }
        
//        Student student = new Student();
//        student.ShowInfo();
//        System.out.println("Nhap n = ");
//        int n = sc.nextInt();
//        if(isPrime(n) == true){
//            System.out.println(n+ " la so nguyen to");
//        }
//        else{
//            System.out.println(n+ " khong la so nguyen to");
//        }
//          
//        System.out.println(sum(1, 3));
        final int MY_IP = 5;
        System.out.println(MY_IP);
        
    }
    public static boolean isPrime(int a){
        if(a < 2) 
            return false;
        for(int i=2; i*i<=a; i++){
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static int sum(int a, int b){
        return a+b;
    }
    
}
