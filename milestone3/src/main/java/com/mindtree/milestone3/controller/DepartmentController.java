package com.mindtree.milestone3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.milestone3.entity.Department;
import com.mindtree.milestone3.entity.Employee;
import com.mindtree.milestone3.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService service;
	
	@PostMapping("/createDepartment")
	public void createDepartment(@RequestBody Department department) {
		service.createDepartment(department);
	}
	
	@GetMapping("/getAllDepartment")
	public List<Department> getAll(){
		return service.getAllDepartments();
	}
	
	@GetMapping("/getAllEmployee/{id}")
	public List<Employee> getAllEmployee(@PathVariable int id){
		return service.getAllEmplForDepartment(id);
	}

}
