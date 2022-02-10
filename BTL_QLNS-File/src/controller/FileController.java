package controller;

import model.Employee;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileController {

    public FileWriter fileWriter;
    public BufferedWriter bufferedWriter;
    public PrintWriter printWriter;
    public Scanner scanner;

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
