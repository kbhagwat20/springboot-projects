package com.example.microservices.DepartmentServer.Service;

import java.util.Collections;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.microservices.DepartmentServer.Entity.DepartmentEntity;
import com.example.microservices.DepartmentServer.Repository.DepartmentRepository;
import com.example.microservices.DepartmentServer.pojo.Department;
import com.example.microservices.DepartmentServer.pojo.Employee;

@Service
public class DepartmentService {
	
	
	@Autowired
	private DepartmentRepository repository;
	
	@Autowired
	private WebClient.Builder webClientBuilder;

	public List<Department> getAllDepartment() {
		List<DepartmentEntity> list =  repository.findAll();
		List<Department> departments = list.stream()
				.map(Department::toDepartment)
				.collect(Collectors.toList());
		for(Department dept: departments) {
			List<Employee> ls = getEployeeListOfDept(dept.getId());
			dept.setEmployees(getEployeeListOfDept(dept.getId()));
			Collections.sort(dept.getEmployees(), (o1, o2) -> o1.getName().compareTo(o2.getName()));
		}
		return departments;
	}

	public void createDepartment(DepartmentEntity departmentEntity) {
		repository.save(departmentEntity);
		
	}
	
	public DepartmentEntity getDepartment(int id) {
		return repository.findById(id).get();
	}
	
	public List<Employee> getEployeeListOfDept(int departmentId){
		List<Employee> ls = webClientBuilder.build().get()
				.uri("http://localhost:8020/EMPLOYEE-SERVER/getEmployeesOfDept/"+departmentId)
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<List<Employee>>() {})
				.block();
		return ls;
	}

}
