package com.students.business.service;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.data.entity.Report;
import com.students.data.repository.TeacherJpaRepository;

@Service
public class ReportTeachers implements ReportGenerator {

	private Report report;
	@Autowired
	TeacherJpaRepository teacherJpaRepository;

	public ReportTeachers() {

	}

	public ReportTeachers(String report) {
		super();
		this.report = new Report(report);
	}

	@Override
	public void getReport() throws UnsupportedEncodingException, FileNotFoundException, IOException {
		String fileName = "Report" + ".doc";
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "utf-8"))) {
			this.report = new Report("Teacher report format");
		}

	}

}
