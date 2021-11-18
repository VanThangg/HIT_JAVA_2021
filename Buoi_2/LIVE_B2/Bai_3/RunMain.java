
package Bai_3;

public class RunMain {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 10};
        
        for(int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }
        
       for(int item : a) {  //forEach
           System.out.println(item + " Hello");
       }
    }
}
