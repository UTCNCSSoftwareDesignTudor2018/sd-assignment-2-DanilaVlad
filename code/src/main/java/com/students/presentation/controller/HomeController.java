package com.students.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.students.presentation.view.HomeView;
import com.students.presentation.view.StudentView;
import com.students.presentation.view.TeacherView;

@Controller
public class HomeController {

	@Autowired
	HomeView homeView;
	@Autowired
	TeacherView teacherView;
	@Autowired
	StudentView studentView;

	public HomeController(HomeView homeView) {
		this.homeView = homeView;
		homeView.setStudentLoginListener(new StudentLoginListener());
		homeView.setTeacherLoginListener(new TeacherLoginListener());
	}

	public void setHomeView(HomeView homeView) {
		this.homeView = homeView;
	}

	private class StudentLoginListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == homeView.loginStudentBtn) {
				homeView.frame.getContentPane().add(studentView.panelStudent);
				homeView.frame.getContentPane().remove(teacherView.panelTeacher);
				studentView.panelStudent.setVisible(true);
				teacherView.panelTeacher.setVisible(false);

			}

		}
	}

	private class TeacherLoginListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == homeView.loginTeacherBtn) {
				homeView.frame.getContentPane().remove(studentView.panelStudent);
				homeView.frame.getContentPane().add(teacherView.panelTeacher);
				teacherView.panelTeacher.setVisible(true);
				studentView.panelStudent.setVisible(false);
			}

		}

	}

}