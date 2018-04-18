package com.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.students.business.service.StudentService;
import com.students.presentation.controller.StudentController;
import com.students.presentation.view.StudentView;

@SpringBootApplication
public class StudentsManagementApplication implements CommandLineRunner{
	@Autowired
	StudentView studentView;
	@Autowired
	StudentController studentController;
	@Autowired
	StudentService studentService;
	
	public static void main(String[] args)  {
		System.setProperty("java.awt.headless", "false");
		SpringApplication.run(StudentsManagementApplication.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {
		studentView.getFrame().setVisible(true);
		studentController.setStudentView(studentView);	
	}
}
