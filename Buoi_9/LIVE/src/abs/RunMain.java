package abs;

public class RunMain {
    //abstract: giảm thiểu code trùng nhau, quản lý khó, khó bảo trì
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();

        dog.sleep();
        dog.eat();

        cat.sleep();
        cat.eat();
    }

}