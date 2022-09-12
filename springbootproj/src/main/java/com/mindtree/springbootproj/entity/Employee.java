package com.mindtree.springbootproj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="employee")
public class Employee {

	@Id
	@Column(name ="emp_id")
	private int empId;
	
	@Column(name="emp_name")
	private String name;
	
	@Column(name ="salary")
	private int salary;
	
	@Column(name="department_id")
	private int deptId;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public Employee(int empId, String name, int salary, int deptId) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.deptId = deptId;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", salary=" + salary + ", deptId=" + deptId + "]";
	}
	
	
	
}
