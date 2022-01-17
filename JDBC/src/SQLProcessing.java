import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLProcessing {
    static Connection conn = SQLServerConnection.getJDBCConnection();
    static Statement statement;

    static {
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //----------------------------
    public static int insertRecord(String maHang, String tenHang, String loai, int gia) {
        String sqlInsert = "insert into Hang values ('"+maHang+"', '"+tenHang+"', N'"+loai+"', "+gia+")";
        try {
            return statement.executeUpdate(sqlInsert);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int updateRecord(String maHang, String tenHang, String loai, int gia) {
        String sqlUpdate =
                "update Hang set Tenhang = N'"+tenHang+ "', "+
                        "Loai = N'"+loai+
                        "', Gia = "+gia+
                        " where Mahang = '"+maHang+"'";
        try {
            return statement.executeUpdate(sqlUpdate);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int deleteRecord(String maHang) {
        String sqlDelete = "delete Hang where Mahang = '"+maHang+"'";
        try {
            return statement.executeUpdate(sqlDelete);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static List<Hang> readAllProduct() {
        List<Hang> hangs = new ArrayList<>();
        String sql = "select * from Hang";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Hang hang = new Hang(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4)
                );

                hangs.add(hang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hangs;
    }

}
