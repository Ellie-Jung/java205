package com.bitcamp.op.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	
	public static Connection getConnection() throws SQLException {
		
		//jdbcUrl
		String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
	//	String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/project?serverTimezone=UTC";
	//	String jdbcUrl = "jdbc:mysql://localhost:3306/mysql";
		String user= "bit";
		String pw= "bit";
		
		return DriverManager.getConnection(jdbcUrl, user, pw);
	}
	
}
