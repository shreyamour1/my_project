package com.pratilipi.demo.model;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "UNIVERSITY_TABLE")
public class University {

	@Id
	@GeneratedValue
	@Column(name = "id")
	@NotNull
	private Integer id;

	@Column(name = "totalViewCount")
	private Integer totalViewCount;

	@Column(name = "universityName")
	@NotNull
	@NotEmpty
	private String universityName;

	@Column(name = "logo")
	@Lob
	private Byte[] logo;

	@Column(name = "address")
	@NotNull
	@NotEmpty
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

	public Integer getTotalViewCount() {
		return totalViewCount;
	}

	public void setTotalViewCount(Integer totalViewCount) {
		this.totalViewCount = totalViewCount;
	}

	public Byte[] getLogo() {
		return logo;
	}

	public void setLogo(MultipartFile logo) throws IOException {
		if (logo == null) {
			this.logo = null;
		} else {
			Byte[] byteObjects = new Byte[logo.getBytes().length];

			int j = 0;

			for (byte b : logo.getBytes()) {
				byteObjects[j++] = b;
			}

			this.logo = byteObjects;
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}