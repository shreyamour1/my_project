package com.pratilipi.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.pratilipi.demo.model.Student;
import com.pratilipi.demo.repository.StudentRepository;

@Service("loginService")
public class LoginService {

	@Autowired
	private StudentRepository repository;

	public boolean login(Integer studentId, String password) {

		Optional<Student> student = repository.findById(studentId);

		if (!student.isPresent()) {
			return false;
		} else if (password.equals(student.get().getPassword())) {
			return true;
		} else {
			return false;
		}
	}

}
