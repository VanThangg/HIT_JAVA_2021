package KeThua;

public class Cha extends Ong{
    private String vo;
    protected long soTien;

    public Cha() {
    }

    public Cha(long soTien) {
        this.soTien = soTien;
    }

    public Cha(String vo, long soTien) {
        this.vo = vo;
        this.soTien = soTien;
    }

    private void anBaCham() {
        System.out.println("Bố ăn ...");
        System.out.println(dienTichDat);
    }

    public void diLam() {
        System.out.println("Bố đi làm...");
    }


}