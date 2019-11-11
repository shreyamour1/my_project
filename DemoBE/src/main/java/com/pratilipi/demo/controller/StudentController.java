package com.pratilipi.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pratilipi.demo.model.Student;
import com.pratilipi.demo.service.StudentService;

@RequestMapping("/student")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping
	public ResponseEntity<Student> createorUpdate(@RequestPart Student student,
			@RequestPart("image") MultipartFile image) throws IOException {
		Student updated = studentService.createOrUpdateStudent(student, image);
		updated.setImage(null);
		updated.setPassword(null);
		return new ResponseEntity<Student>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer id) throws IOException {
		Student entity = studentService.getStudentById(id);
		entity.setImage(null);
		entity.setPassword(null);
		return new ResponseEntity<Student>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteStudentById(@PathVariable("id") Integer id) {
		studentService.deleteStudentById(id);
		return HttpStatus.FORBIDDEN;
	}

	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents() throws IOException {
		List<Student> list = studentService.getAllStudents();
		List<Student> answerList = new ArrayList<>();
		for (Student student : list) {
			student.setImage(null);
			student.setPassword(null);
			answerList.add(student);
		}

		return new ResponseEntity<List<Student>>(answerList, new HttpHeaders(), HttpStatus.OK);
	}

}
