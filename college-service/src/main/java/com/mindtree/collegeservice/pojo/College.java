package com.mindtree.collegeservice.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import com.mindtree.collegeservice.entity.CollegeEntity;

public class College {
	private int id;
	
	private String name;
	
	private int noOfStudents;
	
	private List<Student> studentList = new ArrayList<>();

	public College() {
		super();
	}

	public College(int id, String name, int noOfStudents, List<Student> studentList) {
		super();
		this.id = id;
		this.name = name;
		this.noOfStudents = noOfStudents;
		this.studentList = studentList;
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

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	public static College toCollege(CollegeEntity entity) {
		College college = new College();
		college.setId(entity.getId());
		college.setName(entity.getName());
		college.setNoOfStudents(entity.getNoOfStudents());
		return college;
	}
	
	
}
