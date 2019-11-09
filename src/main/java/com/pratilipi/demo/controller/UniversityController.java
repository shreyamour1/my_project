package com.pratilipi.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratilipi.demo.service.UniversityService;

@RequestMapping("/university")
@RestController
public class UniversityController {

	@Autowired
	UniversityService universityService;

}
