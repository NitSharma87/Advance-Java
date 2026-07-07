package com.rays.jdbc.excercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDataSource {
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/demo";
		Connection conn = DriverManager.getConnection(url, "root", "root");
		System.out.println(conn);
		return conn;
	
		
	
	
	
	
	}
}
