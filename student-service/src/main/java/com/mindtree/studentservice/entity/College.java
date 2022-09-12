package com.mindtree.studentservice.entity;

public class College {
	
	private int id;
	private String name;
	private int noOfStudents;
	public College() {
		super();
	}
	public College(int id, String name, int noOfStudents) {
		super();
		this.id = id;
		this.name = name;
		this.noOfStudents = noOfStudents;
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
	public int getNoOfStudents() {
		return noOfStudents;
	}
	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}
	
	

}
