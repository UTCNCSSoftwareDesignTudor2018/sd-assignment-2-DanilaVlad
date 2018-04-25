package com.students.data.entity;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Report {
	private String reportContent;
	
	public Report(String reportContent) {
		this.reportContent = reportContent;

		try {
			MongoClient client = new MongoClient("127.0.0.1", 27017);
			MongoDatabase database = client.getDatabase("reports");
			MongoCollection<Document> newCollection = database.getCollection("reportsCollection");
			Document document = new Document(reportContent, "added!" );
			newCollection.insertOne(document);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
