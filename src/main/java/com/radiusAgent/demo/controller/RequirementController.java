package com.radiusAgent.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.radiusAgent.demo.model.Property;
import com.radiusAgent.demo.model.Requirement;
import com.radiusAgent.demo.service.RequirementService;

@RequestMapping("/requirement")
@RestController
public class RequirementController {

	@Autowired
	RequirementService requirementService;

	@PostMapping("/")
	public ResponseEntity<List<Property>> getMatchingProperties(
			@RequestBody Requirement requirement) {
		List<Property> qualifiedProperties = requirementService
				.getQualifiedProperties(requirement);
		return new ResponseEntity<List<Property>>(qualifiedProperties,
				new HttpHeaders(), HttpStatus.OK);
	}

}
