package com.mindtree.milestone3.entity;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="department")
public class Department {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
	private int id;
    
    @Column(name="name")
	private String departmentName;
    
    private int noOfEmployees;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "department_id")
    private List<Employee> employeeList = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getNoOfEmployees() {
		return noOfEmployees;
	}

	public void setNoOfEmployees(int noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public Department(int id, String departmentName, int noOfEmployees,
			List<com.mindtree.milestone3.entity.Employee> employeeList) {
		super();
		this.id = id;
		this.departmentName = departmentName;
		this.noOfEmployees = noOfEmployees;
		this.employeeList = employeeList;
	}

	public Department() {
		super();
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", departmentName=" + departmentName + ", noOfEmployees=" + noOfEmployees
				+ ", employeeList=" + employeeList + "]";
	}
    
    
    

}
