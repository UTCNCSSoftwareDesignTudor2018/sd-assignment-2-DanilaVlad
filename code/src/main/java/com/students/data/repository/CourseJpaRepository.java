package com.students.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.students.data.entity.Course;

@Repository
public interface CourseJpaRepository extends JpaRepository<Course, Integer> {

	public Course findByCourseId(Integer id);

	@Query("SELECT c FROM Course c WHERE c.teachersTeacherId = :teachersTeacherId")
	public List<Course> findAllCourses(@Param("teachersTeacherId") Integer id);

	@Query("SELECT c.students FROM Course c WHERE c.courseId = :courseId")
	public List<Course> findAllStudentsByCourseId(@Param("courseId") Integer id);
}
