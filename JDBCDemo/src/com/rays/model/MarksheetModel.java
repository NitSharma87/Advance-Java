package com.rays.model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rays.bean.JDBCConnection;
import com.rays.bean.MarksheetBean;

public class MarksheetModel {

	public int nextPK() throws ClassNotFoundException, SQLException {
		int pk = 0;
		Connection conn = JDBCConnection.getConnection();
		String sql = "select max(id) from marksheet";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);

		}
		return pk + 1;

	}

	public void add(MarksheetBean bean) throws ClassNotFoundException, SQLException {

		Connection conn = JDBCConnection.getConnection();
		String sql = "insert into marksheet values(?,?,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);

		pst.setInt(1, nextPK());
		pst.setString(2, bean.getRollNo());
		pst.setString(3, bean.getName());
		pst.setInt(4, bean.getPhysics());
		pst.setInt(5, bean.getChemistry());
		pst.setInt(6, bean.getMaths());

		int record = pst.executeUpdate();
		System.out.println(record);
		if (record > 0) {
			System.out.println("Record inserted ");
		} else {
			System.out.println("Somthing Wrong");
		}

	}

	public void update(MarksheetBean bean) throws ClassNotFoundException, SQLException {
		Connection conn = JDBCConnection.getConnection();
		String sql = "update marksheet set name=?, physics=?,chemistry=?,maths=? where rollNo=?";
		PreparedStatement pst = conn.prepareStatement(sql);

		pst.setString(1, bean.getName());
		pst.setInt(2, bean.getPhysics());
		pst.setInt(3, bean.getChemistry());
		pst.setInt(4, bean.getMaths());
		pst.setString(5, bean.getRollNo());
		int record = pst.executeUpdate();
		System.out.println(record);
		if (record > 0) {
			System.out.println("Record updated ");
		} else {
			System.out.println("Somthing Wrong");
		}

	}

	public void delete(MarksheetBean bean) throws ClassNotFoundException, SQLException {
		Connection conn = JDBCConnection.getConnection();
		String sql = "delete from marksheet where rollNo=?";
		PreparedStatement pst = conn.prepareStatement(sql);

		pst.setString(1, bean.getRollNo());

		int record = pst.executeUpdate();
		System.out.println(record);
		if (record > 0) {
			System.out.println("Record deleted ");
		} else {
			System.out.println("Somthing Wrong");
		}

	}

	public void findByRollNo(MarksheetBean bean) throws ClassNotFoundException, SQLException {

		Connection conn = JDBCConnection.getConnection();
		String sql = "select * from marksheet where rollNo=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, bean.getRollNo());
		ResultSet rs = pst.executeQuery();

		while (rs.next()) {

			bean.setRollNo(rs.getString("rollNo"));

			bean.setName(rs.getString("name"));
			bean.setPhysics(rs.getInt("physics"));
			bean.setChemistry(rs.getInt("chemistry"));
			bean.setMaths(rs.getInt("maths"));

		}

	}

	public void findByPK(MarksheetBean bean) throws ClassNotFoundException, SQLException {

		Connection conn = JDBCConnection.getConnection();
		String sql = "select * from marksheet where id=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, bean.getId());
		ResultSet rs = pst.executeQuery();

		while (rs.next()) {

			bean.setRollNo(rs.getString("rollNo"));

			bean.setName(rs.getString("name"));
			bean.setPhysics(rs.getInt("physics"));
			bean.setChemistry(rs.getInt("chemistry"));
			bean.setMaths(rs.getInt("maths"));

		}

	}

}
