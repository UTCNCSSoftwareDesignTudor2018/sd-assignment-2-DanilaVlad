package com.students.data.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "teachers")
public class Teacher {
	@Id
	@Column
	@SequenceGenerator(name = "my_seq2", sequenceName = "teachers_teacher_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq2")
	private int teacherId;
	@Column
	private String teacherName;
	@Column
	private String teacherAddress;

	@OneToMany(mappedBy = "teacher", fetch = FetchType.EAGER)
	private List<Course> courses;

	public List<Course> getCourses() {
		return courses;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherAddress() {
		return teacherAddress;
	}

	public void setTeacherAddress(String teacherAddress) {
		this.teacherAddress = teacherAddress;
	}

	@Override
	public String toString() {
		return "Id: " + teacherId + "\nName: " + teacherName + "\nAddress: " + teacherAddress;
	}

}
