package com.students.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.students.data.entity.Teacher;

@Repository
public interface TeacherJpaRepository extends JpaRepository<Teacher, Integer> {
	public Teacher findByTeacherName(String teacherName);
}
