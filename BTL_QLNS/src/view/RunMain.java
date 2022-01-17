package view;

import controller.FileController;
import model.Account;
import model.Employee;

import java.text.Normalizer;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class RunMain {
    public static Scanner sc = new Scanner(System.in);
    static String regUserName = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[A-Za-z0-9]{6,}$";
    static String regPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=])[A-Za-z0-9@#$%^&+=]{8,}$";
    static String regEmail = "[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}";
    static String regPhone = "^0[0-9]{9}$";

    static List<Account> accounts = new ArrayList<>();
    static List<Employee> dataUsers = new ArrayList<>();
    static List<Employee> feedbackPublic = new ArrayList<>();
    static List<Employee> feedbackPrivate = new ArrayList<>();
    static List<Employee> reasons = new ArrayList<>();

    static FileController fileController = new FileController();
    static String securityCode = "CongTy##2022";
    static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static void main(String[] args) {
        int choose;
        do {
            System.out.println("------------MENU-------------");
            System.out.println("|\t\t1. Log in.  \t\t|");
            System.out.println("|\t\t2. Register.\t\t|");
            System.out.println("|\t\t3. Back.    \t\t|");
            System.out.println("-----------------------------");

            System.out.print("Your choose: ");
            choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                    LogIn();
                    break;
                case 2:
                    Register();
                    break;
                case 3:
                    System.out.println("Exit program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid selection.");
            }
        }while(true);
    }
    public static void Register() {
        dataUsers = fileController.ReadEmployeeFromFile("dataUsers.DAT");
        Account acc = new Account();
        Employee employee = new Employee();
        String userName, password, email, phoneNumber;
        int salaryGrape = 1;
        int hour = 0;

        if(dataUsers.size() == 0) {
            acc.setId(1);
            employee.setId(1);
        }
        else {
            acc.setId(dataUsers.get(dataUsers.size()-1).getId()+1);
            employee.setId(dataUsers.get(dataUsers.size()-1).getId()+1);
        }

        System.out.print("Full name: ");
        employee.setFullName(sc.nextLine());
        System.out.print("Date of birth: ");
        employee.setDate(sc.nextLine());

        Pattern p1 = Pattern.compile(regUserName);
        while (true) {
            System.out.print("Username: ");
            userName = sc.nextLine();
            if(CheckUsername(userName)) {
                System.out.println("Username: " + userName + " already exists. Please re-enter.");
            }
            else {
                if(p1.matcher(userName).find()) {
                    acc.setUserName(userName);
                    break;
                }
                else {
                    System.out.println("Invalid username. Please re-enter.");
                }
            }
        }

        Pattern p2 = Pattern.compile(regPassword);
        while (true) {
            System.out.print("Password: ");
            password = sc.nextLine();
            if(p2.matcher(password).find()) {
                while (true) {
                    System.out.print("Please re-enter your password: ");
                    String rePassword;
                    rePassword = sc.nextLine();
                    if(password.compareTo(rePassword) == 0){
                        break;
                    }
                    else {
                        System.out.println("Incorrect password. Please re-enter.");
                    }
                }
                acc.setPassword(password);
                break;
            }
            else {
                System.out.println("Invalid password. Please re-enter.");
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
                System.out.println("Invalid email. Please re-enter.");
            }
        }
        Pattern p4 = Pattern.compile(regPhone);
        while (true) {
            System.out.print("Phone number: ");
            phoneNumber = sc.nextLine();
            if(p4.matcher(phoneNumber).find()) {
                acc.setPhoneNumber(phoneNumber);
                break;
            }
            else {
                System.out.println("Invalid phone number. Please re-enter.");
            }
        }
        System.out.print("Department: ");
        employee.setDepartment(sc.nextLine());
        System.out.print("Address: ");
        employee.setAddress(sc.nextLine());
        System.out.print("Hometown: ");
        employee.setHometown(sc.nextLine());
        System.out.print("Nation: ");
        employee.setNation(sc.nextLine());
        employee.setSalaryGrape(salaryGrape);
        employee.setHour(hour);

        Date createAt = new Date();
        acc.setCreatAt(formatter.format(createAt));

        dataUsers.add(employee);
        fileController.WriteEmployeeToFile("dataUsers.DAT", employee);

        int chooseManager;
        System.out.println("Are you a manager?");
        System.out.println("1. Yes.");
        System.out.println("2. No.");
        System.out.println("3. Back.");
        System.out.print("Your choose: ");
        chooseManager = sc.nextInt();
        sc.nextLine();
        switch (chooseManager) {
            case 1:
                String isManager;
                System.out.print("Enter the security code: ");
                isManager = sc.nextLine();
                if(isManager.compareTo(securityCode) == 0) {
                    System.out.println("You are the manager.");
                    acc.setPosition("Manager");
                    accounts.add(acc);
                    fileController.WriteAccountToFile("Account.DAT", acc);
                    System.out.println("Successfully registered as a manager.");
                }
                else {
                    System.out.println("You are not the manager.");
                    acc.setPosition("Employee");
                    accounts.add(acc);
                    fileController.WriteAccountToFile("Account.DAT", acc);
                    System.out.println("Successfully registered as an employee.");
                }
                break;
            case 2:
                acc.setPosition("Employee");
                accounts.add(acc);
                fileController.WriteAccountToFile("Account.DAT", acc);
                System.out.println("Successfully registered as an employee.");
                break;
            case 3:
                break;
        }
    }
    public static void LogIn(){
        dataUsers = fileController.ReadEmployeeFromFile("dataUsers.DAT");
        accounts = fileController.ReadAccountFromFile("Account.DAT");
        String userName, password;
        System.out.print("Username: ");
        userName = sc.nextLine();
        System.out.print("Password: ");
        password = sc.nextLine();
        CheckAccount(userName, password);
        if(CheckAccount(userName, password) == 1) {
            System.out.println("Successfully logged in as manager.");
            Employee employee = new Employee();
            Account account = new Account();
            for (Account acc: accounts) {
                if(acc.getUserName().compareTo(userName) == 0) {
                    account = acc;
                    for(Employee emp : dataUsers) {
                        if(acc.getId() == emp.getId()) {
                            employee = emp;
                        }
                    }
                }
            }
            int choose;
            do {
                System.out.println("----------------MENU----------------");
                System.out.println("| 1. Show Info All Employee.       |");
                System.out.println("| 2. Show Employees By Department. |");
                System.out.println("| 3. Show My Profile.              |");
                System.out.println("| 4. Change Info My Account.       |");
                System.out.println("| 5. Create Account For Employee.  |");
                System.out.println("| 6. Edit Info Of All Employee.    |");
                System.out.println("| 7. Timekeeping.                  |");
                System.out.println("| 8. Find Employee.                |");
                System.out.println("| 9. Delete Employee.              |");
                System.out.println("| 10. Sort Employee.               |");
                System.out.println("| 11. View Message.                |");
                System.out.println("| 12. View Feedback.               |");
                System.out.println("| 13. Summary.                     |");
                System.out.println("| 14. Log out.                     |");
                System.out.println("------------------------------------");
                System.out.print("Your Choose: ");
                choose = sc.nextInt();
                sc.nextLine();
                switch(choose) {
                    case 1:
                        ShowInfoAllEmployee();
                        break;
                    case 2:
                        ShowEmployeesInYourDepartment(employee.getDepartment());
                        break;
                    case 3:
                        System.out.println("\tMy profile.");
                        employee.OutputEmployee1();
                        break;
                    case 4:
                        ChangeInfoMyAccount(userName, password, account);
                        break;
                    case 5:
                        CreateAccountForEmployee(account.getId());
                        break;
                    case 6:
                        EditInfoOfAllEmployee(employee.getDepartment());
                        break;
                    case 7:
                        Timekeeping(employee.getId(), employee);
                        break;
                    case 8:
                        FindEmployee(employee.getDepartment());
                        break;
                    case 9:
                        DeleteEmployee(employee.getDepartment());
                        break;
                    case 10:
                        SortEmployee(employee.getDepartment());
                        break;
                    case 11:
                        ViewMessage(employee.getId());
                        break;
                    case 12:
                        ViewFeedback(employee.getDepartment());
                        break;
                    case 13:
                        Summary(employee.getDepartment());
                        break;
                    case 14:
                        break;
                    default:
                        System.out.println("Invalid selection.");
                }
            }while(choose != 14);
        }
        else if(CheckAccount(userName, password) == 2) {
            System.out.println("Successfully logged in as employee.");
            Employee employee = new Employee();
            Account account = new Account();
            for (Account acc: accounts) {
                if(acc.getUserName().compareTo(userName) == 0) {
                    account = acc;
                    for(Employee emp : dataUsers) {
                        if(acc.getId() == emp.getId()) {
                            employee = emp;
                        }
                    }
                }
            }
            int choose;
            do {
                System.out.println("----------------MENU----------------");
                System.out.println("| 1. Show Info All Employee.       |");
                System.out.println("| 2. Show Employees By Department. |");
                System.out.println("| 3. Show My Profile.              |");
                System.out.println("| 4. Change Info My Account.       |");
                System.out.println("| 5. Timekeeping.                  |");
                System.out.println("| 6. Find Employee.                |");
                System.out.println("| 7. Sort Employee.                |");
                System.out.println("| 8. Take A Day Off.               |");
                System.out.println("| 9. Write feedback.               |");
                System.out.println("| 10. Log out.                     |");
                System.out.println("------------------------------------");
                System.out.print("Your Choose: ");
                choose = sc.nextInt();
                sc.nextLine();
                switch(choose) {
                    case 1:
                        ShowInfoAllEmployee();
                        break;
                    case 2:
                        ShowEmployeesInYourDepartment(employee.getDepartment());
                        break;
                    case 3:
                        System.out.println("\tMy profile.");
                        employee.OutputEmployee1();
                        break;
                    case 4:
                        ChangeInfoMyAccount(userName, password, account);
                        break;
                    case 5:
                        Timekeeping(employee.getId(), employee);
                        break;
                    case 6:
                        FindEmployee(employee.getDepartment());
                        break;
                    case 7:
                        SortEmployee(employee.getDepartment());
                        break;
                    case 8:
                        TakeADayOff(employee.getId());
                        break;
                    case 9:
                        WriteFeedback(employee.getId());
                        break;
                    case 10:
                        break;
                    default:
                        System.out.println("Invalid selection.");
                }
            }while(choose != 10);
        }
        else {
            System.out.println("Account does not exist.");
        }
    }
    public static String removeAccent(String s) {
        try {
            String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
            return pattern.matcher(temp).replaceAll("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public static boolean CheckUsername(String userName) {
        accounts = fileController.ReadAccountFromFile("Account.DAT");
        for(Account acc : accounts) {
            if (acc.getUserName().compareTo(userName) == 0) {
                return true;
            }
        }
        return false;
    }
    public static int CheckAccount(String userName, String password) {
        accounts = fileController.ReadAccountFromFile("Account.DAT");
        for (Account acc : accounts) {
            if (acc.getUserName().compareTo(userName) == 0 && acc.getPassword().compareTo(password) == 0) {
                if (acc.getPosition().compareTo("Manager") == 0) {
                    return 1;
                }
                else if(acc.getPosition().compareTo("Employee") == 0) {
                    return 2;
                }
            }
        }
        return 3;
    }
    public static void ShowInfoAllEmployee() {
        dataUsers = fileController.ReadEmployeeFromFile("dataUsers.DAT");
        for(int i = 1; i <= 181; i++) {
            System.out.print("-");
        }
        System.out.print("\n| ");
        System.out.print("\tAll employee.");
        System.out.printf("%165s", "|\n");
        System.out.printf("| %-9s %-25s %-15s %-25s %-25s %-24s %-25s %-15s %-6s |", "Id", "Full name", "Date", "Address", "Hometown", "Nation", "Department", "Salary Grape", "Hour");
        System.out.println();
        for (Employee emp : dataUsers) {
            emp.OutputEmployee();
            System.out.println();
        }
        for(int i = 1; i <= 181; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
    public static void ShowEmployeesInYourDepartment(String department) {
        dataUsers = fileController.ReadEmployeeFromFile("dataUsers.DAT");
        accounts = fileController.ReadAccountFromFile("Account.DAT");
        System.out.println("Department: " + department);
        System.out.println("\tManager.");
        for(Account acc : accounts) {
            if(acc.getPosition().compareTo("Manager") == 0) {
                for(Employee emp : dataUsers) {
                    if(acc.getId() == emp.getId() && emp.getDepartment().compareTo(department) == 0) {
                        emp.OutputEmployeeTree();
                    }
                }
            }
        }
        for(int i = 1; i <= 181; i++) {
            System.out.print("-");
        }
        System.out.print("\n| ");
        System.out.print("\tEmployee.");
        System.out.printf("%169s", "|\n");
        System.out.printf("| %-9s %-25s %-15s %-25s %-25s %-24s %-25s %-15s %-6s |", "Id", "Full name", "Date", "Address", "Hometown", "Nation", "Department", "Salary Grape", "Hour");
        System.out.println();
        for(Account acc : accounts) {
            if(acc.getPosition().compareTo("Employee") == 0) {
                for(Employee emp : dataUsers) {
                    if(acc.getId() == emp.getId() && emp.getDepartment().compareTo(department) == 0) {
                        emp.OutputEmployee();
                        System.out.println();
                    }
                }
            }
        }
        for(int i = 1; i <= 181; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
    public static void ChangeInfoMyAccount(String userName, String password, Account account) {
        dataUsers = fileController.ReadEmployeeFromFile("dataUsers.DAT");
        accounts = fileController.ReadAccountFromFile("Account.DAT");
        Employee employee = new Employee();
        for(Account acc : accounts) {
            if(acc.getUserName().compareTo(userName) == 0) {
                for(Employee emp : dataUsers) {
                    if(acc.getId() == emp.getId()) {
                        employee = emp;
                    }
                }
            }
        }
        int chooseChange;
        do {
            System.out.println("---------MENU CHANGE---------");
            System.out.println("| 1. Change password.       |");
            System.out.println("| 2. Change phone number.   |");
            System.out.println("| 3. Change email.          |");
            System.out.println("| 4. Change full name.      |");
            System.out.println("| 5. Change date of birth.  |");
            System.out.println("| 6. Change address.        |");
            System.out.println("| 7. Change hometown.       |");
            System.out.println("| 8. Change nation.         |");
            System.out.println("| 9. Change department.     |");
            System.out.println("| 10. Back.                 |");
            System.out.println("-----------------------------");
            System.out.print("Your choose: ");
            chooseChange = sc.nextInt();
            sc.nextLine();
            switch (chooseChange) {
                case 1:
                    ChangePassword(userName, password, account);
                    break;
                case 2:
                    ChangePhoneNumber(userName, password, account);
                    break;
                case 3:
                    ChangeEmail(userName, password, account);
                    break;
                case 4:
                    ChangeFullName(employee.getId(), employee);
                    break;
                case 5:
                    ChangeDate(employee.getId(), employee);
                    break;
                case 6:
                    ChangeAddress(employee.getId(), employee);
                    break;
                case 7:
                    ChangeHometown(employee.getId(), employee);
                    break;
                case 8:
                    ChangeNation(employee.getId(), employee);
                    break;
                case 9:
                    ChangeDepartment(employee.getId(), employee);
                    break;
                case 10:
                    break;
                default:
                    System.out.println("Invalid selection.");
            }
        }while (chooseChange != 10);
    }
    public static void EditInfoOfAllEmployee(String department) {
        dataUsers = fileController.ReadEmployeeFromFile("dataUsers.DAT");
        accounts = fileController.ReadAccountFromFile("Account.DAT");
        int d = 0;
        System.out.print("Id of employee need edit: ");
        long id = sc.nextLong();
        for(Employee emp : dataUsers) {
            if(emp.getId() == id && emp.getDepartment().compareTo(department) == 0) {
                int chooseChange;
                do {
                    System.out.println("--------MENU CHANGE--------");
                    System.out.println("| 1. Change full name.     |");
                    System.out.println("| 2. Change date.          |");
                    System.out.println("| 3. Change address.       |");
                    System.out.println("| 4. Change hometown.      |");
                    System.out.println("| 5. Change nation.        |");
                    System.out.println("| 6. Change department.    |");
                    System.out.println("| 7. Salary grape up.      |");
                    System.out.println("| 8. Back.                 |");
                    System.out.println("----------------------------");
                    System.out.print("Your choose: ");
                    chooseChange = sc.nextInt();
                    sc.nextLine();
                    switch (chooseChange) {
                        case 1:
                            ChangeFullName(emp.getId(), emp);
                            break;
                        case 2:
                            ChangeDate(emp.getId(), emp);
                            break;
                        case 3:
                            ChangeAddress(emp.getId(), emp);
                            break;
                        case 4:
                            ChangeHometown(emp.getId(), emp);
                            break;
                        case 5:
                            ChangeNation(emp.getId(), emp);
                            break;
                        case 6:
                            ChangeDepartment(emp.getId(), emp);
                            break;
                        case 7:
                            SalaryGrapeUp(emp.getId(), emp);
                            break;
                        case 8:
                            break;
                        default:
                            System.out.println("Invalid selection.");
                    }
                }while (chooseChange != 8);
                d++;
            }
        }
        if(d == 0) {
            System.out.println("Id: " + id + " does not exist in your department.");
        }
    }
    private static void UpdateFileAccountAfterChange(String userName, String oldPassword, Account account) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUserName().compareTo(userName) == 0 && accounts.get(i).getPassword().compareTo(oldPassword) == 0) {
                accounts.set(i, account);
                fileController.UpdateAccountFile(accounts, "Account.DAT");
                System.out.println("Successfully changed.");
                break;
            }
        }
    }
    public static void ChangePassword(String userName, String oldPassword, Account account) {
        accounts = fileController.ReadAccountFromFile("Account.DAT");
        String reOldPassword, newPassword, reNewPassword;
        while (true) {
            System.out.print("Enter old password: ");
            reOldPassword = sc.nextLine();
            if(reOldPassword.compareTo(oldPassword) == 0) {
                break;
            }
            else {
                System.out.println("Incorrect password. Please re-enter.");
            }
        }
        Pattern p2 = Pattern.compile(regPassword);
        while (true) {
            System.out.print("Enter new password: ");
            newPassword = sc.nextLine();
            if(p2.matcher(newPassword).find()) {
                while (true) {
                    System.out.print("Please re-enter new password: ");
                    reNewPassword = sc.nextLine();
                    if(newPassword.compareTo(reNewPassword) == 0){
                        break;
                    }
                    else {
                        System.out.println("Incorrect password. Please re-enter.");
                    }
                }
                account.setPassword(newPassword);
                break;
            }
            else {
                System.out.println("Invalid password. Please re-enter.");
            }
        }
        UpdateFileAccountAfterChange(userName, oldPassword, account);
    }
    public static void ChangePhoneNumber(String userName, String password, Account account) {
        accounts = fileController.ReadAccountFromFile("Account.DAT");
        String newPhoneNumber;

        Pattern p4 = Pattern.compile(regPhone);
        while (true) {
            System.out.print("New phone number: ");
            newPhoneNumber = sc.nextLine();
            if(p4.matcher(newPhoneNumber).find()) {
                account.setPhoneNumber(newPhoneNumber);
                break;
            }
            else {
                System.out.println("Invalid phone number. Please re-enter.");
            }
        }
        UpdateFileAccountAfterChange(userName, password, account);
    }
    public static void ChangeEmail(String userName, String password, Account account) {
        accounts = fileController.ReadAccountFromFile("Account.DAT");
        String newEmail;

        Pattern p3 = Pattern.compile(regEmail);
        while (true) {
            System.out.print("Email: ");
            newEmail = sc.nextLine();
            if(p3.matcher(newEmail).find()) {
                account.setEmail(newEmail);
                break;
            }
            else {
                System.out.println("Invalid email. Please re-enter.");
            }
        }
        UpdateFileAccountAfterChange(userName, password, account);
    }
    private static void UpdateFileEmployeeAfterChange(long id, Employee employee) {
        for (int i = 0; i < dataUsers.size(); i++) {
            if (dataUsers.get(i).getId() == id) {
                dataUsers.set(i, employee);
                fileController.UpdateEmployeeFile(dataUsers, "dataUsers.DAT");
                System.out.println("Successfully changed.");
                break;
            }
        }
    }
    public static void ChangeFullName(long id, Employee employee) {
        dataUsers = fileController.ReadEmployeeFromFile("dataUsers.DAT");
        String newFullName;
        System.out.print("New full name: ");
        newFullName = sc.nextLine();
        employee.setFullName(newFullName);
        UpdateFileEmployeeAfterChange(id, employee);
    }
    public static void ChangeDate(long id, Employee employee) {
        dataUsers = fileController.ReadEmployeeFromFile("dataUsers.DAT");
        String newDate;
        System.out.print("New date of birth: ");
        newDate = sc.nextLine();
        employee.setDate(newDate);
        UpdateFileEmployeeAfterChange(id, employee);
    }
    public static void ChangeAddress(long id, Employee employee) {
        dataUsers = fileController.ReadEmployeeFromFile("dataUsers.DAT");
        String newAddress;
        System.out.print("New address: ");
        newAddress = sc.nextLine();
        employee.setAddress(newAddress);
        UpdateFileEmployeeAfterChange(id, employee);
    }
    public static void ChangeHometown(long id, Employee employee) {
        dataUsers = fileController.ReadEmployeeFromFile("dataUsers.DAT");
        String newHometown;
        System.out.print("New hometown: ");
        newHometown = sc.nextLine();
        employee.setHometown(newHometown);
        UpdateFileEmployeeAfterChange(id, employee);
    }
    public static void ChangeNation(long id, Employee employee) {
        dataUsers = fileController.ReadEmployeeFromFile("dataUsers.DAT");
        String newNation;
        System.out.print("New nation: ");
        newNation = sc.nextLine();
        employee.setNation(newNation);
        UpdateFileEmployeeAfterChange(id, employee);
    }
    public static void ChangeDepartment(long id, Employee employee) {
        dataUsers = fileController.ReadEmployeeFromFile("dataUsers.DAT");
        String newDepartment;
        System.out.print("New department: ");
        newDepartment = sc.nextLine();
        employee.setDepartment(newDepartment);
        UpdateFileEmployeeAfterChange(id, employee);
    }
    public static void SalaryGrapeUp(long id, Employee employee) {
        dataUsers = fileController.ReadEmployeeFromFile("dataUsers.DAT");
        employee.setSalaryGrape(employee.getSalaryGrape()+1);
        UpdateFileEmployeeAfterChange(id, employee);
    }
    public static void Timekeeping(long id, Employee employee){
        dataUsers = fileController.ReadEmployeeFromFile("dataUsers.DAT");
        SimpleDateFormat formatt = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
        for (int i = 0; i < dataUsers.size(); i++) {
            if (dataUsers.get(i).getId() == id) {
                if(employee.getTimeIn().compareTo("") == 0) {
                    Date timeInAt = new Date();
                    employee.setTimeIn(formatter.format(timeInAt));
                    System.out.println("Time in: " + employee.getTimeIn());
                }
                else {
                    Date timeOutAt = new Date();
                    employee.setTimeOut(formatter.format(timeOutAt));
                    System.out.println("Time out: " + employee.getTimeOut());
                    fileController.WriteTimeToFile("WorkingTime.DAT", employee);
                }

                if(employee.getTimeIn().compareTo("") != 0 && employee.getTimeOut().compareTo("") != 0) {
                    Date d1 = null;
                    Date d2 = null;
                    try {
                        d1 = formatt.parse(employee.getTimeIn());
                        d2 = formatt.parse(employee.getTimeOut());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    assert d2 != null;
                    long workingTime = d2.getTime() - d1.getTime();
                    long hour = workingTime / (60 * 60 * 1000) - 2;
                    if(hour > 8) {
                        employee.setHour(employee.getHour() + 8 + (hour - 8)*2);
                    }
                    else {
                        employee.setHour(employee.getHour() + hour);
                    }
                    if (dataUsers.get(i).getId() == id) {
                        dataUsers.set(i, employee);
                        fileController.UpdateEmployeeFile(dataUsers, "dataUsers.DAT");
                        System.exit(0);
                        break;
                    }
                }
            }
        }
    }
    public static void TakeADayOff(long id) {
        dataUsers = fileController.ReadEmployeeFromFile("dataUsers.DAT");
        for(Employee emp : dataUsers) {
            if(emp.getId() == id) {
                System.out.print("Reason on leave: ");
                emp.setReason(sc.nextLine());
                System.out.print("Time break (day): ");
                emp.setNumber(sc.nextDouble());
                Date timeSent = new Date();
                emp.setTimeSent(formatter.format(timeSent));
                fileController.WriteReasonToFile("ReasonOnLeave.DAT", emp);
                System.out.println("Complete.");
            }
        }
    }
    public static void ViewMessage(long id) {
        dataUsers = fileController.ReadEmployeeFromFile("dataUsers.DAT");
        reasons = fileController.ReadReasonFromFile("ReasonOnLeave.DAT");
        System.out.println("Message...");
        System.out.println("-------------------------------------");
        for(Employee emp : dataUsers) {
            if(emp.getId() == id) {
                for(Employee rea : reasons) {
                    if((emp.getDepartment()).compareTo(rea.getDepartment()) == 0) {
                        rea.OutputMessage();
                    }
                }
            }
        }
    }
    public static void FindEmployee(String department) {
        int choose;
        System.out.println("----------------MENU FIND----------------");
        System.out.println("| 1. Find Employee In Your Department.  |");
        System.out.println("| 2. Find Employee In Company.          |");
        System.out.println("| 3. Back.                              |");
        System.out.println("-----------------------------------------");
        System.out.print("Your choose: ");
        choose = sc.nextInt();
        switch (choose) {
            case 1:
                FindEmployeeInYourDepartment(department);
                break;
            case 2:
                FindEmployeeInCompany();
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid selection.");
        }
    }
    public static void FindEmployeeInYourDepartment(String department) {
        dataUsers = fileController.ReadEmployeeFromFile("dataUsers.DAT");
        int choose, d = 0;
        do{
            System.out.println("-------MENU FIND--------");
            System.out.println("| 1. Search by id.     |");
            System.out.println("| 2. Search by name.   |");
            System.out.println("| 3. Back.             |");
            System.out.println("------------------------");

            System.out.print("Your choose: ");
            choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                    int id;
                    System.out.print("Enter id: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    for (Employee emp : dataUsers) {
                        if(emp.getId() == id && emp.getDepartment().compareTo(department) == 0) {
                            d++;
                        }
                    }
                    if(d == 0) {
                        System.out.println("Id: " + id + " does not exist in your department.");
                    }
                    else {
                        System.out.println("\tSearch results.");
                        for (Employee emp : dataUsers) {
                            if(emp.getId() == id && emp.getDepartment().compareTo(department) == 0) {
                                emp.OutputEmployee1();
                                System.out.println();
                            }
                        }
                        d = 0;
                    }
                    break;
                case 2:
                    String name;
                    System.out.print("Enter name: ");
                    name = sc.nextLine();

                    for (Employee emp : dataUsers) {
                        if(removeAccent(emp.getFullName().toLowerCase()).contains(removeAccent(name.toLowerCase()))  && emp.getDepartment().compareTo(department) == 0) {
                            d++;
                        }
                    }

                    if(d == 0) {
                        System.out.println("Name: " + name + " does not exist in your department.");
                    }
                    else {
                        for(int i = 1; i <= 181; i++) {
                            System.out.print("-");
                        }
                        System.out.print("\n| ");
                        System.out.print("\tSearch Results.");
                        System.out.printf("%163s", "|\n");
                        System.out.printf("| %-9s %-25s %-15s %-25s %-25s %-24s %-25s %-15s %-6s |", "Id", "Full name", "Date", "Address", "Hometown", "Nation", "Department", "Salary Grape", "Hour");
                        System.out.println();
                        for (Employee emp : dataUsers) {
                            if(removeAccent(emp.getFullName().toLowerCase()).contains(removeAccent(name.toLowerCase())) && emp.getDepartment().compareTo(department) == 0) {
                                emp.OutputEmployee();
                                System.out.println();
                            }
                        }
                        for(int i = 1; i <= 181; i++) {
                            System.out.print("-");
                        }
                        System.out.println();
                        d = 0;
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid selection.");
            }
        }while (choose != 3);
    }
    public static void FindEmployeeInCompany() {
        dataUsers = fileController.ReadEmployeeFromFile("dataUsers.DAT");
        int choose, d = 0;
        do{
            System.out.println("----------MENU FIND-----------");
            System.out.println("| 1. Search by id.           |");
            System.out.println("| 2. Search by name.         |");
            System.out.println("| 3. Search by department.   |");
            System.out.println("| 4. Back.                   |");
            System.out.println("------------------------------");

            System.out.print("Your choose: ");
            choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                    int id;
                    System.out.print("Enter id: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    for (Employee emp : dataUsers) {
                        if(emp.getId() == id) {
                            d++;
                        }
                    }
                    if(d == 0) {
                        System.out.println("Id: " + id + " does not exist.");
                    }
                    else {
                        System.out.println("\tSearch results.");
                        for (Employee emp : dataUsers) {
                            if(emp.getId() == id) {
                                emp.OutputEmployee1();
                                System.out.println();
                            }
                        }
                        d = 0;
                    }
                    break;
                case 2:
                    String name;
                    System.out.print("Enter name: ");
                    name = sc.nextLine();
                    for (Employee emp  : dataUsers) {
                        if(removeAccent(emp.getFullName().toLowerCase()).contains(removeAccent(name.toLowerCase()))) {
                            d++;
                        }
                    }
                    if(d == 0) {
                        System.out.println("Name: " + name + " does not exist.");
                    }
                    else {
                        for(int i = 1; i <= 181; i++) {
                            System.out.print("-");
                        }
                        System.out.print("\n| ");
                        System.out.print("\tSearch Results.");
                        System.out.printf("%163s", "|\n");
                        System.out.printf("| %-9s %-25s %-15s %-25s %-25s %-24s %-25s %-15s %-6s |", "Id", "Full name", "Date", "Address", "Hometown", "Nation", "Department", "Salary Grape", "Hour");
                        System.out.println();
                        for (Employee emp : dataUsers) {
                            if(removeAccent(emp.getFullName().toLowerCase()).contains(removeAccent(name.toLowerCase()))) {
                                emp.OutputEmployee();
                                System.out.println();
                            }
                        }
                        for(int i = 1; i <= 181; i++) {
                            System.out.print("-");
                        }
                        System.out.println();
                        d = 0;
                    }
                    break;
                case 3:
                    String department;
                    System.out.print("Enter department: ");
                    department = sc.nextLine();
                    for (Employee emp : dataUsers) {
                        if(removeAccent(emp.getDepartment().toLowerCase()).contains(removeAccent(department.toLowerCase()))) {
                            d++;
                        }
                    }
                    if(d == 0) {
                        System.out.println("Department: " + department + " does not exist.");
                    }
                    else {
                        for(int i = 1; i <= 181; i++) {
                            System.out.print("-");
                        }
                        System.out.print("\n| ");
                        System.out.print("\tSearch Results.");
                        System.out.printf("%163s", "|\n");
                        System.out.printf("| %-9s %-25s %-15s %-25s %-25s %-24s %-25s %-15s %-6s |", "Id", "Full name", "Date", "Address", "Hometown", "Nation", "Department", "Salary Grape", "Hour");
                        System.out.println();
                        for (Employee emp : dataUsers) {
                            if(removeAccent(emp.getDepartment().toLowerCase()).contains(removeAccent(department.toLowerCase()))) {
                                emp.OutputEmployee();
                                System.out.println();
                            }
                        }
                        for(int i = 1; i <= 181; i++) {
                            System.out.print("-");
                        }
                        System.out.println();
                        d = 0;
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid selection.");
            }
        }while (choose != 4);
    }
    public static void CreateAccountForEmployee(long idManager) {
        dataUsers = fileController.ReadEmployeeFromFile("dataUsers.DAT");
        Account acc = new Account();
        Employee employee = new Employee();
        String userName, password;
        int salaryGrape = 1;
        int hour = 0;
        if(dataUsers.size() == 0) {
            acc.setId(1);
            employee.setId(1);
        }
        else {
            acc.setId(dataUsers.get(dataUsers.size()-1).getId()+1);
            employee.setId(dataUsers.get(dataUsers.size()-1).getId()+1);
        }
        Pattern p1 = Pattern.compile(regUserName);
        while (true) {
            System.out.print("Username: ");
            userName = sc.nextLine();
            if(CheckUsername(userName)) {
                System.out.println("Username: " + userName + " already exists. Please re-enter.");
            }
            else {
                if(p1.matcher(userName).find()) {
                    acc.setUserName(userName);
                    break;
                }
                else {
                    System.out.println("Invalid username. Please re-enter.");
                }
            }
        }

        Pattern p2 = Pattern.compile(regPassword);
        while (true) {
            System.out.print("Password: ");
            password = sc.nextLine();
            if(p2.matcher(password).find()) {
                while (true) {
                    System.out.print("Please re-enter your password: ");
                    String rePassword;
                    rePassword = sc.nextLine();
                    if(password.compareTo(rePassword) == 0){
                        break;
                    }
                    else {
                        System.out.println("Incorrect password. Please re-enter.");
                    }
                }
                acc.setPassword(password);
                break;
            }
            else {
                System.out.println("Invalid password. Please re-enter.");
            }
        }
        for(Employee emp : dataUsers) {
            if(emp.getId() == idManager) {
                employee.setDepartment(emp.getDepartment());
            }
        }
        acc.setPosition("Employee");
        employee.setSalaryGrape(salaryGrape);
        employee.setHour(hour);

        Date createAt = new Date();
        acc.setCreatAt(formatter.format(createAt));

        dataUsers.add(employee);
        fileController.WriteEmployeeToFile("dataUsers.DAT", employee);
        accounts.add(acc);
        fileController.WriteAccountToFile("Account.DAT", acc);
        System.out.println("Successfully registered for employee.");
    }
    public static void DeleteEmployee(String department) {
        dataUsers = fileController.ReadEmployeeFromFile("dataUsers.DAT");
        accounts = fileController.ReadAccountFromFile("Account.DAT");
        int id, d = 0;
        System.out.print("Enter id to delete: ");
        id = sc.nextInt();
        for (Employee emp : dataUsers) {
            if(emp.getId() == id && emp.getDepartment().compareTo(department) == 0) {
                d++;
            }
        }
        if(d == 0) {
            System.out.println("Id: " + id + " does not exist in your department.");
        }
        else {
            for (int i = 0; i < dataUsers.size(); i++) {
                if(dataUsers.get(i).getId() == id  && dataUsers.get(i).getDepartment().compareTo(department) == 0) {
                    dataUsers.remove(dataUsers.get(i));
                    fileController.UpdateEmployeeFile(dataUsers, "dataUsers.DAT");
                    for (int j = 0; j < accounts.size(); j++) {
                        if(accounts.get(j).getId() == id) {
                            accounts.remove(accounts.get(j));
                            fileController.UpdateAccountFile(accounts, "Account.DAT");
                            System.out.println("Deleted");
                        }
                    }
                }
            }
        }
    }
    public static void SortEmployee(String department) {
        int chooseSort;
        do {
            System.out.println("---------MENU SORT---------");
            System.out.println("| 1. Sort By Name.        |");
            System.out.println("| 2. Sort By Hard Work.   |");
            System.out.println("| 3. Back.                |");
            System.out.println("---------------------------");

            System.out.print("Your choose: ");
            chooseSort = sc.nextInt();
            switch (chooseSort) {
                case 1:
                    SortByName(department);
                    break;
                case 2:
                    SortByHardWork(department);
                    break;
                case 3:
                    break;
            }
        }while (chooseSort != 3);

    }
    public static void SortByName(String department) {
        dataUsers = fileController.ReadEmployeeFromFile("dataUsers.DAT");
        List<Employee> dataSort = new ArrayList<>();
        for (Employee emp : dataUsers) {
            if(emp.getDepartment().compareTo(department) == 0) {
                dataSort.add(emp);
            }
        }
        dataSort.sort((o1, o2) -> {
            int i = o1.getFullName().trim().lastIndexOf(' ');
            o1.setName(o1.getFullName().substring(i + 1));
            int j = o2.getFullName().trim().lastIndexOf(' ');
            o2.setName(o2.getFullName().substring(j + 1));
            return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
        });
        for(int i = 1; i <= 181; i++) {
            System.out.print("-");
        }
        System.out.print("\n| ");
        System.out.print("\tSort by name.");
        System.out.printf("%165s", "|\n");
        System.out.printf("| %-9s %-25s %-15s %-25s %-25s %-24s %-25s %-15s %-6s |", "Id", "Full name", "Date", "Address", "Hometown", "Nation", "Department", "Salary Grape", "Hour");
        System.out.println();
        for (Employee emp : dataSort) {
            emp.OutputEmployee();
            System.out.println();
        }
        for(int i = 1; i <= 181; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
    public static void SortByHardWork(String department) {
        dataUsers = fileController.ReadEmployeeFromFile("dataUsers.DAT");
        /*Collections.sort(dataUsers, new Comparator<>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o2.getHour()-o1.getHour());
            }
        });*/
        List<Employee> dataSort = new ArrayList<>();
        for (Employee emp : dataUsers) {
            if(emp.getDepartment().compareTo(department) == 0) {
                dataSort.add(emp);
            }
        }
        dataSort.sort((o1, o2) ->
                (int) (o2.getHour() - o1.getHour())
        );
        for(int i = 1; i <= 181; i++) {
            System.out.print("-");
        }
        System.out.print("\n| ");
        System.out.print("\tSort by hard work.");
        System.out.printf("%160s", "|\n");
        System.out.printf("| %-9s %-25s %-15s %-25s %-25s %-24s %-25s %-15s %-6s |", "Id", "Full name", "Date", "Address", "Hometown", "Nation", "Department", "Salary Grape", "Hour");
        System.out.println();
        for (Employee emp : dataSort) {
            emp.OutputEmployee();
            System.out.println();
        }
        for(int i = 1; i <= 181; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
    public static void Summary(String department) {
        dataUsers = fileController.ReadEmployeeFromFile("dataUsers.DAT");
        int choose;
        System.out.println("Summary confirmation: ");
        System.out.println("1. Yes.");
        System.out.println("2. No.");
        System.out.print("Your choose: ");
        choose = sc.nextInt();
        switch (choose) {
            case 1:
                long hourMax = 200;

                for (Employee emp : dataUsers) {
                    if(emp.getDepartment().compareTo(department) == 0) {
                        emp.setMore("");
                        emp.setSalary((((emp.getSalaryGrape()-1)*5000)+40000) * emp.getHour());
                        if(hourMax < emp.getHour()) {
                            hourMax = emp.getHour();
                        }
                    }
                }

                for (Employee emp : dataUsers) {
                    if(emp.getDepartment().compareTo(department) == 0) {
                        if(hourMax == emp.getHour()) {
                            emp.setSalary(emp.getSalary() + 500000);
                            emp.setMore("Hardest employee");
                        }
                        else if(emp.getHour() > 200) {
                            emp.setSalary(emp.getSalary() + 200000);
                            emp.setMore("Hard-working employee");
                        }
                        else if(emp.getHour() < 160) {
                            emp.setMore("Employee need to try");
                        }
                    }
                }

                Locale localeVN = new Locale("vi", "VN");
                NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
                for(int i = 1; i <= 227; i++) {
                    System.out.print("-");
                }
                System.out.println();
                System.out.printf("| %-9s %-25s %-15s %-25s %-25s %-24s %-25s %-15s %-5s %-20s %-25s |", "Id", "Full name", "Date", "Address", "Hometown", "Nation", "Department", "Salary Grape", "Hour", "Salary", "More");
                System.out.println();
                for (Employee emp : dataUsers) {
                    if(emp.getDepartment().compareTo(department) == 0) {
                        emp.OutputEmployeeSumary();
                        String salaryVND = currencyVN.format(emp.getSalary());
                        System.out.printf("%-20s %-25s |", salaryVND, emp.getMore());
                        System.out.println();
                        emp.setHour(0);
                    }
                }
                for(int i = 1; i <= 227; i++) {
                    System.out.print("-");
                }
//              Reset
                for (int i = 0; i < dataUsers.size(); i++) {
                    if(dataUsers.get(i).getDepartment().compareTo(department) == 0) {
                        dataUsers.set(i, dataUsers.get(i));
                    }
                }
                fileController.UpdateEmployeeFile(dataUsers, "dataUsers.DAT");
                System.exit(0);
                break;
            case 2:
                break;
        }
    }
    public static void WriteFeedback(long id) {
        dataUsers =  fileController.ReadFeedbackFromFilePublic("dataUsers.DAT");
        for (Employee emp : dataUsers) {
            if(emp.getId() == id) {
                System.out.print("Your feedback: ");
                emp.setFeedback(sc.nextLine());
                Date writeAt = new Date();
                emp.setWriteAt(formatter.format(writeAt));

                int choose;
                System.out.println("Do you want to send it public or private?");
                System.out.println("1. Public.");
                System.out.println("2. Private.");
                System.out.print("Your choose: ");
                choose = sc.nextInt();
                sc.nextLine();
                switch (choose) {
                    case 1:
                        fileController.WriteFeedbackPublic("FeedbackPublic.DAT", emp);
                        break;
                    case 2:
                        fileController.WriteFeedbackPrivate("FeedbackPrivate.DAT", emp);
                        break;
                    default:
                        System.out.println("Invalid selection.");
                }
            }
        }
        System.out.println("Your feedback has been sent.");
    }
    public static void ViewFeedback(String department) {
        feedbackPublic = fileController.ReadFeedbackFromFilePublic("FeedbackPublic.DAT");
        feedbackPrivate = fileController.ReadFeedbackFromFilePrivate("FeedbackPrivate.DAT");
        System.out.println("-------------------------------------");
        System.out.println("Feedback public...");
        for (Employee emp1 : dataUsers) {
            for(Employee emp : feedbackPublic) {
                if(emp.getId() == emp1.getId() && emp1.getDepartment().compareTo(department) == 0) {
                    emp.OutputFeedbackPublic();
                }
            }
        }
        System.out.println("Feedback private...");
        for (Employee emp : feedbackPrivate) {
            emp.OutputFeedbackPrivate();
        }
    }
}
