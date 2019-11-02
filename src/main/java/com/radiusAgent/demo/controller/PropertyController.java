package com.radiusAgent.demo.controller;

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

import com.radiusAgent.demo.model.Property;
import com.radiusAgent.demo.service.PropertyService;

@RequestMapping("/property")
@RestController
public class PropertyController {

	@Autowired
	PropertyService propertyService;

	@PostMapping("/")
	public ResponseEntity<Property> createorUpdate(@RequestBody Property property) {
		Property updated = propertyService.createOrUpdateProperty(property);
		return new ResponseEntity<Property>(updated, new HttpHeaders(),
				HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Property> getPropertyById(@PathVariable("id") Integer id) {
		Property entity = propertyService.getPropertyById(id);

		return new ResponseEntity<Property>(entity, new HttpHeaders(),
				HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deletePropertyById(@PathVariable("id") Integer id) {
		propertyService.deletePropertyById(id);
		return HttpStatus.FORBIDDEN;
	}

	@GetMapping
	public ResponseEntity<List<Property>> getAllProperties() {
		List<Property> list = propertyService.getAllProperties();

		return new ResponseEntity<List<Property>>(list, new HttpHeaders(),
				HttpStatus.OK);
	}
}
