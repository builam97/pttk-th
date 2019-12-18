package demo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import demo.utils.MySQLConnUtils;

public class LoginDAO {
	
	public static Boolean isCorrect(String userName, String password) {
	    boolean status = false;
	    try {
            Connection con = MySQLConnUtils.getMySQLConnection();
            PreparedStatement ps = con.prepareStatement("Select * from account where username = ? and password =?");
            ps.setString(1, userName);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return status;
	}
	
}
