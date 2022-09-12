package com.mindtree.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.student.entity.StudentEntity;
import com.mindtree.student.services.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@PostMapping("/addStudent")
	public void createStudent(@RequestBody StudentEntity student) {
		service.createStudents(student);
	}
	
	@GetMapping("/getAllStudent")
	public List<StudentEntity> getAllStudent(){
		return service.getAllStudent();
	}
	
	@PutMapping("/update/{id}/{city}")
	public StudentEntity updateStudent(@PathVariable int id, @PathVariable String city) {
		return service.updateStudent(id, city);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteStudent(@PathVariable int id) {
		service.deleteStudent(id);
	}
	
	

}
