package com.students.data.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {
	@Id
	@Column
	@SequenceGenerator(name = "my_seq3", sequenceName = "courses_course_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq3")
	private int courseId;

	@Column
	private String courseName;

	@Column
	private int teachersTeacherId;

	@ManyToOne
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;

	@ManyToMany(mappedBy = "courses")
	private List<Student> students;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "enrollments", joinColumns = { @JoinColumn(name = "coursesCourseId") }, inverseJoinColumns = {
			@JoinColumn(name = "examsExamId") })
	List<Course> exams;

	public Course() {
	}

	public Course(int courseId) {
		super();
		this.courseId = courseId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public int getTeachersTeacherId() {
		return teachersTeacherId;
	}

	public void setTeachersTeacherId(int teachersTeacherId) {
		this.teachersTeacherId = teachersTeacherId;
	}

	@Override
	public String toString() {
		return "Course id: " + courseId + " Name: " + courseName;
	}

}
