
package Bai_4;
import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi cần chuẩn hóa: ");
        String str = sc.nextLine();
        
        // Xóa khoảng trắng thừa 2 đầu
        str = str.trim();
        System.out.println("1. Xoá khoảng trắng thừa ở 2 đầu: " + str);
        
        // Giữa các từ chỉ có 1 khoảng trắng
        str = str.replaceAll("( )+", " ");
        System.out.println("2. Giữa các từ chỉ có 1 khoảng trắng: " + str);
        
        // Xóa các ký tự số
        str = str.replaceAll("[0-9]", ""); 
        System.out.println("3. Xóa các ký tự số: " + str);
        
        // Viết hoa đầu mỗi từ
        String str2 = "";
        str2 += Character.toUpperCase(str.charAt(0));
        
        for(int i = 1; i < str.length(); i++) {
            if(Character.isWhitespace(str.charAt(i)) == true){
                str2 += " ";
                str2 += Character.toUpperCase(str.charAt(i+1));
                i++;
            }
            else {
                str2 += str.charAt(i);
            }
        }
        System.out.println("4. Viết hoa đầu mỗi từ: " + str2);
    }
}
