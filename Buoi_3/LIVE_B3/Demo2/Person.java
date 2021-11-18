/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Demo2;

/**
 *
 * @author Thang02
 */
public class Person {
    private int id;
    private String name;
    private int age;
    private static int cnt = 1;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        id = cnt;
        cnt++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age; 
    }
}