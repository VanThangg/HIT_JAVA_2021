package Generic;

public class RunMain {
    public static void main(String[] args) {
        //1) Generic: là một cách để xác định các kiểu(kiểu dữ liệu, kiểu object) cụ thể cho các lớp và
        // phương thức trong ngữ cảnh khác nhau
        //template:
        /*
            T - Type
            E - Element
            K - Key
            N - Number
            V - Value
        */
        //kết tập: trong 1 class thì lại chứa 1 class khác
//        Array<Integer> array = new Array<Integer>();
//        array.setN(5);
//        Integer[] b = new Integer[]{1, 2, 3, 4, 5};
//        array.setA(b);
//        System.out.println(array);
//
//        Array<Double> array2 = new Array<>();
//        array2.setN(5);
//        Double[] c = new Double[]{1.5, 2.5, 2.0, 5.5, 2.8};
//        array2.setA(c);
//        System.out.println(array2);
//
//
//        ShowInfo<Student> showInfo = new ShowInfo<>();
//        showInfo.setObj(new Student("Huân"));
//        showInfo.show();
//
//        ShowInfo<Array<Integer>> showInfo2 = new ShowInfo<>();
//        showInfo2.setObj(array);
//        showInfo2.show();
//
//
//        ShowInfo<Integer> showInfo3 = new ShowInfo<>();
//        Integer integer = 4;
//        showInfo3.setObj(integer);
//        showInfo3.show();
//
//        Array<Student> array1 = new Array<>();
//        array1.setN(1);
//        Student[] temp = new Student[]{new Student("HUan123")};
//        array1.setA(temp);
//
//        System.out.println(array1);


        Student student = new Student("Huân");
        System.out.println(student.toString());
    }
}
