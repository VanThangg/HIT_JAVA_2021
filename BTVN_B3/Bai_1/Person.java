
package Bai_1;

public class Person {
    private String name;
    private int age;
    private String gender;
    private String hobby;
    
    public Person(){
        this.name = "";
        this.age = 0;
        this.gender = "";
        this.hobby = "";
    }
    public Person(String name, int age, String gender, String hobby) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", age=" + age + ", gender=" + gender + ", hobby=" + hobby + '}';
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getGender() {
        return gender;
    }
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
    public String getHobby() {
        return hobby;
    }

}
