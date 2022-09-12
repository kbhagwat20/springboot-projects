package com.example.microservices.EmployeeServer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.EmployeeServer.Entity.Employee;
import com.example.microservices.EmployeeServer.Service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;

	
	@PostMapping("/createEmployee")
	public void createEmployee(@RequestBody Employee employee) throws Exception{
		service.createEmployee(employee);
	}
	
	@GetMapping("/getAllEmployee")
	public List<Employee> getALl(){
		return service.getAllEmployee();
	}
	
	@GetMapping("/getEmployeesOfDept/{departmentId}")
	public List<Employee> getEmployeeOfDept(@PathVariable int departmentId){
		return service.getEployeeListOfDept(departmentId);
	}

}
