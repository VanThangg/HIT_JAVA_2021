package controller;

import model.Employee;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class EmployeeController extends FileController {
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
}
