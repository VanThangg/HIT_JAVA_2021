package abs;

public class Dog extends Animal{
    @Override
    public void sleep() {
        System.out.println("Dog đang ngủ...");
    }


    public void eat() {
        super.eat();
        System.out.println("Dog đang ăn");
    }

    public void speak(){

    }
}