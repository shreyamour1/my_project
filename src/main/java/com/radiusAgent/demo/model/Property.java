package com.radiusAgent.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROPERTY_TABLE")
public class Property {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "latitude")
	private Double latitude;

	@Column(name = "longitude")
	private Double longitude;

	@Column(name = "price")
	private Double price;

	@Column(name = "noOfBedRooms")
	private Integer noOfBedRooms;

	@Column(name = "noOfBathRooms")
	private Integer noOfBathRooms;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getNoOfBedRooms() {
		return noOfBedRooms;
	}

	public void setNoOfBedRooms(Integer noOfBedRooms) {
		this.noOfBedRooms = noOfBedRooms;
	}

	public Integer getNoOfBathRooms() {
		return noOfBathRooms;
	}

	public void setNoOfBathRooms(Integer noOfBathRooms) {
		this.noOfBathRooms = noOfBathRooms;
	}
	
}
