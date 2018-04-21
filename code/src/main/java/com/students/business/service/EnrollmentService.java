package com.students.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.business.dto.EnrollmentDto;
import com.students.data.entity.Enrollment;
import com.students.data.entity.Exam;
import com.students.data.repository.EnrollmentJpaRepository;

@Service
public class EnrollmentService {
	@Autowired
	EnrollmentJpaRepository enrollmentJpaRepository;

	public String createEnrollment(EnrollmentDto enrollmentDto) {
		Enrollment enrollment = new Enrollment();
		enrollment.setCourse(enrollmentDto.getCourse());
		enrollment.setStudent(enrollmentDto.getStudent());
		enrollment.setExam(enrollmentDto.getExam());
		Enrollment enrollmentRes = enrollmentJpaRepository.save(enrollment);
		return "Id: " + enrollmentRes.getEnrollmentId().toString() + "\n Course: "
				+ enrollmentRes.getCourse().getCourseName() + "\n Student: "
				+ enrollmentRes.getStudent().getStudentName();
	}

	public Enrollment getEnrollmentById(int enrollmentId) {
		return enrollmentJpaRepository.findByEnrollmentId(enrollmentId);
	}

	public void deleteEnrollment(Integer id) {
		enrollmentJpaRepository.deleteById(id);
	}

	public void updateExam(Enrollment enrollment, Exam exam) {
		enrollment.setExam(exam);
		enrollmentJpaRepository.save(enrollment);
	}
}
