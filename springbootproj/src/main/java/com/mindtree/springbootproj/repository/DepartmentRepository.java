package com.mindtree.springbootproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.springbootproj.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
