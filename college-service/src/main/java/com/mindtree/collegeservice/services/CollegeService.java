package com.mindtree.collegeservice.services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.mindtree.collegeservice.entity.CollegeEntity;
import com.mindtree.collegeservice.pojo.College;
import com.mindtree.collegeservice.pojo.Student;
import com.mindtree.collegeservice.repository.CollegeRepository;

@Service
public class CollegeService {
	@Autowired
	private CollegeRepository repository;
	
	@Autowired
	private WebClient.Builder webClientBuilder;

	public List<College> getAllCollege() {
		List<CollegeEntity> list =  repository.findAll();
		List<College> colleges = list.stream()
				.map(College::toCollege)
				.collect(Collectors.toList());
		for(College clg: colleges) {
			List<Student> ls = getStudentsOfCollege(clg.getId());
			clg.setStudentList(getStudentsOfCollege(clg.getId()));
			Collections.sort(clg.getStudentList(), (o1, o2) -> o1.getName().compareTo(o2.getName()));
		}
		return colleges;
	}

	public void createCollege(CollegeEntity collegeEntity) {
		repository.save(collegeEntity);
		
	}
	
	public CollegeEntity getCollege(int id) {
		return repository.findById(id).get();
	}
	
	public List<Student> getStudentsOfCollege(int collegeId){
		List<Student> ls = webClientBuilder.build().get()
				.uri("http://localhost:8020/STUDENT-SERVER/getStudentOfCollege/"+collegeId)
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<List<Student>>() {})
				.block();
		return ls;
	}
	
}
