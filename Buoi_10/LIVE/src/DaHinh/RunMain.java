package DaHinh;

import java.util.LinkedList;
import java.util.List;

public class RunMain {
    public static void main(String[] args) {
//        List<Animal> animals = new LinkedList<>();
        Animal animal = new Animal();

        Cat cat = new Cat();

        AsianCat asianCat = new AsianCat();

        animal.getClazz();
        animal.sleep(5);

        cat.getClazz();
        cat.sleep(6);
        cat.sleep(12, 6);

        asianCat.getClazz();
//        asianCat.sleep();

    }
}
