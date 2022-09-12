package com.mindtree.springbootproj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mindtree.springbootproj.entity.Department;
import com.mindtree.springbootproj.repository.DepartmentRepository;

@SpringBootApplication
public class SpringbootprojApplication{
	
	@Autowired
	DepartmentRepository departmentRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootprojApplication.class, args);
	}

}
