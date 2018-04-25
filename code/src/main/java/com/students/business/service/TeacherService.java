package com.students.business.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.data.entity.Report;
import com.students.data.entity.Teacher;
import com.students.data.repository.TeacherJpaRepository;

@Service
public class TeacherService {
	@Autowired
	TeacherJpaRepository teacherJpaRepository;
	ReportGenerator reportGenerator = null;
	public void factoryMethod(String type, String name) {
		if (type.equals("student")) {
			reportGenerator = new ReportStudents(type);
		}
		if (type.equals("teacher")) {
			reportGenerator = new ReportTeachers(type);
		}
		reportGenerator.getReport(name);
	}

	public Teacher getTeacherByName(String teacherName) {
		return teacherJpaRepository.findByTeacherName(teacherName);

	}

}
