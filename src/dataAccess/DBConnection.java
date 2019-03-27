package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection() throws SQLException{
		Connection myCon;
		 myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","Steaua2586-");
		return myCon;
	}
}
