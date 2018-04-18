package com.students.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.students.business.dto.StudentDto;
import com.students.business.service.StudentService;
import com.students.presentation.view.StudentView;

@Controller
public class StudentController {

	private StudentView studentView;
	@Autowired
	StudentService studentService;

	public StudentController(StudentView studentView, StudentService studentService) {
		this.studentView = studentView;
		studentView.setStudentLoginListener(new StudentLoginListener());
		studentView.setStudentViewInfoListener(new StudentViewInfoListener());
		studentView.setStudentCreateProfileListener(new StudentCreateProfileListener());
		studentView.setStudentUpdateProfileListener(new StudentUpdateProfileListener());
	}

	public void setStudentView(StudentView studentView) {
		this.studentView = studentView;
	}

	private class StudentLoginListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == studentView.loginStudentBtn) {
				studentView.panelStudent.setVisible(true);
			}

		}
	}

	private class StudentViewInfoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == studentView.viewStudentInfoBtn) {
				String studentName = "";
				studentName = studentView.studentNameText.getText();
				studentView.areaInfo.setText(studentService.getStudentByName(studentName).toString());
			}

		}
	}

	private class StudentCreateProfileListener implements ActionListener {
		String name = "";
		String card = "";
		String pnc = "";
		String address = "";
		String group = "";

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == studentView.createStudentBtn) {
				int optionPaneResult = studentView.createOptionPane();
				if (optionPaneResult == JOptionPane.OK_OPTION) {
					name = studentView.profileNameText.getText();
					card = studentView.profileCardText.getText();
					pnc = studentView.profilePersonalNrText.getText();
					address = studentView.profileAddressText.getText();
					group = studentView.profileGroupText.getText();
				} else {
					System.out.println("Cancelled");
				}
				StudentDto studentDto = new StudentDto(name, card, pnc, address, group);
				studentService.createStudent(studentDto);
			}

		}
	}

	private class StudentUpdateProfileListener implements ActionListener {
		int id = 0;
		String group = "";

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == studentView.updateStudentBtn) {
				id = Integer.parseInt(studentView.editStudentIdText.getText());
				group = studentView.editStudentGroupText.getText();
				studentService.updateGroup(id, group);
				studentView.areaInfo.setText(studentService.getStudentById(id).toString());
			}

		}
	}

}
