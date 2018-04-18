package com.students.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "students")

public class Student {

	@Id
	@Column
	@SequenceGenerator(name = "my_seq", sequenceName = "student_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq")
	private int studentId;
	@Column
	private String studentName;
	@Column
	private String studentCardNr;
	@Column
	private String studentPersonalCode;
	@Column
	private String studentAddress;
	@Column
	private String studentGroup;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
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
		return "Id: " + studentId + "\n" + "Name: " + studentName + "\n" + "Card number: " + studentCardNr + "\n"
				+ "Personal code: " + studentPersonalCode + "\n" + "Address: " + studentAddress + "\n" + "Group: "
				+ studentGroup;
	}

}
