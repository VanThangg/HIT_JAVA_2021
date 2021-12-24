package Bai_1;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class RunMain {
    static Scanner sc = new Scanner(System.in);

    static String regUserName = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[A-Za-z0-9]{6,}$";
    static String regPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=])[A-Za-z0-9@#$%^&+=]{8,}$";
    static String regEmail = "[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}";
    static String regPhone = "^[0-9\\-\\+]{9,15}$";

    static List<Account> accs = new ArrayList<>();
    static FileController fileController = new FileController();

    public static void main(String[] args) {
        int chon;
        do {
            System.out.println("-------------MENU-------------");
            System.out.println("1. Create new account.");
            System.out.println("2. Login to an existing account.");
            System.out.println("3. Sort accounts by username.");
            System.out.println("4. Exit");
            System.out.print("Nhap lua chon: ");
            chon = sc.nextInt();

            switch (chon) {
                case 1:
                    CreateAccount();
                    break;
                case 2:
                    Login();
                    break;
                case 3:
                    SortByUserName();
                    break;
                case 4:
                    System.out.println("Thoat chuong trinh.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        } while (chon != 4);
    }

    public static void CreateAccount(){
        Account acc = new Account();
        long id;
        String userName, password, email, phone;
        while (true) {
            System.out.print("Id: ");
            id = sc.nextLong();
            if(CheckId(id)) {
                System.out.println("Id da ton tai. Vui long nhap lai.");
            }
            else {
                acc.setId(id);
                break;
            }
        }

        System.out.print("Fullname: ");
        sc.nextLine();
        acc.setFullName(sc.nextLine());

        Pattern p1 = Pattern.compile(regUserName);
        while (true) {
            System.out.print("Username: ");
            userName = sc.nextLine();
            if(CheckUsername(userName)) {
                System.out.println("Username da ton tai. Vui long nhap lai.");
            }
            else {
                if(p1.matcher(userName).find()) {
                    acc.setUserName(userName);
                    break;
                }
                else {
                    System.out.println("Username phai chua cac ky tu thuong, hoa, so, it nhat co 6 ky tu.");
                    System.out.println("Vui long nhap lai.");
                }
            }
        }
        Pattern p2 = Pattern.compile(regPassword);
        while (true) {
            System.out.print("Password: ");
            password = sc.nextLine();
            if(p2.matcher(password).find()) {
                while (true) {
                    System.out.print("Nhap lai mat khau: ");
                    String rePassword;
                    rePassword = sc.nextLine();
                    if(password.compareTo(rePassword) == 0){
                        break;
                    }
                    else {
                        System.out.println("Mat khau khong khop. Vui long nhap lai.");
                    }
                }
                acc.setPassword(password);
                break;
            }
            else {
                System.out.println("Mat khau phai chua cac ky tu thuong, hoa, so, ky tu dac biet, it nhat co 8 ky tu.");
                System.out.println("Vui long nhap lai.");
            }
        }

        Pattern p3 = Pattern.compile(regEmail);
        while (true) {
            System.out.print("Email: ");
            email = sc.nextLine();
            if(p3.matcher(email).find()) {
                acc.setEmail(email);
                break;
            }
            else {
                System.out.println("Email khong hop le. Vui long nhap lai");
            }
        }
        Pattern p4 = Pattern.compile(regPhone);
        while (true) {
            System.out.print("So dien thoai: ");
            phone = sc.nextLine();
            if(p4.matcher(phone).find()) {
                acc.setPhone(phone);
                break;
            }
            else {
                System.out.println("So dien thoai khong hop le. Vui long nhap lai");
            }
        }
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        acc.setCreatAt(formatter.format(date));

        accs.add(acc);
        fileController.WriteAccountToFile("Account.DAT", acc);
    }

    public static void Login() {
        accs = fileController.ReadAccountFromFile("Account.DAT");
        String userName, password;
        sc.nextLine();
        System.out.print("Username: ");
        userName = sc.nextLine();
        System.out.print("Password: ");
        password = sc.nextLine();

        if(CheckAccount(userName, password)) {
            System.out.println("Dang nhap thanh cong.");
            Account acc = new Account();
            for(int i = 0; i < accs.size(); i++) {
                if(accs.get(i).getUserName().compareTo(userName) == 0) {
                    acc = accs.get(i);
                }
            }
            int chon;
            do {
                System.out.println("---------MENU---------");
                System.out.println("1. Show info.");
                System.out.println("2. Change password.");
                System.out.println("3. End");
                System.out.println("Nhap lua chon: ");
                chon = sc.nextInt();
                switch(chon) {
                    case 1:
                        System.out.println("Thong tin tai khoan.");
                        acc.Xuat1();
                        break;
                    case 2:
                        sc.nextLine();
                        ChangePassword(userName, password, acc);
                        System.out.println("Doi mat khau thanh cong");
                        break;
                    case 3:
                        System.out.println("Thoat chuong trinh.");
                        System.exit(0);
                        return;
                    default:
                        System.out.println("Lua chon khong hop le!\n");
                }
            }while(chon != 3);
        }
        else {
            System.out.println("Tai khoan khong ton tai.");
        }
    }

    public static void SortByUserName() {
        accs = fileController.ReadAccountFromFile("Account.DAT");
        Collections.sort(accs);
        System.out.printf("%5s %30s %20s %20s %15s %25s", "Id", "Fullname", "Username", "Email", "Phone", "Create at");
        System.out.println();
        for(int i = 0; i < accs.size(); i++) {
            accs.get(i).Xuat();
        }
    }

    public static boolean CheckId(long id){
        accs = fileController.ReadAccountFromFile("Account.DAT");
        for(int i = 0; i < accs.size(); i++) {
            if(id == accs.get(i).getId()) {
                return true;
            }
        }
        return false;
    }

    public static boolean CheckUsername(String userName) {
        accs = fileController.ReadAccountFromFile("Account.DAT");
        for (int i = 0; i < accs.size(); i++) {
            if (accs.get(i).getUserName().compareTo(userName) == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean CheckAccount(String userName, String password) {
        accs = fileController.ReadAccountFromFile("Account.DAT");
        for (int i = 0; i < accs.size(); i++) {
            if (accs.get(i).getUserName().compareTo(userName) == 0 && accs.get(i).getPassword().compareTo(password) == 0) {
                return true;
            }
        }
        return false;
    }
    public static void ChangePassword(String userName, String oldPassword, Account acc) {
        String reOldPassword, newPassword, reNewPassword;
        while (true) {
            System.out.print("Nhap mat khau cu: ");
            reOldPassword = sc.nextLine();
            if(reOldPassword.compareTo(oldPassword) == 0) {
                break;
            }
            else {
                System.out.println("Mat khau khong dung. Vui long nhap lai");
            }
        }
        Pattern p2 = Pattern.compile(regPassword);
        while (true) {
            System.out.print("Nhap mat khau moi: ");
            newPassword = sc.nextLine();
            if(p2.matcher(newPassword).find()) {
                while (true) {
                    System.out.print("Nhap lai mat khau moi: ");
                    reNewPassword = sc.nextLine();
                    if(newPassword.compareTo(reNewPassword) == 0){
                        break;
                    }
                    else {
                        System.out.println("Mat khau khong khop. Vui long nhap lai.");
                    }
                }
                acc.setPassword(newPassword);
                break;
            }
            else {
                System.out.println("Mat khau phai chua cac ky tu thuong, hoa, so, ky tu dac biet, it nhat co 8 ky tu.");
                System.out.println("Vui long nhap lai.");
            }
        }
        for (int i = 0; i < accs.size(); i++) {
            if(accs.get(i).getUserName().compareTo(userName) == 0) {
                accs.set(i, acc);
                break;
            }
        }
        fileController.UpdateAccountFile(accs, "Account.DAT");
    }
}
