package com.students.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.students.business.dto.StudentDto;
import com.students.data.entity.Student;

@Repository
public interface StudentJpaRepository extends JpaRepository<Student, Integer> {

	public Student findByStudentName(String studentName);

	public Student save(Student student);

	public Student findByStudentId(int studentId);

}
