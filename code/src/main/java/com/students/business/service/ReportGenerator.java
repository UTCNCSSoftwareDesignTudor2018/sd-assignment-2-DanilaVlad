package com.students.business.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Service;

@Service
public interface ReportGenerator {
	void getReport() throws UnsupportedEncodingException, FileNotFoundException, IOException;
}
