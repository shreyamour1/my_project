package com.pratilipi.demo.controller;

import java.io.IOException;

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

import com.pratilipi.demo.model.University;
import com.pratilipi.demo.service.UniversityService;

@RequestMapping("/university")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UniversityController {

	@Autowired
	UniversityService universityService;

	@PostMapping
	public ResponseEntity<University> createorUpdate(@RequestPart University university,
			@RequestPart("image") MultipartFile logo) throws IOException {
		University updated = universityService.createOrUpdateUniversity(university, logo);
		updated.setLogo(null);
		return new ResponseEntity<University>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<University> getUniversityById(@PathVariable("id") Integer id) throws IOException {
		University entity = universityService.getUniversityById(id);
		entity.setLogo(null);
		return new ResponseEntity<University>(entity, new HttpHeaders(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public HttpStatus deleteUniversityById(@PathVariable("id") Integer id) {
		universityService.deleteUniversityById(id);
		return HttpStatus.FORBIDDEN;
	}

}
