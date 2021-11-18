package KeThua;

public class RunMain {
    public static void main(String[] args) {
        // extends: kế thừa
        // super: gọi constructor của cha

        Conn conn = new Conn(1999, "Huân");
//        System.out.println(conn.soTien);
//        conn.dapPha();
//        System.out.println(conn.ny);
//        System.out.println(conn.dienTichDat);
        conn.diLam();


//        Cha cha = new Cha();
//
//        cha.hutThuoc();
//        conn.hutThuoc();

    }
}
