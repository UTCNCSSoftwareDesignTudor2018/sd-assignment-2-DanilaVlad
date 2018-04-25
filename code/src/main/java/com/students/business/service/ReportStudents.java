package com.students.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.data.entity.Report;
import com.students.data.entity.Student;
import com.students.data.repository.StudentJpaRepository;

@Service
public class ReportStudents implements ReportGenerator {
	private Report report;
	@Autowired
	StudentJpaRepository studentJpaRepository;

	public ReportStudents() {

	}

	public ReportStudents(String report) {
		super();
		this.report = new Report(report);
	}

	@Override
	public void getReport(String studentName) {
		//Student student = studentJpaRepository.findByStudentName(studentName);
		//this.report = new Report(student.getStudentName() + " " + student.getStudentAddress());
	}
}
