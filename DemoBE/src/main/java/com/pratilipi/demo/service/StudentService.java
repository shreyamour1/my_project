package com.pratilipi.demo.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pratilipi.demo.errorhandling.NoStudentException;
import com.pratilipi.demo.model.Student;
import com.pratilipi.demo.repository.StudentRepository;

@Service("studentService")
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public Student createOrUpdateStudent(Student i, MultipartFile image) throws IOException {

		Optional<Student> student = studentRepository.findById(i.getId());

		if (student.isPresent()) {
			Student existingStudent = student.get();
			existingStudent.setBatch(i.getBatch());
			if (null != image) {
				existingStudent.setImage(image);
			}
			existingStudent.setName(i.getName());
			existingStudent.setPassword(i.getPassword());
			existingStudent.setUniversityId(i.getUniversityId());
			existingStudent.setId(i.getId());
			existingStudent = studentRepository.save(existingStudent);
			return existingStudent;
		} else {
			if (null != image) {
				i.setImage(image);
			}
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

	public List<Student> getAllStudents() {
		List<Student> allStudents = studentRepository.findAll();
		if (allStudents.size() > 0) {
			return allStudents;
		} else {
			throw new NoStudentException("No such student exist");
		}
	}

}
