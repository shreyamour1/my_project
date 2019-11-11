package com.pratilipi.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratilipi.demo.model.Credentials;
import com.pratilipi.demo.service.LoginService;

@RequestMapping("/login")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping
	public boolean login(@RequestBody Credentials credentials) {

		return loginService.login(credentials.getStudentId(), credentials.getPassword());
	}

}
