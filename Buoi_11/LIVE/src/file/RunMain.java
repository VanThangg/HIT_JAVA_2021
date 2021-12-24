package file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) throws IOException {
        /*
            - Ghi File:
                FileWriter;
                BufferedWriter;
                PrintWriter;
            - Đọc File:
                Scanner;
        */

        User user = new User("huannd9999", "Huannd010101*");

        List<User> users = new ArrayList<>();
        users.add(new User("huannd9991", "Huannd010101*"));
        users.add(new User("huannd9992", "Huannd010102*"));
        users.add(new User("huannd9993", "Huannd010103*"));

//        FileWriter fileWriter = new FileWriter("Account.txt", true); //Mở file
//        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); //Tạo 1 lớp đọc ghi file đc an toàn
//        PrintWriter printWriter = new PrintWriter(bufferedWriter); //Đối tượng ghi dữ liệu
//
////        printWriter.println(user.getUsername() + "|" + user.getPassword());
//        for(User u : users) {
//            printWriter.println(u.getUsername() + "|" + u.getPassword());
//        }
//
//        printWriter.close();
//        bufferedWriter.close();
//        fileWriter.close();

//        Scanner scanner = new Scanner(Paths.get("C:/Users/Nguyen Dinh Huan/OneDrive/Desktop/Account.txt"));
        Scanner scanner = new Scanner(Paths.get("Account.txt"));
        List<User> userList = new ArrayList<>();
        while(scanner.hasNext()) {
            String s = scanner.nextLine();
            String[] a = s.split("\\|");
            userList.add(new User(a[0], a[1]));
        }

        System.out.println(userList.get(1));
    }
}