package com.students.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "enrollments")
public class Enrollment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "enrollment_id", updatable = false, nullable = false)
	private Integer enrollmentId;

	@ManyToOne
	@JoinColumn(name = "studentsStudentId")
	private Student student;

	@ManyToOne
	@JoinColumn(name = "coursesCourseId")
	private Course course;

	@ManyToOne
	@JoinColumn(name = "examsExamId")
	private Exam exam;

	public Enrollment() {

	}

	public Enrollment(Student student, Course course, Exam exam) {
		super();
		this.student = student;
		this.course = course;
		this.exam = exam;
	}

	public Enrollment(Integer enrollmentId, Integer coursesCourseId, Student student, Course course) {
		this.enrollmentId = enrollmentId;
		this.student = student;
		this.course = course;
	}

	public Enrollment(Integer enrollmentId, Student student, Exam exam) {
		this.enrollmentId = enrollmentId;
		this.student = student;
		this.exam = exam;
	}

	public Integer getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(Integer enrollmentId) {
		this.enrollmentId = enrollmentId;
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

	@Override
	public String toString() {
		return "Id: " + enrollmentId + "\nStudent: " + student.getStudentName() + "\nCourse: " + course.getCourseName()
				+ "\nGrade: " + exam.getExamGrade();
	}

}