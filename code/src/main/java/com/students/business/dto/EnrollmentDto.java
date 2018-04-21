package com.students.business.dto;

import com.students.data.entity.Course;
import com.students.data.entity.Exam;
import com.students.data.entity.Student;

public class EnrollmentDto {
	private Student student;
	private Course course;
	private Exam exam;

	public EnrollmentDto() {

	}

	public EnrollmentDto(Student student, Course course, Exam exam) {
		super();
		this.student = student;
		this.course = course;
		this.exam = exam;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

}
