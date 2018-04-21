package com.students.business.service;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.data.entity.Report;
import com.students.data.entity.Student;
import com.students.data.entity.Teacher;
import com.students.data.repository.StudentJpaRepository;
import com.students.data.repository.TeacherJpaRepository;

@Service
public class TeacherService {
	@Autowired
	TeacherJpaRepository teacherJpaRepository;
	@Autowired
	StudentJpaRepository studentJpaRepository;

	Report report;
	ReportGenerator reportGenerator = null;

	public void factoryMethod(String type) throws UnsupportedEncodingException, FileNotFoundException, IOException {
		if (type.equals("txt")) {
			reportGenerator = new ReportStudents(type);
		}
		if (type.equals("doc")) {
			reportGenerator = new ReportTeachers(type);
		}
		reportGenerator.getReport();
	}

	public Teacher getTeacherByName(String teacherName) {
		return teacherJpaRepository.findByTeacherName(teacherName);

	}

}
