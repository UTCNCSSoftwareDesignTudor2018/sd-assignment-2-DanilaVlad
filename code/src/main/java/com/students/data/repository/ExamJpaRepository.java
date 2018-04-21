package com.students.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.students.data.entity.Exam;

@Repository
public interface ExamJpaRepository extends JpaRepository<Exam, Integer> {
	public Exam findByExamId(Integer examId);

}
