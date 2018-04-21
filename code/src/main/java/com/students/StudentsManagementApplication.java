package com.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.students.presentation.controller.HomeController;
import com.students.presentation.view.HomeView;

@SpringBootApplication
public class StudentsManagementApplication implements CommandLineRunner {
	@Autowired
	HomeView homeView;
	@Autowired
	HomeController homeController;

	public static void main(String[] args) {
		System.setProperty("java.awt.headless", "false");
		SpringApplication.run(StudentsManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		homeView.getFrame().setVisible(true);
		homeController.setHomeView(homeView);			
	}
}
