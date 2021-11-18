package Generic;

import java.util.Arrays;
//tất cả kiểu dữ liệu nào mà muốn linh động theo lúc khai báo, thì để là T

public class Array<T> {
    private T[] a;
    private int n;

    public Array() {
    }

    public Array(T[] a, int n) {
        this.a = a;
        this.n = n;
    }

    public T[] getA() {
        return a;
    }

    public void setA(T[] a) {
        this.a = a;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "Array{" +
                "a=" + Arrays.toString(a) +
                ", n=" + n +
                '}';
    }
}
