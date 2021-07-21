package jdbc.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {

	//Connection
	public static void close(Connection conn) {
		
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} 
	
	
	//Statement, PreparedStatement  =>상속관계이기때문에 다형성으로 하나만 닫으면된다.
	public static void close(Statement stmt) {
		
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	} //오버로딩
		
	
	
	
	
	//ResultSet
	public static void close(ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} 
	
	
}
