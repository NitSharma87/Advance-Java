package com.rays.model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

import com.rays.bean.JDBCConnection;

public class TransactionDemo {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Connection conn=null;
	try {	conn=JDBCConnection.getConnection();
conn.setAutoCommit(false);
Statement stmt=conn.createStatement();

int i = stmt.executeUpdate(
		"insert into employee values(31, 'Suresh', 'infotech',84000)");

i = stmt.executeUpdate(
		"insert into employee values(32, 'ramesh', 'infograin',73000)");

i = stmt.executeUpdate(
		"insert into employee values(33, 'vijay', 'linkinfo',96000)");

conn.commit();
System.out.println("transaction complited:(records saved)");

conn.close();
}catch (Exception e) {
	conn.rollback();
	e.printStackTrace();
}



}
}
