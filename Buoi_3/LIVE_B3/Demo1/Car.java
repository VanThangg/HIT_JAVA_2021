/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Demo1;

/**
 *
 * @author Thang02
 */
public class Car {
//    Thuộc tính
    private String mauSac;
    private int soBanhXe;
    private String tenXe;
    
//  Contructors
    public Car() {
        tenXe = "Xe hơi";
    }
    public void setSoBanhXe(int soBanhXe) {
        if(soBanhXe % 2 != 0) {
            this.soBanhXe = soBanhXe - 1;
        }
        else {
            this.soBanhXe = soBanhXe;
        }
    }
    public int getSoBanhXe() {
        return soBanhXe;
    }
    
    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }
    public String getTenXe() {
        return tenXe;
    }
    
    public Car(String tenXe, String mauSac, int soBanhXe) {
        this.tenXe = tenXe;
        this.mauSac = mauSac;
        this.soBanhXe = soBanhXe;
    }
    
    
    
//  Phuong thuc
    public void diThang(){
        System.out.println("Lai xe di thang");
    }
    public void diLui(){
        System.out.println("Lai xe di lui");
    }
}
