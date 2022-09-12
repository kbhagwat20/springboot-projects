package com.mindtree.milestone3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.milestone3.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
