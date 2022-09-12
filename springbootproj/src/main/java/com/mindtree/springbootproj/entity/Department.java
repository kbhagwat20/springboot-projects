package com.mindtree.springbootproj.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {
    
	@Id
    @Column(name="dept_id")
	private int deptId;
    
    @Column(name="department")
	private String department;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "department_id")
    private List<Employee> employeeList = new ArrayList<>();
    
	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	private int noOfEmployees;
	
	public int getDeptid() {
		return deptId;
	}
	public void setDeptid(int deptid) {
		this.deptId = deptid;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getNoOfEmployees() {
		return noOfEmployees;
	}
	public void setNoOfEmployees(int noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}
	public Department(int deptid, String department, int noOfEmployees) {
		super();
		this.deptId = deptid;
		this.department = department;
		this.noOfEmployees = noOfEmployees;
	}
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", department=" + department + ", employeeList=" + employeeList
				+ ", noOfEmployees=" + noOfEmployees + "]";
	}
	public Department() {
		super();
	}
	
	
}
