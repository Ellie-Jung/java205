package guest.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	
	public static Connection getConnection() throws SQLException {
		
													//스키마 이름?
		String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
		String user="bit";
		String pw="bit";
		
		Connection conn=null;
		
		conn= DriverManager.getConnection(jdbcUrl, user, pw); //예외 던지기 
		
		return conn;
	}
}
