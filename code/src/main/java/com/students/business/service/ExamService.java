package com.students.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.data.entity.Exam;
import com.students.data.repository.ExamJpaRepository;

@Service
public class ExamService {
	@Autowired
	ExamJpaRepository examJpaRepository;

	public Exam getExamById(int examId) {
		return examJpaRepository.findByExamId(examId);
	}

}
