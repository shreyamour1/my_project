package com.radiusAgent.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.radiusAgent.demo.errorhandling.NoPropertyException;
import com.radiusAgent.demo.model.Property;
import com.radiusAgent.demo.repository.PropertyRepository;

@Service("propertyService")
public class PropertyService {

	@Autowired
	PropertyRepository propertyRepository;

	public Property createOrUpdateProperty(Property i) {

		Optional<Property> property = propertyRepository.findById(i.getId());

		if (property.isPresent()) {
			Property newProperty = property.get();
			newProperty.setLatitude(i.getLatitude());
			newProperty.setLongitude(i.getLongitude());
			newProperty.setPrice(i.getPrice());
			newProperty.setNoOfBathRooms(i.getNoOfBathRooms());
			newProperty.setNoOfBedRooms(i.getNoOfBedRooms());
			newProperty = propertyRepository.save(newProperty);

			return newProperty;
		} else {
			return propertyRepository.save(i);
		}

	}

	public Property getPropertyById(Integer id) {
		Optional<Property> item = propertyRepository.findById(id);

		if (item.isPresent()) {
			return item.get();
		} else {
			throw new NoPropertyException("No such property exist");
		}
	}

	public void deletePropertyById(Integer id) {
		Optional<Property> item = propertyRepository.findById(id);

		if (item.isPresent()) {
			propertyRepository.deleteById(id);
		}
	}

	public List<Property> getAllProperties() {
		List<Property> allProperties = propertyRepository.findAll();
		if (allProperties.size() > 0) {
			return allProperties;
		} else {
			throw new NoPropertyException("No such property exist");
		}
	}
}
