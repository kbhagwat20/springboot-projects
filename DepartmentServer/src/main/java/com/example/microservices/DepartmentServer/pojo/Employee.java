package com.example.microservices.DepartmentServer.pojo;

public class Employee {

	private int id;
	
	private String name;
	
	private int deptId;
	
	private int age;
	
	private int salary;
	
	public Employee() {
		super();
	}

	public Employee(int id, String name, int deptId, int age, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.deptId = deptId;
		this.age = age;
		this.salary = salary;
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

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}
