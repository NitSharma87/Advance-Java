package com.rays.model.test;

import java.sql.SQLException;

import com.rays.bean.ExamBean;
import com.rays.model.ExamModel;

public class ExamModelTest {
	final static ExamModel model = new ExamModel();

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		testAdd();
		// testDelete();

	}

	public static void testAdd() throws ClassNotFoundException, SQLException {

		/*
		 * ExamBean bean = new ExamBean("114", "Java", "2025-05-28", 75, 33);
		 * model.add(bean);
		 */

	}

	public static void testUpdate() {

		ExamBean bean = new ExamBean();
		bean.setExamId(0);
	}

	public static void testDelete() throws ClassNotFoundException, SQLException {
		int examId = 112;

		model.delete(examId);
	}

}
