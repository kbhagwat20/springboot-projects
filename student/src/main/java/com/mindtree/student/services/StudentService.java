package com.mindtree.student.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.student.entity.StudentEntity;
import com.mindtree.student.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository repository;
	
	public void createStudents(StudentEntity student) {
		repository.save(student);
		
	}
	
	public List<StudentEntity> getAllStudent() {
		return repository.findAll();
	}
	
	public StudentEntity updateStudent(int id,String city) {
		List<StudentEntity> list = repository.findAll();
		for(StudentEntity s: list) {
			if(s.getId()== id) {
				s.setCity(city);
				repository.save(s);
				return s;
			}
		}return null;
	}
	
	public void deleteStudent(int id) {
		repository.deleteById(id);
	}
		
}
