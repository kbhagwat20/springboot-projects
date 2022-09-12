package com.example.microservices.DepartmentServer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.DepartmentServer.Entity.DepartmentEntity;
import com.example.microservices.DepartmentServer.Service.DepartmentService;
import com.example.microservices.DepartmentServer.pojo.Department;


@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService service;

	
	@PostMapping("/createDepartment")
	public void createDepartment(@RequestBody DepartmentEntity departmentEntity) {
		service.createDepartment(departmentEntity);
	}
	
	@GetMapping("/getAllDepartment")
	public List<Department> getALl(){
		return service.getAllDepartment();
	}
	
	@GetMapping("/getDepartment/{id}")
	public DepartmentEntity getDepartment(@PathVariable int id){
		return service.getDepartment(id);
	}
	
	
}
