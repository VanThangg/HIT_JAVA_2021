
package Bai_2;

public class RunMain {
    public static void main(String[] args) {
        Array arr1 = new Array();
        Array arr2 = new Array();
        System.out.println("Nhap arr1.");
        arr1.InputData();
        System.out.println("Nhap arr2.");
        arr2.InputData();
        
        float TbcArr1 = arr1.Sum()/arr1.getN();
        float TbcArr2 = arr2.Sum()/arr2.getN();
        if(TbcArr1 > TbcArr2) {
            System.out.println("TBC Arr1 > TBC Arr2.");
        }
        else if(TbcArr1 < TbcArr2) {
            System.out.println("TBC Arr1 < TBC Arr2.");         
        }
        else {
            System.out.println("Bye");
        }
    }
}
