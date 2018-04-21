package com.students.data.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "exams")
public class Exam {
	@Id
	@Column
	@SequenceGenerator(name = "my_seq4", sequenceName = "exams_exam_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq4")
	private int examId;

	@Column
	private int examGrade;

	@ManyToMany(mappedBy = "exams", fetch = FetchType.EAGER)
	private List<Student> students;

	@ManyToMany(mappedBy = "exams", fetch = FetchType.EAGER)
	private List<Course> courses;

	@OneToMany(mappedBy = "exam", fetch = FetchType.EAGER)
	private List<Enrollment> enrollments;

	public Exam() {

	}

	public Exam(int examId) {
		super();
		this.examId = examId;
	}

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public int getExamGrade() {
		return examGrade;
	}

	public void setExamGrade(int examGrade) {
		this.examGrade = examGrade;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return courses + " Grade=" + examGrade + "\n";
	}

}
