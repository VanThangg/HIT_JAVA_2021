package ex1;

public class RunMain {
    //1. Kiểu dữ liệu tham số đầu vào
//2. Số lượng tham số đầu vào
    public static int sum(int a, int b) {
        return a + b;
    }


    public static int sum(int a, int b, int c) {
        return a + b + c;
    }

    public static double sum(double a, double b) {
        return a + b;
    }


    public static long sum(int a, long b) {
        return a + b;
    }
    public static long sum(long a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println(sum(1L, 2));
        System.out.println(sum(1, 2, 3));

        System.out.println((char) 48);
        long a = (byte) 5;
        long b = 5;
//        main(16);
    }

//    public static void main(int a) {
//        System.out.println(a);
//    }
}
