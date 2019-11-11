package com.pratilipi.demo.model;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class Credentials {

	@Column(name = "studentId")
	@NotNull
	private Integer studentId;

	@Column(name = "password")
	@NotNull
	@NotEmpty
	private String password;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
