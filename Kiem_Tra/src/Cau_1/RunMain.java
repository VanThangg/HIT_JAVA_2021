package Cau_1;

import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = new String();
        str = sc.nextLine();
        int dem = 0, tong = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                dem++;
//                tong+=Integer.parseInt(String.valueOf(str.charAt(i)));
                tong += Character.getNumericValue(str.charAt(i));
            }
        }
        int tich = 1;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                int so = Integer.parseInt(String.valueOf(str.charAt(i)));
                if(tong % so == 0) {
                    tich *= so;
                }
            }
        }

        System.out.println("Co " + dem +  " ky tu so.");
        if(dem != 0) {
            System.out.println("Tich: " + tich);
        }
        else {
            System.out.println("Tich: 0");
        }

    }
}
