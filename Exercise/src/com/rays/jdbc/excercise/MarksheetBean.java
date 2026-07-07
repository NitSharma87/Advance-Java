package com.rays.jdbc.excercise;

public class MarksheetBean {
	private int id;
	private String rollNo;
	private String name;
	private int physics;
	private int chemistry;
	private int maths;

	public MarksheetBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MarksheetBean(int id, String rollNo, String name, int physics, int chemistry, int maths) {
		super();
		this.id = id;
		this.rollNo = rollNo;
		this.name = name;
		this.physics = physics;
		this.chemistry = chemistry;
		this.maths = maths;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhysics() {
		return physics;
	}

	public void setPhysics(int physics) {
		this.physics = physics;
	}

	public int getChemistry() {
		return chemistry;
	}

	public void setChemistry(int chemistry) {
		this.chemistry = chemistry;
	}

	public int getMaths() {
		return maths;
	}

	public void setMaths(int maths) {
		this.maths = maths;
	}

}
