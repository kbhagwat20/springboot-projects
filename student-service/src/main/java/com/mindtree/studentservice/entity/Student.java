package com.mindtree.studentservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	@Column(name = "roll_no")
	private int rollNo;
	
	@Column
	private String name;
	
	@Column
	private int age;
	
	@Column
	private String gender;
	
	@Column(name = "college_id")
	private int collegeId;
	
	@Column
	private String stream;

	public Student() {
		super();
	}

	public Student(int id, int rollNo, String name, int age, String gender, int collegeId, String stream) {
		super();
		this.id = id;
		this.rollNo = rollNo;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.collegeId = collegeId;
		this.stream = stream;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	
	

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", rollNo=" + rollNo + ", name=" + name + ", age=" + age + ", gender=" + gender
				+ ", collegeId=" + collegeId + ", stream=" + stream + "]";
	}

	
	

}
