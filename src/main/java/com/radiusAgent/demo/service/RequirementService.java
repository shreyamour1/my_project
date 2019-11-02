package com.radiusAgent.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.radiusAgent.demo.errorhandling.MissingMandatoryException;
import com.radiusAgent.demo.model.ParameterPercentage;
import com.radiusAgent.demo.model.Property;
import com.radiusAgent.demo.model.Requirement;
import com.radiusAgent.demo.repository.PropertyRepository;
import com.radiusAgent.demo.utility.Utility;

@Service("requirementService")
public class RequirementService {

	@Autowired
	PropertyRepository propertyRepository;

	public List<Property> getQualifiedProperties(Requirement r) {

		// validation of mandatory fields of requirement
		validateRequirement(r);
		List<Property> validProperties = new ArrayList<Property>();

		// list for storing property and its percentage paramters
		List<ParameterPercentage> paramPercentage = new ArrayList<ParameterPercentage>();
		for (Property p : propertyRepository.findAll()) {
			ParameterPercentage param = new ParameterPercentage();
			calculateAndSetDistancePercent(param, p, r);
			calculateAndSetBudgetPercent(param, p, r);
			calculateBathroomPercent(param, p, r);
			calculateBedroomPercent(param, p, r);
			calculateTotalPercent(param);
			// setProperty
			param.setProperty(p);
			paramPercentage.add(param);

		}
		// if total percentage is >= 40, then only consider valid property to
		// show to customer
		for (ParameterPercentage param : paramPercentage) {
			if (param.getTotal() >= 40) {
				validProperties.add(param.getProperty());
			}
		}

		return validProperties;
	}

	public static void validateRequirement(Requirement r) {
		List<String> mandatoryMissingParameters = new ArrayList<String>();
		if (r.getLatitude() == null) {
			mandatoryMissingParameters.add("latitude");
		}
		if (r.getLongitude() == null) {
			mandatoryMissingParameters.add("longitude");
		}
		if (r.getMinBudget() == null && r.getMaxBudget() == null) {
			mandatoryMissingParameters.add("budget");
		}
		if (r.getMinBathRoom() == null && r.getMaxBathRoom() == null) {
			mandatoryMissingParameters.add("bathRoom");
		}
		if (r.getMinBedRoom() == null && r.getMaxBedRoom() == null) {
			mandatoryMissingParameters.add("bedRoom");
		}

		if (!mandatoryMissingParameters.isEmpty()) {
			throw new MissingMandatoryException("Mandatory parameter(s): "
					+ String.join(",", mandatoryMissingParameters)
					+ " are missing");
		}
	}

	public void calculateAndSetDistancePercent(ParameterPercentage param,
			Property p, Requirement r) {

		double distanceInMiles = Utility.getDistanceFromLatLonInMiles(
				r.getLatitude(), r.getLongitude(), p.getLatitude(),
				p.getLongitude());

		if (distanceInMiles < 2) {
			param.setDistance(30.00);
		}

	}

	public void calculateAndSetBudgetPercent(ParameterPercentage param,
			Property p, Requirement r) {

		if (r.getMinBudget() != null && r.getMaxBudget() != null) {
			if (p.getPrice() >= r.getMinBudget()
					&& p.getPrice() <= r.getMaxBudget()) {
				param.setBudget(30.00);
			}
		} else {

			// +- 25% for checking valid match
			Double budget = r.getMaxBudget() == null ? r.getMinBudget() : r
					.getMaxBudget();

			// calculatePercentage
			// within 10%, then 30% match

		}

	}

	public void calculateBathroomPercent(ParameterPercentage param, Property p,
			Requirement r) {

		// if both min max given and property bathroom between min max, then
		// contribution is 20%
		if (r.getMinBathRoom() != null && r.getMaxBathRoom() != null) {
			if (p.getNoOfBathRooms() >= r.getMinBathRoom()
					&& p.getNoOfBathRooms() <= r.getMinBathRoom()) {
				param.setBudget(20.00);
			} else {

			}
		} else {

			Integer bathRoom = r.getMinBathRoom() == null ? r.getMaxBathRoom()
					: r.getMinBathRoom();
			// calculatePercentage
			if (bathRoom - 2 > 0) {

			}

		}

	}

	public void calculateBedroomPercent(ParameterPercentage param, Property p,
			Requirement r) {

		// if both min max given and property bedroom between min max, then
		// contribution is 20%
		if (r.getMinBedRoom() != null && r.getMaxBedRoom() != null) {
			if (p.getNoOfBedRooms() >= r.getMinBedRoom()
					&& p.getNoOfBedRooms() <= r.getMinBedRoom()) {
				param.setBudget(20.00);
			} else {

			}
		} else {

			Integer bedRoom = r.getMinBedRoom() == null ? r.getMaxBedRoom() : r
					.getMinBedRoom();
			// calculatePercentage
			if (bedRoom - 2 > 0) {

			}

		}

	}

	public void calculateTotalPercent(ParameterPercentage param) {
		param.setTotal(param.getBathRoom() + param.getBedRoom()
				+ param.getBudget() + param.getDistance());
	}

}
