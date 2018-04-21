package com.students.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.students.data.entity.Course;
import com.students.data.entity.Exam;
import com.students.data.entity.Student;

@Repository
public interface StudentJpaRepository extends JpaRepository<Student, Integer> {

	public Student findByStudentName(String studentName);

	public Student save(Student student);

	public Student findByStudentId(int studentId);

	@Query("SELECT s.courses FROM Student s WHERE s.studentId = :studentId")
	public List<Course> findAllCoursesByStudentId(@Param("studentId") Integer id);

	@Query("SELECT s.exams FROM Student s WHERE s.studentId = :studentId")
	public List<Exam> findAllExamsByStudentId(@Param("studentId") Integer id);

}
