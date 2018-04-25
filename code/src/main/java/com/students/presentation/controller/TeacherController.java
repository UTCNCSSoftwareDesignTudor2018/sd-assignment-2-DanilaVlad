package com.students.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.students.business.dto.CourseDto;
import com.students.business.dto.EnrollmentDto;
import com.students.business.service.CourseService;
import com.students.business.service.EnrollmentService;
import com.students.business.service.ExamService;
import com.students.business.service.StudentService;
import com.students.business.service.TeacherService;
import com.students.presentation.view.StudentView;
import com.students.presentation.view.TeacherView;

@Controller
public class TeacherController {

	private TeacherView teacherView;
	@Autowired
	StudentView studentView;
	@Autowired
	TeacherService teacherService;
	@Autowired
	CourseService courseService;
	@Autowired
	StudentService studentService;
	@Autowired
	ExamService examService;
	@Autowired
	EnrollmentService enrollmentService;

	public TeacherController(TeacherView teacherView, TeacherService teacherService) {
		this.teacherView = teacherView;
		teacherView.setTeacherViewInfoListener(new TeacherViewInfoListener());
		teacherView.setTeacherViewCourseListener(new TeacherViewCoursesListener());
		teacherView.setTeacherViewStudentsListener(new TeacherViewStudentsListener());
		teacherView.setTeacherEnrollListener(new TeacherEnrollListener());
		teacherView.setTeacherDeleteEnrollListener(new TeacherDeleteEnrollListener());
		teacherView.setTeacherUpdateEnrollListener(new TeacherUpdateEnrollListener());
		teacherView.setGenerateReportListener(new TeacherGenerateReportListener());
	}

	public void setTeacherView(TeacherView teacherView) {
		this.teacherView = teacherView;
	}

	private class TeacherViewInfoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == teacherView.viewTeacherInfoBtn) {
				String teacherName = "";
				teacherName = teacherView.teacherNameText.getText();
				teacherView.areaInfo.setText(teacherService.getTeacherByName(teacherName).toString());
			}
		}
	}

	private class TeacherViewCoursesListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == teacherView.viewTeacherCoursesBtn) {
				int teacherId = 0;
				teacherId = Integer.parseInt(teacherView.teacherIdText.getText());
				teacherView.areaInfo.setText(courseService.getCourses(teacherId).toString()
						.substring(1, courseService.getCourses(teacherId).toString().length() - 1).replace(",", "\n"));
			}
		}
	}

	private class TeacherViewStudentsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == teacherView.viewTeacherStudentsBtn) {
				int courseId = 0;
				courseId = Integer.parseInt(teacherView.courseIdText.getText());
				CourseDto courseDto = new CourseDto();
				courseDto.setCourseId(courseId);

				teacherView.areaInfo.setText(courseService.setCourseId(courseDto).toString()
						.substring(1, courseService.setCourseId(courseDto).toString().length() - 1).replace(",", "\n"));
			}
		}
	}

	private class TeacherEnrollListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == teacherView.createEnrollmentBtn) {
				int courseId = 0;
				int studentId = 0;
				courseId = Integer.parseInt(teacherView.courseEnrolIdText.getText());
				studentId = Integer.parseInt(teacherView.studentEnrolIdText.getText());
				EnrollmentDto enrollmentDto = new EnrollmentDto();

				enrollmentDto.setCourse(courseService.findById(courseId));
				enrollmentDto.setStudent(studentService.getStudentById(studentId));
				enrollmentDto.setExam(examService.getExamById(2));

				teacherView.areaInfo.setText(enrollmentService.createEnrollment(enrollmentDto));
			}
		}
	}

	private class TeacherDeleteEnrollListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == teacherView.deleteEnrollmentBtn) {
				int enrollId = 0;
				enrollId = Integer.parseInt(teacherView.enrollIdText.getText());
				teacherView.areaInfo
						.setText("Enrollment: " + enrollmentService.getEnrollmentById(enrollId) + " deleted");
				enrollmentService.deleteEnrollment(enrollId);
			}
		}
	}

	private class TeacherUpdateEnrollListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == teacherView.updateEnrollmentBtn) {
				int examId = 0;
				int enrollId = 0;
				examId = Integer.parseInt(teacherView.examIdText.getText());
				enrollId = Integer.parseInt(teacherView.enrollIdText.getText());
				enrollmentService.updateExam(enrollmentService.getEnrollmentById(enrollId),
						examService.getExamById(examId));
				teacherView.areaInfo.setText(enrollmentService.getEnrollmentById(enrollId) + "\nUpdated successfully!");
			}
		}
	}
	
	private class TeacherGenerateReportListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == teacherView.generateReportBtn) {
				String teacherName = "";
				teacherName = teacherView.teacherNameText.getText();
					teacherService.factoryMethod("teacher", teacherName);
				teacherView.areaInfo.setText("Teacher request generated in 'reportsCollection' collection\n from 'reports' mongoDB ");
			}
		}
	}


}
