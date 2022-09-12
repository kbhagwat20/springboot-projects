package com.mindtree.milestone3.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.milestone3.entity.Department;
import com.mindtree.milestone3.entity.Employee;
import com.mindtree.milestone3.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository repository;
	
	public void createDepartment(Department department) {
		repository.save(department);
	}
	
	public List<Department> getAllDepartments(){
		List<Department> ls = repository.findAll();
		ls.forEach((Department department) -> {
			Collections.sort(department.getEmployeeList(), (o1, o2) -> o1.getName().compareTo(o2.getName()));
		});
		return ls;
	}
		
		public List<Employee> getAllEmplForDepartment(int departmentId){
			Department dept = repository.findById(departmentId).get();
			List<Employee> employeeList = dept.getEmployeeList();
			Collections.sort(employeeList, (o1,o2) -> o2.getAge()- o1.getAge());
			return employeeList;
		}
		
		
	

}
