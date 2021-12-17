package DaHinh;

public class Animal {
    private String name;
    private int age;

    public Animal() {
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //------------------------: ghi đè
    public void getClazz() {
        System.out.println("Class Animal");
    }


    //---------------------: nạp chồng
    public void sleep(int n) {
        System.out.printf("\nĐã ngủ %d giờ", n);
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