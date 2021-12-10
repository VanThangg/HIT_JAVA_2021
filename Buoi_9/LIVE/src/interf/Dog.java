package interf;

//kế thừa: extends class
//triển khai: implements interface

public class Dog implements IAnimal2, Animal {

    @Override
    public void sleep() {
//        int res = 10 / 0;
        System.out.println("Dog đang ngủ....");
    }

    @Override
    public void sleep2() {
        System.out.println("Sleep2....");
    }

    @Override
    public void sleep3() {
        System.out.println("Sleep3....");
    }

    @Override
    public void eat() {
    }
}