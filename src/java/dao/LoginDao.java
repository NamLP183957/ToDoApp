
package dao;
import Utils.JDBCUtils;
import java.sql.*;

import model.User;

/**
 *
 * @author Nam
 */
public class LoginDao {
    
    public boolean validate(User employee) throws ClassNotFoundException, SQLException{
        boolean status = false;
       Connection connection = JDBCUtils.getConnection();
       
       String LOGIN_SQL = "SELECT * FROM users WHERE username = ? AND password = ?";
       PreparedStatement statement = connection.prepareStatement(LOGIN_SQL);
       statement.setString(1, employee.getUserName());
       statement.setString(2, employee.getPassword());
       
       ResultSet rs = statement.executeQuery();
       
       if (rs.next()) status = true;
       
       return status;
    }
}
