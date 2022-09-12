package com.mindtree.milestone3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.milestone3.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
