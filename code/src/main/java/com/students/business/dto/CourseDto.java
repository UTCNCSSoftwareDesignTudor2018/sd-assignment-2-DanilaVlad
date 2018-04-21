package com.students.business.dto;

public class CourseDto {

	private int courseId;
	private String courseName;
	private int teachersTeacherId;

	public CourseDto(int courseId, String courseName, int teachersTeacherId) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.teachersTeacherId = teachersTeacherId;
	}

	public CourseDto() {

	}

	public CourseDto(int courseId) {
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

	public int getTeachersTeacherId() {
		return teachersTeacherId;
	}

	public void setTeachersTeacherId(int teachersTeacherId) {
		this.teachersTeacherId = teachersTeacherId;
	}

}
