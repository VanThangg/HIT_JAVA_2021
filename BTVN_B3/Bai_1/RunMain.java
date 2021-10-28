/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai_1;

/**
 *
 * @author Thang02
 */
public class RunMain {
    public static void main(String[] args) {
        Person person = new Person("Nguyễn Văn Thắng", 19, "Name", "Code ^^");
        System.out.println(person);
        
        Person p1 = new Person();
        p1.setName("Nguyễn Văn A");
        p1.setAge(19);
        p1.setGender("Male");
        p1.setHobby("Code ^^");
        
        System.out.println(p1);
        
    }

}
