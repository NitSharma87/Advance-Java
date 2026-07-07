package com.rays.model.test;

import java.sql.SQLException;

import com.rays.bean.MarksheetBean;
import com.rays.model.MarksheetModel;

public class MarksheetTest {
	static final MarksheetModel model = new MarksheetModel();

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//testAdd();
		// testUpdate();
		//testDelete();
		//testfindByRollNo();
		testfindByPK();
	}

	public static void testAdd() throws ClassNotFoundException, SQLException {

		MarksheetBean bean = new MarksheetBean("131", "nitin", 55, 74, 89);
		model.add(bean);

	}

	public static void testUpdate() throws ClassNotFoundException, SQLException {

		MarksheetBean bean = new MarksheetBean();
		bean.setRollNo("131");
		bean.setName("ram");
		bean.setPhysics(74);
		bean.setChemistry(85);
		bean.setMaths(65);
		model.update(bean);

	}

	public static void testDelete() throws ClassNotFoundException, SQLException {

		MarksheetBean bean = new MarksheetBean();
		bean.setRollNo("131");
		model.delete(bean);

	}

	public static void testfindByRollNo() throws ClassNotFoundException, SQLException {
		MarksheetBean bean = new MarksheetBean();
		bean.setRollNo("130");
		model.findByRollNo(bean);
		System.out.println("Student RollNo: " + bean.getRollNo());
		System.out.println("Student Name: " + bean.getName());
		System.out.println("Physics Marks: " + bean.getPhysics());
		System.out.println("Chemisty Marks: " + bean.getChemistry());
		System.out.println("Maths Marks: " + bean.getMaths());

	}
	public static void testfindByPK() throws ClassNotFoundException, SQLException {
		MarksheetBean bean = new MarksheetBean();
		bean.setId(5);
		model.findByPK(bean);
		System.out.println("Student RollNo: " + bean.getRollNo());
		System.out.println("Student Name: " + bean.getName());
		System.out.println("Physics Marks: " + bean.getPhysics());
		System.out.println("Chemisty Marks: " + bean.getChemistry());
		System.out.println("Maths Marks: " + bean.getMaths());

	}
}
