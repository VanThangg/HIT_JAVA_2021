package DaHinh;

public class Cat extends Animal {

    @Override
    public void getClazz() {
        System.out.println("Class Cat");
    }

    public void sleep(int start, int end) {
        System.out.printf("\nĐã ngủ %d giờ", end - start);
    }
}
