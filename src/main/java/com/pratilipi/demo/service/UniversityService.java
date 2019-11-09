package com.pratilipi.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratilipi.demo.repository.StudentRepository;

@Service("universityService")
public class UniversityService {

	@Autowired
	StudentRepository studentRepository;

}
