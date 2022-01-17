public class Hang {
    private String maHang;
    private String tenHang;
    private String loai;
    private int gia;

    public Hang() {
    }

    public Hang(String maHang, String tenHang, String loai, int gia) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.loai = loai;
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "Hang{" +
                "maHang='" + maHang + '\'' +
                ", tenHang='" + tenHang + '\'' +
                ", loai='" + loai + '\'' +
                ", gia=" + gia +
                '}';
    }
}
