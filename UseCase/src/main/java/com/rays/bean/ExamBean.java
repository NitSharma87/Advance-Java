package com.rays.bean;

public class ExamBean {
private int examId;
private String rollNo;
private String subjectName;
private String examDate;
private int totalMarks;
private int passingMarks;
public ExamBean() {
	super();
	
}

public int getExamId() {
	return examId;
}
public void setExamId(int examId) {
	this.examId = examId;
}
public String getSubjectName() {
	return subjectName;
}
public void setSubjectName(String subjectName) {
	this.subjectName = subjectName;
}
public String getExamDate() {
	return examDate;
}
public void setExamDate(String examDate) {
	this.examDate = examDate;
}
public int getTotalMarks() {
	return totalMarks;
}
public void setTotalMarks(int totalMarks) {
	this.totalMarks = totalMarks;
}
public int getPassingMarks() {
	return passingMarks;
}
public void setPassingMarks(int passingMarks) {
	this.passingMarks = passingMarks;
}

public String getRollNo() {
	return rollNo;
}

public void setRollNo(String rollNo) {
	this.rollNo = rollNo;
}

public ExamBean(int examId, String rollNo, String subjectName, String examDate, int totalMarks, int passingMarks) {
	super();
	this.examId = examId;
	this.rollNo = rollNo;
	this.subjectName = subjectName;
	this.examDate = examDate;
	this.totalMarks = totalMarks;
	this.passingMarks = passingMarks;
}




}
