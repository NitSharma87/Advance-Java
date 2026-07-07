package com.rays.bean;

import java.util.Date;

public class UserBean {
	private int id;
	private String firstName;
	private String lastName;
	private String login;
	private String password;
	private Date dob;
	private String address;
	private String gender;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public  UserBean(String firstName, String lastName, String login, String password, Date dob, String address, String gender) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
		this.dob = dob;
		this.address = address;
		this.gender=gender;
	}

}
