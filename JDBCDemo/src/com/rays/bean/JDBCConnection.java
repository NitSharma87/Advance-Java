package com.rays.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JDBCConnection {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		ResourceBundle rb=ResourceBundle.getBundle("com.rays.bundle.system");
		Class.forName(rb.getString("driver"));
		String url = rb.getString("url");
		String userName=rb.getString("userName");
		String pass=rb.getString("password");
		Connection conn = DriverManager.getConnection(url, userName,pass);

		return conn;
	}

	
	
	
	
	
}
