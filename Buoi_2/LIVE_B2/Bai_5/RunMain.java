/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai_5;

public class RunMain {
    public static void main(String[] args) {
//        String s = new String("HIT 12");
//        String s = "HIT 12";
//        System.out.println(s.length());
//        System.out.println(s.charAt(2));
//        System.out.println(s.indexOf("T"));

        String s = "HIT";
        String s1 = "hit";
        System.out.println(s.compareTo(s1));
        
        String s3 = "123123     HIT     ";
//        System.out.println(s3.trim());
        String[] arr = s3.split("Love");
        for(String item : arr) {
            System.out.println(item);
        }
        System.out.println(s3.split(" ").length);
        
        int 
      
    }
}
