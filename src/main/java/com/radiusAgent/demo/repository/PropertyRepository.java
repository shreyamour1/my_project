package com.radiusAgent.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.radiusAgent.demo.model.Property;

@Repository("propertyRepository")

public interface PropertyRepository extends JpaRepository<Property, Integer> {

}
