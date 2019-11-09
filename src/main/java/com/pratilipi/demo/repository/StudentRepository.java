package com.pratilipi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pratilipi.demo.model.Student;

@Repository("studentRepository")

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
