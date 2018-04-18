package com.students.business.dto;


public class StudentDto {
	
	private String studentName;
	private String studentCardNr;
	private String studentPersonalCode;
	private String studentAddress;
	private String studentGroup;
	
	
	public StudentDto(String studentName, String studentCardNr, String studentPersonalCode, String studentAddress,
			String studentGroup) {
		super();
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
	
	@Override
	public String toString() {
		return "StudentDto [ studentName=" + studentName + ", studentCardNr="
				+ studentCardNr + ", studentPersonalCode=" + studentPersonalCode + ", studentAddress=" + studentAddress
				+ ", studentGroup=" + studentGroup + "]";
	}
	
	
}
