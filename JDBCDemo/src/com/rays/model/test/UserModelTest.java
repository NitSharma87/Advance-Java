package com.rays.model.test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;

public class UserModelTest {
	final static UserModel model = new UserModel();
	final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		// testNextPK();
        //testAdd();
		// testUpdate();
		// testFindByLogin();
		//testFindByPK();
		//testSearch();
		testAuthenticate();
	}

	public static void testSearch() throws ClassNotFoundException, SQLException {

	    UserBean bean = new UserBean();
	    bean.setFirstName("N");
	    bean.setLastName("S");
	    List<UserBean> list = model.search(bean);

	    Iterator<UserBean> it = list.iterator();

	    while (it.hasNext()) {

	        UserBean ub = it.next();

	        System.out.println("First Name : " + ub.getFirstName());
	        System.out.println("Last Name  : " + ub.getLastName());
	        System.out.println("Login      : " + ub.getLogin());
	        System.out.println("Password   : " + ub.getPassword());
	        System.out.println("DOB        : " + ub.getDob());
	        System.out.println("----------------------");
	    }
	}

	public static void testFindByPK() throws ClassNotFoundException, SQLException {
		UserBean bean = new UserBean();

		bean = model.findByPK(15);

		if (bean == null) {
			System.out.println("user not found");
		} else {

			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());

		}

	}

	public static void testFindByLogin() throws ClassNotFoundException, SQLException {
		UserBean bean = new UserBean();

		bean = model.findByLogin("krishna@gmail.com");

		if (bean == null) {
			System.out.println("user not found");
		} else {

			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());

		}

	}
	public static void testAuthenticate() throws ClassNotFoundException, SQLException {
		UserBean bean = new UserBean();

		bean = model.authenticate("krishna@gmail.com","1234");

		if (bean == null) {
			System.out.println("invalid login and password");
		} else {

			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());

		}

	}
	public static void testUpdate() throws ParseException, ClassNotFoundException, SQLException {
		Date dob = sdf.parse("2000-05-15");
		UserBean bean = new UserBean();
		bean.setFirstName("krishna");
		bean.setLastName("karma");
		bean.setLogin("krishna@gmail.com");
		bean.setPassword("1234");
		bean.setDob(dob);
		bean.setId(5);
		model.update(bean);
	}

	public static void testAdd() throws ParseException, ClassNotFoundException, SQLException {

		Date dob = sdf.parse("2000-05-15");
		UserBean bean = new UserBean("nitin", "sharma", "nit@gmail.com", "123", dob);
		model.add(bean);

	}

	public static void testNextPK() throws ClassNotFoundException, SQLException {
		System.out.println(model.nextPK());

	}

}
