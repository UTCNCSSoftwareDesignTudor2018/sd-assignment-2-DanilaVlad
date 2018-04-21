package com.students.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.business.dto.CourseDto;
import com.students.data.entity.Course;
import com.students.data.entity.Student;
import com.students.data.repository.CourseJpaRepository;
import com.students.data.repository.StudentJpaRepository;
import com.students.data.repository.TeacherJpaRepository;

@Service
public class CourseService {

	@Autowired
	CourseJpaRepository courseJpaRepository;
	@Autowired
	StudentJpaRepository studentJpaRepository;
	@Autowired
	TeacherJpaRepository teacherJpaRepository;

	public Course findById(Integer id) {
		return courseJpaRepository.findByCourseId(id);
	}

	public List<Course> getCourses(int teacherId) {
		List<Course> courses = courseJpaRepository.findAllCourses(teacherId);
		return courses;
	}

	public List<Course> findCoursesForStudent(Student student) {
		List<Course> courses = studentJpaRepository.findAllCoursesByStudentId(student.getStudentId());
		return courses;
	}

	public List<Course> setCourseId(CourseDto courseDto) {
		Course course = new Course();
		course.setCourseId(courseDto.getCourseId());
		return courseJpaRepository.findAllStudentsByCourseId(course.getCourseId());
	}

}
