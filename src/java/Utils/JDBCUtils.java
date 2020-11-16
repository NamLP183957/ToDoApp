
package Utils;
import java.sql.*;
import java.time.LocalDate;

public class JDBCUtils {
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        String hostName = "localhost";
        String dbName = "todolist";
        String userName = "root";
        String password = "";
        
        return getConnection(hostName, dbName, userName, password);
    }
    
    public static Connection getConnection(String hostName, String dbName, String userName, String password) throws ClassNotFoundException, SQLException{
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        String connectionUrl = "jdbc:mysql://" + hostName + ":3306/" + dbName + "?useUnicode=true&characterEncoding=utf-8";
        connection = DriverManager.getConnection(connectionUrl, userName, password);
        
        return connection;
    }

    public static Date getSQLDate(LocalDate date) {
        return java.sql.Date.valueOf(date);
    }
    
}
