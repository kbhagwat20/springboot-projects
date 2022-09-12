package com.mindtree.studentservice.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.mindtree.studentservice.entity.College;
import com.mindtree.studentservice.entity.Student;
import com.mindtree.studentservice.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;

	@Autowired
	private WebClient.Builder webClientBuilder;
	
	public void createStudent(Student student) throws Exception{
		
		List<Student> studList = repository.findAllByCollegeId(student.getCollegeId());
		
		College college = webClientBuilder.build().get()
				.uri("http://localhost:8020/COLLEGE-SERVER/getCollege/" + student.getCollegeId())
				.retrieve()
				.bodyToMono(College.class)
				.block();
		if(college.getNoOfStudents()<studList.size()+1) {
			throw new Exception("Unable to add employee to the department as the capacity of department is full");
		}
		repository.save(student);
	}
	
	public List<Student> getAllStudents(){
		return repository.findAll();
	}
	
	public List<Student> getStudentsOfCollege(int id){
		List<Student> students =  repository.findAllByCollegeId(id);
		Collections.sort(students, (o1,o2) -> o2.getAge()- o1.getAge());
		return students;
	}

}
