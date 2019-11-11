package com.pratilipi.demo.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pratilipi.demo.errorhandling.NoStudentException;
import com.pratilipi.demo.model.Student;
import com.pratilipi.demo.model.University;
import com.pratilipi.demo.repository.UniversityRepository;

@Service("universityService")
public class UniversityService {

	@Autowired
	UniversityRepository universityRepository;

	public University createOrUpdateUniversity(University uni, MultipartFile logo) throws IOException {
		Optional<University> university = universityRepository.findById(uni.getId());

		if (university.isPresent()) {
			University existingUniversity = university.get();
			if (null != logo) {
				existingUniversity.setLogo(logo);
			}
			existingUniversity.setAddress(uni.getAddress());
			existingUniversity.setUniversityName(uni.getUniversityName());
			existingUniversity.setId(uni.getId());
			existingUniversity.setTotalViewCount(uni.getTotalViewCount());
			existingUniversity = universityRepository.save(existingUniversity);
			return existingUniversity;
		} else {
			if (null != logo) {
				uni.setLogo(logo);
			}
			return universityRepository.save(uni);
		}

	}

	public University getUniversityById(Integer id) {
		Optional<University> item = universityRepository.findById(id);

		if (item.isPresent()) {
			University university = item.get();
			university.setTotalViewCount(university.getTotalViewCount() + 1);
			universityRepository.save(university);
			return item.get();
		} else {
			throw new NoStudentException("No such student exist");
		}
	}

	public void deleteUniversityById(Integer id)
	{	
	Optional<University> item = universityRepository.findById(id);
	if (item.isPresent()) {
		universityRepository.deleteById(id);
	}
	}
}
