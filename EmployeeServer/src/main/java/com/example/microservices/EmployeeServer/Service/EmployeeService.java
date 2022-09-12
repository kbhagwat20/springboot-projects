package com.example.microservices.EmployeeServer.Service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.microservices.EmployeeServer.Entity.Department;
import com.example.microservices.EmployeeServer.Entity.Employee;
import com.example.microservices.EmployeeServer.Repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	public void createEmployee(Employee employee) throws Exception{
		
		List<Employee> emplList = repository.findAllByDeptId(employee.getDeptId());
		
		Department department = webClientBuilder.build().get()
				.uri("http://localhost:8020/DEPARTMENT-SERVER/getDepartment/" + employee.getDeptId())
				.retrieve()
				.bodyToMono(Department.class)
				.block();
		if(department.getNoOfEmployee()<emplList.size()+1) {
			throw new Exception("Unable to add employee to the department as the capacity of department is full");
		}
		repository.save(employee);
	}
	
	public List<Employee> getAllEmployee(){
		return repository.findAll();
	}
	
	public List<Employee> getEployeeListOfDept(int id){
		List<Employee> employees =  repository.findAllByDeptId(id);
		Collections.sort(employees, (o1,o2) -> o2.getAge()- o1.getAge());
		return employees;
	}
}
