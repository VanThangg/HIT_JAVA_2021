package Bai_4;

public class RunMain {
    public static void main(String[] args) {
        Sum<Integer> a = new Sum<Integer>(2, 4);
        System.out.println(a.getSoA()+a.getSoB());

        Sum<Long> b = new Sum<Long>(123456l, 654321l);
        System.out.println(b.getSoA()+b.getSoB());

        Sum<Float> c = new Sum<Float>(1.2f, 3.4f);
        System.out.println(c.getSoA()+c.getSoB());

        Sum<Double> d = new Sum<Double>(5.6, 7.8);
        System.out.println(d.getSoA()+d.getSoB());

    }

}
