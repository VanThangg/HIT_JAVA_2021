
package Bai_3;
import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tong = 0, dem = 0;
        
        System.out.print("Nhập chuỗi bất kì: ");
        String str = sc.nextLine();
        for(int i = 0; i < str.length(); i++) {
            char vt = str.charAt(i);
            if(vt >= '0' && vt <= '9') {
                tong += Character.getNumericValue(vt);
                dem++;
            }
        }
        if(dem != 0) {
            System.out.println("true");
            System.out.println((float)tong/dem);
        }
        else {
            System.out.println("false");
        }
    }
}
