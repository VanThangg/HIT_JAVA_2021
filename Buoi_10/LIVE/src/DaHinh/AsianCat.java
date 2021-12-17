package DaHinh;

public class AsianCat extends Cat {

    @Override
    public void getClazz() {
        System.out.println("Class AsianCat");
    }

    public void sleep(int start, int end, String name) {
        System.out.printf("\n%s đã ngủ %d giờ", name, end - start);
    }
}