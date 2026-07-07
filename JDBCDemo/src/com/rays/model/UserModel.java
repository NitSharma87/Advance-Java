package com.rays.model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.JDBCConnection;
import com.rays.bean.UserBean;

public class UserModel {
	public int nextPK() throws ClassNotFoundException, SQLException {
		int pk = 0;
		Connection conn = JDBCConnection.getConnection();
		String sql = "select max(id) from user";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);

		}
		return pk + 1;

	}

	public void add(UserBean bean) throws ClassNotFoundException, SQLException {
		Connection conn = JDBCConnection.getConnection();
		String sql = "insert into user values(?,?,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, nextPK());
		pst.setString(2, bean.getFirstName());
		pst.setString(3, bean.getLastName());
		pst.setString(4, bean.getLogin());
		pst.setString(5, bean.getPassword());
		pst.setDate(6, new java.sql.Date(bean.getDob().getTime()));

		int record = pst.executeUpdate();

		if (record > 0) {
			System.out.println("Record inserted ");
		} else {
			System.out.println("Somthing Wrong");
		}

	}

	public void update(UserBean bean) throws ClassNotFoundException, SQLException {
		Connection conn = JDBCConnection.getConnection();
		String sql = "update user set firstName=?,lastName=?,login=?,password=?, dob=? where id=?";
		PreparedStatement pst = conn.prepareStatement(sql);

		pst.setString(1, bean.getFirstName());
		pst.setString(2, bean.getLastName());
		pst.setString(3, bean.getLogin());
		pst.setString(4, bean.getPassword());
		pst.setDate(5, new java.sql.Date(bean.getDob().getTime()));
		pst.setInt(6, bean.getId());

		int record = pst.executeUpdate();

		if (record > 0) {
			System.out.println("Record Updated ");
		} else {
			System.out.println("Somthing Wrong");
		}

	}

	public void delete(UserBean bean) throws ClassNotFoundException, SQLException {
		Connection conn = JDBCConnection.getConnection();
		String sql = "delete from user where id=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, bean.getId());

		int record = pst.executeUpdate();

		if (record > 0) {
			System.out.println("Record deleted ");
		} else {
			System.out.println("Somthing Wrong");
		}

	}

	public UserBean findByLogin(String login) throws ClassNotFoundException, SQLException {
		UserBean bean =null; 
		Connection conn = JDBCConnection.getConnection();
		String sql = "select * from user where login=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, login);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			bean=new UserBean();
			bean.setFirstName(rs.getString("firstName"));
			bean.setLastName(rs.getString("lastName"));
			bean.setLogin(rs.getString("login"));
			bean.setPassword(rs.getString("password"));
			bean.setDob(rs.getDate("dob"));

		}
		return bean;
	}

	public UserBean findByPK(int id) throws ClassNotFoundException, SQLException {
		UserBean bean = new UserBean();
		Connection conn = JDBCConnection.getConnection();
		String sql = "select * from user where id=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			bean.setFirstName(rs.getString("firstName"));
			bean.setLastName(rs.getString("lastName"));
			bean.setLogin(rs.getString("login"));
			bean.setPassword(rs.getString("password"));
			bean.setDob(rs.getDate("dob"));

		}
		return bean;
	}

	public List<UserBean> search(UserBean bean) throws ClassNotFoundException, SQLException {

	    Connection conn = JDBCConnection.getConnection();

	    StringBuffer sql = new StringBuffer("select * from user where 1=1");

	    if (bean != null) {

	        if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
	            sql.append(" and firstName like '" + bean.getFirstName() + "%'");
	        }

	        if (bean.getLastName() != null && bean.getLastName().length() > 0) {
	            sql.append(" and lastName like '" + bean.getLastName() + "%'");
	        }
	    }

	    System.out.println("sql ===> " + sql);

	    PreparedStatement pst = conn.prepareStatement(sql.toString());

	    ResultSet rs = pst.executeQuery();

	    List<UserBean> list = new ArrayList<UserBean>();

	    while (rs.next()) {

	        UserBean ub = new UserBean();

	        ub.setId(rs.getInt("id"));
	        ub.setFirstName(rs.getString("firstName"));
	        ub.setLastName(rs.getString("lastName"));
	        ub.setLogin(rs.getString("login"));
	        ub.setPassword(rs.getString("password"));
	        ub.setDob(rs.getDate("dob"));

	        list.add(ub);
	    }

	    return list;
	}
	public UserBean authenticate(String login, String password) throws ClassNotFoundException, SQLException {
		UserBean bean = null;
		Connection conn = JDBCConnection.getConnection();
		String sql = "select * from user where login=? and password=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, login);
		pst.setString(2, password);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
		bean=	new UserBean();
			bean.setFirstName(rs.getString("firstName"));
			bean.setLastName(rs.getString("lastName"));
			bean.setLogin(rs.getString("login"));
			bean.setPassword(rs.getString("password"));
			bean.setDob(rs.getDate("dob"));

		}
		return bean;
	}

}
