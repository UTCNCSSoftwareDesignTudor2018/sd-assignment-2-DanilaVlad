package com.students.business.dto;

public class StudentDto {

	private int studentId;
	private String studentName;
	private String studentCardNr;
	private String studentPersonalCode;
	private String studentAddress;
	private String studentGroup;

	public StudentDto() {

	}

	public StudentDto(int studentId) {
		super();
		this.studentId = studentId;
	}

	public StudentDto(String studentName, String studentCardNr, String studentPersonalCode, String studentAddress,
			String studentGroup) {
		this.studentName = studentName;
		this.studentCardNr = studentCardNr;
		this.studentPersonalCode = studentPersonalCode;
		this.studentAddress = studentAddress;
		this.studentGroup = studentGroup;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentCardNr() {
		return studentCardNr;
	}

	public void setStudentCardNr(String studentCardNr) {
		this.studentCardNr = studentCardNr;
	}

	public String getStudentPersonalCode() {
		return studentPersonalCode;
	}

	public void setStudentPersonalCode(String studentPersonalCode) {
		this.studentPersonalCode = studentPersonalCode;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public String getStudentGroup() {
		return studentGroup;
	}

	public void setStudentGroup(String studentGroup) {
		this.studentGroup = studentGroup;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

}
