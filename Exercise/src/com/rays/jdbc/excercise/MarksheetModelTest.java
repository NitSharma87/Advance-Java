package com.rays.jdbc.excercise;

import java.sql.SQLException;

public class MarksheetModelTest {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	testAdd();
	
}
public static void testAdd() throws ClassNotFoundException, SQLException {
	MarksheetModel model=new MarksheetModel();
	MarksheetBean bean=new MarksheetBean(1, "101","Nitin",  74, 65, 88);
model.add(bean);

}
}
