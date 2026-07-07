package com.rays.jdbc.excercise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MarksheetModel {
	public void add(MarksheetBean bean) throws SQLException, ClassNotFoundException {
		Connection conn = JDBCDataSource.getConnection();

		String sql = "insert into marksheet values(?,?,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, bean.getId());
		pst.setString(2, bean.getRollNo());
		pst.setString(3, bean.getName());
		pst.setInt(4, bean.getPhysics());
		pst.setInt(5, bean.getChemistry());
		pst.setInt(6, bean.getMaths());
		int record = pst.executeUpdate();

		if (record > 0) {
			System.out.println("Record Successfully");
		} else {
			System.out.println("Something Missing");
		}
	}
	
	public void update(MarksheetBean bean) throws ClassNotFoundException, SQLException {
		Connection conn=JDBCDataSource.getConnection();
		String sql="update marksheet set ";
	}
	
	
	
	
	
}
