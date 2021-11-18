package KeThua;

public class Conn extends Cha {
    public String ny;

    public Conn() {
    }

    public Conn(long soTien, String ny) {
        super(soTien);
        this.ny = ny;
    }

    public void dapPha() {
        System.out.println("Con dap pha");
    }


    @Override
    public void diLam() {
        super.diLam(); //gọi đến phương thức của cha
        System.out.println("Con đang đi làm");
    }
}
