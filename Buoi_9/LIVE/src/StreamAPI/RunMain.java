package StreamAPI;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class RunMain {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        //Filter: loc
        ArrayList res1 = (ArrayList) list.stream().filter(item -> item % 2 == 0).collect(Collectors.toList());
        System.out.println(res1);

//        map: trả về 1 mảng giữ nguyên số lượng phần tử trong mảng và
//        có thể thay đổi giá trị của phần tử trong mảng
        System.out.println(list.stream().map(item -> {
            return item*2;
        }).collect(Collectors.toList()));

//        skip bỏ qua n phần tử đầu tiên
//        list.stream().skip(n);

    }
}
