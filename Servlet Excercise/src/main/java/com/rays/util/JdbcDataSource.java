package com.rays.util;

import java.sql.Statement;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JdbcDataSource {

	private static JdbcDataSource jds = null;
	private ComboPooledDataSource ds = null;

	private JdbcDataSource() {

		try {
			ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.system");
			ds = new ComboPooledDataSource();
			ds.setDriverClass(rb.getString("driver"));
			ds.setJdbcUrl(rb.getString("url"));
			ds.setUser(rb.getString("userName"));
			ds.setPassword(rb.getString("password"));
			ds.setInitialPoolSize(Integer.parseInt(rb.getString("initialPoolSize")));
			ds.setAcquireIncrement(Integer.parseInt(rb.getString("acquireIncrement")));
			ds.setMaxPoolSize(Integer.parseInt(rb.getString("maxPoolSize")));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static JdbcDataSource getInstance() {
		if (jds == null) {
			jds = new JdbcDataSource();

		}
		return jds;
	}

	public static Connection getConnection() {
		try {
			return getInstance().ds.getConnection();
		} catch (Exception e) {
			return null;
		}
	}

	public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				rs.close();
			if (conn != null)
				rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeConnection(Connection conn, Statement stmt) {
		closeConnection(conn, stmt, null);
	}

	public static void closeConnection(Connection conn) {
		closeConnection(conn, null, null);
	}

}
