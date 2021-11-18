package Generic;

public class ShowInfo<T> {
    T obj;

    public void show() {
        System.out.println(obj);
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
