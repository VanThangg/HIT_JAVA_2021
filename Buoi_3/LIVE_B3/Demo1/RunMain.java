
package Demo1;

public class RunMain {
    
    public static void main(String[] args) {
//        Car carA = new Car();
//        Car carB = new Car();
//        carA.tenXe = "Xe A";
//        carA.diThang();
//        carB.diLui();
        Car carA = new Car("Xe A", "Mau do", 6);
        carA.setSoBanhXe(5);
//        System.out.println(carA.tenXe + " - " + carA.mauSac + " - " + carA.soBanhXe);
        
        System.out.println(carA.getTenXe());
        System.out.println(carA.getSoBanhXe());
    }
}
