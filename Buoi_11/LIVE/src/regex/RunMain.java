package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RunMain {
    static String regUserName = "^[\\w]{5,}$";
    static String regPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=])[A-Za-z0-9@#$%^&+=]{8,}$";
    static String regPhone = "^[0-9\\-\\+]{9,15}$";
    static String regEmail = "[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}";

    public static void main(String[] args) {
        // (?=.*[a-z]) : ?=.*[Ký tự bắt buộc] : bắt buộc trong chuỗi phải có ký tự này
        //static Pattern compile(String regex)
        //boolean matches()	kiểm tra xem biểu thức chính quy có khớp với mẫu hay không.
        //boolean find()	tìm biểu thức tiếp theo khớp với mẫu.


//        Matcher matcher = pattern.matcher();
//        System.out.println(matcher.find());
        Pattern pattern = Pattern.compile(regEmail);
        String email = "huannd0101@gmail.com|huannd0101@gmail.com|huannd0101@gmail.com";

        if(pattern.matcher(email).find()) {
            System.out.println("Đây là 1 email");
        }else {
            System.out.println("Đây là không là 1 email");
        }

        String text1 = "Hello java regex 2-12-2018, hello world 12/12/2018";
        Pattern pattern2 = Pattern.compile("\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}");
        Matcher matcher = pattern2.matcher(text1);

        System.out.println("Ngày tháng trong chuỗi text1: " + text1);
        while (matcher.find()) {
            System.out.println(text1.substring(matcher.start(), matcher.end()));
        }


    }
}
