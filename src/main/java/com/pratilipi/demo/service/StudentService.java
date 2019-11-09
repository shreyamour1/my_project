package com.pratilipi.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratilipi.demo.errorhandling.NoStudentException;
import com.pratilipi.demo.model.Student;
import com.pratilipi.demo.repository.StudentRepository;

@Service("studentService")
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public Student createOrUpdatestudent(Student i) {

		Optional<Student> student = studentRepository.findById(i.getId());

		if (student.isPresent()) {
			Student newstudent = student.get();
			newstudent.setBatch(i.getBatch());
			newstudent = studentRepository.save(newstudent);

			return newstudent;
		} else {
			return studentRepository.save(i);
		}

	}

	public Student getStudentById(Integer id) {
		Optional<Student> item = studentRepository.findById(id);

		if (item.isPresent()) {
			return item.get();
		} else {
			throw new NoStudentException("No such student exist");
		}
	}

	public void deleteStudentById(Integer id) {
		Optional<Student> item = studentRepository.findById(id);

		if (item.isPresent()) {
			studentRepository.deleteById(id);
		}
	}

	public List<Student> getAllProperties() {
		List<Student> allStudents = studentRepository.findAll();
		if (allStudents.size() > 0) {
			return allStudents;
		} else {
			throw new NoStudentException("No such student exist");
		}
	}
}
