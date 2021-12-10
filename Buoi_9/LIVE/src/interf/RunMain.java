package interf;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RunMain {
    public static void main(String[] args) {
//        Dog dog = new Dog();
//        dog.eat();

        IAnimal2 dog = new Dog();
        dog.sleep();

        IAnimal2 cat = new Cat();
        cat.sleep();

        ArrayList<Integer> list = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();

        List<Integer> list2 = new LinkedList<>();

        LinkedList<Integer> linkedList = new LinkedList<>();

//        interface, trừu tượng, stream(song song, map), abstract class
    }
}