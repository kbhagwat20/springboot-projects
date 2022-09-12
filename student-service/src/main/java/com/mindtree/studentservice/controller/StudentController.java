package com.mindtree.studentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.studentservice.entity.Student;
import com.mindtree.studentservice.services.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@PostMapping("/createStudent")
	public void createStudent(@RequestBody Student student) throws Exception{
		service.createStudent(student);
	}
	
	@GetMapping("/getAllStudent")
	public List<Student> getALl(){
		return service.getAllStudents();
	}
	
	@GetMapping("/getStudentOfCollege/{collegeId}")
	public List<Student> getStudentOfCollege(@PathVariable int collegeId){
		return service.getStudentsOfCollege(collegeId);
	}

}
