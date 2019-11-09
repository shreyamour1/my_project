package com.pratilipi.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "UNIVERSITY_TABLE")
public class University {

	@Id
	@GeneratedValue
	@Column(name = "id")
	@NotNull
	private Integer id;

	@Column(name = "universityName")
	@NotNull
	private String universityName;

	@Column(name = "logo")
	@NotNull
	private String logo;

	@Column(name = "address")
	@NotNull
	private String address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}