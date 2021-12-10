package abs;

//abstract method: không định nghĩa tại class abstract, bắt thằng con định nghĩa lại(ghi đè)
public abstract class Animal {
    //[access_modifier] abstract [kiểu_trả_về] [tên_phương_thức_trừu_tượng] [<đối_số_truyền_vào>];
    public abstract void sleep();
    public String name;

    public void eat() {
        System.out.println("Đăng ăn....");
    }

}