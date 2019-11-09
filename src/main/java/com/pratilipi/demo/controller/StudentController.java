package com.pratilipi.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratilipi.demo.model.Student;
import com.pratilipi.demo.service.StudentService;

@RequestMapping("/student")
@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/")
	public ResponseEntity<Student> createorUpdate(@RequestBody Student student) {
		Student updated = studentService.createOrUpdateStudent(student);
		return new ResponseEntity<Student>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer id) {
		Student entity = studentService.getStudentById(id);
		return new ResponseEntity<Student>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteStudentById(@PathVariable("id") Integer id) {
		studentService.deleteStudentById(id);
		return HttpStatus.FORBIDDEN;
	}

	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> list = studentService.getAllStudents();

		return new ResponseEntity<List<Student>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	//get student by name
	@GetMapping("/{name}")
	public ResponseEntity<Student> getStudentByName(@PathVariable("name") String name) {
		Student entity = studentService.getStudentById(name);
		return new ResponseEntity<Student>(entity, new HttpHeaders(), HttpStatus.OK);
	}
}
