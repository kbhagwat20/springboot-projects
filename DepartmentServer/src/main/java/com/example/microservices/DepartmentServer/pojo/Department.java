package com.example.microservices.DepartmentServer.pojo;

import java.util.ArrayList;
import java.util.List;

import com.example.microservices.DepartmentServer.Entity.DepartmentEntity;

public class Department {
	private int id;
	
	private String name;
	
	private int noOfEmployee;
	
	List<Employee> employees = new ArrayList<Employee>();

	
	public Department() {
		super();
	}


	public Department(int id, String name, int noOfEmployee, List<Employee> employees) {
		super();
		this.id = id;
		this.name = name;
		this.noOfEmployee = noOfEmployee;
		this.employees = employees;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getNoOfEmployee() {
		return noOfEmployee;
	}


	public void setNoOfEmployee(int noOfEmployee) {
		this.noOfEmployee = noOfEmployee;
	}


	public List<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public static Department toDepartment(DepartmentEntity entity) {
		Department department = new Department();
		department.setId(entity.getId());
		department.setName(entity.getName());
		department.setNoOfEmployee(entity.getNoOfEmployee());
		return department;
	}
}
