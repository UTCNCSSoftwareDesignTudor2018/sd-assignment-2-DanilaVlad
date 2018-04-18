package com.students.presentation.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.springframework.stereotype.Component;

@Component
public class StudentView {

	public JFrame frame;
	
	public JPanel panelHome;
	public JPanel panelStudent;
	public JPanel createProfilePanel;
	
	public JButton loginStudentBtn;
	public JButton loginTeacherBtn;
	public JButton viewStudentInfoBtn;
	public JButton createStudentBtn;
	public JButton updateStudentBtn;
	
	public JTextField studentNameText;
	public JTextField nameText;
	public JTextField cardText;
	public JTextField personalCodeText;
	public JTextField addressText;
	public JTextField profileNameText;
	public JTextField profileCardText;
	public JTextField profilePersonalNrText;
	public JTextField profileAddressText;
	public JTextField profileGroupText;
	
	public JTextField editStudentIdText;
	public JTextField editStudentGroupText;
	
	public JTextArea areaInfo;

	public JFrame getFrame() {
		return frame;
	}

	public StudentView() {
		initialize();
	}
	
	public void setStudentLoginListener(ActionListener actionListener) {
		loginStudentBtn.addActionListener(actionListener);
	}
	public void setStudentViewInfoListener(ActionListener actionListener) {
		viewStudentInfoBtn.addActionListener(actionListener);
	}
	public void setStudentCreateProfileListener(ActionListener actionListener) {
		createStudentBtn.addActionListener(actionListener);
	}
	public void setStudentUpdateProfileListener(ActionListener actionListener) {
		updateStudentBtn.addActionListener(actionListener);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 357);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		panelHome = new JPanel();
		panelHome.setBounds(0, 0, 550, 45);
		panelHome.setBackground(Color.GRAY);
		panelHome.setLayout(null);
		frame.add(panelHome);

		panelStudent = new JPanel();
		panelStudent.setBounds(0, 45, 550, 312);
		panelStudent.setLayout(null);
		frame.getContentPane().add(panelStudent);
		panelStudent.setVisible(false);
		
		loginStudentBtn = new JButton("Student Login");
		loginStudentBtn.setBounds(100, 10, 144, 25);
		panelHome.add(loginStudentBtn);
		
		loginTeacherBtn = new JButton("Teacher Login");
		loginTeacherBtn.setBounds(280, 10, 144, 25);
		panelHome.add(loginTeacherBtn);
		
		viewStudentInfoBtn = new JButton("View info");
		viewStudentInfoBtn.setBounds(130, 10, 100, 20);
		panelStudent.add(viewStudentInfoBtn);
		
		createStudentBtn = new JButton("Create profile");
		createStudentBtn.setBounds(60, 190, 120, 20);
		panelStudent.add(createStudentBtn);
		
		studentNameText = new JTextField("Student name");
		studentNameText.setBounds(10, 10, 100, 20);
		panelStudent.add(studentNameText);
		
		editStudentIdText = new JTextField("Student id");
		editStudentIdText.setBounds(70, 70, 100, 20);
		panelStudent.add(editStudentIdText);
		
		editStudentGroupText = new JTextField("Student group");
		editStudentGroupText.setBounds(70, 100, 100, 20);
		panelStudent.add(editStudentGroupText);
		
		updateStudentBtn = new JButton("Update profile");
		updateStudentBtn.setBounds(60, 140, 120, 20);
		panelStudent.add(updateStudentBtn);
		
	    areaInfo = new JTextArea();  
	    areaInfo.setBounds(250,10, 200,150);  
	    panelStudent.add(areaInfo);  
	    
	    profileNameText = new JTextField();
		profileCardText = new JTextField();
		profilePersonalNrText = new JTextField();
		profileAddressText = new JTextField();
		profileGroupText = new JTextField();
		
		createProfilePanel = new JPanel(new GridLayout(0, 1));
		createProfilePanel.add(new JLabel("Name:"));
		createProfilePanel.add(profileNameText);
		createProfilePanel.add(new JLabel("CardNr:"));
		createProfilePanel.add(profileCardText);
		createProfilePanel.add(new JLabel("PNC:"));
		createProfilePanel.add(profilePersonalNrText);
		createProfilePanel.add(new JLabel("Address:"));
		createProfilePanel.add(profileAddressText);
		createProfilePanel.add(new JLabel("Group:"));
		createProfilePanel.add(profileGroupText);
		
	}
	
	public int createOptionPane() {
		return JOptionPane.showConfirmDialog(null, createProfilePanel, "Create profile",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	}
}
