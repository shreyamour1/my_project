package com.pratilipi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pratilipi.demo.model.University;

@Repository("universityRepository")
public interface UniversityRepository extends JpaRepository<University, Integer> {
}
