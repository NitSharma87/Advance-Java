package com.rays.test.model;

import java.sql.SQLException;

import com.rays.model.UserModel;

public class UserModelTest {
	static final UserModel model=new UserModel();
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	testNextPK();
		
	
}
public static void testNextPK() throws ClassNotFoundException, SQLException {
	int pk=model.nextPK();
	System.out.println(pk);
}
}
