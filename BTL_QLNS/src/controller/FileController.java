package controller;

import model.Account;
import model.Employee;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileController {

    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private PrintWriter printWriter;
    private Scanner scanner;

    public Scanner getScanner(){
        return this.scanner;
    }

    public void OpenFileToWrite(String fileName){
        try {
            fileWriter = new FileWriter(fileName, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void CloseFileAfterWrite(){
        try {
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void OpenFileToRead(String fileName){
        try {
            File file = new File(fileName);
            if(!file.exists()){
                file.createNewFile();
            }
            scanner = new Scanner(Paths.get(fileName),"UTF-8");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void CloseFileAfterRead(){
        try{
            scanner.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //Account
    public void WriteAccountToFile(String fileName, Account acc){
        OpenFileToWrite(fileName);
        printWriter.println(
                acc.getId() + "|" + acc.getUserName() + "|" + acc.getPassword() + "|" + acc.getPosition() +  "|" +  acc.getPhoneNumber() + "|" + acc.getEmail() + "|" + acc.getCreatAt()
        );
        CloseFileAfterWrite();
    }

    public Account CreateAccountFromData(String data){
        String[] datas = data.split("\\|");
        Account acc = new Account(Integer.parseInt(datas[0]), datas[1], datas[2], datas[3], datas[4], datas[5], datas[6]);
        return acc;
    }

    public List<Account> ReadAccountFromFile(String fileName){
        OpenFileToRead(fileName);
        List<Account> list = new ArrayList<>();
        while(scanner.hasNext()){
            String data = scanner.nextLine();
            Account acc = CreateAccountFromData(data);
            list.add(acc);
        }
        CloseFileAfterRead();
        return list;
    }

    public void UpdateAccountFile(List<Account> list, String fileName){
        File file = new File(fileName);
        if(file.exists()){
            file.delete();
        }
        for (Account acc : list) {
            WriteAccountToFile(fileName, acc);
        }
    }
    //Employee
    public void WriteEmployeeToFile(String fileName, Employee employee){
        OpenFileToWrite(fileName);
        printWriter.println(
                employee.getId() + "|" + employee.getFullName() + "|" + employee.getDate() + "|" + employee.getAddress()
                        + "|" +  employee.getHometown() + "|" + employee.getNation() + "|" + employee.getDepartment()
                        + "|" + employee.getSalaryGrape() + "|" + employee.getHour()
        );
        CloseFileAfterWrite();
    }

    public Employee CreateEmployeeFromData(String data){
        String[] datas = data.split("\\|");
        Employee employee = new Employee(Integer.parseInt(datas[0]), datas[1], datas[2], datas[3], datas[4], datas[5], datas[6], Integer.parseInt(datas[7]), Integer.parseInt(datas[8]));
        return employee;
    }

    public List<Employee> ReadEmployeeFromFile(String fileName){
        OpenFileToRead(fileName);
        List<Employee> list = new ArrayList<>();
        while(scanner.hasNext()){
            String data = scanner.nextLine();
            Employee employee = CreateEmployeeFromData(data);
            list.add(employee);
        }
        CloseFileAfterRead();
        return list;
    }

    public void UpdateEmployeeFile(List<Employee> list, String fileName){
        File file = new File(fileName);
        if(file.exists()){
            file.delete();
        }
        for (Employee employee : list) {
            WriteEmployeeToFile(fileName, employee);
        }
    }
    //Feedback Public
    public void WriteFeedbackPublic(String fileName, Employee employee){
        OpenFileToWrite(fileName);
        printWriter.println(
                employee.getId() + "|" + employee.getFullName() + "|" + employee.getFeedback() + "|" + employee.getWriteAt()
        );
        CloseFileAfterWrite();
    }

    public Employee CreateFeedbackFromDataPublic(String data){
        String[] datas = data.split("\\|");
        Employee employee = new Employee(Integer.parseInt(datas[0]), datas[1], datas[2], datas[3]);
        return employee;
    }

    public List<Employee> ReadFeedbackFromFilePublic(String fileName){
        OpenFileToRead(fileName);
        List<Employee> list = new ArrayList<>();
        while(scanner.hasNext()){
            String data = scanner.nextLine();
            Employee employee = CreateFeedbackFromDataPublic(data);
            list.add(employee);
        }
        CloseFileAfterRead();
        return list;
    }
    //Feedback Private
    public void WriteFeedbackPrivate(String fileName, Employee employee){
        OpenFileToWrite(fileName);
        printWriter.println(
                employee.getFeedback() + "|" + employee.getWriteAt()
        );
        CloseFileAfterWrite();
    }

    public Employee CreateFeedbackFromDataPrivate(String data){
        String[] datas = data.split("\\|");
        Employee employee = new Employee(datas[0], datas[1]);
        return employee;
    }

    public List<Employee> ReadFeedbackFromFilePrivate(String fileName){
        OpenFileToRead(fileName);
        List<Employee> list = new ArrayList<>();
        while(scanner.hasNext()){
            String data = scanner.nextLine();
            Employee employee = CreateFeedbackFromDataPrivate(data);
            list.add(employee);
        }
        CloseFileAfterRead();
        return list;
    }
    //Working time
    public void WriteTimeToFile(String fileName, Employee employee){
        OpenFileToWrite(fileName);
        printWriter.println(
                employee.getId() + "|" + employee.getTimeIn() + "|" + employee.getTimeOut()
        );
        CloseFileAfterWrite();
    }

    /*public Employee CreateTimeFromData(String data){
        String[] datas = data.split("\\|");
        Employee employee = new Employee(Integer.parseInt(datas[0]), datas[1], datas[3]);
        return employee;
    }

    public List<Employee> ReadTimeFromFile(String fileName){
        OpenFileToRead(fileName);
        List<Employee> list = new ArrayList<>();
        while(scanner.hasNext()){
            String data = scanner.nextLine();
            Employee employee = CreateTimeFromData(data);
            list.add(employee);
        }
        CloseFileAfterRead();
        return list;
    }*/

    public void WriteReasonToFile(String fileName, Employee employee){
        OpenFileToWrite(fileName);
        printWriter.println(
                employee.getId() + "|" + employee.getFullName() + "|" + employee.getDepartment() + "|" + employee.getReason() + "|" + employee.getNumber() + "|" + employee.getTimeSent()
        );
        CloseFileAfterWrite();
    }

    public Employee CreateReasonFromData(String data){
        String[] datas = data.split("\\|");
        Employee employee = new Employee(Integer.parseInt(datas[0]), datas[1], datas[2], datas[3], Double.parseDouble(datas[4]), datas[5]);
        return employee;
    }

    public List<Employee> ReadReasonFromFile(String fileName){
        OpenFileToRead(fileName);
        List<Employee> list = new ArrayList<>();
        while(scanner.hasNext()){
            String data = scanner.nextLine();
            Employee employee = CreateReasonFromData(data);
            list.add(employee);
        }
        CloseFileAfterRead();
        return list;
    }
}
