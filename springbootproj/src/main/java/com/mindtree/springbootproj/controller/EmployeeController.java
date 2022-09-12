package com.mindtree.springbootproj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.springbootproj.entity.Department;
import com.mindtree.springbootproj.entity.Employee;
import com.mindtree.springbootproj.repository.DepartmentRepository;
import com.mindtree.springbootproj.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@PostMapping("createEmployee")
	public void createEmployee(@RequestBody Employee employee) {
		repository.save(employee);
		Department department = departmentRepository.findById(employee.getDeptId()).get();
		department.setNoOfEmployees(department.getNoOfEmployees()+1);
		departmentRepository.save(department);
	}

}
