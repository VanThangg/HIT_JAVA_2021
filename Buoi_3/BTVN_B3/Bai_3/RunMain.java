
package Bai_3;

import java.util.Random;

public class RunMain {
    public static void main(String[] args) {
        Random rd = new Random();
        Guns DiepBeDe = new Guns("AK47", 100);
        Guns DoanXinhGai = new Guns("BK47", 100);
       
        while(true) {
            int d1 = DiepBeDe.Shoot(rd.nextInt(10) + 1);
            int d2 = DoanXinhGai.Shoot(rd.nextInt(10) + 1);
            if(d1 == 0 && d2 == 0) {
                System.out.println("2 anh cung het dan. Tiep tuc nap dan.");
                DiepBeDe.Load(rd.nextInt(10) + 1);
                DoanXinhGai.Load(rd.nextInt(10) + 1);
            }
            else if(d2 == 0) {
                System.out.println("Anh DiepBeDe chien thang.");
                break;
            }
            else if(d1 == 0) {
                System.out.println("Anh DoanXinhGai chien thang.");
                break;
            }
        }
    }
}
