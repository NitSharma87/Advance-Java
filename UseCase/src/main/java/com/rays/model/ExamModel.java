package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.ExamBean;
import com.rays.utility.JDBCDataSource;

public class ExamModel extends ExamBean {

	public void add(ExamBean ex) throws ClassNotFoundException, SQLException {
int pk=nextPk();
		Connection conn = JDBCDataSource.getConnection();
		String sql = "insert into exam values(?,?,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		
		
		pst.setInt(1, pk);
		pst.setString(2, ex.getRollNo());
		pst.setString(3, ex.getSubjectName());
		pst.setString(4, ex.getExamDate());
		pst.setInt(5, ex.getTotalMarks());
		pst.setInt(6, ex.getPassingMarks());
		pst.executeUpdate();

	}

	public void update(ExamBean ex) throws ClassNotFoundException, SQLException {
		Connection conn = JDBCDataSource.getConnection();
		String sql = "update exam set SUBJECT_NAME=? AND EXAM_DATE=? AND TOTAL_MARKS=? AND PASSING_MARKS=? where ExamId=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, ex.getExamId());
		pst.setString(2, ex.getSubjectName());
		pst.setString(3, ex.getExamDate());
		pst.setInt(4, ex.getTotalMarks());
		pst.setInt(5, ex.getPassingMarks());
		pst.executeUpdate();
	}

	public  void delete(int examId) throws ClassNotFoundException, SQLException {
		Connection conn = JDBCDataSource.getConnection();
		String sql = "delete from exam  where ID=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		
		pst.setInt(1,examId);

		pst.executeUpdate();
	}

	public ExamBean get(int examId) throws ClassNotFoundException, SQLException {
		ExamBean bean = null;
		Connection conn = JDBCDataSource.getConnection();
		String sql = "select * from exam  where ExamId=?";
		PreparedStatement pst = conn.prepareStatement(sql);

		pst.setInt(1, examId);

		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			bean = new ExamBean();
			bean.setExamId(rs.getInt(1));
			bean.setSubjectName(rs.getString(2));
			bean.setExamDate(rs.getString(3));
			bean.setTotalMarks(rs.getInt(4));
			bean.setPassingMarks(rs.getInt(5));

		}

		return bean;
	}

	/*
	 * public List getAllRecord() throws ClassNotFoundException, SQLException {
	 * ExamBean bean = null; List list = new ArrayList<>();
	 * 
	 * Connection conn = JDBCDataSource.getConnection(); String sql =
	 * "select * from exam "; PreparedStatement pst = conn.prepareStatement(sql);
	 * ResultSet rs = pst.executeQuery();
	 * 
	 * while (rs.next()) { bean = new ExamBean(); bean.setExamId(rs.getInt(1));
	 * bean.setSubjectName(rs.getString(2)); bean.setExamDate(rs.getString(3));
	 * bean.setTotalMarks(rs.getInt(4)); bean.setPassingMarks(rs.getInt(5));
	 * 
	 * }
	 * 
	 * return list; }
	 */
	public int nextPk() throws ClassNotFoundException, SQLException {
		int pk=0;
		Connection conn = JDBCDataSource.getConnection(); 
		String sql = "select max(ID) from exam"; 
		PreparedStatement pst = conn.prepareStatement(sql);
				  ResultSet rs = pst.executeQuery();
				  
				 while(rs.next()) {
					 pk=rs.getInt(1);
				 } 
				 
		
		return pk+1;
		
	}
	
	
}
