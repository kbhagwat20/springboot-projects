package com.mindtree.jpa.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mindtree.jpa.demo.entity.Employee;
import com.mindtree.jpa.demo.repository.EmployeeRepo;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
	 ApplicationContext context = 	SpringApplication.run(DemoApplication.class, args);
	 EmployeeRepo repo = context.getBean(EmployeeRepo.class);
//	 Employee empl = new Employee(2, "fdsaf", 3423);
//	 repo.save(empl);
	 
	 
	 
	List<Employee> employees = repo.findAll();
	for(Employee e: employees) {
		System.out.println(e);
	}

	}
}
