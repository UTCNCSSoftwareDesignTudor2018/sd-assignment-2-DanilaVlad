package com.students.business.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.data.entity.Report;
import com.students.data.entity.Teacher;

@Service
public class ReportTeachers implements ReportGenerator {
	
	private Report report;
	@Autowired
	TeacherService teacherService;

	public ReportTeachers() {

	}

	public ReportTeachers(String report) {
		super();
		this.report = new Report(report);
	}

	@Override
	public void getReport(String teacherName) {
		Teacher teacher = teacherService.getTeacherByName(teacherName);
			this.report = new Report(teacher.getTeacherName().toString() + " " + teacher.getTeacherAddress().toString());
	}

}
