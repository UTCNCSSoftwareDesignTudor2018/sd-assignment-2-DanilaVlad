package com.students.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.business.dto.StudentDto;
import com.students.data.entity.Student;
import com.students.data.repository.StudentJpaRepository;

@Service
public class StudentService {

	@Autowired
	StudentJpaRepository studentJpaRepository;

	public Student getStudentByName(String studentName) {
		return studentJpaRepository.findByStudentName(studentName);
	}

	public Student getStudentById(int studentId) {
		return studentJpaRepository.findByStudentId(studentId);
	}

	public void createStudent(StudentDto studentDto) {
		Student student = new Student();
		student.setStudentName(studentDto.getStudentName());
		student.setStudentCardNr(studentDto.getStudentCardNr());
		student.setStudentPersonalCode(studentDto.getStudentPersonalCode());
		student.setStudentAddress(studentDto.getStudentAddress());
		student.setStudentGroup(studentDto.getStudentGroup());
		studentJpaRepository.save(student);
	}

	public void updateGroup(int studentId, String group) {
		Student student = studentJpaRepository.findByStudentId(studentId);
		student.setStudentGroup(group);
		studentJpaRepository.save(student);
	}

}
