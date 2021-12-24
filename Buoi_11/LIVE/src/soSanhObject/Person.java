package soSanhObject;

public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public boolean equals(Object o) {
        //b1: ép kiểu Object -> Person
        Person person = (Person) o;
//        return person.age == this.age;
        //b2: so sánh và trả về theo tiêu trí nào đó
//        return this.name.compareToIgnoreCase(person.name) == 0;
        return person.age == this.age && this.name.compareToIgnoreCase(person.name) == 0;
    }



}