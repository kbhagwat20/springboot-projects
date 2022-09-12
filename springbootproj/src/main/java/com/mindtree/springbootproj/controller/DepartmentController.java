package com.mindtree.springbootproj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.springbootproj.entity.Department;
import com.mindtree.springbootproj.repository.DepartmentRepository;

@RestController
public class DepartmentController {

	@Autowired
	DepartmentRepository repository;
	
	@GetMapping("/departments")
	public List<Department> getDaprtmentDetails(){
		return repository.findAll();
	}
}
