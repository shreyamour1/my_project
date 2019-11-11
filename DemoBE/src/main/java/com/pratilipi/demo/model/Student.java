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
@Table(name = "STUDENT_TABLE")
public class Student {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	@NotNull
	@NotEmpty
	private String name;

	@Column(name = "image")
	@Lob
	private Byte[] image;

	@Column(name = "batch")
	@NotNull
	@NotEmpty
	private String batch;

	@Column(name = "university")
	@NotNull
	private Integer universityId;

	@Column(name = "password")
	@NotNull
	@NotEmpty
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Byte[] getImage() {
		return image;
	}

	public void setImage(MultipartFile image) throws IOException {
		if (image == null) {
			this.image = null;
		} else {
			Byte[] byteObjects = new Byte[image.getBytes().length];

			int j = 0;

			for (byte b : image.getBytes()) {
				byteObjects[j++] = b;
			}

			this.image = byteObjects;
		}

	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public Integer getUniversityId() {
		return universityId;
	}

	public void setUniversityId(Integer universityId) {
		this.universityId = universityId;
	}

}
