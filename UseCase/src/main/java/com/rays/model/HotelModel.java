package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.HotelBean;
import com.rays.utility.JDBCDataSource;

public class HotelModel {
	public long nextPK() throws Exception {

	    long pk = 0;

	    Connection conn = JDBCDataSource.getConnection();

	    PreparedStatement ps = conn.prepareStatement("SELECT MAX(hotelId) FROM hotel");

	    ResultSet rs = ps.executeQuery();

	    while (rs.next()) {
	        pk = rs.getLong(1);
	    }

	    rs.close();
	    ps.close();
	    conn.close();

	    return pk + 1;
	}
	public void add(HotelBean bean) throws Exception {

	    Connection conn = JDBCDataSource.getConnection();

	    PreparedStatement ps = conn.prepareStatement(
	            "INSERT INTO hotel VALUES(?,?,?,?,?)");

	    ps.setLong(1, nextPK());
	    ps.setString(2, bean.getHotelName());
	    ps.setString(3, bean.getLocation());
	    ps.setDouble(4, bean.getRating());
	    ps.setString(5, bean.getContactNo());

	    ps.executeUpdate();

	    ps.close();
	    conn.close();
	}
	public void update(HotelBean bean) throws Exception {

	    Connection conn = JDBCDataSource.getConnection();

	    PreparedStatement ps = conn.prepareStatement(
	            "UPDATE hotel SET hotelName=?,location=?,rating=?,contactNo=? WHERE hotelId=?");

	    ps.setString(1, bean.getHotelName());
	    ps.setString(2, bean.getLocation());
	    ps.setDouble(3, bean.getRating());
	    ps.setString(4, bean.getContactNo());
	    ps.setLong(5, bean.getHotelId());

	    ps.executeUpdate();

	    ps.close();
	    conn.close();
	}
	public void delete(long hotelId) throws Exception {

	    Connection conn = JDBCDataSource.getConnection();

	    PreparedStatement ps = conn.prepareStatement(
	            "DELETE FROM hotel WHERE hotelId=?");

	    ps.setLong(1, hotelId);

	    ps.executeUpdate();

	    ps.close();
	    conn.close();
	}
	
	public HotelBean findByPK(long hotelId) throws Exception {

	    HotelBean bean = null;

	    Connection conn = JDBCDataSource.getConnection();

	    PreparedStatement ps = conn.prepareStatement(
	            "SELECT * FROM hotel WHERE hotelId=?");

	    ps.setLong(1, hotelId);

	    ResultSet rs = ps.executeQuery();

	    if (rs.next()) {

	        bean = new HotelBean();

	        bean.setHotelId(rs.getLong("hotelId"));
	        bean.setHotelName(rs.getString("hotelName"));
	        bean.setLocation(rs.getString("location"));
	        bean.setRating(rs.getDouble("rating"));
	        bean.setContactNo(rs.getString("contactNo"));
	    }

	    rs.close();
	    ps.close();
	    conn.close();

	    return bean;
	}
	public List<HotelBean> search(HotelBean bean) throws Exception {

	    List<HotelBean> list = new ArrayList<>();

	    StringBuffer sql = new StringBuffer("SELECT * FROM hotel WHERE 1=1");

	    if (bean != null) {

	        if (bean.getHotelName() != null && bean.getHotelName().length() > 0) {
	            sql.append(" AND hotelName LIKE '" + bean.getHotelName() + "%'");
	        }

	        if (bean.getLocation() != null && bean.getLocation().length() > 0) {
	            sql.append(" AND location LIKE '" + bean.getLocation() + "%'");
	        }
	    }

	    Connection conn = JDBCDataSource.getConnection();

	    PreparedStatement ps = conn.prepareStatement(sql.toString());

	    ResultSet rs = ps.executeQuery();

	    while (rs.next()) {

	        HotelBean b = new HotelBean();

	        b.setHotelId(rs.getLong("hotelId"));
	        b.setHotelName(rs.getString("hotelName"));
	        b.setLocation(rs.getString("location"));
	        b.setRating(rs.getDouble("rating"));
	        b.setContactNo(rs.getString("contactNo"));

	        list.add(b);
	    }

	    rs.close();
	    ps.close();
	    conn.close();

	    return list;
	}
	
	
}
