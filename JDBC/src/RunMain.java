import java.sql.*;
import java.util.List;

public class RunMain {
    public static void main(String[] args) throws SQLException {
        //        Connection
//        DriverManager
//        Statement
//        PreparedStatement
//        ResultSet

//        Connection conn = SQLServerConnection.getJDBCConnection();
//        Statement statement = conn.createStatement();

        //1. read data: select
//        String type = "Quần áo";
//        int gia = 500;
//        String sqlSelect = "select * from Hang where Loai = N'" + type + "' and Gia = " + gia;
//        String sqlSelect2 = "select * from Hang where Loai = N'Quần áo'";
//        ResultSet resultSet = statement.executeQuery(sqlSelect);
//
//        while (resultSet.next()) {
//            String s = resultSet.getString("Tenhang");
//            String s2 = resultSet.getString("Loai");
//            System.out.println(s);
//        }

//        List<Hang> hangs = SQLProcessing.readAllProduct();
//        hangs.forEach(System.out::println);

        //2. insert data: insert
//        String sqlInsert = "insert into Hang values ('06', 'Hang demo', N'Váy', 2000)";
//        statement.executeUpdate(sqlInsert);
//        int res = SQLProcessing.insertRecord("06", "Huân", "Người", 0);
//        System.out.println(res);

        //3. update data: update
//        String sqlUpdate = "update Hang set Tenhang = N'Váy dài', Gia = 5000 where Mahang = '06'";
//        statement.executeUpdate(sqlUpdate);
//        int res = SQLProcessing.updateRecord("06", "Váy dài", "Váy", 10000);
//        System.out.println(res);

        //4. delete data: delete
//        String sqlDelete = "delete Hang where Mahang = '06'";
//        statement.executeUpdate(sqlDelete);
//        int res = SQLProcessing.deleteRecord("06");
//        System.out.println(res);

        Connection conn = SQLServerConnection.getJDBCConnection();

        //select
        /*String loai = "Quần áo";
        String sql = "select * from Hang where Loai = N'"+loai+"'";

        String sqlSelect = "select * from Hang where Loai = ? and Gia = ?";

        PreparedStatement statement = conn.prepareStatement(sqlSelect);

        statement.setString(1, "Quần áo");
        statement.setInt(2, 700);

        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()) {
            System.out.println(resultSet.getString(2));
        }*/

    }
}
